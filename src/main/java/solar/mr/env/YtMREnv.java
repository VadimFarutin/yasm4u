package solar.mr.env;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spbsu.commons.func.Action;
import com.spbsu.commons.func.Processor;
import com.spbsu.commons.random.FastRandom;
import com.spbsu.commons.seq.CharSeq;
import com.spbsu.commons.seq.CharSeqBuilder;
import com.spbsu.commons.seq.CharSeqTools;
import com.spbsu.commons.util.JSONTools;
import org.apache.log4j.Logger;
import solar.mr.*;
import solar.mr.proc.impl.MRPath;
import solar.mr.routines.MRRecord;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: solar
 * Date: 19.09.14
 * Time: 17:08
 */
public class YtMREnv extends RemoteMREnv {
  private static int MAX_ROW_WEIGTH = 128000000;
  private static Logger LOG = Logger.getLogger(YtMREnv.class);
  final static String mrUserHome = System.getProperty("mr.user.home","mobilesearch");
  public YtMREnv(final ProcessRunner runner, final String tag, final String master) {
    super(runner, tag, master);
  }

  @SuppressWarnings("UnusedDeclaration")
  public YtMREnv(final ProcessRunner runner, final String user, final String master,
                    final Action<CharSequence> errorsProc,
                    final Action<CharSequence> outputProc) {
    super(runner, user, master, errorsProc, outputProc);
  }

  protected List<String> defaultOptions() {
    final List<String> options = new ArrayList<>();
    { // access settings
      //options.add("-subkey");
      //options.add("-tableindex");
      options.add("--proxy");
      options.add(master);
    }
    return options;
  }

  public int read(MRPath shard, final Processor<MRRecord> linesProcessor) {
    final int[] recordsCount = new int[]{0};

    //if (!shard.isAvailable())
    //  return 0;

    final List<String> options = defaultOptions();
    options.add("read");
    options.add("--format");
    options.add("\"<has_subkey=true>\"yamr");
    options.add(localPath(shard));
    executeCommand(options, new MRRoutine(shard) {
      @Override
      public void process(final MRRecord arg) {
        recordsCount[0]++;
        linesProcessor.process(arg);
      }
    }, defaultErrorsProcessor, null);
    return recordsCount[0];
  }

  public void sample(MRPath table, final Processor<MRRecord> linesProcessor) {
    final List<String> options = defaultOptions();
    options.add("read");
    options.add("--format");
    options.add("\"<has_subkey=true>yamr\"");
    options.add(localPath(table) + "[:#100]");
    executeCommand(options, new MRRoutine(table) {
      @Override
      public void process(final MRRecord arg) {
        linesProcessor.process(arg);
      }
    }, defaultErrorsProcessor, null);
  }


  @Override
  public MRPath[] list(final MRPath prefix) {
    final List<String> defaultOptionsEntity = defaultOptions();

    defaultOptionsEntity.add("get");
    defaultOptionsEntity.add("--format");
    defaultOptionsEntity.add("json");

    final List<String> optionEntity = new ArrayList<>();
    optionEntity.addAll(defaultOptionsEntity);
    final String path = localPath(prefix);
    final List<MRPath> result = new ArrayList<>();
    if (!prefix.isDirectory()) { // trying an easy way first
      optionEntity.add(path);
      final ConcatAction resultProcessor = new ConcatAction();
      executeCommand(optionEntity, resultProcessor, defaultErrorsProcessor, null);

      try {
        final JsonParser parser = JSONTools.parseJSON(resultProcessor.sequence());
        extractTableFromJson(prefix, result, parser);
      } catch (IOException| ParseException e) {
        LOG.warn(e);
        return new MRPath[0];
      }
    }
    else {
      final List<String> options = defaultOptions();
      options.add("list");
      final String nodePath = path.substring(0, path.length() - 1);
      options.add(nodePath);
      //final ConcatAction builder = new ConcatAction(" ");
      executeCommand(options, new Action<CharSequence>(){
        @Override
        public void invoke(CharSequence arg) {
          result.addAll(Arrays.asList(list(new MRPath(prefix.mount, prefix.path + arg, false))));
        }
      }, defaultErrorsProcessor, null);
    }
    if (result.isEmpty()) {
      updateState(prefix, new MRTableState(prefix.path,false, false, "0", 0, 0, 0, System.currentTimeMillis()));
      return new MRPath[]{prefix};
    }
    else
      return result.toArray(new MRPath[result.size()]);
  }

  private void extractTableFromJson(final MRPath prefixPath, List<MRPath> result, JsonParser parser) throws IOException, ParseException {
    final String prefix = localPath(prefixPath);
    // TODO: cache mapper
    final ObjectMapper mapper = new ObjectMapper();

    final JsonNode metaJSON = mapper.readTree(parser);
    if (metaJSON == null) {
      return;
    }

    final JsonNode typeNode = metaJSON.get("type");
    if (typeNode != null && !typeNode.isMissingNode()) {
      final String name = metaJSON.get("key").asText(); /* it's a name in Yt */
      final String path = prefixPath.isDirectory() ? prefix : prefix + "/" + name;

      if (typeNode.textValue().equals("table")) {
        final long size = metaJSON.get("uncompressed_data_size").longValue();
        boolean sorted = metaJSON.has("sorted");
        final long recordsCount = metaJSON.has("row_count") ? metaJSON.get("row_count").longValue() : 0;
        final MRTableState sh = new MRTableState(path, true, sorted, "" + size, size, recordsCount / 10, recordsCount, /*ts*/ System.currentTimeMillis());
        final MRPath localPath = findByLocalPath(path, sorted);
        result.add(localPath);
        updateState(localPath, sh);
      }
      else if (typeNode.textValue().equals("map_node")) {
        list(new MRPath(prefixPath.mount, path, false));
      }
    }
  }

  @Override
  public void copy(final MRPath[] from, MRPath to, boolean append) {
    if (!append)
      delete(to); /* Yt requires that destination shouldn't exists */
    createTable(to);

    for (final MRPath sh : from){
      final List<String> options = defaultOptions();
      options.add("merge");
      // is sorted enough?
      //options.add("--spec '{\"combine_chunks\"=true;\"merge_by\"=[\"key\"];\"mode\"=\"sorted\"}'");
      options.add("--spec '{\"combine_chunks\"=true;}'");
      options.add("--src");
      options.add(localPath(sh));
      options.add("--dst");
      options.add("\"<append=true>\"" + localPath(to));
      //options.add("--mode sorted");
      executeMapOrReduceCommand(options, defaultOutputProcessor, defaultErrorsProcessor, null);
    }
    wipeState(to);
  }

  public void write(final MRPath shard, final Reader content) {
    final String localPath = localPath(shard);
    createTable(shard);
    final List<String> options = defaultOptions();
    options.add("write");
    options.add("--format");
    options.add("\"<has_subkey=true>yamr\"");
    options.add(localPath);
    MRTools.CounterInputStream cis = new MRTools.CounterInputStream(new LineNumberReader(content), 0, 0, 0);
    executeCommand(options, defaultOutputProcessor, defaultErrorsProcessor, cis);
    updateState(shard, MRTools.updateTableShard(localPath, false, cis));
  }

  @Override
  public void append(final MRPath shard, final Reader content) {
    final String localPath = localPath(shard);
    createTable(shard);
    final List<String> options = defaultOptions();
    options.add("write");
    options.add("--format");
    options.add("\"<has_subkey=true>yamr\"");
    options.add("\"<append=true>" + localPath + "\"");
    final MRTableState cachedState = resolve(shard, true);
    if (cachedState != null) {
      MRTools.CounterInputStream cis = new MRTools.CounterInputStream(new LineNumberReader(content), cachedState.recordsCount(), cachedState.keysCount(), cachedState.length());
      executeCommand(options, defaultOutputProcessor, defaultErrorsProcessor, cis);
      updateState(shard, MRTools.updateTableShard(localPath, false, cis));
    }
    else {
      executeCommand(options, defaultOutputProcessor, defaultErrorsProcessor, new InputStream() {
        @Override
        public int read() throws IOException {
          return content.read();
        }
      });
    }
  }

  private void createTable(final MRPath shard) {
    final MRTableState sh = resolve(shard, true);
    if (sh != null && sh.isAvailable())
      return;

    final List<String> options = defaultOptions();
    options.add("create");
    options.add("-r");
    options.add("table");
    options.add(localPath(shard));
    executeCommand(options, defaultOutputProcessor, defaultErrorsProcessor, null);
    wipeState(shard);
  }

  public void delete(final MRPath table) {
    final List<String> options = defaultOptions();
    /* if (!resolve(table, false).isAvailable())
      return; */
    options.add("remove");
    options.add("-r ");
    options.add(localPath(table));
    executeCommand(options, defaultOutputProcessor, defaultErrorsProcessor, null);
    wipeState(table);
  }

  public void sort(final MRPath table) {
    final List<String> options = defaultOptions();
    /* if (!resolve(table, false).isAvailable())
      return; */
    options.add("sort");
    options.add("--src");
    options.add(localPath(table));
    options.add("--dst");
    options.add(localPath(table));
    options.add("--sort-by key");
    options.add("--spec '{\"weight\"=5;\"sort_job_io\" = {\"table_writer\" = {\"max_row_weight\" = "
        + MAX_ROW_WEIGTH
        + "}};\"merge_job_io\" = {\"table_writer\" = {\"max_row_weight\" = "
        + MAX_ROW_WEIGTH
        + "}}}'");
    executeMapOrReduceCommand(options, defaultOutputProcessor, defaultErrorsProcessor, null);
    wipeState(table);
  }

  @Override
  public boolean execute(MRRoutineBuilder builder, final MRErrorsHandler errorsHandler, File jar)
  {
    final List<String> options = defaultOptions();
    switch (builder.getRoutineType()) {
      case REDUCE:
        options.add("reduce");
        options.add("--reduce-by key");
        //options.add("--spec '{\"weight\"=5}'");
        break;
      case MAP:
        options.add("map");
        break;
      default:
        throw new IllegalArgumentException("unsupported operation: " + builder.getRoutineType());
    }
    options.add("--spec '{\"weight\"=5;\"job_io\" = {\"table_writer\" = {\"max_row_weight\" = " + MAX_ROW_WEIGTH + "}}}'");
    options.add("--memory-limit 3000");
    options.add("--format");
    options.add("\"<has_subkey=true;enable_table_index=true>yamr\"");
    MRPath[] in = builder.input();
    MRPath[] out = builder.output();

    for(final MRPath o: out) {
      options.add("--dst");
      options.add(localPath(o));
      createTable(o); /* lazy materialization */
    }

    options.add("--local-file");
    options.add(jar.getAbsolutePath());

    options.add("'/usr/local/java8/bin/java ");
    //options.add(" -Dcom.sun.management.jmxremote.port=50042 -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false");
    //options.add("-Xint -XX:+UnlockDiagnosticVMOptions -XX:+LogVMOutput -XX:LogFile=/dev/stderr ");
    options.add("-XX:-UsePerfData -Xmx2G -Xms2G -jar ");
    options.add(jar.getName()); /* please do not append to the rest of the command */
    //options.add("| sed -ne \"/^[0-9]\\*\\$/p\" -ne \"/\\t/p\" )'");
    options.add("'");

    for(final MRPath sh : in) {
      options.add("--src");
      options.add(localPath(sh));
    }

    final MRPath errorsPath = MRPath.create("/tmp/errors-" + Integer.toHexString(new FastRandom().nextInt()));
    createTable(errorsPath);
    options.add("--dst");
    options.add(localPath(errorsPath));

    executeMapOrReduceCommand(options, defaultOutputProcessor, defaultErrorsProcessor, null);
    final int[] errorsCount = new int[]{0};
    errorsCount[0] += read(errorsPath, new ErrorsTableHandler(errorsPath, errorsHandler));
    delete(errorsPath);

    return errorsCount[0] == 0;
  }

  @Override
  protected MRPath findByLocalPath(String table, boolean sorted) {
    MRPath.Mount mnt;
    String path;
    final String homePrefix = "//home/" + mrUserHome + "/";
    if (table.startsWith(homePrefix)) {
      mnt = MRPath.Mount.HOME;
      path = table.substring(homePrefix.length());
    } else if (table.startsWith("//tmp/")) {
      mnt = MRPath.Mount.TEMP;
      path = table.substring("//tmp/".length());
    } else {
      mnt = MRPath.Mount.ROOT;
      path = table;
    }

    return new MRPath(mnt, path, sorted);
  }

  @Override
  protected String localPath(MRPath shard) {
    final StringBuilder result = new StringBuilder();
    switch (shard.mount) {
      case HOME:
        result.append("//home/").append(mrUserHome).append("/");
        break;
      case TEMP:
        result.append("//tmp/");
        break;
      case ROOT:
        result.append("//");
        break;
    }
    result.append(shard.path);
    return result.toString();
  }

  @Override
  protected boolean isFat(MRPath path) {
    return false;
  }

  @Override
  public String name() {
    return "Yt://" + master + "/";
  }

  @Override
  public String toString() {
    return "Yt://" + user + "@" + master + "/";
  }

  private void executeMapOrReduceCommand(final List<String> options, final Action<CharSequence> outputProcessor, final Action<CharSequence> errorsProcessor, final InputStream contents) {
    final YtMRResponseProcessor processor;
    if (runner instanceof SSHProcessRunner)
      super.executeCommand(options, (processor = new SshMRYtResponseProcessor(outputProcessor, errorsProcessor)), errorsProcessor, contents);
    else
      super.executeCommand(options, outputProcessor, (processor = new LocalMRYtResponseProcessor(errorsProcessor)), contents);

    if (!processor.isOk())
      throw new RuntimeException("M/R failed");
  }

  @Override
  protected void executeCommand(List<String> options, Action<CharSequence> outputProcessor,
                                Action<CharSequence> errorsProcessor, InputStream contents) {
    if (runner instanceof SSHProcessRunner)
      super.executeCommand(options, new SshYtResponseProcessor(outputProcessor, errorsProcessor), errorsProcessor, contents);
    else
      super.executeCommand(options, outputProcessor, new LocalYtResponseProcessor(errorsProcessor), contents);
  }

  private static class ConcatAction implements Action<CharSequence> {
    private final CharSeqBuilder builder;
    private final String sep;
    private boolean withSeparator;

    private ConcatAction(final String sep, boolean withSeparator) {
      this.sep = sep;
      this.withSeparator = withSeparator;
      builder = new CharSeqBuilder();
    }

    public ConcatAction() {
      this("",false);
    }

    public ConcatAction(final String sep) {
      this(sep, true);
    }

    @Override
    public void invoke(CharSequence arg) {
      builder.append(arg);
      if (withSeparator)
        builder.append(sep);
    }

    public CharSequence sequence() {
      return builder.build();
    }

    public CharSequence trimmedSequence() {
      final CharSequence seq = builder.build();
      if (seq.length() != 0)
        return CharSeqTools.trim(seq);
      else
        return seq;
    }
  }

  protected abstract static class YtResponseProcessor implements Action<CharSequence>{
    final Action<CharSequence> processor;

    public YtResponseProcessor(final Action<CharSequence> processor) {
      this.processor = processor;
    }

    @Override
    public void invoke(CharSequence arg) {
      try {
        final JsonParser parser = JSONTools.parseJSON(arg);
        final ObjectMapper mapper = new ObjectMapper();
        final JsonNode metaJSON = mapper.readTree(parser);
        /* TODO: more protective programming */
        int code = 0;
        if (!metaJSON.has("message")) {
          processor.invoke(arg);
          return;
        }

        JsonNode errors = metaJSON.get("inner_errors").get(0);
        do {
          code = errors.get("code").asInt();
          errors = errors.elements().next().get(0);
          if (errors == null)
            break;
        } while (errors.size() != 0);
        switch (code) {
          case 500:
            warn("WARNING! doesn't exists");
            break;
          case 501:
            warn("WARNING! already exists");
            break;
          case 1:
            break;
          default: {
            reportError(arg);
            throw new RuntimeException("Yt exception");
          }
        }
      } catch (JsonParseException e) {
        if (arg.charAt(4) == '-'
            && arg.charAt(11) == '-'
            && arg.charAt(19) == '-') {
          /* it's uid of new created table */
          warn("Shold looks like uuid: " + arg);
          return;
        }
        reportError("Msg: " + arg.toString() + " appears here by mistake!!!!");
        reportError(e.getMessage());
        processor.invoke(arg);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
    public abstract void reportError(final CharSequence msg);
    public abstract void warn(final String msg);
  }

  protected abstract static class YtMRResponseProcessor extends YtResponseProcessor {
    enum OperationStatus {
      NONE,
      INITIALIZING,
      PREPARING,
      COMPLETING,
      FAILED,
      COMPETED,
      PRINT_HINT
    }
    private OperationStatus status = OperationStatus.NONE;
    private CharSequence guid = null;
    private final static String TOK_OPERATION = "operation";
    private final static String TOK_OP_INITIALIZING = "initializing";
    private final static String TOK_OP_COMPLETING = "completing";
    private final static String TOK_OP_COMPLETED = "completed";
    private final static String TOK_OP_PREPARING = "preparing";
    private final static String TOK_OP_FAILED = "failed";

    private final static String TOK_HINT = "INFO";

    public YtMRResponseProcessor(final Action<CharSequence> processor) {
      super(processor);
    }

    public boolean isOk() {
      return (status == OperationStatus.COMPETED);
    }

    private CharSequence eatDate(final CharSequence arg) {
      if (CharSeqTools.isNumeric(arg.subSequence(0,3)) /* year */
          && arg.charAt(4) == '-'
          && CharSeqTools.isNumeric(arg.subSequence(5, 6)) /* month */
          && arg.charAt(7) == '-'
          && CharSeqTools.isNumeric(arg.subSequence(8,9)) /* day */)
        return arg.subSequence(10,arg.length());
      else {
        reportError(arg);
        return arg.subSequence(10,arg.length());
        //throw new RuntimeException("Expected date");
      }
    }

    private CharSequence eatTime(final CharSequence arg, char separator) {
      if (CharSeqTools.isNumeric(arg.subSequence(0,1)) /* hours */
          && arg.charAt(2) == ':'
          && CharSeqTools.isNumeric(arg.subSequence(3,4)) /* minutes */
          && arg.charAt(5) == ':'
          && CharSeqTools.isNumeric(arg.subSequence(6,7))
          && arg.charAt(8) == separator
          && CharSeqTools.isNumeric(arg.subSequence(9,11)))
        return arg.subSequence(12, arg.length());
      else {
        reportError(arg);
        //throw new RuntimeException("Expected time hh:MM:ss " + separator + " zzz");
        return arg.subSequence(12, arg.length());
      }
    }

    private CharSequence eatPeriod(final CharSequence arg) {
      int index = 3;
      if (arg.charAt(0) == '(') {
        while (CharSeqTools.isNumeric(arg.subSequence(2, index))) {
          index++;
        }
        if (CharSeqTools.equals(arg.subSequence(index, index + 4),"min)"))
          return arg.subSequence(index + 5, arg.length());
      }
      reportError(arg);
      return arg.subSequence(index + 5, arg.length());
      //throw new RuntimeException("Expected period \"( xx min)\"");
    }

    private CharSequence eatToken(final CharSequence arg, final String token) {
      if (!CharSeqTools.startsWith(arg, token)
          || CharSeqTools.isAlpha(arg.subSequence(token.length(), token.length() + 1))) {
        reportError(arg);
        //throw new RuntimeException("expected token: " + token);
        return arg.subSequence(token.length() + 1, arg.length());
      }
      return arg.subSequence(token.length() + 1, arg.length());
    }

    private CharSequence initGuid(final CharSequence arg) {
      CharSequence guid = arg.subSequence(0,35);
      if (this.guid != null && !CharSeqTools.equals(guid, this.guid)) {
        reportError(arg);
        //throw new RuntimeException("something strange with guid");
        return arg.subSequence(35, arg.length());
      }
      return arg.subSequence(35, arg.length());
    }

    private void checkOperationStatus(final CharSequence arg) {
      if (CharSeqTools.equals(arg, TOK_OP_INITIALIZING) && status == OperationStatus.NONE) {
        status = OperationStatus.INITIALIZING;
        return;
      }
      if (CharSeqTools.equals(arg, TOK_OP_COMPLETED)
          && (status == OperationStatus.INITIALIZING
          || status == OperationStatus.PREPARING
          || status == OperationStatus.PRINT_HINT
          || status == OperationStatus.NONE /* Ultra fast operation usually with empty inputs */
          || status == OperationStatus.COMPLETING)){
        status = OperationStatus.COMPETED;
        return;
      }
      if (CharSeqTools.equals(arg, TOK_OP_PREPARING)
          && (status == OperationStatus.INITIALIZING)) {
        status = OperationStatus.PREPARING;
        return;
      }
      if (CharSeqTools.equals(arg, TOK_OP_COMPLETING)
          && (status == OperationStatus.NONE
          || status == OperationStatus.INITIALIZING)) {
        status = OperationStatus.COMPLETING;
        return;
      }
      if (CharSeqTools.equals(arg, TOK_OP_FAILED)) {
        status = OperationStatus.FAILED;
        reportError("FAILED");
        return;
        //throw new RuntimeException("Operation failed");

      }
      reportError("current status: " + status);
      return;
      //throw new RuntimeException("Unknown status: " + arg);
    }

    private void hint(final CharSequence arg) {
      processor.invoke(CharSeqTools.trim(eatToken(arg, TOK_HINT)));
      status = OperationStatus.PRINT_HINT;
    }

    @Override
    public void invoke(CharSequence arg) {
      System.err.println("DEBUG:" + arg);
      switch (status) {
        case NONE:
        case INITIALIZING:
          final CharSequence raw0 = CharSeqTools.trim(eatPeriod(CharSeqTools.trim(eatTime(CharSeqTools.trim(eatDate(arg)), '.'))));
          final CharSequence raw1 = CharSeqTools.trim(eatToken(raw0, TOK_OPERATION));
          final CharSequence raw2 = CharSeqTools.trim(initGuid(raw1));
          /* we don't need the rest of the mess at runtime
           * in some cases Yt drops : before running=... failed=...
           */
          if (raw2.charAt(0) == ':' || CharSeqTools.startsWith(CharSeqTools.trim(raw2), "running="))
            return;
          checkOperationStatus(raw2);
          break;
        case COMPETED:
          hint(CharSeqTools.trim(eatTime(CharSeqTools.trim(eatDate(arg)), ',')));
          break;
        case PRINT_HINT:
          processor.invoke(arg);
          status = OperationStatus.COMPETED;
          break;
        default:
          reportError(arg);
          //throw new RuntimeException("Please add case!!!");
      }
      /* here should be hint processing */
    }
  }

  private static class LocalYtResponseProcessor extends YtResponseProcessor {
    public LocalYtResponseProcessor(Action<CharSequence> errorProcessor) {
      super(errorProcessor);
    }

    @Override
    public void reportError(final CharSequence msg) {
      processor.invoke(msg);
    }

    @Override
    public void warn(final String msg) {
      processor.invoke(msg);
    }
  }

  private static class SshYtResponseProcessor extends YtResponseProcessor {
    final Action<CharSequence> errorProcessor;
    public SshYtResponseProcessor(Action<CharSequence> processor, Action<CharSequence> errorProcessor) {
      super(processor);
      this.errorProcessor = errorProcessor;
    }

    @Override
    public void invoke(CharSequence arg) {
      if (CharSeqTools.indexOf(arg, "\t") == -1)
        super.invoke(arg);
      else
        processor.invoke(arg);
    }

    @Override
    public void reportError(final CharSequence errorMsg) {
      errorProcessor.invoke(errorMsg);
    }

    @Override
    public void warn(final String msg) {
      errorProcessor.invoke(msg);
    }
  }

  protected static class LocalMRYtResponseProcessor extends YtMRResponseProcessor{
    public LocalMRYtResponseProcessor(Action<CharSequence> processor) {
      super(processor);
    }

    @Override
    public void reportError(CharSequence msg) {
      processor.invoke(msg);
    }

    @Override
    public void warn(String msg) {
      processor.invoke(msg);
    }
  }

  protected static class SshMRYtResponseProcessor extends YtMRResponseProcessor{
    final Action<CharSequence> errorProcessor;
    public SshMRYtResponseProcessor(final Action<CharSequence> processor, final Action<CharSequence> errorProcessor) {
      super(processor);
      this.errorProcessor = errorProcessor;
    }

    @Override
    public void reportError(CharSequence msg) {
      errorProcessor.invoke(msg);
    }

    @Override
    public void warn(String msg) {
      errorProcessor.invoke(msg);
    }
  }
}

package ru.yandex.se.mobile.logprocessing.core;

import com.spbsu.commons.seq.CharSeqTools;
import com.spbsu.commons.util.Pair;
import solar.mr.MREnv;
import solar.mr.MROutput;
import solar.mr.env.ProcessRunner;
import solar.mr.env.SSHProcessRunner;
import solar.mr.env.YaMREnv;
import solar.mr.proc.State;
import solar.mr.proc.AnnotatedMRProcess;
import solar.mr.proc.Whiteboard;
import solar.mr.proc.impl.WhiteboardImpl;
import solar.mr.proc.tags.MRMapMethod;
import solar.mr.proc.tags.MRProcessClass;
import solar.mr.proc.tags.MRReduceMethod;

import java.util.Iterator;

/**
 * User: inikifor
 * Date: 05.11.14
 * Time: 15:11
 */
public final class Main {
  @SuppressWarnings("UnusedDeclaration")
  @MRProcessClass(goal = "mr:///mobilesearchtest/count_tmp")
  public static final class SampleCounter {

    private static final String TMP_TABLE_URI = "temp:mr:///test-counter";

    private final State state;

    public SampleCounter(State state) {
      this.state = state;
    }

    @MRMapMethod(input = "mr:///mobilesearchtest/20141017_655_11", output = TMP_TABLE_URI)
    public void map(final String key, final String sub, final CharSequence value, MROutput output) {
      int len = value.length();
      switch (len % 3) {
        case 0:
          output.add("% 3 = 0", "" + len, "1");
          break;
        case 1:
          output.add("% 3 = 1", "" + len, "1");
          break;
        case 2:
          output.add("% 3 = 2", "" + len, "1");
          break;
      }
    }

    @MRReduceMethod(input = TMP_TABLE_URI, output = "mr:///mobilesearchtest/count_tmp")
    public void reduce(final String key, final Iterator<Pair<String, CharSequence>> reduce, MROutput output) {
      int count = 0;
      while (reduce.hasNext()) {
        Pair<String, CharSequence> sv = reduce.next();
        count += CharSeqTools.parseInt(sv.second);
      }
      output.add(key, "1", "" + count);
    }

  }

  public static void main(String[] args) {
    System.out.println("Starting Java MR calculation!");
    final ProcessRunner runner = new SSHProcessRunner("batista", "/Berkanavt/mapreduce/bin/mapreduce-dev");
    final MREnv env = new YaMREnv(runner, "mobilesearch", "cedar:8013");
    final Whiteboard wb = new WhiteboardImpl(env, SampleCounter.class.getName());
    final AnnotatedMRProcess mrProcess = new AnnotatedMRProcess(SampleCounter.class, wb);
    mrProcess.execute();
    mrProcess.wb().wipe();
  }

}

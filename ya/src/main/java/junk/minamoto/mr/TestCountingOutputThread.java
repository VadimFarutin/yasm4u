package junk.minamoto.mr;

import com.expleague.commons.seq.CharSeqTools;
import gnu.trove.map.hash.TIntLongHashMap;

import java.io.*;
import java.util.function.Consumer;

/**
 * Created by minamoto on 18/09/15.
 */
public class TestCountingOutputThread extends Thread {
  public final PipedOutputStream out;
  private TIntLongHashMap counter;
  private final LineNumberReader numberReader;

  public TIntLongHashMap getCounter() {
    return counter;
  }

  public TestCountingOutputThread() throws IOException {
    final PipedInputStream in = new PipedInputStream();
    out = new PipedOutputStream(in);
    numberReader = new LineNumberReader(new InputStreamReader(in));

    counter = new TIntLongHashMap();
  }

  public void run() {
    try {
      CharSeqTools.processLines(numberReader, new Consumer<CharSequence>() {
        int table = 0;
        @Override
        public void accept(CharSequence arg) {
          CharSequence[] split = CharSeqTools.split(arg, '\t');
          if (split.length == 1) {
            table = Integer.decode(split[0].toString());
          } else {
            counter.adjustOrPutValue(table, 1, 1);
          }
        }
      });
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}

package solar.mr.proc.impl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


import com.spbsu.commons.io.StreamTools;
import com.spbsu.commons.seq.CharSeqTools;
import com.spbsu.commons.util.Pair;
import solar.mr.MRMap;
import solar.mr.MROutput;
import solar.mr.env.MRRunner;
import solar.mr.proc.MRState;

/**
* User: solar
* Date: 13.10.14
* Time: 10:33
*/
public class MapMethod extends MRMap {
  private final Method method;
  private final Object routineObj;

  public MapMethod(final String[] input, final MROutput output, final MRState state) {
    super(input, output, state);
    try {
      final Pair<String,String> classMethodPair = state.get(MRRunner.ROUTINES_PROPERTY_NAME);
      assert classMethodPair != null;
      final Class<?> routineClass = Class.forName(classMethodPair.getFirst());
      routineObj = routineClass.getConstructor(MRState.class).newInstance(state);
      method = routineClass.getMethod(classMethodPair.getSecond(), String.class, String.class, CharSequence.class, MROutput.class);
    } catch (ClassNotFoundException | InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void map(final String key, final String sub, final CharSequence value) {
    try {
      method.invoke(routineObj, key, sub, value, output);
    } catch (IllegalAccessException | InvocationTargetException e) {
      throw new RuntimeException(e);
    }
  }
}

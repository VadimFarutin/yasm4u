package com.expleague.yasm4u.domains.mr.routines;

import com.expleague.commons.util.ArrayTools;
import com.expleague.yasm4u.JobExecutorService;
import com.expleague.yasm4u.Joba;
import com.expleague.yasm4u.Ref;
import com.expleague.yasm4u.Routine;
import com.expleague.yasm4u.domains.mr.MREnv;
import com.expleague.yasm4u.domains.mr.MRPath;
import com.expleague.yasm4u.domains.mr.routines.ann.impl.RoutineJoba;
import gnu.trove.map.TObjectIntMap;
import gnu.trove.map.hash.TObjectIntHashMap;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: solar
 * Date: 07.11.14
 * Time: 16:39
 */
public class MergeRoutine implements Routine {
  private static final Pattern MERGE_PATTERN = Pattern.compile("^(.*)merge/([^\\/]+)/(\\d+)-(\\d+)$");

  public static List<RoutineJoba> unmergeJobs(final List<RoutineJoba> jobs) {
    final TObjectIntMap<Ref> sharded = new TObjectIntHashMap<>();
    for (final Joba joba : jobs) {
      for (final Ref resource : joba.produces()) {
        sharded.adjustOrPutValue(resource, 1, 1);
      }
    }

    final List<RoutineJoba> result = new ArrayList<>();

    final TObjectIntMap<MRPath> shardsCount = new TObjectIntHashMap<>();
    for (final RoutineJoba joba : jobs) {
      final MRPath[] outputs = new MRPath[joba.produces().length];
      for(int i = 0; i < outputs.length; i++) {
        Ref ref = joba.produces()[i];
        if (!(ref instanceof MRPath))
          continue;
        final MRPath resourceName = (MRPath) ref;
        if (sharded.get(resourceName) > 1) {
          final MRPath shard = new MRPath(MRPath.Mount.TEMP, resourceName.path + "merge/" + resourceName.mount + "/" + sharded.get(resourceName) + "-" + shardsCount.get(resourceName), false);
          outputs[i] = shard;
          shardsCount.adjustOrPutValue(resourceName, 1, 1);
        }
        else outputs[i] = resourceName;
      }
      if (!Arrays.equals(outputs, joba.produces())) {
        //noinspection unchecked
        result.add(new RoutineJoba(joba.controller, joba.input, outputs, joba.method, joba.type));
      }
      else result.add(joba);
    }
    return result;
  }

  @Override
  public Joba[] buildVariants(Ref[] state, final JobExecutorService executor) {
    final Map<MRPath, MRPath[]> shardsMap = new HashMap<>();
    for(int i = 0; i < state.length; i++) {
      Ref stateRef = state[i];
      if (stateRef == null)
        System.out.println();
      if (MRPath.class.isAssignableFrom(stateRef.type())) {
        final MRPath ref = (MRPath)executor.resolve(stateRef);
        if (ref.mount == MRPath.Mount.TEMP) {
          final Matcher matcher = MERGE_PATTERN.matcher(ref.path);
          if (matcher.find()) {
            final MRPath resource = new MRPath(MRPath.Mount.valueOf(matcher.group(2)), matcher.group(1), false);
            MRPath[] shards = shardsMap.get(resource);
            if (shards == null) {
              shardsMap.put(resource, shards = new MRPath[Integer.parseInt(matcher.group(3))]);
            }
            shards[Integer.parseInt(matcher.group(4))] = ref.mkunsorted();
          }
        }
      }
    }
    final List<Joba> variants = new ArrayList<>();
    for (final Map.Entry<MRPath, MRPath[]> entry : shardsMap.entrySet()) {
      final MRPath[] shards = entry.getValue();
      if (ArrayTools.indexOf(null, shards) >= 0)
        continue;
      final MRPath resource = entry.getKey();
      variants.add(new Joba.Stub(shards, new MRPath[]{resource}) {
        @Override
        public void run() {
          executor.domain(MREnv.class).copy((MRPath[]) consumes(), resource, false);
        }
        public String toString() {
          return "Merge " + Arrays.toString(consumes()) + " -> " + resource;
        }
      });
    }
    return variants.toArray(new Joba[variants.size()]);
  }
}

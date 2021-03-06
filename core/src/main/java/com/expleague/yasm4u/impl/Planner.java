package com.expleague.yasm4u.impl;

import com.expleague.commons.func.Evaluator;
import com.expleague.commons.util.ArrayTools;
import com.expleague.yasm4u.JobExecutorService;
import com.expleague.yasm4u.Joba;
import com.expleague.yasm4u.Ref;
import com.expleague.yasm4u.Routine;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Predicate;

/**
 * User: solar
 * Date: 17.03.15
 * Time: 16:53
 */
public class Planner {
  private final Ref[] initial;
  private final Routine[] routines;
  private final Joba[] jobs;

  private final Evaluator<Joba> estimator = joba -> 1.;

  public Planner(Ref[] initial, Routine[] routines, Joba[] jobs) {
    this.initial = initial;
    this.routines = routines;
    this.jobs = jobs;
  }

  @NotNull
  public Joba[] build(JobExecutorService jes, Ref... goals) {
    final Set<Ref> initialState;
    { // initialize universe and starting state
      final Set<Ref> consumes = new HashSet<>();
      final Set<Ref> produces = new HashSet<>();
      final Set<Ref> possibleResources = new HashSet<>(Arrays.asList(initial));
      for (final Joba job : jobs) {
        consumes.addAll(Arrays.asList(job.consumes()));
        produces.addAll(Arrays.asList(job.produces()));
        possibleResources.addAll(Arrays.asList(job.consumes()));
      }

      int possibleResourcesSize;
      do { // making closure
        possibleResourcesSize = possibleResources.size();
        for (Routine routine : routines) {
          for (final Joba job : routine.buildVariants(possibleResources.toArray(new Ref[possibleResourcesSize]), jes)) {
            consumes.addAll(Arrays.asList(job.consumes()));
            produces.addAll(Arrays.asList(job.produces()));
            possibleResources.addAll(Arrays.asList(job.consumes()));
          }
        }
      }
      while (possibleResourcesSize != possibleResources.size());

      consumes.removeAll(produces);
      final Set<Joba> possibleJobas = new HashSet<>();
      possibleResources.clear();

      while (true) {
        final Iterator<Ref> it = consumes.iterator();
        Set<Ref> next = new HashSet<>(consumes);
        while (it.hasNext()) {
          final Ref res = it.next();
          next.remove(res);
          if (!forwardPath(jes, next, possibleJobas, possibleResources, res)) {
            forwardPath(jes, next, possibleJobas, possibleResources, res);
            next.add(res);
          }
        }
        if (consumes.equals(next)) {
          break;
        }
      }

      initialState = new HashSet<>(Arrays.asList(initial));
      initialState.addAll(consumes);
    }


    final Set<Joba> possibleJobas = new HashSet<>();
    final Set<Ref> possibleResources = new HashSet<>();

    final Set<Ref> goalsSet = new HashSet<>(Arrays.asList(goals));
    if (!forwardPath(jes, initialState, possibleJobas, possibleResources, goalsSet.toArray(new Ref[goalsSet.size()]))) {
      goalsSet.removeAll(possibleResources);
      initialState.addAll(goalsSet);
//      throw new IllegalArgumentException("Unable to create plan : " + Arrays.toString(goalsSet.toArray()) + " unreachable");
    }
    possibleResources.clear();
    possibleResources.addAll(goalsSet);
    final Set<Joba> neededJobas = new HashSet<>();
    int currentPower;
    do {
      currentPower = possibleResources.size();
      for (Joba joba : possibleJobas) {
        boolean needed = false;
        for (Ref ref : joba.produces()) {
          needed |= possibleResources.contains(ref);
        }
        if (needed) {
          possibleResources.addAll(Arrays.asList(joba.consumes()));
          neededJobas.add(joba);
        }
      }
    }
    while (currentPower < possibleResources.size());
    final List<Joba> best = backwardPath(goals, neededJobas, initialState);
    return best.toArray(new Joba[best.size()]);
  }

  private List<Joba> backwardPath(Ref[] goals, Set<Joba> possibleJobas, Set<Ref> initialState) {
    final Map<Set<Ref>, PossibleState> states = new HashMap<>();
    final TreeSet<Set<Ref>> order = new TreeSet<>((o1, o2) -> {
      final int cmp1 = Double.compare(states.get(o1).weight, states.get(o2).weight);
      if (cmp1 == 0) {
        final int cmp2 = Integer.compare(o1.hashCode(), o2.hashCode());
        return cmp2 == 0 && !o1.equals(o2)? 1 : cmp2;
      }
      return cmp1;
    });

    final Set<Ref> goalsSet = new HashSet<>(Arrays.asList(goals));
    states.put(goalsSet, new PossibleState(new ArrayList<>(), possibleJobas, initialState, 0.));
    order.add(goalsSet);

    PossibleState best = null;
    double bestScore = Double.POSITIVE_INFINITY;
    while (!order.isEmpty()) {
      final Set<Ref> current = order.pollFirst();
      final PossibleState currentState = states.get(current);
      if (bestScore <= currentState.weight)
        continue;
      if (current == null || initialState.containsAll(current)) {
        bestScore = currentState.weight;
        best = currentState;
        continue;
      }
      final Set<Joba> jobs = new HashSet<>(currentState.possibleJobas);
      {
        final Set<Joba> randomOrderTasks = new HashSet<>();
        { // Filter impossible, we don't need produced resources yet or producing something that is needed by other tasks
          final Set<Ref> consumedResources = new HashSet<>();
          for (final Joba job : jobs) {
            consumedResources.addAll(Arrays.asList(job.consumes()));
          }
          final Iterator<Joba> jobIt = jobs.iterator();
          while (jobIt.hasNext()) {
            final Ref[] produces = jobIt.next().produces();
            boolean needed = false;
            for (Ref produce : produces) {
              if (consumedResources.contains(produce)) {
                jobIt.remove();
                needed = true; // to preserve double remove
                break;
              }
              needed |= current.contains(produce);
            }
            if (!needed)
              jobIt.remove();
          }
        }

        final Set<Ref> produced = new HashSet<>();
        do {
          produced.clear();
          randomOrderTasks.clear();
          for (final Joba next : jobs) {
            final Predicate<Ref> blockedFilter = produced::contains;

            if (!ArrayTools.or(next.produces(), blockedFilter)) {
              randomOrderTasks.add(next);
              produced.addAll(Arrays.asList(next.produces()));
            }
          }
          final Set<Ref> next = new HashSet<>(current);
          PossibleState nextState = currentState;
          for (final Joba job : randomOrderTasks) {
            next.addAll(Arrays.asList(job.consumes()));
            next.removeAll(Arrays.asList(job.produces()));
            nextState = nextState.next(job);
            jobs.remove(job);
          }
          final PossibleState knownState = states.get(next);
          if (knownState == null || knownState.weight > nextState.weight) {
            states.put(next, nextState);
            order.remove(next);
            order.add(next);
          }
        }
        while(!randomOrderTasks.isEmpty());
      }
    }
    if (best == null)
      throw new RuntimeException("Unable to create feasible plan! This should not happen.");
    Collections.reverse(best.plan);
    return best.plan;
  }

  private boolean forwardPath(JobExecutorService jes, Set<Ref> initialState, Set<Joba> possibleJobas, Set<Ref> possibleResources, Ref... goals) {
    possibleJobas.clear();
    possibleResources.clear();
    possibleJobas.addAll(Arrays.asList(jobs));
    possibleResources.addAll(initialState);
    final Set<Ref> goalsSet = new HashSet<>(Arrays.asList(goals));
    final List<Joba> jobs = new ArrayList<>(Arrays.asList(this.jobs));
    while(!possibleResources.containsAll(goalsSet)) {
      final Ref[] state = possibleResources.toArray(new Ref[possibleResources.size()]);
      for (final Routine routine : this.routines) {
        final List<Joba> routineGenerated = Arrays.asList(routine.buildVariants(state, jes));
        jobs.addAll(routineGenerated);
      }
      final Iterator<Joba> jobsIt = jobs.iterator();
      while (jobsIt.hasNext()) {
        final Joba joba = jobsIt.next();
        if (possibleResources.containsAll(Arrays.asList(joba.consumes()))) {
          possibleResources.addAll(Arrays.asList(joba.produces()));
          possibleJobas.add(joba);
          jobsIt.remove();
        }
      }
      if (possibleResources.size() == state.length && !possibleResources.containsAll(goalsSet)) {
        goalsSet.removeAll(possibleResources);
        return false;
      }
    }
    return true;
  }

  private class PossibleState {
    public final List<Joba> plan;
    public final Set<Joba> possibleJobas;
    public final Set<Ref> produced;
    public double weight = 0;

    private PossibleState(List<Joba> plan, Set<Joba> possibleJobas, Set<Ref> produced, double weight) {
      this.plan = plan;
      this.possibleJobas = possibleJobas;
      this.produced = produced;
      this.weight = weight;
    }

    public PossibleState next(Joba job) {
      final List<Joba> nextPlan = new ArrayList<>(plan);
      final Set<Joba> nextPossible = new HashSet<>(possibleJobas);
      final Set<Ref> nextProduced = new HashSet<>(produced);
      nextPlan.add(job);
      nextProduced.addAll(Arrays.asList(job.produces()));
      nextPossible.removeIf(candidate -> nextProduced.containsAll(Arrays.asList(candidate.produces())));
      return new PossibleState(nextPlan, nextPossible, nextProduced, weight + estimator.value(job));
    }
  }
}

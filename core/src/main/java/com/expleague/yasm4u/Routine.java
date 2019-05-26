package com.expleague.yasm4u;

/**
 * User: solar
 * Date: 21.01.15
 * Time: 13:54
 */
public interface Routine {
  Joba[] buildVariants(Ref[] state, JobExecutorService executor);
  Joba[] buildVariantsFor(Ref[] goals, JobExecutorService executor);
}

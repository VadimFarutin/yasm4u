package com.expleague.yasm4u.domains.mr.routines.ann.tags;

import java.lang.annotation.*;

/**
 * User: solar
 * Date: 12.10.14
 * Time: 11:29
 */

@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MRReduceMethod {
  String[] input();
  String[] output();
}

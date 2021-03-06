package com.expleague.yasm4u.domains.mr;

import com.expleague.yasm4u.domains.mr.ops.MRRecord;

/**
 * User: solar
 * Date: 23.09.14
 * Time: 11:09
 */
public interface MRErrorsHandler {
  void error(String type, String cause, MRRecord record);
  void error(Throwable th, MRRecord record);
  int errorsCount();
}

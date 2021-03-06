package com.expleague.lyadzhin.report.http;


import com.expleague.commons.seq.CharSeqBuilder;
import com.expleague.yasm4u.domains.wb.StateRef;

/**
* User: lyadzhin
* Date: 08.04.15 19:13
*/
public class BodyPartRef extends StateRef<CharSeqBuilder> {
  public final int partsCount;
  public final int partNum;

  public BodyPartRef(int partsCount, int partNum) {
    super("body_part_ref_" + partNum, CharSeqBuilder.class);
    this.partsCount = partsCount;
    this.partNum = partNum;
  }
}

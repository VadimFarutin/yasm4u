package com.expleague.yasm4u.domains.sql;

import com.expleague.yasm4u.Restriction;

public class SQLRestriction implements Restriction {
    @Override
    public boolean satisfy(Restriction other) {
        return false;
    }

    public SQLRestriction applySelect() {
        return this;
    }

    public SQLRestriction applyWhere() {
        return this;
    }
}

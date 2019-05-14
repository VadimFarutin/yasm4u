package com.expleague.yasm4u.domains.sql;

import com.expleague.yasm4u.Restriction;

import java.util.Set;

public class SQLRestriction implements Restriction {
    private Set<String> columnNames;

    public SQLRestriction(Set<String> columnNames) {
        this.columnNames = columnNames;
    }

    @Override
    public boolean satisfy(Restriction other) {
        return false;
    }

    public Set<String> getColumnNames() {
        return columnNames;
    }

    public SQLRestriction selectColumns(Set<String> columnNames) {
        // select predicates
        return new SQLRestriction(columnNames);
    }

    public SQLRestriction filter() {
        return this;
    }
}

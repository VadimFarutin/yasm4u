package com.expleague.yasm4u.domains.sql;

import com.expleague.yasm4u.Restriction;

import java.util.Set;
import java.util.TreeSet;

public class SQLRestriction implements Restriction {
    private Set<String> columnNames;

    public SQLRestriction(Set<String> columnNames) {
        this.columnNames = new TreeSet<>(columnNames);
    }

    @Override
    public boolean satisfy(Restriction other) {
        return true;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SQLRestriction)) return false;
        SQLRestriction other = (SQLRestriction) o;

        return columnNames.equals(other.columnNames);
    }

    @Override
    public int hashCode() {
        int result = columnNames.hashCode();
        return result;
    }
}

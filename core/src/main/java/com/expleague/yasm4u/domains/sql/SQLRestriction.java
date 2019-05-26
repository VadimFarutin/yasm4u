package com.expleague.yasm4u.domains.sql;

import com.expleague.yasm4u.Restriction;

import java.util.*;

public class SQLRestriction implements Restriction {
    private SortedSet<String> columnNames;
    private Map<String, List<String>> predicateMap;

    public SQLRestriction(Set<String> columnNames) {
        this.columnNames = new TreeSet<>(columnNames);
        this.predicateMap = new TreeMap<>();
    }

    public SQLRestriction(Set<String> columnNames,
                          Map<String, List<String>> columnPredicates) {
        this.columnNames = new TreeSet<>(columnNames);
        this.predicateMap = new TreeMap<>(columnPredicates);
    }

    @Override
    public boolean satisfy(Restriction other) {
        return true;
    }

    public SortedSet<String> getColumnNames() {
        return new TreeSet<>(columnNames);
    }

    public Map<String, List<String>> getPredicates() {
        return new HashMap<>(predicateMap);
    }

    public SQLRestriction selectColumns(Set<String> columnNames) {
        Map<String, List<String>> columnPredicates = new HashMap<>();

        for (String columnName : columnNames) {
            if (predicateMap.containsKey(columnName)) {
                columnPredicates.put(columnName, predicateMap.get(columnName));
            }
        }

        return new SQLRestriction(columnNames, columnPredicates);
    }

    public SQLRestriction crossJoin(SQLRestriction other) {
        Set<String> joinColumnNames = new HashSet<>(this.columnNames);
        joinColumnNames.addAll(other.columnNames);

        Map<String, List<String>> joinPredicates = new HashMap<>(this.predicateMap);
        joinPredicates.putAll(other.predicateMap);

        return new SQLRestriction(joinColumnNames, joinPredicates);
    }

    public SQLRestriction naturalJoin(SQLRestriction other) {
        Set<String> joinColumnNames = new HashSet<>(this.columnNames);
        joinColumnNames.addAll(other.columnNames);

        Map<String, List<String>> joinPredicates = new HashMap<>(this.predicateMap);

        for (String columnName : other.predicateMap.keySet()) {
            joinPredicates.merge(columnName,
                                 other.predicateMap.get(columnName),
                                 (l1, l2) -> {
                                     l1.addAll(l2);
                                     return l1;
                                 });
        }

        return new SQLRestriction(joinColumnNames, joinPredicates);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SQLRestriction)) return false;
        SQLRestriction other = (SQLRestriction) o;

        return columnNames.equals(other.columnNames) && predicateMap.equals(other.predicateMap);
    }

    @Override
    public int hashCode() {
        int result = columnNames.hashCode();
        result = 31 * result + predicateMap.hashCode();
        return result;
    }
}

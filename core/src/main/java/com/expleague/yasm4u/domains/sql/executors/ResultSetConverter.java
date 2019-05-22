package com.expleague.yasm4u.domains.sql.executors;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

public class ResultSetConverter {
    public static String convert(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        SortedSet<String> columnNames = new TreeSet<>();
        StringJoiner tableJoiner = new StringJoiner(System.lineSeparator());
        StringJoiner rowJoiner = new StringJoiner(" ");

        for (int i = 1; i <= columnCount; i++) {
            columnNames.add(metaData.getColumnName(i));
        }

        for (String columnName : columnNames) {
            rowJoiner.add(columnName);
        }

        tableJoiner.add(rowJoiner.toString());

        while (resultSet.next()) {
            rowJoiner = new StringJoiner(" ");

            for (String columnName : columnNames) {
                rowJoiner.add(resultSet.getString(columnName));
            }

            tableJoiner.add(rowJoiner.toString());
        }

        return tableJoiner.toString();
    }
}

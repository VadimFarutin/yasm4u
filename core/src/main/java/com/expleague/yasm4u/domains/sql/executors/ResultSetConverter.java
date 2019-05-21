package com.expleague.yasm4u.domains.sql.executors;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.StringJoiner;

public class ResultSetConverter {
    public static String convert(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        StringJoiner tableJoiner = new StringJoiner(System.lineSeparator());
        StringJoiner rowJoiner = new StringJoiner(" ");

        for (int i = 1; i <= columnCount; i++) {
            rowJoiner.add(metaData.getColumnName(i));
        }

        tableJoiner.add(rowJoiner.toString());

        while (resultSet.next()) {
            rowJoiner = new StringJoiner(" ");

            for (int i = 1; i <= columnCount; i++) {
                rowJoiner.add(resultSet.getString(i));
            }

            tableJoiner.add(rowJoiner.toString());
        }

        return tableJoiner.toString();
    }
}

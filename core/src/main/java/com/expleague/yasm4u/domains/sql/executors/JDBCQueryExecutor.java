package com.expleague.yasm4u.domains.sql.executors;

import com.expleague.yasm4u.domains.sql.SQLConfig;
import com.expleague.yasm4u.domains.sql.SQLQueryExecutor;
import com.expleague.yasm4u.domains.sql.exceptions.SQLConnectionException;
import com.expleague.yasm4u.domains.sql.exceptions.SQLDriverNotFoundException;

import java.sql.*;

public class JDBCQueryExecutor implements SQLQueryExecutor {
    private SQLConfig config;

    public JDBCQueryExecutor(SQLConfig config) throws SQLDriverNotFoundException {
        this.config = config;

        try {
            Class.forName(config.getDriver());
        } catch (ClassNotFoundException e) {
            throw new SQLDriverNotFoundException();
        }
    }

    @Override
    public String process(String query) throws SQLConnectionException {
        String result;

        try (Connection conn = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            result = rs.toString();
        } catch(SQLException se) {
            throw new SQLConnectionException();
        }

        return result;
    }
}

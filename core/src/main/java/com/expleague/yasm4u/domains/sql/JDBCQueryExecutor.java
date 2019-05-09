package com.expleague.yasm4u.domains.sql;

import java.sql.*;

public class JDBCQueryExecutor implements SQLQueryExecutor {
    private SQLConfig config;

    public JDBCQueryExecutor(SQLConfig config) {
        this.config = config;
    }

    @Override
    public String process(String query) {
        Connection conn = null;
        Statement stmt = null;
        String result = null;

        try{
            Class.forName(config.getDriver());

            conn = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            result = rs.toString();

            rs.close();
            stmt.close();
            conn.close();
        } catch(SQLException se) {
            se.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException ignored) {
            }

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        return result;
    }
}

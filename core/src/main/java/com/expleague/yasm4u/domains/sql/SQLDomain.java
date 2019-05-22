package com.expleague.yasm4u.domains.sql;

import com.expleague.yasm4u.Domain;
import com.expleague.yasm4u.Joba;
import com.expleague.yasm4u.Ref;
import com.expleague.yasm4u.Routine;
import com.expleague.yasm4u.domains.sql.exceptions.SQLConnectionException;
import com.expleague.yasm4u.domains.sql.exceptions.SQLDriverNotFoundException;
import com.expleague.yasm4u.domains.sql.executors.ResultSetConverter;
import com.expleague.yasm4u.domains.sql.routines.SQLCrossJoinRoutine;
import com.expleague.yasm4u.domains.sql.routines.SQLSelectRoutine;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;

public class SQLDomain implements Domain {
    private SQLConfig config;
    private SQLQueryParser parser;

    public SQLDomain(SQLConfig config, SQLQueryParser parser) throws SQLDriverNotFoundException {
        try {
            Class.forName(config.getDriver());
        } catch (ClassNotFoundException e) {
            throw new SQLDriverNotFoundException();
        }

        this.config = config;
        this.parser = parser;
        this.parser.setDomain(this);
    }

    @Override
    public void publishExecutables(List<Joba> jobs, List<Routine> routines) {
        routines.add(new SQLSelectRoutine());
        routines.add(new SQLCrossJoinRoutine());
    }

    @Override
    public void publishReferenceParsers(Ref.Parser parser, Controller controller) {
//        parser.registerProtocol("sql", from -> SQLRef.createFromURI("sql:" + from, this.parser));
        parser.registerProtocol("sql", from -> SQLRef.create(from.replace("%20", " "), this.parser));
    }

    public Set<SQLRef> parseSources(String query) throws SQLConnectionException {
        return parser.parseSources(query);
    }

    public List<String> getColumnNames(String tableName) throws SQLConnectionException {
        try (Connection connection = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword())) {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet columns = metaData.getColumns(null, null, tableName, null);
            List<String> columnNames = new ArrayList<>();

            while (columns.next()) {
                columnNames.add(columns.getString("COLUMN_NAME"));
            }

            return columnNames;
        } catch (SQLException e) {
            throw new SQLConnectionException();
        }
    }

    public boolean available(SQLRef ref) {
        try (Connection connection = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword())) {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet tables = metaData.getTables(null, null, ref.getTable(), null);
            return tables.next();
        } catch (SQLException e) {
            return false;
        }
    }

    public void select(String fromTable, String toTable, Set<String> columns) throws SQLConnectionException {
        try (Connection connection = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword())) {
            StringJoiner joiner = new StringJoiner(", ");
            for (String column : columns) {
                joiner.add(column);
            }

            StringBuilder builder = new StringBuilder();
            builder.append("CREATE TABLE ")
                    .append(toTable)
                    .append(" (")
                    .append(joiner.toString())
                    .append(") AS (SELECT ")
                    .append(joiner.toString())
                    .append(" FROM ")
                    .append(fromTable)
                    .append(") WITH DATA")
                    .append(";");

            Statement statement = connection.createStatement();
            statement.executeUpdate(builder.toString());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLConnectionException();
        }
    }

    public void crossJoin(String fromTableFirst, String fromTableSecond, String toTable, Set<String> columns) throws SQLConnectionException {
        try (Connection connection = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword())) {
            StringJoiner joiner = new StringJoiner(", ");
            for (String column : columns) {
                joiner.add(column);
            }

            StringBuilder builder = new StringBuilder();
            builder.append("CREATE TABLE ")
                    .append(toTable)
                    .append(" (")
                    .append(joiner.toString())
                    .append(") AS (SELECT ")
                    .append(joiner.toString())
                    .append(" FROM ")
                    .append(fromTableFirst)
                    .append(", ")
                    .append(fromTableSecond)
                    .append(") WITH DATA")
                    .append(";");

            Statement statement = connection.createStatement();
            statement.executeUpdate(builder.toString());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLConnectionException();
        }
    }

    public String getContent(SQLRef ref) throws SQLConnectionException {
        try (Connection connection = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword())) {
            StringBuilder builder = new StringBuilder();
            builder.append("SELECT * ")
                    .append("FROM ")
                    .append(ref.getTable())
                    .append(";");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(builder.toString());
            return ResultSetConverter.convert(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLConnectionException();
        }
    }
}

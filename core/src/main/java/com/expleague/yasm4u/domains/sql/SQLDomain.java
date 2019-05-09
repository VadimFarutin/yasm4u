package com.expleague.yasm4u.domains.sql;

import com.expleague.yasm4u.Domain;
import com.expleague.yasm4u.Joba;
import com.expleague.yasm4u.Ref;
import com.expleague.yasm4u.Routine;
import com.expleague.yasm4u.domains.sql.routines.SQLSelectRoutine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public class SQLDomain implements Domain {
    private Connection connection = null;

    public SQLDomain(SQLConfig config) {
        try {
            Class.forName(config.getDriver());
            connection = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            // getConnection
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ignored) {
                }
            }
        }
    }

    @Override
    public void publishExecutables(List<Joba> jobs, List<Routine> routines) {
        routines.add(new SQLSelectRoutine());
    }

    @Override
    public void publishReferenceParsers(Ref.Parser parser, Controller controller) {
        parser.registerProtocol("sql", from -> SQLRef.createFromURI("sql:" + from));
    }

    public Set<Ref> parseSources(String query) {
        return null;
    }

    public boolean available(SQLRef ref) {
        return true;
    }
}

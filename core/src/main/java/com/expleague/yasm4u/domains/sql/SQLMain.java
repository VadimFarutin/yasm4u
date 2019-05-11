package com.expleague.yasm4u.domains.sql;

import com.expleague.yasm4u.domains.sql.exceptions.SQLDriverNotFoundException;
import com.expleague.yasm4u.domains.sql.executors.SQLRestrictionBasedQueryExecutor;

import java.util.Scanner;

public class SQLMain {
    public static void main(String[] args) {
        if (args.length != 4) {
            System.err.println(
                    "Expected arguments: <driver> <url> <username> <password>");
            System.exit(1);
        }

        String driver = args[0];
        String url = args[1];
        String username = args[2];
        String password = args[3];
        SQLConfig config = new SQLConfig(driver, url, username, password);

        try {
            SQLQueryExecutor executor = new SQLRestrictionBasedQueryExecutor(config);

            Scanner scanner = new Scanner(System.in);
            String query = scanner.next();

            String result = executor.process(query);
            System.out.println(result);
        } catch (SQLDriverNotFoundException e) {
            System.err.println("Driver not found");
            System.exit(1);
        }
    }
}

package com.expleague.yasm4u.domains.sql;

import com.expleague.yasm4u.domains.sql.exceptions.SQLConnectionException;
import com.expleague.yasm4u.domains.sql.exceptions.SQLJobaExecutionException;

public interface SQLQueryExecutor {
    String process(String query) throws SQLConnectionException, SQLJobaExecutionException;
}

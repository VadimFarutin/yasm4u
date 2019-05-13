package com.expleague.yasm4u.domains.sql;

import com.expleague.yasm4u.domains.sql.exceptions.SQLConnectionException;

public interface SQLQueryExecutor {
    String process(String query) throws SQLConnectionException;
}

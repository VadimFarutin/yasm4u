package com.expleague.yasm4u.domains.sql;

import com.expleague.yasm4u.domains.sql.exceptions.SQLConnectionException;

import java.util.Set;

public interface SQLQueryParser {
    void setDomain(SQLDomain domain);
    SQLRestriction parse(String query);
    Set<SQLRef> parseSources(String query) throws SQLConnectionException;
}

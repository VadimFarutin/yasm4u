package com.expleague.yasm4u.domains.sql;

import java.util.Set;

public interface SQLParser {
    void setDomain(SQLDomain domain);
    SQLRestriction parse(String query);
    Set<SQLRestriction> parseSources(String query);
}

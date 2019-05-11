package com.expleague.yasm4u.domains.sql.parser;

import com.expleague.yasm4u.domains.sql.SQLDomain;
import com.expleague.yasm4u.domains.sql.SQLParser;
import com.expleague.yasm4u.domains.sql.SQLRestriction;

import java.util.Set;

public class SQLAntlrParser implements SQLParser {
    private SQLDomain domain = null;

    @Override
    public void setDomain(SQLDomain domain) {
        this.domain = domain;
    }

    @Override
    public SQLRestriction parse(String query) {
        return null;
    }

    @Override
    public Set<SQLRestriction> parseSources(String query) {
        return null;
    }
}

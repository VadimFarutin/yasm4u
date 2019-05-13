package com.expleague.yasm4u.domains.sql.executors;

import com.expleague.yasm4u.JobExecutorService;
import com.expleague.yasm4u.Ref;
import com.expleague.yasm4u.domains.sql.*;
import com.expleague.yasm4u.domains.sql.exceptions.SQLConnectionException;
import com.expleague.yasm4u.domains.sql.exceptions.SQLDriverNotFoundException;
import com.expleague.yasm4u.domains.sql.parser.SQLAntlrQueryParser;
import com.expleague.yasm4u.impl.MainThreadJES;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class SQLRestrictionBasedQueryExecutor implements SQLQueryExecutor {
    private SQLDomain domain;
    private JobExecutorService jes;

    public SQLRestrictionBasedQueryExecutor(SQLConfig config) throws SQLDriverNotFoundException {
        SQLQueryParser parser = new SQLAntlrQueryParser();
        domain = new SQLDomain(config, parser);
        jes = new MainThreadJES(domain);
    }

    @Override
    public String process(String query) throws SQLConnectionException {
        Set<Ref> from = domain.parseSources(query);
        SQLRef goal = jes.parse(query);

        Future<List<?>> resultFuture = jes.calculate(from, goal);

        try {
            List<SQLRef> result = (List<SQLRef>) resultFuture.get();
            // print output
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }
}

package com.expleague.yasm4u.domains.sql.executors;

import com.expleague.yasm4u.JobExecutorService;
import com.expleague.yasm4u.Ref;
import com.expleague.yasm4u.domains.sql.*;
import com.expleague.yasm4u.domains.sql.exceptions.SQLConnectionException;
import com.expleague.yasm4u.domains.sql.exceptions.SQLDriverNotFoundException;
import com.expleague.yasm4u.domains.sql.exceptions.SQLJobaExecutionException;
import com.expleague.yasm4u.domains.sql.parser.SQLAntlrQueryParser;
import com.expleague.yasm4u.impl.MainThreadJES;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class SQLRestrictionBasedQueryExecutor implements SQLQueryExecutor {
    private SQLDomain domain;
    private JobExecutorService jes;

    public SQLRestrictionBasedQueryExecutor(SQLConfig config) throws SQLDriverNotFoundException {
        SQLQueryParser parser = new SQLAntlrQueryParser();
        domain = new SQLDomain(config, parser);
        jes = new MainThreadJES(domain);
    }

    @Override
    public String process(String query) throws SQLConnectionException, SQLJobaExecutionException {
        Set<SQLRef> fromSql = domain.parseSources(query);
        Set<Ref> from = fromSql.stream().map(r -> (Ref) r).collect(Collectors.toSet());
        SQLRef goal = jes.parse("sql:" + query.replace(" ", "%20"));
        Future<List<?>> resultFuture = jes.calculate(from, goal);

        try {
            List<SQLRef> result = (List<SQLRef>) resultFuture.get();
            return domain.getContent(result.get(0));
        } catch (InterruptedException | ExecutionException e) {
            throw new SQLJobaExecutionException();
        }
    }
}

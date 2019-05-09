package com.expleague.yasm4u.domains.sql;

import com.expleague.yasm4u.JobExecutorService;
import com.expleague.yasm4u.Ref;
import com.expleague.yasm4u.impl.MainThreadJES;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class SQLRestrictionBasedQueryExecutor implements SQLQueryExecutor {
    private SQLDomain domain;
    private JobExecutorService jes;

    public SQLRestrictionBasedQueryExecutor(SQLConfig config) {
        domain = new SQLDomain(config);
        jes = new MainThreadJES(domain);
    }

    @Override
    public String process(String query) {
        Set<Ref> from = domain.parseSources(query);
        SQLRef goal = jes.parse(query);

        // add routines
        // jes.addRoutine();

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

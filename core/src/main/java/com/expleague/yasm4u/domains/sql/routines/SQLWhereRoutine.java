package com.expleague.yasm4u.domains.sql.routines;

import com.expleague.yasm4u.JobExecutorService;
import com.expleague.yasm4u.Joba;
import com.expleague.yasm4u.Ref;
import com.expleague.yasm4u.Routine;
import com.expleague.yasm4u.domains.sql.SQLDomain;
import com.expleague.yasm4u.domains.sql.SQLRef;
import com.expleague.yasm4u.domains.sql.SQLRestriction;
import com.expleague.yasm4u.domains.sql.exceptions.SQLConnectionException;

import java.math.BigInteger;
import java.util.*;

public class SQLWhereRoutine implements Routine {
    @Override
    public Joba[] buildVariants(Ref[] state, JobExecutorService executor) {
        return new Joba[0];
    }

    @Override
    public Joba[] buildVariantsFor(Ref[] goals, JobExecutorService executor) {
        final List<Joba> variants = new ArrayList<>();

        for(int i = 0; i < goals.length; i++) {
            if (SQLRef.class.isAssignableFrom(goals[i].type())) {
                final SQLRef ref = (SQLRef)executor.resolve(goals[i]);
                SQLRestriction restriction = (SQLRestriction) ref.restriction();

                Set<String> columns = restriction.getColumnNames();
                Map<String, List<String>> predicateMap = restriction.getPredicates();

                for (Map.Entry<String, List<String>> entry : predicateMap.entrySet()) {
                    if (!columns.contains(entry.getKey())) {
                        continue;
                    }

                    List<String> predicates = entry.getValue();

                    for (int j = 0; j < predicates.size(); j++) {
                        String predicate = predicates.remove(j);
                        entry.setValue(predicates);

                        SQLRestriction inputRestriction = new SQLRestriction(columns, predicateMap);
                        SQLRef inputRef = new SQLRef(inputRestriction);

                        variants.add(new Joba.Stub(new Ref[]{inputRef}, new Ref[]{ref}) {
                            @Override
                            public void run() {
                                final SQLDomain env = executor.domain(SQLDomain.class);
                                try {
                                    SQLRef from = ((SQLRef) consumes()[0]).resolve(env);
                                    SQLRef to = ((SQLRef) produces()[0]).resolve(env);
                                    env.filter(from.getTable(), to.getTable(), columns, predicate);
                                } catch (SQLConnectionException ignored) {
                                }
                            }
                        });

                        predicates.add(j, predicate);
                        entry.setValue(predicates);
                    }
                }
            }
        }

        return variants.toArray(new Joba[0]);
    }
}

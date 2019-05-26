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

public class SQLCrossJoinRoutine implements Routine {
    @Override
    public Joba[] buildVariants(Ref[] state, JobExecutorService executor) {
        final List<Joba> variants = new ArrayList<>();

        for(int i = 0; i < state.length - 1; i++) {
            for(int j = i + 1; j < state.length; j++) {
                if (SQLRef.class.isAssignableFrom(state[i].type())
                        && SQLRef.class.isAssignableFrom(state[i].type())) {
                    final SQLRef first = (SQLRef) executor.resolve(state[i]);
                    final SQLRef second = (SQLRef) executor.resolve(state[j]);

                    SQLRestriction firstRestriction = (SQLRestriction) first.restriction();
                    Set<String> firstColumns = firstRestriction.getColumnNames();

                    SQLRestriction secondRestriction = (SQLRestriction) second.restriction();
                    Set<String> secondColumns = secondRestriction.getColumnNames();

                    Set<String> intersection = new HashSet<>(firstColumns);
                    intersection.retainAll(secondColumns);

                    if (!intersection.isEmpty()) {
                        continue;
                    }

                    Set<String> union = new HashSet<>(firstColumns);
                    union.addAll(secondColumns);
                    SQLRestriction crossJoinRestriction = firstRestriction.crossJoin(secondRestriction);
                    SQLRef outputRef = new SQLRef(crossJoinRestriction);

                    variants.add(new Joba.Stub(new Ref[]{first, second}, new Ref[]{outputRef}) {
                        @Override
                        public void run() {
                            final SQLDomain env = executor.domain(SQLDomain.class);
                            try {
                                SQLRef fromFirst = ((SQLRef) consumes()[0]).resolve(env);
                                SQLRef fromSecond = ((SQLRef) consumes()[1]).resolve(env);
                                SQLRef to = ((SQLRef) produces()[0]).resolve(env);
                                env.crossJoin(fromFirst.getTable(), fromSecond.getTable(), to.getTable(), union);
                            } catch (SQLConnectionException ignored) {
                            }
                        }
                    });
               }
            }
        }

        return variants.toArray(new Joba[0]);
    }

    @Override
    public Joba[] buildVariantsFor(Ref[] goals, JobExecutorService executor) {
        return new Joba[0];
    }
}

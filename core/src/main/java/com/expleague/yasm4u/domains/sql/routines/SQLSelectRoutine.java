package com.expleague.yasm4u.domains.sql.routines;

import com.expleague.yasm4u.JobExecutorService;
import com.expleague.yasm4u.Joba;
import com.expleague.yasm4u.Ref;
import com.expleague.yasm4u.Routine;
import com.expleague.yasm4u.domains.sql.SQLDomain;
import com.expleague.yasm4u.domains.sql.SQLRef;
import com.expleague.yasm4u.domains.sql.SQLRestriction;

import java.math.BigInteger;
import java.util.*;

public class SQLSelectRoutine implements Routine {
    private static final int MASK_RADIX = 2;

    @Override
    public Joba[] buildVariants(Ref[] state, JobExecutorService executor) {
        final List<Joba> variants = new ArrayList<>();

        for(int i = 0; i < state.length; i++) {
            if (SQLRef.class.isAssignableFrom(state[i].type())) {
                final SQLRef ref = (SQLRef)executor.resolve(state[i]);
                SQLRestriction restriction = (SQLRestriction) ref.restriction();
                List<String> columns = new ArrayList<>(restriction.getColumnNames());
                BigInteger maxMask = allInMask(columns.size());

                for (BigInteger mask = BigInteger.ZERO;
                     mask.compareTo(maxMask) <= 0;
                     mask = mask.add(BigInteger.ONE))
                {
                    Set<String> subSet = new HashSet<>(subList(columns, mask));
                    // make output ref
                    SQLRef outputRef = ref;

                    variants.add(new Joba.Stub(new Ref[]{ref}, new Ref[]{outputRef}) {
                        @Override
                        public void run() {
                            final SQLDomain env = executor.domain(SQLDomain.class);
                            // make select
                            //env.sort((SQLRef) consumes()[0].resolve(env));
                        }
                    });
                }
            }
        }

        return variants.toArray(new Joba[0]);
    }

    private static BigInteger allInMask(int n) {
        char[] ones = new char[n];
        Arrays.fill(ones, '1');
        return new BigInteger(new String(ones), MASK_RADIX);
    }

    private static List<String> subList(List<String> list, BigInteger mask) {
        List<String> sublist = new ArrayList<>();
        String binaryMask = mask.toString(MASK_RADIX);
        char[] bits = binaryMask.toCharArray();
        int n = bits.length;

        for (int i = 0; i < n; i++) {
            if (bits[n - i - 1] == '1') {
                sublist.add(list.get(i));
            }
        }

        return sublist;
    }
}

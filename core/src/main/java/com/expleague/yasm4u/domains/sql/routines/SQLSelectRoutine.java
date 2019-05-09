package com.expleague.yasm4u.domains.sql.routines;

import com.expleague.yasm4u.JobExecutorService;
import com.expleague.yasm4u.Joba;
import com.expleague.yasm4u.Ref;
import com.expleague.yasm4u.Routine;

public class SQLSelectRoutine implements Routine {
    @Override
    public Joba[] buildVariants(Ref[] state, JobExecutorService executor) {
        return new Joba[0];
    }
}

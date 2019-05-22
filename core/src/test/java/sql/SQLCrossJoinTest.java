package sql;

import com.expleague.yasm4u.domains.sql.SQLQueryExecutor;
import com.expleague.yasm4u.domains.sql.executors.JDBCQueryExecutor;
import com.expleague.yasm4u.domains.sql.executors.SQLRestrictionBasedQueryExecutor;
import org.junit.Rule;
import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

public class SQLCrossJoinTest {
    @Rule
    public BaseSQLTest baseSQLTest = new BaseSQLTest();

    public SQLCrossJoinTest() throws Exception {
    }

    @Test
    public void testJoin() throws Exception {
//        BaseSQLTest.testQuery("SELECT COL1, AGE FROM A, D;");
        BaseSQLTest.testQuery("SELECT NAME, AGE, ID1 FROM D, E;");
    }
}

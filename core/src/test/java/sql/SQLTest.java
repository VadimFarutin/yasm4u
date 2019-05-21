package sql;

import com.expleague.yasm4u.domains.sql.SQLQueryExecutor;
import com.expleague.yasm4u.domains.sql.executors.JDBCQueryExecutor;
import com.expleague.yasm4u.domains.sql.executors.SQLRestrictionBasedQueryExecutor;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SQLTest {
    @Rule
    public BaseSQLTest baseSQLTest = new BaseSQLTest();

    public SQLTest() throws Exception {
    }

    @Test
    public void testSelect() throws Exception {
        SQLQueryExecutor jdbcExecutor = new JDBCQueryExecutor(BaseSQLTest.getConfig());
        SQLQueryExecutor restrictionBasedExecutor = new SQLRestrictionBasedQueryExecutor(BaseSQLTest.getConfig());

        String query = "SELECT COL0 FROM EMPTY_TABLE;";

        String expected = jdbcExecutor.process(query);
        String result = restrictionBasedExecutor.process(query);

        assertEquals(expected, result);
    }
}

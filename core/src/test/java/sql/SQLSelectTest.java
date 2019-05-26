package sql;

import org.junit.Rule;
import org.junit.Test;

public class SQLSelectTest {
    @Rule
    public BaseSQLTest baseSQLTest = new BaseSQLTest();

    public SQLSelectTest() throws Exception {
    }

    @Test
    public void testSelectOneColumn() throws Exception {
        BaseSQLTest.testQuery("SELECT COL0 FROM A;");
    }

    @Test
    public void testSelectTwoColumns() throws Exception {
        BaseSQLTest.testQuery("SELECT COL0, COL1 FROM A;");
    }

    @Test
    public void testSelectFromEmptyTable() throws Exception {
        BaseSQLTest.testQuery("SELECT NAME, AGE FROM C;");
    }
}

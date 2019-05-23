package sql;

import org.junit.Rule;
import org.junit.Test;

public class SQLNaturalJoinTest {
    @Rule
    public BaseSQLTest baseSQLTest = new BaseSQLTest();

    public SQLNaturalJoinTest() throws Exception {
    }

    @Test
    public void testNaturalJoinOnOneColumn() throws Exception {
        BaseSQLTest.testQuery("SELECT NAME, AGE, HEIGHT FROM D NATURAL JOIN F;");
    }

    @Test
    public void testNaturalJoinOnTwoColumns() throws Exception {
        BaseSQLTest.testQuery("SELECT COL0, COL1, COL2, COL3 FROM A NATURAL JOIN B;");
    }

    @Test
    public void testNaturalJoinWithSelect() throws Exception {
        BaseSQLTest.testQuery("SELECT COL0, COL2, COL3 FROM A NATURAL JOIN B;");
    }
}

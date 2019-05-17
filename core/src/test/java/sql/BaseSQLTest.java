package sql;

import com.expleague.yasm4u.domains.sql.SQLConfig;
import com.expleague.yasm4u.domains.sql.SQLQueryExecutor;
import com.expleague.yasm4u.domains.sql.executors.JDBCQueryExecutor;
import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.DatabaseDataSourceConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.hsqldb.jdbc.JDBCDataSource;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;

public class BaseSQLTest extends DBTestCase {
    private static final String DRIVER = "org.hsqldb.jdbcDriver";
    private static final String URL = "jdbc:hsqldb:sample";
    private static final String USERNAME = "";
    private static final String PASSWORD = "";
    private static final String DATABASE_SOURCE = "database.xml";
    
    private static final SQLConfig config = new SQLConfig(DRIVER, URL, USERNAME, PASSWORD);

    public BaseSQLTest(String name) {
        super(name);
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, DRIVER);
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, URL);
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, USERNAME);
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, PASSWORD);
    }
    
    public static SQLConfig getConfig() {
        return config;        
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        File database = new File(this.getClass().getResource(DATABASE_SOURCE).getFile());
        return new FlatXmlDataSetBuilder().build(new FileInputStream(database));
    }

    @Override
    protected DatabaseOperation getSetUpOperation() throws Exception {
        return DatabaseOperation.CLEAN_INSERT;
    }

    @Override
    protected DatabaseOperation getTearDownOperation() throws Exception {
        return DatabaseOperation.NONE;
    }

    @Test
    public void testSelect() throws Exception {
        SQLQueryExecutor jdbcExecutor = new JDBCQueryExecutor(BaseSQLTest.getConfig());
        String query = "SELECT * FROM EMPTY_TABLE;";
        String result = jdbcExecutor.process(query);
        System.out.println(result);
    }
}

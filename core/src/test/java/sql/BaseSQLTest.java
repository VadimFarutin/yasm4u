package sql;

import com.expleague.yasm4u.domains.sql.SQLConfig;
import com.expleague.yasm4u.domains.sql.SQLQueryExecutor;
import com.expleague.yasm4u.domains.sql.executors.JDBCQueryExecutor;
import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.sql.*;

public class BaseSQLTest extends DBTestCase {
    private static final String DRIVER = "org.hsqldb.jdbcDriver";
    private static final String URL = "jdbc:hsqldb:sample";
    private static final String USERNAME = "";
    private static final String PASSWORD = "";
    private static final String DATABASE_SOURCE = "database.xml";
    private static final SQLConfig config = new SQLConfig(DRIVER, URL, USERNAME, PASSWORD);

    private static final String[] TABLE_NAMES = {
            "EMPTY_TABLE",
            "FIRST_TABLE",
            "SECOND_TABLE"};
    private static final String[] TABLE_SCHEMAS = {
            "(id INTEGER)",
            "(col0 VARCHAR(255), col1 VARCHAR(255), col2 VARCHAR(255))",
            "(col0 VARCHAR(255), col1 VARCHAR(255))"};

    public BaseSQLTest(String name) throws Exception {
        super(name);

        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, DRIVER);
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, URL);
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, USERNAME);
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, PASSWORD);

        createTables();
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

    private void createTables() throws ClassNotFoundException, SQLException {
        Class.forName(config.getDriver());

        try (Connection conn = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());
             Statement stmt = conn.createStatement()) {
            dropTables(stmt);
            createTables(stmt);
        }
    }

    private void dropTables(Statement stmt) throws SQLException {
        String dropPattern = "DROP TABLE IF EXISTS %s CASCADE;";

        for (int i = 0; i < TABLE_NAMES.length; i++) {
            stmt.executeUpdate(String.format(dropPattern, TABLE_NAMES[i]));
        }
    }

    private void createTables(Statement stmt) throws SQLException {
        String createPattern = "CREATE TABLE %s %s;";

        for (int i = 0; i < TABLE_NAMES.length; i++) {
            stmt.executeUpdate(String.format(createPattern, TABLE_NAMES[i], TABLE_SCHEMAS[i]));
        }
    }
}

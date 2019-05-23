package sql;

import com.expleague.yasm4u.domains.sql.SQLConfig;
import com.expleague.yasm4u.domains.sql.SQLQueryExecutor;
import com.expleague.yasm4u.domains.sql.exceptions.SQLConnectionException;
import com.expleague.yasm4u.domains.sql.exceptions.SQLDriverNotFoundException;
import com.expleague.yasm4u.domains.sql.exceptions.SQLJobaExecutionException;
import com.expleague.yasm4u.domains.sql.executors.JDBCQueryExecutor;
import com.expleague.yasm4u.domains.sql.executors.SQLRestrictionBasedQueryExecutor;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.varia.NullAppender;
import org.dbunit.*;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;

import static org.junit.Assert.assertEquals;

public class BaseSQLTest implements TestRule {
    private static final String DRIVER = "org.hsqldb.jdbcDriver";
    private static final String URL = "jdbc:hsqldb:testdb";
    private static final String USERNAME = "";
    private static final String PASSWORD = "";
    private static final String DATASET_SOURCE = "dataset.xml";
    private static final SQLConfig config = new SQLConfig(DRIVER, URL, USERNAME, PASSWORD);

    private static final String[] TABLE_NAMES = {
            "A",
            "B",
            "C",
            "D",
            "E",
            "F"};
    private static final String[] TABLE_SCHEMAS = {
            "(COL0 VARCHAR(255), COL1 VARCHAR(255), COL2 VARCHAR(255))",
            "(COL0 VARCHAR(255), COL1 VARCHAR(255), COL3 VARCHAR(255))",
            "(NAME VARCHAR(255), AGE INT)",
            "(NAME VARCHAR(255), AGE INT)",
            "(ID1 INT)",
            "(NAME VARCHAR(255), HEIGHT INT)"};

    private JdbcDatabaseTester databaseTester;

    public BaseSQLTest() throws Exception {
//        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, DRIVER);
//        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, URL);
//        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, USERNAME);
//        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, PASSWORD);

        databaseTester = new JdbcDatabaseTester(config.getDriver(),
                                                config.getUrl(),
                                                config.getUsername(),
                                                config.getPassword());

        Logger.getLogger("org.dbunit").setLevel(Level.ERROR);
    }

    public static void testQuery(String query) throws SQLDriverNotFoundException, SQLConnectionException, SQLJobaExecutionException {
        SQLQueryExecutor jdbcExecutor = new JDBCQueryExecutor(config);
        SQLQueryExecutor restrictionBasedExecutor = new SQLRestrictionBasedQueryExecutor(config);

        String expected = jdbcExecutor.process(query);
        String result = restrictionBasedExecutor.process(query);

        assertEquals(expected, result);
    }

    @Override
    public org.junit.runners.model.Statement apply(org.junit.runners.model.Statement base,
                                                   Description description) {
        return new org.junit.runners.model.Statement() {
            @Override
            public void evaluate() throws Throwable {
                setUp();
                base.evaluate();
                tearDown();
            }
        };
    }

    private void setUp() throws Exception {
        dropTables();
        createTables();

        IDatabaseTester databaseTester = getDatabaseTester();
        databaseTester.setSetUpOperation(getSetUpOperation());
        databaseTester.setDataSet(getDataSet());
        databaseTester.setOperationListener(getOperationListener());
        databaseTester.onSetup();
    }

    private void tearDown() throws Exception {
        IDatabaseTester databaseTester = getDatabaseTester();
        databaseTester.setTearDownOperation(getTearDownOperation());
        databaseTester.setDataSet(getDataSet());
        databaseTester.setOperationListener(getOperationListener());
        databaseTester.onTearDown();

        dropTables();
    }

    private IDatabaseTester getDatabaseTester() {
        return databaseTester;
    }

    private IOperationListener getOperationListener() {
        return null;
    }

    private IDataSet getDataSet() throws Exception {
        File dataset = new File(this.getClass().getResource(DATASET_SOURCE).getFile());
        return new FlatXmlDataSetBuilder().build(new FileInputStream(dataset));
    }

    private DatabaseOperation getSetUpOperation() {
        return DatabaseOperation.CLEAN_INSERT;
    }

    private DatabaseOperation getTearDownOperation() {
        return DatabaseOperation.NONE;
    }

    private void createTables() throws ClassNotFoundException, SQLException {
        Class.forName(config.getDriver());
        String createPattern = "CREATE TABLE %s %s;";

        try (Connection conn = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());
             Statement stmt = conn.createStatement()) {
            for (int i = 0; i < TABLE_NAMES.length; i++) {
                stmt.executeUpdate(String.format(createPattern, TABLE_NAMES[i], TABLE_SCHEMAS[i]));
            }
        }
    }

    private void dropTables() throws ClassNotFoundException, SQLException {
        Class.forName(config.getDriver());
        String dropPattern = "DROP TABLE IF EXISTS %s CASCADE;";

        try (Connection conn = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());
             Statement stmt = conn.createStatement()) {
            DatabaseMetaData metaData = conn.getMetaData();
            ResultSet allTables = metaData.getTables(null, null, null, new String[]{"TABLE"});

            while (allTables.next()) {
                stmt.executeUpdate(String.format(dropPattern, allTables.getString("TABLE_NAME")));
            }
        }
    }
}

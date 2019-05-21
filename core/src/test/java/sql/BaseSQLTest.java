package sql;

import com.expleague.yasm4u.domains.sql.SQLConfig;
import org.dbunit.*;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;

public class BaseSQLTest implements TestRule {
    private static final String DRIVER = "org.hsqldb.jdbcDriver";
    private static final String URL = "jdbc:hsqldb:testdb";
    private static final String USERNAME = "";
    private static final String PASSWORD = "";
    private static final String DATASET_SOURCE = "dataset.xml";
    private static final SQLConfig config = new SQLConfig(DRIVER, URL, USERNAME, PASSWORD);

    private static final String[] TABLE_NAMES = {
            "EMPTY_TABLE",
            "FIRST_TABLE",
            "SECOND_TABLE"};
    private static final String[] TABLE_SCHEMAS = {
            "(COL0 VARCHAR(255))",
            "(COL0 VARCHAR(255), COL1 VARCHAR(255), COL2 VARCHAR(255))",
            "(COL0 VARCHAR(255), COL1 VARCHAR(255))"};

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
        createTables();
    }

    public static SQLConfig getConfig() {
        return config;
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

        try (Connection conn = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());
             Statement stmt = conn.createStatement()) {
            dropTables(conn, stmt);
            createTables(stmt);
        }
    }

    private void dropTables(Connection connection, Statement stmt) throws SQLException {
        String dropPattern = "DROP TABLE IF EXISTS %s CASCADE;";
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet allTables = metaData.getTables(null, null, null, new String[]{"TABLE"});

        while (allTables.next()) {
            stmt.executeUpdate(String.format(dropPattern, allTables.getString("TABLE_NAME")));
        }
    }

    private void createTables(Statement stmt) throws SQLException {
        String createPattern = "CREATE TABLE %s %s;";

        for (int i = 0; i < TABLE_NAMES.length; i++) {
            stmt.executeUpdate(String.format(createPattern, TABLE_NAMES[i], TABLE_SCHEMAS[i]));
        }
    }
}

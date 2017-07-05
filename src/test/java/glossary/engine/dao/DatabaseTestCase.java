package glossary.engine.dao;

import glossary.engine.factory.DatabaseFactory;
import junit.framework.TestCase;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;

/**
 * Test case with database connection
 */
public abstract class DatabaseTestCase extends TestCase {
    Connection testConnection;
    private String databaseFile;

    public void setUp() throws Exception {
        super.setUp();
        databaseFile = getClass().getName() + ".test.sqlite";
        testConnection = DatabaseFactory.craete(databaseFile);
    }

    public void tearDown() throws Exception {
        super.tearDown();

        testConnection.close();
        Files.delete(Paths.get(databaseFile));
    }
}

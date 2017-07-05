package glossary.engine.factory;

import glossary.global.exception.DatabaseException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Pavel Máca <maca.pavel@gmail.com> on 05.07.2017.
 */
public abstract class DatabaseFactory {

    /**
     * Craete SQLite database Connection for given file
     * Create new file and setup structure if given file is not found.
     *
     * @param fileName name of file for storing database data
     * @return Return NULL if database cannot be opened od created
     */
    public static Connection craete(String fileName) {
        Connection connection = null;

        Path filepath = Paths.get(fileName);
        boolean createDbStructure = true;
        if (Files.exists(filepath)) {
            createDbStructure = false;
        }

        try {
            // db parameters
            String url = "jdbc:sqlite:" + fileName;

            // create a connection to the database
            connection = DriverManager.getConnection(url);

            if (createDbStructure) {
                // setup database structure
                createDatabase(connection);
            }

            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Create internal database structure
     * @param connection empty database connection
     */
    private static void createDatabase(Connection connection) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE 'card' (" +
                    "  'id' INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    "  'id_list' INTEGER NOT NULL," +
                    "  'word_1' TEXT NOT NULL," +
                    "  'word_2' TEXT NOT NULL, 'priority' INTEGER NOT NULL DEFAULT '1'," +
                    "  FOREIGN KEY ('id_list') REFERENCES 'list' ('id') ON DELETE CASCADE" +
                    ");");

            statement.executeUpdate("CREATE TABLE 'list' (" +
                    "  'id' INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    "  'name' TEXT NOT NULL" +
                    ");");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

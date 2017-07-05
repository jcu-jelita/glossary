package glossary.engine.service;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Pavel Máca <maca.pavel@gmail.com> on 04.07.2017.
 */
public class DatabaseService {
    private Connection connection = null;

    static private String DB_FILE_NAME = "glossary.db";

    public Connection getConnection() {
        if (connection != null) {
            return connection;
        }

        Path filepath = Paths.get(DB_FILE_NAME);
        boolean createDb = true;
        if (Files.exists(filepath)) {
            createDb = false;
        }

        try {
            // db parameters
            String url = "jdbc:sqlite:" + DB_FILE_NAME;

            // create a connection to the database
            connection = DriverManager.getConnection(url);

            if (createDb) {
                createDatabase();
            }

            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    protected void createDatabase() {
        try {
            Statement statement = getConnection().createStatement();
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

    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

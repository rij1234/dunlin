import java.sql.*;

public class Database {
    private String filename;
    private Connection c;


    public Database(String filename) {
        this.filename = filename;
        connect();
        setupTables();

    }

    public void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:" + filename;
            c = DriverManager.getConnection(url);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        public void close() {
        try {
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setupTables() {
        try {
            Statement s = c.createStatement();
            s.executeUpdate("CREATE TABLE IF NOT EXISTS Days (month TINYINT(12), day TINYINT(31), " +
                    "journalEntry TEXT, year INT)");
            s.executeUpdate("CREATE TABLE IF NOT EXISTS Goals (name TEXT, achieved BOOLEAN, monthAchieved INT, " +
                    "dayAchieved INT, yearAchieved, onePointRequirement TEXT, twoPointRequirement TEXT, year INT)");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
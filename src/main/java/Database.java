import java.sql.*;

public class Database {
    private String filename;
    private Connection c;


    public Database(String filename) {
        this.filename = filename;
        connect();
    }

    public void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:" + filename;
            c = DriverManager.getConnection(url);

            setupTables();
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

    // Creates the tables if they don't exist
    public void setupTables() {
        try {
            Statement s = c.createStatement();
            s.executeUpdate("CREATE TABLE IF NOT EXISTS Days (month TINYINT(12), day TINYINT(31),  year INT, " +
                    "journalEntry TEXT, mood INT, productivity INT, goalTotals TEXT)");
            s.executeUpdate("CREATE TABLE IF NOT EXISTS Goals (name TEXT, id TEXT UNIQUE, achieved BOOLEAN, monthAchieved INT, " +
                    "dayAchieved INT, yearAchieved, onePointRequirement TEXT, twoPointRequirement TEXT)");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // Adds a goal to the database
    public void addGoal(Goal goal) {
        try {
            Statement s = c.createStatement();

            if(goal.hasBeenAchieved()) {
                s.executeUpdate("INSERT INTO Goals VALUES ('" + goal.getGoal() + "', '" + goal.getId() + "', " + goal.hasBeenAchieved() + ", " +
                        goal.getDateAchieved()[0] + ", " + goal.getDateAchieved()[1] + ", " + goal.getDateAchieved()[2] + ", " +
                        "'" + goal.getOnePointRequirement() + "', '" + goal.getTwoPointRequirement() + "')");
            } else {
                s.executeUpdate("INSERT INTO Goals VALUES ('" + goal.getGoal() + "', '" + goal.getId() + "', " + goal.hasBeenAchieved() + ", " +
                        "NULL" + ", " + "NULL" + ", " + "NULL" + ", " +
                        "'" + goal.getOnePointRequirement() + "', '" + goal.getTwoPointRequirement() + "')");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // Fetches all goals from the database and returns them in a Goal[] array
    public Goal[] getGoals(){
        Goal[] goals = new Goal[0];
        try {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM Goals");
            goals = new Goal[4];
            int i = 0;
            while(rs.next()) {
                String name = rs.getString("name");
                String id = rs.getString("id");
                boolean achieved = rs.getBoolean("achieved");
                int[] dateAchieved = new int[3];
                dateAchieved[0] = rs.getInt("monthAchieved");
                dateAchieved[1] = rs.getInt("dayAchieved");
                dateAchieved[2] = rs.getInt("yearAchieved");

                goals[i] = new Goal(name, rs.getString("onePointRequirement"), rs.getString("twoPointRequirement"), id, achieved, dateAchieved);
                i++;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goals;
    }

    // Adds a day to the database

}
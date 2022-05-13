import java.util.*;

class Day {
    private int mood = 0;
    private int productivity = 0;
    private int month = 0;
    private int day = 0;
    private Map<String, Integer> goalTotals;

    private static final int MAX_JOURNAL_ENTRY_LENGTH = 2000;
    private String journalEntry;

    public Day(int month, int day) {
        this.month = month;
        this.day = day;
        goalTotals = new HashMap<String, Integer>();
    }

    public void setGoalTotals(Map<String, Integer> goalTotals) {
        this.goalTotals = goalTotals;
    }

    public void addGoalTotal(String goal, int score) {
        goalTotals.put(goal, score);
    }

    public Map<String, Integer> getGoalTotals() {
        return goalTotals;
    }

    public int[] getDate(){
        int[] returnDate = new int[2];
        returnDate[0] = month;
        returnDate[1] = day;
        return returnDate;
    }

    public void setMood(int newMood){this.mood = newMood;}
    public int getMood(){return mood;}

    public void setJournal(String entry){journalEntry = entry;}
    public String getJournal(){return journalEntry;}

    public int getProductivity(){return productivity;}
    public void setProductivity(int h){productivity = h;}

}
import java.util.*;

public class Year {

    private int year;
    public ArrayList<Goal> goals;
    public ArrayList<Day> days;

    public Year(int year){
        this.year = year;
        this.goals = new ArrayList<Goal>();
        this.days = new ArrayList<Day>();
    }

    public int getYear() {
        return year;
    }

    public Goal[] getGoals(){
        Goal[] goalsArray = new Goal[goals.size()];
        for(int i = 0; i < goals.size(); i++) goalsArray[i] = goals.get(i);
        return goalsArray;
    }

    public Goal[] addGoal(Goal goal) {
        goals.add(goal);
        return getGoals();
    }

    public Goal[] getGoals(int year) {
        Goal[] goalsArray = new Goal[goals.size()];
        for(int i = 0; i < goals.size(); i++) goalsArray[i] = goals.get(i);
        return goalsArray;
    }

    public Day[] getDays(){
        Day[] daysArray = new Day[days.size()];
        for(int i = 0; i < days.size(); i++) daysArray[i] = days.get(i);
        return daysArray;
    }

    public void addDay(Day day){
        days.add(day);
    }



}
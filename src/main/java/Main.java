import java.util.*;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        Day today = new Day(now.getMonthValue(), now.getDayOfMonth());

        Goal goal1 = new Goal("Get USACO silver", "Study 1 Hour", "Study 2+ hours", Goal.getNewId());
        Goal goal2 = new Goal("1550+ SAT", "Study 1 Hour", "Study 2+ hours", Goal.getNewId());
        Goal goal3 = new Goal("Ekal", "1 Hour", "2+ hours", Goal.getNewId());
        Goal goal4 = new Goal("Sleep Earlier", "No Screen 30 min before bed", "No screen 1 hour before bed", Goal.getNewId());

        Goal[] goals = {goal1, goal2, goal3, goal4};

//        year.addGoal(goal1);
//        year.addGoal(goal2);
//        year.addGoal(goal3);
//        year.addGoal(goal4);
//
//        for (Goal goal : year.getGoals()) {
//            System.out.println(goal);
//            today.addGoalTotal(goal.toString(), 2);
//        }
//
//        System.out.println("\n\n");

        Database database = new Database("main.db");

        for(Goal goal : goals) {
            // database.addGoal(goal);
        }

        for(Goal goal : database.getGoals()){
            System.out.println(goal);
            // database.removeGoal(goal);
        }

        GUI gui = new GUI();





    }
}
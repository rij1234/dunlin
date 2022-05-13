import java.util.*;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args){
        LocalDateTime now = LocalDateTime.now();
        Year year = new Year(2022);
        Day today = new Day(now.getMonthValue(), now.getDayOfMonth());

        year.addGoal(new Goal("Get USACO silver", "Study 1 Hour", "Study 2+ hours"));
        year.addGoal(new Goal("1550+ SAT", "Study 1 Hour", "Study 2+ hours"));
        year.addGoal(new Goal("Ekal", "1 Hour", "2+ hours"));
        year.addGoal(new Goal("Sleep Earlier", "No Screen 30 min before bed", "No screen 1 hour before bed"));



        // if this works, yay

        for(Goal goal : year.getGoals()) {
            System.out.println(goal);
            today.addGoalTotal(goal.toString(), 2);
        }
        System.out.println("\n\n");

         Database database = new Database("main.db");





        year.addDay(today);


    }
}
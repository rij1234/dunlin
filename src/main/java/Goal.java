import java.util.ArrayList;
import java.util.UUID;

public class Goal {
    private String goal;
    private ArrayList<String> dailySteps;
    private boolean achieved;
    private int[] dateAchieved;
    private String onePointRequirement;
    private String twoPointRequirement;
    private final String id;

    public Goal(String mainGoal, String onePointRequirement, String twoPointRequirement, String id) {
        goal = mainGoal;
        dailySteps = new ArrayList<String>();
        achieved = false;
        this.onePointRequirement = onePointRequirement;
        this.twoPointRequirement = twoPointRequirement;
        this.id = id;
    }

    public Goal(String mainGoal, String onePointRequirement, String twoPointRequirement, String id, boolean achieved, int[] dateAchieved) {
        goal = mainGoal;
        dailySteps = new ArrayList<String>();
        achieved = false;
        this.onePointRequirement = onePointRequirement;
        this.twoPointRequirement = twoPointRequirement;
        this.id = id;
        this.achieved = achieved;
        this.dateAchieved = dateAchieved;
    }

    public static String getNewId() {
        String uniqueID = UUID.randomUUID().toString();

        // return (int) (Math.random() * 1000000);
        return uniqueID;
    }

    public String[] getDailySteps(){
        String[] steps = new String[dailySteps.size()];
        for(int i = 0; i < dailySteps.size(); i++) steps[i] = dailySteps.get(i);
        return steps;
    }

    public String getGoal(){return goal;}

    public void setGoal(String newGoal){goal = newGoal;}

    public void addDailySteps(String[] steps){
        for(int i = 0; i < steps.length; i++) dailySteps.add(steps[i]);
    }
    public void addDailyStep(String step){ dailySteps.add(step); }

    public void setDailyStep(String newStep, int index){ dailySteps.set(index, newStep); }

    public void removeDailyStep(int index){ dailySteps.remove(index); }

    public int getDailyStepsSize(){ return dailySteps.size(); }

    public String getDailyStep(int index){ return dailySteps.get(index); }

    public boolean hasBeenAchieved(){ return achieved; }
    public void setNotAchieved(){ achieved = false; dateAchieved = null; }
    public void setAchieved(int[] date){ achieved = true; dateAchieved = date; }
    public int[] getDateAchieved(){ return dateAchieved; }

    public String getOnePointRequirement(){ return onePointRequirement; }
    public String getTwoPointRequirement(){ return twoPointRequirement; }
    public void getOnePointRequirement(String newRequirement){ onePointRequirement = newRequirement; }
    public void getTwoPointRequirement(String newRequirement){ twoPointRequirement = newRequirement; }

    public String getId(){ return id; }

    public String toString(){
        return getGoal() + "{}{}{}" + getOnePointRequirement() + "{}{}{}" + getTwoPointRequirement();
    }
}
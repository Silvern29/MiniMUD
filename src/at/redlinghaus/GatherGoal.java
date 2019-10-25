package at.redlinghaus;

public class GatherGoal extends Goal {

    private PackItem goalItem;
    private String task;

    public GatherGoal (String task, Player p, Item goalItem, int goalCount) {
        this.task = task;
        this.goalItem = p.addBackPack(goalItem, 0);
        this.goalCount = goalCount;
    }

    public PackItem getGoalItem() {
        return goalItem;
    }

    public int getGoalCount() {
        return goalCount;
    }


    }



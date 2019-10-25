package at.redlinghaus;

public class GatherGoal extends Goal {

    private int goalCount;
    private PackItem goalItem;

    public GatherGoal(Player p, Item goalItem, int goalCount) {
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



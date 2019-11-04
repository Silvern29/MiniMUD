package at.redlinghaus;

public class GatherGoal extends Goal {

    public GatherGoal(Player p, Item goalItem, int goalCount) {
        this.goalItem = new PackItem(goalItem, 0);
        this.goalCount = goalCount;
    }
}



package at.redlinghaus;

public class Quest2 extends Quest {

    private Item stone;

    public Quest2(Player p, DungeonMap map) {
        this.p = p;
        description = "Please gather the not so ordinary stone to unlock the key.";
        stone = map.stone;
        goal = new GatherGoal(p, stone, 1);
        reward = map.key2;
    }

    @Override
    public boolean isComplete() {
        return p.isInPack(stone).getAmount() >= goal.goalCount;
    }

    public void solveQuest() {
        System.out.println("\nYou gathered all the required items. You have unlocked the key.\n");
        setSolved();
        p.addBackPack(reward, 1);
        p.removeBackPack(stone, goal.goalCount);
    }
}

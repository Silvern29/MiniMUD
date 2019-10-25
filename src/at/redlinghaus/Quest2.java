package at.redlinghaus;

import java.util.Scanner;

public class Quest2 extends Quest {

    private Player player;
    private Item stone = new QuestItem("a not so ordinary stone");
    private Key key = new Key("456");
    private Scanner sc = new Scanner(System.in);

    public Quest2(Player player) {
        this.player = player;
        description = "## filler ##";
        goal = new GatherGoal("Gather the required items.", player, stone, 5);
        reward = key;
    }

    @Override
    public void setSolved(boolean isSolved) {
        this.isSolved = true;
    }

    @Override
    public void acceptQuest() {
    }

    @Override
    public boolean isComplete() {
        return player.isInPack(stone).getAmount() >= goal.goalCount;
    }

    public void solveQuest() {
        System.out.println("You gathered all the required items. You have unlocked the key.");
        setSolved(true);
        player.addBackPack(key, 1);
        player.removeBackPack(stone, goal.goalCount);
    }
}

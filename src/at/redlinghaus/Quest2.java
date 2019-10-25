package at.redlinghaus;

import java.util.Scanner;

public class Quest2 extends Quest {

    private Player player;
    private Item stone = new QuestItem("a not so ordinary stone");
    private Scanner sc = new Scanner(System.in);

    public Quest2(Player player, DungeonMap map) {
        this.player = player;
        description = "## filler ##";
        goal = new GatherGoal(player, stone, 5);
        reward = map.key2;
    }

    @Override
    public void setSolved(boolean isSolved) {
        this.isSolved = true;
    }

    @Override
    public void acceptQuest() {
        String inputPlayer = sc.nextLine();
        System.out.println("Do you want to accept this quest?\ny/n");
        switch (inputPlayer.toLowerCase()) {
            case "y":
                player.acceptQuest(this);
                System.out.println("You have accepted this quest.");
                if (isComplete()) {
                    this.solveQuest();
                } else {
                    System.out.println("Please gather the required items and return.");
                }
                break;
            case "n":
                System.out.println("You have denied the quest.");
                break;
            default:
                System.out.println("Invalid answer.");
        }
    }

    @Override
    public boolean isComplete() {
        return player.isInPack(stone).getAmount() >= goal.goalCount;
    }

    public void solveQuest() {
        System.out.println("You gathered all the required items. You have unlocked the key.");
        setSolved(true);
        player.addBackPack(reward, 1);
        player.removeBackPack(stone, goal.goalCount);
    }
}

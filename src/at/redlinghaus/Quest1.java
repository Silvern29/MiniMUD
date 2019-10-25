package at.redlinghaus;

import java.util.Scanner;

public class Quest1 extends Quest {

    private Player player;
    private Scanner sc = new Scanner(System.in);

    public Quest1(Player player, DungeonMap map) {
        this.player = player;
        description = "This door is locked. It requires a key, which is being kept in this box. " +
                "To open the box you must solve the following riddle:\n\nWhat has a head and a tail, but no body?\n\n" +
                "You have 3 tries.";
        goal = new PuzzleGoal("coin");
        reward = map.entryKey;
    }

    @Override
    public void acceptQuest() {
        String inputPlayer = sc.nextLine();
        System.out.println("Do you want to accept this quest?\ny/n");
        switch (inputPlayer.toLowerCase()) {
            case "y":
                player.acceptQuest(this);
                System.out.println("You have accepted this quest. Enter your guess below.");
                this.solveQuest();
                break;
            case "n":
                System.out.println("You have denied the quest.");
                break;
            default:
                System.out.println("Invalid answer.");
        }
    }

    public void solveQuest() {
        for (int triesLeft = 3; triesLeft > 0; triesLeft--) {
            if (sc.nextLine().equalsIgnoreCase(((PuzzleGoal) goal).getAnswerString())) {
                System.out.println("Congratulations. Your answer is correct. The box opens and you receive the key " + reward.getDescription() + ".");
                setSolved(true);
                player.addBackPack(reward, 1);
            } else {
                System.out.println("Wrong answer. You have " + triesLeft + " left.");
            }
        }
    }

    @Override
    public boolean isComplete() {
        return true;
    }

    @Override
    public void setSolved(boolean isSolved) {
        this.isSolved = true;
    }

    @Override
    public void acceptQuest() {
    }

    @Override
    public String toString() {
        return "Quest1{" +
                "goal=" + goal +
                ", reward=" + reward +
                ", isSolved=" + isSolved +
                '}';
    }

}

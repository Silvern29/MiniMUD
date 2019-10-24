package at.redlinghaus;

import java.util.Scanner;

public class Quest1 extends Quest {

    private Player player;
    private PuzzleGoal goalQ1 = new PuzzleGoal("coin");
    private Key key = new Key("123");
    private Scanner sc = new Scanner(System.in);

    public Quest1(Player player) {
        this.player = player;
        description = "This Door is locked. It requires a key, which is being kept in this box. " +
                "To open the box you must solve the following riddle:\n\nWhat has a head and a tail, but on body?\n\n" +
                "You have 3 tries.";
        goal = goalQ1;
        reward = key;
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
        for (int triesLeft = 2; triesLeft > -1; triesLeft--) {
            if (sc.nextLine().equalsIgnoreCase(goalQ1.getAnswerString())) {
                System.out.println("Congratulations. Your answer is correct. The box opens and you receive the key " + key.getDescription() + ".");
                setSolved(true);
                player.addBackPack(key, 1);
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
    public String toString() {
        return "Quest1{" +
                "goalQ1=" + goalQ1 +
                ", key=" + key +
                ", isSolved=" + isSolved +
                '}';
    }

}

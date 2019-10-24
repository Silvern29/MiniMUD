package at.redlinghaus;

import java.util.Scanner;

public class Quest1 extends Quest {

    private Player player;
    private PuzzleGoal goalQ1 = new PuzzleGoal("coin");
    private Key key = new Key("123");

    public Quest1(Player player) {
        this.player = player;
        description = "This Door is locked. It requires a key, which is being kept in this box. "  +
                "To open the box you must solve the following riddle:\n\nWhat has a head and a tail, but on body?\n\n" +
                "You have 3 tries.";
        goal = goalQ1;
        reward = key;
    }

    @Override
    public void accept() {

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

    public void solveQuest () {
        Scanner sc = new Scanner(System.in);
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


}
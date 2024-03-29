package at.redlinghaus;

import java.util.Scanner;

abstract public class Quest extends Interaction {

    protected boolean isSolved;
    protected Goal goal;
    protected Item reward;
    protected Scanner sc = new Scanner(System.in);
    protected Player p;
    protected long timeRequired = getTime();

    public void setSolved() {
        this.isSolved = true;
    }

    public boolean isSolved() {
        return isSolved;
    }

    public void acceptQuest() {
        if (timeRequired <= getTime()) {
            System.out.println("You have come across a quest:\n" + this.description + "\nDo you want to accept this quest?\ny/n");
            String inputPlayer = sc.nextLine();
            switch (inputPlayer.toLowerCase()) {
                case "y":
                    p.acceptQuest(this);
                    System.out.println("You have accepted this quest.");
                    if (isComplete()) {
                        this.solveQuest();
                    }
                    break;
                case "n":
                    System.out.println("You have denied the quest.");
                    break;
                default:
                    System.out.println("Invalid answer.");
            }
        }
        else {
            System.out.println("\nThis quest is not available yet.\n");
        }
    }

    abstract public void solveQuest();

    abstract public boolean isComplete();

    protected long getTime() {
        return System.currentTimeMillis();
    }

    protected void setTimeRequired() {
        timeRequired = getTime() + (2 * 60 * 1000);
    }

    public Goal getGoal() {
        return goal;
    }

    @Override
    public void handleInteraction(Player p, Field field) {
        if (!p.isInQuestList(this)) {
            this.acceptQuest();
        } else if (p.isInQuestList(this) && !this.isSolved) {
            if (this.isComplete()) {
                this.solveQuest();
            }
        }
    }

    @Override
    public String toString() {
        return "Quest: " + description + " - is solved: " + isSolved;
    }
}

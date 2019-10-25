package at.redlinghaus;

public class Quest1 extends Quest {


    public Quest1(Player p, DungeonMap map) {
        this.p = p;
        description = "This door is locked. It requires a key, which is being kept in this box. " +
                "To open the box you must solve the following riddle:\n\nWhat has a head and a tail, but no body?\n\n" +
                "You have 3 tries.";
        goal = new PuzzleGoal("coin");
        reward = map.entryKey;
    }


    public void solveQuest() {
        for (int triesLeft = 3; triesLeft > 0; triesLeft--) {
            if (sc.nextLine().equalsIgnoreCase(((PuzzleGoal) goal).getAnswerString())) {
                System.out.println("Congratulations. Your answer is correct. The box opens and you receive " + reward + ".");
                setSolved(true);
                p.addBackPack(reward, 1);
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
        return "Quest: " + description;
    }

}

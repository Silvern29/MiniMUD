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
        for (int tries = 3; tries > 0; tries--) {
            if (sc.nextLine().equalsIgnoreCase(((PuzzleGoal) goal).getAnswerString())) {
                System.out.println("\nCongratulations. Your answer is correct. The box opens and you receive " + reward + ".\n");
                setSolved();
                p.addBackPack(reward, 1);
                tries = 0;
            } else {
                System.out.println("Wrong answer. You have " + (tries - 1) + " tries left.");
                if (tries == 1) {
                    p.removeQuestList(this);
                }
            }
        }
    }

    @Override
    public boolean isComplete() {
        return true;
    }

/*    @Override
    public String toString() {
        return "Quest: " + description;
    }*/
}

package at.redlinghaus;

abstract public class Quest extends Interaction {

    protected boolean isSolved;
    protected Goal goal;
    protected Item reward;

    abstract public void setSolved(boolean isSolved);

    public boolean isSolved() {
        return isSolved;
    }

    abstract public void acceptQuest();

    abstract public void solveQuest();

    abstract public boolean isComplete();

    public Goal getGoal() {
        return goal;
    }

    @Override
    public void handleInteraction(Player p) {
        if (!p.isInQuestList(this)) {
            this.acceptQuest();
        } else if (p.isInQuestList(this) && !this.isSolved) {
            if (this.isComplete()) {
                this.solveQuest();
            }
        }
    }

}

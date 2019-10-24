package at.redlinghaus;

abstract public class Quest extends Interaction {

    protected boolean isSolved;
    protected Goal goal;
    protected Item reward;

    abstract public void setSolved(boolean isSolved);

    abstract public void accept();

}

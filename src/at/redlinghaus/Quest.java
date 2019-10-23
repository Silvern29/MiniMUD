package at.redlinghaus;

abstract public class Quest extends Interaction {

    protected boolean isSolved;
    protected Goal goal;
    protected Item reward;

    public void setSolved(boolean solved) {
        isSolved = solved;
    }

    abstract public void accept();

}

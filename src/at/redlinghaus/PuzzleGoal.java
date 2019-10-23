package at.redlinghaus;

public class PuzzleGoal extends Goal {

    private String answerString;
    private int answerInt;

    public PuzzleGoal (String answerString) {
        this.answerString = answerString;
    }

    public PuzzleGoal (int answerInt) {
        this.answerInt = answerInt;
    }

    public String getAnswerString() {
        return answerString;
    }

    public int getAnswerInt() {
        return answerInt;
    }
}

package at.redlinghaus;

public class PuzzleGoal extends Goal {

    private String answerString;
    private int answerInt;
    private String task;

    public PuzzleGoal (String task, String answerString) {
        this.task = task;
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

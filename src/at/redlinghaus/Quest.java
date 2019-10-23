package at.redlinghaus;

public class Quest extends Interaction {

    private boolean isSolved;
    private String goal;
    private Item reward;


    public Quest(String description, Item reward, boolean isSolved) {
        super(description);
        this.reward = reward;
        this.isSolved = false;
    }
}

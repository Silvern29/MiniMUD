package at.redlinghaus;

public abstract class Interaction {
    protected String description;

    public Interaction(){}

    public Interaction(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    abstract public void handleInteraction (Player player);
}

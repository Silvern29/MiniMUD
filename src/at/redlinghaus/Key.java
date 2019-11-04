package at.redlinghaus;

public class Key extends Item {

    public Key(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "Key " + description;
    }
}

package at.redlinghaus;

import java.util.List;

public class Field extends Element {
    public static int nextFieldNum = 0;
    private int fieldNum;
    private String description;

    public Field(String description) {
        super();
        this.description = description;
        fieldNum = nextFieldNum++;
    }

    public Field(String description, Element north, Element east, Element south, Element west) {
        super(north, east, south, west);
        this.description = description;
        fieldNum = nextFieldNum++;
    }

    @Override
    public String getDescription() {
        return "Field " + fieldNum + ", " + description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Interaction> getInteractions() {
        return interactions;
    }

    public void addInteractions(Interaction interaction) {
        this.interactions.add(interaction);
    }

    @Override
    public int getFieldNum() {
        return fieldNum;
    }

    public void setFieldNum(int fieldNum) {
        this.fieldNum = fieldNum;
    }

    @Override
    public void enter(Player p) {
        p.setCurrField(this);
        if (interactions.size() > 0) {
            for (Interaction el : interactions) {
                el.handleInteraction(p, this);
            }
        }
    }

    @Override
    public void enter(Player p, Item item) {
    }


    @Override
    public String toString() {
        return "Field: " + fieldNum + ", " + description;
    }
}

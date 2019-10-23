package at.redlinghaus;

import java.util.LinkedList;
import java.util.List;

public class Field extends Element {
    private LinkedList<Interaction> interactions = new LinkedList<>();
    public static int nextFieldNum = 1;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Interaction> getInteractions() {
        return interactions;
    }

    public void setInteractions(Interaction interaction) {
        this.interactions.add(interaction);
    }

    public int getFieldNum() {
        return fieldNum;
    }

    public void setFieldNum(int fieldNum) {
        this.fieldNum = fieldNum;
    }

    @Override
    public Field enter() {
        return this;
    }
}

package at.redlinghaus;

import java.util.LinkedList;
import java.util.List;

public class Field extends Element {
    private List<Interaction> interactions = new LinkedList<>();
    public static int nextFieldNum = 1;
    private int fieldNum;
    private String description;

    public Field(String description) {
        this.description = description;
        fieldNum = nextFieldNum++;
        this.connect();
    }

    @Override
    public String getDescription() {
        return description;
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
        for (Interaction el : interactions) {
            if (el instanceof Quest) {
                checkQuestStatus((Quest) el, p);
            } else if (el instanceof Item) {
                //bla
            }
        }
    }

    public void checkQuestStatus (Quest quest, Player p) {
        if (!p.isInQuestList(quest)) {
            quest.acceptQuest();
        } else if (p.isInQuestList(quest) && !quest.isSolved) {
            if (quest.isComplete()) {
                quest.solveQuest();
            }
        }
    }

    @Override
    public String toString() {
        return "Field{" +
                "interactions=" + interactions +
                ", fieldNum=" + fieldNum +
                ", description='" + description + '\'' +
                '}';
    }
}

package at.redlinghaus;

import java.util.List;

public class Player {
    private String name;
    private List<Quest> questList;
    private List<PackItem> backPack;
    private Field currField;

    public void move(String direction) {
        switch (direction.toLowerCase()) {
            case "north":
                currField.north.enter();
                break;
            case "east":
                currField.east.enter();
                break;
            case "south":
                currField.south.enter();
                break;
            case "west":
                currField.west.enter();
                break;
            default:
                System.out.println("Please try again");
        }
    }

    public void use() {

    }

    public void acceptQuest() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Quest> getQuestList() {
        return questList;
    }

    public void setQuestList(List<Quest> questList) {
        this.questList = questList;
    }

    public List<PackItem> getBackPack() {
        return backPack;
    }

    public void setBackPack(List<PackItem> backPack) {
        this.backPack = backPack;
    }

    public Field getCurrField() {
        return currField;
    }

    public void setCurrField(Field currField) {
        this.currField = currField;
    }
}
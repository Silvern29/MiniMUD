package at.redlinghaus;

import java.util.LinkedList;
import java.util.List;

public class Player {
    private String name;
    private LinkedList<Quest> questList = new LinkedList<>();
    private LinkedList<PackItem> backPack = new LinkedList<>();
    private Field currField;


    public Player(String name, Field currField) {
        this.name = name;
        this.currField = currField;
    }

    public void move(String direction) {
        switch (direction.toLowerCase()) {
            case "north":
                currField.north.enter(this);
                break;
            case "east":
                currField.east.enter(this);
                break;
            case "south":
                currField.south.enter(this);
                break;
            case "west":
                currField.west.enter(this);
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

    public LinkedList<Quest> getQuestList() {
        return questList;
    }

    public void addQuestList(Quest quest) {
        this.questList.add(quest);
    }

    public void removeQuestList(Quest quest) {
        this.questList.remove(quest);
    }

    public LinkedList<PackItem> getBackPack() {
        return backPack;
    }

    public PackItem isInPack(Item item) {
        for (PackItem el : backPack) {
            if (el.getPackedItem() == item) {
                return el;
            }
        }
        return null;
    }

    public void addBackPack(Item item, int amount) {
        PackItem tmp = isInPack(item);
        if (tmp != null) {
            tmp.setAmount(tmp.getAmount() + amount);
        } else {
            this.backPack.add(new PackItem(item, amount));
        }
    }

    public void removeBackPack (PackItem item) {
        this.backPack.remove(item);
    }

    public Field getCurrField() {
        return currField;
    }

    public void setCurrField(Field currField) {
        this.currField = currField;
    }
}

package at.redlinghaus;

import java.util.LinkedList;

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

    public void acceptQuest(Quest quest) {
        addQuestList(quest);
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

    public boolean isInQuestList(Quest quest) {
        boolean existing = false;
        for (Quest quest1 : getQuestList()) {
            if (quest1 == quest) {
                existing = true;
            }
        }
        return existing;
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

    public PackItem addBackPack(Item item, int amount) {
        PackItem tmp = isInPack(item);
        if (tmp != null) {
            tmp.setAmount(tmp.getAmount() + amount);
        } else {
            tmp = new PackItem(item, amount);
            this.backPack.add(tmp);
        }
        return tmp;
    }


/*    public void removeBackPack (PackItem item) {
        this.backPack.remove(item);
    }*/

    public void removeBackPack (Item item, int amount) {
        PackItem tmp = isInPack(item);
        if (tmp != null && tmp.getAmount() > amount) {
            tmp.setAmount(tmp.getAmount() - amount);
        } else if (tmp != null && tmp.getAmount() == amount) {
            tmp.setAmount(0);
            this.backPack.remove(tmp);
        }
    }


    public Field getCurrField() {
        return currField;
    }

    public void setCurrField(Field currField) {
        this.currField = currField;
    }
}

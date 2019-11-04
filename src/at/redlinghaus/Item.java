package at.redlinghaus;

import java.util.Scanner;

public abstract class Item extends Interaction {

    protected Player p;
    protected Scanner sc = new Scanner(System.in);

    public Item(String description) {
        super(description);
    }

    @Override
    public void handleInteraction(Player p, Field field) {
        System.out.printf("You found %s. Do you want to pick it up and add it to your backpack?\ny/n\n", this.toString());
        String inputPlayer = sc.nextLine();
        switch (inputPlayer.toLowerCase()) {
            case "y":
                p.addBackPack(this, 1);
                System.out.println("Item added to your backpack.");
                field.interactions.remove(this);
                break;
            case "n":
                System.out.println("Item was not picked up.");
                break;
            default:
                System.out.println("Invalid answer.");
        }
    }

    @Override
    public String toString() {
        return description + "";
    }
}


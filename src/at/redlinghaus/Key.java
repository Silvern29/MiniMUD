package at.redlinghaus;

import java.util.Scanner;

public class Key extends Item {

    private Scanner sc = new Scanner(System.in);

    public Key(String description) {
        super(description);
    }

    @Override
    void pickUpItem(Player player) {
        String inputPlayer = sc.nextLine();
        System.out.println("You found a key. Do you want to pick it up and add it to your backpack?\ny/n");
        switch (inputPlayer.toLowerCase()) {
            case "y":
                player.addBackPack(this, 1);
                System.out.println("Item added to your backpack.");
                break;
            case "n":
                System.out.println("Item was not picked up.");
                break;
            default:
                System.out.println("Invalid answer.");
        }
    }

}

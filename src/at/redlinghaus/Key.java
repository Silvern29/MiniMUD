package at.redlinghaus;

import java.util.Scanner;

public class Key extends Item {

    private Scanner sc = new Scanner(System.in);

    public Key(String description) {
        super(description);
    }

    @Override
    public void handleInteraction(Player p) {
        super.handleInteraction(p);
    }
}

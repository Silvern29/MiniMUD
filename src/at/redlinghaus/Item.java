package at.redlinghaus;

public abstract class Item extends Interaction {


    public Item(String description) {
        super(description);
    }


    abstract void pickUpItem (Player p);

    @Override
    public void handleInteraction(Player p) {

    }

}

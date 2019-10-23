package at.redlinghaus;

public class Wall extends Element{

    @Override
    public void enter(Player p) {
        System.out.println("Ouch! This is a wall!");
    }
}

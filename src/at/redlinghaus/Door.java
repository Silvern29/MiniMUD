package at.redlinghaus;

public class Door extends Field {
    private boolean isOpen;

    public Door(Element north, Element east, Element south, Element west) {
        super(north, east, south, west);
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    @Override
    public void enter() {

    }
}

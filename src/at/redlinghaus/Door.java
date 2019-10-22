package at.redlinghaus;

public class Door extends Field {
    private boolean isOpen;

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

package at.redlinghaus;

public class Door extends Element {
    private boolean isOpen;

    public Door(boolean isOpen){
        this.isOpen = isOpen;
    }

    public Field nextField(Field currField){
        if(currField.equals(north)){
            return (Field) south;
        } else if(currField.equals(east)){
            return (Field) west;
        } else if(currField.equals(south)){
            return (Field) north;
        } else {
            return (Field) east;
        }
    }

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
    public void enter(Player p) {
        p.setCurrField(this.nextField(p.getCurrField()));
    }
}

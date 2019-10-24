package at.redlinghaus;

public class Door extends Element {
    private boolean isOpen;
    public String description;

    public Door(boolean isOpen){
        super();
        this.isOpen = isOpen;
    }

    public Door(boolean isOpen, Element north, Element east, Element south, Element west) {
        super(north, east, south, west);
        this.isOpen = isOpen;
    }

    @Override
    public String getDescription(){
        description = String.format("Door between field %d and field %d", oppositeField(firstNotNull()).getFieldNum(), firstNotNull().getFieldNum());
        return description;
    }

//    @Override
//    public String getDescription(Element el){
//        description = String.format("Door to field %d", oppositeField(el).getFieldNum());
//        return description;
//    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    @Override
    public void enter(Player p) {
        p.setCurrField(this.oppositeField(p.getCurrField()));
    }

    @Override
    public String toString() {
        return "Door to field " +
                "isOpen=" + isOpen +
                '}';
    }
}

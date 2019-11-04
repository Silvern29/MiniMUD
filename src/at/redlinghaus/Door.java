package at.redlinghaus;

public class Door extends Element {
    private boolean isOpen;
    private String description;
    private Key key;

    public Door(boolean isOpen, Key key) {
        super();
        this.isOpen = isOpen;
        this.key = key;
    }

    @Override
    public String getDescription() {
        if (oppositeField(firstNotNull()) == null) {
            description = String.format("Entrance door");
            return description;
        }
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
        if (isOpen) {
            p.setCurrField(this.oppositeField(p.getCurrField()));
        } else {
            System.out.println(">>> This door is locked! <<<");
        }
    }

    @Override
    public void enter(Player p, Item item) {
        if (isOpen) {
            System.out.println(">>> This door is already unlocked! <<<");
        } else {
            if (item == key) {
                isOpen = true;
                System.out.println("Door unlocked.");
            } else {
                System.out.println("The key does not match. Find the right one!");
            }
        }
    }

    @Override
    public String toString() {
        return "Door to field " +
                "isOpen=" + isOpen +
                '}';
    }
}

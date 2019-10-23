package at.redlinghaus;

abstract public class Element {
    Element north, east, south, west;

    public Element(){
    }

    public Element(Element north, Element east, Element south, Element west){
        this.north = north;
        this.east = east;
        this.south = south;
        this.west = west;
    }

    public Element firstNotNull(){
        if (this.north != null){
            return north;
        } else if(this.east != null){
            return east;
        } else if(this.south != null){
            return south;
        } else if (this.west != null){
            return west;
        } return null;
    }

    public void connect() {
        if (firstNotNull() != null) {
            if (firstNotNull() == north) {
                this.east = north.east.south;
            } else if (firstNotNull() == east) {
                this.south = east.south.west;
            } else if (firstNotNull() == south) {
                this.west = south.west.north;
            } else if (firstNotNull() == west) {
                this.north = west.north.east;
            }
        }
    }

    public void addNorth(Element north){
        this.north = north;
        north.south = this;
    }

    public void addEast(Element east){
        this.east = east;
        east.setWest(this);
    }

    public void addSouth(Element south){
        this.south = south;
        south.north = this;
    }

    public void addWest(Element west){
        this.west = west;
        west.east = this;
    }

    abstract public void enter(Player p );

    public Element getNorth() {
        return north;
    }

    public void setNorth(Element north) {
        this.north = north;
    }

    public Element getEast() {
        return east;
    }

    public void setEast(Element east) {
        this.east = east;
    }

    public Element getSouth() {
        return south;
    }

    public void setSouth(Element south) {
        this.south = south;
    }

    public Element getWest() {
        return west;
    }

    public void setWest(Element west) {
        this.west = west;
    }

    public int getFieldNum() {
        return 0;
    }

    public String getDescription() {
        return "";
    }


}

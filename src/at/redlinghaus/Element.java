package at.redlinghaus;

abstract public class Element {
    protected Element north, east, south, west;

    public Element(){
    }

    public Element(Element north, Element east, Element south, Element west){
        this.north = north;
        this.east = east;
        this.south = south;
        this.west = west;
    }

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

    public void addNorth(Element north){
        this.north = north;
        north.south = this;
    }

    public void addEast(Element east){
        this.east = east;
        east.west = this;
    }

    public void addSouth(Element south){
        this.south = south;
        south.north = this;
    }

    public void addWest(Element west){
        this.west = west;
        west.east = this;
    }

    abstract public Field enter();
}

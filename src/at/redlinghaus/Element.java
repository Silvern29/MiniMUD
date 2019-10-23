package at.redlinghaus;

abstract public class Element {
    protected Element north, east, south, west;

    public Element(Element north, Element east, Element south, Element west){
        this.north = north;
        this.east = east;
        this.south = south;
        this.west = west;
    }

    abstract public void enter();
}

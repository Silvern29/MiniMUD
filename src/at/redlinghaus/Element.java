package at.redlinghaus;

import java.util.LinkedList;
import java.util.List;

abstract public class Element {
    Element north, east, south, west;
    String description;
    protected List<Interaction> interactions = new LinkedList<>();


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

    /*public void connect() {
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
*/
    public String getDescription(){
        return description;
    }

    public String getDescription(Element el){
        return description;
    }

    public Element oppositeField(Element currField){
        if(currField.equals(north)){
            return south;
        } else if(currField.equals(east)){
            return west;
        } else if(currField.equals(south)){
            return north;
        } else {
            return east;
        }
    }

    public void connect(Element north, Element east, Element south, Element west){
        this.addNorth(north);
        this.addEast(east);
        this.addSouth(south);
        this.addWest(west);
    }

    public void addNorth(Element north){
        this.north = north;
        if (north != null){
            north.south = this;
        }
    }

    public void addEast(Element east){
        this.east = east;
        if (east != null){
            east.setWest(this);
        }
    }

    public void addSouth(Element south){
        this.south = south;
        if (south != null){
            south.north = this;
        }
    }

    public void addWest(Element west){
        this.west = west;
        if (west != null){
            west.east = this;
        }
    }

    abstract public void enter(Player p );
    abstract public void enter(Player p, Item item);

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

    public List<Interaction> getInteractions() {
        return interactions;
    }


}

package at.redlinghaus;

import java.util.List;

abstract public class Field extends Element {
    protected List interactions;

    public Field(Element north, Element east, Element south, Element west) {
        super(north, east, south, west);
    }
}

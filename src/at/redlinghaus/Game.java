package at.redlinghaus;

public class Game {
    Element field1 = new Field("Start");
    Element field2 = new Field("Start");
    Element field3 = new Field("Start");
    Element field4 = new Field("Start");

    public void createDungeon(){
        field1.addEast(field2);
        field1.addSouth(field3);
        field3.addEast(field4);
    }
}

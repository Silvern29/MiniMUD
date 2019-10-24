package at.redlinghaus;

import java.util.LinkedList;
import java.util.List;

public class DungeonMap {
    List<Element> listOfElments = new LinkedList<>();

    Field field1;
    Field field2;
    Field field3;
    Field field4;
    Wall wall1;
    Wall wall2;
    Wall wall3;
    Wall wall4;
    Wall wall5;
    Wall wall6;
    Wall wall7;
    Wall wall8;

    public DungeonMap(){
        field1 = createField("Start");
        field2 = createField("Start");
        field3 = createField("Start");
        field4 = createField("Start");
        wall1 = createWall();
        wall2 = createWall();
        wall3 = createWall();
        wall4 = createWall();
        wall5 = createWall();
        wall6 = createWall();
        wall7 = createWall();
        wall8 = createWall();
        connectAll();

    }

    public Field createField(String description) {
        Field tmp = new Field(description);
        listOfElments.add(tmp);
        return tmp;
    }

    public Wall createWall() {
        Wall tmp = new Wall();
        listOfElments.add(tmp);
        return tmp;
    }

    public void connectAll(){
        for(Element el : listOfElments) {
            el.connect();
        }
    }

    private void createStart(){
        field1.addEast(field2);
        field2.addEast(field3);
        field3.addEast(field4);
        field1.addNorth(wall1);
        wall1.addEast(wall2);
        wall2.addEast(wall3);
        wall3.addEast(wall4);
        field1.addSouth(wall5);
        wall5.addEast(wall6);
        wall6.addEast(wall7);
        wall7.addEast(wall8);
    }
    public void createDungeon(){
        createStart();

    }
}

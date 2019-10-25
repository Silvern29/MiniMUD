package at.redlinghaus;

import java.util.LinkedList;
import java.util.List;

public class DungeonMap {
    List<Element> listOfElements = new LinkedList<>();

    Field field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15, field16, field17, field18, field19, field20, field21, field22, field23, field24;
    Door entry, door1, door2, door3;
    Key entryKey, key1, key2;

    public DungeonMap() {
        createMap();
        connectMap();
        createKeys();
    }

    public Door createDoor(boolean isOpen, Key key) {
        Door tmp = new Door(isOpen, new Key("1234"));
        listOfElements.add(tmp);
        return tmp;
    }

    public Field createField(String description) {
        Field tmp = new Field(description);
        listOfElements.add(tmp);
        return tmp;
    }

    public void createKeys() {
        entryKey = new Key("456");
        key1 = new Key("123");
        field6.interactions.add(key1);
        key2 = new Key("789");
    }

    public void createMap() {
        entry = createDoor(false, entryKey);
        field1 = createField("Entrance");
        field2 = createField("Entrance");
        field3 = createField("Entrance");
        field4 = createField("Entrance");
        field5 = createField("Entrance");
        field6 = createField("Entrance");
        door1 = createDoor(false, key1);


        field7 = createField("Hallway");
        field8 = createField("Hallway");
        field9 = createField("Hallway");
        door2 = createDoor(false, key2);

        field10 = createField("Room");
        field11 = createField("Room");

        field12 = createField("Hallway");
        field13 = createField("Hallway");
        field14 = createField("Hallway");
        door3 = createDoor(true, null);

        field15 = createField("Patio");
        field16 = createField("Patio");
        field17 = createField("Patio");
        field18 = createField("Patio");

        field19 = createField("Hallway");
        field20 = createField("Hallway");

        field21 = createField("Hall");
        field22 = createField("Hall");
        field23 = createField("Hall");
        field24 = createField("Hall");
    }

    public void connectMap() {
        field1.connect(null, field2, field3, null);
        field2.connect(null, door1, field4, field1);
        field3.connect(field1, field4, field5, null);
        field4.connect(field2, null, field6, field3);
        field5.connect(field3, field6, null, null);
        field6.connect(field4, null, null, field5);

        field7.connect(null, field8, null, door1);
        field8.connect(null, field9, null, field7);
        field9.connect(null, door2, null, field8);

        field10.connect(null, field11, null, door2);
        field11.connect(null, null, null, field10);

        field12.connect(field9, null, field13, null);
        field13.connect(field12, null, field14, null);
        field14.connect(field13, door3, field13, null);

        field15.connect(null, field16, field17, door3);
        field16.connect(null, null, field18, field15);
        field17.connect(field15, field18, null, null);
        field18.connect(field16, null, null, field17);

        field19.connect(field14, null, field20, null);
        field20.connect(field19, null, field22, null);

        field21.connect(null, field22, field23, null);
        field22.connect(field20, null, field24, field21);
        field23.connect(field21, field24, null, null);
        field24.connect(field22, null, null, field23);
    }
}

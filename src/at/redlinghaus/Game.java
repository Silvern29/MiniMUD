package at.redlinghaus;

public class Game {
    Field field1 = new Field("Start");
    Field field2 = new Field("Start");
    Field field3 = new Field("Start");
    Field field4 = new Field("Start");

    public void createDungeon(){
        field1.addEast(field2);
        field1.addSouth(field3);
        field3.addEast(field4);
    }

    public void playGame () {

        Player player = new Player("Dummy", field1);
        Quest1 quest1 = new Quest1();
        quest1.solveQuest();

    }








}

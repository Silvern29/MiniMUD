package at.redlinghaus;

public class Game {
    DungeonMap dung;
    Printer myPrint;

    public Game(){
        dung = new DungeonMap();
        myPrint = new Printer(this);

    }

    public void playGame () {
        Player player1 = new Player("Dummy", dung.field1);
        myPrint.printCurrField(player1);
        Interaction quest1 = new Quest1(player1);
        dung.field4.addInteractions(quest1);
        myPrint.printElements();

    }








}

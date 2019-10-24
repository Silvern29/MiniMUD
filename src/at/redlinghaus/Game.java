package at.redlinghaus;

public class Game {
    DungeonMap dung;
    Printer myPrint;

    public Game(){
        dung = new DungeonMap();
        myPrint = new Printer(this);

    }

    public void playGame () {
        Player player1 = new Player("Dummy", dung.field2);
        Quest quest1 = new Quest1(player1);
        dung.field4.addInteractions(quest1);
//        quest1.solveQuest();
        myPrint.printCurrField(player1);
        myPrint.printElements();
    }
}

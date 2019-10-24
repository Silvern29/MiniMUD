package at.redlinghaus;

public class Game {
    DungeonMap dung;
    Printer myPrint;
    boolean playing = true;

    public Game(){
        dung = new DungeonMap();
        myPrint = new Printer(this);

    }

    public void playGame () {
        Player player1 = new Player("Dummy", dung.field1);
        myPrint.printCurrField(player1);
        setQuests(player1);

        while (playing) {
            turn(player1);
        }


//        myPrint.printElements();

    }

    public void setQuests(Player player){
        Interaction quest1 = new Quest1(player);
        dung.field4.addInteractions(quest1);
    }

    public void turn(Player player){
        myPrint.printCurrField(player);

    }








}

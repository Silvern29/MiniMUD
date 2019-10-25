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
        Interaction quest1 = new Quest1(player, dung); //create as Quest??
        dung.field11.addInteractions(quest1);

        Interaction quest2 = new Quest2(player, dung);
        dung.field16.addInteractions(quest1);

    }

    public void turn(Player player){
        myPrint.printCurrField(player);

    }








}

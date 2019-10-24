package at.redlinghaus;

public class Game {
    private void createStart(){
        Field field1 = new Field("Start");
        Field field2 = new Field("Start");
        Field field3 = new Field("Start");
        Field field4 = new Field("Start");
    }
    public void createDungeon(){



        System.out.println(field1);
        System.out.println(field2);
        System.out.println(field3);
        System.out.println(field4);
    }

    public void playGame () {


        Player player1 = new Player("Dummy", field1);
        Quest1 quest1 = new Quest1(player1);
        field4.addInteractions(quest1);
        quest1.solveQuest();

    }








}

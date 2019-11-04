package at.redlinghaus;

import java.util.Scanner;

public class Game {
    DungeonMap dung;
    Printer myPrint;
    boolean playing;
    Scanner sc = new Scanner(System.in);

    public Game() {
        dung = new DungeonMap();
        myPrint = new Printer(this);
    }

    public void playGame() {
        playing = true;
        Player player1 = new Player("Dummy", dung.field1);
        setQuests(player1);
        System.out.println("Try to find the key and escape the dungeon!");
        myPrint.printCurrField(player1);
        while (playing) {
            if (player1.getCurrField() == dung.field0) {
                System.out.println("\nCongratulations. You escaped the dungeon.");
                playing = false;
            } else {
                turn(player1);
            }
        }
//        myPrint.printElements();
    }

    public void setQuests(Player player) {
        Interaction quest1 = new Quest1(player, dung); //create as Quest??
        dung.field11.addInteractions(quest1);

        Interaction quest2 = new Quest2(player, dung);
        dung.field16.addInteractions(quest2);

    }

    public void turn(Player player) {
        int oldField = player.getCurrField().getFieldNum();
        System.out.print("Enter the command: ");
        boolean validInput = false;
        String input = "";
        while (!validInput) {
            input = sc.nextLine().toLowerCase();
            validInput = input.equals("w") || input.equals("a") || input.equals("s") || input.equals("d") || input.equals("u") || input.equals("k") || input.equals("b") || input.equals("q");
        }

        if (input.equals("w") || input.equals("a") || input.equals("s") || input.equals("d")) {
            player.move(input);
        } else if (input.equals("b")) {
            if (player.getBackPack().size() == 0) {
                System.out.println("Your backpack is empty!");
            } else {
                myPrint.printBackPack(player);
            }
        } else if (input.equals("k")) {
            myPrint.printQuests(player);
        } else if (input.equals("u")) {
            if (player.getBackPack().size() == 0) {
                System.out.println("You do not have anything to use!");
            } else {
                boolean validIndex = false;
                boolean validDirection = false;
                System.out.println("Please choose an item: ");
                myPrint.printBackPack(player);

                int index = -1;
                while (!validIndex) {
                    try {
                        index = sc.nextInt();
                        validIndex = player.getBackPack().get(index) != null;
                    } catch(Exception e) {
                        System.out.println("Please only integers!");
                    }
                    sc.nextLine();
                }

                System.out.println("Please choose a direction to use the item: ");
                String direction = "";
                while (!validDirection) {
                    direction = sc.nextLine();
                    validDirection = direction.equals("w") || direction.equals("a") || direction.equals("s") || direction.equals("d");
                }

                player.use(player.getBackPack().get(index).getPackedItem(), direction);
            }

        } else if (input.equals("q")) {
            System.exit(0);
        }

        if (player.getCurrField().getFieldNum() != oldField) {
            myPrint.printCurrField(player);
        }
    }


}

package at.redlinghaus;

public class Printer {
    Game game;

    public Printer(Game game){
        this.game = game;
    }

    public void printCurrField(Player p){
        System.out.println("-------------------------------------------------------");
        System.out.printf("Field %d%n", p.getCurrField().getFieldNum());
        System.out.printf("Description: %s%n", p.getCurrField().getDescription());

        System.out.printf("North: %s%n", p.getCurrField().getNorth());
        System.out.printf("East: %s%n", p.getCurrField().getEast());
        System.out.printf("South: %s%n", p.getCurrField().getSouth());
        System.out.printf("West: %s%n", p.getCurrField().getWest());
    }

    public void printField(Element el){
        System.out.println("-------------------------------------------------------");
        System.out.printf("Field %d%n", el.getFieldNum());
        System.out.printf("Description: %s%n", el.getDescription());

        System.out.printf("North: %s%n", el.getNorth());
        System.out.printf("East: %s%n", el.getEast());
        System.out.printf("South: %s%n", el.getSouth());
        System.out.printf("West: %s%n", el.getWest());
    }

    public void printElements(){
        for(Element el : game.dung.listOfElments){
            printField(el);
        }
    }
}

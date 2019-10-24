package at.redlinghaus;

public class Printer {
    Game game;

    public Printer(Game game){
        this.game = game;
    }

    public void printCurrField(Player p){
        System.out.println("-------------------------------------------------------");
        System.out.printf("%s%n%n", callFieldDescription(p.getCurrField()));
        System.out.printf("Quest/Items: %s%n%n", printInteractions(p.getCurrField()));

        System.out.printf("North: %s%n", callFieldDescription(p.getCurrField().getNorth()));
        System.out.printf("East: %s%n", callFieldDescription(p.getCurrField().getEast()));
        System.out.printf("South: %s%n", callFieldDescription(p.getCurrField().getSouth()));
        System.out.printf("West: %s%n", callFieldDescription(p.getCurrField().getWest()));
    }

    public void printField(Element el){
        System.out.println("-------------------------------------------------------");
        System.out.printf("%s%n", callFieldDescription(el));

        System.out.printf("North: %s%n", callFieldDescription(el.getNorth()));
        System.out.printf("East: %s%n", callFieldDescription(el.getEast()));
        System.out.printf("South: %s%n", callFieldDescription(el.getSouth()));
        System.out.printf("West: %s%n", callFieldDescription(el.getWest()));
    }

    public void printElements(){
        for(Element el : game.dung.listOfElements){
            printField(el);
        }
    }

    public String printInteractions(Element el) {
        String output = "";
        for(Interaction i : el.getInteractions()) {
            output += i.getDescription() + ", ";
        }
        return output;
    }

//    private String callFieldDescription(Door el) {
//        if (el != null) {
//            return el.getDescription(el);
//        } else {
//            return "Wall";
//        }
//    }

    private String callFieldDescription(Element el) {
        if (el != null) {
            return el.getDescription();
        } else {
            return "Wall";
        }
    }
}

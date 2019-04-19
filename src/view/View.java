package view;

import model.*;

public class View {
    private static final View VIEW = new View();

    private View() {
    }

    public static View getInstance() {
        return VIEW;
    }

    public void printError(ErrorType error) {
        if (error == null) return;
        System.out.println(error.getMessage());
    }

    public void printLeaderBoard() {
        for (int i = 0; i < Account.getAllUser().size(); i++) {
            System.out.println((i + 1) + "- UserName : " + Account.getAllUser().get(i).getUserName() + "- Wins : " + Account.getAllUser().get(i).getWins());
        }
    }

    public void printDeckValidation(){
        System.out.println("The deck is valid");
    }

    public void printObjectId(int id){
        System.out.println(id);
    }

    public void showCollection(Collection collection){
        int index = 1;
        for (Hero hero: collection.getHeroes()) {
            System.out.println(index + " : " + hero.showDetails());
            index++;
        }
        index = 1;
        for (Item item: collection.getItems()) {
            System.out.println(index + " : " + item.showDetails());
            index++;
        }
        index = 1;
        for (Spell spell: collection.getSpells()) {
            System.out.println(index + " : " + spell.showDetails());
            index++;
        }
        for (Minion minion: collection.getMinions()) {
            System.out.println(index + " : " + minion.showDetails());
            index++;
        }
    }

    public void printDeckDetails (Deck deck){
        //todo check method name
        System.out.println("Hereos :\n\t1 : " + deck.getHero().showDetails());
        System.out.println("Items :\n\t1 : " + deck.getItem().showDetails());
        System.out.println("Cards :\n");
        int index = 1;
        for (Spell spell : deck.getSpells()) {
            System.out.println("\t"+ index + spell.showDetails());
            index++;
        }
        for (Minion minion : deck.getMinions()) {
            System.out.println("\t" + index + minion.showDetails());
            index++;
        }
    }
}

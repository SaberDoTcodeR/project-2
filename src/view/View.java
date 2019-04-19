package view;

import model.*;

import java.util.ArrayList;
import java.util.Arrays;

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

    public void printDeckValidation(String name) {
        System.out.println(name + " is a valid deck.");
    }

    public void printObjectId(ArrayList<Integer> id) {
        for (int i = 0; i < id.size(); i++) {
            System.out.println(id.get(i));
        }
    }

    public void showCollection(Collection collection) {
        int index = 1;
        System.out.println("Heroes :\n\t");
        for (Hero hero : collection.getHeroes()) {
            System.out.println(index + " : " + hero.showDetails());
            index++;
        }
        index = 1;
        System.out.println("Items :\n\t");
        for (Item item : collection.getItems()) {
            System.out.println(index + " : " + item.showDetails());
            index++;
        }
        index = 1;
        System.out.println("Cards :\n\t");
        for (Spell spell : collection.getSpells()) {
            System.out.println(index + " : " + spell.showDetails());
            index++;
        }
        for (Minion minion : collection.getMinions()) {
            System.out.println(index + " : " + minion.showDetails());
            index++;
        }
    }

    public void printDeckDetails(Deck deck) {
        System.out.println("Heroes :\n\t1 : " + deck.getHero().showDetails());
        System.out.println("Items :\n\t1 : " + deck.getItem().showDetails());
        System.out.println("Cards :\n");
        int index = 1;
        for (Spell spell : deck.getSpells()) {
            System.out.println("\t" + index + spell.showDetails());
            index++;
        }
        for (Minion minion : deck.getMinions()) {
            System.out.println("\t" + index + minion.showDetails());
            index++;
        }
    }

    public void showCollectionMenu() {
        String helpstr = "1 : Exit\n" +
                "2 : Show\n" +
                "3 : Search\n" +
                "4 : Save\n" +
                "5 : Create Deck\n" +
                "6 : Delete Deck\n" +
                "7 : Add Card To Deck\n" +
                "8 : Remove Card From Deck\n" +
                "9 : Validate Deck\n" +
                "10 : Select Deck\n" +
                "11 : Show All Decks\n" +
                "12 : Show Deck\n" +
                "13 : Help";
        System.out.println(helpstr);
    }

}

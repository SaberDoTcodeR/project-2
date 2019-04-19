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
    public void showShop(){
        int index=1;
        System.out.println("Heroes :");
        for (Hero hero:Hero.getHeroes()){
            String heroInfo=hero.showDetails();
            System.out.print(index+" : ");
            System.out.println(heroInfo);
            index++;
        }index=1;
        System.out.println("Items :");
        for (Item item:Item.getItems()){
            String itemInfo=item.showDetails();
            System.out.print(index+" : ");
            System.out.println(itemInfo);
            index++;
        }
        index=1;
        System.out.println("Cards :");
        for (Minion minion:Minion.getMinions()){
            String minionInfo=minion.showDetails();
            System.out.print(index+" : ");
            System.out.println(minionInfo);
            index++;
        }
        for (Spell spell:Spell.getSpells()){
            String spellInfo=spell.showDetails();
            System.out.print(index+" : ");
            System.out.println(spellInfo);
            index++;
        }
    }
    public void printDeckDetails (Deck deck){
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
    public void showAccountMenu(){
        String helpstr = "1 : create account [your username]\n" +
                "2 : login [your username]\n" +
                "3 : show leaderboard\n" +
                "4 : Search Collection\n" +
                "5 : save\n" +
                "6 : Sell\n" +
                "7 : logout\n" +
                "8 : help";
        System.out.println(helpstr);
    }
    public void showMainMenu(){
        String helpstr = "1 : Collection\n" +
                "2 : Shop\n" +
                "3 : Battle\n" +
                "4 : Exit\n" +
                "5 : Help";
        System.out.println(helpstr);
    }
    public void showShopMenu(){
        String helpstr = "1 : Exit\n" +
                "2 : Show Collection\n" +
                "3 : Search\n" +
                "4 : Search Collection\n" +
                "5 : Buy\n" +
                "6 : Sell\n" +
                "7 : Show\n" +
                "8 : Help";
        System.out.println(helpstr);
    }
}

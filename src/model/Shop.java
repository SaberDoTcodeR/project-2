package model;

import java.util.ArrayList;

public class Shop {

    public int searchOfShop (String objectName){
        for (Hero hero : Hero.getHeroes()) {
            if (hero.getName().equals(objectName)){
                return 1;
            }
        }
        for (Spell spell : Spell.getSpells()) {
            if (spell.getName().equals(objectName)){
                return 1;
            }
        }
        for (Minion minion : Minion.getMinions()) {
            if (minion.getName().equals(objectName)){
                return 1;
            }
        }
        for (Item item : Item.getItems()) {
            if (item.getName().equals(objectName)){
                return 1;
            }
        }
        return 0;
    }
    public boolean hasThisCard(String objectName) {
        for (Hero hero : Hero.getHeroes()) {
            if (hero.getName().equals(objectName)) {
                return true;
            }
        }
        for (Spell spell : Spell.getSpells()) {
            if (spell.getName().equals(objectName)) {
                return true;
            }
        }
        for (Minion minion : Minion.getMinions()) {
            if (minion.getName().equals(objectName)) {
                return true;
            }
        }
        for (Item item : Item.getItems()) {
            if (item.getName().equals(objectName)) {
                return true;
            }
        }
        return false;
    }
    public int costOfCard (String name) {
        for (Hero hero:Hero.getHeroes()) {
            if (hero.getName().equals(name))
                return hero.getCostOfBuy();
        }
        for (Minion minion:Minion.getMinions()){
            if (minion.getName().equals(name))
                return minion.getCostOfBuy();
        }
        for (Spell spell:Spell.getSpells()){
            if (spell.getName().equals(name))
                return spell.getCostOfBuy();
        }
        for (Item item:Item.getItems()){
            if (item.getName().equals(name))
                return item.getCostOfBuy();
        }
        return 0;
    }

}

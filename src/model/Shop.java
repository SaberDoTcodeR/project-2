package model;

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
}

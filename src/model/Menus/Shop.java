package model.Menus;

import model.Cards.Hero.Hero;
import model.Cards.Minion.Minion;
import model.Cards.Spell.Spell;
import model.Item.UsableItem.UsableItem;

public class Shop {

    public int searchOfShop(String objectName) {
        for (Hero hero : Hero.getHeroes()) {
            if (hero.getName().equals(objectName)) {
                return 1;
            }
        }
        for (Spell spell : Spell.getSpells()) {
            if (spell.getName().equals(objectName)) {
                return 1;
            }
        }
        for (Minion minion : Minion.getMinions()) {
            if (minion.getName().equals(objectName)) {
                return 1;
            }
        }
        for (UsableItem usableItem : UsableItem.getUsableItems()) {
            if (usableItem.getName().equals(objectName)) {
                return 1;
            }
        }
        return 0;
    }

    public boolean hasThisCard(String objectName) {
        for (Hero hero : Hero.getHeroes()) {
            if (hero.getName().toLowerCase().equals(objectName)) {
                return true;
            }
        }
        for (Spell spell : Spell.getSpells()) {
            if (spell.getName().toLowerCase().equals(objectName)) {
                return true;
            }
        }
        for (Minion minion : Minion.getMinions()) {
            if (minion.getName().toLowerCase().equals(objectName)) {

                return true;

            }
        }
        for (UsableItem usableItem : UsableItem.getUsableItems()) {
            if (usableItem.getName().toLowerCase().equals(objectName)) {
                return true;
            }
        }
        return false;
    }

    public int costOfCard(String name) {
        for (Hero hero : Hero.getHeroes()) {
            if (hero.getName().equals(name))
                return hero.getCostOfBuy();
        }
        for (Minion minion : Minion.getMinions()) {
            if (minion.getName().equals(name))
                return minion.getCostOfBuy();
        }
        for (Spell spell : Spell.getSpells()) {
            if (spell.getName().equals(name))
                return spell.getCostOfBuy();
        }
        for (UsableItem usableItem : UsableItem.getUsableItems()) {
            if (usableItem.getName().equals(name))
                return usableItem.getCostOfBuy();
        }
        return 0;
    }

}

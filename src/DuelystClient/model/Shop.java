package DuelystClient.model;

import DuelystClient.model.Card.Hero.Hero;
import DuelystClient.model.Card.Minion.Minion;
import DuelystClient.model.Card.Spell.Spell;
import DuelystClient.model.Item.UsableItem.UsableItem;

public class Shop {

    public int costOfCard2(String name) {

        if (Hero.getHeroesName().containsKey(name)){
            return Hero.getHeroesName().get(name);
        } else if (Minion.getMinionsName().containsKey(name)){
            return Minion.getMinionsName().get(name);
        } else if (Spell.getSpellsName().containsKey(name)){
            return Spell.getSpellsName().get(name);
        } else return UsableItem.getUsableItemsName().getOrDefault(name, 0);
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

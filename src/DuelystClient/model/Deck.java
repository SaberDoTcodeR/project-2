package DuelystClient.model;

import DuelystClient.model.Card.Hero.Hero;
import DuelystClient.model.Card.Minion.Minion;
import DuelystClient.model.Card.Spell.Spell;
import DuelystClient.model.Item.UsableItem.UsableItem;

import java.util.ArrayList;

public class Deck {

    private String name;
    private ArrayList<Hero> heroes = new ArrayList<>();
    private ArrayList<UsableItem> usableItems = new ArrayList<>();
    private ArrayList<Spell> spells = new ArrayList<>();
    private ArrayList<Minion> minions = new ArrayList<>();

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public ArrayList<UsableItem> getUsableItems() {
        return usableItems;
    }

    public void setHeroes(ArrayList<Hero> heroes) {
        this.heroes = heroes;
    }

    public void setUsableItems(ArrayList<UsableItem> usableItems) {
        this.usableItems = usableItems;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Hero> getHero() {
        return heroes;
    }

    public void setHero(ArrayList<Hero> heroes) {
        this.heroes = heroes;
    }

    public ArrayList<Spell> getSpells() {
        return spells;
    }

    public Deck duplicate() {
        Deck deck = new Deck();
        deck.setName(this.name);
        ArrayList<Hero> hero = new ArrayList<>();
        ArrayList<UsableItem> usableItem = new ArrayList<>();
        for (Hero hero1 : this.heroes) {
            hero.add(hero1.duplicate());
        }
        for (UsableItem usableItem1 : this.usableItems) {
            usableItem.add(usableItem1.duplicate());
        }
        ArrayList<Minion> minions = new ArrayList<>();
        ArrayList<Spell> spells = new ArrayList<>();
        for (Minion minion : this.minions) {
            minions.add(minion.duplicate());
        }
        for (Spell spell : this.spells) {
            spells.add(spell.duplicate());
        }
        deck.setHero(hero);
        deck.setUsableItem(usableItem);
        deck.setMinions(minions);
        deck.setSpells(spells);
        return deck;
    }

    public void setSpells(ArrayList<Spell> spells) {
        this.spells = spells;
    }

    public ArrayList<UsableItem>  getUsableItem() {
        return usableItems;
    }

    public void setUsableItem(ArrayList<UsableItem>  usableItem) {
        this.usableItems = usableItem;
    }

    public ArrayList<Minion> getMinions() {
        return minions;
    }

    public void setMinions(ArrayList<Minion> minions) {
        this.minions = minions;
    }

    public boolean isFilled() {
        if (getHero() != null && getSpells().size() + getMinions().size() == 20)
            return true;
        return false;
    }

    public boolean isValid() {
        if (getHero() != null && getSpells().size() + getMinions().size() == 20)
            return true;
        return false;
    }

    public boolean hasThisCard(int objectID) {
        for (Hero hero : getHero()) {
            if (hero.getId() == objectID) {
                return true;
            }
        }
        for (Spell spell : getSpells()) {
            if (spell.getId() == objectID) {
                return true;
            }
        }
        for (Minion minion : getMinions()) {
            if (minion.getId() == objectID) {
                return true;
            }
        }
        for (UsableItem usableItem : getUsableItem()) {
            if (usableItem.getId() == objectID) {
                return true;
            }
        }
        return false;
    }

    public boolean isContain(Hero hero) {
        for (Hero hero1 : this.getHero()) {
            if (hero.getName().equals(hero1.getName())) {
                return true;
            }
        }
        return false;
    }

    public boolean isContain(Minion minion) {
        for (Minion minion1 : this.getMinions()) {
            if (minion1.getName().equals(minion.getName())) {
                return true;
            }
        }
        return false;
    }
}

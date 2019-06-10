package Duelyst.model;

import Duelyst.model.Card.Hero.Hero;
import Duelyst.model.Card.Minion.Minion;
import Duelyst.model.Card.Spell.Spell;
import Duelyst.model.Item.UsableItem.UsableItem;

import java.util.ArrayList;

public class Deck {

    private String name;
    private Hero hero;
    private UsableItem usableItem;
    private ArrayList<Spell> spells = new ArrayList<>();
    private ArrayList<Minion> minions = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public ArrayList<Spell> getSpells() {
        return spells;
    }

    public Deck duplicate() {
        Deck deck = new Deck();
        deck.setName(this.name);
        deck.setHero(this.getHero());
        deck.setUsableItem(this.usableItem);
        ArrayList<Minion> minions = new ArrayList<>();
        ArrayList<Spell> spells = new ArrayList<>();
        for (Minion minion : this.minions) {
            minions.add(minion.duplicate());
        }
        for (Spell spell : this.spells) {
            spells.add(spell.duplicate());
        }
        deck.setMinions(minions);
        deck.setSpells(spells);
        return deck;
    }

    public void setSpells(ArrayList<Spell> spells) {
        this.spells = spells;
    }

    public UsableItem getUsableItem() {
        return usableItem;
    }

    public void setUsableItem(UsableItem usableItem) {
        this.usableItem = usableItem;
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
        if (getHero() != null && getHero().getId() == objectID)
            return true;
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
        if (getUsableItem() != null && getUsableItem().getId() == objectID)
            return true;
        return false;
    }

    public boolean isContain(Hero hero) {
        if (this.getHero().getName().equals(hero.getName())) {
            return true;
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
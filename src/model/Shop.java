package model;

import java.util.ArrayList;

public class Shop {
    private ArrayList<Hero> availableHeroes = new ArrayList<>();
    private ArrayList<Minion> availableMinions = new ArrayList<>();
    private ArrayList<Spell> availableSpells = new ArrayList<>();
    public Shop(){
        availableHeroes = Hero.getHeroes();
        availableSpells = Spell.getSpells();
        availableMinions = Minion.getMinions();
    }

    public ArrayList<Hero> getAvailableHeroes() {
        return availableHeroes;
    }

    public ArrayList<Minion> getAvailableMinions() {
        return availableMinions;
    }

    public ArrayList<Spell> getAvailableSpells() {
        return availableSpells;
    }
}

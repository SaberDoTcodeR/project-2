package model;

import control.*;
import view.*;

import java.util.ArrayList;

public class Deck {

    private String name;
    private Hero hero;
    private Item item;
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

    public void setSpells(ArrayList<Spell> spells) {
        this.spells = spells;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public ArrayList<Minion> getMinions() {
        return minions;
    }

    public void setMinions(ArrayList<Minion> minions) {
        this.minions = minions;
    }

    public boolean isFilled(){
        if (getSpells().size() + getMinions().size() == 20 && getHero() != null && getItem() != null)
            //todo check working
            return true;
        return false;
    }

    public boolean isValid(){
        //todo check validation
        if (getHero() != null && getSpells().size() + getMinions().size() == 20)
            return true;
        return false;
    }

}
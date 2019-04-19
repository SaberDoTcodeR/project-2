package model;

import java.util.ArrayList;

public  abstract class Spell extends Card{
    private static ArrayList<Spell> spells=new ArrayList<>();
    private int costToUse;
    private Buff buff;
    public Spell(String name,int costToUse,int costOfBuy,Buff buff){
        this.setName(name);
        this.setCostOfBuy(costOfBuy);
        this.costToUse=costToUse;
        this.buff=buff;
        spells.add(this);
    }
    public Spell(Spell spell){
        this.setName(spell.getName());
        this.setCostOfBuy(spell.getCostOfBuy());
        this.costToUse=spell.costToUse;
        this.buff=spell.buff;
    }
    public abstract ArrayList<Cell> effectedCells();
    public static ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public int getCostToUse() {
        return costToUse;
    }

    public int getHp() {
        return hp;
    }


    public int getType(){
        return 1;
    }

}
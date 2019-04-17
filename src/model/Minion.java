package model;

import java.util.ArrayList;

public abstract class Minion extends  Card{
    private static ArrayList<Minion> minions=new ArrayList<>();
    private int ap;
    private int hp;
    private int costToUse;
    private SpecialPower specialPower;
    private int typeOfRange;//0 mellee 1 ranged 2 hybrid
    private int range;
    private int timeOfActivationOfSpecialPower;//0 on attack 1 on spawn 2 combo 3 on death 4 passive 5on turn 6 on defend
    public int getTypeOfRange() {
        return typeOfRange;
    }

    public int getRange() {
        return range;
    }


    public Minion(String name,int ap, int hp, SpecialPower specialPower, int costOfBuy, int costToUse, int typeOfRange, int range){
        this.setName(name);
        this.setCostOfBuy(costOfBuy);
        this.ap=ap;
        this.hp=hp;
        this.specialPower=specialPower;
        this.costToUse=costToUse;
        this.typeOfRange=typeOfRange;
        this.range=range;
        minions.add(this);
    }
    public Minion(Minion minion){
        this.setName(minion.getName());
        this.setCostOfBuy(minion.getCostOfBuy());
        this.ap=minion.ap;
        this.hp=minion.hp;
        this.specialPower=minion.specialPower;
        this.costToUse=minion.costToUse;
        this.typeOfRange=minion.typeOfRange;
        this.range=minion.range;
    }
    public int getAp() {
        return ap;
    }

    public int getCostToUse() {
        return costToUse;
    }

    public int getHp() {
        return hp;
    }

    public SpecialPower getSpecialPower() {
        return specialPower;
    }

    public static ArrayList<Minion> getMinions() {
        return minions;
    }



}

package model;

import java.util.ArrayList;

public abstract class Hero extends Card{
    private static ArrayList<Hero> heroes=new ArrayList<>();
    private int ap;
    private int hp;
    SpecialPower specialPower;
    private int typeOfRange;//0 mellee 1 ranged 2 hybrid
    private int range;
    private int coolDownTime;

    public Hero(String name,int ap,int hp,int coolDownTime,SpecialPower specialPower,int costOfBuy, int typeOfRange, int range){
        this.setName(name);
        this.setCostOfBuy(costOfBuy);
        this.typeOfRange=typeOfRange;
        this.range=range;
        this.coolDownTime=coolDownTime;
        this.ap=ap;
        this.hp=hp;
        this.specialPower=specialPower;
        heroes.add(this);
    }
    public Hero(Hero hero){
        this.setName(hero.getName());
        this.setCostOfBuy(hero.getCostOfBuy());
        this.typeOfRange=hero.typeOfRange;
        this.range=hero.range;
        this.coolDownTime=hero.coolDownTime;
        this.ap=hero.ap;
        this.hp=hero.hp;
        this.specialPower=hero.specialPower;
    }
    public static ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public int getHp() {
        return hp;
    }

    public SpecialPower getSpecialPower() {
        return specialPower;
    }

}

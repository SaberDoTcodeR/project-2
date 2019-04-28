package model.Cards;

import java.util.ArrayList;

public abstract class Hero extends Card {
    private static ArrayList<Hero> heroes = new ArrayList<>();

    static {
        new Arash();
        new Dragon();
        new Esfandyar();
        new Kaveh();
        new Legend();
        new Rakhsh();
        new Rostam();
        new Simurgh();
        new WhiteBogey();
        new Zahhak();
    }

    private int ap;
    private int hp;
    private int mp;
    private int holyCounter = 0;
    private boolean isStunning = false;
    //SpecialPower specialPower;
    private boolean counterAttack;
    private int typeOfRange;//0 melee 1 ranged 2 hybrid
    private int range;
    private int coolDownTime;
    private ArrayList<Buff> ownBuffs = new ArrayList<>();

    public ArrayList<Buff> getOwnBuffs() {
        return ownBuffs;
    }

    public boolean isCounterAttack() {
        return counterAttack;
    }

    public void setCounterAttack(boolean counterAttack) {
        this.counterAttack = counterAttack;
    }

    public Hero(String name, int ap, int hp, int costOfBuy, int typeOfRange) {
        this.setName(name);
        this.setCostOfBuy(costOfBuy);
        this.typeOfRange = typeOfRange;
        this.ap = ap;
        this.hp = hp;
        heroes.add(this);
    }

    public Hero(Hero hero) {
        this.setName(hero.getName());
        this.setCostOfBuy(hero.getCostOfBuy());
        this.typeOfRange = hero.typeOfRange;
        this.range = hero.range;
        this.coolDownTime = hero.coolDownTime;
        this.ap = hero.ap;
        this.hp = hero.hp;
        this.mp = hero.mp;
        //this.specialPower = hero.specialPower;
    }

    public void setCoolDownTime(int coolDownTime) {
        this.coolDownTime = coolDownTime;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAp(int ap) {
        this.ap = ap;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public static ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public int getHp() {
        return hp;
    }

    public int getAp() {
        return ap;
    }

    public String getType() {
        return "Hero";
    }

    public void setTypeOfHit(int typeOfRange) {
        this.typeOfRange = typeOfRange;
    }

    public String getTypeOfHit() {
        if (this.typeOfRange == 0)
            return "Melee";
        else if (this.typeOfRange == 1)
            return "Ranged";
        else if (this.typeOfRange == 2)
            return "Hybrid";
        else
            return null;
    }

    public boolean isStunning() {
        return isStunning;
    }

    public void setStunning(boolean stunning) {
        isStunning = stunning;
    }

    public int getHolyCounter() {
        return holyCounter;
    }

    public void incrementHolyCounter() {
        this.holyCounter++;
    }

    public void setHolyCounter(int holyCounter) {
        this.holyCounter = holyCounter;
    }

    public void incrementAp(int unit) {
        this.ap += unit;
    }

    public void decrementAp(int unit) {
        if (unit > 0)
            this.ap -= unit;
    }

    public void incrementHp(int unit) {
        this.hp += unit;
    }

    public void decrementHp(int unit) {
        if (unit > 0)
            this.hp -= unit;
    }

    public abstract void castSpecialPower();

    public Hero duplicate() {
        return null;//todo --> can be abstract
    }

   /* public SpecialPower getSpecialPower() {
        return specialPower;
    }
*/
}

enum HeroesAP {
    ARASH(2),
    DRAGON(4),
    ESFANDYAR(3),
    KAVEH(4),
    LEGEND(3),
    RAKHSH(4),
    ROSTAM(7),
    SIMURGH(4),
    WHITE_BOGEY(4),
    ZAHHAK(4);
    private int apUnit;

    HeroesAP(int apUnit) {
        this.apUnit = apUnit;
    }
}

enum HeroesHP {
    ARASH(30),
    DRAGON(50),
    ESFANDYAR(35),
    KAVEH(50),
    LEGEND(40),
    RAKHSH(50),
    ROSTAM(55),
    SIMURGH(50),
    WHITE_BOGEY(50),
    ZAHHAK(50);
    private int hpUnit;

    HeroesHP(int hpUnit) {
        this.hpUnit = hpUnit;
    }
}

class WhiteBogey extends Hero {
    public WhiteBogey() {
        super("WhiteBogey", 4, 50, 8000, 0);
        super.setCoolDownTime(2);
        super.setMp(1);
    }

    public WhiteBogey(WhiteBogey whiteBogey) {
        super(whiteBogey);
    }

    public Hero duplicate() {
        WhiteBogey whiteBogey = new WhiteBogey(this);
        return whiteBogey;
    }

    @Override
    public String showDetails() {
        String details = "Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - Class : " + this.getTypeOfHit() + " – Special power : take a power buff that increase hit power of itself" +
                "4 units forever.";
        return details;
    }

    @Override
    public void castSpecialPower() {

    }
}

class Simurgh extends Hero {
    public Simurgh() {
        super("Simurgh", 4, 50, 9000, 0);
        super.setCoolDownTime(8);
        super.setMp(3);
    }

    public Simurgh(Simurgh simurgh) {
        super(simurgh);
    }

    public Hero duplicate() {
        Simurgh simurgh = new Simurgh(this);
        return simurgh;
    }

    @Override
    public String showDetails() {
        String details = "Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - Class : " + this.getTypeOfHit() + " – Special power : stun all enemy forces for one turn.";
        return details;
    }

    @Override
    public void castSpecialPower() {

    }
}

class Dragon extends Hero {
    public Dragon() {
        super("Dragon", 4, 50, 8000, 0);
        super.setCoolDownTime(1);
        super.setMp(0);
    }

    public Dragon(Dragon dragon) {
        super(dragon);
    }

    public Hero duplicate() {
        Dragon dragon = new Dragon(this);
        return dragon;
    }

    @Override
    public String showDetails() {
        String details = "Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - Class : " + this.getTypeOfHit() + " – Special power : disarm one person.";
        return details;
    }

    @Override
    public void castSpecialPower() {

    }
}

class Rakhsh extends Hero {
    public Rakhsh() {
        super("Rakhsh", 4, 50, 8000, 0);
        super.setCoolDownTime(2);
        super.setMp(1);
    }

    public Rakhsh(Rakhsh rakhsh) {
        super(rakhsh);
    }

    public Hero duplicate() {
        Rakhsh rakhsh = new Rakhsh(this);
        return rakhsh;
    }

    @Override
    public String showDetails() {
        String details = "Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - Class : " + this.getTypeOfHit() + " – Special power : stun one of the enemy forces for one turn.";
        return details;
    }

    @Override
    public void castSpecialPower() {

    }
}

class Zahhak extends Hero {
    public Zahhak() {
        super("Zahhak", 4, 50, 10000, 0);
        super.setCoolDownTime(3);
        super.setMp(1);
    }

    public Zahhak(Zahhak zahhak) {
        super(zahhak);
    }

    public Hero duplicate() {
        Zahhak zahhak = new Zahhak(this);
        return zahhak;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - Class : " + this.getTypeOfHit() + " – Special power : poison the enemy in time of hitting for 3 turns.";
        return details;
    }

    @Override
    public void castSpecialPower() {

    }
}

class Kaveh extends Hero {
    public Kaveh() {
        super("Kaveh", 4, 50, 8000, 0);
        super.setCoolDownTime(3);
        super.setMp(1);
    }

    public Kaveh(Kaveh kaveh) {
        super(kaveh);
    }

    public Hero duplicate() {
        Kaveh kaveh = new Kaveh(this);
        return kaveh;
    }

    @Override
    public String showDetails() {
        String details = "Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - Class : " + this.getTypeOfHit() + " – Special power : make a cell holy for 3 turns.";
        return details;
    }

    @Override
    public void castSpecialPower() {

    }
}

class Arash extends Hero {
    public Arash() {
        super("Arash", 2, 30, 10000, 1);
        super.setCoolDownTime(2);
        super.setMp(2);
        super.setRange(6);
    }

    public Arash(Arash arash) {
        super(arash);
    }

    public Hero duplicate() {
        Arash arash = new Arash(this);
        return arash;
    }

    @Override
    public String showDetails() {
        String details = "Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - Class : " + this.getTypeOfHit() + " – Special power : hit all enemy forces in itself row with 4 units hit.";
        return details;
    }

    @Override
    public void castSpecialPower() {

    }
}

class Legend extends Hero {
    public Legend() {
        super("Legend", 3, 40, 11000, 1);
        super.setCoolDownTime(2);
        super.setMp(1);
        super.setRange(3);
    }

    public Legend(Legend legend) {
        super(legend);
    }

    public Hero duplicate() {
        Legend legend = new Legend(this);
        return legend;
    }

    @Override
    public String showDetails() {
        String details = "Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - Class : " + this.getTypeOfHit() + " – Special power : dispel one of the enemy forces.";
        return details;
    }

    @Override
    public void castSpecialPower() {

    }
}

class Esfandyar extends Hero {
    public Esfandyar() {
        super("Esfandyar", 3, 35, 12000, 2);
        super.setCoolDownTime(1);
        super.setMp(0);
        super.setRange(3);
    }

    public Esfandyar(Esfandyar esfandyar) {
        super(esfandyar);
    }

    public Hero duplicate() {
        Esfandyar esfandyar = new Esfandyar(this);
        return esfandyar;
    }

    @Override
    public String showDetails() {
        String details = "Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - Class : " + this.getTypeOfHit() + " – Special power : has 3 holy buff in continuous mode.";
        return details;
    }

    @Override
    public void castSpecialPower() {

    }
}

class Rostam extends Hero {
    public Rostam() {
        super("Rostam", 7, 55, 8000, 2);
        super.setRange(4);
    }

    public Rostam(Rostam rostam) {
        super(rostam);
    }

    public Hero duplicate() {
        Rostam rostam = new Rostam(this);
        return rostam;
    }

    @Override
    public String showDetails() {
        String details = "Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - Class : " + this.getTypeOfHit() + " – Special power : - .";
        return details;
    }

    @Override
    public void castSpecialPower() {

    }
}
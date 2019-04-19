package model;

import java.util.ArrayList;

public abstract class Hero extends Card {
    private static ArrayList<Hero> heroes = new ArrayList<>();
    private int ap;
    private int hp;
    private int mp;
    //SpecialPower specialPower;
    private int typeOfRange;//0 mellee 1 ranged 2 hybrid
    private int range;
    private int coolDownTime;

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
        this.specialPower = hero.specialPower;
    }

    public void setCoolDownTime(int coolDownTime) {
        this.coolDownTime = coolDownTime;
    }

    public void setMp(int mp) {
        this.mp = mp;
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

   /* public SpecialPower getSpecialPower() {
        return specialPower;
    }
*/
}

public class WhiteBogey extends Hero {
    public WhiteBogey() {
        super("WhiteBogey", 4, 50, 8000, 0);
        super.setCoolDownTime(2);
        super.setMp(1);
    }

}

public class Simurgh extends Hero {
    public Simurgh() {
        super("Simurgh", 4, 50, 9000, 0);
        super.setCoolDownTime(8);
        super.setMp(3);
    }
}

public class Dragon extends Hero {
    public Dragon() {
        super("Dragon", 4, 50, 8000, 0);
        super.setCoolDownTime(1);
        super.setMp(0);
    }
}

public class Rakhsh extends Hero {
    public Rakhsh() {
        super("Rakhsh", 4, 50, 8000, 0);
        super.setCoolDownTime(2);
        super.setMp(1);
    }
}

public class Zahhak extends Hero {
    public Zahhak() {
        super("Zahhak", 4, 50, 10000, 0);
        super.setCoolDownTime(3);
        super.setMp(1);
    }
}

public class Kaveh extends Hero {
    public Kaveh() {
        super("Kaveh", 4, 50, 1, 3, , 8000, 0, );
        super.setCoolDownTime(3);
        super.setMp(1);
    }
}

public class Arash extends Hero {
    public Arash() {
        super("Arash", 2, 30, 10000, 1);
        super.setCoolDownTime(2);
        super.setMp(2);
        super.setRange(6);
    }
}

public class Legend extends Hero {
    public Legend() {
        super("Legend", 3, 40, 11000, 1);
        super.setCoolDownTime(2);
        super.setMp(1);
        super.setRange(3);
    }
}

public class Esfandyar extends Hero {
    public Esfandyar() {
        super("Esfandyar", 3, 35, 12000, 2);
        super.setCoolDownTime(1);
        super.setMp(0);
        super.setRange(3);
    }
}

public class Rostam extends Hero {
    public Rostam() {
        super("Rostam", 7, 55, 8000, 2);
        super.setRange(4);
    }
}
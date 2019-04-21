package model;

import javafx.scene.control.Cell;

import java.util.ArrayList;

public abstract class Spell extends Card {
    private static ArrayList<Spell> spells = new ArrayList<>();
    private int costToUse;
    private Buff buff;

    public Spell(String name, int costToUse, int costOfBuy, Buff buff) {
        this.setName(name);
        this.setCostOfBuy(costOfBuy);
        this.costToUse = costToUse;
        this.buff = buff;
        spells.add(this);
    }

    public Spell(Spell spell) {
        this.setName(spell.getName());
        this.setCostOfBuy(spell.getCostOfBuy());
        this.costToUse = spell.costToUse;
        this.buff = spell.buff;
    }

    public abstract ArrayList<Cell> effectedCells();

    public static ArrayList<Spell> getSpells() {
        return spells;
    }

    public int getCostToUse() {
        return costToUse;
    }

}

enum SpellWork {
    TOTAL_DISARM("An enemy force become disarm until the end of the game"),
    AREA_DISPEL("Disappear positive buffs of enemy force and negative buffs of " +
            "insider force on selected 2x2 square"),
    EMPOWER("Add 2AP to a enemy force"),
    FIREBALL("Hit an enemy force 4 uint"),
    GOD_STRENGTH("Add 4Ap to a insider hero card"),
    HELL_FIRE("Apply fiery cell effect on selected 2x2 square for 2 turns"),
    LIGHTING_BOLT("Hit an enemy force 8 uint"),
    POISON_LAKE("Apply poison cell effect on selected 3x3 square for 1 turn"),
    MADNESS("Increase an insider force's Ap 4 units for 3turns but it can be disarm"),
    ALL_DISARM("Be disarm for 1 turn"),
    ALL_POISON("Enemy forces become poison for 4 turns"),
    DISPEL("Disappear positive buffs of enemy force and negative buffs of " +
            "insider force for a insider force or enemy force")/*todo --> what the faz?*/,
    HEALTH_WITH_PROFIT("Give friend force a weakness buff or reduce HP of force 6 units" +
            "but have 2 holy buff for 3 turns"),
    POWER_UP("Apply a power buff and add 6AP for an insider force"),
    ALL_POWER("Apply a power buff and add 6AP for all insider forces permanently"),
    ALL_ATTACK("Hit all enemy forces who in one column 6units"),
    WEAKENING("Give a enemy minion a weakness buff or reduce HP of minion 4 units"),
    SACRIFICE("Give a insider minion a weakness buff or reduce HP of minion 6 units" +
            " and give a power buff and add 8AP to insider minion"),
    KINGS_GUARD("Kill enemy force on 8 around cells"),
    SHOCK("Become stun for 2 turn for enemy force");

    private String effect;

    SpellWork(String effect) {
        this.effect = effect;
    }

}

class TotalDisarm extends Spell {

    public TotalDisarm(String name, int costToUse, int costOfBuy, Buff buff) {
        super(name, costToUse, costOfBuy, buff);
    }

    @Override
    public ArrayList<Cell> effectedCells() {
        return null;
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.TOTAL_DISARM;
        return details;
    }
}

class AreaDispel extends Spell {

    public AreaDispel(String name, int costToUse, int costOfBuy, Buff buff) {
        super(name, costToUse, costOfBuy, buff);
    }

    @Override
    public ArrayList<Cell> effectedCells() {
        return null;
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.AREA_DISPEL;
        return details;
    }
}

class Empower extends Spell {

    public Empower(String name, int costToUse, int costOfBuy, Buff buff) {
        super(name, costToUse, costOfBuy, buff);
    }

    @Override
    public ArrayList<Cell> effectedCells() {
        return null;
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.EMPOWER;
        return details;
    }
}

class FireBall extends Spell {

    public FireBall(String name, int costToUse, int costOfBuy, Buff buff) {
        super(name, costToUse, costOfBuy, buff);
    }

    @Override
    public ArrayList<Cell> effectedCells() {
        return null;
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.FIREBALL;
        return details;
    }
}

class GodStrength extends Spell {

    public GodStrength(String name, int costToUse, int costOfBuy, Buff buff) {
        super(name, costToUse, costOfBuy, buff);
    }

    @Override
    public ArrayList<Cell> effectedCells() {
        return null;
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.GOD_STRENGTH;
        return details;
    }
}

class HellFire extends Spell {

    public HellFire(String name, int costToUse, int costOfBuy, Buff buff) {
        super(name, costToUse, costOfBuy, buff);
    }

    @Override
    public ArrayList<Cell> effectedCells() {
        return null;
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.HELL_FIRE;
        return details;
    }
}

class LightingBolt extends Spell {

    public LightingBolt(String name, int costToUse, int costOfBuy, Buff buff) {
        super(name, costToUse, costOfBuy, buff);
    }

    @Override
    public ArrayList<Cell> effectedCells() {
        return null;
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.LIGHTING_BOLT;
        return details;
    }
}

class PoisonLake extends Spell {

    public PoisonLake(String name, int costToUse, int costOfBuy, Buff buff) {
        super(name, costToUse, costOfBuy, buff);
    }

    @Override
    public ArrayList<Cell> effectedCells() {
        return null;
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.POISON_LAKE;
        return details;
    }
}

class Madness extends Spell {

    public Madness(String name, int costToUse, int costOfBuy, Buff buff) {
        super(name, costToUse, costOfBuy, buff);
    }

    @Override
    public ArrayList<Cell> effectedCells() {
        return null;
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.MADNESS;
        return details;
    }
}

class AllDisarm extends Spell {

    public AllDisarm(String name, int costToUse, int costOfBuy, Buff buff) {
        super(name, costToUse, costOfBuy, buff);
    }

    @Override
    public ArrayList<Cell> effectedCells() {
        return null;
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.ALL_DISARM;
        return details;
    }
}

class AllPoison extends Spell {

    public AllPoison(String name, int costToUse, int costOfBuy, Buff buff) {
        super(name, costToUse, costOfBuy, buff);
    }

    @Override
    public ArrayList<Cell> effectedCells() {
        return null;
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.ALL_POISON;
        return details;
    }
}

class Dispel extends Spell {

    public Dispel(String name, int costToUse, int costOfBuy, Buff buff) {
        super(name, costToUse, costOfBuy, buff);
    }

    @Override
    public ArrayList<Cell> effectedCells() {
        return null;
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.DISPEL;
        return details;
    }
}

class HealthWithProfit extends Spell {

    public HealthWithProfit(String name, int costToUse, int costOfBuy, Buff buff) {
        super(name, costToUse, costOfBuy, buff);
    }

    @Override
    public ArrayList<Cell> effectedCells() {
        return null;
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.HEALTH_WITH_PROFIT;
        return details;
    }
}

class PowerUp extends Spell {

    public PowerUp(String name, int costToUse, int costOfBuy, Buff buff) {
        super(name, costToUse, costOfBuy, buff);
    }

    @Override
    public ArrayList<Cell> effectedCells() {
        return null;
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.POWER_UP;
        return details;
    }
}

class AllPower extends Spell {

    public AllPower(String name, int costToUse, int costOfBuy, Buff buff) {
        super(name, costToUse, costOfBuy, buff);
    }

    @Override
    public ArrayList<Cell> effectedCells() {
        return null;
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.ALL_POWER;
        return details;
    }
}

class AllAttack extends Spell {

    public AllAttack(String name, int costToUse, int costOfBuy, Buff buff) {
        super(name, costToUse, costOfBuy, buff);
    }

    @Override
    public ArrayList<Cell> effectedCells() {
        return null;
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.ALL_ATTACK;
        return details;
    }
}

class Weakening extends Spell {

    public Weakening(String name, int costToUse, int costOfBuy, Buff buff) {
        super(name, costToUse, costOfBuy, buff);
    }

    @Override
    public ArrayList<Cell> effectedCells() {
        return null;
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.WEAKENING;
        return details;
    }
}

class Sacrifice extends Spell {

    public Sacrifice(String name, int costToUse, int costOfBuy, Buff buff) {
        super(name, costToUse, costOfBuy, buff);
    }

    @Override
    public ArrayList<Cell> effectedCells() {
        return null;
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.SACRIFICE;
        return details;
    }
}

class KingsGuard extends Spell {

    public KingsGuard(String name, int costToUse, int costOfBuy, Buff buff) {
        super(name, costToUse, costOfBuy, buff);
    }

    @Override
    public ArrayList<Cell> effectedCells() {
        return null;
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.KINGS_GUARD;
        return details;
    }
}

class Shock extends Spell {

    public Shock(String name, int costToUse, int costOfBuy, Buff buff) {
        super(name, costToUse, costOfBuy, buff);
    }

    @Override
    public ArrayList<Cell> effectedCells() {
        return null;
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.SHOCK;
        return details;
    }
}

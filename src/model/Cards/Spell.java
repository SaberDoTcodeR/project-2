package model.Cards;

import model.Cell;

import java.util.ArrayList;

public abstract class Spell extends Card {
    private static ArrayList<Spell> spells = new ArrayList<>();
    private int costToUse;

    static {
        new AllAttack();
        new AllDisarm();
        new AllPoison();
        new AllPower();
        new AreaDispel();
        new Dispel();
        new Empower();
        new FireBall();
        new GodStrength();
        new HealthWithProfit();
        new HellFire();
        new KingsGuard();
        new LightingBolt();
        new Madness();
        new PoisonLake();
        new PowerUp();
        new Sacrifice();
        new Shock();
        new TotalDisarm();
        new Weakening();
    }

    public Spell(String name, int costToUse, int costOfBuy) {
        this.setName(name);
        this.setCostOfBuy(costOfBuy);
        this.costToUse = costToUse;
        spells.add(this);
    }

    public Spell(Spell spell) {
        this.setName(spell.getName());
        this.setCostOfBuy(spell.getCostOfBuy());
        this.costToUse = spell.costToUse;
    }

    public abstract ArrayList<Cell> effectedCells();

    public static ArrayList<Spell> getSpells() {
        return spells;
    }

    public int getCostToUse() {
        return costToUse;
    }

    public abstract void castBuff(Cell cell);

    public abstract void castBuff(ArrayList<Cell> cells);

    public String getType() {
        return "Spell";
    }

    public Spell duplicate() {
        return null;
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

    public TotalDisarm() {
        super("TotalDisarm", 0, 1000);
    }

    public TotalDisarm(String name, int costToUse, int costOfBuy) {
        super(name, costToUse, costOfBuy);
    }

    public TotalDisarm(TotalDisarm totalDisarm) {
        super(totalDisarm);
    }

    public Spell duplicate() {
        TotalDisarm totalDisarm = new TotalDisarm(this);
        return totalDisarm;
    }

    @Override
    public ArrayList<Cell> effectedCells() {
        return null;
    }

    @Override
    public void castBuff(Cell cell) {
        //todo
    }

    @Override
    public void castBuff(ArrayList<Cell> cells) {
        DisarmBuff disarmBuff = new DisarmBuff();
        disarmBuff.disarm(cells);
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

    public AreaDispel() {
        super("AreaDispel", 2, 1500);
    }

    public AreaDispel(AreaDispel areaDispel) {
        super(areaDispel);
    }

    public Spell duplicate() {
        AreaDispel areaDispel = new AreaDispel(this);
        return areaDispel;
    }

    @Override
    public ArrayList<Cell> effectedCells() {
        return null;
    }

    @Override
    public void castBuff(Cell cell) {

    }

    @Override
    public void castBuff(ArrayList<Cell> cells) {

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

    public Empower() {
        super("Empower", 1, 250);
    }

    public Empower(Empower empower) {
        super(empower);
    }

    public Spell duplicate() {
        Empower empower = new Empower(this);
        return empower;
    }

    @Override
    public ArrayList<Cell> effectedCells() {
        return null;
    }

    @Override
    public void castBuff(Cell cell) {

    }

    @Override
    public void castBuff(ArrayList<Cell> cells) {
        ChangeApBuff changeApBuff = new ChangeApBuff(2);
        changeApBuff.changeAP(cells);
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

    public FireBall() {
        super("FireBall", 1, 400);
    }

    public FireBall(FireBall fireBall) {
        super(fireBall);
    }

    public Spell duplicate() {
        FireBall fireBall = new FireBall(this);
        return fireBall;
    }

    @Override
    public ArrayList<Cell> effectedCells() {
        return null;
    }

    @Override
    public void castBuff(Cell cell) {

    }

    @Override
    public void castBuff(ArrayList<Cell> cells) {

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

    public GodStrength() {
        super("GodStrength", 2, 450);
    }

    public GodStrength(GodStrength godStrength) {
        super(godStrength);
    }

    public Spell duplicate() {
        GodStrength godStrength = new GodStrength(this);
        return godStrength;
    }

    @Override
    public ArrayList<Cell> effectedCells() {
        return null;
    }

    @Override
    public void castBuff(Cell cell) {

    }

    @Override
    public void castBuff(ArrayList<Cell> cells) {

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

    public HellFire() {
        super("HellFire", 3, 600);
    }

    public HellFire(HellFire hellFire) {
        super(hellFire);
    }

    public Spell duplicate() {
        HellFire hellFire = new HellFire(this);
        return hellFire;
    }

    @Override
    public ArrayList<Cell> effectedCells() {
        return null;
    }

    @Override
    public void castBuff(Cell cell) {

    }

    @Override
    public void castBuff(ArrayList<Cell> cells) {

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

    public LightingBolt() {
        super("LightingBolt", 2, 1250);
    }

    public LightingBolt(LightingBolt lightingBolt) {
        super(lightingBolt);
    }

    public Spell duplicate() {
        LightingBolt lightingBolt = new LightingBolt(this);
        return lightingBolt;
    }

    @Override
    public ArrayList<Cell> effectedCells() {
        return null;
    }

    @Override
    public void castBuff(Cell cell) {

    }

    @Override
    public void castBuff(ArrayList<Cell> cells) {

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

    public PoisonLake() {
        super("PoisonLake", 5, 900);
    }

    public PoisonLake(PoisonLake poisonLake) {
        super(poisonLake);
    }

    public Spell duplicate() {
        PoisonLake poisonLake = new PoisonLake(this);
        return poisonLake;
    }

    @Override
    public ArrayList<Cell> effectedCells() {
        return null;
    }

    @Override
    public void castBuff(Cell cell) {

    }

    @Override
    public void castBuff(ArrayList<Cell> cells) {

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

    public Madness() {
        super("Madness", 0, 650);
    }

    public Madness(Madness madness) {
        super(madness);
    }

    public Spell duplicate() {
        Madness madness = new Madness(this);
        return madness;
    }

    @Override
    public ArrayList<Cell> effectedCells() {
        return null;
    }

    @Override
    public void castBuff(Cell cell) {

    }

    @Override
    public void castBuff(ArrayList<Cell> cells) {

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

    public AllDisarm() {
        super("AllDisarm", 9, 2000);
    }

    public AllDisarm(AllDisarm allDisarm) {
        super(allDisarm);
    }

    public Spell duplicate() {
        AllDisarm allDisarm = new AllDisarm(this);
        return allDisarm;
    }

    @Override
    public ArrayList<Cell> effectedCells() {
        return null;
    }

    @Override
    public void castBuff(Cell cell) {

    }

    @Override
    public void castBuff(ArrayList<Cell> cells) {

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

    public AllPoison() {
        super("AllPoison", 8, 1500);
    }

    public AllPoison(String name, int costToUse, int costOfBuy) {
        super(name, costToUse, costOfBuy);
    }

    public AllPoison(AllPoison allPoison) {
        super(allPoison);
    }

    public Spell duplicate() {
        AllPoison allPoison = new AllPoison(this);
        return allPoison;
    }

    @Override
    public ArrayList<Cell> effectedCells() {
        return null;
    }

    @Override
    public void castBuff(Cell cell) {

    }

    @Override
    public void castBuff(ArrayList<Cell> cells) {

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

    public Dispel() {
        super("Dispel", 0, 2100);
    }

    public Dispel(Dispel dispel) {
        super(dispel);
    }

    public Spell duplicate() {
        Dispel dispel = new Dispel(this);
        return dispel;
    }

    @Override
    public ArrayList<Cell> effectedCells() {
        return null;
    }

    @Override
    public void castBuff(Cell cell) {

    }

    @Override
    public void castBuff(ArrayList<Cell> cells) {

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

    public HealthWithProfit() {
        super("HealthWithProfit", 0, 2250);
    }

    public HealthWithProfit(HealthWithProfit healthWithProfit) {
        super(healthWithProfit);
    }

    public Spell duplicate() {
        HealthWithProfit healthWithProfit = new HealthWithProfit(this);
        return healthWithProfit;
    }

    @Override
    public ArrayList<Cell> effectedCells() {
        return null;
    }

    @Override
    public void castBuff(Cell cell) {

    }

    @Override
    public void castBuff(ArrayList<Cell> cells) {

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

    public PowerUp() {
        super("PowerUp", 2, 2500);
    }

    public PowerUp(PowerUp powerUp) {
        super(powerUp);
    }

    public Spell duplicate() {
        PowerUp powerUp = new PowerUp(this);
        return powerUp;
    }

    @Override
    public ArrayList<Cell> effectedCells() {
        return null;
    }

    @Override
    public void castBuff(Cell cell) {

    }

    @Override
    public void castBuff(ArrayList<Cell> cells) {

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

    public AllPower() {
        super("AllPower", 4, 2000);
    }

    public AllPower(AllPower allPower) {
        super(allPower);
    }

    public Spell duplicate() {
        AllPower allPower = new AllPower(this);
        return allPower;
    }

    @Override
    public ArrayList<Cell> effectedCells() {
        return null;
    }

    @Override
    public void castBuff(Cell cell) {

    }

    @Override
    public void castBuff(ArrayList<Cell> cells) {

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

    public AllAttack() {
        super("AllAttack", 4, 1500);
    }

    public AllAttack(AllAttack allAttack) {
        super(allAttack);
    }

    public Spell duplicate() {
        AllAttack allAttack = new AllAttack(this);
        return allAttack;
    }

    @Override
    public ArrayList<Cell> effectedCells() {
        return null;
    }

    @Override
    public void castBuff(Cell cell) {

    }

    @Override
    public void castBuff(ArrayList<Cell> cells) {

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

    public Weakening() {
        super("Weakening", 1, 1000);
    }

    public Weakening(Weakening weakening) {
        super(weakening);
    }

    public Spell duplicate() {
        Weakening weakening = new Weakening(this);
        return weakening;
    }

    @Override
    public ArrayList<Cell> effectedCells() {
        return null;
    }

    @Override
    public void castBuff(Cell cell) {

    }

    @Override
    public void castBuff(ArrayList<Cell> cells) {

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

    public Sacrifice() {
        super("Sacrifice", 2, 1600);
    }

    public Sacrifice(Sacrifice sacrifice) {
        super(sacrifice);
    }

    public Spell duplicate() {
        Sacrifice sacrifice = new Sacrifice(this);
        return sacrifice;
    }

    @Override
    public ArrayList<Cell> effectedCells() {
        return null;
    }

    @Override
    public void castBuff(Cell cell) {

    }

    @Override
    public void castBuff(ArrayList<Cell> cells) {

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

    public KingsGuard() {
        super("KingsGuard", 9, 1750);
    }

    public KingsGuard(KingsGuard kingsGuard) {
        super(kingsGuard);
    }

    public Spell duplicate() {
        KingsGuard kingsGuard = new KingsGuard(this);
        return kingsGuard;
    }

    @Override
    public ArrayList<Cell> effectedCells() {
        return null;
    }

    @Override
    public void castBuff(Cell cell) {

    }

    @Override
    public void castBuff(ArrayList<Cell> cells) {

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

    public Shock() {
        super("Shock", 1, 1200);
    }

    public Shock(Shock shock) {
        super(shock);
    }

    public Spell duplicate() {
        Shock shock = new Shock(this);
        return shock;
    }

    @Override
    public ArrayList<Cell> effectedCells() {
        return null;
    }

    @Override
    public void castBuff(Cell cell) {

    }

    @Override
    public void castBuff(ArrayList<Cell> cells) {

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

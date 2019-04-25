package model;

import java.util.ArrayList;

public abstract class Spell extends Card {
    private static ArrayList<Spell> spells = new ArrayList<>();
    private int costToUse;

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

}

enum SpellWork {
    TOTAL_DISARM("An enemy force become disarm until the end of the game"),
    AREA_DISPEL("Disappear positive  s of enemy force and negative  s of " +
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
    DISPEL("Disappear positive  s of enemy force and negative  s of " +
            "insider force for a insider force or enemy force")/*todo --> what the faz?*/,
    HEALTH_WITH_PROFIT("Give friend force a weakness   or reduce HP of force 6 units" +
            "but have 2 holy   for 3 turns"),
    POWER_UP("Apply a power   and add 6AP for an insider force"),
    ALL_POWER("Apply a power   and add 6AP for all insider forces permanently"),
    ALL_ATTACK("Hit all enemy forces who in one column 6units"),
    WEAKENING("Give a enemy minion a weakness   or reduce HP of minion 4 units"),
    SACRIFICE("Give a insider minion a weakness   or reduce HP of minion 6 units" +
            " and give a power   and add 8AP to insider minion"),
    KINGS_GUARD("Kill enemy force on 8 around cells"),
    SHOCK("Become stun for 2 turn for enemy force");

    private String effect;

    SpellWork(String effect) {
        this.effect = effect;
    }

}

class TotalDisarm extends Spell {

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

    public void buff(){

    }

    public void buff(Minion minion){

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

    public AreaDispel(String name, int costToUse, int costOfBuy) {
        super(name, costToUse, costOfBuy);
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
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.AREA_DISPEL;
        return details;
    }
}

class Empower extends Spell {

    public Empower(String name, int costToUse, int costOfBuy) {
        super(name, costToUse, costOfBuy);
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
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.EMPOWER;
        return details;
    }
}

class FireBall extends Spell {

    public FireBall(String name, int costToUse, int costOfBuy) {
        super(name, costToUse, costOfBuy);
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
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.FIREBALL;
        return details;
    }
}

class GodStrength extends Spell {

    public GodStrength(String name, int costToUse, int costOfBuy) {
        super(name, costToUse, costOfBuy);
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
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.GOD_STRENGTH;
        return details;
    }
}

class HellFire extends Spell {

    public HellFire(String name, int costToUse, int costOfBuy) {
        super(name, costToUse, costOfBuy);
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
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.HELL_FIRE;
        return details;
    }
}

class LightingBolt extends Spell {

    public LightingBolt(String name, int costToUse, int costOfBuy) {
        super(name, costToUse, costOfBuy);
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
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.LIGHTING_BOLT;
        return details;
    }
}

class PoisonLake extends Spell {

    public PoisonLake(String name, int costToUse, int costOfBuy) {
        super(name, costToUse, costOfBuy);
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
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.POISON_LAKE;
        return details;
    }
}

class Madness extends Spell {

    public Madness(String name, int costToUse, int costOfBuy) {
        super(name, costToUse, costOfBuy);
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
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.MADNESS;
        return details;
    }
}

class AllDisarm extends Spell {

    public AllDisarm(String name, int costToUse, int costOfBuy) {
        super(name, costToUse, costOfBuy);
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
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.ALL_DISARM;
        return details;
    }
}

class AllPoison extends Spell {

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
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.ALL_POISON;
        return details;
    }
}

class Dispel extends Spell {

    public Dispel(String name, int costToUse, int costOfBuy) {
        super(name, costToUse, costOfBuy);
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
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.DISPEL;
        return details;
    }
}

class HealthWithProfit extends Spell {

    public HealthWithProfit(String name, int costToUse, int costOfBuy) {
        super(name, costToUse, costOfBuy);
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
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.HEALTH_WITH_PROFIT;
        return details;
    }
}

class PowerUp extends Spell {

    public PowerUp(String name, int costToUse, int costOfBuy) {
        super(name, costToUse, costOfBuy);
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
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.POWER_UP;
        return details;
    }
}

class AllPower extends Spell {

    public AllPower(String name, int costToUse, int costOfBuy) {
        super(name, costToUse, costOfBuy);
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
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.ALL_POWER;
        return details;
    }

}

class AllAttack extends Spell {

    public AllAttack(String name, int costToUse, int costOfBuy) {
        super(name, costToUse, costOfBuy);
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
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.ALL_ATTACK;
        return details;
    }
}

class Weakening extends Spell {

    public Weakening(String name, int costToUse, int costOfBuy) {
        super(name, costToUse, costOfBuy);
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
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.WEAKENING;
        return details;
    }
}

class Sacrifice extends Spell {

    public Sacrifice(String name, int costToUse, int costOfBuy) {
        super(name, costToUse, costOfBuy);
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
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.SACRIFICE;
        return details;
    }
}

class KingsGuard extends Spell {

    public KingsGuard(String name, int costToUse, int costOfBuy) {
        super(name, costToUse, costOfBuy);
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
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.KINGS_GUARD;
        return details;
    }
}

class Shock extends Spell {

    public Shock(String name, int costToUse, int costOfBuy) {
        super(name, costToUse, costOfBuy);
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
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.SHOCK;
        return details;
    }
}

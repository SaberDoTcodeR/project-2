package model.Cards;

import model.Battles.Battle;
import model.Cell;
import model.ErrorType;
import model.Menus.Account;
import view.View;

import java.util.ArrayList;

public abstract class Spell extends Card {
    private static ArrayList<Spell> spells = new ArrayList<>();
    private int costToUse;
    protected static View view = View.getInstance();

    private ArrayList<String> positiveBuffs = new ArrayList<>();
    private ArrayList<String> negativeBuffs = new ArrayList<>();

    {
        positiveBuffs.add("HolyBuff");
        positiveBuffs.add("PowerBuff");
        negativeBuffs.add("PoisonBuff");
        negativeBuffs.add("WeaknessBuff");
        negativeBuffs.add("StunBuff");
        negativeBuffs.add("DisarmBuff");
    }

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

    public boolean dispelEnemyValidation(String buffName) {
        for (String str : negativeBuffs) {
            if (str.equals(buffName)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispelInsiderValidation(String buffName) {
        for (String str : positiveBuffs) {
            if (str.equals(buffName)) {
                return true;
            }
        }
        return false;
    }

    public abstract void castBuff(Battle battle, Cell cell, Account player);

    public static ArrayList<Spell> getSpells() {
        return spells;
    }

    public int getCostToUse() {
        return costToUse;
    }

    public String getType() {
        return "Spell";
    }

    public Spell duplicate() {
        return null;
    }

    public Cell rightCell(ArrayList<ArrayList<Cell>> map, Cell cell) {
        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.get(i).size(); j++) {
                if (map.get(i).get(j).equals(cell)) {
                    return map.get(i).get(j + 1);
                }
            }
        }
        return null;
    }

    public Cell leftCell(ArrayList<ArrayList<Cell>> map, Cell cell) {
        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.get(i).size(); j++) {
                if (map.get(i).get(j).equals(cell)) {
                    return map.get(i).get(j - 1);
                }
            }
        }
        return null;
    }

    public Cell upCell(ArrayList<ArrayList<Cell>> map, Cell cell) {
        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.get(i).size(); j++) {
                if (map.get(i).get(j).equals(cell)) {
                    return map.get(i + 1).get(j);
                }
            }
        }
        return null;
    }

    public Cell downCell(ArrayList<ArrayList<Cell>> map, Cell cell) {
        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.get(i).size(); j++) {
                if (map.get(i).get(j).equals(cell)) {
                    return map.get(i - 1).get(j);
                }
            }
        }
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

    public String getMessage() {
        return effect;
    }

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

    @Override
    public void castBuff(Battle battle, Cell cell, Account player) {
        if (cell.getMinion() == null && cell.getHero() == null) {
            view.printError(ErrorType.INVALID_TARGET);
        } else {
            if (cell.getHero() != null) {
                if (!player.getMainDeck().isContain(cell.getHero())) {
                    DisarmBuff disarmBuff = new DisarmBuff();
                    disarmBuff.setTurnCounter(-5);//-5 means until end of game
                    disarmBuff.disarm(cell.getHero());
                    cell.getHero().getOwnBuffs().add(disarmBuff);
                } else {
                    view.printError(ErrorType.INVALID_TARGET);
                }
            }
            if (cell.getMinion() != null) {
                if (!player.getMainDeck().isContain(cell.getMinion())) {
                    DisarmBuff disarmBuff = new DisarmBuff();
                    disarmBuff.setTurnCounter(-5);
                    disarmBuff.disarm(cell.getMinion());
                    cell.getMinion().getOwnBuffs().add(disarmBuff);
                } else {
                    view.printError(ErrorType.INVALID_TARGET);
                }
            }
        }
    }

    public TotalDisarm(TotalDisarm totalDisarm) {
        super(totalDisarm);
    }

    public Spell duplicate() {
        TotalDisarm totalDisarm = new TotalDisarm(this);
        return totalDisarm;
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.TOTAL_DISARM.getMessage();
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

    @Override
    public void castBuff(Battle battle, Cell cell, Account player) {
        ArrayList<Cell> cells = new ArrayList<>();
        cells.add(cell);
        cells.add(rightCell(battle.getMap(),cell));
        cells.add(upCell(battle.getMap(),cell));
        cells.add(upCell(battle.getMap(),cells.get(1)));
        //todo check working
        for (Cell cell1: cells) {
            Dispel dispel = new Dispel();
            dispel.castBuff(battle,cell1,player);
        }
    }

    public Spell duplicate() {
        AreaDispel areaDispel = new AreaDispel(this);
        return areaDispel;
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.AREA_DISPEL.getMessage();
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

    @Override
    public void castBuff(Battle battle, Cell cell, Account player) {
        if (cell.getHero() == null && cell.getMinion() == null) {
            view.printError(ErrorType.INVALID_TARGET);
        } else {
            if (cell.getHero() != null) {
                if (player.getMainDeck().isContain(cell.getHero())) {
                    ChangeApBuff changeAp = new ChangeApBuff(2);
                    changeAp.setTurnCounter(1);
                    changeAp.increment(cell.getHero());
                    cell.getHero().getOwnBuffs().add(changeAp);
                } else {
                    view.printError(ErrorType.INVALID_TARGET);
                }
            }
            if (cell.getMinion() != null) {
                if (player.getMainDeck().isContain(cell.getMinion())) {
                    ChangeApBuff changeAp = new ChangeApBuff(2);
                    changeAp.setTurnCounter(1);
                    changeAp.increment(cell.getMinion());
                    cell.getMinion().getOwnBuffs().add(changeAp);
                } else {
                    view.printError(ErrorType.INVALID_TARGET);
                }
            }
        }
    }

    public Spell duplicate() {
        Empower empower = new Empower(this);
        return empower;
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.EMPOWER.getMessage();
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

    @Override
    public void castBuff(Battle battle, Cell cell, Account player) {
        if (cell.getHero() == null && cell.getMinion() == null) {
            view.printError(ErrorType.INVALID_TARGET);
        } else {
            if (cell.getHero() != null) {
                if (!player.getMainDeck().isContain(cell.getHero())) {
                    if (cell.getHero().getHolyCounter() != 0) {
                        ChangeHpBuff changeHp = new ChangeHpBuff(4 - cell.getHero().getHolyCounter());
                        changeHp.setTurnCounter(1);
                        changeHp.decrement(cell.getHero());
                        cell.getHero().getOwnBuffs().add(changeHp);
                    } else {
                        ChangeHpBuff changeHp = new ChangeHpBuff(4);
                        changeHp.setTurnCounter(1);
                        changeHp.decrement(cell.getHero());
                        cell.getHero().getOwnBuffs().add(changeHp);
                    }
                } else {
                    view.printError(ErrorType.INVALID_TARGET);
                }
            }
            if (cell.getMinion() != null) {
                if (!player.getMainDeck().isContain(cell.getMinion())) {
                    if (cell.getMinion().getHolyCounter() != 0) {
                        ChangeHpBuff changeHp = new ChangeHpBuff(4 - cell.getMinion().getHolyCounter());
                        changeHp.setTurnCounter(1);
                        changeHp.decrement(cell.getMinion());
                        cell.getMinion().getOwnBuffs().add(changeHp);
                    } else {
                        ChangeHpBuff changeHp = new ChangeHpBuff(4);
                        changeHp.setTurnCounter(1);
                        changeHp.decrement(cell.getMinion());
                        cell.getMinion().getOwnBuffs().add(changeHp);
                    }
                } else {
                    view.printError(ErrorType.INVALID_TARGET);
                }
            }
        }
    }

    public Spell duplicate() {
        FireBall fireBall = new FireBall(this);
        return fireBall;
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.FIREBALL.getMessage();
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

    @Override
    public void castBuff(Battle battle, Cell cell, Account player) {
        if (cell.getHero() == null && cell.getMinion() == null) {
            view.printError(ErrorType.INVALID_TARGET);
        } else {
            if (cell.getHero() != null) {
                if (player.getMainDeck().isContain(cell.getHero())) {
                    ChangeApBuff changeAp = new ChangeApBuff(4);
                    changeAp.setTurnCounter(1);
                    changeAp.increment(cell.getHero());
                    cell.getHero().getOwnBuffs().add(changeAp);
                } else {
                    view.printError(ErrorType.INVALID_TARGET);
                }
            }
            if (cell.getMinion() != null) {
                view.printError(ErrorType.INVALID_TARGET);
            }
        }
    }

    public Spell duplicate() {
        GodStrength godStrength = new GodStrength(this);
        return godStrength;
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.GOD_STRENGTH.getMessage();
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

    @Override
    public void castBuff(Battle battle, Cell cell, Account player) {
        ArrayList<Cell> cells = new ArrayList<>();
        cells.add(cell);
        cells.add(rightCell(battle.getMap(),cell));
        cells.add(upCell(battle.getMap(),cells.get(1)));
        cells.add(upCell(battle.getMap(),cell));
        //todo check working
        for (Cell cell1: cells) {
           FiringEffectedCell firingEffectedCell = new FiringEffectedCell();
           firingEffectedCell.setTurnCounter(2);
           cell1.getCellEffect().add(firingEffectedCell);
        }
    }

    public Spell duplicate() {
        HellFire hellFire = new HellFire(this);
        return hellFire;
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.HELL_FIRE.getMessage();
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

    @Override
    public void castBuff(Battle battle, Cell cell, Account player) {
        if (cell.getHero() == null && cell.getMinion() == null) {
            view.printError(ErrorType.INVALID_TARGET);
        } else {
            if (cell.getHero() != null) {
                if (!player.getMainDeck().isContain(cell.getHero())) {
                    if (cell.getHero().getHolyCounter() != 0) {
                        ChangeHpBuff changeHp = new ChangeHpBuff(8 - cell.getHero().getHolyCounter());
                        changeHp.decrement(cell.getHero());
                        changeHp.setTurnCounter(1);
                        cell.getHero().getOwnBuffs().add(changeHp);
                    } else {
                        ChangeHpBuff changeHp = new ChangeHpBuff(8);
                        changeHp.decrement(cell.getMinion());
                        changeHp.setTurnCounter(1);
                        cell.getHero().getOwnBuffs().add(changeHp);
                    }
                } else {
                    view.printError(ErrorType.INVALID_TARGET);
                }
            }
            if (cell.getMinion() != null) {
                view.printError(ErrorType.INVALID_TARGET);
            }
        }
    }

    public Spell duplicate() {
        LightingBolt lightingBolt = new LightingBolt(this);
        return lightingBolt;
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.LIGHTING_BOLT.getMessage();
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

    @Override
    public void castBuff(Battle battle, Cell cell, Account player) {
        ArrayList<Cell> cells = new ArrayList<>();
        cells.add(cell);
        cells.add(rightCell(battle.getMap(),cell));
        cells.add(rightCell(battle.getMap(),cells.get(1)));
        cells.add(upCell(battle.getMap(),cells.get(2)));
        cells.add(upCell(battle.getMap(),cells.get(3)));
        cells.add(leftCell(battle.getMap(),cells.get(4)));
        cells.add(leftCell(battle.getMap(),cells.get(5)));
        cells.add(downCell(battle.getMap(),cells.get(6)));
        cells.add(rightCell(battle.getMap(),cells.get(7)));
        //todo check working
        for (Cell cell1: cells) {
            PoisonEffectedCell poisonEffectedCell = new PoisonEffectedCell();
            poisonEffectedCell.setTurnCounter(1);
            cell1.getCellEffect().add(poisonEffectedCell);
        }
    }

    public Spell duplicate() {
        PoisonLake poisonLake = new PoisonLake(this);
        return poisonLake;
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.POISON_LAKE.getMessage();
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

    @Override
    public void castBuff(Battle battle, Cell cell, Account player) {
        if (cell.getHero() == null && cell.getMinion() == null) {
            view.printError(ErrorType.INVALID_TARGET);
        } else {
            if (cell.getHero() != null) {
                if (player.getMainDeck().isContain(cell.getHero())) {
                    DisarmBuff disarmBuff = new DisarmBuff();
                    disarmBuff.setTurnCounter(3);
                    disarmBuff.disarm(cell.getHero());
                    ChangeApBuff changeAp = new ChangeApBuff(4);
                    changeAp.setTurnCounter(3);
                    changeAp.increment(cell.getHero());
                    cell.getHero().getOwnBuffs().add(disarmBuff);
                    cell.getHero().getOwnBuffs().add(changeAp);
                }
            } else {
                view.printError(ErrorType.INVALID_TARGET);
            }
        }
        if (cell.getMinion() != null) {
            if (player.getMainDeck().isContain(cell.getMinion())) {
                DisarmBuff disarmBuff = new DisarmBuff();
                disarmBuff.setTurnCounter(3);
                disarmBuff.disarm(cell.getMinion());
                ChangeApBuff changeAp = new ChangeApBuff(4);
                changeAp.setTurnCounter(3);
                changeAp.increment(cell.getMinion());
                cell.getMinion().getOwnBuffs().add(disarmBuff);
                cell.getMinion().getOwnBuffs().add(changeAp);
            } else {
                view.printError(ErrorType.INVALID_TARGET);
            }
        }
    }

    public Spell duplicate() {
        Madness madness = new Madness(this);
        return madness;
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.MADNESS.getMessage();
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

    @Override
    public void castBuff(Battle battle, Cell cell, Account player) {
        for (ArrayList<Cell> cells : battle.getMap()) {
            for (Cell cell1 : cells) {
                if (cell1.getHero() != null && !player.getMainDeck().isContain(cell1.getHero())) {
                    DisarmBuff disarmBuff = new DisarmBuff();
                    disarmBuff.disarm(cell1.getHero());
                    disarmBuff.setTurnCounter(1);
                    cell1.getHero().getOwnBuffs().add(disarmBuff);
                }
                if (cell1.getMinion() != null && !player.getMainDeck().isContain(cell1.getMinion())) {
                    DisarmBuff disarmBuff = new DisarmBuff();
                    disarmBuff.disarm(cell1.getMinion());
                    disarmBuff.setTurnCounter(1);
                    cell1.getMinion().getOwnBuffs().add(disarmBuff);
                }
            }
        }
    }

    public Spell duplicate() {
        AllDisarm allDisarm = new AllDisarm(this);
        return allDisarm;
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.ALL_DISARM.getMessage();
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

    @Override
    public void castBuff(Battle battle, Cell cell, Account player) {
        for (ArrayList<Cell> cells : battle.getMap()) {
            for (Cell cell1 : cells) {
                if (cell1.getHero() != null && !player.getMainDeck().isContain(cell1.getHero())) {
                    PoisonBuff poisonBuff = new PoisonBuff();
                    poisonBuff.poison(cell1.getHero());
                    poisonBuff.setTurnCounter(4);
                    cell1.getHero().getOwnBuffs().add(poisonBuff);
                }
                if (cell1.getMinion() != null && !player.getMainDeck().isContain(cell1.getMinion())) {
                    PoisonBuff poisonBuff = new PoisonBuff();
                    poisonBuff.poison(cell1.getMinion());
                    poisonBuff.setTurnCounter(4);
                    cell1.getMinion().getOwnBuffs().add(poisonBuff);
                }
            }
        }
    }

    public AllPoison(AllPoison allPoison) {
        super(allPoison);
    }

    public Spell duplicate() {
        AllPoison allPoison = new AllPoison(this);
        return allPoison;
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.ALL_POISON.getMessage();
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

    @Override
    public void castBuff(Battle battle, Cell cell, Account player) {
        if (cell.getHero() == null && cell.getMinion() == null) {
            view.printError(ErrorType.INVALID_TARGET);
        } else {
            if (cell.getHero() != null) {
                if (!player.getMainDeck().isContain(cell.getHero())) {
                    for (Buff buff : cell.getHero().getOwnBuffs()) {
                        if (dispelEnemyValidation(buff.getClass().getSimpleName())) {
                            buff.dispel(cell.getHero());
                            //todo --> check Working
                        }
                    }
                } else {
                    for (Buff buff : cell.getHero().getOwnBuffs()) {
                        if (dispelInsiderValidation(buff.getClass().getSimpleName())) {
                            buff.dispel(cell.getHero());
                            //todo --> check Working
                        }
                    }
                }
            }
            if (cell.getMinion() != null) {
                if (!player.getMainDeck().isContain(cell.getMinion())) {
                    for (Buff buff : cell.getMinion().getOwnBuffs()) {
                        if (dispelEnemyValidation(buff.getClass().getSimpleName())) {
                            buff.dispel(cell.getMinion());
                            //todo --> check Working
                        }
                    }
                } else {
                    for (Buff buff : cell.getMinion().getOwnBuffs()) {
                        if (dispelInsiderValidation(buff.getClass().getSimpleName())) {
                            buff.dispel(cell.getMinion());
                            //todo --> check Working
                        }
                    }
                }
            }
        }
    }

    public Spell duplicate() {
        Dispel dispel = new Dispel(this);
        return dispel;
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.DISPEL.getMessage();
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

    @Override
    public void castBuff(Battle battle, Cell cell, Account player) {
        if (cell.getHero() == null && cell.getMinion() == null) {
            view.printError(ErrorType.INVALID_TARGET);
        } else {
            if (cell.getHero() != null) {
                if (player.getMainDeck().isContain(cell.getHero())) {
                    WeaknessBuff weaknessBuff = new WeaknessBuff();
                    weaknessBuff.weakness(cell.getHero());
                    weaknessBuff.setTurnCounter(6);
                    cell.getHero().getOwnBuffs().add(weaknessBuff);

                    if (cell.getHero().getHolyCounter() != 0) {
                        ChangeHpBuff changeHp = new ChangeHpBuff(6 - cell.getHero().getHolyCounter());
                        changeHp.decrement(cell.getHero());
                        changeHp.setTurnCounter(3);
                        cell.getHero().getOwnBuffs().add(changeHp);
                    } else {
                        ChangeHpBuff changeHp = new ChangeHpBuff(6);
                        changeHp.decrement(cell.getMinion());
                        changeHp.setTurnCounter(3);
                        cell.getHero().getOwnBuffs().add(changeHp);
                    }

                    HolyBuff holyBuff1 = new HolyBuff();
                    holyBuff1.holy(cell.getHero());
                    holyBuff1.setTurnCounter(3);
                    cell.getHero().getOwnBuffs().add(holyBuff1);
                    HolyBuff holyBuff2 = new HolyBuff();
                    holyBuff2.holy(cell.getHero());
                    holyBuff2.setTurnCounter(3);
                    cell.getHero().getOwnBuffs().add(holyBuff2);
                }
            } else {
                view.printError(ErrorType.INVALID_TARGET);
            }
        }
        if (cell.getMinion() != null) {
            if (player.getMainDeck().isContain(cell.getMinion())) {
                WeaknessBuff weaknessBuff = new WeaknessBuff();
                weaknessBuff.weakness(cell.getMinion());
                weaknessBuff.setTurnCounter(6);
                cell.getMinion().getOwnBuffs().add(weaknessBuff);

                if (cell.getMinion().getHolyCounter() != 0) {
                    ChangeHpBuff changeHp = new ChangeHpBuff(6 - cell.getMinion().getHolyCounter());
                    changeHp.decrement(cell.getMinion());
                    changeHp.setTurnCounter(3);
                    cell.getMinion().getOwnBuffs().add(changeHp);
                } else {
                    ChangeHpBuff changeHp = new ChangeHpBuff(6);
                    changeHp.decrement(cell.getMinion());
                    changeHp.setTurnCounter(3);
                    cell.getMinion().getOwnBuffs().add(changeHp);
                }

                HolyBuff holyBuff1 = new HolyBuff();
                holyBuff1.holy(cell.getMinion());
                holyBuff1.setTurnCounter(3);
                cell.getMinion().getOwnBuffs().add(holyBuff1);
                HolyBuff holyBuff2 = new HolyBuff();
                holyBuff2.holy(cell.getMinion());
                holyBuff2.setTurnCounter(3);
                cell.getMinion().getOwnBuffs().add(holyBuff2);
            } else {
                view.printError(ErrorType.INVALID_TARGET);
            }
        }
    }

    public Spell duplicate() {
        HealthWithProfit healthWithProfit = new HealthWithProfit(this);
        return healthWithProfit;
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.HEALTH_WITH_PROFIT.getMessage();
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

    @Override
    public void castBuff(Battle battle, Cell cell, Account player) {
        if (cell.getHero() == null && cell.getMinion() == null) {
            view.printError(ErrorType.INVALID_TARGET);
        } else {
            if (cell.getHero() != null) {
                if (player.getMainDeck().isContain(cell.getHero())) {
                    ChangeApBuff changeAp = new ChangeApBuff(6);
                    changeAp.setTurnCounter(1);
                    changeAp.increment(cell.getHero());
                    cell.getHero().getOwnBuffs().add(changeAp);

                    PowerBuff powerBuff = new PowerBuff();
                    powerBuff.power(cell.getHero());
                    powerBuff.setTurnCounter(1);
                    cell.getHero().getOwnBuffs().add(powerBuff);
                } else {
                    view.printError(ErrorType.INVALID_TARGET);
                }
            }
            if (cell.getMinion() != null) {
                if (player.getMainDeck().isContain(cell.getMinion())) {
                    ChangeApBuff changeAp = new ChangeApBuff(6);
                    changeAp.setTurnCounter(1);
                    changeAp.increment(cell.getMinion());
                    cell.getMinion().getOwnBuffs().add(changeAp);

                    PowerBuff powerBuff = new PowerBuff();
                    powerBuff.power(cell.getMinion());
                    powerBuff.setTurnCounter(1);
                    cell.getMinion().getOwnBuffs().add(powerBuff);
                } else {
                    view.printError(ErrorType.INVALID_TARGET);
                }
            }
        }
    }

    public Spell duplicate() {
        PowerUp powerUp = new PowerUp(this);
        return powerUp;
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.POWER_UP.getMessage();
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

    @Override
    public void castBuff(Battle battle, Cell cell, Account player) {
        for (ArrayList<Cell> cells : battle.getMap()) {
            for (Cell cell1 : cells) {
                if (cell1.getHero() != null) {
                    if (player.getMainDeck().isContain(cell1.getHero())) {
                        PowerBuff powerBuff = new PowerBuff();
                        powerBuff.setTurnCounter(-5);
                        powerBuff.power(cell1.getHero());
                        cell1.getHero().getOwnBuffs().add(powerBuff);

                        ChangeApBuff changeApBuff = new ChangeApBuff(2);
                        changeApBuff.setTurnCounter(-5);
                        changeApBuff.increment(cell1.getHero());
                        cell1.getHero().getOwnBuffs().add(changeApBuff);
                    }
                }
                if (cell1.getMinion() != null) {
                    if (player.getMainDeck().isContain(cell1.getMinion())) {
                        PowerBuff powerBuff = new PowerBuff();
                        powerBuff.setTurnCounter(-5);
                        powerBuff.power(cell1.getMinion());
                        cell1.getMinion().getOwnBuffs().add(powerBuff);

                        ChangeApBuff changeApBuff = new ChangeApBuff(2);
                        changeApBuff.setTurnCounter(-5);
                        changeApBuff.increment(cell1.getMinion());
                        cell1.getMinion().getOwnBuffs().add(changeApBuff);
                    }
                }
            }
        }
    }

    public Spell duplicate() {
        AllPower allPower = new AllPower(this);
        return allPower;
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.ALL_POWER.getMessage();
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

    @Override
    public void castBuff(Battle battle, Cell cell, Account player) {
        int index = -1;
        for (ArrayList<Cell> cells : battle.getMap()) {
            if (cells.contains(cell)) {
                index = cells.indexOf(cell);
            }
        }
        for (int i = 0; i < battle.getMap().size(); i++) {
            if (battle.getMap().get(i).get(index).getHero() != null) {
                if (!player.getMainDeck().isContain(battle.getMap().get(i).get(index).getHero())) {
                    if (battle.getMap().get(i).get(index).getHero().getHolyCounter() != 0) {
                        ChangeHpBuff changeHp = new ChangeHpBuff(6 - cell.getHero().getHolyCounter());
                        changeHp.decrement(cell.getHero());
                        changeHp.setTurnCounter(1);
                        cell.getHero().getOwnBuffs().add(changeHp);
                    } else {
                        ChangeHpBuff changeHp = new ChangeHpBuff(6);
                        changeHp.decrement(cell.getMinion());
                        changeHp.setTurnCounter(1);
                        cell.getHero().getOwnBuffs().add(changeHp);
                    }
                }
            }
            if (battle.getMap().get(i).get(index).getMinion() != null) {
                if (!player.getMainDeck().isContain(battle.getMap().get(i).get(index).getMinion())) {
                    if (battle.getMap().get(i).get(index).getMinion().getHolyCounter() != 0) {
                        ChangeHpBuff changeHp = new ChangeHpBuff(6 - cell.getMinion().getHolyCounter());
                        changeHp.decrement(cell.getMinion());
                        changeHp.setTurnCounter(1);
                        battle.getMap().get(i).get(index).getMinion().getOwnBuffs().add(changeHp);
                    } else {
                        ChangeHpBuff changeHp = new ChangeHpBuff(6);
                        changeHp.decrement(cell.getMinion());
                        changeHp.setTurnCounter(1);
                        battle.getMap().get(i).get(index).getHero().getOwnBuffs().add(changeHp);
                    }
                }
            }
        }
    }

    public Spell duplicate() {
        AllAttack allAttack = new AllAttack(this);
        return allAttack;
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.ALL_ATTACK.getMessage();
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

    @Override
    public void castBuff(Battle battle, Cell cell, Account player) {
        if (cell.getHero() == null && cell.getMinion() == null) {
            view.printError(ErrorType.INVALID_TARGET);
        } else {
            if (cell.getMinion() != null) {
                if (!player.getMainDeck().isContain(cell.getMinion())) {
                    ChangeApBuff changeAp = new ChangeApBuff(4);
                    changeAp.setTurnCounter(1);
                    changeAp.decrement(cell.getMinion());
                    cell.getMinion().getOwnBuffs().add(changeAp);

                    WeaknessBuff weaknessBuff = new WeaknessBuff();
                    weaknessBuff.weakness(cell.getMinion());
                    weaknessBuff.setTurnCounter(1);
                    cell.getMinion().getOwnBuffs().add(weaknessBuff);
                } else {
                    view.printError(ErrorType.INVALID_TARGET);
                }
            }
            if (cell.getMinion() != null) {
                view.printError(ErrorType.INVALID_TARGET);
            }
        }
    }

    public Spell duplicate() {
        Weakening weakening = new Weakening(this);
        return weakening;
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.WEAKENING.getMessage();
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

    @Override
    public void castBuff(Battle battle, Cell cell, Account player) {
        if (cell.getHero() == null && cell.getMinion() == null) {
            view.printError(ErrorType.INVALID_TARGET);
        } else {
            if (cell.getMinion() != null) {
                if (player.getMainDeck().isContain(cell.getMinion())) {
                    ChangeApBuff changeAp = new ChangeApBuff(8);
                    changeAp.setTurnCounter(1);
                    changeAp.increment(cell.getMinion());
                    cell.getMinion().getOwnBuffs().add(changeAp);

                    WeaknessBuff weaknessBuff = new WeaknessBuff();
                    weaknessBuff.weakness(cell.getMinion());
                    weaknessBuff.setTurnCounter(1);
                    cell.getMinion().getOwnBuffs().add(weaknessBuff);

                    PowerBuff powerBuff = new PowerBuff();
                    powerBuff.setTurnCounter(1);
                    powerBuff.power(cell.getMinion());
                    cell.getMinion().getOwnBuffs().add(powerBuff);

                    if (cell.getMinion().getHolyCounter() != 0) {
                        ChangeHpBuff changeHp = new ChangeHpBuff(6 - cell.getMinion().getHolyCounter());
                        changeHp.decrement(cell.getMinion());
                        changeHp.setTurnCounter(1);
                        cell.getMinion().getOwnBuffs().add(changeHp);
                    } else {
                        ChangeHpBuff changeHp = new ChangeHpBuff(6);
                        changeHp.decrement(cell.getMinion());
                        changeHp.setTurnCounter(1);
                        cell.getMinion().getOwnBuffs().add(changeHp);
                    }
                } else {
                    view.printError(ErrorType.INVALID_TARGET);
                }
            }
            if (cell.getMinion() != null) {
                view.printError(ErrorType.INVALID_TARGET);
            }
        }
    }

    public Spell duplicate() {
        Sacrifice sacrifice = new Sacrifice(this);
        return sacrifice;
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.SACRIFICE.getMessage();
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

    @Override
    public void castBuff(Battle battle, Cell cell, Account player) {
        ArrayList<Cell> cells = new ArrayList<>();
        cells.add(rightCell(battle.getMap(),cell));
        cells.add(upCell(battle.getMap(),cells.get(0)));
        cells.add(leftCell(battle.getMap(),cells.get(1)));
        cells.add(leftCell(battle.getMap(),cells.get(2)));
        cells.add(downCell(battle.getMap(),cells.get(3)));
        cells.add(downCell(battle.getMap(),cells.get(4)));
        cells.add(rightCell(battle.getMap(),cells.get(5)));
        cells.add(rightCell(battle.getMap(),cells.get(6)));
        for (Cell cell1: cells) {
            if (cell1.getMinion() != null && player.getMainDeck().isContain(cell1.getMinion())){
                cell1.getMinion().setHp(0);
                //todo goto graveyard
            }
        }
    }

    public Spell duplicate() {
        KingsGuard kingsGuard = new KingsGuard(this);
        return kingsGuard;
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.KINGS_GUARD.getMessage();
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

    @Override
    public void castBuff(Battle battle, Cell cell, Account player) {
        if (cell.getMinion() == null && cell.getHero() == null) {
            view.printError(ErrorType.INVALID_TARGET);
        } else {
            if (cell.getHero() != null) {
                if (!player.getMainDeck().isContain(cell.getHero())) {
                    StunBuff stunBuff = new StunBuff();
                    stunBuff.stun(cell.getHero());
                    stunBuff.setTurnCounter(2);
                    cell.getHero().getOwnBuffs().add(stunBuff);
                } else {
                    view.printError(ErrorType.INVALID_TARGET);
                }
            }
            if (cell.getMinion() != null) {
                if (!player.getMainDeck().isContain(cell.getMinion())) {
                    StunBuff stunBuff = new StunBuff();
                    stunBuff.stun(cell.getMinion());
                    stunBuff.setTurnCounter(2);
                    cell.getMinion().getOwnBuffs().add(stunBuff);
                } else {
                    view.printError(ErrorType.INVALID_TARGET);
                }
            }
        }
    }

    public Spell duplicate() {
        Shock shock = new Shock(this);
        return shock;
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.SHOCK.getMessage();
        return details;
    }
}
package model.Cards;

import model.Buffs.*;
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

    public abstract void castSpell(Battle battle, Cell cell, Account player);

    public static ArrayList<Spell> getSpells() {
        return spells;
    }

    public int getCostToUse() {
        return costToUse;
    }

    public abstract String getDesc();

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
    HEALTH_WITH_PROFIT("Give friend force a decrement buff or reduce HP of force 6 units" +
            "but have 2 holy buff for 3 turns"),
    POWER_UP("Apply a power buff and add 6AP for an insider force"),
    ALL_POWER("Apply a power buff and add 6AP for all insider forces permanently"),
    ALL_ATTACK("Hit all enemy forces who in one column 6units"),
    WEAKENING("Give a enemy minion a decrement buff or reduce HP of minion 4 units"),
    SACRIFICE("Give a insider minion a decrement buff or reduce HP of minion 6 units" +
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
    public void castSpell(Battle battle, Cell cell, Account player) {
        if (cell.getMinion() == null && cell.getHero() == null) {
            view.printError(ErrorType.INVALID_TARGET);
        } else {
            if (cell.getHero() != null) {
                if (!player.getMainDeck().isContain(cell.getHero())) {
                    DisarmBuff disarmBuff = new DisarmBuff();
                    disarmBuff.setTurnCounter(-5);//-5 means until end of game
                    disarmBuff.disarm(cell.getHero());
                    disarmBuff.setCasting(disarmBuff, null, cell.getHero(), null);
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
                    disarmBuff.setCasting(disarmBuff, null, null, cell.getMinion());
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
    public String getDesc() {
        return SpellWork.TOTAL_DISARM.getMessage();
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

    public String getDesc() {
        return SpellWork.AREA_DISPEL.getMessage();
    }

    @Override
    public void castSpell(Battle battle, Cell cell, Account player) {
        ArrayList<Cell> cells = new ArrayList<>();
        cells.add(cell);
        cells.add(cell.rightCell(battle.getMap()));
        cells.add(cell.downCell(battle.getMap()));
        cells.add(cells.get(1).downCell(battle.getMap()));
        //todo check working
        for (Cell cell1 : cells) {
            Dispel dispel = new Dispel();
            dispel.castSpell(battle, cell1, player);
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
    public void castSpell(Battle battle, Cell cell, Account player) {
        if (cell.getHero() == null && cell.getMinion() == null) {
            view.printError(ErrorType.INVALID_TARGET);
        } else {
            if (cell.getHero() != null) {
                if (player.getMainDeck().isContain(cell.getHero())) {
                    ChangeApBuff changeAp = new ChangeApBuff(2);
                    changeAp.setTurnCounter(1);
                    changeAp.increment(cell.getHero());
                    changeAp.setCasting(changeAp, null, cell.getHero(), null);
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
                    changeAp.setCasting(changeAp, null, null, cell.getMinion());
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

    public String getDesc() {
        return SpellWork.EMPOWER.getMessage();
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
    public void castSpell(Battle battle, Cell cell, Account player) {
        if (cell.getHero() == null && cell.getMinion() == null) {
            view.printError(ErrorType.INVALID_TARGET);
        } else {
            if (cell.getHero() != null) {
                if (!player.getMainDeck().isContain(cell.getHero())) {
                    ChangeHpBuff changeHp = new ChangeHpBuff(4 - cell.getHero().getHolyCounter());
                    changeHp.setTurnCounter(1);
                    changeHp.decrement(cell.getHero());
                    changeHp.setCasting(changeHp, null, cell.getHero(), null);
                    cell.getHero().getOwnBuffs().add(changeHp);
                } else {
                    view.printError(ErrorType.INVALID_TARGET);
                }
            }
            else if (cell.getMinion() != null) {
                if (!player.getMainDeck().isContain(cell.getMinion())) {
                    ChangeHpBuff changeHp = new ChangeHpBuff(4 - cell.getMinion().getHolyCounter());
                    changeHp.setTurnCounter(1);
                    changeHp.decrement(cell.getMinion());
                    changeHp.setCasting(changeHp, null, null, cell.getMinion());
                    cell.getMinion().getOwnBuffs().add(changeHp);
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
    public String getDesc() {
        return SpellWork.FIREBALL.getMessage();
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
    public void castSpell(Battle battle, Cell cell, Account player) {
        if (cell.getHero() == null && cell.getMinion() == null) {
            view.printError(ErrorType.INVALID_TARGET);
        } else {
            if (cell.getHero() != null) {
                if (player.getMainDeck().isContain(cell.getHero())) {
                    ChangeApBuff changeAp = new ChangeApBuff(4);
                    changeAp.setTurnCounter(1);
                    changeAp.increment(cell.getHero());
                    changeAp.setCasting(changeAp, null, cell.getHero(), null);
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
    public String getDesc() {
        return SpellWork.GOD_STRENGTH.getMessage();
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
    public void castSpell(Battle battle, Cell cell, Account player) {
        ArrayList<Cell> cells = new ArrayList<>();
        cells.add(cell);
        cells.add(cell.rightCell(battle.getMap()));
        cells.add(cells.get(1).downCell(battle.getMap()));
        cells.add(cell.downCell(battle.getMap()));
        //todo check working
        for (Cell cell1 : cells) {
            FiringEffectedCell firingEffectedCell = new FiringEffectedCell();
            firingEffectedCell.setTurnCounter(2);
            firingEffectedCell.firing(cell1);
            firingEffectedCell.setCasting(firingEffectedCell, cell1, null, null);
            cell1.getCellEffect().add(firingEffectedCell);
        }
    }

    public Spell duplicate() {
        HellFire hellFire = new HellFire(this);
        return hellFire;
    }

    @Override
    public String getDesc() {
        return SpellWork.HELL_FIRE.getMessage();
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
    public void castSpell(Battle battle, Cell cell, Account player) {
        if (cell.getHero() == null && cell.getMinion() == null) {
            view.printError(ErrorType.INVALID_TARGET);
        } else {
            if (cell.getHero() != null) {
                if (!player.getMainDeck().isContain(cell.getHero())) {
                    ChangeHpBuff changeHp = new ChangeHpBuff(8 - cell.getHero().getHolyCounter());
                    changeHp.decrement(cell.getHero());
                    changeHp.setTurnCounter(1);
                    changeHp.setCasting(changeHp, null, cell.getHero(), null);
                    cell.getHero().getOwnBuffs().add(changeHp);
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
    public String getDesc() {
        return SpellWork.LIGHTING_BOLT.getMessage();
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
    public void castSpell(Battle battle, Cell cell, Account player) {
        ArrayList<Cell> cells = new ArrayList<>();
        cells.add(cell);
        cells.add(cell.rightCell(battle.getMap()));
        cells.add(cells.get(1).rightCell(battle.getMap()));
        cells.add(cells.get(2).downCell(battle.getMap()));
        cells.add(cells.get(3).downCell(battle.getMap()));
        cells.add(cells.get(4).leftCell(battle.getMap()));
        cells.add(cells.get(5).leftCell(battle.getMap()));
        cells.add(cells.get(6).upCell(battle.getMap()));
        cells.add(cells.get(7).rightCell(battle.getMap()));
        //todo check working
        for (Cell cell1 : cells) {
            PoisonEffectedCell poisonEffectedCell = new PoisonEffectedCell();
            poisonEffectedCell.setTurnCounter(1);
            poisonEffectedCell.setCasting(poisonEffectedCell, cell1, null, null);
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

    @Override
    public String getDesc() {
        return SpellWork.POISON_LAKE.getMessage();
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
    public void castSpell(Battle battle, Cell cell, Account player) {
        if (cell.getHero() == null && cell.getMinion() == null) {
            view.printError(ErrorType.INVALID_TARGET);
        } else {
            if (cell.getHero() != null) {
                if (player.getMainDeck().isContain(cell.getHero())) {
                    DisarmBuff disarmBuff = new DisarmBuff();
                    disarmBuff.setTurnCounter(3);
                    disarmBuff.disarm(cell.getHero());
                    disarmBuff.setCasting(disarmBuff, null, cell.getHero(), null);
                    ChangeApBuff changeAp = new ChangeApBuff(4);
                    changeAp.setTurnCounter(3);
                    changeAp.increment(cell.getHero());
                    changeAp.setCasting(changeAp, null, cell.getHero(), null);
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
                disarmBuff.setCasting(disarmBuff, null, null, cell.getMinion());
                ChangeApBuff changeAp = new ChangeApBuff(4);
                changeAp.setTurnCounter(3);
                changeAp.increment(cell.getMinion());
                changeAp.setCasting(changeAp, null, null, cell.getMinion());
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
    public String getDesc() {
        return SpellWork.MADNESS.getMessage();
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
    public void castSpell(Battle battle, Cell cell, Account player) {
        for (ArrayList<Cell> cells : battle.getMap()) {
            for (Cell cell1 : cells) {
                if (cell1.getHero() != null && !player.getMainDeck().isContain(cell1.getHero())) {
                    DisarmBuff disarmBuff = new DisarmBuff();
                    disarmBuff.disarm(cell1.getHero());
                    disarmBuff.setTurnCounter(1);
                    disarmBuff.setCasting(disarmBuff, null, cell1.getHero(), null);
                    cell1.getHero().getOwnBuffs().add(disarmBuff);
                }
                if (cell1.getMinion() != null && !player.getMainDeck().isContain(cell1.getMinion())) {
                    DisarmBuff disarmBuff = new DisarmBuff();
                    disarmBuff.disarm(cell1.getMinion());
                    disarmBuff.setTurnCounter(1);
                    disarmBuff.setCasting(disarmBuff, null, null, cell1.getMinion());
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
    public String getDesc() {
        return SpellWork.ALL_DISARM.getMessage();
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
    public void castSpell(Battle battle, Cell cell, Account player) {
        for (ArrayList<Cell> cells : battle.getMap()) {
            for (Cell cell1 : cells) {
                if (cell1.getHero() != null && !player.getMainDeck().isContain(cell1.getHero())) {
                    PoisonBuff poisonBuff = new PoisonBuff();
                    poisonBuff.poison(cell1.getHero());
                    poisonBuff.setTurnCounter(4);
                    poisonBuff.setCasting(poisonBuff, null, cell1.getHero(), null);
                    cell1.getHero().getOwnBuffs().add(poisonBuff);
                }
                if (cell1.getMinion() != null && !player.getMainDeck().isContain(cell1.getMinion())) {
                    PoisonBuff poisonBuff = new PoisonBuff();
                    poisonBuff.poison(cell1.getMinion());
                    poisonBuff.setTurnCounter(4);
                    poisonBuff.setCasting(poisonBuff, null, null, cell1.getMinion());
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
    public String getDesc() {
        return SpellWork.ALL_POISON.getMessage();
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
    public void castSpell(Battle battle, Cell cell, Account player) {
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
    public String getDesc() {
        return SpellWork.DISPEL.getMessage();
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
    public void castSpell(Battle battle, Cell cell, Account player) {
        if (cell.getHero() == null && cell.getMinion() == null) {
            view.printError(ErrorType.INVALID_TARGET);
        } else {
            if (cell.getHero() != null) {
                if (player.getMainDeck().isContain(cell.getHero())) {
                    WeaknessBuff weaknessBuff = new WeaknessBuff(6 - cell.getHero().getHolyCounter(), false);
                    weaknessBuff.decrementHp(cell.getHero());
                    weaknessBuff.setTurnCounter(3);
                    weaknessBuff.setCasting(weaknessBuff, null, cell.getHero(), null);
                    cell.getHero().getOwnBuffs().add(weaknessBuff);
                    for (int i = 0; i < 2; i++) {
                        HolyBuff holyBuff = new HolyBuff();
                        holyBuff.holy(cell.getHero());
                        holyBuff.setTurnCounter(3);
                        holyBuff.setCasting(holyBuff, null, cell.getHero(), null);
                        cell.getHero().getOwnBuffs().add(holyBuff);
                    }
                }
            } else {
                view.printError(ErrorType.INVALID_TARGET);
            }
        }
        if (cell.getMinion() != null) {
            if (player.getMainDeck().isContain(cell.getMinion())) {
                WeaknessBuff weaknessBuff = new WeaknessBuff(6 - cell.getMinion().getHolyCounter(), false);
                weaknessBuff.decrementHp(cell.getMinion());
                weaknessBuff.setTurnCounter(6);
                weaknessBuff.setCasting(weaknessBuff, null, null, cell.getMinion());
                cell.getMinion().getOwnBuffs().add(weaknessBuff);

                for (int i = 0; i < 2; i++) {
                    HolyBuff holyBuff = new HolyBuff();
                    holyBuff.holy(cell.getMinion());
                    holyBuff.setTurnCounter(3);
                    holyBuff.setCasting(holyBuff, null, null, cell.getMinion());
                    cell.getMinion().getOwnBuffs().add(holyBuff);
                }
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
    public String getDesc() {
        return SpellWork.HEALTH_WITH_PROFIT.getMessage();
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
    public void castSpell(Battle battle, Cell cell, Account player) {
        if (cell.getHero() == null && cell.getMinion() == null) {
            view.printError(ErrorType.INVALID_TARGET);
        } else {
            if (cell.getHero() != null) {
                if (player.getMainDeck().isContain(cell.getHero())) {
                    PowerBuff powerBuff = new PowerBuff(6, true);
                    powerBuff.incrementAp(cell.getHero());
                    powerBuff.setTurnCounter(1);
                    powerBuff.setCasting(powerBuff, null, cell.getHero(), null);
                    cell.getHero().getOwnBuffs().add(powerBuff);
                } else {
                    view.printError(ErrorType.INVALID_TARGET);
                }
            }
            if (cell.getMinion() != null) {
                if (player.getMainDeck().isContain(cell.getMinion())) {
                    PowerBuff powerBuff = new PowerBuff(6, true);
                    powerBuff.incrementAp(cell.getMinion());
                    powerBuff.setTurnCounter(1);
                    powerBuff.setCasting(powerBuff, null, null, cell.getMinion());
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
    public String getDesc() {
        return SpellWork.POWER_UP.getMessage();
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
    public void castSpell(Battle battle, Cell cell, Account player) {
        for (ArrayList<Cell> cells : battle.getMap()) {
            for (Cell cell1 : cells) {
                if (cell1.getHero() != null) {
                    if (player.getMainDeck().isContain(cell1.getHero())) {
                        PowerBuff powerBuff = new PowerBuff(2, true);
                        powerBuff.setTurnCounter(-5);
                        powerBuff.incrementAp(cell1.getHero());
                        powerBuff.setCasting(powerBuff, null, cell1.getHero(), null);
                        cell1.getHero().getOwnBuffs().add(powerBuff);
                    }
                }
                if (cell1.getMinion() != null) {
                    if (player.getMainDeck().isContain(cell1.getMinion())) {
                        PowerBuff powerBuff = new PowerBuff(2, true);
                        powerBuff.setTurnCounter(-5);
                        powerBuff.incrementAp(cell1.getMinion());
                        powerBuff.setCasting(powerBuff, null, null, cell1.getMinion());
                        cell1.getMinion().getOwnBuffs().add(powerBuff);
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
    public String getDesc() {
        return SpellWork.ALL_POWER.getMessage();
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
    public void castSpell(Battle battle, Cell cell, Account player) {
        int index = -1;
        for (ArrayList<Cell> cells : battle.getMap()) {
            if (cells.contains(cell)) {
                index = cells.indexOf(cell);
            }
        }
        for (int i = 0; i < battle.getMap().size(); i++) {
            if (battle.getMap().get(i).get(index).getHero() != null) {
                if (!player.getMainDeck().isContain(battle.getMap().get(i).get(index).getHero())) {
                    ChangeHpBuff changeHp = new ChangeHpBuff(6 - battle.getMap().get(i).get(index).getHero().getHolyCounter());
                    changeHp.decrement(battle.getMap().get(i).get(index).getHero());
                    changeHp.setTurnCounter(1);
                    changeHp.setCasting(changeHp, null, battle.getMap().get(i).get(index).getHero(), null);
                    battle.getMap().get(i).get(index).getHero().getOwnBuffs().add(changeHp);
                }
            }
            if (battle.getMap().get(i).get(index).getMinion() != null) {
                if (!player.getMainDeck().isContain(battle.getMap().get(i).get(index).getMinion())) {
                    ChangeHpBuff changeHp = new ChangeHpBuff(6 - battle.getMap().get(i).get(index).getMinion().getHolyCounter());
                    changeHp.decrement(battle.getMap().get(i).get(index).getHero());
                    changeHp.setTurnCounter(1);
                    changeHp.setCasting(changeHp, null, null, battle.getMap().get(i).get(index).getMinion());
                    battle.getMap().get(i).get(index).getMinion().getOwnBuffs().add(changeHp);
                }
            }
        }
    }

    public Spell duplicate() {
        AllAttack allAttack = new AllAttack(this);
        return allAttack;
    }


    @Override
    public String getDesc() {
        return SpellWork.ALL_ATTACK.getMessage();
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
    public void castSpell(Battle battle, Cell cell, Account player) {
        if (cell.getHero() == null && cell.getMinion() == null) {
            view.printError(ErrorType.INVALID_TARGET);
        } else {
            if (cell.getMinion() != null) {
                if (!player.getMainDeck().isContain(cell.getMinion())) {
                    WeaknessBuff weaknessBuff = new WeaknessBuff(4, true);
                    weaknessBuff.decrementAp(cell.getMinion());
                    weaknessBuff.setTurnCounter(1);
                    weaknessBuff.setCasting(weaknessBuff, null, null, cell.getMinion());
                    cell.getMinion().getOwnBuffs().add(weaknessBuff);
                } else {
                    view.printError(ErrorType.INVALID_TARGET);
                }
            }
            if (cell.getHero() != null) {
                view.printError(ErrorType.INVALID_TARGET);
            }
        }
    }

    public Spell duplicate() {
        Weakening weakening = new Weakening(this);
        return weakening;
    }


    @Override
    public String getDesc() {
        return SpellWork.WEAKENING.getMessage();
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
    public void castSpell(Battle battle, Cell cell, Account player) {
        if (cell.getHero() == null && cell.getMinion() == null) {
            view.printError(ErrorType.INVALID_TARGET);
        } else {
            if (cell.getMinion() != null) {
                if (player.getMainDeck().isContain(cell.getMinion())) {
                    PowerBuff powerBuff = new PowerBuff(8, true);
                    powerBuff.setTurnCounter(1);
                    powerBuff.incrementAp(cell.getMinion());
                    powerBuff.setCasting(powerBuff, null, null, cell.getMinion());
                    cell.getMinion().getOwnBuffs().add(powerBuff);

                    WeaknessBuff weaknessBuff = new WeaknessBuff(6 - cell.getMinion().getHolyCounter(), false);
                    weaknessBuff.decrementAp(cell.getMinion());
                    weaknessBuff.setTurnCounter(1);
                    weaknessBuff.setCasting(weaknessBuff, null, null, cell.getMinion());
                    cell.getMinion().getOwnBuffs().add(weaknessBuff);
                } else {
                    view.printError(ErrorType.INVALID_TARGET);
                }
            }
            if (cell.getHero() != null) {
                view.printError(ErrorType.INVALID_TARGET);
            }
        }
    }

    public Spell duplicate() {
        Sacrifice sacrifice = new Sacrifice(this);
        return sacrifice;
    }

    @Override
    public String getDesc() {
        return SpellWork.SACRIFICE.getMessage();
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
    public void castSpell(Battle battle, Cell cell, Account player) {
        ArrayList<Cell> cells = new ArrayList<>();
        cells.add(cell.rightCell(battle.getMap()));
        cells.add(cells.get(0).downCell(battle.getMap()));
        cells.add(cells.get(1).leftCell(battle.getMap()));
        cells.add(cells.get(2).leftCell(battle.getMap()));
        cells.add(cells.get(3).upCell(battle.getMap()));
        cells.add(cells.get(4).upCell(battle.getMap()));
        cells.add(cells.get(5).rightCell(battle.getMap()));
        cells.add(cells.get(6).rightCell(battle.getMap()));
        for (Cell cell1 : cells) {
            if (cell1.getMinion() != null && player.getMainDeck().isContain(cell1.getMinion())) {
                cell1.getMinion().setHp(0);
                break;
                //todo goto graveyard
            }
        }
    }

    public Spell duplicate() {
        KingsGuard kingsGuard = new KingsGuard(this);
        return kingsGuard;
    }


    @Override
    public String getDesc() {
        return SpellWork.KINGS_GUARD.getMessage();
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
    public void castSpell(Battle battle, Cell cell, Account player) {
        if (cell.getMinion() == null && cell.getHero() == null) {
            view.printError(ErrorType.INVALID_TARGET);
        } else {
            if (cell.getHero() != null) {
                if (!player.getMainDeck().isContain(cell.getHero())) {
                    StunBuff stunBuff = new StunBuff();
                    stunBuff.stun(cell.getHero());
                    stunBuff.setTurnCounter(2);
                    stunBuff.setCasting(stunBuff, null, cell.getHero(), null);
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
                    stunBuff.setCasting(stunBuff, null, null, cell.getMinion());
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
    public String getDesc() {
        return SpellWork.SHOCK.getMessage();
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
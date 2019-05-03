package model.Cards;


import com.sun.javaws.exceptions.ErrorCodeResponseException;
import model.Battles.Battle;
import model.Buffs.*;
import model.Cell;
import model.Deck;
import model.ErrorType;
import model.Menus.Account;
import view.Request;

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
    private boolean useSpecial = false;
    private int typeOfRange;//0 melee 1 ranged 2 hybrid
    private int range;
    private int coolDownTime;
    private ArrayList<Buff> ownBuffs = new ArrayList<>();

    public ArrayList<Buff> getOwnBuffs() {
        return ownBuffs;
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
    }

    public void setCoolDownTime(int coolDownTime) {
        this.coolDownTime = coolDownTime;
    }

    public int getCoolDownTime() {
        return coolDownTime;
    }

    public int getMp() {
        return mp;
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

    public abstract void castSpecialPower(Battle battle, Cell cell, Account player, Request request);

    public abstract String getDesc();

    public Hero duplicate() {
        return null;//todo --> can be abstract
    }

    public void setUseSpecial(boolean useSpecial) {
        this.useSpecial = useSpecial;
    }

    public boolean isUseSpecial() {
        return useSpecial;
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
                + " - Class : " + this.getTypeOfHit() + " – Special power : " + SpecialPower.WHITE_BOGEY.getMessage();
        return details;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, Request request) {
        if (!this.isUseSpecial()) {
            if (player.getMana() >= this.getMp()) {
                ChangeApBuff changeApBuff = new ChangeApBuff(4);
                changeApBuff.increment(this);
                changeApBuff.setTurnCounter(-5);
                changeApBuff.setCasting(changeApBuff, null, this, null);
                this.getOwnBuffs().add(changeApBuff);
                player.setMana(player.getMana() - this.getMp());
            } else request.setError(ErrorType.DONT_HAVE_ENOUGH_MANA);
        } else request.setError(ErrorType.DIDNT_PASS_ENOUGH_TIME);
    }

    @Override
    public String getDesc() {
        return SpecialPower.WHITE_BOGEY.getMessage();
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
                + " - Class : " + this.getTypeOfHit() + " – Special power : " + SpecialPower.SIMURGH.getMessage();
        return details;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, Request request) {
        if (!this.isUseSpecial()) {
            if (player.getMana() >= this.getMp()) {
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 9; j++) {
                        if (battle.getMap().get(i).get(j).getHero() != null) {
                            if (!player.getMainDeck().isContain(battle.getMap().get(i).get(j).getHero())) {
                                StunBuff stunBuff = new StunBuff();
                                stunBuff.setTurnCounter(1);
                                stunBuff.stun(battle.getMap().get(i).get(j).getHero());
                                stunBuff.setCasting(stunBuff, null, battle.getMap().get(i).get(j).getHero(), null);
                                battle.getMap().get(i).get(j).getHero().getOwnBuffs().add(stunBuff);
                            }
                        } else if (battle.getMap().get(i).get(j).getMinion() != null) {
                            if (!player.getMainDeck().isContain(battle.getMap().get(i).get(j).getMinion())) {
                                StunBuff stunBuff = new StunBuff();
                                stunBuff.setTurnCounter(1);
                                stunBuff.stun(battle.getMap().get(i).get(j).getMinion());
                                stunBuff.setCasting(stunBuff, null, null, battle.getMap().get(i).get(j).getMinion());
                                battle.getMap().get(i).get(j).getMinion().getOwnBuffs().add(stunBuff);
                            }
                        }
                    }
                }
            } else request.setError(ErrorType.DONT_HAVE_ENOUGH_MANA);
        } else request.setError(ErrorType.DIDNT_PASS_ENOUGH_TIME);
    }

    @Override
    public String getDesc() {
        return SpecialPower.SIMURGH.getMessage();
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
                + " - Class : " + this.getTypeOfHit() + " – Special power : " + SpecialPower.DRAGON.getMessage();
        return details;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, Request request) {
        if (!this.isUseSpecial()) {
            if (player.getMana() >= this.getMp()) {
                if (cell.getHero() != null) {
                    if (!player.getMainDeck().isContain(cell.getHero())) {
                        DisarmBuff disarmBuff = new DisarmBuff();
                        disarmBuff.setTurnCounter(1);
                        disarmBuff.disarm(cell.getHero());
                        disarmBuff.setCasting(disarmBuff, null, cell.getHero(), null);
                        cell.getHero().getOwnBuffs().add(disarmBuff);
                    } else request.setError(ErrorType.SELF_HARM);
                } else if (cell.getMinion() != null) {
                    if (!player.getMainDeck().isContain(cell.getMinion())) {
                        DisarmBuff disarmBuff = new DisarmBuff();
                        disarmBuff.setTurnCounter(1);
                        disarmBuff.disarm(cell.getMinion());
                        disarmBuff.setCasting(disarmBuff, null, null, cell.getMinion());
                        cell.getMinion().getOwnBuffs().add(disarmBuff);
                    } else request.setError(ErrorType.SELF_HARM);
                } else request.setError(ErrorType.EMPTY_CELL);
            } else request.setError(ErrorType.DONT_HAVE_ENOUGH_MANA);
        } else request.setError(ErrorType.DIDNT_PASS_ENOUGH_TIME);
    }

    public String getDesc() {
        return SpecialPower.DRAGON.getMessage();
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
                + " - Class : " + this.getTypeOfHit() + " – Special power : " + SpecialPower.RAKHSH.getMessage();
        return details;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, Request request) {
        if (!this.isUseSpecial()) {
            if (player.getMana() >= this.getMp()) {
                if (cell.getHero() != null) {
                    if (!player.getMainDeck().isContain(cell.getHero())) {
                        StunBuff stunBuff = new StunBuff();
                        stunBuff.setTurnCounter(1);
                        stunBuff.stun(cell.getHero());
                        stunBuff.setCasting(stunBuff, null, cell.getHero(), null);
                        cell.getHero().getOwnBuffs().add(stunBuff);
                    } else request.setError(ErrorType.SELF_HARM);
                } else if (cell.getMinion() != null) {
                    if (!player.getMainDeck().isContain(cell.getMinion())) {
                        StunBuff stunBuff = new StunBuff();
                        stunBuff.setTurnCounter(1);
                        stunBuff.stun(cell.getMinion());
                        stunBuff.setCasting(stunBuff, null, null, cell.getMinion());
                        cell.getMinion().getOwnBuffs().add(stunBuff);
                    } else request.setError(ErrorType.SELF_HARM);
                } else request.setError(ErrorType.EMPTY_CELL);
            } else request.setError(ErrorType.DONT_HAVE_ENOUGH_MANA);
        } else request.setError(ErrorType.DIDNT_PASS_ENOUGH_TIME);
    }

    public String getDesc() {
        return SpecialPower.RAKHSH.getMessage();
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
                + " - Class : " + this.getTypeOfHit() + " – Special power : " + SpecialPower.ZAHHAK.getMessage();
        return details;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, Request request) {
        if (cell.getHero() != null) {
            if (!player.getMainDeck().isContain(cell.getHero())) {
                PoisonBuff poisonBuff = new PoisonBuff();
                poisonBuff.setTurnCounter(3);
                poisonBuff.poison(cell.getHero());
                poisonBuff.setCasting(poisonBuff, null, cell.getHero(), null);
                cell.getHero().getOwnBuffs().add(poisonBuff);
            } else request.setError(ErrorType.SELF_HARM);
        } else if (cell.getMinion() != null) {
            if (!player.getMainDeck().isContain(cell.getMinion())) {
                PoisonBuff poisonBuff = new PoisonBuff();
                poisonBuff.setTurnCounter(3);
                poisonBuff.poison(cell.getMinion());
                poisonBuff.setCasting(poisonBuff, null, null, cell.getMinion());
                cell.getMinion().getOwnBuffs().add(poisonBuff);
            } else request.setError(ErrorType.SELF_HARM);
        } else request.setError(ErrorType.EMPTY_CELL);
    }

    public String getDesc() {
        return SpecialPower.ZAHHAK.getMessage();
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
                + " - Class : " + this.getTypeOfHit() + " – Special power : " + SpecialPower.KAVEH.getMessage();
        return details;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, Request request) {
        if (!this.isUseSpecial()) {
            if (player.getMana() >= this.getMp()) {
                HolyEffectedCell holyEffectedCell = new HolyEffectedCell();
                holyEffectedCell.setTurnCounter(3);
                if (cell.getHero() != null) {
                    holyEffectedCell.holy(cell.getHero());
                } else if (cell.getMinion() != null) {
                    holyEffectedCell.holy(cell.getMinion());
                }
                holyEffectedCell.setCasting(holyEffectedCell, cell, null, null);
                cell.getCellEffect().add(holyEffectedCell);
            } else request.setError(ErrorType.DONT_HAVE_ENOUGH_MANA);
        } else request.setError(ErrorType.DIDNT_PASS_ENOUGH_TIME);
    }

    public String getDesc() {
        return SpecialPower.KAVEH.getMessage();
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
                + " - Class : " + this.getTypeOfHit() + " – Special power : " + SpecialPower.ARASH.getMessage();
        return details;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, Request request) {
        if (!this.isUseSpecial()) {
            if (player.getMana() >= this.getMp()) {
                int indexOfRow = -1;
                for (int i = 0; i < 5; i++) {
                    if (battle.getMap().get(i).contains(cell)) {
                        indexOfRow = i;
                        break;
                    }
                }
                for (int i = 0; i < 9; i++) {
                    if (battle.getMap().get(indexOfRow).get(i).getHero() != null) {
                        battle.getMap().get(indexOfRow).get(i).getHero().decrementHp(4 - battle.getMap().get(indexOfRow).get(i).getHero().getHolyCounter());
                    } else if (battle.getMap().get(indexOfRow).get(i).getMinion() != null) {
                        battle.getMap().get(indexOfRow).get(i).getMinion().decrementHp(4 - battle.getMap().get(indexOfRow).get(i).getMinion().getHolyCounter());
                    }
                }
            } else request.setError(ErrorType.DONT_HAVE_ENOUGH_MANA);
        } else request.setError(ErrorType.DIDNT_PASS_ENOUGH_TIME);
    }

    public String getDesc() {
        return SpecialPower.ARASH.getMessage();
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
                + " - Class : " + this.getTypeOfHit() + " – Special power : " + SpecialPower.LEGEND.getMessage();
        return details;
    }

    public void castSpecialPower(Battle battle, Cell cell, Account player, Request request) {
        if (!this.isUseSpecial()) {
            if (player.getMana() >= this.getMp()) {
                if (cell.getHero() != null) {
                    if (!player.getMainDeck().isContain(cell.getHero())) {
                        for (Buff buff : cell.getHero().getOwnBuffs()) {
                            if (dispelEnemyValidation(buff.getClass().getSimpleName())) {
                                buff.dispel(cell.getHero());
                            }
                        }
                    } else request.setError(ErrorType.INVALID_TARGET);
                } else if (cell.getMinion() != null) {
                    if (!player.getMainDeck().isContain(cell.getMinion())) {
                        for (Buff buff : cell.getMinion().getOwnBuffs()) {
                            if (dispelEnemyValidation(buff.getClass().getSimpleName())) {
                                buff.dispel(cell.getMinion());
                            }
                        }
                    } else request.setError(ErrorType.INVALID_TARGET);
                } else request.setError(ErrorType.EMPTY_CELL);
            } else request.setError(ErrorType.DONT_HAVE_ENOUGH_MANA);
        } else request.setError(ErrorType.DIDNT_PASS_ENOUGH_TIME);
    }

    public String getDesc() {
        return SpecialPower.LEGEND.getMessage();
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
                + " - Class : " + this.getTypeOfHit() + " – Special power : " + SpecialPower.ESFANDYAR.getMessage();
        return details;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, Request request) {
        if (cell.getMinion() != null) {
            for (int i = 0; i < 3; i++) {
                HolyBuff holyBuff = new HolyBuff();
                holyBuff.setTurnCounter(-4);
                holyBuff.holy(cell.getMinion());
                this.getOwnBuffs().add(holyBuff);
            }
        } else if (cell.getHero() != null) {
            for (int i = 0; i < 3; i++) {
                HolyBuff holyBuff = new HolyBuff();
                holyBuff.setTurnCounter(-4);
                holyBuff.holy(cell.getHero());
                this.getOwnBuffs().add(holyBuff);
            }
        } else request.setError(ErrorType.EMPTY_CELL);
    }

    public String getDesc() {
        return SpecialPower.ESFANDYAR.getMessage();
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
                + " - Class : " + this.getTypeOfHit() + " – Special power : -. - CoolDown Time : -.";
        return details;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, Request request) {
        //doesn't have any special power :)
    }

    public String getDesc() {
        return "Nothing" + " - CoolDown Time : -.";
    }
}
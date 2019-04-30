package model.Item;

import java.util.ArrayList;

import model.Battles.*;
import model.Buffs.*;
import model.Cell;
import model.ErrorType;
import model.Menus.Account;
import view.View;

public abstract class UsableItem extends Item {
    private int costOfBuy;
    private static ArrayList<UsableItem> usableItems = new ArrayList<>();
    protected static View view = View.getInstance();

    static {
        new AssassinationDagger();
        new Baptism();
        new CrownOfWisdom();
        new DamolArchery();
        new KingWisdom();
        new PoisonousDagger();
        new ShameEmblem();
        new ShockHammer();
        new SimorghPlume();
        new SoulEater();
        new TerrorHood();
    }

    public UsableItem(int costOfBuy, String name) {
        this.setCostOfBuy(costOfBuy);
        this.setName(name);
        usableItems.add(this);
    }

    public UsableItem(UsableItem usableItem) {
        this.setCostOfBuy(usableItem.getCostOfBuy());
        this.setName(usableItem.getName());
    }

    public abstract void applyEffect(Battle battle, Cell cell, Account player);

    public int getCostOfBuy() {
        return costOfBuy;
    }

    public void setCostOfBuy(int costOfBuy) {
        this.costOfBuy = costOfBuy;
    }

    public static ArrayList<UsableItem> getUsableItems() {
        return usableItems;
    }

    public UsableItem duplicate() {
        return null;
    }
}

enum UsableItemWork {
    CROWN_OF_WISDOM("Increase mana in 3 first turns"),
    SHAME_EMBLEM("Active 12 holyBuff in insider force"),
    DAMOL_ARCHERY("Insider force can disarm enemy force's hit in ranged and hybrid mood"),
    SIMORGH_PLUME("Reduce 2Ap of enemy force's hit in hybrid and ranged mood"),
    TERROR_HOOD("in its hit, apply weaknessBuff and reduce 2AP on enemy accident force for 1 turn"),
    KING_WISDOM("Increase mana 1unit in all turns"),
    ASSASSINATION_DAGGER("Hit enemy Hero 1AP when you put it"),
    POISONOUS_DAGGER("apply poisonBuff on enemy accident force for 1 turn when insider force hitting"),
    SHOCK_HAMMER("Insider hero disarm enemy force for 1 turn whenr hitting"),
    SOUL_EATER("when insider force die,apply a power buff and 1AP on an insider force"),
    BAPTISM("Any minion when spawning,get holyBuff for 2 turns");
    private String effect;

    public String getMessage() {
        return effect;
    }

    UsableItemWork(String effect) {
        this.effect = effect;
    }

}

class CrownOfWisdom extends UsableItem {

    public CrownOfWisdom() {
        super(300, "CrownOfWisdom");
    }

    public CrownOfWisdom(CrownOfWisdom crownOfWisdom) {
        super(crownOfWisdom);
    }

    @Override
    public void applyEffect(Battle battle, Cell cell, Account player) {
        if (battle.getTurn() < 4) {
            player.incrementMana(1);
            //todo checking what happen
        }
    }

    public UsableItem duplicate() {
        CrownOfWisdom crownOfWisdom = new CrownOfWisdom(this);
        return crownOfWisdom;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + UsableItemWork.CROWN_OF_WISDOM.getMessage();
        return details;

    }
}

class ShameEmblem extends UsableItem {

    public ShameEmblem() {
        super(4000, "ShameEmblem");
    }

    public ShameEmblem(ShameEmblem shameEmblem) {
        super(shameEmblem);
    }

    @Override
    public void applyEffect(Battle battle, Cell cell, Account player) {
        if (cell.getHero() != null && player.getMainDeck().isContain(cell.getHero())) {
            for (int i = 0; i < 12; i++) {
                HolyBuff holyBuff = new HolyBuff();
                holyBuff.setTurnCounter(1);
                holyBuff.holy(cell.getHero());
                cell.getHero().getOwnBuffs().add(holyBuff);
            }
        } else {
            view.printError(ErrorType.INVALID_TARGET);
        }
    }

    public UsableItem duplicate() {
        ShameEmblem shameEmblem = new ShameEmblem(this);
        return shameEmblem;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + UsableItemWork.SHAME_EMBLEM.getMessage();
        return details;

    }
}

class DamolArchery extends UsableItem {

    public DamolArchery() {
        super(30000, "DamolArchery");
    }

    public DamolArchery(DamolArchery damolArchery) {
        super(damolArchery);
    }

    @Override
    public void applyEffect(Battle battle, Cell cell, Account player) {
        if (player.getMainDeck().getHero().getTypeOfHit().equals("Ranged") ||
                player.getMainDeck().getHero().getTypeOfHit().equals("Hybrid")) {
            if (cell.getMinion() == null && cell.getHero() == null) {
                view.printError(ErrorType.INVALID_TARGET);
            } else {
                if (cell.getHero() != null) {
                    if (!player.getMainDeck().isContain(cell.getHero())) {
                        DisarmBuff disarmBuff = new DisarmBuff();
                        disarmBuff.setTurnCounter(1);
                        disarmBuff.disarm(cell.getHero());
                        cell.getHero().getOwnBuffs().add(disarmBuff);
                    } else {
                        view.printError(ErrorType.INVALID_TARGET);
                    }
                }
                if (cell.getMinion() != null) {
                    if (!player.getMainDeck().isContain(cell.getMinion())) {
                        DisarmBuff disarmBuff = new DisarmBuff();
                        disarmBuff.setTurnCounter(1);
                        disarmBuff.disarm(cell.getMinion());
                        cell.getMinion().getOwnBuffs().add(disarmBuff);
                    } else {
                        view.printError(ErrorType.INVALID_TARGET);
                    }
                }
            }
        } else {
            view.printError(ErrorType.INVALID_HERO_TYPE_HITTING);
        }
    }

    public UsableItem duplicate() {
        DamolArchery damolArchery = new DamolArchery(this);
        return damolArchery;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + UsableItemWork.DAMOL_ARCHERY.getMessage();
        return details;
    }
}

class SimorghPlume extends UsableItem {

    public SimorghPlume() {
        super(3500, "SimorghePlume");
    }

    public SimorghPlume(SimorghPlume simorghPlume) {
        super(simorghPlume);
    }

    @Override
    public void applyEffect(Battle battle, Cell cell, Account player) {
        if (cell.getHero() != null && !player.getMainDeck().isContain(cell.getHero())) {
            if (cell.getHero().getTypeOfHit().equals("Ranged") ||
                    cell.getHero().getTypeOfHit().equals("Hybrid")) {
                cell.getHero().decrementAp(2);
            } else {
                view.printError(ErrorType.FALSE_ITEM_USING);
            }
        } else {
            view.printError(ErrorType.INVALID_TARGET);
        }
    }

    public UsableItem duplicate() {
        SimorghPlume simorghPlume = new SimorghPlume(this);
        return simorghPlume;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + UsableItemWork.SIMORGH_PLUME.getMessage();
        return details;
    }
}

class TerrorHood extends UsableItem {

    public TerrorHood() {
        super(5000, "TerrorHood");
    }

    public TerrorHood(TerrorHood terrorHood) {
        super(terrorHood);
    }

    @Override
    public void applyEffect(Battle battle, Cell cell, Account player) {
        for (ArrayList<Cell> cells : battle.getMap()) {
            for (Cell cell1 : cells) {
                if ((cell1.getHero() != null && !player.getMainDeck().isContain(cell1.getHero()))) {
                    WeaknessBuff weaknessBuff = new WeaknessBuff(2 - cell.getHero().getHolyCounter(), true);
                    weaknessBuff.decrementAp(cell.getHero());
                    weaknessBuff.setTurnCounter(-5);
                    cell.getHero().getOwnBuffs().add(weaknessBuff);
                }
                if (cell1.getMinion() != null && player.getMainDeck().isContain(cell1.getMinion())) {
                    WeaknessBuff weaknessBuff = new WeaknessBuff(2 - cell.getMinion().getHolyCounter(), true);
                    weaknessBuff.decrementAp(cell.getMinion());
                    weaknessBuff.setTurnCounter(-5);
                    cell.getMinion().getOwnBuffs().add(weaknessBuff);
                }
            }
        }
    }

    public UsableItem duplicate() {
        TerrorHood terrorHood = new TerrorHood(this);
        return terrorHood;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + UsableItemWork.TERROR_HOOD.getMessage();
        return details;
    }
}

class KingWisdom extends UsableItem {

    public KingWisdom() {
        super(9000, "KingWisdom");
    }

    public KingWisdom(KingWisdom kingWisdom) {
        super(kingWisdom);
    }

    @Override
    public void applyEffect(Battle battle, Cell cell, Account player) {
        player.incrementMana(1);
        //todo what should we do?
    }

    public UsableItem duplicate() {
        KingWisdom kingWisdom = new KingWisdom(this);
        return kingWisdom;
    }


    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + UsableItemWork.KING_WISDOM.getMessage();
        return details;
    }
}

class AssassinationDagger extends UsableItem {

    public AssassinationDagger() {
        super(15000, "AssassinationDagger");
    }

    public AssassinationDagger(AssassinationDagger assassinationDagger) {
        super(assassinationDagger);
    }

    @Override
    public void applyEffect(Battle battle, Cell cell, Account player) {

    }

    public UsableItem duplicate() {
        AssassinationDagger assassinationDagger = new AssassinationDagger(this);
        return assassinationDagger;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + UsableItemWork.ASSASSINATION_DAGGER.getMessage();
        return details;
    }
}

class PoisonousDagger extends UsableItem {

    public PoisonousDagger() {
        super(7000, "PoisonousDagger");
    }

    public PoisonousDagger(PoisonousDagger poisonousDagger) {
        super(poisonousDagger);
    }

    @Override
    public void applyEffect(Battle battle, Cell cell, Account player) {

    }

    public UsableItem duplicate() {
        PoisonousDagger poisonousDagger = new PoisonousDagger(this);
        return poisonousDagger;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + UsableItemWork.POISONOUS_DAGGER.getMessage();
        return details;
    }
}

class ShockHammer extends UsableItem {

    public ShockHammer() {
        super(15000, "ShockHammer");
    }

    public ShockHammer(ShockHammer shockHammer) {
        super(shockHammer);
    }

    @Override
    public void applyEffect(Battle battle, Cell cell, Account player) {

    }

    public UsableItem duplicate() {
        ShockHammer shockHammer = new ShockHammer(this);
        return shockHammer;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + UsableItemWork.SHOCK_HAMMER.getMessage();
        return details;
    }
}

class SoulEater extends UsableItem {
    public SoulEater() {
        super(25000, "SoulEater");
    }

    public SoulEater(SoulEater soulEater) {
        super(soulEater);
    }

    @Override
    public void applyEffect(Battle battle, Cell cell, Account player) {

    }

    public UsableItem duplicate() {
        SoulEater soulEater = new SoulEater(this);
        return soulEater;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + UsableItemWork.SOUL_EATER.getMessage();
        return details;
    }
}

class Baptism extends UsableItem {

    public Baptism() {
        super(20000, "Baptism");
    }

    public Baptism(Baptism baptism) {
        super(baptism);
    }

    @Override
    public void applyEffect(Battle battle, Cell cell, Account player) {

    }

    public UsableItem duplicate() {
        Baptism baptism = new Baptism(this);
        return baptism;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + UsableItemWork.BAPTISM.getMessage();
        return details;
    }
}
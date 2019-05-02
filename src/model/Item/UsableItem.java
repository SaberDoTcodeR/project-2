package model.Item;

import java.util.ArrayList;

import model.Battles.*;
import model.Buffs.*;
import model.Cell;
import model.Menus.Account;
import view.Request;
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

    public abstract void applyEffect(Battle battle, Cell cell, Account player, Request request, int activeTime);

    /* activeTime:
     * 0 -> on spawn
     * 1 -> passive
     * 2 -> on death
     * 3 -> on attack
     * 4 -> on defend
     * 5 -> combo
     * */
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

//todo -->
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
    public void applyEffect(Battle battle, Cell cell, Account player, Request request, int activeTime) {
        ManaItemBuff manaItemBuff = new ManaItemBuff(player, 1);
        manaItemBuff.setTurnCounter(5);
        manaItemBuff.castBuff();
        player.getOwnBuffs().add(manaItemBuff);
    }

    @Override
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
    public void applyEffect(Battle battle, Cell cell, Account player, Request request, int activeTime) {
        for (int i = 0; i < 12; i++) {
            HolyBuff holyBuff = new HolyBuff();
            holyBuff.setCasting(holyBuff, null, player.getMainDeck().getHero(), null);
            holyBuff.setTurnCounter(-5);
            holyBuff.castBuff();
            player.getMainDeck().getHero().getOwnBuffs().add(holyBuff);
        }
    }

    @Override
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
    public void applyEffect(Battle battle, Cell cell, Account player, Request request, int activeTime) {
        if (player.getMainDeck().getHero().getTypeOfHit().equals("Ranged") ||
                player.getMainDeck().getHero().getTypeOfHit().equals("Hybrid")) {
            if (activeTime == 3) {
                if (cell.getHero() != null) {
                    DisarmBuff disarmBuff = new DisarmBuff();
                    disarmBuff.disarm(cell.getHero());
                    disarmBuff.setTurnCounter(1);
                    disarmBuff.setCasting(disarmBuff, null, cell.getHero(), null);
                    cell.getHero().getOwnBuffs().add(disarmBuff);
                }
                if (cell.getMinion() != null) {
                    DisarmBuff disarmBuff = new DisarmBuff();
                    disarmBuff.disarm(cell.getMinion());
                    disarmBuff.setTurnCounter(1);
                    disarmBuff.setCasting(disarmBuff, null, cell.getHero(), null);
                    cell.getMinion().getOwnBuffs().add(disarmBuff);
                }
            }
        }
    }

    @Override
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
    public void applyEffect(Battle battle, Cell cell, Account player, Request request, int activeTime) {
        if (battle.getFirstPlayer().getUserName().equals(player.getUserName())) {
            if (battle.getSecondPlayer().getMainDeck().getHero().getTypeOfHit().equals("Hybrid") ||
                    battle.getSecondPlayer().getMainDeck().getHero().getTypeOfHit().equals("Ranged"))
                battle.getSecondPlayer().getMainDeck().getHero().decrementAp(2);
        } else {
            if (battle.getFirstPlayer().getMainDeck().getHero().getTypeOfHit().equals("Hybrid") ||
                    battle.getFirstPlayer().getMainDeck().getHero().getTypeOfHit().equals("Ranged"))
                battle.getFirstPlayer().getMainDeck().getHero().decrementAp(2);
        }
    }

    @Override
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
    public void applyEffect(Battle battle, Cell cell, Account player, Request request, int activeTime) {
        if (activeTime == 3) {
            if (battle.getFirstPlayer().getUserName().equals(player.getUserName())) {
                outer:
                for (ArrayList<Cell> cells : battle.getMap()) {
                    for (Cell cell1 : cells) {
                        if (cell1.getMinion() != null &&
                                battle.getSecondPlayer().getMainDeck().isContain(cell1.getMinion())) {
                            terrorHoodHelper(cell1);
                            break outer;
                        }
                    }
                }
                //todo --> kossher zadam behtar she
            } else {
                outer:
                for (ArrayList<Cell> cells : battle.getMap()) {
                    for (Cell cell1 : cells) {
                        if (cell1.getMinion() != null &&
                                battle.getFirstPlayer().getMainDeck().isContain(cell1.getMinion())) {
                            terrorHoodHelper(cell1);
                            break outer;
                        }
                    }
                }
            }
        }
    }

    private void terrorHoodHelper(Cell cell1) {
        int unit = cell1.getMinion().getHolyCounter();
        WeaknessBuff weaknessBuff = new WeaknessBuff(2 - unit, true);
        weaknessBuff.setTurnCounter(1);
        weaknessBuff.setCasting(weaknessBuff, null, null, cell1.getMinion());
        weaknessBuff.decrementAp(cell1.getMinion());
        cell1.getMinion().getOwnBuffs().add(weaknessBuff);
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
    public void applyEffect(Battle battle, Cell cell, Account player, Request request, int activeTime) {
        ManaItemBuff manaItemBuff = new ManaItemBuff(player, 1);
        manaItemBuff.setTurnCounter(-5);
        manaItemBuff.castBuff();
        player.getOwnBuffs().add(manaItemBuff);
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
    public void applyEffect(Battle battle, Cell cell, Account player, Request request, int activeTime) {
        if (activeTime == 0) {
            if (battle.getFirstPlayer().getUserName().equals(player.getUserName())) {
                int unit = battle.getSecondPlayer().getMainDeck().getHero().getHolyCounter();
                battle.getSecondPlayer().getMainDeck().getHero().decrementHp(1 - unit);
            }
            if (battle.getSecondPlayer().getUserName().equals(player.getUserName())) {
                int unit = battle.getFirstPlayer().getMainDeck().getHero().getHolyCounter();
                battle.getFirstPlayer().getMainDeck().getHero().decrementHp(1 - unit);
            }
        }
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
    public void applyEffect(Battle battle, Cell cell, Account player, Request request, int activeTime) {
        if (activeTime == 3) {
            if (battle.getFirstPlayer().getUserName().equals(player.getUserName())) {
                outer:
                for (ArrayList<Cell> cells : battle.getMap()) {
                    for (Cell cell1 : cells) {
                        if (cell1.getMinion() != null &&
                                battle.getSecondPlayer().getMainDeck().isContain(cell1.getMinion())) {
                            poisonousDraggerHelper(cell1);
                            break outer;
                        }
                    }
                }
                //todo --> kossher zadam behtar she
            } else {
                outer:
                for (ArrayList<Cell> cells : battle.getMap()) {
                    for (Cell cell1 : cells) {
                        if (cell1.getMinion() != null &&
                                battle.getFirstPlayer().getMainDeck().isContain(cell1.getMinion())) {
                            poisonousDraggerHelper(cell1);
                            break outer;
                        }
                    }
                }
            }
        }
    }

    private void poisonousDraggerHelper(Cell cell1) {
        PoisonBuff poisonBuff = new PoisonBuff();
        poisonBuff.setTurnCounter(1);
        poisonBuff.poison(cell1.getMinion());
        poisonBuff.setCasting(poisonBuff, null, null, cell1.getMinion());
        cell1.getMinion().getOwnBuffs().add(poisonBuff);
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
    public void applyEffect(Battle battle, Cell cell, Account player, Request request, int activeTime) {
        if (activeTime == 3) {
            if (cell.getHero() != null) {
                DisarmBuff disarmBuff = new DisarmBuff();
                disarmBuff.setTurnCounter(1);
                disarmBuff.disarm(cell.getHero());
                disarmBuff.setCasting(disarmBuff, null, cell.getHero(), null);
                cell.getHero().getOwnBuffs().add(disarmBuff);
            }
            if (cell.getMinion() != null) {
                DisarmBuff disarmBuff = new DisarmBuff();
                disarmBuff.setTurnCounter(1);
                disarmBuff.disarm(cell.getMinion());
                disarmBuff.setCasting(disarmBuff, null, cell.getHero(), null);
                cell.getMinion().getOwnBuffs().add(disarmBuff);
            }
        }
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
    public void applyEffect(Battle battle, Cell cell, Account player, Request request, int activeTime) {
        if (activeTime == 2) {
            PowerBuff powerBuff = new PowerBuff(1, true);
            outer:
            for (ArrayList<Cell> cells : battle.getMap()) {
                for (Cell cell1 : cells) {
                    if (cell1.getMinion() != null &&
                            battle.getFirstPlayer().getUserName().equals(player.getUserName())) {
                        if (battle.getFirstPlayer().getMainDeck().isContain(cell1.getMinion())) {
                            soulEaterHelper(powerBuff, cell1);
                            break outer;
                        }
                    }
                    if (cell1.getMinion() != null &&
                            battle.getSecondPlayer().getUserName().equals(player.getUserName())) {
                        if (battle.getSecondPlayer().getMainDeck().isContain(cell1.getMinion())) {
                            soulEaterHelper(powerBuff, cell1);
                            break outer;
                        }
                    }
                }
            }
        }
    }

    private void soulEaterHelper(PowerBuff powerBuff, Cell cell1) {
        powerBuff.incrementAp(cell1.getMinion());
        powerBuff.setTurnCounter(1);
        powerBuff.setCasting(powerBuff, null, null, cell1.getMinion());
        cell1.getMinion().getOwnBuffs().add(powerBuff);
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
    public void applyEffect(Battle battle, Cell cell, Account player, Request request, int activeTime) {
        if (activeTime == 0) {
            if (cell.getMinion() != null) {
                HolyBuff holyBuff = new HolyBuff();
                holyBuff.holy(cell.getMinion());
                holyBuff.setTurnCounter(3);
                holyBuff.setCasting(holyBuff, null, null, cell.getMinion());
                cell.getMinion().getOwnBuffs().add(holyBuff);
            }
        }
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
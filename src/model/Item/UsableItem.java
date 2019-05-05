package model.Item;

import java.util.ArrayList;

import model.Battles.*;
import model.Buffs.*;
import model.Cell;
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

    public abstract void applyEffect(Battle battle, Cell cell, Account player, int activeTime);

    /* activeTime:
     * 0 -> on spawn
     * 1 -> passive
     * 2 -> on death
     * 3 -> on attack hero or minion
     * 4 -> on defend
     * 5 -> combo
     * 6 -> on Attack -> just Hero
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

    /*
     * cell --> no different
     * player --> The player who has this item
     * activeTime : no different
     * */
    @Override
    public void applyEffect(Battle battle, Cell cell, Account player, int activeTime) {
        if (activeTime != -1)
            return;
        ManaItemBuff manaItemBuff = new ManaItemBuff(player, 1);
        manaItemBuff.setTurnCounter(2);
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

    /*
     * cell --> The cell of insider hero
     * player --> no different at all but the player who has this item
     * activeTime --> no different
     * */
    @Override
    public void applyEffect(Battle battle, Cell cell, Account player, int activeTime) {
        if (activeTime != -1)
            return;
        for (int i = 0; i < 12; i++) {
            HolyBuff holyBuff = new HolyBuff();
            holyBuff.setCasting(holyBuff, null, cell.getHero(), null);
            holyBuff.setTurnCounter(-5);
            holyBuff.castBuff();
            cell.getHero().getOwnBuffs().add(holyBuff);
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

    /*
     * cell : enemy cell that player's *hero* want to attack on this
     * player : the player who has this item
     * activeTime : 6 --> on Attack
     * */
    @Override
    public void applyEffect(Battle battle, Cell cell, Account player, int activeTime) {
        if (player.getMainDeck().getHero().getTypeOfHit().equals("Ranged") ||
                player.getMainDeck().getHero().getTypeOfHit().equals("Hybrid")) {
            if (activeTime == 6) {
                if (cell.getHero() != null) {
                    DisarmBuff disarmBuff = new DisarmBuff();
                    disarmBuff.disarm(cell.getHero());
                    disarmBuff.setCasting(disarmBuff, null, cell.getHero(), null);
                    disarmBuff.setTurnCounter(0);
                    cell.getHero().getOwnBuffs().add(disarmBuff);
                }
                if (cell.getMinion() != null) {
                    DisarmBuff disarmBuff = new DisarmBuff();
                    disarmBuff.disarm(cell.getMinion());
                    disarmBuff.setTurnCounter(0);
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

    /*
     * cell : the cell of enemy's hero
     * player : no different
     * activeTime : no different
     * */
    @Override
    public void applyEffect(Battle battle, Cell cell, Account player, int activeTime) {
        if (activeTime != -1)
            return;
        if (cell.getHero().getTypeOfHit().equals("Hybrid") ||
                cell.getHero().getTypeOfHit().equals("Ranged")) {
            cell.getHero().decrementAp(2);
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

    /*
     * cell : no different
     * player : th player who its force want to attack on enemy
     * activeTime : 3 or 6 --> on Attack
     * */
    @Override
    public void applyEffect(Battle battle, Cell cell, Account player, int activeTime) {

        if (activeTime == 3 || activeTime == 6) {
            Cell enemyCell = getRandomEnemyForce(battle, player);
            if (enemyCell.getHero() != null) {
                WeaknessBuff weaknessBuff = new WeaknessBuff(2, true);
                weaknessBuff.setCasting(weaknessBuff, null, enemyCell.getHero(), null);
                weaknessBuff.decrementAp(enemyCell.getHero());
                weaknessBuff.setTurnCounter(0);
                enemyCell.getHero().getOwnBuffs().add(weaknessBuff);
            }
            if (enemyCell.getMinion() != null) {
                WeaknessBuff weaknessBuff = new WeaknessBuff(2, true);
                weaknessBuff.setCasting(weaknessBuff, null, null, enemyCell.getMinion());
                weaknessBuff.decrementAp(enemyCell.getMinion());
                weaknessBuff.setTurnCounter(0);
                enemyCell.getMinion().getOwnBuffs().add(weaknessBuff);
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

    /* --->>> should be applied on every turn
     * cell --> no different
     * player --> The player who has this item
     * activeTime : no different
     * */
    @Override
    public void applyEffect(Battle battle, Cell cell, Account player, int activeTime) {
        if (activeTime != -1)
            return;
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

    /*
     * cell : cell of enemy's Hero
     * player : no different
     * activeTime : 0 --> on Spawn
     * */
    @Override
    public void applyEffect(Battle battle, Cell cell, Account player, int activeTime) {
        if (activeTime == 0) {
            cell.getHero().decrementHp(1);
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

    /*
     * cell : no different
     * player : the player that its enemy is attacking
     * activeTime : 3 or 6 --> on Attack
     * */
    @Override
    public void applyEffect(Battle battle, Cell cell, Account player, int activeTime) {
        if (activeTime == 3 || activeTime == 6) {
            Cell enemyCell = getRandomEnemyForce(battle, player);
            if (enemyCell.getHero() != null) {
                PoisonBuff poisonBuff = new PoisonBuff();
                poisonBuff.setCasting(poisonBuff, null, enemyCell.getHero(), null);
                poisonBuff.poison(enemyCell.getHero());
                poisonBuff.setTurnCounter(0);
                enemyCell.getHero().getOwnBuffs().add(poisonBuff);
            }
            if (enemyCell.getMinion() != null) {
                PoisonBuff poisonBuff = new PoisonBuff();
                poisonBuff.setCasting(poisonBuff, null, null, enemyCell.getMinion());
                poisonBuff.poison(enemyCell.getMinion());
                poisonBuff.setTurnCounter(0);
                enemyCell.getMinion().getOwnBuffs().add(poisonBuff);
            }
        }
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

    /*
     * cell : cell of hero or minion is
     * player : no different
     * activeTime : 6 --> on Attack
     * */
    @Override
    public void applyEffect(Battle battle, Cell cell, Account player, int activeTime) {
        if (activeTime == 6) {
            if (cell.getHero() != null) {
                DisarmBuff disarmBuff = new DisarmBuff();
                disarmBuff.setTurnCounter(0);
                disarmBuff.disarm(cell.getHero());
                disarmBuff.setCasting(disarmBuff, null, cell.getHero(), null);
                cell.getHero().getOwnBuffs().add(disarmBuff);
            }
            if (cell.getMinion() != null) {
                DisarmBuff disarmBuff = new DisarmBuff();
                disarmBuff.setTurnCounter(0);
                disarmBuff.disarm(cell.getMinion());
                disarmBuff.setCasting(disarmBuff, null, null, cell.getMinion());
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

    /*
     * cell : no different
     * player : the player that its force is dying
     * activeTime : 2 --> on Death
     * */
    @Override
    public void applyEffect(Battle battle, Cell cell, Account player, int activeTime) {
        if (activeTime == 2) {
            Cell insiderCell = getRandomInsiderForce(battle, player);
            if (insiderCell.getHero() != null) {
                PowerBuff powerBuff = new PowerBuff(1, true);
                powerBuff.setTurnCounter(-5);//todo --> right or not
                powerBuff.setCasting(powerBuff, null, insiderCell.getHero(), null);
                powerBuff.incrementAp(insiderCell.getHero());
                insiderCell.getHero().getOwnBuffs().add(powerBuff);
            }
            if (insiderCell.getMinion() != null) {
                PowerBuff powerBuff = new PowerBuff(1, true);
                powerBuff.setTurnCounter(-5);//todo --> right or not
                powerBuff.setCasting(powerBuff, null, null, insiderCell.getMinion());
                powerBuff.incrementAp(insiderCell.getMinion());
                insiderCell.getMinion().getOwnBuffs().add(powerBuff);
            }
        }
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

    /* should be called for any minion that want to come to the game
     * cell : cell of insider minion that has been put
     * player : no different
     * activeTime : 0 --> on Spawn
     * */
    @Override
    public void applyEffect(Battle battle, Cell cell, Account player, int activeTime) {
        if (activeTime == 0) {
            if (cell.getMinion() != null) {
                HolyBuff holyBuff = new HolyBuff();
                holyBuff.holy(cell.getMinion());
                holyBuff.setTurnCounter(1);
                holyBuff.setCasting(holyBuff, null, null, cell.getMinion());
                cell.getMinion().getOwnBuffs().add(holyBuff);
            }
        }
    }

    @Override
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

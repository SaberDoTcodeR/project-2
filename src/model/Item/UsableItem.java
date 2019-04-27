package model.Item;

import java.util.ArrayList;

public abstract class UsableItem extends Item {
    private int costOfBuy;
    private static ArrayList<UsableItem> usableItems = new ArrayList<>();

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
    DAMOL_ARCHERY("Insider forcecan disarm enemy force's hit in ranged and hybrid mood"),
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
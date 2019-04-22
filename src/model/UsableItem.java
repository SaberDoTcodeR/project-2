package model;

import java.util.ArrayList;

public abstract class UsableItem extends Item {
    public UsableItem(int costOfBuy,String name){
        this.setCostOfBuy(costOfBuy);
        this.setName(name);
    }
    private int costOfBuy;
    private static ArrayList<UsableItem> usableItems = new ArrayList<>();

    public int getCostOfBuy() {
        return costOfBuy;
    }

    public void setCostOfBuy(int costOfBuy) {
        this.costOfBuy = costOfBuy;
    }

    public static ArrayList<UsableItem> getUsableItems() {
        return usableItems;
    }
}

enum UsableItemWork {
    CROWN_OF_WISOM("Increase mana in 3 first turns"),
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

    UsableItemWork(String effect) {
        this.effect = effect;
    }

}

class CrownOfWisom extends UsableItem {

    public CrownOfWisom(int costOfBuy, String name) {
        super(costOfBuy, name);
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + UsableItemWork.CROWN_OF_WISOM;
        return details;

    }
}

class ShameEmblem extends UsableItem {

    public ShameEmblem(int costOfBuy, String name) {
        super(costOfBuy, name);
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + UsableItemWork.SHAME_EMBLEM;
        return details;

    }
}

class DamolArchery extends UsableItem {

    public DamolArchery(int costOfBuy, String name) {
        super(costOfBuy, name);
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + UsableItemWork.DAMOL_ARCHERY;
        return details;
    }
}

class SimorghPlume extends UsableItem {

    public SimorghPlume(int costOfBuy, String name) {
        super(costOfBuy, name);
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + UsableItemWork.SIMORGH_PLUME;
        return details;
    }
}

class TerrorHood extends UsableItem {

    public TerrorHood(int costOfBuy, String name) {
        super(costOfBuy, name);
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + UsableItemWork.TERROR_HOOD;
        return details;
    }
}

class KingWisdom extends UsableItem {

    public KingWisdom(int costOfBuy, String name) {
        super(costOfBuy, name);
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + UsableItemWork.KING_WISDOM;
        return details;
    }
}

class AssassinationDagger extends UsableItem {

    public AssassinationDagger(int costOfBuy, String name) {
        super(costOfBuy, name);
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + UsableItemWork.ASSASSINATION_DAGGER;
        return details;
    }
}

class PoisonousDagger extends UsableItem {

    public PoisonousDagger(int costOfBuy, String name) {
        super(costOfBuy, name);
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + UsableItemWork.POISONOUS_DAGGER;
        return details;
    }
}

class ShockHammer extends UsableItem {

    public ShockHammer(int costOfBuy, String name) {
        super(costOfBuy, name);
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + UsableItemWork.SHOCK_HAMMER;
        return details;
    }
}

class SoulEater extends UsableItem {

    public SoulEater(int costOfBuy, String name) {
        super(costOfBuy, name);
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + UsableItemWork.SOUL_EATER;
        return details;
    }
}

class Baptism extends UsableItem {

    public Baptism(int costOfBuy, String name) {
        super(costOfBuy, name);
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + UsableItemWork.BAPTISM;
        return details;
    }
}
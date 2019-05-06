package model.Item.UsableItem;

import java.util.ArrayList;

import model.Battles.*;
import model.Cell;
import model.Item.Item;
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


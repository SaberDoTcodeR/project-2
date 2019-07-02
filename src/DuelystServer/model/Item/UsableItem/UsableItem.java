package DuelystServer.model.Item.UsableItem;

import DuelystServer.model.Account;
import DuelystServer.model.Battle.Battle;
import DuelystServer.model.Cell;
import DuelystServer.model.Item.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class UsableItem extends Item {
    private int costOfBuy;
    private transient static ArrayList<UsableItem> usableItems = new ArrayList<>();
    private transient static Map<String,Integer> usableItemsName = new HashMap<>();

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

    public static Map<String, Integer> getUsableItemsName() {
        return usableItemsName;
    }

    public UsableItem(int costOfBuy, String name) {
        this.setCostOfBuy(costOfBuy);
        this.setName(name);
        usableItems.add(this);
        usableItemsName.put(this.getName().toLowerCase(),this.getCostOfBuy());
    }

    public UsableItem(UsableItem usableItem) {
        this.setCostOfBuy(usableItem.getCostOfBuy());
        this.setName(usableItem.getName());
    }

    public void applyEffect(Battle battle, Cell cell, Account player, int activeTime){}

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


package model.Cards;

import model.Battles.Battle;

import java.util.ArrayList;

import model.Buffs.Buff;

public abstract class Card {
    private String name;
    private boolean isOnMap;
    private int costOfBuy;
    private long id;
    private String CardId;
    public String getName() {
        return name.toLowerCase();
    }

    public void setName(String nameOfCard) {
        this.name = nameOfCard;
    }

    public String getCardId() {
        return CardId;
    }

    public void setCardId(String cardId) {
        CardId = cardId;
    }

    public boolean dispelEnemyValidation(String buffName) {
        for (String str : Buff.getPositiveBuffs()) {
            if (str.equals(buffName)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispelInsiderValidation(String buffName) {
        for (String str : Buff.getNegativeBuffs()) {
            if (str.equals(buffName)) {
                return true;
            }
        }
        return false;
    }

    public boolean isOnMap() {
        return isOnMap;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCostOfBuy() {
        return costOfBuy;
    }

    public void setCostOfBuy(int costOfBuy) {
        this.costOfBuy = costOfBuy;
    }

    public long getId() {
        return id;
    }

    abstract public String getType();

    public abstract String showDetails();
    public void cardIdGenerator(Battle battle){
        ArrayList<Card>cards;
        String playerName;
        if(battle.getTurn()%2==0)
        {
            playerName=battle.getFirstPlayer().getUserName();
            cards=battle.getFirstPlayerInGameCards();
        }
        else{
            cards=battle.getSecondPlayerInGameCards();
            playerName=battle.getSecondPlayer().getUserName();
        }

        int count=0;
        for (Card card :cards) {
            if(card.getName().equals(this.name)){
                count++;
            }
        }
        String str=playerName+"_"+this.getName()+"_"+(count+1);
        setCardId(str);
    }
}

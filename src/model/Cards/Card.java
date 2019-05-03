package model.Cards;

import model.Battles.Battle;

import java.util.ArrayList;

import model.Buffs.Buff;
import model.Cell;
import model.ErrorType;
import model.RecordedMatch;
import view.Request;
import view.View;

public abstract class Card {
    View view = View.getInstance();
    private String name;
    private boolean isOnMap;
    private int costOfBuy;
    private long id;
    private String CardId;
    private int remainedMoves = 2;
    private boolean canAttack = true;

    public String getName() {
        return name.toLowerCase();
    }

    public boolean getCanAttack() {
        return canAttack;
    }

    public void setCanAttack(boolean canAttack) {
        this.canAttack = canAttack;
    }

    public int getRemainedMoves() {
        return remainedMoves;
    }

    public void attack(Battle battle, Card card, Request request) {
        Cell cell = battle.getMap().get(0).get(0).getCellOfCard(card, battle);
        if (cell == null) {
            request.setError(ErrorType.CARD_NOT_FOUND_IN_GAME);
            return;
        }

        if ((this.getType().equals("Minion") && ((Minion) this).isStunning()) ||
                (this.getType().equals("Hero") && ((Hero) this).isStunning())) {
            request.setError(ErrorType.CARD_IS_STUNNED);
        }
        int x = 0;
        if (this.getType().equals("Minion") && ((Minion) this).getTypeOfRange() == 1) {
            x = ((Minion) this).getRange();
        } else if (this.getType().equals("Hero") && ((Hero) this).getTypeOfRange() == 1) {
            x = ((Hero) this).getRange();
        }
        if ((this.getType().equals("Minion") && ((Minion) this).getTypeOfRange() == 0) ||
                (this.getType().equals("Hero") && ((Hero) this).getTypeOfRange() == 0) && cell.manhataniDistance(battle.getMap().get(0).get(0).getCellOfCard(card, battle).getX(),
                        battle.getMap().get(0).get(0).getCellOfCard(card, battle).getY()) <= 2) {
            if (card.getType().equals("Hero") && this.getType().equals("Hero")) {
                ((Hero) card).setHp(((Hero) card).getHp() - ((Hero) this).getAp());
                if (!((Hero) card).isStunning() && ((Hero) card).isCounterAttack()) {
                    card.counterAttack(battle, this);
                }
            } else if (card.getType().equals("Hero") && this.getType().equals("Minion"))
                ((Hero) card).setHp(((Hero) card).getHp() - ((Minion) this).getAp());
            else if (card.getType().equals("Minion") && this.getType().equals("Minion"))
                ((Minion) card).setHp(((Minion) card).getHp() - ((Minion) this).getAp());
            else {
                ((Minion) card).setHp(((Minion) card).getHp() - ((Hero) this).getAp());
                if (!((Minion) card).isStunning() && ((Minion) card).isCounterAttack()) {
                    card.counterAttack(battle, this);
                }
            }


        } else if (x != 0 && cell.manhataniDistance(battle.getMap().get(0).get(0).getCellOfCard(card, battle).getX(),
                battle.getMap().get(0).get(0).getCellOfCard(card, battle).getY()) > 2 && cell.manhataniDistance(battle.getMap().get(0).get(0).getCellOfCard(card, battle).getX(),
                battle.getMap().get(0).get(0).getCellOfCard(card, battle).getY()) <= x) {
            if (card.getType().equals("Hero") && this.getType().equals("Hero")) {
                ((Hero) card).setHp(((Hero) card).getHp() - ((Hero) this).getAp());
                if (!((Hero) card).isStunning() && ((Hero) card).isCounterAttack()) {
                    card.counterAttack(battle, this);
                }
            } else if (card.getType().equals("Hero") && this.getType().equals("Minion"))
                ((Hero) card).setHp(((Hero) card).getHp() - ((Minion) this).getAp());
            else if (card.getType().equals("Minion") && this.getType().equals("Minion"))
                ((Minion) card).setHp(((Minion) card).getHp() - ((Minion) this).getAp());
            else {
                ((Minion) card).setHp(((Minion) card).getHp() - ((Hero) this).getAp());
                if (!((Minion) card).isStunning() && ((Minion) card).isCounterAttack()) {
                    card.counterAttack(battle, this);
                }
            }
        } else if ((this.getType().equals("Minion") && ((Minion) this).getTypeOfRange() == 2) || (this.getType().equals("Hero") && ((Hero) this).getTypeOfRange() == 2)) {
            if (card.getType().equals("Hero") && this.getType().equals("Hero")) {
                ((Hero) card).setHp(((Hero) card).getHp() - ((Hero) this).getAp());
                if (!((Hero) card).isStunning() && ((Hero) card).isCounterAttack()) {
                    card.counterAttack(battle, this);
                }
            } else if (card.getType().equals("Hero") && this.getType().equals("Minion"))
                ((Hero) card).setHp(((Hero) card).getHp() - ((Minion) this).getAp());
            else if (card.getType().equals("Minion") && this.getType().equals("Minion"))
                ((Minion) card).setHp(((Minion) card).getHp() - ((Minion) this).getAp());
            else {
                ((Minion) card).setHp(((Minion) card).getHp() - ((Hero) this).getAp());
                if (!((Minion) card).isStunning() && ((Minion) card).isCounterAttack()) {
                    card.counterAttack(battle, this);
                }
            }
        }
        card.deadChecker(battle);
        this.deadChecker(battle);
        this.setRemainedMoves(0);
        this.setCanAttack(false);
    }

    public void deadChecker(Battle battle) {
        if (((Minion) this).getHp() <= 0) {
            if (battle.getSelectedCard().CardId.equals(this.getCardId()))
                battle.setSelectedCard(null);
            if (battle.getFirstPlayerInGameCards().contains(this)) {
                battle.getFirstPlayerInGameCards().remove(this);
                battle.addToFirstGrave(this);
            } else if (battle.getSecondPlayerInGameCards().contains(this)) {
                battle.getSecondPlayerInGameCards().remove(this);
                battle.addToSecondGrave(this);
            }
        }
    }

    public void counterAttack(Battle battle, Card card) {
        Cell cell = battle.getMap().get(0).get(0).getCellOfCard(card, battle);
        int y = 0;
        if (this.getType().equals("Minion") && ((Minion) this).getTypeOfRange() == 1) {
            y = ((Minion) this).getRange();
        } else if (this.getType().equals("Hero") && ((Hero) this).getTypeOfRange() == 1) {
            y = ((Hero) this).getRange();
        }
        if ((this.getType().equals("Minion") && ((Minion) this).getTypeOfRange() == 0) ||
                (this.getType().equals("Hero") && ((Hero) this).getTypeOfRange() == 0)&&cell.manhataniDistance(battle.getMap().get(0).get(0).getCellOfCard(card, battle).getX(),
                battle.getMap().get(0).get(0).getCellOfCard(card, battle).getY()) <= 2) {
            ((Hero) card).setHp(((Hero) card).getHp() - ((Minion) this).getAp());

        } else if (y != 0 && cell.manhataniDistance(battle.getMap().get(0).get(0).getCellOfCard(card, battle).getX(),
                battle.getMap().get(0).get(0).getCellOfCard(card, battle).getY()) > 2 && cell.manhataniDistance(battle.getMap().get(0).get(0).getCellOfCard(card, battle).getX(),
                battle.getMap().get(0).get(0).getCellOfCard(card, battle).getY()) <= y) {
            if (card.getType().equals("Hero") && this.getType().equals("Hero")) {
                ((Hero) card).setHp(((Hero) card).getHp() - ((Hero) this).getAp());
            } else if (card.getType().equals("Hero") && this.getType().equals("Minion"))
                ((Hero) card).setHp(((Hero) card).getHp() - ((Minion) this).getAp());
            else if (card.getType().equals("Minion") && this.getType().equals("Minion"))
                ((Minion) card).setHp(((Minion) card).getHp() - ((Minion) this).getAp());
            else {
                ((Minion) card).setHp(((Minion) card).getHp() - ((Hero) this).getAp());
            }
        } else if ((this.getType().equals("Minion") && ((Minion) this).getTypeOfRange() == 2) || (this.getType().equals("Hero") && ((Hero) this).getTypeOfRange() == 2)) {
            if (card.getType().equals("Hero") && this.getType().equals("Hero")) {
                ((Hero) card).setHp(((Hero) card).getHp() - ((Hero) this).getAp());
            } else if (card.getType().equals("Hero") && this.getType().equals("Minion"))
                ((Hero) card).setHp(((Hero) card).getHp() - ((Minion) this).getAp());
            else if (card.getType().equals("Minion") && this.getType().equals("Minion"))
                ((Minion) card).setHp(((Minion) card).getHp() - ((Minion) this).getAp());
            else {
                ((Minion) card).setHp(((Minion) card).getHp() - ((Hero) this).getAp());
            }
        }
    }

    public void setRemainedMoves(int remainedMoves) {
        this.remainedMoves = remainedMoves;
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

    public void cardIdGenerator(Battle battle) {
        ArrayList<Card> cards;
        String playerName;
        if (battle.getTurn() % 2 == 1) {
            playerName = battle.getFirstPlayer().getUserName();
            cards = battle.getFirstPlayerInGameCards();
        } else {
            cards = battle.getSecondPlayerInGameCards();
            playerName = battle.getSecondPlayer().getUserName();
        }

        int count = 1;
        for (Card card : cards) {
            if (card.getName().equals(this.name)) {
                count++;
            }
        }
        String str = playerName + "_" + this.getName() + "_" + (count);
        setCardId(str);
    }
}

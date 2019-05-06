package model.Cards;

import model.Battles.Battle;

import java.util.ArrayList;

import model.Buffs.Buff;
import model.Cards.Hero.Hero;
import model.Cards.Minion.Minion;
import model.Cell;
import model.ErrorType;
import view.Request;
import view.View;

public abstract class Card {
    View view = View.getInstance();
    private String name;
    private boolean isOnMap;
    private boolean isHitting;
    private boolean isDying;
    private boolean isComingToMap;
    private int costOfBuy;
    private long id;
    private String cardId;
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
        int x = 0, y = 0;
        if (this.getType().equals("Minion"))
            x = ((Minion) this).getRange();
        else if (this.getType().equals("Hero"))
            x = ((Hero) this).getRange();


        if (card.getType().equals("Minion"))
            y = ((Minion) card).getHolyCounter();
        else
            y = ((Hero) card).getHolyCounter();


        if ((this.getType().equals("Minion") && ((Minion) this).getTypeOfRange() == 0) ||
                (this.getType().equals("Hero") && ((Hero) this).getTypeOfRange() == 0) && cell.manhataniDistance(battle.getMap().get(0).get(0).getCellOfCard(this, battle).getX() + 1,
                        battle.getMap().get(0).get(0).getCellOfCard(this, battle).getY() + 1) <= 2) {
            this.doHarm(card, y, battle, false);

        } else if ((this.getType().equals("Minion") && ((Minion) this).getTypeOfRange() == 1) || (this.getType().equals("Hero") && ((Hero) this).getTypeOfRange() == 1)
                && cell.manhataniDistance(battle.getMap().get(0).get(0).getCellOfCard(this, battle).getX() + 1,
                battle.getMap().get(0).get(0).getCellOfCard(this, battle).getY() + 1) > 2 && cell.manhataniDistance(battle.getMap().get(0).get(0).getCellOfCard(this, battle).getX() + 1,
                battle.getMap().get(0).get(0).getCellOfCard(this, battle).getY() + 1) <= x) {
            this.doHarm(card, y, battle, false);
        } else if (((this.getType().equals("Minion") && ((Minion) this).getTypeOfRange() == 2) || (this.getType().equals("Hero") && ((Hero) this).getTypeOfRange() == 2))
                && cell.manhataniDistance(battle.getMap().get(0).get(0).getCellOfCard(this, battle).getX() + 1,
                battle.getMap().get(0).get(0).getCellOfCard(this, battle).getY() + 1) <= x) {
            this.doHarm(card, y, battle, false);
        } else {

            request.setError(ErrorType.INVALID_TARGET);
            return;
        }
        if (this.getType().equals("Minion"))
            ((Minion) card).increaseNumberOfAttacks();

        card.deadChecker(battle);
        this.setRemainedMoves(0);
        this.setCanAttack(false);
        this.deadChecker(battle);
    }

    public void deadChecker(Battle battle) {
        if (this.getType().equals("Minion") && ((Minion) this).getHp() <= 0) {
            if (battle.getSelectedCard().cardId.equals(this.getCardId()))
                battle.setSelectedCard(null);
            if (battle.getFirstPlayerInGameCards().contains(this)) {
                battle.getFirstPlayerInGameCards().remove(this);
                battle.addToFirstGrave(this);
            } else if (battle.getSecondPlayerInGameCards().contains(this)) {
                battle.getSecondPlayerInGameCards().remove(this);
                battle.addToSecondGrave(this);
            }
            if (battle.getTurn() % 2 == 1 && battle.getFirstPlayerDeck().getUsableItem() != null)
                battle.getFirstPlayerDeck().getUsableItem().applyEffect(battle, null, battle.getFirstPlayer(), 3);
            if (battle.getTurn() % 2 == 0 && battle.getSecondPlayerDeck().getUsableItem() != null)
                battle.getSecondPlayerDeck().getUsableItem().applyEffect(battle, null, battle.getSecondPlayer(), 4 - 1);

        } else if (this.getType().equals("Hero") && ((Hero) this).getHp() <= 0) {
            if (battle.getType().equals("HeroBattle")) {
                if (this.getCardId().contains(battle.getSecondPlayer().getUserName()))
                    view.endGame(battle, true);
                else
                    view.endGame(battle, false);
            }
        }
    }

    public void doHarm(Card card, int y, Battle battle, boolean isCounter) {
        if (card.getType().equals("Hero") && this.getType().equals("Hero")) {
            if (((Hero) this).getAp() >= y && !(((Hero) this).getAp() < ((Hero) card).getAp() && card.getName().equals("Ashkbous")))
                ((Hero) card).setHp(((Hero) card).getHp() - ((Hero) this).getAp() + y);
            if (battle.getTurn() % 2 == 1 && battle.getFirstPlayerDeck().getUsableItem() != null)
                battle.getFirstPlayerDeck().getUsableItem().applyEffect(battle, null, battle.getFirstPlayer(), 6);
            if (battle.getTurn() % 2 == 0 && battle.getSecondPlayerDeck().getUsableItem() != null)
                battle.getSecondPlayerDeck().getUsableItem().applyEffect(battle, null, battle.getSecondPlayer(), 6);


            if (!((Hero) card).isStunning() && ((Hero) card).isCounterAttack() && !isCounter) {
                card.counterAttack(battle, this);
            }
        } else if (card.getType().equals("Hero") && this.getType().equals("Minion")) {

            if (((Minion) this).getAp() >= y && !(((Minion) this).getAp() < ((Hero) card).getAp() && card.getName().equals("Ashkbous")))
                ((Hero) card).setHp(((Hero) card).getHp() - ((Minion) this).getAp() + y);
            if (battle.getTurn() % 2 == 1 && battle.getFirstPlayerDeck().getUsableItem() != null)
                battle.getFirstPlayerDeck().getUsableItem().applyEffect(battle, null, battle.getFirstPlayer(), 6);
            if (battle.getTurn() % 2 == 0 && battle.getSecondPlayerDeck().getUsableItem() != null)
                battle.getSecondPlayerDeck().getUsableItem().applyEffect(battle, null, battle.getSecondPlayer(), 7 - 1);

            if (!((Hero) card).isStunning() && ((Hero) card).isCounterAttack() && !isCounter) {
                card.counterAttack(battle, this);
            }
        } else if (card.getType().equals("Minion") && this.getType().equals("Minion")) {
            if (((Minion) this).getAp() >= y &&! (((Minion) this).getAp() < ((Minion) card).getAp() && card.getName().equals("Ashkbous")))
                ((Minion) card).setHp(((Minion) card).getHp() - ((Minion) this).getAp() + y);
            if (battle.getTurn() % 2 == 1 && battle.getFirstPlayerDeck().getUsableItem() != null)
                battle.getFirstPlayerDeck().getUsableItem().applyEffect(battle, null, battle.getFirstPlayer(), 3);
            if (battle.getTurn() % 2 == 0 && battle.getSecondPlayerDeck().getUsableItem() != null)
                battle.getSecondPlayerDeck().getUsableItem().applyEffect(battle, null, battle.getSecondPlayer(), 3);

            if (!((Minion) card).isStunning() && ((Minion) card).isCounterAttack()) {
                card.counterAttack(battle, this);
            }
        } else {
            if (((Hero) this).getAp() >= y && !(((Hero) this).getAp() < ((Minion) card).getAp() && card.getName().equals("Ashkbous")))
                ((Minion) card).setHp(((Minion) card).getHp() - ((Hero) this).getAp() + y);
            if (battle.getTurn() % 2 == 1 && battle.getFirstPlayerDeck().getUsableItem() != null)
                battle.getFirstPlayerDeck().getUsableItem().applyEffect(battle, null, battle.getFirstPlayer(), 3);
            if (battle.getTurn() % 2 == 0 && battle.getSecondPlayerDeck().getUsableItem() != null)
                battle.getSecondPlayerDeck().getUsableItem().applyEffect(battle, null, battle.getSecondPlayer(), 2 + 1);

            if (!((Minion) card).isStunning() && ((Minion) card).isCounterAttack()) {
                card.counterAttack(battle, this);
            }
        }
    }

    public void counterAttack(Battle battle, Card card) {
        Cell cell = battle.getMap().get(0).get(0).getCellOfCard(card, battle);
        int x = 0, y = 0;
        if (this.getType().equals("Minion")) {
            x = ((Minion) this).getRange();
        } else if (this.getType().equals("Hero")) {
            x = ((Hero) this).getRange();
        }
        if (card.getType().equals("Minion")) {
            y = ((Minion) card).getHolyCounter();
        } else
            y = ((Hero) card).getHolyCounter();
        if ((this.getType().equals("Minion") && ((Minion) this).getTypeOfRange() == 0) ||
                (this.getType().equals("Hero") && ((Hero) this).getTypeOfRange() == 0) && cell.manhataniDistance(battle.getMap().get(0).get(0).getCellOfCard(this, battle).getX() + 1,
                        battle.getMap().get(0).get(0).getCellOfCard(this, battle).getY() + 1) <= 2) {
            this.doHarm(card, y, battle, true);


        } else if ((this.getType().equals("Minion") && ((Minion) this).getTypeOfRange() == 1) || (this.getType().equals("Hero") && ((Hero) this).getTypeOfRange() == 1)
                && cell.manhataniDistance(battle.getMap().get(0).get(0).getCellOfCard(this, battle).getX() + 1,
                battle.getMap().get(0).get(0).getCellOfCard(this, battle).getY() + 1) > 2 && cell.manhataniDistance(battle.getMap().get(0).get(0).getCellOfCard(this, battle).getX() + 1,
                battle.getMap().get(0).get(0).getCellOfCard(this, battle).getY() + 1) <= x) {
            this.doHarm(card, y, battle, true);
        } else if ((this.getType().equals("Minion") && ((Minion) this).getTypeOfRange() == 2) || (this.getType().equals("Hero") && ((Hero) this).getTypeOfRange() == 2)
                && cell.manhataniDistance(battle.getMap().get(0).get(0).getCellOfCard(this, battle).getX() + 1,
                battle.getMap().get(0).get(0).getCellOfCard(this, battle).getY() + 1) <= x) {
            this.doHarm(card, y, battle, true);
        }
    }

    public void setRemainedMoves(int remainedMoves) {
        this.remainedMoves = remainedMoves;
    }

    public void setName(String nameOfCard) {
        this.name = nameOfCard;
    }

    public String getCardId() {
        return cardId.toLowerCase();
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
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

        int count = 0;
        for (Card card : cards) {
            if (card.getName().equals(this.name)) {
                count++;
            }
        }
        String str = playerName + "_" + this.getName() + "_" + (count);
        setCardId(str);
    }

    public boolean isHitting() {
        return isHitting;
    }

    public void setHitting(boolean hitting) {
        isHitting = hitting;
    }

    public boolean isDying() {
        return isDying;
    }

    public void setDying(boolean dying) {
        isDying = dying;
    }

    public boolean isComingToMap() {
        return isComingToMap;
    }

    public void setComingToMap(boolean comingToMap) {
        isComingToMap = comingToMap;
    }
}

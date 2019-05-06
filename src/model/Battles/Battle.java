package model.Battles;

import model.Cards.Card;
import model.Cards.Hero.Hero;
import model.Cards.Minion.Minion;
import model.Item.CollectibleItem.CollectibleItem;
import model.Menus.Account;
import model.*;
import view.Request;

import java.util.ArrayList;

public abstract class Battle {
    private Account firstPlayer;
    private Deck firstPlayerDeck;
    private Deck secondPlayerDeck;
    private Hand firstPlayerHand = new Hand();
    private Card selectedCard;
    private CollectibleItem selectedCollectible;
    private ArrayList<CollectibleItem> firstPlayerCollectibleItem = new ArrayList<>();
    private int reward;
    private ArrayList<CollectibleItem> secondPlayerCollectibleItem = new ArrayList<>();
    private ArrayList<ArrayList<Cell>> map = new ArrayList<>();
    private int turn = 1;
    private ArrayList<Card> firstPlayerInGameCards = new ArrayList<>();
    private ArrayList<Card> secondPlayerInGameCards = new ArrayList<>();
    private ArrayList<Card> firstGrave = new ArrayList<>();
    private ArrayList<Card> secondGrave = new ArrayList<>();
    private int firstPlayerFlagCarryTurnCounter = 0;
    private int secondPlayerFlagCarryTurnCounter = 0;

    public void setFirstPlayerFlagCarryTurnCounter(int firstPlayerFlagCarryTurnCounter) {
        this.firstPlayerFlagCarryTurnCounter = firstPlayerFlagCarryTurnCounter;
    }

    public void setSecondPlayerFlagCarryTurnCounter(int secondPlayerFlagCarryTurnCounter) {
        this.secondPlayerFlagCarryTurnCounter = secondPlayerFlagCarryTurnCounter;
    }

    public int getFirstPlayerFlagCarryTurnCounter() {
        return firstPlayerFlagCarryTurnCounter;
    }

    public int getSecondPlayerFlagCarryTurnCounter() {
        return secondPlayerFlagCarryTurnCounter;
    }

    public void incrementFirstPlayerFlagCarryTurnCounter() {
        this.firstPlayerFlagCarryTurnCounter++;
    }

    public void incrementSecondPlayerFlagCarryTurnCounter() {
        this.secondPlayerFlagCarryTurnCounter++;
    }

    protected Battle(Account firstPlayer, Deck deck, Deck deck2) {
        this.firstPlayer = firstPlayer;
        this.firstPlayerDeck = deck;
        this.secondPlayerDeck = deck2;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    abstract public String getType();

    public ArrayList<CollectibleItem> getFirstPlayerCollectibleItem() {
        return firstPlayerCollectibleItem;
    }

    public ArrayList<CollectibleItem> getSecondPlayerCollectibleItem() {
        return secondPlayerCollectibleItem;
    }

    public void addSecondPlayerCollectibleItem(CollectibleItem collectibleItem) {
        secondPlayerCollectibleItem.add(collectibleItem);
    }

    public void addFirstPlayerCollectibleItem(CollectibleItem collectibleItem) {
        firstPlayerCollectibleItem.add(collectibleItem);
    }

    public void addToFirstGrave(Card card) {
        firstGrave.add(card);
    }

    public void addToSecondGrave(Card card) {
        secondGrave.add(card);
    }

    public ArrayList<Card> getFirstGrave() {
        return firstGrave;
    }

    public ArrayList<Card> getSecondGrave() {
        return secondGrave;
    }

    public Card getSelectedCard() {
        return selectedCard;
    }

    public Card getCard(String name, int x) {
        if (x == 0) {
            for (Card card : this.getFirstPlayerInGameCards()) {
                if (card.getCardId().equals(name))
                    return card;
            }
        } else {
            for (Card card : this.getSecondPlayerInGameCards()) {
                if (card.getCardId().equals(name))
                    return card;
            }
        }
        return null;
    }

    public void setSelectedCard(Card selectedCard) {
        if (selectedCard != null && selectedCard.getType().equals("Spell"))
            return;
        this.selectedCard = selectedCard;
    }

    public void setSelectedCollectible(CollectibleItem selectedCollectible) {
        this.selectedCollectible = selectedCollectible;
    }

    public CollectibleItem getSelectedCollectible() {
        return selectedCollectible;
    }

    public void addFirstPlayerInGameCards(Card card) {
        this.firstPlayerInGameCards.add(card);
    }

    public void ComboAttack(Card oppCard, ArrayList<Minion> cards, Request request) {
        Cell oppCell = this.getMap().get(0).get(0).getCellOfCard(oppCard, this);
        if (oppCell == null) {
            request.setError(ErrorType.CARD_NOT_FOUND_IN_GAME);
            return;
        }
        if (((Minion) cards.get(0)).isStunning()) {
            request.setError(ErrorType.CARD_IS_STUNNED);
        }
        for (Card card : cards) {

            if (((Minion) card).getTypeOfRange() == 0 && oppCell.manhataniDistance(this.getMap().get(0).get(0).getCellOfCard(card, this).getX(),
                    this.getMap().get(0).get(0).getCellOfCard(card, this).getY()) <= 2) {
                if (oppCard.getType().equals("Minion"))
                    ((Minion) oppCard).setHp(((Minion) oppCard).getHp() - ((Minion) card).getAp());
                else
                    ((Hero) oppCard).setHp(((Hero) oppCard).getHp() - ((Minion) card).getAp());
            } else if (((Minion) card).getTypeOfRange() == 1 && oppCell.manhataniDistance(this.getMap().get(0).get(0).getCellOfCard(card, this).getX(),
                    this.getMap().get(0).get(0).getCellOfCard(card, this).getY()) > 2 && oppCell.manhataniDistance(this.getMap().get(0).get(0).getCellOfCard(card, this).getX(),
                    this.getMap().get(0).get(0).getCellOfCard(card, this).getY()) <= ((Minion) card).getRange()) {
                if (oppCard.getType().equals("Minion"))
                    ((Minion) oppCard).setHp(((Minion) oppCard).getHp() - ((Minion) card).getAp());
                else
                    ((Hero) oppCard).setHp(((Hero) oppCard).getHp() - ((Minion) card).getAp());
            } else if (((Minion) card).getTypeOfRange() == 2) {
                if (oppCard.getType().equals("Minion"))
                    ((Minion) oppCard).setHp(((Minion) oppCard).getHp() - ((Minion) card).getAp());
                else
                    ((Hero) oppCard).setHp(((Hero) oppCard).getHp() - ((Minion) card).getAp());

            }
        }
        oppCard.counterAttack(this, cards.get(0));
        oppCard.deadChecker(this);
        ((Minion) cards.get(0)).setCanAttack(false);
        ((Minion) cards.get(0)).setRemainedMoves(0);
        ((Minion) cards.get(0)).deadChecker(this);
    }

    public void addSecondPlayerInGameCards(Card card) {
        this.secondPlayerInGameCards.add(card);
    }

    public ArrayList<Card> getFirstPlayerInGameCards() {
        return firstPlayerInGameCards;
    }

    public ArrayList<Card> getSecondPlayerInGameCards() {
        return secondPlayerInGameCards;
    }

    public int getTurn() {
        return turn;
    }

    public void increamentTurn() {
        this.turn++;
    }

    public void decreamentTurn() {
        turn--;
    }

    public ArrayList<ArrayList<Cell>> getMap() {
        return map;
    }

    public abstract void showDetailedInfo();

    public Account getFirstPlayer() {
        return firstPlayer;
    }

    public Deck getFirstPlayerDeck() {
        return firstPlayerDeck;
    }

    public Deck getSecondPlayerDeck() {
        return secondPlayerDeck;
    }

    public Hand getFirstPlayerHand() {
        return firstPlayerHand;
    }

    public abstract boolean isPlayWithAI();

    public abstract Account getSecondPlayer();

    public abstract Hand getSecondPlayerHand();
}


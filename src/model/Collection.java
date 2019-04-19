package model;

import view.*;

import java.util.ArrayList;

public class Collection {
    private static View view = View.getInstance();
    private ArrayList<Hero> heroes = new ArrayList<>();
    private ArrayList<Spell> spells = new ArrayList<>();
    private ArrayList<Minion> minions = new ArrayList<>();
    private ArrayList<Item> items = new ArrayList<>();
    private ArrayList<Deck> decks = new ArrayList<>();

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(ArrayList<Hero> heroes) {
        this.heroes = heroes;
    }

    public ArrayList<Spell> getSpells() {
        return spells;
    }

    public void setSpells(ArrayList<Spell> spells) {
        this.spells = spells;
    }

    public ArrayList<Minion> getMinions() {
        return minions;
    }

    public void setMinions(ArrayList<Minion> minions) {
        this.minions = minions;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Deck> getDecks() {
        return decks;
    }

    public void setDecks(ArrayList<Deck> decks) {
        this.decks = decks;
    }

    public void addDeck(Deck deck) {
        this.decks.add(deck);
    }


    public void showObjects() {
        view.showCollection(this);
    }

    public ArrayList<Integer> search(String objectName) {
        ArrayList<Integer> ids = new ArrayList<>();
        for (Hero hero : getHeroes()) {
            if (hero.getName().equals(objectName)){
                 ids.add(hero.getId());
            }
        }
        for (Spell spell : getSpells()) {
            if (spell.getName().equals(objectName)){
                ids.add(spell.getId());
            }
        }
        for (Minion minion : getMinions()) {
            if (minion.getName().equals(objectName)){
                ids.add(minion.getId());
            }
        }
        for (Item item : getItems()) {
            if (item.getName().equals(objectName)){
                ids.add(item.getId());
            }
        }
        return ids;
    }

    public void createDeck(String deckName) {
        for (Deck deck : getDecks()) {
            if (deck.getName().equals(deckName)) {
                view.printError(ErrorType.DECK_EXISTENCE);
                return;
            }
        }
        Deck newDeck = new Deck();
        newDeck.setName(deckName);
        getDecks().add(newDeck);
    }

    public void deleteDeck(String deckName) {
        getDecks().removeIf(deck -> deck.getName().equals(deckName));
    }

    public Deck findDeck(String name) {
        for (Deck deck : getDecks()) {
            if (deck.getName().equals(name)) {
                return deck;
            }
        }
        return null;
    }

    public boolean hasThisCard(int objectID) {
        for (Hero hero : getHeroes()) {
            if (hero.getId() == objectID) {
                return true;
            }
        }
        for (Spell spell : getSpells()) {
            if (spell.getId() == objectID) {
                return true;
            }
        }
        for (Minion minion : getMinions()) {
            if (minion.getId() == objectID) {
                return true;
            }
        }
        for (Item item : getItems()) {
            if (item.getId() == objectID) {
                return true;
            }
        }
        return false;
    }

    public boolean hasThisCard(String objectName) {
        for (Hero hero : getHeroes()) {
            if (hero.getName().equals(objectName)) {
                return true;
            }
        }
        for (Spell spell : getSpells()) {
            if (spell.getName().equals(objectName)) {
                return true;
            }
        }
        for (Minion minion : getMinions()) {
            if (minion.getName().equals(objectName)) {
                return true;
            }
        }
        for (Item item : getItems()) {
            if (item.getName().equals(objectName)) {
                return true;
            }
        }
        return false;
    }

    public void addToDeck(int objectId, String deckName) {
        Deck deck = findDeck(deckName);
        for (Hero hero : getHeroes()) {
            if (hero.getId() == objectId) {
                deck.setHero(hero);
                return;
            }
        }
        for (Spell spell : getSpells()) {
            if (spell.getId() == objectId) {
                deck.getSpells().add(spell);
                return;
            }
        }
        for (Minion minion : getMinions()) {
            if (minion.getId() == objectId) {
                deck.getMinions().add(minion);
                return;
            }
        }
        for (Item item : getItems()) {
            if (item.getId() == objectId) {
                deck.setItem(item);
                return;
            }
        }
    }

    public boolean isHero(int objectId) {
        for (Hero hero : getHeroes()) {
            if (hero.getId() == objectId)
                return true;
        }
        return false;
    }

    public void removeFromDeck(int objectID, String deckName) {
        Deck deck = findDeck(deckName);
        if (deck.getHero().getId() == objectID) {
            deck.setHero(null);
        }
        if (deck.getItem().getId() == objectID) {
            deck.setItem(null);
        }
        deck.getSpells().removeIf(spell -> spell.getId() == objectID);
        deck.getMinions().removeIf(minion -> minion.getId() == objectID);
    }


    public boolean checkDeckValidation(String deckName) {
        Deck deck = findDeck(deckName);
        if (deck.isValid())
            return true;
        else
            return false;
    }

    public void selectDeck(String deckName) {
        Deck deck = findDeck(deckName);
        Account.getLoginAccount().setMainDeck(deck);
    }

    public void showAllDecks() {

    }

    public void showDeck(String deckName) {
        Deck deck = findDeck(deckName);
        view.printDeckDetails(deck);
    }

    //an unit error message for invalid deck
}

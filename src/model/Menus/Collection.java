package model.Menus;

import model.Cards.Hero;
import model.Cards.Minion;
import model.Cards.Spell;
import model.Deck;
import model.Item.UsableItem;
import view.*;

import java.util.ArrayList;

public class Collection {
    private static View view = View.getInstance();
    private ArrayList<Hero> heroes = new ArrayList<>();
    private ArrayList<Spell> spells = new ArrayList<>();
    private ArrayList<Minion> minions = new ArrayList<>();
    private ArrayList<UsableItem> usableItems = new ArrayList<>();
    private ArrayList<Deck> decks = new ArrayList<>();
    private ArrayList<Deck> stroyModeDeck = new ArrayList<>();//should be added
    private int idMaker = 0;

    public ArrayList<Deck> getStroyModeDeck() {
        return stroyModeDeck;
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(ArrayList<Hero> heroes) {
        this.heroes = heroes;
    }

    public int getIdMaker() {
        return idMaker;
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

    public ArrayList<UsableItem> getUsableItems() {
        return usableItems;
    }

    public void setUsableItems(ArrayList<UsableItem> usableItems) {
        this.usableItems = usableItems;
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

    public void addToCollection(String cardName) {
        for (Hero hero : Hero.getHeroes()) {
            if (hero.getName().equals(cardName)) {
                hero.setId(this.getIdMaker());
                this.idMaker++;
                this.heroes.add(hero);
                return;
            }
        }
        for (Spell spell : Spell.getSpells()) {
            if (spell.getName().equals(cardName)) {
                spell.setId(this.getIdMaker());
                this.idMaker++;
                this.spells.add(spell);
                return;
            }
        }
        for (Minion minion : Minion.getMinions()) {
            if (minion.getName().equals(cardName)) {
                minion.setId(this.getIdMaker());
                this.idMaker++;
                this.minions.add(minion);
                return;
            }
        }
        for (UsableItem usableItem : UsableItem.getUsableItems()) {
            if (usableItem.getName().equals(cardName)) {
                usableItem.setId(this.getIdMaker());
                this.idMaker++;
                this.usableItems.add(usableItem);
                return;
            }
        }
    }

    public ArrayList<Integer> search(String objectName) {
        ArrayList<Integer> ids = new ArrayList<>();
        for (Hero hero : getHeroes()) {
            if (hero.getName().equals(objectName)) {
                ids.add(hero.getId());
            }
        }
        for (Spell spell : getSpells()) {
            if (spell.getName().equals(objectName)) {
                ids.add(spell.getId());
            }
        }
        for (Minion minion : getMinions()) {
            if (minion.getName().equals(objectName)) {
                ids.add(minion.getId());
            }
        }
        for (UsableItem usableItem : getUsableItems()) {
            if (usableItem.getName().equals(objectName)) {
                ids.add(usableItem.getId());
            }
        }
        return ids;
    }

    public void createDeck(String deckName) {
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
        for (UsableItem usableItem : getUsableItems()) {
            if (usableItem.getId() == objectID) {
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
        for (UsableItem usableItem : getUsableItems()) {
            if (usableItem.getName().equals(objectName)) {
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
        for (UsableItem usableItem : getUsableItems()) {
            if (usableItem.getId() == objectId) {
                deck.setUsableItem(usableItem);
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
        if (deck.getUsableItem().getId() == objectID) {
            deck.setUsableItem(null);
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
        //todo check working
        int index = 1;
        if (Account.getLoginAccount().getMainDeck() != null) {
            view.printDeckDetails(Account.getLoginAccount().getMainDeck(), index++, true);
            for (Deck deck : this.getDecks()) {
                if (deck.getName().equals(Account.getLoginAccount().getMainDeck().getName()))
                    continue;
                view.printDeckDetails(deck, index, true);
                index++;
            }
        } else {

            for (Deck deck : this.getDecks()) {
                view.printDeckDetails(deck, index, true);
            }
        }
    }

    public void showDeck(String deckName) {
        Deck deck = findDeck(deckName);
        view.printDeckDetails(deck, 1, false);
    }

    public void removeCardFromCollection(int objectId) {
        this.getHeroes().removeIf(hero -> hero.getId() == objectId);
        this.getSpells().removeIf(spell -> spell.getId() == objectId);
        this.getMinions().removeIf(minion -> minion.getId() == objectId);
        this.getUsableItems().removeIf(item -> item.getId() == objectId);
        for (Deck deck : this.getDecks()) {
            removeFromDeck(objectId, deck.getName());
        }
    }

    public int costOfCard(int id) {
        for (Hero hero : this.getHeroes()) {
            if (hero.getId() == id)
                return hero.getCostOfBuy();
        }
        for (Minion minion : this.getMinions()) {
            if (minion.getId() == id)
                return minion.getCostOfBuy();
        }
        for (Spell spell : this.getSpells()) {
            if (spell.getId() == id)
                return spell.getCostOfBuy();
        }
        for (UsableItem usableItem : this.getUsableItems()) {
            if (usableItem.getId() == id)
                return usableItem.getCostOfBuy();
        }
        return 0;
    }
}

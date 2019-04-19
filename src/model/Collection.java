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

    public void search(String name) {
        Hero hero;
        hero = isHero(name, -1);
        if (hero != null) {
            //todo == is working or not
            view.printObjectId(hero.getId());
        } else {
            Spell spell;
            spell = isSpell(name, -1);
            if (spell != null) {
                view.printObjectId(spell.getId());
            } else {
                Minion minion;
                minion = isMinion(name, -1);
                if (minion != null) {
                    view.printObjectId(minion.getId());
                } else {
                    Item item;
                    item = isItem(name, -1);
                    if (item != null) {
                        view.printObjectId(item.getId());
                    } else {
                        view.printError(ErrorType.INVALID_NAME);
                    }
                }
            }
        }
    }

    private Item isItem(String name, int id) {
        if (id == -1) {
            for (Item item : this.getItems()) {
                if (item.getName().equals(name)) {
                    return item;
                }
            }
        } else {
            for (Item item : this.getItems()) {
                if (item.getId() == (id)) {
                    return item;
                }
            }
        }
        return null;
    }

    private Spell isSpell(String name, int id) {
        if (id == -1) {
            for (Spell spell : this.getSpells()) {
                if (spell.getName().equals(name)) {
                    return spell;
                }
            }
        } else {
            for (Spell spell : this.getSpells()) {
                if (spell.getId() == id) {
                    return spell;
                }
            }
        }
        return null;
    }

    private Minion isMinion(String name, int id) {
        if (id == -1) {
            for (Minion minion : this.getMinions()) {
                if (minion.getName().equals(name)) {
                    return minion;
                }
            }
        } else {
            for (Minion minion : this.getMinions()) {
                if (minion.getId() == id) {
                    return minion;
                }
            }
        }
        return null;
    }

    private Hero isHero(String name, int id) {
        if (id == -1) {
            for (Hero hero : this.getHeroes()) {
                if (hero.getName().equals(name)) {
                    return hero;
                }
            }
        } else {
            for (Hero hero : this.getHeroes()) {
                if (hero.getId() == id) {
                    return hero;
                }
            }
        }
        return null;
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
        //todo --> check it is work or not
        //todo --> error message should be written or not
    }

    public Deck findDeck(String name) {
        for (Deck deck : getDecks()) {
            if (deck.getName().equals(name)) {
                return deck;
            }
        }
        return null;
        //todo --> deck is copy not real one
    }

    public void addToDeck(int objectId, String deckName) {
        Deck deck = findDeck(deckName);
        if (deck.isFilled()) {
            view.printError(ErrorType.DECK_FILLED);
            return;
        }
        Hero hero = isHero(null, objectId);
        if (hero != null) {
            //todo check working
            if (deck.getHero() == null) {
                deck.setHero(hero);
            } else {
                view.printError(ErrorType.WRONG_ADDING);
            }
        } else {
            Spell spell = isSpell(null, objectId);
            if (spell != null) {
                deck.getSpells().add(spell);
            } else {
                Minion minion = isMinion(null, objectId);
                if (minion != null) {
                    deck.getMinions().add(minion);
                } else {
                    Item item = isItem(null, objectId);
                    if (item != null) {
                        if (deck.getItem() == null) {
                            //todo check working
                            deck.setItem(item);
                        } else {
                            view.printError(ErrorType.WRONG_ADDING);
                        }
                    } else {
                        view.printError(ErrorType.INVALID_DECK);
                    }
                }
            }
        }
        //show an error message(s)
    }

    public void removeFromDeck(int objectID, String deckName) {
        Deck deck = findDeck(deckName);
        boolean isInDeck = isInDeck(objectID, deck);
        if (!isInDeck) {
            view.printError(ErrorType.WRONG_REMOVE);
        } else {
            Hero hero = isHero(null, objectID);
            if (hero != null) {
                //todo == is working or not
                deck.setHero(null);
            } else {
                Spell spell = isSpell(null, objectID);
                if (spell != null) {
                    deck.getSpells().remove(spell);
                    //todo error checking
                } else {
                    Minion minion = isMinion(null, objectID);
                    if (minion != null) {
                        deck.getMinions().remove(minion);
                    } else {
                        Item item = isItem(null, objectID);
                        if (item != null) {
                            deck.setItem(null);
                        } else {
                            view.printError(ErrorType.INVALID_NAME);
                        }
                    }
                }
            }
        }
    }

    private boolean isInDeck(int objectID, Deck deck) {
        Hero hero = isHero(null, objectID);
        boolean isInDeck;
        if (hero != null) {
            //todo == is working or not
            if (deck.getHero() != null && deck.getHero().getId == objectID) {
                isInDeck = true;
            } else {
                isInDeck = false;
            }
        } else {
            Spell spell = isSpell(null, objectID);
            if (spell != null) {
                if (deck.getSpells().contains(spell)) {
                    isInDeck = true;
                } else {
                    isInDeck = false;
                }
            } else {
                Minion minion = isMinion(null, objectID);
                if (minion != null) {
                    if (deck.getMinions().contains(minion)) {
                        isInDeck = true;
                    } else {
                        isInDeck = false;
                    }
                } else {
                    Item item = isItem(null, objectID);
                    if (item != null) {
                        if (deck.getItem() != null && deck.getItem().getId == objectID) {
                            isInDeck = true;
                        } else {
                            isInDeck = false;
                        }
                    } else {
                        isInDeck = false;
                    }
                }
            }
        }
        if (isInDeck)
            return true;
        return false;
    }

    public boolean checkDeckValidation(String deckName) {
        Deck deck = findDeck(deckName);
        if (deck.isValid())
            return true;
        else
            return false;
    }
    public boolean (String deckName) {
        Deck deck = findDeck(deckName);
        if (deck != null) {
            if (deck.isValid()) {
                return true;
            } else {
                //view.printError(ErrorType.INVALID_DECK);
                return false;
            }
        } else {
            view.printError(ErrorType.NO_DECK_FOUND);
            return false;
        }
    }
    public void selectDeck(String deckName) {
        Deck deck = findDeck(deckName);
        boolean validate = checkDeckValidation(deckName);
        if (validate){
            Account.getLoginAccount().getMainDeck() = deck;
        }
        //todo 1:maindeck 2:check deck is copy or not
    }

    public void showAllDecks() {
        //todo check working
        if (Account.getLoginAccount().mainDeck != null){
            showDeck(Account.getLoginAccount().mainDeck);
            for (Deck deck : this.getDecks()) {
                if (deck == Account.getLoginAccount().mainDeck)
                    continue;
                view.printDeckDetails(deck);
            }
        }
    }

    public void showDeck(String deckName) {
        Deck deck = findDeck(deckName);
        view.printDeckDetails(deck);
    }

    //an unit error message for invalid deck
}

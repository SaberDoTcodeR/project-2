package view;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import control.*;
import model.*;
import model.Battles.*;
import model.Cards.*;
import model.Cards.Hero.Hero;
import model.Cards.Minion.Minion;
import model.Cards.Spell.Spell;
import model.Item.CollectibleItem.CollectibleItem;
import model.Menus.*;

public abstract class Command {
    static View view = View.getInstance();
    Pattern pattern;
    Matcher matcher;

    public Command(CommandRegex command) {
        pattern = Pattern.compile(command.getRegex());
    }

    public Matcher getMatcher() {
        return matcher;
    }

    public abstract void apply(Request request);
}

class Show extends Command {

    Show() {
        super(CommandRegex.SHOW);
    }

    @Override
    public void apply(Request request) {
        Account.getLoginAccount().getCollection().showObjects();
    }
}

class Search extends Command {

    Search() {
        super(CommandRegex.SEARCH);
    }

    @Override
    public void apply(Request request) {
        String objectName = matcher.group(1).trim();
        if (Account.getLoginAccount().getCollection().hasThisCard(objectName)) {
            System.out.println();
            view.printObjectId(Account.getLoginAccount().getCollection().search(objectName));
        } else {
            request.setError(ErrorType.INVALID_NAME);
        }
    }
}

class CreateDeck extends Command {

    CreateDeck() {
        super(CommandRegex.CREATE_DECK);
    }

    @Override
    public void apply(Request request) {
        String deckName = matcher.group(1).trim();
        if (Account.getLoginAccount().getCollection().findDeck(deckName) == null) {
            Account.getLoginAccount().getCollection().createDeck(deckName);
        } else {
            request.setError(ErrorType.DECK_EXISTENCE);
        }

    }
}

class DeleteDeck extends Command {

    DeleteDeck() {
        super(CommandRegex.DELETE_DECK);
    }

    @Override
    public void apply(Request request) {
        String deckName = matcher.group(1).trim();
        if (Account.getLoginAccount().getCollection().findDeck(deckName) != null) {
            Account.getLoginAccount().getCollection().deleteDeck(deckName);
        } else {
            request.setError(ErrorType.NO_DECK_FOUND);
        }
    }
}

class Add extends Command {

    Add() {
        super(CommandRegex.ADD);
    }

    @Override
    public void apply(Request request) {
        int id = Integer.parseInt(matcher.group(1).trim());
        String deckName = matcher.group(2).trim();
        if (Account.getLoginAccount().getCollection().findDeck(deckName) == null) {
            request.setError(ErrorType.NO_DECK_FOUND);
            return;
        }
        if (Account.getLoginAccount().getCollection().hasThisCard(id)) {
            if (!Account.getLoginAccount().getCollection().findDeck(deckName).hasThisCard(id)) {
                if (!Account.getLoginAccount().getCollection().findDeck(deckName).isFilled()) {
                    if (Account.getLoginAccount().getCollection().findDeck(deckName).getHero() != null &&
                            Account.getLoginAccount().getCollection().isHero(id)) {
                        request.setError(ErrorType.DECK_ALREADY_HAS_HERO);
                    } else {
                        Account.getLoginAccount().getCollection().addToDeck(id, deckName);
                    }
                } else {
                    request.setError(ErrorType.DECK_FILLED);
                }
            } else {
                request.setError(ErrorType.CARD_EXISTENCE_IN_DECK);
            }
        } else {
            request.setError(ErrorType.CARD_EXISTENCE);
        }
    }
}

class Remove extends Command {

    Remove() {
        super(CommandRegex.REMOVE);
    }

    @Override
    public void apply(Request request) {
        int id = Integer.parseInt(matcher.group(1).trim());
        String deckName = matcher.group(2).trim();
        if (Account.getLoginAccount().getCollection().findDeck(deckName) != null) {
            if (Account.getLoginAccount().getCollection().findDeck(deckName).hasThisCard(id)) {
                Account.getLoginAccount().getCollection().removeFromDeck(id, deckName);
            } else {
                request.setError(ErrorType.WRONG_REMOVE);
            }
        } else {
            request.setError(ErrorType.NO_DECK_FOUND);
        }
    }
}

class ValidateDeck extends Command {

    ValidateDeck() {
        super(CommandRegex.VALIDATE_DECK);
    }

    @Override
    public void apply(Request request) {
        String deckName = matcher.group(1).trim();
        if (Account.getLoginAccount().getCollection().findDeck(deckName) != null) {
            request.validateDeck(deckName);
        } else {
            request.setError(ErrorType.NO_DECK_FOUND);
        }
    }
}

class SelectDeck extends Command {

    SelectDeck() {
        super(CommandRegex.SELECT_DECK);
    }

    @Override
    public void apply(Request request) {
        String deckName = matcher.group(1).trim();
        if (Account.getLoginAccount().getCollection().findDeck(deckName) != null) {
            if (Account.getLoginAccount().getCollection().checkDeckValidation(deckName)) {
                Account.getLoginAccount().getCollection().selectDeck(deckName);
            } else {
                request.setError(ErrorType.INVALID_DECK);
            }
        } else {
            request.setError(ErrorType.NO_DECK_FOUND);
        }
    }
}

class ShowDeck extends Command {

    ShowDeck() {
        super(CommandRegex.SHOW_DECK);
    }

    @Override
    public void apply(Request request) {
        String deckName = matcher.group(1).trim();
        if (Account.getLoginAccount().getCollection().findDeck(deckName) != null) {
            Account.getLoginAccount().getCollection().showDeck(deckName);
        } else {
            request.setError(ErrorType.NO_DECK_FOUND);
        }
    }
}

class ShowAllDecks extends Command {

    ShowAllDecks() {
        super(CommandRegex.SHOW_ALL_DECKS);
    }

    @Override
    public void apply(Request request) {
        Account.getLoginAccount().getCollection().showAllDecks();
    }
}


class EnterBattle extends Command {

    EnterBattle() {
        super(CommandRegex.ENTER_BATTLE);
    }

    @Override
    public void apply(Request request) {
        if (!request.mainDeckValidation())
            return;
        BattleControl battleControl = new BattleControl();
        battleControl.main();
    }
}

class EnterCollection extends Command {

    EnterCollection() {
        super(CommandRegex.ENTER_COLLECTION);
    }

    @Override
    public void apply(Request request) {
        CollectionControl collectionControl = new CollectionControl();
        collectionControl.main();
    }
}

class EnterShop extends Command {

    EnterShop() {
        super(CommandRegex.ENTER_SHOP);
    }

    @Override
    public void apply(Request request) {
        ShopControl shopControl = new ShopControl();
        shopControl.main();
    }
}

class Help extends Command {

    Help() {
        super(CommandRegex.HELP);
    }

    @Override
    public void apply(Request request) {

    }
}

class HelpInBattle extends Command {

    HelpInBattle() {
        super(CommandRegex.HELP);
    }

    @Override
    public void apply(Request request) {
        System.out.println("Moves Can be performed:");
        ArrayList<Card> cards;
        ArrayList<Card> handCards;
        int mana;
        if (request.getBattle().getTurn() % 2 == 1) {
            cards = request.getBattle().getFirstPlayerInGameCards();
            handCards = request.getBattle().getFirstPlayerHand().getCards();
            mana = request.getBattle().getFirstPlayer().getMana();
        } else {
            cards = request.getBattle().getSecondPlayerInGameCards();
            handCards = request.getBattle().getSecondPlayerHand().getCards();
            mana = request.getBattle().getSecondPlayer().getMana();
        }
        for (Card card : cards) {
            if (card.getRemainedMoves() > 0)
                System.out.println(card.getCardId() + " can do " + card.getRemainedMoves() + " distance moves.");
        }
        System.out.println("Attacks Can be performed:");
        for (Card card : cards) {
            if (card.getCanAttack() && ((card.getType().equals("Minion") && !((Minion) card).isStunning()) || (card.getType().equals("Hero")
                    && !((Hero) card).isStunning())))
                System.out.println(card.getCardId() + " can do Attack");
        }
        System.out.println("Cards Can be put in game:");
        for (Card card : handCards) {
            if ((card.getType().equals("Minion") && mana >= ((Minion) card).getCostToUse()) || (card.getType().equals("Spell")
                    && mana >= ((Spell) card).getCostToUse())) {
                System.out.println(card.getName() + " can be bought.");
            }
        }
    }
}

class ExitFromSubMenu extends Command {

    ExitFromSubMenu() {
        super(CommandRegex.EXIT);
    }

    @Override
    public void apply(Request request) {

        MainMenuControl mainMenuControl = new MainMenuControl();
        mainMenuControl.main();
    }
}

class Exit extends Command {

    Exit() {
        super(CommandRegex.EXIT);
    }

    @Override
    public void apply(Request request) {
        System.exit(0);
    }
}

class ExitFromMainMenu extends Command {

    ExitFromMainMenu() {
        super(CommandRegex.EXIT);
    }

    @Override
    public void apply(Request request) {

        Account.setLoginAccount(null);
        AccountControl accountControl = new AccountControl();
        accountControl.main();
    }
}

class CreateAccount extends Command {

    CreateAccount() {
        super(CommandRegex.CREATE_ACCOUNT);
    }

    @Override
    public void apply(Request request) {
        String userName = matcher.group(1).trim();
        if (!request.repetitiousUser(userName)) {
            System.out.println("Set Your PassWord " + userName + " :");
            String pass = Request.scanner.nextLine();
            Account.setLoginAccount(new Account(userName, pass));
            MainMenuControl mainMenuControl = new MainMenuControl();
            mainMenuControl.main();
        } else {
            request.setError(ErrorType.USER_ALREADY_CREATED);
        }
    }
}

class Login extends Command {

    Login() {
        super(CommandRegex.LOGIN);
    }

    @Override
    public void apply(Request request) {
        String userName = matcher.group(1).trim();
        if (request.existThisUser(userName)) {
            System.out.println("Enter Your PassWord :");
            String pass = Request.scanner.nextLine();
            request.authorize(userName, pass);

        }
    }
}

class ShowLeaderBoard extends Command {

    ShowLeaderBoard() {
        super(CommandRegex.SHOW_LEADERBOARD);
    }

    @Override
    public void apply(Request request) {
        Account.showLeaderboard();
    }
}

class Save extends Command {

    Save() {
        super(CommandRegex.SAVE);
    }

    @Override
    public void apply(Request request) {
        Account.setLoginAccount(null);
        AccountControl accountControl = new AccountControl();
        accountControl.main();
    }
}

class LogOut extends Command {

    LogOut() {
        super(CommandRegex.LOGOUT);
    }

    @Override
    public void apply(Request request) {
        if (Account.getLoginAccount() == null) {
            request.setError(ErrorType.ALREADY_LOGOUT);
            return;
        }
        Account.setLoginAccount(null);
        AccountControl accountControl = new AccountControl();
        accountControl.main();
    }
}

class ShowCollection extends Command {
    ShowCollection() {
        super(CommandRegex.SHOW_COLLECTION);
    }

    @Override
    public void apply(Request request) {
        view.showCollection(Account.getLoginAccount().getCollection());
    }
}

class SearchOfShop extends Command {
    SearchOfShop() {
        super(CommandRegex.SEARCH);
    }

    @Override
    public void apply(Request request) {
        String objectName = matcher.group(1).trim();
        Shop shop = new Shop();
        if (shop.hasThisCard(objectName)) {
            request.setError(ErrorType.IS_IN_SHOP);
        } else {
            request.setError(ErrorType.NOT_IN_SHOP);
        }
    }
}

class SearchCollection extends Command {
    SearchCollection() {
        super(CommandRegex.SEARCH_COLLECTION);
    }

    @Override
    public void apply(Request request) {
        String objectName = matcher.group(1).trim();
        if (Account.getLoginAccount().getCollection().hasThisCard(objectName)) {
            System.out.println("List of ID :");
            view.printObjectId(Account.getLoginAccount().getCollection().search(objectName));
        } else {
            request.setError(ErrorType.INVALID_NAME);
        }
    }

}

class Buy extends Command {
    Buy() {
        super(CommandRegex.BUY);
    }

    @Override
    public void apply(Request request) {
        String cardName = matcher.group(1).trim();
        Shop shop = new Shop();
        if (shop.hasThisCard(cardName)) {
            if (shop.costOfCard(cardName) > Account.getLoginAccount().getMoney()) {
                request.setError(ErrorType.DONT_HAVE_ENOUGH_MONEY);
            } else {
                if (Account.getLoginAccount().getCollection().getUsableItems().size() < 3) {
                    request.setError(ErrorType.CARD_SUCCESSFULLY_BOUGHT);
                    Account.getLoginAccount().decrement(shop.costOfCard(cardName));
                    Account.getLoginAccount().getCollection().addToCollection(cardName);
                } else {
                    request.setError(ErrorType.THREE_ITEMS_ALREADY_OCCUPIED);
                }
            }
        } else {
            request.setError(ErrorType.CARD_NOT_FOUND_IN_SHOP);
        }
    }
}

class Sell extends Command {
    Sell() {
        super(CommandRegex.SELL);
    }

    @Override
    public void apply(Request request) {
        int objectId = Integer.parseInt(matcher.group(1).trim());
        if (Account.getLoginAccount().getCollection().hasThisCard(objectId)) {
            int cost = Account.getLoginAccount().getCollection().costOfCard(objectId);
            Account.getLoginAccount().incrementMoney(cost);
            Account.getLoginAccount().getCollection().removeCardFromCollection(objectId);
            request.setError(ErrorType.DONE_MESSAGE);
        } else {
            request.setError(ErrorType.CARD_EXISTENCE);
        }
    }
}

class ShowShop extends Command {
    ShowShop() {
        super(CommandRegex.SHOW);
    }

    @Override
    public void apply(Request request) {
        view.showShop();
    }
}

class StartGame extends Command {
    StartGame() {
        super(CommandRegex.START_GAME);
    }

    @Override
    public void apply(Request request) {
        String deckName = matcher.group(1).trim();
        int mode = Integer.parseInt(matcher.group(2).trim());
        if (Account.getLoginAccount().getCollection().checkDeckValidation(deckName)) {
            if (mode == 3) {
                int flags = Integer.parseInt(matcher.group(3).trim());
                FlagsBattle battle = new FlagsBattle(Account.getLoginAccount().getCollection().findDeck(deckName).duplicate(),
                        Account.getLoginAccount().getMainDeck().duplicate(), Account.getLoginAccount(), flags, 1000);
                GameControl gameControl = new GameControl();
                gameControl.main(battle);
            } else if (mode == 2) {
                OneFlagBattle battle = new OneFlagBattle(Account.getLoginAccount().getCollection().findDeck(deckName).duplicate(),
                        Account.getLoginAccount().getMainDeck().duplicate(), Account.getLoginAccount(), 1000);
                GameControl gameControl = new GameControl();
                gameControl.main(battle);
            } else {
                HeroBattle battle = new HeroBattle(Account.getLoginAccount().getCollection().findDeck(deckName).duplicate(),
                        Account.getLoginAccount().getMainDeck().duplicate(), Account.getLoginAccount(), 1000);
                GameControl gameControl = new GameControl();
                gameControl.main(battle);
            }
        } else
            request.setError(ErrorType.INVALID_DECK);

    }
}

class SelectUser extends Command {
    SelectUser() {
        super(CommandRegex.SELECT_USER);
    }

    @Override
    public void apply(Request request) {

        String userName = matcher.group(1).trim();
        request.validateSecondPlayer(userName);

    }
}

class StartMultiPlayerGame extends Command {
    StartMultiPlayerGame() {
        super(CommandRegex.START_MULTIPLAYER_GAME);
    }

    @Override
    public void apply(Request request) {
        return;
    }
}

class GameInfo extends Command {
    GameInfo() {
        super(CommandRegex.GAME_INFO);
    }

    @Override
    public void apply(Request request) {
        view.showGameInfo(request.getBattle());
        request.getBattle().showDetailedInfo();
    }
}

class ShowMyMinions extends Command {
    ShowMyMinions() {
        super(CommandRegex.SHOW_MY_MINIONS);
    }

    @Override
    public void apply(Request request) {
        view.showMinions(request.getBattle(), false);

    }

}

class ShowOppMinions extends Command {
    ShowOppMinions() {
        super(CommandRegex.SHOW_OPP_MINIONS);
    }

    @Override
    public void apply(Request request) {
        view.showMinions(request.getBattle(), true);
    }
}

class EndTurn extends Command {
    EndTurn() {
        super(CommandRegex.END_TURN);
    }

    @Override
    public void apply(Request request) {
        int counterOfFlagFirstPlayer = 0;

        int counterOfFlagSecondPlayer = 0;
        for (int i = 0; i < 5; i++) {
            for (Cell cell : request.getBattle().getMap().get(i)) {
                for (int j = 0; j < cell.getCellEffect().size(); j++) {
                    if (cell.getCellEffect().get(j).getTurnCounter() == 0) {
                        cell.getCellEffect().remove(j);
                        j--;
                    } else {
                        cell.getCellEffect().get(j).castBuff();
                        cell.getCellEffect().get(j).decrementTurnCounter(1);
                    }
                }
                if (cell.getHero() != null) {
                    if (request.getBattle().getType().equals("OneFlagBattle")) {
                        if (cell.getHero().getNumberOfFlag() > 0) {
                            if (cell.getHero().getCardId().toLowerCase().contains(request.getBattle().getFirstPlayer().getUserName().toLowerCase())) {
                                request.getBattle().incrementFirstPlayerFlagCarryTurnCounter();
                            } else
                                request.getBattle().incrementSecondPlayerFlagCarryTurnCounter();
                        }
                        if (request.getBattle().getFirstPlayerFlagCarryTurnCounter() == 8) {
                            view.endGame(request.getBattle(), true);
                        } else if (request.getBattle().getSecondPlayerFlagCarryTurnCounter() == 8) {
                            view.endGame(request.getBattle(), false);
                        }
                    } else if (request.getBattle().getType().equals("FlagsBattle")) {
                        if (cell.getHero().getCardId().toLowerCase().contains(request.getBattle().getFirstPlayer().getUserName().toLowerCase())) {
                            counterOfFlagFirstPlayer += cell.getHero().getNumberOfFlag();
                            if (counterOfFlagFirstPlayer >= ((FlagsBattle) request.getBattle()).getFlags() / 2) {
                                view.endGame(request.getBattle(), true);
                            }

                        } else {
                            counterOfFlagSecondPlayer += cell.getHero().getNumberOfFlag();
                            if (counterOfFlagSecondPlayer >= ((FlagsBattle) request.getBattle()).getFlags() / 2) {
                                view.endGame(request.getBattle(), false);
                            }
                        }
                    }
                    for (int j = 0; j < cell.getHero().getOwnBuffs().size(); j++) {
                        if (cell.getHero().getOwnBuffs().get(j).getTurnCounter() == 0) {
                            cell.getHero().getOwnBuffs().get(j).dispel(cell.getHero());
                            cell.getHero().getOwnBuffs().remove(j);
                            j--;
                        } else {
                            cell.getHero().getOwnBuffs().get(j).castBuff();
                            cell.getHero().getOwnBuffs().get(j).decrementTurnCounter(1);
                        }
                    }
                    cell.getHero().setTimeNeededToCool(cell.getHero().getTimeNeededToCool() - 1);
                    cell.getHero().setCanAttack(true);
                    cell.getHero().setRemainedMoves(2);
                } else if (cell.getMinion() != null) {
                    if (request.getBattle().getType().equals("OneFlagBattle")) {
                        if (cell.getMinion().getNumberOfFlag() > 0) {
                            if (cell.getMinion().getCardId().toLowerCase().contains(request.getBattle().getFirstPlayer().getUserName().toLowerCase())) {
                                request.getBattle().incrementFirstPlayerFlagCarryTurnCounter();
                            } else if (cell.getMinion().getCardId().contains(request.getBattle().getSecondPlayer().getUserName()))
                            {
                                request.getBattle().incrementSecondPlayerFlagCarryTurnCounter();
                            }
                        }
                        if (request.getBattle().getFirstPlayerFlagCarryTurnCounter() == 6) {
                            view.endGame(request.getBattle(), true);
                        } else if (request.getBattle().getSecondPlayerFlagCarryTurnCounter() == 6) {
                            view.endGame(request.getBattle(), false);
                        }
                    } else if (request.getBattle().getType().equals("FlagsBattle")) {
                        if (cell.getMinion().getCardId().toLowerCase().contains(request.getBattle().getFirstPlayer().getUserName().toLowerCase())) {
                            counterOfFlagFirstPlayer += cell.getMinion().getNumberOfFlag();
                            if (counterOfFlagFirstPlayer >= ((FlagsBattle) request.getBattle()).getFlags() / 2) {
                                view.endGame(request.getBattle(), true);
                            }

                        } else {
                            counterOfFlagSecondPlayer += cell.getMinion().getNumberOfFlag();
                            if (counterOfFlagSecondPlayer >= ((FlagsBattle) request.getBattle()).getFlags() / 2) {
                                view.endGame(request.getBattle(), false);
                            }
                        }
                    }
                    for (int j = 0; j < cell.getMinion().getOwnBuffs().size(); j++) {
                        if (cell.getMinion().getOwnBuffs().get(j).getTurnCounter() == 0) {
                            cell.getMinion().getOwnBuffs().get(j).dispel(cell.getMinion());
                            cell.getMinion().getOwnBuffs().remove(j);
                            j--;
                        } else {
                            cell.getMinion().getOwnBuffs().get(j).castBuff();
                            cell.getMinion().getOwnBuffs().get(j).decrementTurnCounter(1);
                        }
                    }
                    cell.getMinion().setCanAttack(true);
                    cell.getMinion().setRemainedMoves(2);

                }
            }
        }
        request.getBattle().setSelectedCard(null);
        request.getBattle().setSelectedCollectible(null);

        request.getBattle().increamentTurn();
    }
}

class ShowCardInfo extends Command {
    ShowCardInfo() {
        super(CommandRegex.SHOW_CARD_INFO);
    }

    @Override
    public void apply(Request request) {
        String cardId = matcher.group(1).trim();
        Card card = request.isValidCardId(cardId, true);
        card = request.isValidCardId(cardId, false);
        if (card != null) {
            if (card.getType().equals("Minion"))
                view.printMinionInfoInGame((Minion) card);
            else if (card.getType().equals("Hero"))
                view.printHeroInfoInGame((Hero) card);
            else
                view.printSpellInfoInGame((Spell) card);
        } else {
            request.setError(ErrorType.CARD_NOT_FOUND_IN_GAME);
        }
    }
}

class SelectSoldier extends Command {
    SelectSoldier() {
        super(CommandRegex.SELECT_CARD_ID);
    }

    @Override
    public void apply(Request request) {
        String cardId = matcher.group(1).trim();
        Card card;
        if (request.getBattle().getTurn() % 2 == 1)
            card = request.isValidCardId(cardId, true);
        else {
            card = request.isValidCardId(cardId, false);
        }
        if (card != null) {
            request.getBattle().setSelectedCard(card);
            if (card.getType().equals("Spell"))
                request.setError(ErrorType.SELECT_HERO_OR_MINION);
        } else {
            request.setError(ErrorType.CARD_NOT_FOUND_IN_GAME);
        }
    }
}

class MoveSelectedSoldier extends Command {
    MoveSelectedSoldier() {
        super(CommandRegex.MOVE_CARD);
    }

    @Override
    public void apply(Request request) {
        int xPos = Integer.parseInt(matcher.group(1).trim());
        int yPos = Integer.parseInt(matcher.group(2).trim());
        if (request.getBattle().getSelectedCard() == null) {
            request.setError(ErrorType.NO_CARD_SELECTED);
            return;
        }
        if (request.getBattle().getSelectedCard().getType().equals("Minion") && ((Minion) request.getBattle().getSelectedCard()).isStunning()) {
            request.setError(ErrorType.CARD_IS_STUNNED);
            return;
        }
        if (request.getBattle().getSelectedCard().getType().equals("Hero") && ((Hero) request.getBattle().getSelectedCard()).isStunning()) {
            request.setError(ErrorType.CARD_IS_STUNNED);
            return;
        }
        Cell cell = request.getBattle().getMap().get(0).get(0).getCellOfCard(request.getBattle().getSelectedCard(),
                request.getBattle());//actually is static
        Cell cell2 = request.getBattle().getMap().get(xPos - 1).get(yPos - 1);
        if( cell.manhataniDistance(xPos, yPos) > request.getBattle().getSelectedCard().getRemainedMoves())
            request.setError(ErrorType.TOO_EXHAUSTED);
        if (cell2.getHero() == null && cell2.getMinion() == null ) {//todo checked there is a valid patch to des
            System.out.println(request.getBattle().getSelectedCard().getCardId() + " moved to" + " (" + xPos + "," + yPos + ")");
            cell.moveCardPos(xPos, yPos, request.getBattle());
            request.getBattle().getSelectedCard().setRemainedMoves(request.getBattle().getSelectedCard().getRemainedMoves()
                    - cell.manhataniDistance(xPos, yPos));

            if (cell2.getNumberOfFlag() > 0) {
                if (request.getBattle().getSelectedCard().getType().equals("Minion"))
                    ((Minion) request.getBattle().getSelectedCard()).setNumberOfFlag(((Minion) request.getBattle().getSelectedCard()).getNumberOfFlag() + request.getBattle().getMap().get(xPos - 1).get(yPos - 1).getNumberOfFlag());
                else
                    ((Hero) request.getBattle().getSelectedCard()).setNumberOfFlag(((Hero) request.getBattle().getSelectedCard()).getNumberOfFlag() + request.getBattle().getMap().get(xPos - 1).get(yPos - 1).getNumberOfFlag());

                cell2.setFlag(0);
            }
            if (request.getBattle().getMap().get(xPos - 1).get(yPos - 1).getCollectibleItem() != null)
                request.addCollectible(xPos, yPos);
        } else
            request.setError(ErrorType.INVALID_TARGET);
    }
}

class ShowHand extends Command {
    ShowHand() {
        super(CommandRegex.SHOW_HAND);
    }

    @Override
    public void apply(Request request) {
        ArrayList<Card> cards;
        Card card;
        if (request.getBattle().getTurn() % 2 == 1) {
            System.out.println("Hand of Player " + request.getBattle().getFirstPlayer().getUserName() + " :");
            cards = request.getBattle().getFirstPlayerHand().getCards();
            card = request.getBattle().getFirstPlayerHand().getNextCardInHand();

        } else {
            System.out.println("Hand of Player " + request.getBattle().getSecondPlayer().getUserName());
            cards = request.getBattle().getSecondPlayerHand().getCards();
            card = request.getBattle().getSecondPlayerHand().getNextCardInHand();
        }
        int i = 1;
        for (Card card2 : cards) {
            System.out.println(i + " : " + card2.showDetails());
            i++;
        }
        i = 1;
        System.out.println("Card will be added next turn : ");
        System.out.println(i + " : " + card.showDetails());

    }
}

class InsertCard extends Command {
    InsertCard() {
        super(CommandRegex.INSERT_CARD);
    }

    @Override
    public void apply(Request request) {
        String cardName = matcher.group(1).trim();
        int xPos = Integer.parseInt(matcher.group(2).trim());
        int yPos = Integer.parseInt(matcher.group(3).trim());
        Account account;
        if (request.getBattle().getTurn() % 2 == 1)
            account = request.getBattle().getFirstPlayer();
        else
            account = request.getBattle().getSecondPlayer();
        ArrayList<Card> cards;
        boolean flag = false;
        if (request.getBattle().getTurn() % 2 == 1)
            cards = request.getBattle().getFirstPlayerHand().getCards();
        else
            cards = request.getBattle().getSecondPlayerHand().getCards();
        for (Card card1 : cards) {
            if (cardName.equals(card1.getName())) {
                flag = true;
                int cost = 0;
                if (card1.getType().equals("Spell")) {
                    Spell spell = (Spell) card1;
                    cost = spell.getCostToUse();
                }
                if (card1.getType().equals("Minion")) {
                    Minion minion = (Minion) card1;
                    cost = minion.getCostToUse();
                }
                if (cost > account.getMana()) {
                    request.setError(ErrorType.DONT_HAVE_ENOUGH_MANA);
                    return;
                } else {
                    if (card1.getType().equals("Minion")) {
                        if (request.getBattle().getMap().get(xPos - 1).get(yPos - 1).getMinion() == null &&
                                request.getBattle().getMap().get(xPos - 1).get(yPos - 1).getHero() == null) {
                            ArrayList<Cell> targetCells = new ArrayList<>();
                            if (xPos - 2 >= 0)
                                targetCells.add(request.getBattle().getMap().get(xPos-2).get(yPos-1));
                            if (xPos < 5)
                                targetCells.add(request.getBattle().getMap().get(xPos).get(yPos-1));
                            if ( yPos - 2 >= 0)
                                targetCells.add(request.getBattle().getMap().get(xPos-1).get(yPos-2));
                            if (yPos < 9) {
                                targetCells.add(request.getBattle().getMap().get(xPos - 1).get(yPos));
                            }if (xPos - 2 >= 0 && yPos - 2 >= 0)
                                targetCells.add(request.getBattle().getMap().get(xPos-2).get(yPos-2));
                            if (xPos < 5 && yPos - 2 >= 0)
                                targetCells.add(request.getBattle().getMap().get(xPos).get(yPos-2));
                            if (xPos - 2 >= 0 && yPos < 9)
                                targetCells.add(request.getBattle().getMap().get(xPos-2).get(yPos));
                            if (xPos < 5 && yPos < 9)
                                targetCells.add(request.getBattle().getMap().get(xPos).get(yPos));
                            boolean adjacency = false;
                            for (Cell cell : targetCells) {
                                if (cell.getMinion() != null && cell.getMinion().getCardId().toLowerCase().contains(account.getUserName().toLowerCase())) {
                                    adjacency = true;
                                    break;
                                }
                                if (cell.getHero() != null && cell.getHero().getCardId().toLowerCase().contains(account.getUserName().toLowerCase())) {
                                    adjacency = true;
                                    break;
                                }
                            }
                            if (!adjacency) {
                                request.setError(ErrorType.INVALID_TARGET);
                                return;
                            }
                            if (request.getBattle().getMap().get(xPos - 1).get(yPos - 1).getNumberOfFlag() > 0) {
                                ((Minion) card1).setNumberOfFlag(((Minion) card1).getNumberOfFlag() + request.getBattle().getMap().get(xPos - 1).get(yPos - 1).getNumberOfFlag());
                                request.getBattle().getMap().get(xPos - 1).get(yPos - 1).setFlag(0);
                            }

                            account.setMana(account.getMana() - cost);
                            ((Minion) card1).moveToGame(request.getBattle(), xPos, yPos);
                            System.out.println(card1.getName() + " with " + card1.getCardId() + " inserted to " + " (" + xPos + "," + yPos + ")");
                            if (request.getBattle().getMap().get(xPos - 1).get(yPos - 1).getCollectibleItem() != null) {
                                request.addCollectible(xPos, yPos);
                            }

                            if (request.getBattle().getTurn() % 2 == 1 && request.getBattle().getFirstPlayerDeck().getUsableItem() != null)
                                request.getBattle().getFirstPlayerDeck().getUsableItem().applyEffect(request.getBattle(), null, request.getBattle().getFirstPlayer(), 0);
                            else if (request.getBattle().getTurn() % 2 == 0 && request.getBattle().getSecondPlayerDeck().getUsableItem() != null)
                                request.getBattle().getSecondPlayerDeck().getUsableItem().applyEffect(request.getBattle(), null, request.getBattle().getSecondPlayer(), 0);

                            cards.remove(card1);
                        } else
                        {
                            request.setError(ErrorType.INVALID_TARGET);
                        }
                    } else {
                        ((Spell) card1).castSpell(request.getBattle(), request.getBattle().getMap().get(xPos - 1).get(yPos - 1), account, request);
                        account.setMana(account.getMana() - cost);

                        if (request.getError() == null) {
                            System.out.println(card1.getName() + " inserted to " + " (" + xPos + "," + yPos + ")");
                            cards.remove(card1);
                        }

                    }
                }
                break;
            }

        }
        if (!flag)
            request.setError(ErrorType.INVALID_CARD_NAME);
    }
}

class Attack extends Command {
    Attack() {
        super(CommandRegex.ATTACK);
    }

    @Override
    public void apply(Request request) {
        String oppCardId = matcher.group(1).trim();
        Card card;
        if (request.getBattle().getSelectedCard() == null) {
            request.setError(ErrorType.NO_CARD_SELECTED);
            return;
        } else if (!request.getBattle().getSelectedCard().getCanAttack()) {
            request.setError(ErrorType.TOO_EXHAUSTED);
            return;
        }
        if (request.getBattle().getTurn() % 2 == 1)
            card = request.getBattle().getCard(oppCardId, 1);
        else
            card = request.getBattle().getCard(oppCardId, 0);
        if (card != null) {
            request.getBattle().getSelectedCard().attack(request.getBattle(), card, request);
        } else {
            request.setError(ErrorType.INVALID_TARGET);
            return;
        }
    }
}

class ComboAttack extends Command {
    ComboAttack() {
        super(CommandRegex.ATTACK_COMBO);
    }

    @Override
    public void apply(Request request) {
        int x = matcher.groupCount();
        if (request.getBattle().getSelectedCard() == null) {
            request.setError(ErrorType.NO_CARD_SELECTED);
            return;
        }
        if (request.getBattle().getSelectedCard().getType().equals("Hero")) {
            request.setError(ErrorType.CANNOT_COMBO_ATTACK);
            return;
        } else if (((Minion) request.getBattle().getSelectedCard()).getTimeOfActivationOfSpecialPower() != 2) {
            request.setError(ErrorType.CANNOT_COMBO_ATTACK);
            return;
        }
        String cardId;
        ArrayList<Minion> cards = new ArrayList<>();
        cards.add((Minion) request.getBattle().getSelectedCard());
        Card oppCard = null;
        for (int i = 1; i < x; i++) {
            cardId = matcher.group(i).trim();
            Card card = null;
            if (i == 1)
                oppCard = request.getBattle().getCard(cardId, (request.getBattle().getTurn()) % 2);
            else
                card = request.getBattle().getCard(cardId, (request.getBattle().getTurn() - 1) % 2);
            if (oppCard == null) {
                request.setError(ErrorType.INVALID_TARGET);
                return;
            }
            if (card == null) {
                request.setError(ErrorType.CARD_NOT_FOUND_IN_GAME);
                return;
            }
            if (i != 1) {
                if (card.getType().equals("Hero") || ((Minion) card).getTimeOfActivationOfSpecialPower() != 2) {
                    request.setError(ErrorType.CANNOT_COMBO_ATTACK);
                    return;
                }
                cards.add((Minion) card);
            }
        }
        request.getBattle().ComboAttack(oppCard, cards, request);

    }
}

class UseSpecialPower extends Command {
    UseSpecialPower() {
        super(CommandRegex.SPECIAL_POWER);
    }

    @Override
    public void apply(Request request) {
        if (request.getBattle().getSelectedCard() == null) {
            request.setError(ErrorType.NO_CARD_SELECTED);
            return;
        }
        if (!request.getBattle().getSelectedCard().getType().equals("Hero")) {
            request.setError(ErrorType.ONLY_HEROES_HAVE_SPECIAL_POWER);
            return;
        }
        int xPos = Integer.parseInt(matcher.group(1).trim());
        int yPos = Integer.parseInt(matcher.group(2).trim());
        if (((Hero) request.getBattle().getSelectedCard()).getTimeNeededToCool() > 0) {
            request.setError(ErrorType.HERO_IS_IN_COOLDOWN);
            return;
        }

        if (request.getBattle().getTurn() % 2 == 1)
            ((Hero) request.getBattle().getSelectedCard()).castSpecialPower(request.getBattle()
                    , request.getBattle().getMap().get(xPos - 1).get(yPos - 1), request.getBattle().getFirstPlayer(), request);
        else
            ((Hero) request.getBattle().getSelectedCard()).castSpecialPower(request.getBattle()
                    , request.getBattle().getMap().get(xPos - 1).get(yPos - 1), request.getBattle().getSecondPlayer(), request);

        if (request.getError() == null) {
            ((Hero) request.getBattle().getSelectedCard()).setCoolDownTime(((Hero) request.getBattle().getSelectedCard())
                    .getTimeNeededToCool());
        }


    }
}

class ShowNextCard extends Command {
    ShowNextCard() {
        super(CommandRegex.SHOW_NEXT_CARD);
    }

    @Override
    public void apply(Request request) {
        if (request.getBattle().getTurn() % 2 == 1)
            System.out.println(request.getBattle().getFirstPlayerHand().getNextCardInHand().showDetails());
        else
            System.out.println(request.getBattle().getSecondPlayerHand().getNextCardInHand().showDetails());
    }
}

class EnterGraveYard extends Command {
    EnterGraveYard() {
        super(CommandRegex.ENTER_GRAVE_YARD);
    }

    @Override
    public void apply(Request request) {
        if (request.getBattle().getTurn() % 2 == 1) {
            GraveYard graveYard = new GraveYard();
            graveYard.main(request.getBattle());
        } else
            System.out.println(request.getBattle().getSecondPlayerHand().getNextCardInHand().showDetails());
    }
}

class ShowCardInfoInGrave extends Command {
    ShowCardInfoInGrave() {
        super(CommandRegex.SHOW_CARD_INFO);
    }

    @Override
    public void apply(Request request) {
        String cardId = matcher.group(1).trim();
        if (request.getBattle().getTurn() % 2 == 1) {
            for (Card card : request.getBattle().getFirstGrave()) {
                if (card.getCardId().equals(cardId)) {
                    System.out.println(card.showDetails());
                    return;
                }
            }
        } else {
            for (Card card : request.getBattle().getSecondGrave()) {
                if (card.getCardId().equals(cardId)) {
                    System.out.println(card.showDetails());
                    return;
                }
            }
        }
        request.setError(ErrorType.CARD_NOT_FOUND_IN_GAME);
    }
}

class ShowCardsInGrave extends Command {
    ShowCardsInGrave() {
        super(CommandRegex.SHOW_CARDS);
    }

    @Override
    public void apply(Request request) {
        if (request.getBattle().getTurn() % 2 == 1) {
            for (Card card : request.getBattle().getFirstGrave()) {
                System.out.println(card.showDetails());
            }
        } else {
            for (Card card : request.getBattle().getSecondGrave()) {
                System.out.println(card.showDetails());
            }
        }

    }
}

class ShowCollectibles extends Command {
    ShowCollectibles() {
        super(CommandRegex.SHOW_COLLECTIBLES);
    }

    @Override
    public void apply(Request request) {
        ArrayList<CollectibleItem> collectibleItems;
        if (request.getBattle().getTurn() % 2 == 1)
            collectibleItems = request.getBattle().getFirstPlayerCollectibleItem();
        else
            collectibleItems = request.getBattle().getSecondPlayerCollectibleItem();
        int index = 1;
        for (CollectibleItem collectibleItem : collectibleItems) {
            System.out.println(index + ": ItemId : "+collectibleItem.getCardId()+" " + collectibleItem.showDetails());
            index++;
        }

    }
}

class SelectCollectible extends Command {
    SelectCollectible() {
        super(CommandRegex.SELECT_COLLECTIBLE);
    }

    @Override
    public void apply(Request request) {
        String collectibleId = matcher.group(1).trim();
        ArrayList<CollectibleItem> collectibleItems;
        if (request.getBattle().getTurn() % 2 == 1)
            collectibleItems = request.getBattle().getFirstPlayerCollectibleItem();
        else
            collectibleItems = request.getBattle().getSecondPlayerCollectibleItem();
        for (CollectibleItem collectibleItem : collectibleItems) {
            if (collectibleId.equals(collectibleItem.getCardId())) {
                request.getBattle().setSelectedCollectible(collectibleItem);
                return;
            }
        }
        request.setError(ErrorType.INVALID_COLLECTIBLE_ID);
    }
}

class ShowInfoCollectible extends Command {
    ShowInfoCollectible() {
        super(CommandRegex.SHOW_INFO);
    }

    @Override
    public void apply(Request request) {
        System.out.println(request.getBattle().getSelectedCollectible().showDetails());
    }
}

class UseCollectible extends Command {
    UseCollectible() {
        super(CommandRegex.USE_COLLECTIBLE);
    }

    @Override
    public void apply(Request request) {
        int xPos = Integer.parseInt(matcher.group(1).trim());
        int yPos = Integer.parseInt(matcher.group(2).trim());
        if (request.getBattle().getTurn() % 2 == 1)
            request.getBattle().getSelectedCollectible().applyEffect(request.getBattle(), request.getBattle().getMap().get(xPos - 1).get(yPos - 1), request.getBattle().getFirstPlayer());
        else
            request.getBattle().getSelectedCollectible().applyEffect(request.getBattle(), request.getBattle().getMap().get(xPos - 1).get(yPos - 1), request.getBattle().getSecondPlayer());

    }
}
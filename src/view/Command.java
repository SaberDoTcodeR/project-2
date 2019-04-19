package view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import control.*;
import model.*;

public abstract class Command {
    static View view = View.getInstance();
    Pattern pattern;
    Matcher matcher;

    public Command(CommandRegex command) {
        pattern = Pattern.compile(command.getRegex());
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
        String deckName = matcher.group(3).trim();
        if (Account.getLoginAccount().getCollection().findDeck(deckName) == null) {
            request.setError(ErrorType.DECK_EXISTENCE);
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
                request.setError(ErrorType.CARD_EXISTENCE_INDECK);
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
        String deckName = matcher.group(3).trim();
        if(Account.getLoginAccount().getCollection().findDeck(deckName)==null)
        {
            if(Account.getLoginAccount().getCollection().findDeck(deckName).hasThisCard(id))
            {
                Account.getLoginAccount().getCollection().removeFromDeck(id,deckName);
            }
            else {
                request.setError(ErrorType.CARD_EXISTENCE_INDECK);
            }
        }else {
            request.setError(ErrorType.DECK_EXISTENCE);
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
class ExitFromSubMenu extends Command {

    ExitFromSubMenu() {
        super(CommandRegex.EXIT);
    }

    @Override
    public void apply(Request request) {

        MainMenuControl mainMenuControl =new MainMenuControl();
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
        AccountControl accountControl=new AccountControl();
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
        if (!request.repetitiousUser(userName)){
            System.out.println("Set Your PassWord "+userName+" :");
            String pass=Request.scanner.nextLine();
            Account.setLoginAccount(new Account(userName,pass));
            MainMenuControl mainMenuControl=new MainMenuControl();
            mainMenuControl.main();
        }
        else {
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
        if (request.existThisUser(userName)){
            System.out.println("Enter Your PassWord :");
            String pass=Request.scanner.nextLine();
            request.authorize(userName,pass);

        }
    }
}class ShowLeaderBoard extends Command {

    ShowLeaderBoard() {
        super(CommandRegex.SHOW_LEADERBOARD);
    }

    @Override
    public void apply(Request request) {
        Account.showLeaderboard();
    }
}class Save extends Command {

    Save() {
        super(CommandRegex.SAVE);
    }

    @Override
    public void apply(Request request) {
        Account.setLoginAccount(null);
        AccountControl accountControl = new AccountControl();
        accountControl.main();
    }
}class LogOut extends Command {

    LogOut() {
        super(CommandRegex.LOGOUT);
    }

    @Override
    public void apply(Request request) {
        if(Account.getLoginAccount()==null)
        {
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
        if (shop.hasThisCard(objectName)){
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
        Search search=new Search();
        search.apply(request);
    }

}

class Buy extends Command {
    Buy() {
        super(CommandRegex.BUY);
    }

    @Override
    public void apply(Request request) {
        String cardName = matcher.group(1).trim();
        Shop shop=new Shop();
        if(shop.hasThisCard(cardName)){
            if(shop.costOfCard(cardName)>Account.getLoginAccount().getMoney()){
                request.setError(ErrorType.DONT_HAVE_ENOUGH_MONEY);
            }else {
                if(Account.getLoginAccount().getCollection().getItems().size()<3)
                {
                    request.setError(ErrorType.CARD_SUCCESSFULLY_BUYED);
                    Account.getLoginAccount().decreament(shop.costOfCard(cardName));
                    Account.getLoginAccount().getCollection().addToCollection(cardName);
                }else {
                    request.setError(ErrorType.THREE_ITEMS_ALREADY_OCCUPIED);
                }
            }
        }else {
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
        if (Account.getLoginAccount().getCollection().hasThisCard(objectId)){
            Account.getLoginAccount().getCollection().removeCardFromCollection(objectId);
            int cost = Account.getLoginAccount().getCollection().costOfCard(objectId);
            Account.getLoginAccount().incrementMoney(cost);
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
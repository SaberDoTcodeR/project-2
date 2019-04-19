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

    }
}

class Search extends Command {

    Search() {
        super(CommandRegex.SEARCH);
    }

    @Override
    public void apply(Request request) {

    }
}

class CreateDeck extends Command {

    CreateDeck() {
        super(CommandRegex.CREATE_DECK);
    }

    @Override
    public void apply(Request request) {

    }
}

class DeleteDeck extends Command {

    DeleteDeck() {
        super(CommandRegex.DELETE_DECK);
    }

    @Override
    public void apply(Request request) {

    }
}

class Add extends Command {

    Add() {
        super(CommandRegex.ADD);
    }

    @Override
    public void apply(Request request) {

    }
}

class Remove extends Command {

    Remove() {
        super(CommandRegex.REMOVE);
    }

    @Override
    public void apply(Request request) {

    }
}

class ValidateDeck extends Command {

    ValidateDeck() {
        super(CommandRegex.VALIDATE_DECK);
    }

    @Override
    public void apply(Request request) {
        String deckName = matcher.group(1).trim();
        request.validateDeck(deckName);

    }
}

class SelectDeck extends Command {

    SelectDeck() {
        super(CommandRegex.SELECT_DECK);
    }

    @Override
    public void apply(Request request) {

    }
}

class ShowDeck extends Command {

    ShowDeck() {
        super(CommandRegex.SHOW_DECK);
    }

    @Override
    public void apply(Request request) {

    }
}

class ShowAllDecks extends Command {

    ShowAllDecks() {
        super(CommandRegex.SHOW_ALL_DECKS);
    }

    @Override
    public void apply(Request request) {

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
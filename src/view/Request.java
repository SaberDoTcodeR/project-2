package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.*;
import control.*;
import model.Battles.Battle;
import model.Cards.Card;
import model.Menus.Account;

public class Request {
    public static Scanner scanner = new Scanner(System.in);
    private static ArrayList<ArrayList<Command>> commands = new ArrayList<>();
    private ErrorType error = null;
    private String commandLine;
    private Battle battle;
    public void getNewCommand() {
        this.commandLine = scanner.nextLine().toLowerCase().trim();

    }

    static {
        setMatchedCommand();
    }

    public Battle getBattle() {
        return battle;
    }

    public void setBattle(Battle battle) {
        this.battle = battle;
    }

    private static void setMatchedCommand() {/////0 for main menu   1 for battle    2 for collection    3 for shop 4 Account 5 start Game 6 multiplayer
        commands.add(new ArrayList<>());
        commands.add(new ArrayList<>());
        commands.add(new ArrayList<>());
        commands.add(new ArrayList<>());
        commands.add(new ArrayList<>());
        commands.add(new ArrayList<>());
        commands.add(new ArrayList<>());
        commands.add(new ArrayList<>());

        commands.get(0).add(new EnterBattle());
        commands.get(0).add(new EnterCollection());
        commands.get(0).add(new EnterShop());
        commands.get(0).add(new LogOut());
        commands.get(0).add(new ExitFromMainMenu());
        commands.get(0).add(new Help());

        commands.get(1).add(new GameInfo());
        commands.get(1).add(new ShowMyMinions());
        commands.get(1).add(new ShowOppMinoins());
        commands.get(1).add(new EndTurn());
        commands.get(1).add(new ShowCardInfo());
        /*commands.get(1).add(new MoveSelectedSoldier());
        commands.get(1).add(new Attack());
        commands.get(1).add(new AttackCombo());
        commands.get(1).add(new SelectSoldier());*/

        commands.get(2).add(new Show());
        commands.get(2).add(new ShowDeck());
        commands.get(2).add(new ShowAllDecks());
        commands.get(2).add(new Search());
        commands.get(2).add(new SelectDeck());
        commands.get(2).add(new CreateDeck());
        commands.get(2).add(new DeleteDeck());
        commands.get(2).add(new Add());
        commands.get(2).add(new Remove());
        commands.get(2).add(new ValidateDeck());
        commands.get(2).add(new ExitFromSubMenu());
        commands.get(2).add(new Help());


        commands.get(3).add(new Buy());
        commands.get(3).add(new Sell());
        commands.get(3).add(new ShowShop());
        commands.get(3).add(new SearchCollection());
        commands.get(3).add(new SearchOfShop());
        commands.get(3).add(new ShowCollection());
        commands.get(3).add(new Help());
        commands.get(3).add(new ExitFromSubMenu());


        commands.get(4).add(new LogOut());
        commands.get(4).add(new Login());
        commands.get(4).add(new Save());
        commands.get(4).add(new CreateAccount());
        commands.get(4).add(new ShowLeaderBoard());
        commands.get(4).add(new Help());
        commands.get(4).add(new Exit());

        commands.get(5).add(new StartGame());


        commands.get(6).add(new SelectUser());

        commands.get(7).add(new StartMultiPlayerGame());
    }

    public Command getMatchedCommand(int i) {
        for (Command command : commands.get(i)) {
            command.matcher = command.pattern.matcher(commandLine);
            if (command.matcher.matches()) {
                return command;
            }
        }
        return null;
    }

    public boolean mainDeckValidation() {
        if (Account.getLoginAccount().getMainDeck() == null) {
            this.setError(ErrorType.INVALID_DECK);
            return false;
        }
        if (!Account.getLoginAccount().getMainDeck().isValid()) {
            this.setError(ErrorType.INVALID_DECK);
            return false;
        } else
            return true;

    }

    public void validateDeck(String deckName) {
        if (!Account.getLoginAccount().getCollection().checkDeckValidation(deckName))
            this.setError(ErrorType.INVALID_DECK);
        else
            View.getInstance().printDeckValidation(deckName);
    }


    public boolean repetitiousUser(String userName) {
        for (Account account : Account.getAllUser()) {
            if (account.getUserName().equals(userName)) {
                this.setError(ErrorType.USER_ALREADY_CREATED);
                return true;
            }
        }
        return false;
    }

    public boolean existThisUser(String userName) {
        for (Account account : Account.getAllUser()) {
            if (account.getUserName().equals(userName)) {
                return true;
            }
        }
        this.setError(ErrorType.NO_SUCH_USER_EXIST);
        return false;
    }

    public void authorize(String userName, String passWord) {
        for (Account account : Account.getAllUser()) {
            if (account.getUserName().equals(userName)) {
                if (account.getPassWord().equals(passWord)) {
                    Account.setLoginAccount(account);
                    MainMenuControl mainMenuControl = new MainMenuControl();
                    mainMenuControl.main();
                }
                this.setError(ErrorType.WRONG_PASSWORD);
                return;
            }
        }
    }

    public void setError(ErrorType error) {
        this.error = error;
    }

    public ErrorType getError() {
        return error;
    }

    public String getCommand() {
        return commandLine;
    }

    public void setCommand(String command) {
        this.commandLine = command;
    }

    public void validateSecondPlayer(String userName) {
        if (Account.getLoginAccount().getUserName().equals(userName)) {
            this.setError(ErrorType.SECOND_PLAYER_NOT_CHOSEN_RIGHT);
            return;
        }
        for (Account account : Account.getAllUser()
        ) {
            if (account.getUserName().equals(userName)) {
                if (account.getMainDeck().isValid()) {
                    return;
                } else {
                    this.setError(ErrorType.SECOND_PLAYER_DECK_NOT_VALID);
                    return;
                }
            }
        }
        this.setError(ErrorType.SECOND_PLAYER_NOT_CHOSEN_RIGHT);

    }
    public Card isValidCardId(String cardId){
        for (Card card: this.battle.getFirstPlayerInGameCards() ) {
             if(card.getCardId().equals(cardId)){
                 return card;
             }
        }
        for (Card card:this.battle.getSecondPlayerInGameCards()){
            if(card.getCardId().equals(cardId)){
                return card;
            }
        }
        return null;
    }
}

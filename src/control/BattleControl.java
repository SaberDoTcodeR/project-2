package control;

import model.*;

import model.Battles.FlagsBattle;
import model.Battles.HeroBattle;
import model.Battles.OneFlagBattle;
import model.Menus.Account;
import view.*;

public class BattleControl {
    private static View view = View.getInstance();

    public void main() {
        boolean isSingle;
        while (true) {
            view.showSingleOrMultiMenu();
            Request request = new Request();
            request.getNewCommand();
            if (request.getCommand().equals("single player")) {
                isSingle = true;
                break;
            } else if (request.getCommand().equals("multi player")) {
                isSingle = false;
                break;
            } else {
                view.printError(ErrorType.COMMAND);
            }
        }

        while (isSingle) {
            view.showSingleMatchMenu();
            Request request = new Request();
            request.getNewCommand();
            if (request.getCommand().equals("story")) {
                while (true) {
                    view.showModeList();
                    Request request1 = new Request();
                    request1.getNewCommand();
                    if (request1.getCommand().matches("[1-3]")) {
                        if (request1.getCommand().equals("1")) {
                            HeroBattle battle = new HeroBattle(Account.getLoginAccount().getCollection().getStroyModeDeck().get(0).duplicate(),
                                    Account.getLoginAccount().getMainDeck().duplicate(), Account.getLoginAccount(), 500);
                            GameControl gameControl = new GameControl();
                            gameControl.main(battle);
                            //todo after game finished what the hell i suppose to do
                        } else if (request1.getCommand().equals("2")) {
                            OneFlagBattle battle = new OneFlagBattle(Account.getLoginAccount().getCollection().getStroyModeDeck().get(1).duplicate(),
                                    Account.getLoginAccount().getMainDeck().duplicate(), Account.getLoginAccount());
                            GameControl gameControl = new GameControl();
                            gameControl.main(battle);
                            //todo after game finished what the hell i suppose to do
                        } else {
                            FlagsBattle battle = new FlagsBattle(Account.getLoginAccount().getCollection().getStroyModeDeck().get(2).duplicate(),
                                    Account.getLoginAccount().getMainDeck().duplicate(), Account.getLoginAccount(), 11);
                            GameControl gameControl = new GameControl();
                            gameControl.main(battle);
                            //todo after game finished what the hell i suppose to do
                        }
                        break;
                    } else
                        view.printError(ErrorType.COMMAND);
                }
                break;
            } else if (request.getCommand().equals("custom game")) {
                Account.getLoginAccount().getCollection().showAllDecks();
                while (true) {
                    request.getNewCommand();
                    Command command = request.getMatchedCommand(5);
                    if (command != null) {
                        command.apply(request);
                        view.printError(request.getError());
                    } else {
                        view.printError(ErrorType.COMMAND);
                    }
                }
            } else {
                view.printError(ErrorType.COMMAND);
            }
        }
        while (!isSingle) {
            view.showWholePlayers();
            while (true) {
                Request request = new Request();
                request.getNewCommand();
                Command command = request.getMatchedCommand(6);
                if (command != null) {
                    command.apply(request);
                    if (request.getError() == null) {
                        Request request1 = new Request();
                        request1.getNewCommand();
                        Command command1 = request1.getMatchedCommand(7);
                        if (command1 != null) {
                            int mode = Integer.parseInt(command1.getMatcher().group(1).trim());
                            int flags = Integer.parseInt(command1.getMatcher().group(2).trim());
                            String userName = command.getMatcher().group(1);
                            if (mode == 1) {
                                HeroBattle battle = new HeroBattle(Account.getLoginAccount().getAccount(userName).getMainDeck().duplicate(),
                                        Account.getLoginAccount().getMainDeck().duplicate(), Account.getLoginAccount(), Account.getLoginAccount().getAccount(userName),1000);
                                GameControl gameControl = new GameControl();
                                gameControl.main(battle);
                                //todo after game finished what the hell i suppose to do
                            } else if (request1.getCommand().equals("2")) {
                                OneFlagBattle battle = new OneFlagBattle(Account.getLoginAccount().getAccount(userName).getMainDeck().duplicate(),
                                        Account.getLoginAccount().getMainDeck().duplicate(), Account.getLoginAccount(), Account.getLoginAccount().getAccount(userName));
                                GameControl gameControl = new GameControl();
                                gameControl.main(battle);
                                //todo after game finished what the hell i suppose to do
                            } else {
                                FlagsBattle battle = new FlagsBattle(Account.getLoginAccount().getAccount(userName).getMainDeck().duplicate(),
                                        Account.getLoginAccount().getMainDeck().duplicate(), Account.getLoginAccount(), Account.getLoginAccount().getAccount(userName), flags);
                                GameControl gameControl = new GameControl();
                                gameControl.main(battle);
                                //todo after game finished what the hell i suppose to do
                            }
                        } else
                            view.printError(ErrorType.COMMAND);
                    } else
                        view.printError(request.getError());
                } else {
                    view.printError(ErrorType.COMMAND);
                }
            }

        }

    }
}

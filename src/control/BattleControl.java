package control;

import model.*;

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
                        ///create game with that mode
                        break;
                    } else
                        view.printError(ErrorType.COMMAND);
                }
                break;
            } else if (request.getCommand().equals("Custom game")) {
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
                        if(command1!=null){
                            int mode=Integer.parseInt(command1.getMatcher().group(1).trim());
                            int flags=Integer.parseInt(command1.getMatcher().group(2).trim());
                            String userName=command.getMatcher().group(1);
                            //make gameeee
                        }else
                            view.printError(ErrorType.COMMAND);
                    }else
                        view.printError(request.getError());
                } else {
                    view.printError(ErrorType.COMMAND);
                }
            }

        }

    }
}

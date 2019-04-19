package control;

import model.*;

import view.*;

public class BattleControl {
    public static boolean finished = false;
    private static View view = View.getInstance();

    public void main() {
        //view.showBattleMenu();
        while (!finished) {
            Request request = new Request();
            request.getNewCommand();
            Command command = request.getMatchedCommand(1);

            if (command != null&& !command.equals("help")) {
                command.apply(request);
                view.printError(request.getError());
            } else if (command != null && command.equals("help")) {
               //view.showBattleMenu();
            } else {
                view.printError(ErrorType.COMMAND);
            }
        }
    }
}

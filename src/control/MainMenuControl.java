package control;

import model.*;

import view.*;
public class MainMenuControl {
    public static boolean finished = false;
    private static View view = View.getInstance();

    public void main() {
        while (!finished) {
            Request request = new Request();
            request.getNewCommand();
            Command command = request.getMatchedCommand(0);

            if (command != null && !command.equals("help")) {
                command.apply(request);
            } else if (command != null && command.equals("help")) {
                view.showMainMenu;
            } else {
                view.printError(ErrorType.COMMAND);
            }
        }
    }
}

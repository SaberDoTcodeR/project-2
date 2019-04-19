package control;

import model.*;

import view.*;

public class CollectionControl {
    public static boolean finished = false;
    private static View view = View.getInstance();

    public void main() {
        view.showCollectionMenu();
        while (!finished) {
            Request request = new Request();
            request.getNewCommand();
            Command command = request.getMatchedCommand(2);

            if (command != null && !command.equals("help")) {
                command.apply(request);
                view.printError(request.getError());
            } else if (command != null && command.equals("help")) {
                view.showCollectionMenu();
            } else {
                view.printError(ErrorType.COMMAND);
            }
        }
    }
}

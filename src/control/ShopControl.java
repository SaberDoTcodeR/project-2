package control;

import model.*;

import view.*;
public class ShopControl {
    public static boolean finished = false;
    private static View view = View.getInstance();

    public void main() {
        view.showShopMenu();
        while (!finished) {
            Request request = new Request();
            request.getNewCommand();
            Command command = request.getMatchedCommand(3);

            if (command != null&&!command.equals("help")) {
                command.apply(request);
                view.printError(request.getError());
            } else if (command != null && command.equals("help")) {
                view.showShopMenu();
            }
            else {
                view.printError(ErrorType.COMMAND);
            }
        }
    }
}

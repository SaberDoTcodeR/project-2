package control;

import model.Battles.Battle;
import model.ErrorType;
import view.Command;
import view.Request;
import view.View;

public class CollectableControl {
    public static boolean finished = false;
    private static View view = View.getInstance();

    public void main(Battle battle) {
        view.showCollectableMenu();
        while (!finished) {
            Request request = new Request();
            request.getNewCommand();
            request.setBattle(battle);
            Command command = request.getMatchedCommand(9);

            if (command != null && !request.getCommand().equals("help") && !request.getCommand().equals("exit")) {
                command.apply(request);
                view.printError(request.getError());
            } else if (command != null && request.getCommand().equals("help")) {
                view.showCollectableMenu();
            } else if (command != null && request.getCommand().equals("exit")) {
                request.getBattle().setSelectedCollectible(null);
                return;
            } else {
                view.printError(ErrorType.COMMAND);
            }
        }
    }
}

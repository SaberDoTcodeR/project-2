package control;

import model.*;

import model.Battles.Battle;
import model.Menus.Account;
import view.*;

import java.util.ArrayList;
import java.util.Random;

public class GameControl {
    public static boolean finished = false;
    private static View view = View.getInstance();

    public void main(Battle battle) {
        view.showBattleMenu();
        ArrayList<Account> players = new ArrayList<>();
        players.add(battle.getSecondPlayer());
        players.add(battle.getFirstPlayer());
        while (!finished) {
            battle.getFirstPlayerHand().fillHand(battle, 0);
            battle.getSecondPlayerHand().fillHand(battle, 1);

            int whoseTurn = battle.getTurn() % 2;
            players.get(0).setMana(battle.getTurn()/2+200);
            if (battle.isPlayWithAI() && battle.getTurn() % 2 == 0) {

                battle.doCleverThings();
                Request request = new Request();
                request.setCommand("end turn");
                request.setBattle(battle);
                Command command = request.getMatchedCommand(1);
                command.apply(request);
                System.out.println("your turn :");
            }
            players.get(1).setMana(battle.getTurn()/2+200);
            if (battle.getTurn() == 1 && battle.getFirstPlayerDeck().getUsableItem() != null)
                battle.getFirstPlayerDeck().getUsableItem().applyEffect(battle, null, battle.getFirstPlayer(), -1);
            if (battle.getTurn() == 1 && battle.getSecondPlayerDeck().getUsableItem() != null)
                battle.getSecondPlayerDeck().getUsableItem().applyEffect(battle, null, battle.getSecondPlayer(), -1);


            boolean turnFinished = false;
            while (!turnFinished) {
                Request request = new Request();
                request.getNewCommand();
                request.setBattle(battle);
                Command command = request.getMatchedCommand(1);
                if (command != null && !request.getCommand().equals("end turn")) {
                    command.apply(request);
                    view.printError(request.getError());
                } else if (command != null && request.getCommand().equals("end turn")) {
                    command.apply(request);
                    turnFinished = true;
                } else {
                    view.printError(ErrorType.COMMAND);
                }
            }
        }
    }
}


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
        Random rand = new Random();
        view.showBattleMenu();

        ArrayList<Account> players = new ArrayList<>();
        players.add(battle.getSecondPlayer());
        players.add(battle.getFirstPlayer());
        battle.getMap().get(2).get(0).getHero().cardIdGenerator(battle);
        battle.increamentTurn();
        battle.getMap().get(2).get(8).getHero().cardIdGenerator(battle);
        battle.decreamentTurn();
        while (!finished) {
            battle.getFirstPlayerHand().fillHand(battle, 0);
            battle.getSecondPlayerHand().fillHand(battle, 1);

            int whoseTurn = battle.getTurn() % 2;
            if (battle.getTurn() >= 14)
                players.get(whoseTurn).setMana(9);
            else
                players.get(whoseTurn).setMana(battle.getTurn() / 2 + 2);


            boolean turnFinished = false;
            while (!turnFinished) {
                Request request = new Request();
                request.getNewCommand();
                request.setBattle(battle);
                Command command = request.getMatchedCommand(1);
                if (command != null) {
                    command.apply(request);
                    view.printError(request.getError());
                } else {
                    view.printError(ErrorType.COMMAND);
                }
            }
        }
    }
}


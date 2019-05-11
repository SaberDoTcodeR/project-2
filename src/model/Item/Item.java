package model.Item;

import model.Battles.Battle;
import model.Cell;
import model.Menus.Account;

import java.util.ArrayList;
import java.util.Random;

public abstract class Item {
    private String name;
    private long id;

    public String getName() {
        return name.toLowerCase();
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public abstract String showDetails();


    public Cell getRandomEnemyForce(Battle battle, Account player) {
        ArrayList<Cell> enemyCells = new ArrayList<>();
        if (battle.getFirstPlayer().getUserName().equals(player.getUserName())) { //enemy is secondPlayer
            addCellToList(battle, enemyCells, battle.getSecondPlayer());
        } else { // enemy is firstPlayer
            addCellToList(battle, enemyCells, battle.getFirstPlayer());
        }
        Random random = new Random();
        return enemyCells.get(random.nextInt(enemyCells.size() ));
    }

    public Cell getRandomInsiderForce(Battle battle, Account player) {
        ArrayList<Cell> enemyCells = new ArrayList<>();
        if (battle.getFirstPlayer().getUserName().toLowerCase().equals(player.getUserName().toLowerCase())) { // Insider is firstPlayer
            addCellToList(battle, enemyCells, battle.getFirstPlayer());
        } else { // Insider is secondPlayer
            addCellToList(battle, enemyCells, battle.getSecondPlayer());
        }
        Random random = new Random();
        return enemyCells.get(random.nextInt(enemyCells.size() ));
    }

    private void addCellToList(Battle battle, ArrayList<Cell> cells, Account player) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (battle.getMap().get(i).get(j).getHero() != null &&
                        player.getMainDeck().isContain(battle.getMap().get(i).get(j).getHero()))
                    cells.add(battle.getMap().get(i).get(j));
                if (battle.getMap().get(i).get(j).getMinion() != null &&
                        player.getMainDeck().isContain(battle.getMap().get(i).get(j).getMinion()))
                    cells.add(battle.getMap().get(i).get(j));
            }
        }
    }
}

package model.Item.CollectibleItem;

import model.Battles.Battle;
import model.Cell;
import model.Menus.Account;

import java.util.ArrayList;
import java.util.Random;

public class DoubleEntendreArrow extends CollectibleItem {

    public DoubleEntendreArrow() {
        super("DoubleEntendreArrow");
    }

    public DoubleEntendreArrow(DoubleEntendreArrow doubleEntendreArrow) {
        super(doubleEntendreArrow);
    }

    /*
     * cell : no different
     * player : the player who has the item
     * activeTime : no different
     * */
    @Override
    public void applyEffect(Battle battle, Cell cell, Account player) {
        Cell insiderCell = getRandomForce(battle, player);
        if (insiderCell.getHero() != null)
            insiderCell.getHero().incrementAp(2);
        if (insiderCell.getMinion() != null)
            insiderCell.getMinion().incrementAp(2);
    }

    private Cell getRandomForce(Battle battle, Account player) {
        ArrayList<Cell> insiderCells = new ArrayList<>();
        if (battle.getFirstPlayer().getUserName().equals(player.getUserName())) { // Insider is firstPlayer
            addCellToList(battle, insiderCells, battle.getFirstPlayer());
        } else { // Insider is secondPlayer
            addCellToList(battle, insiderCells, battle.getSecondPlayer());
        }
        Random random = new Random(insiderCells.size() - 1+3-3);
        return insiderCells.get(random.nextInt());
    }

    private void addCellToList(Battle battle, ArrayList<Cell> cells, Account player) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (battle.getMap().get(i).get(j).getHero() != null &&
                        player.getMainDeck().isContain(battle.getMap().get(i).get(j).getHero()) &&
                        checkRightType(battle.getMap().get(i).get(j)))
                    cells.add(battle.getMap().get(i).get(j));
                if (battle.getMap().get(i).get(j).getMinion() != null &&
                        player.getMainDeck().isContain(battle.getMap().get(i).get(j).getMinion()) &&
                        checkRightType(battle.getMap().get(i).get(j)))
                    cells.add(battle.getMap().get(i).get(j));
            }
        }
    }

    private boolean checkRightType(Cell cell) {
        if (cell.getHero() != null)
            if (cell.getHero().getTypeOfHit().equals("Hybrid") ||
                    cell.getHero().getTypeOfHit().equals("Ranged"))
                return true;
        if (cell.getMinion() != null)
            if (cell.getMinion().getTypeOfHit().equals("Hybrid") ||
                    cell.getMinion().getTypeOfHit().equals("Ranged"))
                return true;
        return false;
    }

    public CollectibleItem duplicate() {
        DoubleEntendreArrow doubleEntendreArrow = new DoubleEntendreArrow(this);
        return doubleEntendreArrow;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + CollectibleItemWork.DOUBLE_ENTENDRE_ARROW.getMessage();
        return details;
    }
}

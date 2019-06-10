package Duelyst.model.Card.Spell;

import Duelyst.model.Account;
import Duelyst.model.Battle.Battle;
import Duelyst.model.Buff.PoisonEffectedCell;
import Duelyst.model.Cell;

import java.util.ArrayList;
public class PoisonLake extends Spell {

    public PoisonLake() {
        super("PoisonLake", 5, 900);
    }

    public PoisonLake(PoisonLake poisonLake) {
        super(poisonLake);
    }

    @Override
    public void castSpell(Battle battle, Cell cell, Account player) {
        /*ArrayList<Cell> cells = new ArrayList<>();
        cells.add(cell);
        if (cell.getX() < 5)
            cells.add(cell.downCell(battle.getMap()));
        if (cell.getY() < 9)
            cells.add(cell.rightCell(battle.getMap()));
        if (cell.getY() + 1 < 9)
            cells.add(request.getBattle().getMap().get(cell.getX() - 1).get(cell.getY() + 1));
        if (cell.getX() + 1 < 5)
            cells.add(request.getBattle().getMap().get(cell.getX() + 1).get(cell.getY() - 1));
        if (cell.getY() < 9 && cell.getX() < 5)
            cells.add(request.getBattle().getMap().get(cell.getX()).get(cell.getY()));
        if (cell.getY() + 1 < 9 && cell.getX() + 1 < 5)
            cells.add(request.getBattle().getMap().get(cell.getX() + 1).get(cell.getY() + 1));
        if (cell.getY() + 1 < 9 && cell.getX() < 5)
            cells.add(request.getBattle().getMap().get(cell.getX()).get(cell.getY() + 1));
        if (cell.getY() < 9 && cell.getX() + 1 < 5)
            cells.add(request.getBattle().getMap().get(cell.getX() + 1).get(cell.getY()));
        for (Cell cell1 : cells) {
            PoisonEffectedCell poisonEffectedCell = new PoisonEffectedCell();
            poisonEffectedCell.setTurnCounter(0);
            poisonEffectedCell.setCasting(poisonEffectedCell, cell1, null, null);
            cell1.getCellEffect().add(poisonEffectedCell);
        }*/
    }

    public Spell duplicate() {
        PoisonLake poisonLake = new PoisonLake(this);
        return poisonLake;
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.POISON_LAKE.getMessage();
        return details;
    }

    @Override
    public String getDesc() {
        return SpellWork.POISON_LAKE.getMessage();
    }
}

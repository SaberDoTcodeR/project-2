package model.Cards.Spell;

import model.Battles.Battle;
import model.Buffs.PoisonEffectedCell;
import model.Cell;
import model.Menus.Account;
import view.Request;

import java.util.ArrayList;

public class PoisonLake extends Spell {

    public PoisonLake() {
        super("PoisonLake", 5, 900);
    }

    public PoisonLake(PoisonLake poisonLake) {
        super(poisonLake);
    }

    @Override
    public void castSpell(Battle battle, Cell cell, Account player, Request request) {
        ArrayList<Cell> cells = new ArrayList<>();
        cells.add(cell);
        cells.add(cell.rightCell(battle.getMap()));
        cells.add(cell.downCell(battle.getMap()));
        cells.add(cells.get(2).downCell(battle.getMap()));
        cells.add(cells.get(2).rightCell(battle.getMap()));
        cells.add(cells.get(4).downCell(battle.getMap()));
        cells.add(cells.get(1).rightCell(battle.getMap()));
        cells.add(cells.get(6).downCell(battle.getMap()));
        cells.add(cells.get(7).downCell(battle.getMap()));
        for (Cell cell1 : cells) {
            if (cell1 != null) {
                PoisonEffectedCell poisonEffectedCell = new PoisonEffectedCell();
                poisonEffectedCell.setTurnCounter(0);
                poisonEffectedCell.setCasting(poisonEffectedCell, cell1, null, null);
                cell1.getCellEffect().add(poisonEffectedCell);
            }
        }
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

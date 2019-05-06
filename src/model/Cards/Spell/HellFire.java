package model.Cards.Spell;

import model.Battles.Battle;
import model.Buffs.FiringEffectedCell;
import model.Cell;
import model.Menus.Account;
import view.Request;

import java.util.ArrayList;

public class HellFire extends Spell {

    public HellFire() {
        super("HellFire", 3, 600);
    }

    public HellFire(HellFire hellFire) {
        super(hellFire);
    }

    @Override
    public void castSpell(Battle battle, Cell cell, Account player, Request request) {
        ArrayList<Cell> cells = new ArrayList<>();
        cells.add(cell);
        cells.add(cell.rightCell(battle.getMap()));
        cells.add(cells.get(1).downCell(battle.getMap()));
        cells.add(cell.downCell(battle.getMap()));
        for (Cell cell1 : cells) {
            if (cell1 != null) {
                FiringEffectedCell firingEffectedCell = new FiringEffectedCell();
                firingEffectedCell.setTurnCounter(1);
                firingEffectedCell.firing(cell1);
                firingEffectedCell.setCasting(firingEffectedCell, cell1, null, null);
                cell1.getCellEffect().add(firingEffectedCell);
            }
        }
    }

    public Spell duplicate() {
        HellFire hellFire = new HellFire(this);
        return hellFire;
    }

    @Override
    public String getDesc() {
        return SpellWork.HELL_FIRE.getMessage();
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.HELL_FIRE.getMessage();
        return details;
    }
}

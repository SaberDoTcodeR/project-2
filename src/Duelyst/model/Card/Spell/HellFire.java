package Duelyst.model.Card.Spell;

import Duelyst.model.Account;
import Duelyst.model.Battle.Battle;
import Duelyst.model.Cell;
import Duelyst.model.ErrorType;
import javafx.scene.image.Image;

public class HellFire extends Spell {

    public HellFire() {
        super("HellFire", 3, 600);
        super.cardImage = new Image("Duelyst/css/unit_gifs/f5_altgeneraltier2_breathing.gif");
    }

    public HellFire(HellFire hellFire) {
        super(hellFire);
    }

    @Override
    public ErrorType castSpell(Battle battle, Cell cell, Account player) {
       /* ArrayList<Cell> cells = new ArrayList<>();
        cells.add(cell);
        if (cell.getX() < 4 && cell.getY() < 8)
            cells.add(request.getBattle().getMap().get(cell.getX()+1).get(cell.getY()+1));
        if (cell.getY() < 8)
            cells.add(cell.rightCell(battle.getMap()));
        if (cell.getX() < 4)
            cells.add(cell.downCell(battle.getMap()));
        for (Cell cell1 : cells) {
            if (cell1 != null) {
                FiringEffectedCell firingEffectedCell = new FiringEffectedCell();
                firingEffectedCell.setTurnCounter(1);
                firingEffectedCell.firing(cell1);
                firingEffectedCell.setCasting(firingEffectedCell, cell1, null, null);
                cell1.getCellEffect().add(firingEffectedCell);
            }
        }*/

        return null;
    }

    @Override
    public Spell duplicate() {
        HellFire hellFire = new HellFire(this);
        hellFire.cardImage = new Image("Duelyst/css/unit_gifs/f5_altgeneraltier2_breathing.gif");
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

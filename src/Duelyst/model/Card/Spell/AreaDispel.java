package Duelyst.model.Card.Spell;

import Duelyst.model.Account;
import Duelyst.model.Battle.Battle;
import Duelyst.model.Cell;
import Duelyst.model.ErrorType;
import javafx.scene.image.Image;

public class AreaDispel extends Spell {

    public AreaDispel() {
        super("AreaDispel", 2, 1500);
        super.cardImage = new Image("Duelyst/css/unit_gifs/f3_tier2general_breathing.gif");
    }

    public AreaDispel(AreaDispel areaDispel) {
        super(areaDispel);
    }

    public String getDesc() {
        return SpellWork.AREA_DISPEL.getMessage();
    }

    @Override
    public ErrorType castSpell(Battle battle, Cell cell, Account player) {
       /* ArrayList<Cell> cells = new ArrayList<>();
        cells.add(cell);
        if (cell.getY() < 8)
            cells.add(cell.rightCell(battle.getMap()));
        if (cell.getX() < 4)
            cells.add(cell.downCell(battle.getMap()));
        if (cell.getX() < 4 && cell.getY() < 8)
            cells.add(request.getBattle().getMap().get(cell.getX()+1).get(cell.getY()+1));
        for (Cell cell1 : cells) {
            Dispel dispel = new Dispel();
            dispel.castSpell(battle, cell1, player, request);
        }*/
        return null;
    }

    @Override
    public Spell duplicate() {
        AreaDispel areaDispel = new AreaDispel(this);

        areaDispel.cardImage = new Image("Duelyst/css/unit_gifs/f3_tier2general_breathing.gif");
        return areaDispel;
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.AREA_DISPEL.getMessage();
        return details;
    }
}

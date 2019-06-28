package DuelystServer.model.Card.Spell;

import DuelystServer.model.Account;
import DuelystServer.model.Battle.Battle;
import DuelystServer.model.Cell;
import DuelystServer.model.ErrorType;
import javafx.scene.image.Image;

public class LightingBolt extends Spell {

    public LightingBolt() {
        super("LightingBolt", 2, 1250);
    }

    public LightingBolt(LightingBolt lightingBolt) {
        super(lightingBolt);
    }

    @Override
    public ErrorType castSpell(Battle battle, Cell cell, Account player) {
   /*     if (cell.getHero() == null && cell.getMinion() == null) {
            //request.setError(ErrorType.INVALID_TARGET);
        } else {
            if (cell.getHero() != null) {
                if (!player.getMainDeck().isContain(cell.getHero())) {
                    cell.getHero().decrementHp(8 - cell.getHero().getHolyCounter());
                } else {
                    // request.setError(ErrorType.INVALID_TARGET);
                }
            }
            if (cell.getMinion() != null) {
                //request.setError(ErrorType.INVALID_TARGET);
            }
        }


    */
        return null;
    }

    public Spell duplicate() {
        LightingBolt lightingBolt = new LightingBolt(this);
        return lightingBolt;
    }

    @Override
    public String getDesc() {
        return SpellWork.LIGHTING_BOLT.getMessage();
    }


    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.LIGHTING_BOLT.getMessage();
        return details;
    }
}

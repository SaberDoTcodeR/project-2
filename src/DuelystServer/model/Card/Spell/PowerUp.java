package DuelystServer.model.Card.Spell;
import DuelystServer.model.Account;
import DuelystServer.model.Battle.Battle;
import DuelystServer.model.Cell;
import DuelystServer.model.ErrorType;
import javafx.scene.image.Image;

public class PowerUp extends Spell {

    public PowerUp() {
        super("PowerUp", 2, 2500);
    }

    public PowerUp(PowerUp powerUp) {
        super(powerUp);
    }

    @Override
    public ErrorType castSpell(Battle battle, Cell cell, Account player) {
     /*   if (cell.getHero() == null && cell.getMinion() == null) {
           // request.setError(ErrorType.INVALID_TARGET);
        } else {
            if (cell.getHero() != null) {
                if (player.getMainDeck().isContain(cell.getHero())) {
                    PowerBuff powerBuff = new PowerBuff(6, true);
                    powerBuff.incrementAp(cell.getHero());
                    powerBuff.setTurnCounter(0);
                    powerBuff.setCasting(powerBuff, null, cell.getHero(), null);
                    cell.getHero().getOwnBuffs().add(powerBuff);
                } else {
                   // request.setError(ErrorType.INVALID_TARGET);
                }
            }
            if (cell.getMinion() != null) {
                if (player.getMainDeck().isContain(cell.getMinion())) {
                    PowerBuff powerBuff = new PowerBuff(6, true);
                    powerBuff.incrementAp(cell.getMinion());
                    powerBuff.setTurnCounter(0);
                    powerBuff.setCasting(powerBuff, null, null, cell.getMinion());
                    cell.getMinion().getOwnBuffs().add(powerBuff);
                } else {
                  //  request.setError(ErrorType.INVALID_TARGET);
                }
            }
        }*/
        return null;
    }

    public Spell duplicate() {
        PowerUp powerUp = new PowerUp(this);
        return powerUp;
    }

    @Override
    public String getDesc() {
        return SpellWork.POWER_UP.getMessage();
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.POWER_UP.getMessage();
        return details;
    }
}

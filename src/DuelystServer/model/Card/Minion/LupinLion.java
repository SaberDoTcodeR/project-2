package DuelystServer.model.Card.Minion;

import DuelystServer.model.Account;
import DuelystServer.model.Battle.Battle;
import DuelystServer.model.Cell;
import javafx.scene.image.Image;

public class LupinLion extends Minion {
    public LupinLion() {
        super("LupinLion", 8, 1, 600, 2, 0, 0);
        super.setTimeOfActivationOfSpecialPower(0);
        super.cardImage = new Image("Duelyst/css/unit_gifs/boss_harmony_breathing.gif");
    }

    public LupinLion(LupinLion lupinLion) {
        super(lupinLion);
    }

    public Minion duplicate() {
        LupinLion lupinLion = new LupinLion(this);
        lupinLion.cardImage = new Image("Duelyst/css/unit_gifs/boss_harmony_breathing.gif");
        return lupinLion;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power: " + SpecialPower.LUPIN_LION.getMessage();
        return detail;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, int activeTime) {
      /*  if (activeTime == 3) {
            if (cell.getHero() != null) {
                ChangeApBuff changeApBuff = new ChangeApBuff(cell.getHero().getHolyCounter());
                changeApBuff.setTurnCounter(0);
                changeApBuff.increment(this);
                changeApBuff.setCasting(changeApBuff, null, null, this);
                this.getOwnBuffs().add(changeApBuff);
            } else if (cell.getMinion() != null) {
                ChangeApBuff changeApBuff = new ChangeApBuff(cell.getMinion().getHolyCounter());
                changeApBuff.setTurnCounter(0);
                changeApBuff.increment(this);
                changeApBuff.setCasting(changeApBuff, null, null, this);
                this.getOwnBuffs().add(changeApBuff);
            }
        }*/
    }

    public String getDesc() {
        return SpecialPower.LUPIN_LION.getMessage();
    }
}

package Duelyst.model.Card.Minion;

import Duelyst.model.Account;
import Duelyst.model.Battle.Battle;
import Duelyst.model.Buff.StunBuff;
import Duelyst.model.Cell;
import javafx.scene.image.Image;

public class PersianSwordsman extends Minion {
    public PersianSwordsman() {
        super("PersianSwordsman", 4, 6, 400, 2, 0, 0);
        super.setTimeOfActivationOfSpecialPower(4);
        super.cardImage = new Image("Duelyst/css/unit_gifs/boss_paragon_breathing.gif");
    }

    public PersianSwordsman(PersianSwordsman persianSwordsman) {
        super(persianSwordsman);
    }

    public Minion duplicate() {
        PersianSwordsman persianSwordsman = new PersianSwordsman(this);
        persianSwordsman.cardImage = new Image("Duelyst/css/unit_gifs/boss_paragon_breathing.gif");
        return persianSwordsman;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power : " + SpecialPower.PERSIAN_SWORDSMAN.getMessage();
        return detail;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, int activeTime) {
        if (activeTime == 3) {
            StunBuff stunBuff = new StunBuff();
            stunBuff.setTurnCounter(0);
            if (cell.getHero() != null) {
                stunBuff.stun(cell.getHero());
                stunBuff.setCasting(stunBuff, null, cell.getHero(), null);
                cell.getHero().getOwnBuffs().add(stunBuff);
            } else if (cell.getMinion() != null) {
                stunBuff.stun(cell.getMinion());
                stunBuff.setCasting(stunBuff, null, null, cell.getMinion());
                cell.getMinion().getOwnBuffs().add(stunBuff);
            }
        }
    }

    public String getDesc() {
        return SpecialPower.PERSIAN_SWORDSMAN.getMessage();
    }
}

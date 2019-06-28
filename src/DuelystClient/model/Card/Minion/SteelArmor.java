package DuelystClient.model.Card.Minion;
import DuelystClient.model.Account;
import DuelystClient.model.Battle.Battle;
//import DuelystClient.model.Buff.HolyBuff;
import DuelystClient.model.Cell;
import javafx.scene.image.Image;

public class SteelArmor extends Minion {
    public SteelArmor() {
        super("SteelArmor", 1, 1, 650, 3, 0, 0);
        super.setTimeOfActivationOfSpecialPower(1);
        super.cardImage = new Image("DuelystClient/css/unit_gifs/boss_shadowlord_breathing.gif");
    }

    public SteelArmor(SteelArmor steelArmor) {
        super(steelArmor);
    }

    public Minion duplicate() {
        SteelArmor steelArmor = new SteelArmor(this);
        steelArmor.cardImage = new Image("DuelystClient/css/unit_gifs/boss_shadowlord_breathing.gif");
       /* for (int i = 0; i < 12; i++) {
            HolyBuff holyBuff = new HolyBuff();
            holyBuff.setTurnCounter(-4);
            holyBuff.holy(steelArmor);
            holyBuff.setCasting(holyBuff, null, null, steelArmor);
            steelArmor.getOwnBuffs().add(holyBuff);
        }*/
        return steelArmor;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power : " + SpecialPower.STEEL_ARMOR.getMessage();
        return detail;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, int activeTime) {
        //already set
    }

    public String getDesc() {
        return SpecialPower.STEEL_ARMOR.getMessage();
    }
}

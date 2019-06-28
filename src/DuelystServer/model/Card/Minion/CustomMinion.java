package DuelystServer.model.Card.Minion;

import DuelystServer.model.Account;
import DuelystServer.model.Battle.Battle;
import DuelystServer.model.Cell;
import javafx.scene.image.Image;

public class CustomMinion extends Minion {
    public CustomMinion(String name, int ap, int hp, int costOfBuy, int typeOfRange, int range, Image image, int mp, int activeTime) {
        super(name, ap, hp, costOfBuy, mp, typeOfRange, range);
        this.setTimeOfActivationOfSpecialPower(activeTime);
        this.cardImage = image;
    }

    public CustomMinion(CustomMinion customMinion) {
        super(customMinion);
    }

    public Minion duplicate() {
        CustomMinion customMinion = new CustomMinion(this);
        customMinion.cardImage = this.getImage();
        return customMinion;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + super.getName() + "Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power : ";
        return detail;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, int activeTime) {
        //already exists
    }

    public String getDesc() {
        return null;
    }
}

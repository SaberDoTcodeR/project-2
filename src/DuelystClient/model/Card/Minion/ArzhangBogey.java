package DuelystClient.model.Card.Minion;


import DuelystClient.model.Account;
import DuelystClient.model.Battle.Battle;
import DuelystClient.model.Cell;
import javafx.scene.image.Image;

public class ArzhangBogey extends Minion {
    public ArzhangBogey() {
        super("ArzhangBogey", 6, 6, 600, 3, 0, 0);
        super.setTimeOfActivationOfSpecialPower(2);
        super.cardImage = new Image("DuelystClient/css/unit_gifs/boss_andromeda_breathing.gif");
    }

    public ArzhangBogey(ArzhangBogey arzhangBogey) {
        super(arzhangBogey);
    }

    public Minion duplicate() {
        ArzhangBogey arzhangBogey = new ArzhangBogey(this);
        arzhangBogey.cardImage = new Image("DuelystClient/css/unit_gifs/boss_andromeda_breathing.gif");
        return arzhangBogey;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power:.";
        return detail;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, int activeTime) {

    }

    public String getDesc() {
        return "Nothing";
    }
}

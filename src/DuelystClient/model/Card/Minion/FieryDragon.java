package DuelystClient.model.Card.Minion;
import DuelystClient.model.Account;
import DuelystClient.model.Battle.Battle;
import DuelystClient.model.Cell;
import javafx.scene.image.Image;

public class FieryDragon extends Minion {
    public FieryDragon() {
        super("FieryDragon", 5, 9, 250, 5, 1, 4);
        super.cardImage = new Image("DuelystClient/css/unit_gifs/boss_decepticlechassis_breathing.gif");
    }

    public FieryDragon(FieryDragon fieryDragon) {
        super(fieryDragon);
    }

    public Minion duplicate() {
        FieryDragon fieryDragon = new FieryDragon(this);
        fieryDragon.cardImage = new Image("DuelystClient/css/unit_gifs/boss_decepticlechassis_breathing.gif");
        return fieryDragon;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power:";
        return detail;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, int activeTime) {

    }

    public String getDesc() {
        return "Nothing";
    }
}

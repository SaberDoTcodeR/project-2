package DuelystServer.model.Card.Minion;
import DuelystServer.model.Account;
import DuelystServer.model.Battle.Battle;
import DuelystServer.model.Cell;
import javafx.scene.image.Image;

public class HogRiderBogey extends Minion {
    public HogRiderBogey() {
        super("HogRiderBogey", 8, 16, 300, 6, 0, 0);
    }

    public HogRiderBogey(HogRiderBogey hogRiderBogey) {
        super(hogRiderBogey);
    }

    public Minion duplicate() {
        HogRiderBogey hogRiderBogey = new HogRiderBogey(this);
        return hogRiderBogey;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power:    .";
        return detail;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, int activeTime) {
        //nothing
    }

    public String getDesc() {
        return "Nothing";
    }
}

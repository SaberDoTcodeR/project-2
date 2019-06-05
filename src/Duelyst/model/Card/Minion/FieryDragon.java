package Duelyst.model.Card.Minion;

public class FieryDragon extends Minion {
    public FieryDragon() {
        super("FieryDragon", 5, 9, 250, 5, 1, 4);
    }

    public FieryDragon(FieryDragon fieryDragon) {
        super(fieryDragon);
    }

    public Minion duplicate() {
        FieryDragon fieryDragon = new FieryDragon(this);
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
    public void castSpecialPower(Battle battle, Cell cell, Account player, Request request, int activeTime) {

    }

    public String getDesc() {
        return "Nothing";
    }
}

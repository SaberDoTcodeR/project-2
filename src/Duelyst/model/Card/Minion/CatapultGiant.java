package Duelyst.model.Card.Minion;

public class CatapultGiant extends Minion {
    public CatapultGiant() {
        super("CatapultGiant", 12, 12, 300, 9, 1, 7);
    }

    public CatapultGiant(CatapultGiant catapultGiant) {
        super(catapultGiant);
    }

    public Minion duplicate() {
        CatapultGiant catapultGiant = new CatapultGiant(this);
        return catapultGiant;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power: .";
        return detail;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, Request request, int activeTime) {
        //nothing
    }

    public String getDesc() {
        return " Nothing";
    }
}

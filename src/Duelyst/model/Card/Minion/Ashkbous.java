package Duelyst.model.Card.Minion;


public class Ashkbous extends Minion {
    public Ashkbous() {
        super("Ashkbous", 8, 14, 400, 7, 0, 0);
        super.setTimeOfActivationOfSpecialPower(6);
    }

    public Ashkbous(Ashkbous ashkbous) {
        super(ashkbous);
    }

    public Minion duplicate() {
        Ashkbous ashkbous = new Ashkbous(this);
        return ashkbous;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power : " + SpecialPower.ASHKBOUS.getMessage();
        return detail;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, Request request, int activeTime) {

    }

    public String getDesc() {
        return SpecialPower.ASHKBOUS.getMessage();
    }
}

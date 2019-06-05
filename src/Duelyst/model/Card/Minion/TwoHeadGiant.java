package Duelyst.model.Card.Minion;


public class TwoHeadGiant extends Minion {
    public TwoHeadGiant() {
        super("TwoHeadGiant", 4, 10, 550, 4, 0, 0);
        super.setTimeOfActivationOfSpecialPower(4);
    }

    public TwoHeadGiant(TwoHeadGiant twoHeadGiant) {
        super(twoHeadGiant);
    }

    public Minion duplicate() {
        TwoHeadGiant twoHeadGiant = new TwoHeadGiant(this);
        return twoHeadGiant;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power : " + SpecialPower.TWO_HEAD_GIANT.getMessage();
        return detail;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, Request request, int activeTime) {
        if (activeTime == 3) {
            if (cell.getHero() != null) {
                for (Buff buff : cell.getHero().getOwnBuffs()) {
                    if (dispelEnemyValidation(buff.getClass().getSimpleName())) {
                        buff.dispel(cell.getHero());
                    }
                }
            } else if (cell.getMinion() != null) {
                for (Buff buff : cell.getMinion().getOwnBuffs()) {
                    if (dispelEnemyValidation(buff.getClass().getSimpleName())) {
                        buff.dispel(cell.getMinion());
                    }
                }
            }
        }
    }

    public String getDesc() {
        return SpecialPower.TWO_HEAD_GIANT.getMessage();
    }
}

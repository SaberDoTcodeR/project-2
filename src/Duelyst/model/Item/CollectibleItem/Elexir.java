package Duelyst.model.Item.CollectibleItem;


import Duelyst.model.Account;
import Duelyst.model.Battle.Battle;
import Duelyst.model.Buff.PowerBuff;
import Duelyst.model.Cell;

public class Elexir extends CollectibleItem {

    public Elexir() {
        super("Elexir");
    }

    public Elexir(Elexir elexir) {
        super(elexir);
    }

    /*
     * cell : no different
     * player : the player who has the item
     * activeTime : no different
     * */
    @Override
    public void applyEffect(Battle battle, Cell cell, Account player) {
        Cell insiderCell = getRandomInsiderForce(battle, player);
        while (insiderCell.getMinion() == null) {
            insiderCell = getRandomInsiderForce(battle, player);
        }
        if (insiderCell.getMinion() != null) {
            insiderCell.getMinion().incrementHp(3);
            PowerBuff powerBuff = new PowerBuff(3, true);
            powerBuff.setCasting(powerBuff, null, null, insiderCell.getMinion());
            powerBuff.setTurnCounter(-5);
            powerBuff.incrementAp(insiderCell.getMinion());
            insiderCell.getMinion().getOwnBuffs().add(powerBuff);
        }

    }

    public CollectibleItem duplicate() {
        Elexir elexir = new Elexir(this);
        return elexir;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + CollectibleItemWork.ELIXIR.getMessage();
        return details;
    }
}

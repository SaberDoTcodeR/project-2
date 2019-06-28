package DuelystServer.model.Item.CollectibleItem;

import DuelystServer.model.Account;
import DuelystServer.model.Battle.Battle;
import DuelystServer.model.Cell;

//import DuelystServer.model.Buff.HolyBuff;

public class PerpetuityElectuary extends CollectibleItem {

    public PerpetuityElectuary() {
        super("PerpetuityElectuary");
    }

    public PerpetuityElectuary(PerpetuityElectuary perpetuityElectuary) {
        super(perpetuityElectuary);
    }

    /*
     * cell : no different
     * player : player who has the item
     * activeTime : no different
     * */
    @Override
    public void applyEffect(Battle battle, Cell cell, Account player) {
        /*Cell insiderCell = getRandomInsiderForce(battle, player);
        if (insiderCell.getHero() != null) {
            for (int i = 0; i < 10; i++) {
                HolyBuff holyBuff = new HolyBuff();
                holyBuff.setCasting(holyBuff, null, insiderCell.getHero(), null);
                holyBuff.setTurnCounter(1);
                holyBuff.holy(insiderCell.getHero());
                insiderCell.getHero().getOwnBuffs().add(holyBuff);
            }
        }
        if (insiderCell.getMinion() != null) {
            for (int i = 0; i < 10; i++) {
                HolyBuff holyBuff = new HolyBuff();
                holyBuff.setCasting(holyBuff, null, null, insiderCell.getMinion());
                holyBuff.setTurnCounter(1);
                holyBuff.holy(insiderCell.getMinion());
                insiderCell.getMinion().getOwnBuffs().add(holyBuff);
            }
        }*/
    }

    public CollectibleItem duplicate() {
        PerpetuityElectuary perpetuityElectuary = new PerpetuityElectuary(this);
        return perpetuityElectuary;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + CollectibleItemWork.PERPETUITY_ELECTUARY.getMessage();
        return details;
    }
}

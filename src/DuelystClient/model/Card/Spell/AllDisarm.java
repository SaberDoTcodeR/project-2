package DuelystClient.model.Card.Spell;

import DuelystClient.model.Account;
import DuelystClient.model.Battle.Battle;
import DuelystClient.model.Cell;
import DuelystClient.model.ErrorType;
import javafx.scene.image.Image;

public class AllDisarm extends Spell {

    public AllDisarm() {
        super("AllDisarm", 9, 2000);
        super.cardImage = new Image("DuelystClient/css/unit_gifs/f2_tier2general_breathing.gif");
    }

    public AllDisarm(AllDisarm allDisarm) {
        super(allDisarm);
    }

    @Override
    public ErrorType castSpell(Battle battle, Cell cell, Account player) {
        /*Account account;
        if (battle.getTurn() % 2 == 1)
            account = battle.getSecondPlayer();
        else
            account = battle.getFirstPlayer();
        for (ArrayList<Cell> cells : battle.getMap()) {
            for (Cell cell1 : cells) {
                if (cell1.getHero() != null && cell.getHero().getCardId().toLowerCase().contains(account.getUserName().toLowerCase())) {
                    DisarmBuff disarmBuff = new DisarmBuff();
                    disarmBuff.disarm(cell1.getHero());
                    disarmBuff.last = 0;
                    disarmBuff.setCasting(null, cell1.getHero(), null);
                    cell1.getHero().getOwnBuffs().add(disarmBuff);
                }
                if (cell1.getMinion() != null && cell.getMinion().getCardId().toLowerCase().contains(account.getUserName().toLowerCase())) {
                    DisarmBuff disarmBuff = new DisarmBuff();
                    disarmBuff.disarm(cell1.getMinion());
                    disarmBuff.last = 0;
                    disarmBuff.setCasting(null, null, cell1.getMinion());
                    cell1.getMinion().getOwnBuffs().add(disarmBuff);
                }
            }
        }
*/
        return ErrorType.SUCCESSFUL_INSERT;
    }

    public Spell duplicate() {
        AllDisarm allDisarm = new AllDisarm(this);

        allDisarm.cardImage = new Image("DuelystClient/css/unit_gifs/f2_tier2general_breathing.gif");
        return allDisarm;
    }


    @Override
    public String getDesc() {
        return SpellWork.ALL_DISARM.getMessage();
    }


    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.ALL_DISARM.getMessage();
        return details;
    }
}

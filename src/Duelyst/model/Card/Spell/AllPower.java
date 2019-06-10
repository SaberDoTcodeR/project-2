package Duelyst.model.Card.Spell;
import Duelyst.model.Account;
import Duelyst.model.Battle.Battle;
import Duelyst.model.Buff.PowerBuff;
import Duelyst.model.Cell;

import java.util.ArrayList;

public class AllPower extends Spell {

    public AllPower() {
        super("AllPower", 4, 2000);
    }

    public AllPower(AllPower allPower) {
        super(allPower);
    }

    @Override
    public void castSpell(Battle battle, Cell cell, Account player) {
        for (ArrayList<Cell> cells : battle.getMap()) {
            for (Cell cell1 : cells) {
                if (cell1.getHero() != null) {
                    if (player.getMainDeck().isContain(cell1.getHero())) {
                        PowerBuff powerBuff = new PowerBuff(2, true);
                        powerBuff.setTurnCounter(-5);
                        powerBuff.incrementAp(cell1.getHero());
                        powerBuff.setCasting(powerBuff, null, cell1.getHero(), null);
                        cell1.getHero().getOwnBuffs().add(powerBuff);
                    }
                }
                if (cell1.getMinion() != null) {
                    if (player.getMainDeck().isContain(cell1.getMinion())) {
                        PowerBuff powerBuff = new PowerBuff(2, true);
                        powerBuff.setTurnCounter(-5);
                        powerBuff.incrementAp(cell1.getMinion());
                        powerBuff.setCasting(powerBuff, null, null, cell1.getMinion());
                        cell1.getMinion().getOwnBuffs().add(powerBuff);
                    }
                }
            }
        }
    }

    public Spell duplicate() {
        AllPower allPower = new AllPower(this);
        return allPower;
    }

    @Override
    public String getDesc() {
        return SpellWork.ALL_POWER.getMessage();
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.ALL_POWER.getMessage();
        return details;
    }

}

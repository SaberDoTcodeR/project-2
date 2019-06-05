package Duelyst.model.Card.Spell;

import Duelyst.model.Account;
import Duelyst.model.Battle.Battle;
import Duelyst.model.Buff.PoisonBuff;
import Duelyst.model.Cell;

import java.util.ArrayList;
public class AllPoison extends Spell {

    public AllPoison() {
        super("AllPoison", 8, 1500);
    }

    public AllPoison(String name, int costToUse, int costOfBuy) {
        super(name, costToUse, costOfBuy);
    }

    @Override
    public void castSpell(Battle battle, Cell cell, Account player, Request request) {
        for (ArrayList<Cell> cells : battle.getMap()) {
            for (Cell cell1 : cells) {
                if (cell1.getHero() != null && !player.getMainDeck().isContain(cell1.getHero())) {
                    PoisonBuff poisonBuff = new PoisonBuff();
                    poisonBuff.poison(cell1.getHero());
                    poisonBuff.setTurnCounter(3);
                    poisonBuff.setCasting(poisonBuff, null, cell1.getHero(), null);
                    cell1.getHero().getOwnBuffs().add(poisonBuff);
                }
                if (cell1.getMinion() != null && !player.getMainDeck().isContain(cell1.getMinion())) {
                    PoisonBuff poisonBuff = new PoisonBuff();
                    poisonBuff.poison(cell1.getMinion());
                    poisonBuff.setTurnCounter(3);
                    poisonBuff.setCasting(poisonBuff, null, null, cell1.getMinion());
                    cell1.getMinion().getOwnBuffs().add(poisonBuff);
                }
            }
        }
    }

    public AllPoison(AllPoison allPoison) {
        super(allPoison);
    }

    public Spell duplicate() {
        AllPoison allPoison = new AllPoison(this);
        return allPoison;
    }


    @Override
    public String getDesc() {
        return SpellWork.ALL_POISON.getMessage();
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.ALL_POISON.getMessage();
        return details;
    }
}

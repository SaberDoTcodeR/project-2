package model.Cards.Spell;

import model.Battles.Battle;
import model.Buffs.DisarmBuff;
import model.Cell;
import model.Menus.Account;
import view.Request;

import java.util.ArrayList;

public class AllDisarm extends Spell {

    public AllDisarm() {
        super("AllDisarm", 9, 2000);
    }

    public AllDisarm(AllDisarm allDisarm) {
        super(allDisarm);
    }

    @Override
    public void castSpell(Battle battle, Cell cell, Account player, Request request) {
        for (ArrayList<Cell> cells : battle.getMap()) {
            for (Cell cell1 : cells) {
                if (cell1.getHero() != null && !player.getMainDeck().isContain(cell1.getHero())) {
                    DisarmBuff disarmBuff = new DisarmBuff();
                    disarmBuff.disarm(cell1.getHero());
                    disarmBuff.setTurnCounter(0);
                    disarmBuff.setCasting(disarmBuff, null, cell1.getHero(), null);
                    cell1.getHero().getOwnBuffs().add(disarmBuff);
                }
                if (cell1.getMinion() != null && !player.getMainDeck().isContain(cell1.getMinion())) {
                    DisarmBuff disarmBuff = new DisarmBuff();
                    disarmBuff.disarm(cell1.getMinion());
                    disarmBuff.setTurnCounter(0);
                    disarmBuff.setCasting(disarmBuff, null, null, cell1.getMinion());
                    cell1.getMinion().getOwnBuffs().add(disarmBuff);
                }
            }
        }
    }

    public Spell duplicate() {
        AllDisarm allDisarm = new AllDisarm(this);
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

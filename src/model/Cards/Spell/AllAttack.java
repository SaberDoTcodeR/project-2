package model.Cards.Spell;

import model.Battles.Battle;
import model.Cell;
import model.Menus.Account;
import view.Request;

import java.util.ArrayList;

public class AllAttack extends Spell {

    public AllAttack() {
        super("AllAttack", 4, 1500);
    }

    public AllAttack(AllAttack allAttack) {
        super(allAttack);
    }

    @Override
    public void castSpell(Battle battle, Cell cell, Account player, Request request) {
        int index=cell.getY();
        for (int i = 0; i < 5; i++) {
            if (battle.getMap().get(i).get(index).getHero() != null) {
                if (!player.getMainDeck().isContain(battle.getMap().get(i).get(index).getHero())) {
                    battle.getMap().get(i).get(index).getHero().decrementHp(6 - battle.getMap().get(i).get(index).getHero().getHolyCounter());
                }
            }
            if (battle.getMap().get(i).get(index).getMinion() != null) {
                if (!player.getMainDeck().isContain(battle.getMap().get(i).get(index).getMinion())) {
                    battle.getMap().get(i).get(index).getMinion().decrementHp(6 - battle.getMap().get(i).get(index).getMinion().getHolyCounter());
                }
            }
        }
    }

    public Spell duplicate() {
        AllAttack allAttack = new AllAttack(this);
        return allAttack;
    }


    @Override
    public String getDesc() {
        return SpellWork.ALL_ATTACK.getMessage();
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.ALL_ATTACK.getMessage();
        return details;
    }
}

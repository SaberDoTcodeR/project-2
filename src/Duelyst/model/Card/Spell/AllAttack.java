package Duelyst.model.Card.Spell;
import Duelyst.model.Account;
import Duelyst.model.Battle.Battle;
import Duelyst.model.Cell;

public class AllAttack extends Spell {

    public AllAttack() {
        super("AllAttack", 4, 1500);
    }

    public AllAttack(AllAttack allAttack) {
        super(allAttack);
    }

    @Override
    public void castSpell(Battle battle, Cell cell, Account player) {
        Account account;
        if(battle.getTurn()%2==1)
            account=battle.getSecondPlayer();
        else
            account=battle.getFirstPlayer();
        int index=cell.getY();
        for (int i = 0; i < 5; i++) {
            if (battle.getMap().get(i).get(index).getHero() != null) {
                if (battle.getMap().get(i).get(index).getHero().getCardId().toLowerCase().contains(account.getUserName().toLowerCase())) {
                    battle.getMap().get(i).get(index).getHero().decrementHp(6 - battle.getMap().get(i).get(index).getHero().getHolyCounter());
                    battle.getMap().get(i).get(index).getMinion().deadChecker(battle);
                }
            }
            if (battle.getMap().get(i).get(index).getMinion() != null) {
                System.out.println(account.getUserName());
                System.out.println(battle.getMap().get(i).get(index).getMinion().getCardId().toLowerCase());
                if (battle.getMap().get(i).get(index).getMinion().getCardId().toLowerCase().contains(account.getUserName().toLowerCase())) {

                    battle.getMap().get(i).get(index).getMinion().decrementHp(6 - battle.getMap().get(i).get(index).getMinion().getHolyCounter());
                    battle.getMap().get(i).get(index).getMinion().deadChecker(battle);
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

package DuelystServer.model.Card.Spell;

import DuelystServer.model.Account;
import DuelystServer.model.Battle.Battle;
import DuelystServer.model.Cell;
import DuelystServer.model.ErrorType;
import javafx.scene.image.Image;

public class AllAttack extends Spell {

    public AllAttack() {
        super("AllAttack", 4, 1500);
        super.cardImage = new Image("Duelyst/css/unit_gifs/f2_shidaimk2_breathing.gif");
    }

    public AllAttack(AllAttack allAttack) {
        super(allAttack);
    }

    @Override
    public ErrorType castSpell(Battle battle, Cell cell, Account player) {
        Account account;
        if (battle.getTurn() % 2 == 1)
            account = battle.getSecondPlayer();
        else
            account = battle.getFirstPlayer();
        int index = cell.getY();
        for (int i = 0; i < 5; i++) {
            if (battle.getMap().get(i).get(index).getHero() != null) {
                if (battle.getMap().get(i).get(index).getHero().getCardId().toLowerCase().contains(account.getUserName().toLowerCase())) {
                    battle.getMap().get(i).get(index).getHero().decrementHp(6 - battle.getMap().get(i).get(index).getHero().getHolyCounter());
                    battle.getMap().get(i).get(index).getMinion().deadChecker(battle);
                }
            }
            if (battle.getMap().get(i).get(index).getMinion() != null) {
                if (battle.getMap().get(i).get(index).getMinion().getCardId().toLowerCase().contains(account.getUserName().toLowerCase())) {
                    battle.getMap().get(i).get(index).getMinion().decrementHp(6 - battle.getMap().get(i).get(index).getMinion().getHolyCounter());
                    battle.getMap().get(i).get(index).getMinion().deadChecker(battle);
                }
            }
        }
        return ErrorType.SUCCESSFUL_INSERT;
    }

    public Spell duplicate() {
        AllAttack allAttack = new AllAttack(this);
        allAttack.cardImage = new Image("Duelyst/css/unit_gifs/f2_shidaimk2_breathing.gif");
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

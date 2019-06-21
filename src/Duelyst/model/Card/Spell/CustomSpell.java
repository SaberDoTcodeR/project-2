package Duelyst.model.Card.Spell;

import Duelyst.model.Account;
import Duelyst.model.Battle.Battle;
import Duelyst.model.Buff.Buff;
import Duelyst.model.Cell;

import java.util.ArrayList;

public class CustomSpell extends Spell {
    ArrayList<Buff> buffs = new ArrayList<>();

    public CustomSpell(String name, int costToUse, int costOfBuy, ArrayList<Buff> buffs) {
        super(name, costToUse, costOfBuy);
        this.buffs = buffs;
    }

    @Override
    public void castSpell(Battle battle, Cell cell, Account player) {
        for (Buff buff : this.buffs) {
            if (cell.getHero() != null){
                if (battle.getFirstPlayerInGameCards().contains(cell.getHero())){

                }
            }
        }
    }

    @Override
    public String getDesc() {
        return null;
    }

    @Override
    public String showDetails() {
        return null;
    }
}

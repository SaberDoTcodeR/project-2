package Duelyst.model.Card.Hero;


import Duelyst.model.Account;
import Duelyst.model.Battle.Battle;
import Duelyst.model.Buff.StunBuff;
import Duelyst.model.Card.Minion.SpecialPower;
import Duelyst.model.Cell;

public class Simurgh extends Hero {
    public Simurgh() {
        super("Simurgh", 4, 50, 9000, 0);
        super.setCoolDownTime(8);
        super.setMp(3);
    }

    public Simurgh(Simurgh simurgh) {
        super(simurgh);
    }

    public Hero duplicate() {
        Simurgh simurgh = new Simurgh(this);
        return simurgh;
    }

    @Override
    public String showDetails() {
        String details = "Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - Class : " + this.getTypeOfHit() + " – Special power : " + SpecialPower.SIMURGH.getMessage();
        return details;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, Request request) {

        if (player.getMana() >= this.getMp()) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 9; j++) {
                    if (battle.getMap().get(i).get(j).getHero() != null) {
                        if (!player.getMainDeck().isContain(battle.getMap().get(i).get(j).getHero())) {
                            StunBuff stunBuff = new StunBuff();
                            stunBuff.setTurnCounter(1);
                            stunBuff.stun(battle.getMap().get(i).get(j).getHero());
                            stunBuff.setCasting(stunBuff, null, battle.getMap().get(i).get(j).getHero(), null);
                            battle.getMap().get(i).get(j).getHero().getOwnBuffs().add(stunBuff);
                        }
                    } else if (battle.getMap().get(i).get(j).getMinion() != null) {
                        if (!player.getMainDeck().isContain(battle.getMap().get(i).get(j).getMinion())) {
                            StunBuff stunBuff = new StunBuff();
                            stunBuff.setTurnCounter(1);
                            stunBuff.stun(battle.getMap().get(i).get(j).getMinion());
                            stunBuff.setCasting(stunBuff, null, null, battle.getMap().get(i).get(j).getMinion());
                            battle.getMap().get(i).get(j).getMinion().getOwnBuffs().add(stunBuff);
                        }
                    }
                }
            }
        } else request.setError(ErrorType.DONT_HAVE_ENOUGH_MANA);

    }

    @Override
    public String getDesc() {
        return SpecialPower.SIMURGH.getMessage();
    }
}

package DuelystServer.model.Card.Minion;

import DuelystServer.model.Account;
import DuelystServer.model.Battle.Battle;
import DuelystServer.model.Cell;
import javafx.scene.image.Image;

public class Siavash extends Minion {
    public Siavash() {
        super("Siavash", 5, 8, 350, 4, 0, 0);
        super.setTimeOfActivationOfSpecialPower(3);
    }

    public Siavash(Siavash siavash) {
        super(siavash);
    }

    public Minion duplicate() {
        Siavash siavash = new Siavash(this);
        return siavash;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power : " + SpecialPower.SIAVASH.getMessage();
        return detail;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, int activeTime) {
        /*if (activeTime == 2) {
            outer:
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 9; j++) {
                    if (battle.getMap().get(i).get(j).getHero() != null) {
                        if (!player.getMainDeck().isContain(battle.getMap().get(i).get(j).getHero())) {
                            battle.getMap().get(i).get(j).getHero().decrementHp(6 - battle.getMap().get(i).get(j).getHero().getHolyCounter());
                            break outer;
                        }
                    }
                }
            }
        }*/
    }

    public String getDesc() {
        return SpecialPower.SIAVASH.getMessage();
    }
}

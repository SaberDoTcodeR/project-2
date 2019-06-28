package DuelystServer.model.Card.Minion;

import DuelystServer.model.Account;
import DuelystServer.model.Battle.Battle;
import DuelystServer.model.Cell;
import javafx.scene.image.Image;

public class Bahman extends Minion {
    public Bahman() {
        super("Bahman", 9, 16, 450, 8, 0, 0);
        super.setTimeOfActivationOfSpecialPower(1);

    }

    public Bahman(Bahman bahman) {
        super(bahman);
    }

    public Minion duplicate() {
        Bahman bahman = new Bahman(this);
        return bahman;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + super.getName() + "Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power : " + SpecialPower.BAHMAN.getMessage();
        return detail;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, int activeTime) {
/*        if (activeTime == 0) {
            if (battle.getTurn() % 2 == 0) {
                ArrayList<Minion> minionsOfEnemy = new ArrayList<>();
                for (int i = 0; i < battle.getFirstPlayerInGameCards().size(); i++) {
                    if (battle.getFirstPlayerInGameCards().get(i).getType().equals("Hero") || battle.getFirstPlayerInGameCards().get(i).getType().equals("Spell"))
                        continue;
                    minionsOfEnemy.add((Minion) battle.getFirstPlayerInGameCards().get(i));
                }
                int randomNumber = (int) (Math.random() * minionsOfEnemy.size());
                minionsOfEnemy.get(randomNumber).decrementHp(16);
            } else {
                ArrayList<Minion> minions = new ArrayList<>();
                for (int i = 0; i < battle.getSecondPlayerInGameCards().size(); i++) {
                    if (battle.getSecondPlayerInGameCards().get(i).getType().equals("Hero") || battle.getSecondPlayerInGameCards().get(i).getType().equals("Spell"))
                        continue;
                    minions.add((Minion) battle.getSecondPlayerInGameCards().get(i));
                }
                int random = (int) (Math.random() * minions.size());
                minions.get(random).decrementHp(16);
            }
        }*/
    }

    public String getDesc() {
        return SpecialPower.BAHMAN.getMessage();
    }
}

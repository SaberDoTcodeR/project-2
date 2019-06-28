package DuelystClient.model.Card.Minion;

import DuelystClient.model.Account;
import DuelystClient.model.Battle.Battle;
import DuelystClient.model.Cell;
import javafx.scene.image.Image;

public class PoisonSnake extends Minion {
    public PoisonSnake() {
        super("PoisonSnake", 6, 5, 300, 4, 1, 4);
        super.setTimeOfActivationOfSpecialPower(0);
        super.cardImage = new Image("DuelystClient/css/unit_gifs/boss_sandpanther_breathing.gif");
    }

    public PoisonSnake(PoisonSnake poisonSnake) {
        super(poisonSnake);
    }

    public Minion duplicate() {
        PoisonSnake poisonSnake = new PoisonSnake(this);
        poisonSnake.cardImage = new Image("DuelystClient/css/unit_gifs/boss_sandpanther_breathing.gif");
        return poisonSnake;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power: " + SpecialPower.POISON_SNAKE.getMessage();
        return detail;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, int activeTime) {
       /* if (activeTime == 3) {
            if (cell.getHero() != null) {
                PoisonBuff poisonBuff = new PoisonBuff();
                poisonBuff.setTurnCounter(3);
                poisonBuff.poison(cell.getHero());
                poisonBuff.setCasting(poisonBuff, null, cell.getHero(), null);
                cell.getHero().getOwnBuffs().add(poisonBuff);
            } else if (cell.getMinion() != null) {
                PoisonBuff poisonBuff = new PoisonBuff();
                poisonBuff.setTurnCounter(3);
                poisonBuff.poison(cell.getMinion());
                poisonBuff.setCasting(poisonBuff, null, null, cell.getMinion());
                cell.getMinion().getOwnBuffs().add(poisonBuff);
            }
        }*/
    }

    public String getDesc() {
        return SpecialPower.POISON_SNAKE.getMessage();
    }
}

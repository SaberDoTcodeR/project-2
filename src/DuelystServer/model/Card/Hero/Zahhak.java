package DuelystServer.model.Card.Hero;


import DuelystServer.model.Account;
import DuelystServer.model.Battle.Battle;
import DuelystServer.model.Card.Minion.SpecialPower;
import DuelystServer.model.Cell;
import javafx.scene.image.Image;

public class Zahhak extends Hero {
    public Zahhak() {
        super("Zahhak", 4, 50, 10000, 0);

        super.cardImage = new Image("Duelyst/css/unit_gifs/f2_general_skindogehai_breathing.gif");
        super.setCoolDownTime(0);
        super.setMp(1);
    }

    public Zahhak(Zahhak zahhak) {
        super(zahhak);
    }

    public Hero duplicate() {
        Zahhak zahhak = new Zahhak(this);
        zahhak.cardImage = new Image("Duelyst/css/unit_gifs/f2_general_skindogehai_breathing.gif");
        return zahhak;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - Class : " + this.getTypeOfHit() + " – Special power : " + SpecialPower.ZAHHAK.getMessage();
        return details;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player) {
       /* if (cell.getHero() != null) {
            if (!player.getMainDeck().isContain(cell.getHero())) {
                PoisonBuff poisonBuff = new PoisonBuff();
                poisonBuff.setTurnCounter(3 + 1 - 1);
                poisonBuff.poison(cell.getHero());
                poisonBuff.setCasting(poisonBuff, null, cell.getHero(), null);
                cell.getHero().getOwnBuffs().add(poisonBuff);
            } else {}//request.setError(ErrorType.SELF_HARM);
        } else if (cell.getMinion() != null) {
            if (!player.getMainDeck().isContain(cell.getMinion())) {
                PoisonBuff poisonBuff = new PoisonBuff();
                poisonBuff.setTurnCounter(3 + 2 - 2);
                poisonBuff.poison(cell.getMinion());
                poisonBuff.setCasting(poisonBuff, null, null, cell.getMinion());
                cell.getMinion().getOwnBuffs().add(poisonBuff);
            } else{}// request.setError(ErrorType.SELF_HARM);
        } else {}//request.setError(ErrorType.EMPTY_CELL);*/
    }

    public String getDesc() {
        return SpecialPower.ZAHHAK.getMessage();
    }
}

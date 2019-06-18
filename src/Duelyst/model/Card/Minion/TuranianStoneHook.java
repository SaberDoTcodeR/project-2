package Duelyst.model.Card.Minion;

import Duelyst.model.Account;
import Duelyst.model.Battle.Battle;
import Duelyst.model.Cell;
import javafx.scene.image.Image;

public class TuranianStoneHook extends Minion {
    public TuranianStoneHook() {
        super("TuranianStoneHook", 2, 4, 600, 1, 1, 7);
    }

    public TuranianStoneHook(TuranianStoneHook turanianStoneHook) {
        super(turanianStoneHook);
    }

    public Minion duplicate() {
        TuranianStoneHook turanianStoneHook = new TuranianStoneHook(this);
        turanianStoneHook.cardImage = new Image("Duelyst/css/unit_gifs/boss_soulstealer_breath.gif");
        return turanianStoneHook;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power : - ";
        return detail;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, int activeTime) {
        //nothing
    }

    public String getDesc() {
        return " Nothing";
    }
}

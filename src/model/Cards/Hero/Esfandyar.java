package model.Cards.Hero;

import model.Battles.Battle;
import model.Buffs.HolyBuff;
import model.Cell;
import model.Menus.Account;
import view.Request;

import model.Cards.Minion.SpecialPower;
public class Esfandyar extends Hero {
    public Esfandyar() {
        super("Esfandyar", 3, 35, 12000, 2);
        super.setCoolDownTime(0);
        super.setMp(0);
        super.setRange(3);
    }

    public Esfandyar(Esfandyar esfandyar) {
        super(esfandyar);
    }

    public Hero duplicate() {
        Esfandyar esfandyar = new Esfandyar(this);
        for (int i = 0; i < 3; i++) {
            HolyBuff holyBuff = new HolyBuff();
            holyBuff.setTurnCounter(-4);
            holyBuff.holy(esfandyar);
            holyBuff.setCasting(holyBuff, null, esfandyar, null);
            esfandyar.getOwnBuffs().add(holyBuff);
        }
        return esfandyar;
    }

    @Override
    public String showDetails() {
        String details = "Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - Class : " + this.getTypeOfHit() + " – Special power : " + SpecialPower.ESFANDYAR.getMessage();
        return details;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, Request request) {
        //Its Special Power was set before
    }

    public String getDesc() {
        return SpecialPower.ESFANDYAR.getMessage();
    }
}

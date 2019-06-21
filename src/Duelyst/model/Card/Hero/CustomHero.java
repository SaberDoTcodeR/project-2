package Duelyst.model.Card.Hero;

import Duelyst.model.Account;
import Duelyst.model.Battle.Battle;
import Duelyst.model.Card.Minion.SpecialPower;
import Duelyst.model.Card.Spell.Spell;
import Duelyst.model.Cell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class CustomHero extends Hero {
    private Spell spell;
    public CustomHero(String name, int ap, int hp, int costOfBuy, int typeOfRange ,int range, Image image, Spell spell, int coolDownTime, int mp) {
        super(name, ap, hp, costOfBuy, typeOfRange);
        this.setRange(range);
        this.cardImage = image;
        this.spell = spell;
        this.setCoolDownTime(coolDownTime);
        this.setMp(mp);
    }

    public CustomHero(CustomHero customHero){super(customHero);}

    public Hero duplicate() {
        CustomHero customHero = new CustomHero(this);
        customHero.cardImage = this.getImage();
        return customHero;
    }

    @Override
    public String showDetails() {
        String details = "Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - Class : " + this.getTypeOfHit() + " – Special power : " + this.spell.getDesc();
        return details;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player) {
        //Its Special Power was set before
    }

    @Override
    public String getDesc() {
        return null;
    }
}

package DuelystClient.model.Card.Hero;

import DuelystClient.model.Account;
import DuelystClient.model.Battle.Battle;
import DuelystClient.model.Cell;
import javafx.scene.image.Image;

public class CustomHero extends Hero {
    public CustomHero(String name, int ap, int hp, int costOfBuy, int typeOfRange, int range, Image image, int coolDownTime, int mp) {
        super(name, ap, hp, costOfBuy, typeOfRange);
        this.setRange(range);
        this.cardImage = image;
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
                + " - Class : " + this.getTypeOfHit() + " – Special power : " ;
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

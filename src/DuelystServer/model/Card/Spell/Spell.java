package DuelystServer.model.Card.Spell;

import DuelystServer.model.Account;
import DuelystServer.model.Battle.Battle;
import DuelystServer.model.Card.Card;
import DuelystServer.model.Cell;
import DuelystServer.model.ErrorType;
import javafx.scene.image.Image;

import java.util.ArrayList;

public abstract class Spell extends Card {
    private transient static ArrayList<Spell> spells = new ArrayList<>();
    private int costToUse;

    public void setCostToUse(int costToUse) {
        this.costToUse = costToUse;
    }

    static {
        new AllAttack();
        new AllDisarm();
        new AllPoison();
        new AllPower();
        new AreaDispel();
        new Dispel();
        new Empower();
        new FireBall();
        new GodStrength();
        new HealthWithProfit();
        new HellFire();
        new KingsGuard();
        new LightingBolt();
        new Madness();
        new PoisonLake();
        new PowerUp();
        new Sacrifice();
        new Shock();
        new TotalDisarm();
        new Weakening();
    }

    public Spell(String name, int costToUse, int costOfBuy) {
        this.setName(name);
        this.setCostOfBuy(costOfBuy);
        this.costToUse = costToUse;
        spells.add(this);
    }

    public Spell(Spell spell) {
        this.setName(spell.getName());
        this.setCostOfBuy(spell.getCostOfBuy());
        this.costToUse = spell.costToUse;
    }

    public abstract ErrorType castSpell(Battle battle, Cell cell, Account player);

    public static ArrayList<Spell> getSpells() {
        return spells;
    }

    public int getCostToUse() {
        return costToUse;
    }

    public abstract String getDesc();

    public String getType() {
        return "Spell";
    }

    public Spell duplicate() {
        return null;
    }

    @Override
    public Image getImage() {
        return cardImage;
    }
}


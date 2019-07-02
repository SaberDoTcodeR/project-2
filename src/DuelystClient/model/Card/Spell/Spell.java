package DuelystClient.model.Card.Spell;

import DuelystClient.model.Account;
import DuelystClient.model.Battle.Battle;
import DuelystClient.model.Card.Card;
import DuelystClient.model.Cell;
import DuelystClient.model.ErrorType;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Spell extends Card {
    private transient static ArrayList<Spell> spells = new ArrayList<>();
    private transient static Map<String,Integer> spellsName = new HashMap<>();
    private int costToUse;

    public static Map<String, Integer> getSpellsName() {
        return spellsName;
    }

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
        spellsName.put(this.getName().toLowerCase(),this.getCostOfBuy());
    }

    public Spell(Spell spell) {
        this.setName(spell.getName());
        this.setCostOfBuy(spell.getCostOfBuy());
        this.costToUse = spell.costToUse;
    }

    public ErrorType castSpell(Battle battle, Cell cell, Account player){
        return null;
    }

    public static ArrayList<Spell> getSpells() {
        return spells;
    }

    public int getCostToUse() {
        return costToUse;
    }

    public String getDesc(){
        return null;
    }

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


package DuelystServer.model.Card.Spell;

public enum SpellWork {
    TOTAL_DISARM("An enemy force become disarm until the end of the game"),
    AREA_DISPEL("Disappear positive buffs of enemy force and negative buffs of " +
            "insider force on selected 2x2 square"),
    EMPOWER("Add 2 AP to a allied force"),
    FIREBALL("Hit an enemy force 4 uint"),
    GOD_STRENGTH("Add 4Ap to a insider hero card"),
    HELL_FIRE("Apply fiery cell effect on selected 2x2 square for 2 turns"),
    LIGHTING_BOLT("Hit an enemy force 8 uint"),
    POISON_LAKE("Apply poison cell effect on selected 3x3 square for 1 turn"),
    MADNESS("Increase an insider force's Ap 4 units for 3turns but it can be disarm"),
    ALL_DISARM("Be disarm for 1 turn"),
    ALL_POISON("Enemy forces become poison for 4 turns"),
    DISPEL("Disappear positive buffs of enemy force and negative buffs of " +
            "insider force for a insider force or enemy force"),
    HEALTH_WITH_PROFIT("Give friend force a decrement buff or reduce HP of force 6 units" +
            "but have 2 holy buff for 3 turns"),
    POWER_UP("Apply a power buff and add 6AP for an insider force"),
    ALL_POWER("Apply a power buff and add 2 AP for all insider forces permanently"),
    ALL_ATTACK("Hit all enemy forces who in one column 6units"),
    WEAKENING("Give a enemy minion a decrement buff or reduce HP of minion 4 units"),
    SACRIFICE("Give a insider minion a decrement buff or reduce HP of minion 6 units" +
            " and give a power buff and add 8AP to insider minion"),
    KINGS_GUARD("Kill enemy force on 8 around cells"),
    SHOCK("Become stun for 2 turn for enemy force");

    private String effect;

    public String getMessage() {
        return effect;
    }

    SpellWork(String effect) {
        this.effect = effect;
    }

}

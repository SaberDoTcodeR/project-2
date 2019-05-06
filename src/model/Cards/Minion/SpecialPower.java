package model.Cards.Minion;

public enum SpecialPower {
    PERSIAN_SWORDSMAN("During attack make power stun for this turn."),
    PERSIAN_GLADIATOR(" Hit the enemy force with 5 more units hit than the number of its attacks in game."),
    TURANIAN_SPY("Disarm enemy force for one turn and poison it for 4 turns."),
    EAGLE("Has a power buff with 10 units increasing health."),
    ONE_EYE_GIANT("Hit minions in 8 cells around it " +
            "with 2 units hit when its death comes."),
    POISON_SNAKE("Poison enemy force for 3 turns."),
    LUPIN_LION("Holy buff doesn't have any effect on its attack."),
    GIANT_SNAKE("Minions which have 2 or less than 2 distance " +
            "from it hit 1 more unit while its attack forever."),
    WHITE_WOLF("When it hits a minion in the next turn" +
            " 6 units and the turn next of that 4 units will be diminished from that minion's health."),
    PANTHER("When it hits a minion in the next turn 8" +
            " units will be diminished from that minion's health."),
    WOLF("In the next turn 6 units will be diminished" +
            " from the minion's health."),
    MAGICIAN("Gives itself and all the relative minions which" +
            " they are in 8 cells around it a power with 2 units increase of hit power and a weakness with 1 unit decrease of health."),
    GIANT_MAGICIAN("Gives to all relative minions which they're " +
            "in 8 cells around it a power with 2 units increase of hit power and a holy buff."),
    ELF("Gives to all relative minions power buff " +
            "with 1 unit increase of hit power in passive mode."),
    WILD_HOG("Don't disarm."),
    PIRAN("Don't be poisoned."),
    GIV("Don't take negative effect from cards."),
    BAHMAN("Randomly decrease 16 units from the health of " +
            "one of the enemy's minions."),
    ASHKBOUS("Don't be attacked from forces that " +
            "have less health than it."),
    TWO_HEAD_GIANT("Deactivate all the positive effects of" +
            " every force that this minion attack to it."),
    COLD_GRANDMA("Enemy minions which are in 8 cells around it" +
            " will be stun for a turn."),
    STEEL_ARMOR("Change itself randomly to one of the " +
            "enemy minions."),
    SIAVASH("When its death comes it hits enemy's" +
            " hero with 6 units hit."),


    WHITE_BOGEY("Take a power buff that increase hit power of itself" +
            "4 units forever." + " - CoolDown Time : 2"),
    SIMURGH("Stun all enemy forces for one turn." + " - CoolDown Time : 8"),
    DRAGON("Disarm one person." + " - CoolDown Time : 1"),
    RAKHSH("Stun one of the enemy forces for one turn." + " - CoolDown Time : 2"),
    ZAHHAK("Poison the enemy in time of hitting for 3 turns." + " - CoolDown Time : -."),
    KAVEH("Make a cell holy for 3 turns." + " - CoolDown Time : 3"),
    ARASH("Hit all enemy forces in itself row with 4 units hit." + " - CoolDown Time : 2"),
    LEGEND("Dispel one of the enemy forces." + " - CoolDown Time : 2"),
    ESFANDYAR("Has 3 holy buff in continuous mode." + " - CoolDown Time : -.");
    private String effect;

    public String getMessage() {
        return effect;
    }

    SpecialPower(String effect) {
        this.effect = effect;
    }

}

package model;


public enum ErrorType {
    INVALID_COLLECTIBLE_ID("invalid collectible ID"),
    INVALID_HERO_TYPE_OF_HIT("Hero's hitting is not a kind of melee or hybrid"),
    HERO_IS_IN_COOLDOWN("Hero is in cool down"),
    ONLY_HEROES_HAVE_SPECIAL_POWER("Only Heroes are able to Use Special power"),
    CANNOT_COMBO_ATTACK("Can not attack combo"),
    CARD_IS_STUNNED("Card is Stunned"),
    TOO_EXHAUSTED("Too exhausted "),
    SELECT_HERO_OR_MINION("select hero or minion."),
    NO_CARD_SELECTED("No Card been selected"),
    FALSE_ITEM_USING("Item can not be applied because of type of hero's hitting"),
    INVALID_HERO_TYPE_HITTING("Hero's typeHit is not efficient"),
    INVALID_TARGET("Invalid target"),
    SECOND_PLAYER_NOT_CHOSEN_RIGHT("second player not chosen right"),
    SECOND_PLAYER_DECK_NOT_VALID("selected deck for second player is invalid"),
    CARD_NOT_FOUND_IN_GAME("Invalid card id"),
    DONE_MESSAGE("The Card has sold"),
    WRONG_REMOVE("This card or item not found in deck"),
    COMMAND("Not Valid Command"),
    USER_ALREADY_CREATED("user already created"),
    NO_SUCH_USER_EXIST("No Such User Exist"),
    DECK_FILLED("Deck is filled and you can't add any card"),
    DECK_ALREADY_HAS_HERO("Deck is already has a hero"),
    WRONG_PASSWORD("Wrong Password"),
    CARD_SUCCESSFULLY_BOUGHT("Card Bought successfully"),
    DONT_HAVE_ENOUGH_MONEY("you don't have enough money"),
    DONT_HAVE_ENOUGH_MANA("you don't have enough mana"),
    INVALID_NAME("There isn't any item or card with this name"),
    INVALID_CARD_NAME("There isn't any  card with this name"),
    CARD_EXISTENCE("You don't own this Card"),
    CARD_EXISTENCE_IN_DECK("This CardID Already Existed in This Deck"),
    INVALID_DECK("selected deck is invalid"),
    NOT_IN_SHOP("The card or item is not in shop"),
    IS_IN_SHOP("The card or item is in shop"),
    DECK_EXISTENCE("You have already a deck with this name"),
    NO_DECK_FOUND("You don't have a deck with this name"),
    THREE_ITEMS_ALREADY_OCCUPIED("You Already occupied 3 Items"),
    ALREADY_LOGOUT("you are not in any account"),
    CARD_NOT_FOUND_IN_SHOP("This Card doesn't exist"),
    EMPTY_CELL("This cell is empty"),
    SELF_HARM("Hitting own forces"),
    DIDNT_PASS_ENOUGH_TIME("More time should be passed to complete hero's cool down time"),
    DONT_HAVE_SPECIAL_POWER("This Hero doesn't have any special power");
    private String message;

    public String getMessage() {
        return message;
    }

    ErrorType(String message) {
        this.message = message;
    }
}
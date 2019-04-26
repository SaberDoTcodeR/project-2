package model;


public enum ErrorType {
    SECOND_PLAYER_NOT_CHOSEN_RIGHT("second player not chosen right"),
    SECOND_PLAYER_DECK_NOT_VALID("selected deck for second player is invalid"),
    DONE_MESSAGE("The Card has been selled"),
    WRONG_REMOVE("this card or item not found in deck"),
    COMMAND("Not Valid Command"),
    USER_ALREADY_CREATED("user already created"),
    NO_SUCH_USER_EXIST("No Such User Exist"),
    WRONG_ADDING("This card can't be add to the deck"),
    DECK_FILLED("Deck is filled and you can't add any card"),
    DECK_ALREADY_HAS_HERO("Deck is already has a hero"),
    WRONG_PASSWORD("Wrong Password"),
    CARD_SUCCESSFULLY_BOUGHT("Card Bought successfully"),
    DONT_HAVE_ENOUGH_MONEY("you don't have enough money"),
    INVALID_NAME("There isn't any item or card with this name"),
    CARD_EXISTENCE("You don't own this Card"),
    CARD_EXISTENCE_IN_DECK("This CardID Already Existed in This Deck"),
    INVALID_DECK("selected deck is invalid"),
    NOT_IN_SHOP("The card or item is not in shop"),
    IS_IN_SHOP("The card or item is in shop"),
    DECK_EXISTENCE("You have already a deck with this name"),
    NO_DECK_FOUND("You don't have a deck with this name"),
    THREE_ITEMS_ALREADY_OCCUPIED("You Already occupied 3 Items"),
    ALREADY_LOGOUT("you are not in any account"),
    CARD_NOT_FOUND_IN_SHOP("This Card doesn't exist");
    private String message;

    public String getMessage() {
        return message;
    }

    ErrorType(String message) {
        this.message = message;
    }
}

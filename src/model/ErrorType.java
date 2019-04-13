package model;


public enum ErrorType {
    COMMAND("Not Valid Command"),
    NOT_ENOUGH_MONEY("not enough money"),
    INVALID_INPUT("invalid input"),
    ERROR_WITHOUT_MESSAGE(""),
    DONT_HAVE_PRODUCT("we don't have it");

    private String message;

    public String getMessage() {
        return message;
    }

    ErrorType(String message) {
        this.message = message;
    }
}

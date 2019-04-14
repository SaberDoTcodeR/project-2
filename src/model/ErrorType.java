package model;


public enum ErrorType {
    COMMAND("Not Valid Command"),
    USER_ALREADY_CREATED("user already created"),
    NO_SUCH_USER_EXIST("No Such User Exist"),
    WRONG_PASSWORD("Wrong Password"),
    DONT_HAVE_PRODUCT("we don't have it");

    private String message;

    public String getMessage() {
        return message;
    }

    ErrorType(String message) {
        this.message = message;
    }
}

package view;

import model.*;

public class View {
    private static final View VIEW = new View();

    private View() {
    }

    public static View getInstance() {
        return VIEW;
    }
    public void printError(ErrorType error) {
        if (error == null) return;
        System.out.println(error.getMessage());
    }
}

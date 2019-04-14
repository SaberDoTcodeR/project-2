package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import model.*;
import control.*;

public class Request {
    public static Scanner scanner = new Scanner(System.in);
    private static ArrayList<ArrayList<Command>> commands = new ArrayList<>();
    private ErrorType error = null;
    private String commandLine;

    public void getNewCommand() {
        this.commandLine = scanner.nextLine().toLowerCase().trim();

    }

    static {
        setMatchedCommand();
    }

    private static void setMatchedCommand() {/////0 for main menu   1 for battle    2 for collection    3 for shop
        commands.get(0).add(new EnterBattle());
        commands.get(0).add(new EnterCollection());
        commands.get(0).add(new EnterShop());
        commands.get(0).add(new Exit());
        commands.get(0).add(new Help());


        commands.get(1).add(new EnterBattle());
        commands.get(1).add(new EnterCollection());
        commands.get(1).add(new EnterShop());
        commands.get(1).add(new Exit());
        commands.get(1).add(new Help());

    }

    public Command getMatchedCommand(int i) {
        for (Command command : commands.get(i)) {
            command.matcher = command.pattern.matcher(commandLine);
            if (command.matcher.matches()) {
                return command;
            }
        }
        return null;
    }
    public boolean repetitiousUser(String userName){
        for (Account account:Account.getAllUser()) {
            if(account.getUserName().equals(userName)){
                this.setError(ErrorType.USER_ALREADY_CREATED);
                return true;
            }
        }
        return false;
    }public boolean existThisUser(String userName){
        for (Account account:Account.getAllUser()) {
            if(account.getUserName().equals(userName)){
                return true;
            }
        }
        this.setError(ErrorType.NO_SUCH_USER_EXIST);
        return false;
    }
    public  void authorize(String userName,String passWord){
        for (Account account:Account.getAllUser()) {
            if(account.getUserName().equals(userName)){
                if(account.getPassWord().equals(passWord))
                {
                    Account.setLoginAccount(account);
                    return;
                }
                this.setError(ErrorType.WRONG_PASSWORD);
                return ;
            }
        }
    }
    public void setError(ErrorType error) {
        this.error = error;
    }

    public ErrorType getError() {
        return error;
    }

    public String getCommand() {
        return commandLine;
    }

    public void setCommand(String command) {
        this.commandLine = command;
    }

}

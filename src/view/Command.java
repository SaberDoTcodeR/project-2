package view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import control.*;
import model.*;
public abstract class Command {
    static View view = View.getInstance();
    Pattern pattern;
    Matcher matcher;
    public Command(CommandRegex command)
    {
        pattern = Pattern.compile(command.getRegex());
    }
    public abstract void apply(Request request);
}
class EnterBattle extends Command {

    EnterBattle() {
        super(CommandRegex.ENTER_BATTLE);
    }

    @Override
    public void apply(Request request) {
        BattleControl battleControl=new BattleControl();
        battleControl.main();
    }
}
class EnterCollection extends Command {

    EnterCollection() {
        super(CommandRegex.ENTER_COLLECTION);
    }

    @Override
    public void apply(Request request) {
        CollectionControl collectionControl=new CollectionControl();
        collectionControl.main();
    }
}
class EnterShop extends Command {

    EnterShop() {
        super(CommandRegex.ENTER_SHOP);
    }

    @Override
    public void apply(Request request) {
        ShopControl shopControl=new ShopControl();
        shopControl.main();
    }
}
class Exit extends Command {

    Exit() {
        super(CommandRegex.EXIT);
    }

    @Override
    public void apply(Request request) {
        System.exit(0);
    }
}
class Help extends Command {

    Help() {
        super(CommandRegex.HELP);
    }

    @Override
    public void apply(Request request) {
        System.exit(0);
    }
}
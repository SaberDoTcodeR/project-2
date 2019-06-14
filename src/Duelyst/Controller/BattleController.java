package Duelyst.Controller;

import Duelyst.Main;
import Duelyst.model.Card.Hero.Kaveh;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.util.Duration;

import Duelyst.model.Account;
import Duelyst.model.Battle.Battle;
import Duelyst.model.Battle.FlagsBattle;
import Duelyst.model.Battle.HeroBattle;
import Duelyst.model.Battle.OneFlagBattle;
import Duelyst.model.Card.Card;


public class BattleController {
    @FXML
    public ImageView image1;
    public ImageView image2;
    public ImageView image3;
    public ImageView image4;
    public ImageView image5;
    public ImageView gif1;
    public ImageView gif2;
    public ImageView gif3;
    public ImageView gif4;
    public ImageView gif5;
    public GridPane mapGrid;
    public GridPane stack;
    public static boolean finished = false;
    public Battle currentBattle;
    public Rectangle rect1;
    public Rectangle rect2;
    public Rectangle rect3;
    public Rectangle rect4;
    public Rectangle rect5;
    public Rectangle rect6;
    public Rectangle rect7;
    public Rectangle rect8;
    public Rectangle rect9;
    public Rectangle rect10;
    public Rectangle rect11;
    public Rectangle rect12;
    public Rectangle rect13;
    public Rectangle rect14;
    Rectangle[] rectangles = new Rectangle[45];


    public void handleHand() {
        currentBattle.getFirstPlayerHand().fillHand(currentBattle, 0);
        for (Card card : currentBattle.getFirstPlayerHand().getCards()) {
            showHand(card);
        }
        currentBattle.getSecondPlayerHand().fillHand(currentBattle, 1);
    }

    private void showHand(Card cardInHand) {

    }
/*

    public void handleTurn() {
        currentBattle.increamentTurn();
        currentBattle.getFirstPlayer().setMana(currentBattle.getTurn() / 2 + 2);
        currentBattle.getSecondPlayer().setMana(currentBattle.getTurn() / 2 + 2);
        showMana(currentBattle.getFirstPlayer().getMana(), currentBattle.getSecondPlayer().getMana());
        if (currentBattle.getTurn() % 2 == 0)
            currentBattle.doCleverThings();
        if (currentBattle.getTurn() == 1 && currentBattle.getFirstPlayerDeck().getUsableItem() != null)
            currentBattle.getFirstPlayerDeck().getUsableItem().get(0).applyEffect(currentBattle, null, currentBattle.getFirstPlayer(), -1);
        if (currentBattle.getTurn() == 1 && currentBattle.getSecondPlayerDeck().getUsableItem() != null)
            currentBattle.getSecondPlayerDeck().getUsableItem().get(0).applyEffect(currentBattle, null, currentBattle.getSecondPlayer(), -1);
    }
*/

    private void showMana(int manaPlayer, int manaAI) {

    }

    public void initialize() {
        rectangles[0]=rect1;
        rectangles[1]=rect2;
        rectangles[2]=rect3;
        rectangles[3]=rect4;
        rectangles[4]=rect5;
        rectangles[5]=rect6;
        rectangles[6]=rect7;
        rectangles[7]=rect8;
        rectangles[8]=rect9;
        rectangles[9]=rect10;
        rectangles[10]=rect11;
       /* switch (GameModeController.MODE) {
            case 0: {
                currentBattle = new HeroBattle(Account.getLoginAccount().getCollection().getStoryModeDeck().get(0).duplicate(),
                        Account.getLoginAccount().getMainDeck().duplicate(), Account.getLoginAccount(), 500);
                break;
            }
            case 1: {
                currentBattle = new OneFlagBattle(Account.getLoginAccount().getCollection().getStoryModeDeck().get(1).duplicate(),
                        Account.getLoginAccount().getMainDeck().duplicate(), Account.getLoginAccount(), 1000);
                break;
            }
            case 2: {
                currentBattle = new FlagsBattle(Account.getLoginAccount().getCollection().getStoryModeDeck().get(2).duplicate(),
                        Account.getLoginAccount().getMainDeck().duplicate(), Account.getLoginAccount(), 11, 1500);
                break;
            }
        }*/
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        final double KASHI = primaryScreenBounds.getWidth()*7 / 100;
        for (int i = 0; i < 11; i++) {
            rectangles[i].setWidth(KASHI);
            rectangles[i].setHeight(KASHI);
        }
        PerspectiveTransform transform = new PerspectiveTransform();
        transform.setLry(KASHI*5);
        transform.setLrx(KASHI*9);
        transform.setLly(KASHI*5);
        transform.setLlx(0);
        transform.setUry(0);
        transform.setUrx(KASHI*9-KASHI/3);
        transform.setUly(0);
        transform.setUlx(KASHI/3);
        mapGrid.setEffect(transform);
    }

    public void enterHand1(MouseEvent event) {
        RotateTransition rotate = new RotateTransition(Duration.millis(4000), image1);
        rotate.setFromAngle(image1.getRotate());
        rotate.setToAngle(image1.getRotate() + 360);
        rotate.setCycleCount(Animation.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.play();
        gif1.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                rotate.stop();
            }
        });
    }

   /* public void enterHand2(MouseEvent event) {
        RotateTransition rotate = new RotateTransition(Duration.millis(4000), image1);
        rotate.setFromAngle(image1.getRotate());
        rotate.setToAngle(image1.getRotate() + 360);
        rotate.setCycleCount(Animation.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.play();
        gif2.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                rotate.stop();
            }
        });
    }

    public void enterHand3(MouseEvent event) {
        RotateTransition rotate = new RotateTransition(Duration.millis(4000), image1);
        rotate.setFromAngle(image1.getRotate());
        rotate.setToAngle(image1.getRotate() + 360);
        rotate.setCycleCount(Animation.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.play();
        gif3.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                rotate.stop();
            }
        });
    }

    public void enterHand4(MouseEvent event) {
        RotateTransition rotate = new RotateTransition(Duration.millis(4000), image1);
        rotate.setFromAngle(image1.getRotate());
        rotate.setToAngle(image1.getRotate() + 360);
        rotate.setCycleCount(Animation.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.play();
        gif4.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                rotate.stop();
            }
        });
    }

    public void enterHand5(MouseEvent event) {
        RotateTransition rotate = new RotateTransition(Duration.millis(4000), image1);
        rotate.setFromAngle(image1.getRotate());
        rotate.setToAngle(image1.getRotate() + 360);
        rotate.setCycleCount(Animation.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.play();
        gif5.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                rotate.stop();
            }
        });
    }*/

    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY;

    public void press(MouseEvent event) {
        orgSceneX = event.getSceneX();
        orgSceneY = event.getSceneY();
        orgTranslateX = ((ImageView) (event.getSource())).getTranslateX();
        orgTranslateY = ((ImageView) (event.getSource())).getTranslateY();
    }

    public void drag(MouseEvent event) {
        double offsetX = event.getSceneX() - orgSceneX;
        double offsetY = event.getSceneY() - orgSceneY;
        double newTranslateX = orgTranslateX + offsetX;
        double newTranslateY = orgTranslateY + offsetY;

        ((ImageView) (event.getSource())).setTranslateX(newTranslateX);
        ((ImageView) (event.getSource())).setTranslateY(newTranslateY);
    }


    public void dragReleased(MouseEvent event) {
        ((ImageView) (event.getSource())).setTranslateX(image1.getX());
        ((ImageView) (event.getSource())).setTranslateY(image1.getY());
    }
}

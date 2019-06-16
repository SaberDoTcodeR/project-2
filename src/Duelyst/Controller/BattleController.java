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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
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
    public ImageView[] handGifs;
    public GridPane mapGrid;
    public GridPane stack;
    public static boolean finished = false;
    public Battle currentBattle;
    public Region rect1;
    public Region rect2;
    public Region rect3;
    public Region rect4;
    public Region rect5;
    public Region rect6;
    public Region rect7;
    public Region rect8;
    public Region rect9;
    public Region rect10;
    public Region rect11;
    public Region rect12;
    public Region rect13;
    public Region rect14;
    public Region rect15;
    public Region rect16;
    public Region rect17;
    public Region rect18;
    public Region rect19;
    public Region rect20;
    public Region rect21;
    public Region rect22;
    public Region rect23;
    public Region rect24;
    public Region rect25;
    public Region rect26;
    public Region rect27;
    public Region rect28;
    public Region rect29;
    public Region rect30;
    public Region rect31;
    public Region rect32;
    public Region rect33;
    public Region rect34;
    public Region rect35;
    public Region rect36;
    public Region rect37;
    public Region rect38;
    public Region rect39;
    public Region rect40;
    public Region rect41;
    public Region rect42;
    public Region rect43;
    public Region rect44;
    public Region rect45;

    public ImageView image6;
    public ImageView gif6;


    Region[] rectangles = new Region[45];


    public void handleHand() {
        currentBattle.getFirstPlayerHand().fillHand(currentBattle, 0);

        for (Card card : currentBattle.getFirstPlayerHand().getCards()) {
            showHand(card, false);
        }
        showHand(currentBattle.getFirstPlayerHand().getNextCardInHand(), true);
        currentBattle.getSecondPlayerHand().fillHand(currentBattle, 1);
    }

    private void showHand(Card cardInHand, boolean nextCard) {
        if (nextCard) {
            //gif6.setImage(cardInHand.getImage());
            gif6.setImage(new Image("Duelyst/css/boss_decepticlewings_breathing.gif"));
            return;
        }
        for (ImageView imageView : handGifs) {
            if (imageView.getImage() == null) {
                //imageView.setImage(cardInHand.getImage());
                imageView.setImage(new Image("Duelyst/css/boss_decepticlewings_breathing.gif"));
                return;
            }
        }
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
        handGifs = new ImageView[5];
        handGifs[0] = gif1;
        handGifs[1] = gif2;
        handGifs[2] = gif3;
        handGifs[3] = gif4;
        handGifs[4] = gif5;

        rectangles[0] = rect1;
        rectangles[1] = rect2;
        rectangles[2] = rect3;
        rectangles[3] = rect4;
        rectangles[4] = rect5;
        rectangles[5] = rect6;
        rectangles[6] = rect7;
        rectangles[7] = rect8;
        rectangles[8] = rect9;
        rectangles[9] = rect10;
        rectangles[10] = rect11;
        rectangles[11] = rect12;
        rectangles[12] = rect13;
        rectangles[13] = rect14;
        rectangles[14] = rect15;
        rectangles[15] = rect16;
        rectangles[16] = rect17;
        rectangles[17] = rect18;
        rectangles[18] = rect19;
        rectangles[19] = rect20;
        rectangles[20] = rect21;
        rectangles[21] = rect22;
        rectangles[22] = rect23;
        rectangles[23] = rect24;
        rectangles[24] = rect25;
        rectangles[25] = rect26;
        rectangles[26] = rect27;
        rectangles[27] = rect28;
        rectangles[28] = rect29;
        rectangles[29] = rect30;
        rectangles[30] = rect31;
        rectangles[31] = rect32;
        rectangles[32] = rect33;
        rectangles[33] = rect34;
        rectangles[34] = rect35;
        rectangles[35] = rect36;
        rectangles[36] = rect37;
        rectangles[37] = rect38;
        rectangles[38] = rect39;
        rectangles[39] = rect40;
        rectangles[40] = rect41;
        rectangles[41] = rect42;
        rectangles[42] = rect43;
        rectangles[43] = rect44;
        rectangles[44] = rect45;
        gif1.setImage(new Image("Duelyst/css/boss_decepticlewings_breathing.gif"));
        switch (GameModeController.MODE) {
            case 0: {
                Account.getLoginAccount().setMainDeck(Account.getLoginAccount().getCollection().getStoryModeDeck().get(1));
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
        }
        handleHand();
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        final double KASHI = primaryScreenBounds.getWidth() * 7 / 100;
        for (int i = 1; i < 45; i++) {
            rectangles[i].setPrefWidth(KASHI);
            rectangles[i].setPrefHeight(KASHI);
        }
        PerspectiveTransform transform = new PerspectiveTransform();
        transform.setLry(KASHI * 5);
        transform.setLrx(KASHI * 9);
        transform.setLly(KASHI * 5);
        transform.setLlx(0);
        transform.setUry(0);
        transform.setUrx(KASHI * 9 - KASHI / 3);
        transform.setUly(0);
        transform.setUlx(KASHI / 3);
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


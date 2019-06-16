package Duelyst.Controller;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
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
    public Pane rect1;
    public Pane rect2;
    public Pane rect3;
    public Pane rect4;
    public Pane rect5;
    public Pane rect6;
    public Pane rect7;
    public Pane rect8;
    public Pane rect9;
    public Pane rect10;
    public Pane rect11;
    public Pane rect12;
    public Pane rect13;
    public Pane rect14;
    public Pane rect15;
    public Pane rect16;
    public Pane rect17;
    public Pane rect18;
    public Pane rect19;
    public Pane rect20;
    public Pane rect21;
    public Pane rect22;
    public Pane rect23;
    public Pane rect24;
    public Pane rect25;
    public Pane rect26;
    public Pane rect27;
    public Pane rect28;
    public Pane rect29;
    public Pane rect30;
    public Pane rect31;
    public Pane rect32;
    public Pane rect33;
    public Pane rect34;
    public Pane rect35;
    public Pane rect36;
    public Pane rect37;
    public Pane rect38;
    public Pane rect39;
    public Pane rect40;
    public Pane rect41;
    public Pane rect42;
    public Pane rect43;
    public Pane rect44;
    public Pane rect45;

    public ImageView image6;
    public ImageView gif6;


    Pane[] rectangles = new Pane[45];


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

    int whichHand;
    static Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
    static final double KASHI = primaryScreenBounds.getWidth() * 7 / 100;

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
        image1.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                rotate.stop();
            }
        });
    }

    public void enterHand2(MouseEvent event) {
        RotateTransition rotate = new RotateTransition(Duration.millis(4000), image2);
        rotate.setFromAngle(image2.getRotate());
        rotate.setToAngle(image2.getRotate() + 360);
        rotate.setCycleCount(Animation.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.play();
        gif2.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                rotate.stop();
            }
        });
        image2.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                rotate.stop();
            }
        });
    }

    public void enterHand3(MouseEvent event) {
        RotateTransition rotate = new RotateTransition(Duration.millis(4000), image3);
        rotate.setFromAngle(image3.getRotate());
        rotate.setToAngle(image3.getRotate() + 360);
        rotate.setCycleCount(Animation.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.play();
        gif3.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                rotate.stop();
            }
        });
        image3.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                rotate.stop();
            }
        });
    }

    public void enterHand4(MouseEvent event) {
        RotateTransition rotate = new RotateTransition(Duration.millis(4000), image4);
        rotate.setFromAngle(image4.getRotate());
        rotate.setToAngle(image4.getRotate() + 360);
        rotate.setCycleCount(Animation.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.play();
        gif4.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                rotate.stop();
            }
        });
        image4.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                rotate.stop();
            }
        });
    }

    public void enterHand5(MouseEvent event) {
        RotateTransition rotate = new RotateTransition(Duration.millis(4000), image5);
        rotate.setFromAngle(image5.getRotate());
        rotate.setToAngle(image5.getRotate() + 360);
        rotate.setCycleCount(Animation.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.play();
        gif5.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                rotate.stop();
            }
        });
        image5.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                rotate.stop();
            }
        });
    }

    public void dragHand1(MouseEvent event) {
        Dragboard db = gif1.startDragAndDrop(TransferMode.ANY);
        ClipboardContent content = new ClipboardContent();
        content.putImage(gif1.getImage());
        content.putString(currentBattle.getFirstPlayerHand().getCards().get(0).getName());
        db.setContent(content);
        whichHand = 0;
        event.consume();
    }

    public void dragHand2(MouseEvent event) {
        Dragboard db = gif2.startDragAndDrop(TransferMode.ANY);
        ClipboardContent content = new ClipboardContent();
        content.putImage(gif2.getImage());
        db.setContent(content);
        whichHand = 1;
        event.consume();
    }

    public void dragHand3(MouseEvent event) {
        Dragboard db = gif3.startDragAndDrop(TransferMode.ANY);
        ClipboardContent content = new ClipboardContent();
        content.putImage(gif3.getImage());
        db.setContent(content);
        whichHand = 2;
        event.consume();
    }

    public void dragHand4(MouseEvent event) {
        Dragboard db = gif4.startDragAndDrop(TransferMode.ANY);
        ClipboardContent content = new ClipboardContent();
        content.putImage(gif4.getImage());
        db.setContent(content);
        whichHand = 3;
        event.consume();
    }

    public void dragHand5(MouseEvent event) {
        Dragboard db = gif5.startDragAndDrop(TransferMode.ANY);
        ClipboardContent content = new ClipboardContent();
        content.putImage(gif5.getImage());
        db.setContent(content);
        whichHand = 4;
        event.consume();
    }

    public void rect1DragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
            rect1.setId("tileWhite");
        }
    }

    public void rect1DragDropped(DragEvent event) {
        ImageView imageView = new ImageView(event.getDragboard().getImage());
        imageView.setFitHeight(KASHI);
        imageView.setFitWidth(KASHI);
        rect1.getChildren().add(Card.getCard(event.getDragboard().getString()).getImage());
        handGifs[whichHand].setImage(null);
        rect1.setId("tile");
    }


    public void rect1DragExited(DragEvent event) {
        rect1.setId("tile");
    }

    public void rect2DragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
            rect2.setId("tileWhite");
        }
    }

    public void rect2DragDropped(DragEvent event) {
        ImageView imageView = new ImageView(event.getDragboard().getImage());
        imageView.setFitHeight(KASHI);
        imageView.setFitWidth(KASHI);
        rect2.getChildren().add(Card.getCard(event.getDragboard().getString()).getImage());
        handGifs[whichHand].setImage(null);
        rect2.setId("tile");
    }


    public void rect2DragExited(DragEvent event) {
        rect2.setId("tile");
    }

    public void rect3DragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
            rect3.setId("tileWhite");
        }
    }

    public void rect3DragDropped(DragEvent event) {
        ImageView imageView = new ImageView(event.getDragboard().getImage());
        imageView.setFitHeight(KASHI);
        imageView.setFitWidth(KASHI);
        rect3.getChildren().add(Card.getCard(event.getDragboard().getString()).getImage());
        handGifs[whichHand].setImage(null);
        rect3.setId("tile");
    }


    public void rect3DragExited(DragEvent event) {
        rect3.setId("tile");
    }

    public void rect4DragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
            rect4.setId("tileWhite");
        }
    }

    public void rect4DragDropped(DragEvent event) {
        ImageView imageView = new ImageView(event.getDragboard().getImage());
        imageView.setFitHeight(KASHI);
        imageView.setFitWidth(KASHI);
        rect4.getChildren().add(Card.getCard(event.getDragboard().getString()).getImage());
        handGifs[whichHand].setImage(null);
        rect4.setId("tile");
    }


    public void rect4DragExited(DragEvent event) {
        rect4.setId("tile");
    }

    public void rect5DragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
            rect5.setId("tileWhite");
        }
    }

    public void rect5DragDropped(DragEvent event) {
        ImageView imageView = new ImageView(event.getDragboard().getImage());
        imageView.setFitHeight(KASHI);
        imageView.setFitWidth(KASHI);
        rect5.getChildren().add(Card.getCard(event.getDragboard().getString()).getImage());
        handGifs[whichHand].setImage(null);
        rect5.setId("tile");
    }

    public void rect5DragExited(DragEvent event) {
        rect5.setId("tile");
    }

    public void rect6DragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
            rect6.setId("tileWhite");
        }
    }

    public void rect6DragDropped(DragEvent event) {
        ImageView imageView = new ImageView(event.getDragboard().getImage());
        imageView.setFitHeight(KASHI);
        imageView.setFitWidth(KASHI);
        rect6.getChildren().add(Card.getCard(event.getDragboard().getString()).getImage());
        handGifs[whichHand].setImage(null);
        rect6.setId("tile");
    }


    public void rect6DragExited(DragEvent event) {
        rect6.setId("tile");
    }

    public void rect7DragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
            rect7.setId("tileWhite");
        }
    }

    public void rect7DragDropped(DragEvent event) {
        ImageView imageView = new ImageView(event.getDragboard().getImage());
        imageView.setFitHeight(KASHI);
        imageView.setFitWidth(KASHI);
        rect7.getChildren().add(Card.getCard(event.getDragboard().getString()).getImage());
        handGifs[whichHand].setImage(null);
        rect7.setId("tile");
    }


    public void rect7DragExited(DragEvent event) {
        rect7.setId("tile");
    }

    public void rect8DragExited(DragEvent event) {
        rect8.setId("tile");
    }

    public void rect8DragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
            rect8.setId("tileWhite");
        }
    }

    public void rect8DragDropped(DragEvent event) {
        ImageView imageView = new ImageView(event.getDragboard().getImage());
        imageView.setFitHeight(KASHI);
        imageView.setFitWidth(KASHI);
        rect8.getChildren().add(Card.getCard(event.getDragboard().getString()).getImage());
        handGifs[whichHand].setImage(null);
        rect8.setId("tile");
    }

    public void rect9DragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
            rect9.setId("tileWhite");
        }
    }

    public void rect9DragDropped(DragEvent event) {
        ImageView imageView = new ImageView(event.getDragboard().getImage());
        imageView.setFitHeight(KASHI);
        imageView.setFitWidth(KASHI);
        rect9.getChildren().add(Card.getCard(event.getDragboard().getString()).getImage());
        handGifs[whichHand].setImage(null);
        rect9.setId("tile");
    }


    public void rect9DragExited(DragEvent event) {
        rect9.setId("tile");
    }

    public void rect10DragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
            rect10.setId("tileWhite");
        }
    }

    public void rect10DragDropped(DragEvent event) {
        ImageView imageView = new ImageView(event.getDragboard().getImage());
        imageView.setFitHeight(KASHI);
        imageView.setFitWidth(KASHI);
        rect10.getChildren().add(Card.getCard(event.getDragboard().getString()).getImage());
        handGifs[whichHand].setImage(null);
        rect10.setId("tile");
    }


    public void rect10DragExited(DragEvent event) {
        rect10.setId("tile");
    }

    public void rect11DragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
            rect11.setId("tileWhite");
        }
    }

    public void rect11DragDropped(DragEvent event) {
        ImageView imageView = new ImageView(event.getDragboard().getImage());
        imageView.setFitHeight(KASHI);
        imageView.setFitWidth(KASHI);
        rect11.getChildren().add(Card.getCard(event.getDragboard().getString()).getImage());
        handGifs[whichHand].setImage(null);
        rect11.setId("tile");
    }


    public void rect11DragExited(DragEvent event) {
        rect11.setId("tile");
    }

    public void rect12DragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
            rect12.setId("tileWhite");
        }
    }

    public void rect12DragDropped(DragEvent event) {
        ImageView imageView = new ImageView(event.getDragboard().getImage());
        imageView.setFitHeight(KASHI);
        imageView.setFitWidth(KASHI);
        rect12.getChildren().add(Card.getCard(event.getDragboard().getString()).getImage());
        handGifs[whichHand].setImage(null);
        rect12.setId("tile");
    }


    public void rect12DragExited(DragEvent event) {
        rect12.setId("tile");
    }

    public void rect13DragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
            rect13.setId("tileWhite");
        }
    }

    public void rect13DragDropped(DragEvent event) {
        ImageView imageView = new ImageView(event.getDragboard().getImage());
        imageView.setFitHeight(KASHI);
        imageView.setFitWidth(KASHI);
        rect13.getChildren().add(Card.getCard(event.getDragboard().getString()).getImage());
        handGifs[whichHand].setImage(null);
        rect13.setId("tile");
    }


    public void rect13DragExited(DragEvent event) {
        rect13.setId("tile");
    }

    public void rect14DragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
            rect14.setId("tileWhite");
        }
    }

    public void rect14DragDropped(DragEvent event) {
        ImageView imageView = new ImageView(event.getDragboard().getImage());
        imageView.setFitHeight(KASHI);
        imageView.setFitWidth(KASHI);
        rect14.getChildren().add(Card.getCard(event.getDragboard().getString()).getImage());
        handGifs[whichHand].setImage(null);
        rect14.setId("tile");
    }


    public void rect14DragExited(DragEvent event) {
        rect14.setId("tile");
    }

    public void rect15DragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
            rect15.setId("tileWhite");
        }
    }

    public void rect15DragDropped(DragEvent event) {
        ImageView imageView = new ImageView(event.getDragboard().getImage());
        imageView.setFitHeight(KASHI);
        imageView.setFitWidth(KASHI);
        rect15.getChildren().add(Card.getCard(event.getDragboard().getString()).getImage());
        handGifs[whichHand].setImage(null);
        rect15.setId("tile");
    }

    public void rect15DragExited(DragEvent event) {
        rect15.setId("tile");
    }

    public void rect16DragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
            rect16.setId("tileWhite");
        }
    }

    public void rect16DragDropped(DragEvent event) {
        ImageView imageView = new ImageView(event.getDragboard().getImage());
        imageView.setFitHeight(KASHI);
        imageView.setFitWidth(KASHI);
        rect16.getChildren().add(Card.getCard(event.getDragboard().getString()).getImage());
        handGifs[whichHand].setImage(null);
        rect16.setId("tile");
    }


    public void rect16DragExited(DragEvent event) {
        rect16.setId("tile");
    }

    public void rect17DragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
            rect17.setId("tileWhite");
        }
    }

    public void rect17DragDropped(DragEvent event) {
        ImageView imageView = new ImageView(event.getDragboard().getImage());
        imageView.setFitHeight(KASHI);
        imageView.setFitWidth(KASHI);
        rect17.getChildren().add(Card.getCard(event.getDragboard().getString()).getImage());
        handGifs[whichHand].setImage(null);
        rect17.setId("tile");
    }


    public void rect17DragExited(DragEvent event) {
        rect17.setId("tile");
    }

    public void rect18DragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
            rect18.setId("tileWhite");
        }
    }

    public void rect18DragDropped(DragEvent event) {
        ImageView imageView = new ImageView(event.getDragboard().getImage());
        imageView.setFitHeight(KASHI);
        imageView.setFitWidth(KASHI);
        rect18.getChildren().add(Card.getCard(event.getDragboard().getString()).getImage());
        handGifs[whichHand].setImage(null);
        rect18.setId("tile");
    }

    public void rect18DragExited(DragEvent event) {
        rect18.setId("tile");
    }

    public void rect19DragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
            rect19.setId("tileWhite");
        }
    }

    public void rect19DragDropped(DragEvent event) {
        ImageView imageView = new ImageView(event.getDragboard().getImage());
        imageView.setFitHeight(KASHI);
        imageView.setFitWidth(KASHI);
        rect19.getChildren().add(Card.getCard(event.getDragboard().getString()).getImage());
        handGifs[whichHand].setImage(null);
        rect19.setId("tile");
    }


    public void rect19DragExited(DragEvent event) {
        rect19.setId("tile");
    }

    public void rect20DragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
            rect20.setId("tileWhite");
        }
    }

    public void rect20DragDropped(DragEvent event) {
        ImageView imageView = new ImageView(event.getDragboard().getImage());
        imageView.setFitHeight(KASHI);
        imageView.setFitWidth(KASHI);
        rect20.getChildren().add(Card.getCard(event.getDragboard().getString()).getImage());
        handGifs[whichHand].setImage(null);
        rect20.setId("tile");
    }


    public void rect20DragExited(DragEvent event) {
        rect20.setId("tile");
    }

    public void rect21DragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
            rect21.setId("tileWhite");
        }
    }

    public void rect21DragDropped(DragEvent event) {
        ImageView imageView = new ImageView(event.getDragboard().getImage());
        imageView.setFitHeight(KASHI);
        imageView.setFitWidth(KASHI);
        rect21.getChildren().add(Card.getCard(event.getDragboard().getString()).getImage());
        handGifs[whichHand].setImage(null);
        rect21.setId("tile");
    }


    public void rect21DragExited(DragEvent event) {
        rect21.setId("tile");
    }

    public void rect22DragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
            rect22.setId("tileWhite");
        }
    }

    public void rect22DragDropped(DragEvent event) {
        ImageView imageView = new ImageView(event.getDragboard().getImage());
        imageView.setFitHeight(KASHI);
        imageView.setFitWidth(KASHI);
        rect22.getChildren().add(Card.getCard(event.getDragboard().getString()).getImage());
        handGifs[whichHand].setImage(null);
        rect22.setId("tile");
    }


    public void rect22DragExited(DragEvent event) {
        rect22.setId("tile");
    }

    public void rect23DragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
            rect23.setId("tileWhite");
        }
    }

    public void rect23DragDropped(DragEvent event) {
        ImageView imageView = new ImageView(event.getDragboard().getImage());
        imageView.setFitHeight(KASHI);
        imageView.setFitWidth(KASHI);
        rect23.getChildren().add(Card.getCard(event.getDragboard().getString()).getImage());
        handGifs[whichHand].setImage(null);
        rect23.setId("tile");
    }


    public void rect23DragExited(DragEvent event) {
        rect23.setId("tile");
    }

    public void rect24DragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
            rect24.setId("tileWhite");
        }
    }

    public void rect24DragDropped(DragEvent event) {
        ImageView imageView = new ImageView(event.getDragboard().getImage());
        imageView.setFitHeight(KASHI);
        imageView.setFitWidth(KASHI);
        rect24.getChildren().add(Card.getCard(event.getDragboard().getString()).getImage());
        handGifs[whichHand].setImage(null);
        rect24.setId("tile");
    }


    public void rect24DragExited(DragEvent event) {
        rect24.setId("tile");
    }

    public void rect25DragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
            rect25.setId("tileWhite");
        }
    }

    public void rect25DragDropped(DragEvent event) {
        ImageView imageView = new ImageView(event.getDragboard().getImage());
        imageView.setFitHeight(KASHI);
        imageView.setFitWidth(KASHI);
        rect25.getChildren().add(Card.getCard(event.getDragboard().getString()).getImage());
        handGifs[whichHand].setImage(null);
        rect25.setId("tile");
    }

    public void rect25DragExited(DragEvent event) {
        rect25.setId("tile");
    }

    public void rect26DragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
            rect26.setId("tileWhite");
        }
    }

    public void rect26DragDropped(DragEvent event) {
        ImageView imageView = new ImageView(event.getDragboard().getImage());
        imageView.setFitHeight(KASHI);
        imageView.setFitWidth(KASHI);
        rect26.getChildren().add(Card.getCard(event.getDragboard().getString()).getImage());
        handGifs[whichHand].setImage(null);
        rect26.setId("tile");
    }


    public void rect26DragExited(DragEvent event) {
        rect26.setId("tile");
    }

    public void rect27DragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
            rect27.setId("tileWhite");
        }
    }

    public void rect27DragDropped(DragEvent event) {
        ImageView imageView = new ImageView(event.getDragboard().getImage());
        imageView.setFitHeight(KASHI);
        imageView.setFitWidth(KASHI);
        rect27.getChildren().add(Card.getCard(event.getDragboard().getString()).getImage());
        handGifs[whichHand].setImage(null);
        rect27.setId("tile");
    }


    public void rect27DragExited(DragEvent event) {
        rect27.setId("tile");
    }

    public void rect28DragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
            rect28.setId("tileWhite");
        }
    }

    public void rect28DragDropped(DragEvent event) {
        ImageView imageView = new ImageView(event.getDragboard().getImage());
        imageView.setFitHeight(KASHI);
        imageView.setFitWidth(KASHI);
        rect28.getChildren().add(Card.getCard(event.getDragboard().getString()).getImage());
        handGifs[whichHand].setImage(null);
        rect28.setId("tile");
    }

    public void rect28DragExited(DragEvent event) {
        rect28.setId("tile");
    }

    public void rect29DragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
            rect29.setId("tileWhite");
        }
    }

    public void rect29DragDropped(DragEvent event) {
        ImageView imageView = new ImageView(event.getDragboard().getImage());
        imageView.setFitHeight(KASHI);
        imageView.setFitWidth(KASHI);
        rect29.getChildren().add(Card.getCard(event.getDragboard().getString()).getImage());
        handGifs[whichHand].setImage(null);
        rect29.setId("tile");
    }


    public void rect29DragExited(DragEvent event) {
        rect29.setId("tile");
    }

    public void rect30DragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
            rect30.setId("tileWhite");
        }
    }

    public void rect30DragDropped(DragEvent event) {
        ImageView imageView = new ImageView(event.getDragboard().getImage());
        imageView.setFitHeight(KASHI);
        imageView.setFitWidth(KASHI);
        rect30.getChildren().add(Card.getCard(event.getDragboard().getString()).getImage());
        handGifs[whichHand].setImage(null);
        rect30.setId("tile");
    }


    public void rect30DragExited(DragEvent event) {
        rect30.setId("tile");
    }

    public void rect31DragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
            rect31.setId("tileWhite");
        }
    }

    public void rect31DragDropped(DragEvent event) {
        ImageView imageView = new ImageView(event.getDragboard().getImage());
        imageView.setFitHeight(KASHI);
        imageView.setFitWidth(KASHI);
        rect31.getChildren().add(Card.getCard(event.getDragboard().getString()).getImage());
        handGifs[whichHand].setImage(null);
        rect31.setId("tile");
    }


    public void rect31DragExited(DragEvent event) {
        rect31.setId("tile");
    }

    public void rect32DragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
            rect32.setId("tileWhite");
        }
    }

    public void rect32DragDropped(DragEvent event) {
        ImageView imageView = new ImageView(event.getDragboard().getImage());
        imageView.setFitHeight(KASHI);
        imageView.setFitWidth(KASHI);
        rect32.getChildren().add(Card.getCard(event.getDragboard().getString()).getImage());
        handGifs[whichHand].setImage(null);
        rect32.setId("tile");
    }


    public void rect32DragExited(DragEvent event) {
        rect32.setId("tile");
    }

    public void rect33DragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
            rect33.setId("tileWhite");
        }
    }

    public void rect33DragDropped(DragEvent event) {
        ImageView imageView = new ImageView(event.getDragboard().getImage());
        imageView.setFitHeight(KASHI);
        imageView.setFitWidth(KASHI);
        rect33.getChildren().add(Card.getCard(event.getDragboard().getString()).getImage());
        handGifs[whichHand].setImage(null);
        rect33.setId("tile");
    }


    public void rect33DragExited(DragEvent event) {
        rect33.setId("tile");
    }

    public void rect34DragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
            rect34.setId("tileWhite");
        }
    }

    public void rect34DragDropped(DragEvent event) {
        ImageView imageView = new ImageView(event.getDragboard().getImage());
        imageView.setFitHeight(KASHI);
        imageView.setFitWidth(KASHI);
        rect34.getChildren().add(Card.getCard(event.getDragboard().getString()).getImage());
        handGifs[whichHand].setImage(null);
        rect34.setId("tile");
    }


    public void rect34DragExited(DragEvent event) {
        rect34.setId("tile");
    }

    public void rect35DragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
            rect35.setId("tileWhite");
        }
    }

    public void rect35DragDropped(DragEvent event) {
        ImageView imageView = new ImageView(event.getDragboard().getImage());
        imageView.setFitHeight(KASHI);
        imageView.setFitWidth(KASHI);
        rect35.getChildren().add(Card.getCard(event.getDragboard().getString()).getImage());
        handGifs[whichHand].setImage(null);
        rect35.setId("tile");
    }

    public void rect35DragExited(DragEvent event) {
        rect35.setId("tile");
    }

    public void rect36DragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
            rect36.setId("tileWhite");
        }
    }

    public void rect36DragDropped(DragEvent event) {
        ImageView imageView = new ImageView(event.getDragboard().getImage());
        imageView.setFitHeight(KASHI);
        imageView.setFitWidth(KASHI);
        rect36.getChildren().add(Card.getCard(event.getDragboard().getString()).getImage());
        handGifs[whichHand].setImage(null);
        rect36.setId("tile");
    }


    public void rect36DragExited(DragEvent event) {
        rect36.setId("tile");
    }

    public void rect37DragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
            rect37.setId("tileWhite");
        }
    }

    public void rect37DragDropped(DragEvent event) {
        ImageView imageView = new ImageView(event.getDragboard().getImage());
        imageView.setFitHeight(KASHI);
        imageView.setFitWidth(KASHI);
        rect37.getChildren().add(Card.getCard(event.getDragboard().getString()).getImage());
        handGifs[whichHand].setImage(null);
        rect37.setId("tile");
    }


    public void rect37DragExited(DragEvent event) {
        rect37.setId("tile");
    }

    public void rect38DragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
            rect38.setId("tileWhite");
        }
    }

    public void rect38DragDropped(DragEvent event) {
        ImageView imageView = new ImageView(event.getDragboard().getImage());
        imageView.setFitHeight(KASHI);
        imageView.setFitWidth(KASHI);
        rect38.getChildren().add(Card.getCard(event.getDragboard().getString()).getImage());
        handGifs[whichHand].setImage(null);
        rect38.setId("tile");
    }

    public void rect38DragExited(DragEvent event) {
        rect38.setId("tile");
    }

    public void rect39DragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
            rect39.setId("tileWhite");
        }
    }

    public void rect39DragDropped(DragEvent event) {
        ImageView imageView = new ImageView(event.getDragboard().getImage());
        imageView.setFitHeight(KASHI);
        imageView.setFitWidth(KASHI);
        rect39.getChildren().add(Card.getCard(event.getDragboard().getString()).getImage());
        handGifs[whichHand].setImage(null);
        rect39.setId("tile");
    }


    public void rect39DragExited(DragEvent event) {
        rect39.setId("tile");
    }

    public void rect40DragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
            rect40.setId("tileWhite");
        }
    }

    public void rect40DragDropped(DragEvent event) {
        ImageView imageView = new ImageView(event.getDragboard().getImage());
        imageView.setFitHeight(KASHI);
        imageView.setFitWidth(KASHI);
        rect40.getChildren().add(Card.getCard(event.getDragboard().getString()).getImage());
        handGifs[whichHand].setImage(null);
        rect40.setId("tile");
    }


    public void rect40DragExited(DragEvent event) {
        rect40.setId("tile");
    }

    public void rect41DragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
            rect41.setId("tileWhite");
        }
    }

    public void rect41DragDropped(DragEvent event) {
        ImageView imageView = new ImageView(event.getDragboard().getImage());
        imageView.setFitHeight(KASHI);
        imageView.setFitWidth(KASHI);
        rect41.getChildren().add(Card.getCard(event.getDragboard().getString()).getImage());
        handGifs[whichHand].setImage(null);
        rect41.setId("tile");
    }


    public void rect41DragExited(DragEvent event) {
        rect41.setId("tile");
    }

    public void rect42DragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
            rect42.setId("tileWhite");
        }
    }

    public void rect42DragDropped(DragEvent event) {
        ImageView imageView = new ImageView(event.getDragboard().getImage());
        imageView.setFitHeight(KASHI);
        imageView.setFitWidth(KASHI);
        rect42.getChildren().add(Card.getCard(event.getDragboard().getString()).getImage());
        handGifs[whichHand].setImage(null);
        rect42.setId("tile");
    }


    public void rect42DragExited(DragEvent event) {
        rect42.setId("tile");
    }

    public void rect43DragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
            rect43.setId("tileWhite");
        }
    }

    public void rect43DragDropped(DragEvent event) {
        ImageView imageView = new ImageView(event.getDragboard().getImage());
        imageView.setFitHeight(KASHI);
        imageView.setFitWidth(KASHI);
        rect43.getChildren().add(Card.getCard(event.getDragboard().getString()).getImage());
        handGifs[whichHand].setImage(null);
        rect43.setId("tile");
    }


    public void rect43DragExited(DragEvent event) {
        rect43.setId("tile");
    }

    public void rect44DragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
            rect44.setId("tileWhite");
        }
    }

    public void rect44DragDropped(DragEvent event) {
        ImageView imageView = new ImageView(event.getDragboard().getImage());
        imageView.setFitHeight(KASHI);
        imageView.setFitWidth(KASHI);
        rect44.getChildren().add(Card.getCard(event.getDragboard().getString()).getImage());
        handGifs[whichHand].setImage(null);
        rect44.setId("tile");
    }


    public void rect44DragExited(DragEvent event) {
        rect44.setId("tile");
    }

    public void rect45DragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
            rect45.setId("tileWhite");
        }
    }

    public void rect45DragDropped(DragEvent event) {
        ImageView imageView = new ImageView();
        imageView.setFitHeight(KASHI);
        imageView.setFitWidth(KASHI);
        rect45.getChildren().add(Card.getCard(event.getDragboard().getString()).getImage());
        handGifs[whichHand].setImage(null);
        rect45.setId("tile");
    }

    public void rect45DragExited(DragEvent event) {
        rect45.setId("tile");
    }
}


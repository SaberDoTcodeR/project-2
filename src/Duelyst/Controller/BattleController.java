package Duelyst.Controller;

import Duelyst.View.View;
import Duelyst.model.Card.Hero.Hero;
import Duelyst.model.Card.Minion.Minion;
import Duelyst.model.Cell;
import Duelyst.model.ErrorType;
import Duelyst.model.Card.Spell.Spell;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.events.JFXDialogEvent;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.util.Duration;


import Duelyst.model.Account;
import Duelyst.model.Battle.Battle;
import Duelyst.model.Battle.FlagsBattle;
import Duelyst.model.Battle.HeroBattle;
import Duelyst.model.Battle.OneFlagBattle;
import Duelyst.model.Card.Card;

import java.util.ArrayList;


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
    public GridPane gridPane;
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
    public ImageView profile;
    public Label accountInfo;
    public StackPane stackPane;

    int whichHand = -1;
    int whichRect = -1;
    static Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
    static final double KASHI = primaryScreenBounds.getWidth() * 7 / 100;


    Pane[] rectangles = new Pane[45];

    Card card1;
    Card card2;
    Card card3;
    Card card4;
    Card card5;
    Card[] cardsOfHand = new Card[5];

    public void mainMenuAct() {
        View.makeMainMenu();
    }

    public ErrorType insertCard(String cardName, int rect, boolean ai) {
        int xPos = (rect - 1) / 9 + 1;
        int yPos = ((rect - 1) % 9) + 1;
        Account account;
        if (currentBattle.getTurn() % 2 == 1)
            account = currentBattle.getFirstPlayer();
        else
            account = currentBattle.getSecondPlayer();
        ArrayList<Card> cards;
        if (currentBattle.getTurn() % 2 == 1)
            cards = currentBattle.getFirstPlayerHand().getCards();
        else
            cards = currentBattle.getSecondPlayerHand().getCards();
        for (Card card1 : cards) {
            if (cardName.equals(card1.getName())) {
                int cost = 0;
                if (card1.getType().equals("Spell")) {
                    Spell spell = (Spell) card1;
                    cost = spell.getCostToUse();
                }
                if (card1.getType().equals("Minion")) {
                    Minion minion = (Minion) card1;
                    cost = minion.getCostToUse();
                }
                if (cost > account.getMana()) {
                    return ErrorType.DONT_HAVE_ENOUGH_MANA;
                } else {
                    if (card1.getType().equals("Minion")) {

                        if (currentBattle.getMap().get(xPos - 1).get(yPos - 1).getMinion() == null &&
                                currentBattle.getMap().get(xPos - 1).get(yPos - 1).getHero() == null) {
                            ArrayList<Cell> targetCells = new ArrayList<>();
                            if (xPos - 2 >= 0)
                                targetCells.add(currentBattle.getMap().get(xPos - 2).get(yPos - 1));
                            if (xPos < 5)
                                targetCells.add(currentBattle.getMap().get(xPos).get(yPos - 1));
                            if (yPos - 2 >= 0)
                                targetCells.add(currentBattle.getMap().get(xPos - 1).get(yPos - 2));
                            if (yPos < 9) {
                                targetCells.add(currentBattle.getMap().get(xPos - 1).get(yPos));
                            }
                            if (xPos - 2 >= 0 && yPos - 2 >= 0)
                                targetCells.add(currentBattle.getMap().get(xPos - 2).get(yPos - 2));
                            if (xPos < 5 && yPos - 2 >= 0)
                                targetCells.add(currentBattle.getMap().get(xPos).get(yPos - 2));
                            if (xPos - 2 >= 0 && yPos < 9)
                                targetCells.add(currentBattle.getMap().get(xPos - 2).get(yPos));
                            if (xPos < 5 && yPos < 9)
                                targetCells.add(currentBattle.getMap().get(xPos).get(yPos));

                            boolean adjacency = false;
                            for (Cell cell : targetCells) {
                                if (cell.getMinion() != null && cell.getMinion().getCardId().toLowerCase().contains(account.getUserName().toLowerCase())) {
                                    System.out.println("here1");
                                    adjacency = true;
                                    break;
                                }
                                if (cell.getHero() != null && cell.getHero().getCardId().toLowerCase().contains(account.getUserName().toLowerCase())) {
                                    adjacency = true;
                                    break;
                                }
                            }
                            if (!adjacency) {
                                return ErrorType.INVALID_TARGET;
                            }
                            //if (currentBattle.getMap().get(xPos - 1).get(yPos - 1).getNumberOfFlag() > 0) {
                            //  ((Minion) card1).setNumberOfFlag(((Minion) card1).getNumberOfFlag() + currentBattle.getMap().get(xPos - 1).get(yPos - 1).getNumberOfFlag());
                            //currentBattle.getMap().get(xPos - 1).get(yPos - 1).setNumberOfFlag(0);
                            //}

                            account.setMana(account.getMana() - cost);
                            System.out.println(account.getMana() + " " + cost);
                            ((Minion) card1).moveToGame(currentBattle, xPos, yPos);
                            if (currentBattle.getMap().get(xPos - 1).get(yPos - 1).getCollectibleItem() != null) {
                                Cell.addCollectible(xPos, yPos, currentBattle);
                            }
                            ImageView imageView = new ImageView(Card.getCard(cardName).getImage());
                            imageView.setFitHeight(KASHI);
                            imageView.setFitWidth(KASHI);
                            rectangles[rect - 1].getChildren().add(imageView);
                            if (currentBattle.getTurn() % 2 == 1 && currentBattle.getFirstPlayerDeck().getUsableItem().get(0) != null)
                                currentBattle.getFirstPlayerDeck().getUsableItem().get(0).applyEffect(currentBattle, null, currentBattle.getFirstPlayer(), 0);
                            else if (currentBattle.getTurn() % 2 == 0 && currentBattle.getSecondPlayerDeck().getUsableItem().get(0) != null)
                                currentBattle.getSecondPlayerDeck().getUsableItem().get(0).applyEffect(currentBattle, null, currentBattle.getSecondPlayer(), 0);
                            cards.remove(card1);
                            if (!ai) {
                                updateProfile();
                                handGifs[whichHand].setImage(null);
                                cardsOfHand[whichHand] = null;
                            }
                            return ErrorType.SUCCESSFUL_INSERT;
                        } else {
                            return ErrorType.INVALID_TARGET;
                        }
                    } else {
                        // ((Spell) card1).castSpell(currentBattle, currentBattle.getMap().get(xPos - 1).get(yPos - 1), account, request);
                        account.setMana(account.getMana() - cost);
                        cards.remove(card1);
                        if (!ai) {
                            updateProfile();
                            handGifs[whichHand].setImage(null);
                            cardsOfHand[whichHand] = null;
                        }
                        return ErrorType.SUCCESSFUL_INSERT;

                    }
                }

            }
        }
        return null;
    }

    private void showDialog(ErrorType errorType) {
        if (errorType != null) {
            BoxBlur blur = new BoxBlur(5, 5, 10);
            JFXDialogLayout jfxDialogLayout = new JFXDialogLayout();
            JFXButton jfxButton = new JFXButton("OK");
            jfxDialogLayout.setStyle(" -fx-background-color: rgba(0, 0, 0, 0.3);");
            JFXDialog jfxDialog = new JFXDialog(stackPane, jfxDialogLayout, JFXDialog.DialogTransition.TOP);
            jfxButton.getStyleClass().add("dialog-button");
            jfxButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent) -> {
                        jfxDialog.close();
                    }
            );
            jfxDialog.setOnDialogClosed((JFXDialogEvent jfxEvent) -> {
                gridPane.setEffect(null);
            });
            Label label = new Label(errorType.getMessage());
            label.getStyleClass().add("label3");
            jfxDialogLayout.setBody(label);
            jfxDialogLayout.setActions(jfxButton);
            jfxDialog.show();
            gridPane.setEffect(blur);
        } else
            System.out.println("null");
    }

    public void handleHand() {
        currentBattle.getFirstPlayerHand().fillHand(currentBattle, 0);
        for (Card card : currentBattle.getFirstPlayerHand().getCards()) {
            showHand(card, false);
        }
        card1 = currentBattle.getFirstPlayerHand().getCards().get(0);
        card2 = currentBattle.getFirstPlayerHand().getCards().get(1);
        card3 = currentBattle.getFirstPlayerHand().getCards().get(2);
        card4 = currentBattle.getFirstPlayerHand().getCards().get(3);
        card5 = currentBattle.getFirstPlayerHand().getCards().get(4);
        cardsOfHand[0] = card1;
        cardsOfHand[1] = card2;
        cardsOfHand[2] = card3;
        cardsOfHand[3] = card4;
        cardsOfHand[4] = card5;
        showHand(currentBattle.getFirstPlayerHand().getNextCardInHand(), true);
        currentBattle.getSecondPlayerHand().fillHand(currentBattle, 1);
    }

    private void showHand(Card cardInHand, boolean nextCard) {
        if (nextCard) {
            gif6.setImage(cardInHand.getImage());
            return;
        }
        for (ImageView imageView : handGifs) {
            if (imageView.getImage() == null) {
                imageView.setImage(cardInHand.getImage());
                return;
            }
        }
    }

    public ErrorType moveSelectedCard(int rect) {
        int xPos = (rect - 1) / 9;
        int yPos = (rect - 1) % 9;
        if (currentBattle.getSelectedCard() == null) {
            return ErrorType.NO_CARD_SELECTED;
        }
        if (currentBattle.getSelectedCard().getType().equals("Minion") && ((Minion) currentBattle.getSelectedCard()).isStunning()) {
            return ErrorType.CARD_IS_STUNNED;
        }
        if (currentBattle.getSelectedCard().getType().equals("Hero") && ((Hero) currentBattle.getSelectedCard()).isStunning()) {
            return ErrorType.CARD_IS_STUNNED;
        }
        Cell srcCell = currentBattle.getMap().get(0).get(0).getCellOfCard(currentBattle.getSelectedCard(), currentBattle);//actually is static
        Cell destCell = currentBattle.getMap().get(xPos).get(yPos);
        if (srcCell.manhataniDistance(xPos + 1, yPos + 1) > currentBattle.getSelectedCard().getRemainedMoves()) {
            return ErrorType.TOO_EXHAUSTED;

        }
        if (destCell.getHero() == null && destCell.getMinion() == null) {
            srcCell.moveCardPos(xPos + 1, yPos + 1, currentBattle);
            currentBattle.getSelectedCard().setRemainedMoves(currentBattle.getSelectedCard().getRemainedMoves()
                    - srcCell.manhataniDistance(xPos + 1, yPos + 1));
            ImageView imageView = new ImageView(Card.getCard(currentBattle.getSelectedCard().getName()).getImage());
            imageView.setFitHeight(KASHI);
            imageView.setFitWidth(KASHI);
            rectangles[rect - 1].getChildren().add(imageView);
            /*if (destCell.getNumberOfFlag() > 0) {
                if (currentBattle.getSelectedCard().getType().equals("Minion"))
                    ((Minion) currentBattle.getSelectedCard()).setNumberOfFlag(((Minion) currentBattle.getSelectedCard()).getNumberOfFlag() + currentBattle.getMap().get(xPos - 1).get(yPos - 1).getNumberOfFlag());
                else
                    ((Hero) currentBattle.getSelectedCard()).setNumberOfFlag(((Hero) currentBattle.getSelectedCard()).getNumberOfFlag() + currentBattle.getMap().get(xPos - 1).get(yPos - 1).getNumberOfFlag());

                cell2.setNumberOfFlag(0);
            }*/
            if (currentBattle.getMap().get(xPos).get(yPos).getCollectibleItem() != null)
                Cell.addCollectible(xPos + 1, yPos + 1, currentBattle);
            updateProfile();
            rectangles[whichRect].getChildren().clear();
            return ErrorType.SUCCESSFUL_MOVE;
        } else
            return ErrorType.INVALID_TARGET;

    }

    private void updateProfile() {
        accountInfo.setText(Account.getLoginAccount().getUserName() + "\n" + "MANA :" + currentBattle.getFirstPlayer().getMana());

    }

    public void handleTurn() {

        currentBattle.increamentTurn();
        currentBattle.getFirstPlayer().setMana(currentBattle.getTurn() / 2 + 2);
        currentBattle.getSecondPlayer().setMana(currentBattle.getTurn() / 2 + 2);
        updateProfile();
        if (currentBattle.getTurn() % 2 == 1)
            handleHand();
        if (currentBattle.getTurn() % 2 == 0)
            doCleverThings();
        if (currentBattle.getTurn() == 1 && currentBattle.getFirstPlayerDeck().getUsableItem() != null)
            currentBattle.getFirstPlayerDeck().getUsableItem().get(0).applyEffect(currentBattle, null, currentBattle.getFirstPlayer(), -1);
        if (currentBattle.getTurn() == 1 && currentBattle.getSecondPlayerDeck().getUsableItem() != null)
            currentBattle.getSecondPlayerDeck().getUsableItem().get(0).applyEffect(currentBattle, null, currentBattle.getSecondPlayer(), -1);
        if (currentBattle.getTurn() % 2 == 0)
            handleTurn();
    }

    public void doCleverThings() {
        outer:
        for (Card card : currentBattle.getSecondPlayerHand().getCards()) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 9; j++) {
                    //String str = "insert " + card.getName() + " in (" + (i + 1) + "," + (j + 1) + ")";
                    if (insertCard(card.getName(), 9 * i + j+1,true).getMessage().equals("OK")) {
                        break outer;
                    }
                }
            }
        }
        /*outer:
        for (Card card : currentBattle.getSecondPlayerInGameCards()) {
            currentBattle.setSelectedCard(card);
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 9; j++) {
                    //String str = "move to (" + (i + 1) + "," + (j + 1) + ")";
                    if (moveSelectedCard(9 * i + j).getMessage().equals("OK")) {
                        break outer;
                    }
                }
            }
        }*/
        /*label3:
        for (Card card : currentBattle.getSecondPlayerInGameCards()) {
            currentBattle.setSelectedCard(card);
            for (Card card1 : currentBattle.getFirstPlayerInGameCards()) {
                String str = "attack " + card1.getCardId();
                request.setCommand(str);
                Command command = request.getMatchedCommand(2 - 1);
                command.apply(request);
                if (request.getError() == null) {
                    hasAttack = true;
                    System.out.println("Attack performed on " + card1.getCardId());
                    break label3;
                }
            }
        }
        if (!hasAttack) {
            System.out.println("fuuuuuuuuu*k ::::((( I can't attack to any card ...");
        }*/
    }

    public void setProfile(Image imagePro) {
        accountInfo.setText(Account.getLoginAccount().getUserName() + "\n" + "MANA :" + currentBattle.getFirstPlayer().getMana());
        accountInfo.setGraphicTextGap(10);
        profile.setImage(imagePro);
        Rectangle clip = new Rectangle(
                profile.getFitWidth(), profile.getFitHeight()
        );
        clip.setArcWidth(20);
        clip.setArcHeight(20);
        profile.setClip(clip);
        SnapshotParameters parameters = new SnapshotParameters();
        parameters.setFill(Color.TRANSPARENT);
        WritableImage image = profile.snapshot(parameters, null);
        profile.setClip(null);
        profile.setEffect(new DropShadow(20, Color.BLACK));
        profile.setImage(image);
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
        currentBattle.getFirstPlayer().setMana(currentBattle.getTurn() / 2 + 2);
        setProfile(Account.getLoginAccount().getAvatar());

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
        ImageView imageView = new ImageView(currentBattle.getFirstPlayer().getMainDeck().getHero().get(0).getImage());
        imageView.setFitHeight(KASHI);
        imageView.setFitWidth(KASHI);
        rect19.getChildren().add(imageView);
        ImageView imageView1 = new ImageView(currentBattle.getSecondPlayer().getMainDeck().getHero().get(0).getImage());
        imageView1.setFitHeight(KASHI);
        imageView1.setFitWidth(KASHI);
        rect27.getChildren().add(imageView1);
        currentBattle.getFirstPlayerInGameCards().add(currentBattle.getFirstPlayer().getMainDeck().getHero().get(0));
        currentBattle.getMap().get(2).get(0).setHero(currentBattle.getFirstPlayer().getMainDeck().getHero().get(0), 0);
        currentBattle.getSecondPlayerInGameCards().add(currentBattle.getSecondPlayer().getMainDeck().getHero().get(0));
        currentBattle.getMap().get(2).get(8).setHero(currentBattle.getSecondPlayer().getMainDeck().getHero().get(0), 1);

        currentBattle.getFirstPlayer().getMainDeck().getHero().get(0).cardIdGenerator(currentBattle);
        currentBattle.increamentTurn();

        currentBattle.getSecondPlayer().getMainDeck().getHero().get(0).cardIdGenerator(currentBattle);
        currentBattle.decreamentTurn();
    }


    public void enterHand1() {
        RotateTransition rotate = new RotateTransition(Duration.millis(4000), image1);
        rotate.setFromAngle(image1.getRotate());
        rotate.setToAngle(image1.getRotate() + 360);
        rotate.setCycleCount(Animation.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.play();
        gif1.setOnMouseExited(event1 -> rotate.stop());
        image1.setOnMouseExited(event -> rotate.stop());
    }

    public void enterHand2() {
        RotateTransition rotate = new RotateTransition(Duration.millis(4000), image2);
        rotate.setFromAngle(image2.getRotate());
        rotate.setToAngle(image2.getRotate() + 360);
        rotate.setCycleCount(Animation.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.play();
        gif2.setOnMouseExited(event -> rotate.stop());
        image2.setOnMouseExited(event -> rotate.stop());
    }

    public void enterHand3() {
        RotateTransition rotate = new RotateTransition(Duration.millis(4000), image3);
        rotate.setFromAngle(image3.getRotate());
        rotate.setToAngle(image3.getRotate() + 360);
        rotate.setCycleCount(Animation.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.play();
        gif3.setOnMouseExited(event -> rotate.stop());
        image3.setOnMouseExited(event -> rotate.stop());
    }

    public void enterHand4(MouseEvent event) {
        RotateTransition rotate = new RotateTransition(Duration.millis(4000), image4);
        rotate.setFromAngle(image4.getRotate());
        rotate.setToAngle(image4.getRotate() + 360);
        rotate.setCycleCount(Animation.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.play();
        gif4.setOnMouseExited(event1 -> rotate.stop());
        image4.setOnMouseExited(event12 -> rotate.stop());
    }

    public void enterHand5() {
        RotateTransition rotate = new RotateTransition(Duration.millis(4000), image5);
        rotate.setFromAngle(image5.getRotate());
        rotate.setToAngle(image5.getRotate() + 360);
        rotate.setCycleCount(Animation.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.play();
        gif5.setOnMouseExited(event1 -> rotate.stop());
        image5.setOnMouseExited(event -> rotate.stop());
    }

    public void dragHand1(MouseEvent event) {
        if (gif1.getImage() != null && card1 != null) {
            Dragboard db = gif1.startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putImage(gif1.getImage());
            content.putString(card1.getName());
            db.setContent(content);
            whichHand = 0;
            event.consume();
        }
    }

    public void dragHand2(MouseEvent event) {
        if (gif2.getImage() != null && card2 != null) {
            Dragboard db = gif2.startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putImage(gif2.getImage());
            content.putString(card2.getName());
            db.setContent(content);
            whichHand = 1;
            event.consume();
        }
    }

    public void dragHand3(MouseEvent event) {
        if (gif3.getImage() != null && card3 != null) {
            Dragboard db = gif3.startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putImage(gif3.getImage());
            content.putString(card3.getName());
            db.setContent(content);
            whichHand = 2;
            event.consume();
        }
    }

    public void dragHand4(MouseEvent event) {
        if (gif4.getImage() != null && card4 != null) {
            Dragboard db = gif4.startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putImage(gif4.getImage());
            content.putString(card4.getName());
            db.setContent(content);
            whichHand = 3;
            event.consume();
        }
    }

    public void dragHand5(MouseEvent event) {
        if (gif5.getImage() != null && card5 != null) {
            Dragboard db = gif5.startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putImage(gif5.getImage());
            content.putString(card5.getName());
            db.setContent(content);
            whichHand = 4;
            event.consume();
        }
    }

    public void rect1DragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
            rect1.setId("tileWhite");
        }
    }

    public void rect1DragDropped(DragEvent event) {


        int rectNum = 1;
        if (whichRect != -1) {
            showDialog(moveSelectedCard(rectNum));
            whichRect = -1;
        }
        if (whichHand != -1) {
            showDialog(insertCard(event.getDragboard().getString(), rectNum,false));
            whichHand = -1;
        }
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

        int rectNum = 2;

        if (whichRect != -1) {

            showDialog(moveSelectedCard(rectNum));
            whichRect = -1;
        }

        if (whichHand != -1) {

            showDialog(insertCard(event.getDragboard().getString(), rectNum,false));
            whichHand = -1;
        }

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
        int rectNum = 3;
        if (whichRect != -1) {

            showDialog(moveSelectedCard(rectNum));
            whichRect = -1;

        }
        if (whichHand != -1) {
            showDialog(insertCard(event.getDragboard().getString(), rectNum,false));
            whichHand = -1;
        }
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


        int rectNum = 4;

        if (whichRect != -1) {
            showDialog(moveSelectedCard(rectNum));
            whichRect = -1;
        }
        if (whichHand != -1) {
            showDialog(insertCard(event.getDragboard().getString(), rectNum,false));
            whichHand = -1;
        }
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
        int rectNum = 5;
        if (whichRect != -1) {
            showDialog(moveSelectedCard(rectNum));
            whichRect = -1;
        }
        if (whichHand != -1) {
            showDialog(insertCard(event.getDragboard().getString(), rectNum,false));
            whichHand = -1;
        }
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
        int rectNum = 6;
        if (whichRect != -1) {
            showDialog(moveSelectedCard(rectNum));
            whichRect = -1;
        }
        if (whichHand != -1) {
            showDialog(insertCard(event.getDragboard().getString(), rectNum,false));
            whichHand = -1;
        }
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
        int rectNum = 7;
        if (whichRect != -1) {
            showDialog(moveSelectedCard(rectNum));
            whichRect = -1;
        }
        if (whichHand != -1) {
            showDialog(insertCard(event.getDragboard().getString(), rectNum,false));
            whichHand = -1;
        }
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
        int rectNum = 8;
        if (whichRect != -1) {

            showDialog(moveSelectedCard(rectNum));
            whichRect = -1;
        }
        if (whichHand != -1) {
            showDialog(insertCard(event.getDragboard().getString(), rectNum,false));
            whichHand = -1;
        }
        rect8.setId("tile");
    }

    public void rect9DragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
            rect9.setId("tileWhite");
        }
    }

    public void rect9DragDropped(DragEvent event) {
        int rectNum = 9;
        if (whichRect != -1) {
            showDialog(moveSelectedCard(rectNum));
            whichRect = -1;
        }
        if (whichHand != -1) {
            showDialog(insertCard(event.getDragboard().getString(), rectNum,false));
            whichHand = -1;
        }
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
        int rectNum = 10;
        if (whichRect != -1) {
            showDialog(moveSelectedCard(rectNum));
            whichRect = -1;
        }
        if (whichHand != -1) {
            showDialog(insertCard(event.getDragboard().getString(), rectNum,false));
            whichHand = -1;
        }
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
        int rectNum = 11;
        if (whichRect != -1) {
            showDialog(moveSelectedCard(rectNum));
            whichRect = -1;
        }
        if (whichHand != -1) {
            showDialog(insertCard(event.getDragboard().getString(), rectNum,false));
            whichHand = -1;
        }
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
        int rectNum = 12;
        if (whichRect != -1) {
            showDialog(moveSelectedCard(rectNum));
            whichRect = -1;
        }
        if (whichHand != -1) {
            showDialog(insertCard(event.getDragboard().getString(), rectNum,false));
            whichHand = -1;
        }
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
        int rectNum = 13;
        if (whichRect != -1) {
            showDialog(moveSelectedCard(rectNum));
            whichRect = -1;
        }
        if (whichHand != -1) {
            showDialog(insertCard(event.getDragboard().getString(), rectNum,false));
            whichHand = -1;
        }
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
        int rectNum = 14;
        if (whichRect != -1) {
            showDialog(moveSelectedCard(rectNum));
            whichRect = -1;
        }
        if (whichHand != -1) {
            insertCard(event.getDragboard().getString(), rectNum,false);
            whichHand = -1;
        }
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
        int rectNum = 15;
        if (whichRect != -1) {
            showDialog(moveSelectedCard(rectNum));
            whichRect = -1;
        }
        if (whichHand != -1) {
            showDialog(insertCard(event.getDragboard().getString(), rectNum,false));
            whichHand = -1;
        }
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
        int rectNum = 16;
        if (whichRect != -1) {
            showDialog(moveSelectedCard(rectNum));
            whichRect = -1;
        }
        if (whichHand != -1) {
            showDialog(insertCard(event.getDragboard().getString(), rectNum,false));
            whichHand = -1;
        }
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
        int rectNum = 17;
        if (whichRect != -1) {
            showDialog(moveSelectedCard(rectNum));
            whichRect = -1;
        }
        if (whichHand != -1) {
            showDialog(insertCard(event.getDragboard().getString(), rectNum,false));
            whichHand = -1;
        }
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
        int rectNum = 18;
        if (whichRect != -1) {
            showDialog(moveSelectedCard(rectNum));
            whichRect = -1;
        }
        if (whichHand != -1) {
            showDialog(insertCard(event.getDragboard().getString(), rectNum,false));
            whichHand = -1;
        }
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
        int rectNum = 19;
        if (whichRect != -1) {
            showDialog(moveSelectedCard(rectNum));
            whichRect = -1;
        }
        if (whichHand != -1) {
            showDialog(insertCard(event.getDragboard().getString(), rectNum,false));
            whichHand = -1;
        }
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
        int rectNum = 20;
        if (whichRect != -1) {
            showDialog(moveSelectedCard(rectNum));
            whichRect = -1;
        }
        if (whichHand != -1) {
            showDialog(insertCard(event.getDragboard().getString(), rectNum,false));
            whichHand = -1;
        }
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
        int rectNum = 21;
        if (whichRect != -1) {
            showDialog(moveSelectedCard(rectNum));
            whichRect = -1;
        }
        if (whichHand != -1) {
            showDialog(insertCard(event.getDragboard().getString(), rectNum,false));
            whichHand = -1;
        }
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
        int rectNum = 22;
        if (whichRect != -1) {
            showDialog(moveSelectedCard(rectNum));
            whichRect = -1;
        }
        if (whichHand != -1) {
            showDialog(insertCard(event.getDragboard().getString(), rectNum,false));
            whichHand = -1;
        }
        rect22.setId("tile");
    }


    public void rect22DragExited() {
        rect22.setId("tile");
    }

    public void rect23DragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
            rect23.setId("tileWhite");
        }
    }

    public void rect23DragDropped(DragEvent event) {
        int rectNum = 23;
        if (whichRect != -1) {
            showDialog(moveSelectedCard(rectNum));
            whichRect = -1;
        }
        if (whichHand != -1) {
            showDialog(insertCard(event.getDragboard().getString(), rectNum,false));
            whichHand = -1;
        }
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
        int rectNum = 24;
        if (whichRect != -1) {
            showDialog(moveSelectedCard(rectNum));
            whichRect = -1;
        }
        if (whichHand != -1) {
            showDialog(insertCard(event.getDragboard().getString(), rectNum,false));
            whichHand = -1;
        }
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
        int rectNum = 25;
        if (whichRect != -1) {
            showDialog(moveSelectedCard(rectNum));
            whichRect = -1;
        }
        if (whichHand != -1) {
            showDialog(insertCard(event.getDragboard().getString(), rectNum,false));
            whichHand = -1;
        }
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
        int rectNum = 26;
        if (whichRect != -1) {
            showDialog(moveSelectedCard(rectNum));
            whichRect = -1;
        }
        if (whichHand != -1) {
            showDialog(insertCard(event.getDragboard().getString(), rectNum,false));
            whichHand = -1;
        }
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
        int rectNum = 27;
        if (whichRect != -1) {
            showDialog(moveSelectedCard(rectNum));
            whichRect = -1;
        }
        if (whichHand != -1) {
            showDialog(insertCard(event.getDragboard().getString(), rectNum,false));
            whichHand = -1;
        }
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
        int rectNum = 28;
        if (whichRect != -1) {
            showDialog(moveSelectedCard(rectNum));
            whichRect = -1;
        }
        if (whichHand != -1) {
            showDialog(insertCard(event.getDragboard().getString(), rectNum,false));
            whichHand = -1;
        }
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
        int rectNum = 29;
        if (whichRect != -1) {
            showDialog(moveSelectedCard(rectNum));
            whichRect = -1;
        }
        if (whichHand != -1) {
            showDialog(insertCard(event.getDragboard().getString(), rectNum,false));
            whichHand = -1;
        }
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
        int rectNum = 30;
        if (whichRect != -1) {
            showDialog(moveSelectedCard(rectNum));
            whichRect = -1;
        }
        if (whichHand != -1) {
            showDialog(insertCard(event.getDragboard().getString(), rectNum,false));
            whichHand = -1;
        }
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
        int rectNum = 31;
        if (whichRect != -1) {
            showDialog(moveSelectedCard(rectNum));
            whichRect = -1;
        }
        if (whichHand != -1) {
            showDialog(insertCard(event.getDragboard().getString(), rectNum,false));
            whichHand = -1;
        }
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
        int rectNum = 32;
        if (whichRect != -1) {
            showDialog(moveSelectedCard(rectNum));
            whichRect = -1;
        }
        if (whichHand != -1) {
            showDialog(insertCard(event.getDragboard().getString(), rectNum,false));
            whichHand = -1;
        }
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
        int rectNum = 33;
        if (whichRect != -1) {
            showDialog(moveSelectedCard(rectNum));
            whichRect = -1;
        }
        if (whichHand != -1) {
            showDialog(insertCard(event.getDragboard().getString(), rectNum,false));
            whichHand = -1;
        }
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
        int rectNum = 34;
        if (whichRect != -1) {
            showDialog(moveSelectedCard(rectNum));
            whichRect = -1;
        }
        if (whichHand != -1) {
            showDialog(insertCard(event.getDragboard().getString(), rectNum,false));
            whichHand = -1;
        }
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
        int rectNum = 35;
        if (whichRect != -1) {
            showDialog(moveSelectedCard(rectNum));
            whichRect = -1;
        }
        if (whichHand != -1) {
            showDialog(insertCard(event.getDragboard().getString(), rectNum,false));
            whichHand = -1;
        }
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
        int rectNum = 36;
        if (whichRect != -1) {
            showDialog(moveSelectedCard(rectNum));
            whichRect = -1;
        }
        if (whichHand != -1) {
            showDialog(insertCard(event.getDragboard().getString(), rectNum,false));
            whichHand = -1;
        }
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
        int rectNum = 37;
        if (whichRect != -1) {
            showDialog(moveSelectedCard(rectNum));
            whichRect = -1;
        }
        if (whichHand != -1) {
            showDialog(insertCard(event.getDragboard().getString(), rectNum,false));
            whichHand = -1;
        }
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
        int rectNum = 38;
        if (whichRect != -1) {
            showDialog(moveSelectedCard(rectNum));
            whichRect = -1;
        }
        if (whichHand != -1) {
            showDialog(insertCard(event.getDragboard().getString(), rectNum,false));
            whichHand = -1;
        }
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
        int rectNum = 39;
        if (whichRect != -1) {
            showDialog(moveSelectedCard(rectNum));
            whichRect = -1;
        }
        if (whichHand != -1) {
            showDialog(insertCard(event.getDragboard().getString(), rectNum,false));
            whichHand = -1;
        }
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
        int rectNum = 40;
        if (whichRect != -1) {
            showDialog(moveSelectedCard(rectNum));
            whichRect = -1;
        }
        if (whichHand != -1) {
            showDialog(insertCard(event.getDragboard().getString(), rectNum,false));
            whichHand = -1;
        }
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
        int rectNum = 41;
        if (whichRect != -1) {
            showDialog(moveSelectedCard(rectNum));
            whichRect = -1;
        }
        if (whichHand != -1) {
            showDialog(insertCard(event.getDragboard().getString(), rectNum,false));
            whichHand = -1;
        }
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
        int rectNum = 42;
        if (whichRect != -1) {
            showDialog(moveSelectedCard(rectNum));
            whichRect = -1;
        }
        if (whichHand != -1) {

            showDialog(insertCard(event.getDragboard().getString(), rectNum,false));
            whichHand = -1;
        }
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
        int rectNum = 43;
        if (whichRect != -1) {
            showDialog(moveSelectedCard(rectNum));
            whichRect = -1;
        }
        if (whichHand != -1) {
            showDialog(insertCard(event.getDragboard().getString(), rectNum,false));
            whichHand = -1;
        }
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
        int rectNum = 44;
        if (whichRect != -1) {
            showDialog(moveSelectedCard(rectNum));
            whichRect = -1;
        }
        if (whichHand != -1) {
            showDialog(insertCard(event.getDragboard().getString(), rectNum,false));
            whichHand = -1;
        }
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
        int rectNum = 45;
        if (whichRect != -1) {
            showDialog(moveSelectedCard(rectNum));
            whichRect = -1;
        }
        if (whichHand != -1) {
            showDialog(insertCard(event.getDragboard().getString(), rectNum,false));
            whichHand = -1;
        }
        rect45.setId("tile");
    }

    public void rect45DragExited(DragEvent event) {
        rect45.setId("tile");
    }


    public void dragRect1(MouseEvent event) {
        if (currentBattle.getMap().get((1 - 1) / 9).get((1 - 1) % 9).getHero() != null || currentBattle.getMap().get((1 - 1) / 9).get((1 - 1) % 9).getMinion() != null) {
            System.out.println("task2Done");
            Dragboard db = rect1.getChildren().get(0).startDragAndDrop(TransferMode.MOVE);
            whichRect = 1 - 1;
            ClipboardContent content = new ClipboardContent();
            content.putImage(((ImageView) rect1.getChildren().get(0)).getImage());
            if (currentBattle.getMap().get((1 - 1) / 9).get((1 - 1) % 9).getHero() != null) {
                content.putString(currentBattle.getMap().get((1 - 1) / 9).get((1 - 1) % 9).getHero().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((1 - 1) / 9).get((1 - 1) % 9).getHero());
            } else {
                content.putString(currentBattle.getMap().get((1 - 1) / 9).get((1 - 1) % 9).getMinion().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((1 - 1) / 9).get((1 - 1) % 9).getMinion());
            }
            db.setContent(content);
            event.consume();
        }
    }

    public void dragRect2(MouseEvent event) {
        if (currentBattle.getMap().get((2 - 1) / 9).get((2 - 1) % 9).getHero() != null || currentBattle.getMap().get((2 - 1) / 9).get((2 - 1) % 9).getMinion() != null) {
            Dragboard db = rect2.getChildren().get(0).startDragAndDrop(TransferMode.MOVE);
            whichRect = 2 - 1;
            ClipboardContent content = new ClipboardContent();
            content.putImage(((ImageView) rect2.getChildren().get(0)).getImage());
            if (currentBattle.getMap().get((2 - 1) / 9).get((2 - 1) % 9).getHero() != null) {
                content.putString(currentBattle.getMap().get((2 - 1) / 9).get((2 - 1) % 9).getHero().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((2 - 1) / 9).get((2 - 1) % 9).getHero());
            } else {
                content.putString(currentBattle.getMap().get((2 - 1) / 9).get((2 - 1) % 9).getMinion().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((2 - 1) / 9).get((2 - 1) % 9).getMinion());
            }

            db.setContent(content);
            event.consume();
        }
    }

    public void dragRect3(MouseEvent event) {
        if (currentBattle.getMap().get((3 - 1) / 9).get((3 - 1) % 9).getHero() != null || currentBattle.getMap().get((3 - 1) / 9).get((3 - 1) % 9).getMinion() != null) {
            Dragboard db = rect3.getChildren().get(0).startDragAndDrop(TransferMode.MOVE);
            whichRect = 3 - 1;
            ClipboardContent content = new ClipboardContent();
            content.putImage(((ImageView) rect3.getChildren().get(0)).getImage());
            if (currentBattle.getMap().get((3 - 1) / 9).get((3 - 1) % 9).getHero() != null) {
                content.putString(currentBattle.getMap().get((3 - 1) / 9).get((3 - 1) % 9).getHero().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((3 - 1) / 9).get((3 - 1) % 9).getHero());
            } else {
                content.putString(currentBattle.getMap().get((3 - 1) / 9).get((3 - 1) % 9).getMinion().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((3 - 1) / 9).get((3 - 1) % 9).getMinion());
            }
            db.setContent(content);
            event.consume();
        }
    }

    public void dragRect4(MouseEvent event) {
        if (currentBattle.getMap().get((4 - 1) / 9).get((4 - 1) % 9).getHero() != null || currentBattle.getMap().get((4 - 1) / 9).get((4 - 1) % 9).getMinion() != null) {
            Dragboard db = rect4.getChildren().get(0).startDragAndDrop(TransferMode.MOVE);
            whichRect = 4 - 1;
            ClipboardContent content = new ClipboardContent();
            content.putImage(((ImageView) rect4.getChildren().get(0)).getImage());
            if (currentBattle.getMap().get((4 - 1) / 9).get((4 - 1) % 9).getHero() != null) {
                content.putString(currentBattle.getMap().get((4 - 1) / 9).get((4 - 1) % 9).getHero().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((4 - 1) / 9).get((4 - 1) % 9).getHero());
            } else {
                content.putString(currentBattle.getMap().get((4 - 1) / 9).get((4 - 1) % 9).getMinion().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((4 - 1) / 9).get((4 - 1) % 9).getMinion());
            }
            db.setContent(content);
            event.consume();
        }
    }

    public void dragRect5(MouseEvent event) {
        if (currentBattle.getMap().get((5 - 1) / 9).get((5 - 1) % 9).getHero() != null || currentBattle.getMap().get((5 - 1) / 9).get((5 - 1) % 9).getMinion() != null) {
            Dragboard db = rect5.getChildren().get(0).startDragAndDrop(TransferMode.MOVE);
            whichRect = 5 - 1;
            ClipboardContent content = new ClipboardContent();
            content.putImage(((ImageView) rect5.getChildren().get(0)).getImage());
            if (currentBattle.getMap().get((5 - 1) / 9).get((5 - 1) % 9).getHero() != null) {
                content.putString(currentBattle.getMap().get((5 - 1) / 9).get((5 - 1) % 9).getHero().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((5 - 1) / 9).get((5 - 1) % 9).getHero());
            } else {
                content.putString(currentBattle.getMap().get((5 - 1) / 9).get((5 - 1) % 9).getMinion().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((5 - 1) / 9).get((5 - 1) % 9).getMinion());
            }
            db.setContent(content);
            event.consume();
        }
    }

    public void dragRect6(MouseEvent event) {
        if (currentBattle.getMap().get((6 - 1) / 9).get((6 - 1) % 9).getHero() != null || currentBattle.getMap().get((6 - 1) / 9).get((6 - 1) % 9).getMinion() != null) {
            Dragboard db = rect6.getChildren().get(0).startDragAndDrop(TransferMode.MOVE);
            whichRect = 6 - 1;
            ClipboardContent content = new ClipboardContent();
            content.putImage(((ImageView) rect6.getChildren().get(0)).getImage());
            if (currentBattle.getMap().get((6 - 1) / 9).get((6 - 1) % 9).getHero() != null) {
                content.putString(currentBattle.getMap().get((6 - 1) / 9).get((6 - 1) % 9).getHero().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((6 - 1) / 9).get((6 - 1) % 9).getHero());
            } else {
                content.putString(currentBattle.getMap().get((6 - 1) / 9).get((6 - 1) % 9).getMinion().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((6 - 1) / 9).get((6 - 1) % 9).getMinion());
            }
            db.setContent(content);
            event.consume();
        }
    }

    public void dragRect7(MouseEvent event) {
        if (currentBattle.getMap().get((7 - 1) / 9).get((7 - 1) % 9).getHero() != null || currentBattle.getMap().get((7 - 1) / 9).get((7 - 1) % 9).getMinion() != null) {
            Dragboard db = rect7.getChildren().get(0).startDragAndDrop(TransferMode.MOVE);
            whichRect = 7 - 1;
            ClipboardContent content = new ClipboardContent();
            content.putImage(((ImageView) rect7.getChildren().get(0)).getImage());
            if (currentBattle.getMap().get((7 - 1) / 9).get((7 - 1) % 9).getHero() != null) {
                content.putString(currentBattle.getMap().get((7 - 1) / 9).get((7 - 1) % 9).getHero().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((7 - 1) / 9).get((7 - 1) % 9).getHero());
            } else {
                content.putString(currentBattle.getMap().get((7 - 1) / 9).get((7 - 1) % 9).getMinion().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((7 - 1) / 9).get((7 - 1) % 9).getMinion());
            }
            db.setContent(content);
            event.consume();
        }
    }

    public void dragRect8(MouseEvent event) {
        if (currentBattle.getMap().get((8 - 1) / 9).get((8 - 1) % 9).getHero() != null || currentBattle.getMap().get((8 - 1) / 9).get((8 - 1) % 9).getMinion() != null) {
            Dragboard db = rect8.getChildren().get(0).startDragAndDrop(TransferMode.MOVE);
            whichRect = 8 - 1;
            ClipboardContent content = new ClipboardContent();
            content.putImage(((ImageView) rect8.getChildren().get(0)).getImage());
            if (currentBattle.getMap().get((8 - 1) / 9).get((8 - 1) % 9).getHero() != null) {
                content.putString(currentBattle.getMap().get((8 - 1) / 9).get((8 - 1) % 9).getHero().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((8 - 1) / 9).get((8 - 1) % 9).getHero());
            } else {
                content.putString(currentBattle.getMap().get((8 - 1) / 9).get((8 - 1) % 9).getMinion().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((8 - 1) / 9).get((8 - 1) % 9).getMinion());
            }
            db.setContent(content);
            event.consume();
        }
    }

    public void dragRect9(MouseEvent event) {
        if (currentBattle.getMap().get((9 - 1) / 9).get((9 - 1) % 9).getHero() != null || currentBattle.getMap().get((9 - 1) / 9).get((9 - 1) % 9).getMinion() != null) {
            Dragboard db = rect9.getChildren().get(0).startDragAndDrop(TransferMode.MOVE);
            whichRect = 9 - 1;
            ClipboardContent content = new ClipboardContent();
            content.putImage(((ImageView) rect9.getChildren().get(0)).getImage());
            if (currentBattle.getMap().get((9 - 1) / 9).get((9 - 1) % 9).getHero() != null) {
                content.putString(currentBattle.getMap().get((9 - 1) / 9).get((9 - 1) % 9).getHero().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((9 - 1) / 9).get((9 - 1) % 9).getHero());
            } else {
                content.putString(currentBattle.getMap().get((9 - 1) / 9).get((9 - 1) % 9).getMinion().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((9 - 1) / 9).get((9 - 1) % 9).getMinion());
            }
            db.setContent(content);
            event.consume();
        }
    }

    public void dragRect10(MouseEvent event) {
        if (currentBattle.getMap().get((10 - 1) / 9).get((10 - 1) % 9).getHero() != null || currentBattle.getMap().get((10 - 1) / 9).get((10 - 1) % 9).getMinion() != null) {
            Dragboard db = rect10.getChildren().get(0).startDragAndDrop(TransferMode.MOVE);
            whichRect = 10 - 1;
            ClipboardContent content = new ClipboardContent();
            content.putImage(((ImageView) rect10.getChildren().get(0)).getImage());
            if (currentBattle.getMap().get((10 - 1) / 9).get((10 - 1) % 9).getHero() != null) {
                content.putString(currentBattle.getMap().get((10 - 1) / 9).get((10 - 1) % 9).getHero().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((10 - 1) / 9).get((10 - 1) % 9).getHero());
            } else {
                content.putString(currentBattle.getMap().get((10 - 1) / 9).get((10 - 1) % 9).getMinion().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((10 - 1) / 9).get((10 - 1) % 9).getMinion());
            }
            db.setContent(content);
            event.consume();
        }
    }

    public void dragRect11(MouseEvent event) {
        if (currentBattle.getMap().get((11 - 1) / 9).get((11 - 1) % 9).getHero() != null || currentBattle.getMap().get((11 - 1) / 9).get((11 - 1) % 9).getMinion() != null) {
            Dragboard db = rect11.getChildren().get(0).startDragAndDrop(TransferMode.MOVE);
            whichRect = 11 - 1;
            ClipboardContent content = new ClipboardContent();
            content.putImage(((ImageView) rect11.getChildren().get(0)).getImage());
            if (currentBattle.getMap().get((11 - 1) / 9).get((11 - 1) % 9).getHero() != null) {
                content.putString(currentBattle.getMap().get((11 - 1) / 9).get((11 - 1) % 9).getHero().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((11 - 1) / 9).get((11 - 1) % 9).getHero());
            } else {
                content.putString(currentBattle.getMap().get((11 - 1) / 9).get((11 - 1) % 9).getMinion().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((11 - 1) / 9).get((11 - 1) % 9).getMinion());
            }
            db.setContent(content);
            event.consume();
        }
    }

    public void dragRect13(MouseEvent event) {
        if (currentBattle.getMap().get((13 - 1) / 9).get((13 - 1) % 9).getHero() != null || currentBattle.getMap().get((13 - 1) / 9).get((13 - 1) % 9).getMinion() != null) {
            Dragboard db = rect13.getChildren().get(0).startDragAndDrop(TransferMode.MOVE);
            whichRect = 13 - 1;
            ClipboardContent content = new ClipboardContent();
            content.putImage(((ImageView) rect13.getChildren().get(0)).getImage());
            if (currentBattle.getMap().get((13 - 1) / 9).get((13 - 1) % 9).getHero() != null) {
                content.putString(currentBattle.getMap().get((13 - 1) / 9).get((13 - 1) % 9).getHero().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((13 - 1) / 9).get((13 - 1) % 9).getHero());
            } else {
                content.putString(currentBattle.getMap().get((13 - 1) / 9).get((13 - 1) % 9).getMinion().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((13 - 1) / 9).get((13 - 1) % 9).getMinion());
            }
            db.setContent(content);
            event.consume();
        }
    }

    public void dragRect12(MouseEvent event) {
        if (currentBattle.getMap().get((12 - 1) / 9).get((12 - 1) % 9).getHero() != null || currentBattle.getMap().get((12 - 1) / 9).get((12 - 1) % 9).getMinion() != null) {
            Dragboard db = rect12.getChildren().get(0).startDragAndDrop(TransferMode.MOVE);
            whichRect = 12 - 1;
            ClipboardContent content = new ClipboardContent();
            content.putImage(((ImageView) rect12.getChildren().get(0)).getImage());
            if (currentBattle.getMap().get((12 - 1) / 9).get((12 - 1) % 9).getHero() != null) {
                content.putString(currentBattle.getMap().get((12 - 1) / 9).get((12 - 1) % 9).getHero().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((12 - 1) / 9).get((12 - 1) % 9).getHero());
            } else {
                content.putString(currentBattle.getMap().get((12 - 1) / 9).get((12 - 1) % 9).getMinion().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((12 - 1) / 9).get((12 - 1) % 9).getMinion());
            }
            db.setContent(content);
            event.consume();
        }
    }

    public void dragRect14(MouseEvent event) {
        if (currentBattle.getMap().get((14 - 1) / 9).get((14 - 1) % 9).getHero() != null || currentBattle.getMap().get((14 - 1) / 9).get((14 - 1) % 9).getMinion() != null) {
            Dragboard db = rect14.getChildren().get(0).startDragAndDrop(TransferMode.MOVE);
            whichRect = 14 - 1;
            ClipboardContent content = new ClipboardContent();
            content.putImage(((ImageView) rect14.getChildren().get(0)).getImage());
            if (currentBattle.getMap().get((14 - 1) / 9).get((14 - 1) % 9).getHero() != null) {
                content.putString(currentBattle.getMap().get((14 - 1) / 9).get((14 - 1) % 9).getHero().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((14 - 1) / 9).get((14 - 1) % 9).getHero());
            } else {
                content.putString(currentBattle.getMap().get((14 - 1) / 9).get((14 - 1) % 9).getMinion().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((14 - 1) / 9).get((14 - 1) % 9).getMinion());
            }
            db.setContent(content);
            event.consume();
        }
    }

    public void dragRect15(MouseEvent event) {
        if (currentBattle.getMap().get((15 - 1) / 9).get((15 - 1) % 9).getHero() != null || currentBattle.getMap().get((15 - 1) / 9).get((15 - 1) % 9).getMinion() != null) {
            Dragboard db = rect15.getChildren().get(0).startDragAndDrop(TransferMode.MOVE);
            whichRect = 15 - 1;
            ClipboardContent content = new ClipboardContent();
            content.putImage(((ImageView) rect15.getChildren().get(0)).getImage());
            if (currentBattle.getMap().get((15 - 1) / 9).get((15 - 1) % 9).getHero() != null) {
                content.putString(currentBattle.getMap().get((15 - 1) / 9).get((15 - 1) % 9).getHero().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((15 - 1) / 9).get((15 - 1) % 9).getHero());
            } else {
                content.putString(currentBattle.getMap().get((15 - 1) / 9).get((15 - 1) % 9).getMinion().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((15 - 1) / 9).get((15 - 1) % 9).getMinion());
            }
            db.setContent(content);
            event.consume();
        }
    }

    public void dragRect16(MouseEvent event) {
        if (currentBattle.getMap().get((16 - 1) / 9).get((16 - 1) % 9).getHero() != null || currentBattle.getMap().get((16 - 1) / 9).get((16 - 1) % 9).getMinion() != null) {
            Dragboard db = rect16.getChildren().get(0).startDragAndDrop(TransferMode.MOVE);
            whichRect = 16 - 1;
            ClipboardContent content = new ClipboardContent();
            content.putImage(((ImageView) rect16.getChildren().get(0)).getImage());
            if (currentBattle.getMap().get((16 - 1) / 9).get((16 - 1) % 9).getHero() != null) {
                content.putString(currentBattle.getMap().get((16 - 1) / 9).get((16 - 1) % 9).getHero().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((16 - 1) / 9).get((16 - 1) % 9).getHero());
            } else {
                content.putString(currentBattle.getMap().get((16 - 1) / 9).get((16 - 1) % 9).getMinion().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((16 - 1) / 9).get((16 - 1) % 9).getMinion());
            }
            db.setContent(content);
            event.consume();
        }
    }

    public void dragRect17(MouseEvent event) {
        if (currentBattle.getMap().get((17 - 1) / 9).get((17 - 1) % 9).getHero() != null || currentBattle.getMap().get((17 - 1) / 9).get((17 - 1) % 9).getMinion() != null) {
            Dragboard db = rect17.getChildren().get(0).startDragAndDrop(TransferMode.MOVE);
            whichRect = 17 - 1;
            ClipboardContent content = new ClipboardContent();
            content.putImage(((ImageView) rect17.getChildren().get(0)).getImage());
            if (currentBattle.getMap().get((17 - 1) / 9).get((17 - 1) % 9).getHero() != null) {
                content.putString(currentBattle.getMap().get((17 - 1) / 9).get((17 - 1) % 9).getHero().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((17 - 1) / 9).get((17 - 1) % 9).getHero());
            } else {
                content.putString(currentBattle.getMap().get((17 - 1) / 9).get((17 - 1) % 9).getMinion().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((17 - 1) / 9).get((17 - 1) % 9).getMinion());
            }
            db.setContent(content);
            event.consume();
        }
    }

    public void dragRect18(MouseEvent event) {
        if (currentBattle.getMap().get((18 - 1) / 9).get((18 - 1) % 9).getHero() != null || currentBattle.getMap().get((18 - 1) / 9).get((18 - 1) % 9).getMinion() != null) {
            Dragboard db = rect18.getChildren().get(0).startDragAndDrop(TransferMode.MOVE);
            whichRect = 18 - 1;
            ClipboardContent content = new ClipboardContent();
            content.putImage(((ImageView) rect18.getChildren().get(0)).getImage());
            if (currentBattle.getMap().get((18 - 1) / 9).get((18 - 1) % 9).getHero() != null) {
                content.putString(currentBattle.getMap().get((18 - 1) / 9).get((18 - 1) % 9).getHero().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((18 - 1) / 9).get((18 - 1) % 9).getHero());
            } else {
                content.putString(currentBattle.getMap().get((18 - 1) / 9).get((18 - 1) % 9).getMinion().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((18 - 1) / 9).get((18 - 1) % 9).getMinion());
            }
            db.setContent(content);
            event.consume();
        }
    }

    public void dragRect19(MouseEvent event) {
        if (currentBattle.getMap().get((19 - 1) / 9).get((19 - 1) % 9).getHero() != null || currentBattle.getMap().get((19 - 1) / 9).get((19 - 1) % 9).getMinion() != null) {
            Dragboard db = rect19.getChildren().get(0).startDragAndDrop(TransferMode.MOVE);
            whichRect = 19 - 1;
            ClipboardContent content = new ClipboardContent();
            content.putImage(((ImageView) rect19.getChildren().get(0)).getImage());
            if (currentBattle.getMap().get((19 - 1) / 9).get((19 - 1) % 9).getHero() != null) {
                content.putString(currentBattle.getMap().get((19 - 1) / 9).get((19 - 1) % 9).getHero().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((19 - 1) / 9).get((19 - 1) % 9).getHero());
            } else {
                content.putString(currentBattle.getMap().get((19 - 1) / 9).get((19 - 1) % 9).getMinion().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((19 - 1) / 9).get((19 - 1) % 9).getMinion());
            }
            db.setContent(content);
            event.consume();
        }
    }


    public void dragRect20(MouseEvent event) {
        if (currentBattle.getMap().get((20 - 1) / 9).get((20 - 1) % 9).getHero() != null || currentBattle.getMap().get((20 - 1) / 9).get((20 - 1) % 9).getMinion() != null) {
            Dragboard db = rect20.getChildren().get(0).startDragAndDrop(TransferMode.MOVE);
            whichRect = 20 - 1;
            ClipboardContent content = new ClipboardContent();
            content.putImage(((ImageView) rect20.getChildren().get(0)).getImage());
            if (currentBattle.getMap().get((20 - 1) / 9).get((20 - 1) % 9).getHero() != null) {
                content.putString(currentBattle.getMap().get((20 - 1) / 9).get((20 - 1) % 9).getHero().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((20 - 1) / 9).get((20 - 1) % 9).getHero());
            } else {
                content.putString(currentBattle.getMap().get((20 - 1) / 9).get((20 - 1) % 9).getMinion().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((20 - 1) / 9).get((20 - 1) % 9).getMinion());
            }
            db.setContent(content);
            event.consume();
        }
    }

    public void dragRect21(MouseEvent event) {
        if (currentBattle.getMap().get((21 - 1) / 9).get((21 - 1) % 9).getHero() != null || currentBattle.getMap().get((21 - 1) / 9).get((21 - 1) % 9).getMinion() != null) {
            Dragboard db = rect21.getChildren().get(0).startDragAndDrop(TransferMode.MOVE);
            whichRect = 21 - 1;
            ClipboardContent content = new ClipboardContent();
            content.putImage(((ImageView) rect21.getChildren().get(0)).getImage());
            if (currentBattle.getMap().get((21 - 1) / 9).get((21 - 1) % 9).getHero() != null) {
                content.putString(currentBattle.getMap().get((21 - 1) / 9).get((21 - 1) % 9).getHero().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((21 - 1) / 9).get((21 - 1) % 9).getHero());
            } else {
                content.putString(currentBattle.getMap().get((21 - 1) / 9).get((21 - 1) % 9).getMinion().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((21 - 1) / 9).get((21 - 1) % 9).getMinion());
            }
            db.setContent(content);
            event.consume();
        }
    }

    public void dragRect22(MouseEvent event) {
        if (currentBattle.getMap().get((22 - 1) / 9).get((22 - 1) % 9).getHero() != null || currentBattle.getMap().get((22 - 1) / 9).get((22 - 1) % 9).getMinion() != null) {
            Dragboard db = rect22.getChildren().get(0).startDragAndDrop(TransferMode.MOVE);
            whichRect = 22 - 1;
            ClipboardContent content = new ClipboardContent();
            content.putImage(((ImageView) rect22.getChildren().get(0)).getImage());
            if (currentBattle.getMap().get((22 - 1) / 9).get((22 - 1) % 9).getHero() != null) {
                content.putString(currentBattle.getMap().get((22 - 1) / 9).get((22 - 1) % 9).getHero().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((22 - 1) / 9).get((22 - 1) % 9).getHero());
            } else {
                content.putString(currentBattle.getMap().get((22 - 1) / 9).get((22 - 1) % 9).getMinion().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((22 - 1) / 9).get((22 - 1) % 9).getMinion());
            }
            db.setContent(content);
            event.consume();
        }
    }

    public void dragRect23(MouseEvent event) {
        if (currentBattle.getMap().get((23 - 1) / 9).get((23 - 1) % 9).getHero() != null || currentBattle.getMap().get((23 - 1) / 9).get((23 - 1) % 9).getMinion() != null) {
            Dragboard db = rect23.getChildren().get(0).startDragAndDrop(TransferMode.MOVE);
            whichRect = 23 - 1;
            ClipboardContent content = new ClipboardContent();
            content.putImage(((ImageView) rect23.getChildren().get(0)).getImage());
            if (currentBattle.getMap().get((23 - 1) / 9).get((23 - 1) % 9).getHero() != null) {
                content.putString(currentBattle.getMap().get((23 - 1) / 9).get((23 - 1) % 9).getHero().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((23 - 1) / 9).get((23 - 1) % 9).getHero());
            } else {
                content.putString(currentBattle.getMap().get((23 - 1) / 9).get((23 - 1) % 9).getMinion().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((23 - 1) / 9).get((23 - 1) % 9).getMinion());
            }
            db.setContent(content);
            event.consume();
        }
    }

    public void dragRect24(MouseEvent event) {
        if (currentBattle.getMap().get((24 - 1) / 9).get((24 - 1) % 9).getHero() != null || currentBattle.getMap().get((24 - 1) / 9).get((24 - 1) % 9).getMinion() != null) {
            Dragboard db = rect24.getChildren().get(0).startDragAndDrop(TransferMode.MOVE);
            whichRect = 24 - 1;
            ClipboardContent content = new ClipboardContent();
            content.putImage(((ImageView) rect24.getChildren().get(0)).getImage());
            if (currentBattle.getMap().get((24 - 1) / 9).get((24 - 1) % 9).getHero() != null) {
                content.putString(currentBattle.getMap().get((24 - 1) / 9).get((24 - 1) % 9).getHero().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((24 - 1) / 9).get((24 - 1) % 9).getHero());
            } else {
                content.putString(currentBattle.getMap().get((24 - 1) / 9).get((24 - 1) % 9).getMinion().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((24 - 1) / 9).get((24 - 1) % 9).getMinion());
            }
            db.setContent(content);
            event.consume();
        }
    }

    public void dragRect25(MouseEvent event) {
        if (currentBattle.getMap().get((25 - 1) / 9).get((25 - 1) % 9).getHero() != null || currentBattle.getMap().get((25 - 1) / 9).get((25 - 1) % 9).getMinion() != null) {
            Dragboard db = rect25.getChildren().get(0).startDragAndDrop(TransferMode.MOVE);
            whichRect = 25 - 1;
            ClipboardContent content = new ClipboardContent();
            content.putImage(((ImageView) rect25.getChildren().get(0)).getImage());
            if (currentBattle.getMap().get((25 - 1) / 9).get((25 - 1) % 9).getHero() != null) {
                content.putString(currentBattle.getMap().get((25 - 1) / 9).get((25 - 1) % 9).getHero().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((25 - 1) / 9).get((25 - 1) % 9).getHero());
            } else {
                content.putString(currentBattle.getMap().get((25 - 1) / 9).get((25 - 1) % 9).getMinion().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((25 - 1) / 9).get((25 - 1) % 9).getMinion());
            }
            db.setContent(content);
            event.consume();
        }
    }

    public void dragRect26(MouseEvent event) {
        if (currentBattle.getMap().get((26 - 1) / 9).get((26 - 1) % 9).getHero() != null || currentBattle.getMap().get((26 - 1) / 9).get((26 - 1) % 9).getMinion() != null) {
            Dragboard db = rect26.getChildren().get(0).startDragAndDrop(TransferMode.MOVE);
            whichRect = 26 - 1;
            ClipboardContent content = new ClipboardContent();
            content.putImage(((ImageView) rect26.getChildren().get(0)).getImage());
            if (currentBattle.getMap().get((26 - 1) / 9).get((26 - 1) % 9).getHero() != null) {
                content.putString(currentBattle.getMap().get((26 - 1) / 9).get((26 - 1) % 9).getHero().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((26 - 1) / 9).get((26 - 1) % 9).getHero());
            } else {
                content.putString(currentBattle.getMap().get((26 - 1) / 9).get((26 - 1) % 9).getMinion().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((26 - 1) / 9).get((26 - 1) % 9).getMinion());
            }
            db.setContent(content);
            event.consume();
        }
    }

    public void dragRect27(MouseEvent event) {
        if (currentBattle.getMap().get((27 - 1) / 9).get((27 - 1) % 9).getHero() != null || currentBattle.getMap().get((27 - 1) / 9).get((27 - 1) % 9).getMinion() != null) {
            Dragboard db = rect27.getChildren().get(0).startDragAndDrop(TransferMode.MOVE);
            whichRect = 27 - 1;
            ClipboardContent content = new ClipboardContent();
            content.putImage(((ImageView) rect27.getChildren().get(0)).getImage());
            if (currentBattle.getMap().get((27 - 1) / 9).get((27 - 1) % 9).getHero() != null) {
                content.putString(currentBattle.getMap().get((27 - 1) / 9).get((27 - 1) % 9).getHero().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((27 - 1) / 9).get((27 - 1) % 9).getHero());
            } else {
                content.putString(currentBattle.getMap().get((27 - 1) / 9).get((27 - 1) % 9).getMinion().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((27 - 1) / 9).get((27 - 1) % 9).getMinion());
            }
            db.setContent(content);
            event.consume();
        }
    }

    public void dragRect28(MouseEvent event) {
        if (currentBattle.getMap().get((28 - 1) / 9).get((28 - 1) % 9).getHero() != null || currentBattle.getMap().get((28 - 1) / 9).get((28 - 1) % 9).getMinion() != null) {
            Dragboard db = rect28.getChildren().get(0).startDragAndDrop(TransferMode.MOVE);
            whichRect = 28 - 1;
            ClipboardContent content = new ClipboardContent();
            content.putImage(((ImageView) rect28.getChildren().get(0)).getImage());
            if (currentBattle.getMap().get((28 - 1) / 9).get((28 - 1) % 9).getHero() != null) {
                content.putString(currentBattle.getMap().get((28 - 1) / 9).get((28 - 1) % 9).getHero().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((28 - 1) / 9).get((28 - 1) % 9).getHero());
            } else {
                content.putString(currentBattle.getMap().get((28 - 1) / 9).get((28 - 1) % 9).getMinion().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((28 - 1) / 9).get((28 - 1) % 9).getMinion());
            }
            db.setContent(content);
            event.consume();
        }
    }

    public void dragRect29(MouseEvent event) {
        if (currentBattle.getMap().get((29 - 1) / 9).get((29 - 1) % 9).getHero() != null || currentBattle.getMap().get((29 - 1) / 9).get((29 - 1) % 9).getMinion() != null) {
            Dragboard db = rect29.getChildren().get(0).startDragAndDrop(TransferMode.MOVE);
            whichRect = 29 - 1;
            ClipboardContent content = new ClipboardContent();
            content.putImage(((ImageView) rect29.getChildren().get(0)).getImage());
            if (currentBattle.getMap().get((29 - 1) / 9).get((29 - 1) % 9).getHero() != null) {
                content.putString(currentBattle.getMap().get((29 - 1) / 9).get((29 - 1) % 9).getHero().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((29 - 1) / 9).get((29 - 1) % 9).getHero());
            } else {
                content.putString(currentBattle.getMap().get((29 - 1) / 9).get((29 - 1) % 9).getMinion().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((29 - 1) / 9).get((29 - 1) % 9).getMinion());
            }
            db.setContent(content);
            event.consume();
        }
    }


    public void dragRect30(MouseEvent event) {
        if (currentBattle.getMap().get((30 - 1) / 9).get((30 - 1) % 9).getHero() != null || currentBattle.getMap().get((30 - 1) / 9).get((30 - 1) % 9).getMinion() != null) {
            Dragboard db = rect30.getChildren().get(0).startDragAndDrop(TransferMode.MOVE);
            whichRect = 30 - 1;
            ClipboardContent content = new ClipboardContent();
            content.putImage(((ImageView) rect30.getChildren().get(0)).getImage());
            if (currentBattle.getMap().get((30 - 1) / 9).get((30 - 1) % 9).getHero() != null) {
                content.putString(currentBattle.getMap().get((30 - 1) / 9).get((30 - 1) % 9).getHero().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((30 - 1) / 9).get((30 - 1) % 9).getHero());
            } else {
                content.putString(currentBattle.getMap().get((30 - 1) / 9).get((30 - 1) % 9).getMinion().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((30 - 1) / 9).get((30 - 1) % 9).getMinion());
            }
            db.setContent(content);
            event.consume();
        }
    }

    public void dragRect31(MouseEvent event) {
        if (currentBattle.getMap().get((31 - 1) / 9).get((31 - 1) % 9).getHero() != null || currentBattle.getMap().get((31 - 1) / 9).get((31 - 1) % 9).getMinion() != null) {
            Dragboard db = rect31.getChildren().get(0).startDragAndDrop(TransferMode.MOVE);
            whichRect = 31 - 1;
            ClipboardContent content = new ClipboardContent();
            content.putImage(((ImageView) rect31.getChildren().get(0)).getImage());
            if (currentBattle.getMap().get((31 - 1) / 9).get((31 - 1) % 9).getHero() != null) {
                content.putString(currentBattle.getMap().get((31 - 1) / 9).get((31 - 1) % 9).getHero().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((31 - 1) / 9).get((31 - 1) % 9).getHero());
            } else {
                content.putString(currentBattle.getMap().get((31 - 1) / 9).get((31 - 1) % 9).getMinion().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((31 - 1) / 9).get((31 - 1) % 9).getMinion());
            }
            db.setContent(content);
            event.consume();
        }
    }

    public void dragRect32(MouseEvent event) {
        if (currentBattle.getMap().get((32 - 1) / 9).get((32 - 1) % 9).getHero() != null || currentBattle.getMap().get((32 - 1) / 9).get((32 - 1) % 9).getMinion() != null) {
            Dragboard db = rect32.getChildren().get(0).startDragAndDrop(TransferMode.MOVE);
            whichRect = 32 - 1;
            ClipboardContent content = new ClipboardContent();
            content.putImage(((ImageView) rect32.getChildren().get(0)).getImage());
            if (currentBattle.getMap().get((32 - 1) / 9).get((32 - 1) % 9).getHero() != null) {
                content.putString(currentBattle.getMap().get((32 - 1) / 9).get((32 - 1) % 9).getHero().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((32 - 1) / 9).get((32 - 1) % 9).getHero());
            } else {
                content.putString(currentBattle.getMap().get((32 - 1) / 9).get((32 - 1) % 9).getMinion().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((32 - 1) / 9).get((32 - 1) % 9).getMinion());
            }
            db.setContent(content);
            event.consume();
        }
    }

    public void dragRect33(MouseEvent event) {
        if (currentBattle.getMap().get((33 - 1) / 9).get((33 - 1) % 9).getHero() != null || currentBattle.getMap().get((33 - 1) / 9).get((33 - 1) % 9).getMinion() != null) {
            Dragboard db = rect33.getChildren().get(0).startDragAndDrop(TransferMode.MOVE);
            whichRect = 33 - 1;
            ClipboardContent content = new ClipboardContent();
            content.putImage(((ImageView) rect33.getChildren().get(0)).getImage());
            if (currentBattle.getMap().get((33 - 1) / 9).get((33 - 1) % 9).getHero() != null) {
                content.putString(currentBattle.getMap().get((33 - 1) / 9).get((33 - 1) % 9).getHero().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((33 - 1) / 9).get((33 - 1) % 9).getHero());
            } else {
                content.putString(currentBattle.getMap().get((33 - 1) / 9).get((33 - 1) % 9).getMinion().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((33 - 1) / 9).get((33 - 1) % 9).getMinion());
            }
            db.setContent(content);
            event.consume();
        }
    }

    public void dragRect34(MouseEvent event) {
        if (currentBattle.getMap().get((34 - 1) / 9).get((34 - 1) % 9).getHero() != null || currentBattle.getMap().get((34 - 1) / 9).get((34 - 1) % 9).getMinion() != null) {
            Dragboard db = rect34.getChildren().get(0).startDragAndDrop(TransferMode.MOVE);
            whichRect = 34 - 1;
            ClipboardContent content = new ClipboardContent();
            content.putImage(((ImageView) rect34.getChildren().get(0)).getImage());
            if (currentBattle.getMap().get((34 - 1) / 9).get((34 - 1) % 9).getHero() != null) {
                content.putString(currentBattle.getMap().get((34 - 1) / 9).get((34 - 1) % 9).getHero().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((34 - 1) / 9).get((34 - 1) % 9).getHero());
            } else {
                content.putString(currentBattle.getMap().get((34 - 1) / 9).get((34 - 1) % 9).getMinion().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((34 - 1) / 9).get((34 - 1) % 9).getMinion());
            }
            db.setContent(content);
            event.consume();
        }
    }

    public void dragRect35(MouseEvent event) {
        if (currentBattle.getMap().get((35 - 1) / 9).get((35 - 1) % 9).getHero() != null || currentBattle.getMap().get((35 - 1) / 9).get((35 - 1) % 9).getMinion() != null) {
            Dragboard db = rect35.getChildren().get(0).startDragAndDrop(TransferMode.MOVE);
            whichRect = 35 - 1;
            ClipboardContent content = new ClipboardContent();
            content.putImage(((ImageView) rect35.getChildren().get(0)).getImage());
            if (currentBattle.getMap().get((35 - 1) / 9).get((35 - 1) % 9).getHero() != null) {
                content.putString(currentBattle.getMap().get((35 - 1) / 9).get((35 - 1) % 9).getHero().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((35 - 1) / 9).get((35 - 1) % 9).getHero());
            } else {
                content.putString(currentBattle.getMap().get((35 - 1) / 9).get((35 - 1) % 9).getMinion().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((35 - 1) / 9).get((35 - 1) % 9).getMinion());
            }
            db.setContent(content);
            event.consume();
        }
    }

    public void dragRect36(MouseEvent event) {
        if (currentBattle.getMap().get((36 - 1) / 9).get((36 - 1) % 9).getHero() != null || currentBattle.getMap().get((36 - 1) / 9).get((36 - 1) % 9).getMinion() != null) {
            Dragboard db = rect36.getChildren().get(0).startDragAndDrop(TransferMode.MOVE);
            whichRect = 36 - 1;
            ClipboardContent content = new ClipboardContent();
            content.putImage(((ImageView) rect36.getChildren().get(0)).getImage());
            if (currentBattle.getMap().get((36 - 1) / 9).get((36 - 1) % 9).getHero() != null) {
                content.putString(currentBattle.getMap().get((36 - 1) / 9).get((36 - 1) % 9).getHero().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((36 - 1) / 9).get((36 - 1) % 9).getHero());
            } else {
                content.putString(currentBattle.getMap().get((36 - 1) / 9).get((36 - 1) % 9).getMinion().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((36 - 1) / 9).get((36 - 1) % 9).getMinion());
            }
            db.setContent(content);
            event.consume();
        }
    }

    public void dragRect37(MouseEvent event) {
        if (currentBattle.getMap().get((37 - 1) / 9).get((37 - 1) % 9).getHero() != null || currentBattle.getMap().get((37 - 1) / 9).get((37 - 1) % 9).getMinion() != null) {
            Dragboard db = rect37.getChildren().get(0).startDragAndDrop(TransferMode.MOVE);
            whichRect = 37 - 1;
            ClipboardContent content = new ClipboardContent();
            content.putImage(((ImageView) rect37.getChildren().get(0)).getImage());
            if (currentBattle.getMap().get((37 - 1) / 9).get((37 - 1) % 9).getHero() != null) {
                content.putString(currentBattle.getMap().get((37 - 1) / 9).get((37 - 1) % 9).getHero().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((37 - 1) / 9).get((37 - 1) % 9).getHero());
            } else {
                content.putString(currentBattle.getMap().get((37 - 1) / 9).get((37 - 1) % 9).getMinion().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((37 - 1) / 9).get((37 - 1) % 9).getMinion());
            }
            db.setContent(content);
            event.consume();
        }
    }

    public void dragRect38(MouseEvent event) {
        if (currentBattle.getMap().get((38 - 1) / 9).get((38 - 1) % 9).getHero() != null || currentBattle.getMap().get((38 - 1) / 9).get((38 - 1) % 9).getMinion() != null) {
            Dragboard db = rect38.getChildren().get(0).startDragAndDrop(TransferMode.MOVE);
            whichRect = 38 - 1;
            ClipboardContent content = new ClipboardContent();
            content.putImage(((ImageView) rect38.getChildren().get(0)).getImage());
            if (currentBattle.getMap().get((38 - 1) / 9).get((38 - 1) % 9).getHero() != null) {
                content.putString(currentBattle.getMap().get((38 - 1) / 9).get((38 - 1) % 9).getHero().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((38 - 1) / 9).get((38 - 1) % 9).getHero());
            } else {
                content.putString(currentBattle.getMap().get((38 - 1) / 9).get((38 - 1) % 9).getMinion().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((38 - 1) / 9).get((38 - 1) % 9).getMinion());
            }
            db.setContent(content);
            event.consume();
        }
    }

    public void dragRect39(MouseEvent event) {
        if (currentBattle.getMap().get((39 - 1) / 9).get((39 - 1) % 9).getHero() != null || currentBattle.getMap().get((39 - 1) / 9).get((39 - 1) % 9).getMinion() != null) {
            Dragboard db = rect39.getChildren().get(0).startDragAndDrop(TransferMode.MOVE);
            whichRect = 39 - 1;
            ClipboardContent content = new ClipboardContent();
            content.putImage(((ImageView) rect39.getChildren().get(0)).getImage());
            if (currentBattle.getMap().get((39 - 1) / 9).get((39 - 1) % 9).getHero() != null) {
                content.putString(currentBattle.getMap().get((39 - 1) / 9).get((39 - 1) % 9).getHero().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((39 - 1) / 9).get((39 - 1) % 9).getHero());
            } else {
                content.putString(currentBattle.getMap().get((39 - 1) / 9).get((39 - 1) % 9).getMinion().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((39 - 1) / 9).get((39 - 1) % 9).getMinion());
            }
            db.setContent(content);
            event.consume();
        }
    }


    public void dragRect40(MouseEvent event) {
        if (currentBattle.getMap().get((40 - 1) / 9).get((40 - 1) % 9).getHero() != null || currentBattle.getMap().get((40 - 1) / 9).get((40 - 1) % 9).getMinion() != null) {
            Dragboard db = rect40.getChildren().get(0).startDragAndDrop(TransferMode.MOVE);
            whichRect = 40 - 1;
            ClipboardContent content = new ClipboardContent();
            content.putImage(((ImageView) rect40.getChildren().get(0)).getImage());
            if (currentBattle.getMap().get((40 - 1) / 9).get((40 - 1) % 9).getHero() != null) {
                content.putString(currentBattle.getMap().get((40 - 1) / 9).get((40 - 1) % 9).getHero().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((40 - 1) / 9).get((40 - 1) % 9).getHero());
            } else {
                content.putString(currentBattle.getMap().get((40 - 1) / 9).get((40 - 1) % 9).getMinion().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((40 - 1) / 9).get((40 - 1) % 9).getMinion());
            }
            db.setContent(content);
            event.consume();
        }
    }

    public void dragRect41(MouseEvent event) {
        if (currentBattle.getMap().get((41 - 1) / 9).get((41 - 1) % 9).getHero() != null || currentBattle.getMap().get((41 - 1) / 9).get((41 - 1) % 9).getMinion() != null) {
            Dragboard db = rect41.getChildren().get(0).startDragAndDrop(TransferMode.MOVE);
            whichRect = 41 - 1;
            ClipboardContent content = new ClipboardContent();
            content.putImage(((ImageView) rect41.getChildren().get(0)).getImage());
            if (currentBattle.getMap().get((41 - 1) / 9).get((41 - 1) % 9).getHero() != null) {
                content.putString(currentBattle.getMap().get((41 - 1) / 9).get((41 - 1) % 9).getHero().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((41 - 1) / 9).get((41 - 1) % 9).getHero());
            } else {
                content.putString(currentBattle.getMap().get((41 - 1) / 9).get((41 - 1) % 9).getMinion().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((41 - 1) / 9).get((41 - 1) % 9).getMinion());
            }
            db.setContent(content);
            event.consume();
        }
    }

    public void dragRect42(MouseEvent event) {
        if (currentBattle.getMap().get((42 - 1) / 9).get((42 - 1) % 9).getHero() != null || currentBattle.getMap().get((42 - 1) / 9).get((42 - 1) % 9).getMinion() != null) {
            Dragboard db = rect42.getChildren().get(0).startDragAndDrop(TransferMode.MOVE);
            whichRect = 42 - 1;
            ClipboardContent content = new ClipboardContent();
            content.putImage(((ImageView) rect42.getChildren().get(0)).getImage());
            if (currentBattle.getMap().get((42 - 1) / 9).get((42 - 1) % 9).getHero() != null) {
                content.putString(currentBattle.getMap().get((42 - 1) / 9).get((42 - 1) % 9).getHero().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((42 - 1) / 9).get((42 - 1) % 9).getHero());
            } else {
                content.putString(currentBattle.getMap().get((42 - 1) / 9).get((42 - 1) % 9).getMinion().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((42 - 1) / 9).get((42 - 1) % 9).getMinion());
            }
            db.setContent(content);
            event.consume();
        }
    }

    public void dragRect43(MouseEvent event) {
        if (currentBattle.getMap().get((43 - 1) / 9).get((43 - 1) % 9).getHero() != null || currentBattle.getMap().get((43 - 1) / 9).get((43 - 1) % 9).getMinion() != null) {
            Dragboard db = rect43.getChildren().get(0).startDragAndDrop(TransferMode.MOVE);
            whichRect = 43 - 1;
            ClipboardContent content = new ClipboardContent();
            content.putImage(((ImageView) rect43.getChildren().get(0)).getImage());
            if (currentBattle.getMap().get((43 - 1) / 9).get((43 - 1) % 9).getHero() != null) {
                content.putString(currentBattle.getMap().get((43 - 1) / 9).get((43 - 1) % 9).getHero().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((43 - 1) / 9).get((43 - 1) % 9).getHero());
            } else {
                content.putString(currentBattle.getMap().get((43 - 1) / 9).get((43 - 1) % 9).getMinion().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((43 - 1) / 9).get((43 - 1) % 9).getMinion());
            }
            db.setContent(content);
            event.consume();
        }
    }

    public void dragRect44(MouseEvent event) {
        if (currentBattle.getMap().get((44 - 1) / 9).get((44 - 1) % 9).getHero() != null || currentBattle.getMap().get((44 - 1) / 9).get((44 - 1) % 9).getMinion() != null) {
            Dragboard db = rect44.getChildren().get(0).startDragAndDrop(TransferMode.MOVE);
            whichRect = 44 - 1;
            ClipboardContent content = new ClipboardContent();
            content.putImage(((ImageView) rect44.getChildren().get(0)).getImage());
            if (currentBattle.getMap().get((44 - 1) / 9).get((44 - 1) % 9).getHero() != null) {
                content.putString(currentBattle.getMap().get((44 - 1) / 9).get((44 - 1) % 9).getHero().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((44 - 1) / 9).get((44 - 1) % 9).getHero());
            } else {
                content.putString(currentBattle.getMap().get((44 - 1) / 9).get((44 - 1) % 9).getMinion().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((44 - 1) / 9).get((44 - 1) % 9).getMinion());
            }
            db.setContent(content);
            event.consume();

        }
    }

    public void dragRect45(MouseEvent event) {
        if (currentBattle.getMap().get((45 - 1) / 9).get((45 - 1) % 9).getHero() != null || currentBattle.getMap().get((45 - 1) / 9).get((45 - 1) % 9).getMinion() != null) {
            Dragboard db = rect45.getChildren().get(0).startDragAndDrop(TransferMode.MOVE);
            whichRect = 45 - 1;
            ClipboardContent content = new ClipboardContent();
            content.putImage(((ImageView) rect45.getChildren().get(0)).getImage());
            if (currentBattle.getMap().get((45 - 1) / 9).get((45 - 1) % 9).getHero() != null) {
                content.putString(currentBattle.getMap().get((45 - 1) / 9).get((45 - 1) % 9).getHero().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((45 - 1) / 9).get((45 - 1) % 9).getHero());
            } else {
                content.putString(currentBattle.getMap().get((45 - 1) / 9).get((45 - 1) % 9).getMinion().getName());
                currentBattle.setSelectedCard(currentBattle.getMap().get((45 - 1) / 9).get((45 - 1) % 9).getMinion());
            }

            db.setContent(content);
            event.consume();
        }
    }

    public void showLogAct(MouseEvent event) {
    }
}


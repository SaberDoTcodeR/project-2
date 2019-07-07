package DuelystServer.View;

import DuelystServer.Server;
import DuelystServer.Controller.ShopController;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

import static DuelystServer.Server.primaryStage1;

public class View {
    static Scene scene = new Scene(new GridPane());
    public static void makeShopMenu() {
        Platform.runLater(() -> {
            StackPane root = null;
            try {
                root = FXMLLoader.load(ShopController.class.getResource("shopMenuServer.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            scene.setRoot(root);

            scene.setCursor(new ImageCursor(new Image("DuelystServer/css/OzFOdVG.png")));
            scene.getStylesheets().clear();
            scene.getStylesheets().add(Server.class.getResource("css/css3.css").toExternalForm());
            primaryStage1.setScene(scene);
            primaryStage1.setFullScreen(true);
            primaryStage1.setResizable(true);

        });

    }
}

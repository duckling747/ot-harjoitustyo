package rpgame.UI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Menu extends Application {

    public static int WIDTH = 600, HEIGHT = 400;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Roleplay NOW");

        primaryStage.setScene(getMainMenuScene(primaryStage));
        primaryStage.show();
    }

    private Scene getMainMenuScene(Stage stage) {
        BorderPane pane = new BorderPane();
        pane.setPrefSize(WIDTH, HEIGHT);
        Scene mainMenuScene = new Scene(pane);

        // top
        Label header = new Label("Main menu");
        header.setFont(Font.font("Tahoma", 30));
        header.setPadding(new Insets(30, 30, 0, 30));
        pane.setTop(header);
        BorderPane.setAlignment(header, Pos.CENTER);

        // left
        VBox leftpane = new VBox(30);
        leftpane.setAlignment(Pos.CENTER);
        leftpane.setPrefSize(WIDTH / 2, HEIGHT / 2);

        Button buttonBegin = new Button("Start");
        Insets insets = new Insets(10);
        buttonBegin.setPadding(insets);
        buttonBegin.setOnAction(e -> {
            // handle starting new game and change scene to level selection scene
        });

        Button buttonLoad = new Button("Load Game");
        buttonLoad.setPadding(insets);
        buttonLoad.setOnAction(e -> {
            // hande load game and change scene to level selection scene
        });

        Button buttonQuit = new Button("Quit Game");
        buttonQuit.setOnAction(e -> {
            stage.close();
        });
        buttonQuit.setPadding(insets);

        leftpane.getChildren().addAll(buttonBegin, buttonLoad, buttonQuit);
        leftpane.setAlignment(Pos.CENTER);
        pane.setLeft(leftpane);
//        BorderPane.setAlignment(leftpane, Pos.CENTER);

        // right
        ImageView image = new ImageView(new Image("file:src/main/resources/bavaria.jpeg"));
        image.setFitHeight(HEIGHT / 2);
        image.setFitWidth(WIDTH / 2);
        pane.setRight(image);
        BorderPane.setAlignment(image, Pos.CENTER);

        return mainMenuScene;
    }

}

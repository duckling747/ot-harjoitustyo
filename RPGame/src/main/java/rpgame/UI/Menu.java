package rpgame.UI;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import rpgame.creatures.Actor;
import rpgame.creatures.ThiefCharacter;
import rpgame.creatures.WarriorCharacter;
import rpgame.creatures.WizardCharacter;
import rpgame.main.Game;

public class Menu extends Application {

    private static final int WIDTH = 600, HEIGHT = 400;
    private static final Font TITLE_FONTS = Font.font("Tahoma", 30);
    private static Game game;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Roleplay NOW");
        primaryStage.setScene(getMainMenuScene(primaryStage));
        primaryStage.show();
    }

    private static Scene getMainMenuScene(Stage stage) {
        BorderPane pane = new BorderPane();
        pane.setPrefSize(WIDTH, HEIGHT);
        Scene mainMenuScene = new Scene(pane);

        // top
        Label header = new Label("Main menu");
        header.setFont(TITLE_FONTS);
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
            Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Start a new game? ", ButtonType.YES, ButtonType.CANCEL);
            a.showAndWait();
            if (a.getResult() != ButtonType.YES) {
                return;
            }
            stage.setScene(getStartSceneLoading());
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(x -> {
                stage.setScene(getStartScreenSelections(stage));
            });
            pause.play();
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

    private static Scene getStartSceneLoading() {
        BorderPane bp = new BorderPane();
        bp.setPrefSize(WIDTH, HEIGHT);
        Scene startingScene = new Scene(bp);
        Label header = new Label("Starting up...");
        header.setFont(TITLE_FONTS);
        header.setPadding(new Insets(30, 30, 0, 30));
        bp.setCenter(header);
        BorderPane.setAlignment(header, Pos.CENTER);
        return startingScene;
    }

    private static Scene getStartScreenSelections(Stage stage) {
        VBox vboxSelContainer = new VBox();
        vboxSelContainer.setPrefSize(WIDTH, HEIGHT);
        vboxSelContainer.setAlignment(Pos.CENTER);
        Scene makeSelectionsScene = new Scene(vboxSelContainer);
        Label header = new Label("Character select");
        header.setFont(TITLE_FONTS);
        header.setPadding(new Insets(0, 30, 0, 30));
        vboxSelContainer.getChildren().add(header);
        // VBOX
        Label lName = new Label("Name:");
        vboxSelContainer.getChildren().add(lName);
        lName.setPadding(new Insets(30, 30, 5, 30));
        TextField textfieldName = new TextField();
        textfieldName.setMaxWidth(WIDTH / 3);
        //textfieldName.setPrefColumnCount(300);
        vboxSelContainer.getChildren().add(textfieldName);
        Label lCharacterType = new Label("Character type:");
        lCharacterType.setPadding(new Insets(5, 30, 5, 30));
        vboxSelContainer.getChildren().add(lCharacterType);

        final ToggleGroup toggleCharType = new ToggleGroup();
        RadioButton radioBCharWarrior = new RadioButton("Warrior");
        radioBCharWarrior.setToggleGroup(toggleCharType);
        radioBCharWarrior.setPadding(new Insets(5));
        RadioButton radioBCharWiz = new RadioButton("Wizard");
        radioBCharWiz.setPadding(new Insets(5));
        radioBCharWiz.setToggleGroup(toggleCharType);
        RadioButton radioBCharThf = new RadioButton("Thief");
        radioBCharThf.setPadding(new Insets(5));
        radioBCharThf.setToggleGroup(toggleCharType);
        radioBCharWarrior.setSelected(true);
        HBox hboxRadiogroup = new HBox(radioBCharWarrior, radioBCharWiz, radioBCharThf);
        hboxRadiogroup.setPadding(new Insets(10));
        hboxRadiogroup.setAlignment(Pos.CENTER);
        vboxSelContainer.getChildren().add(hboxRadiogroup);
        Button bStart = new Button("Start");
        //bStart.setPadding(new Insets(20));
        bStart.setMinSize(WIDTH / 5, HEIGHT / 19);
        vboxSelContainer.getChildren().add(bStart);
        bStart.setOnAction(e -> {
            if (textfieldName.getText().equals("")) {
                Alert a = new Alert(Alert.AlertType.NONE, "Please set a character name", ButtonType.OK);
                a.showAndWait();
                return;
            }
            Actor character;
            switch (((RadioButton) toggleCharType.getSelectedToggle()).getText()) {
                default:
                    Alert a = new Alert(Alert.AlertType.ERROR, "Error in character creation (no selection) ");
                    a.showAndWait();
                    return;
                case "Warrior":
                    character = new WarriorCharacter(textfieldName.getText());
                    break;
                case "Wizard":
                    character = new WizardCharacter(textfieldName.getText());
                    break;
                case "Thief":
                    character = new ThiefCharacter(textfieldName.getText());
                    break;
            }
            game = new Game(character);
            stage.setScene(getBattleScene(stage));
        });
        return makeSelectionsScene;
    }

    private static Scene getBattleScene(Stage stage) {
        BorderPane bp = new BorderPane();
        bp.setPrefSize(WIDTH, HEIGHT);
        Scene battleScene = new Scene(bp);
        // top
        TextArea textAreaEvents = new TextArea();
        textAreaEvents.setPrefWidth(WIDTH - 10);
        textAreaEvents.setMaxHeight(HEIGHT / 2);
        textAreaEvents.setEditable(false);
        //ScrollPane textPane = new ScrollPane(textFlowEvents);
        bp.setTop(textAreaEvents);
        // left
        VBox vboxLeft = new VBox();
        vboxLeft.setPrefHeight(HEIGHT / 2);//////////
        // IMAGE TODO: set image based on character
        ImageView playerImage = new ImageView(new Image("file:src/main/resources/warrior_Xena.jpeg"));
        playerImage.setFitHeight(HEIGHT / 4);
        playerImage.setFitWidth(WIDTH / 4);
        vboxLeft.getChildren().add(playerImage);
        ProgressBar healthMeter = new ProgressBar(1.0);
        healthMeter.setStyle("-fx-accent: red;");
        ProgressBar manaMeter = new ProgressBar(1.0);
        vboxLeft.getChildren().add(healthMeter);
        vboxLeft.getChildren().add(manaMeter);
        bp.setLeft(vboxLeft);
        // right
        VBox vboxRight = new VBox();
        vboxRight.setPrefHeight(HEIGHT / 2);////////
        ImageView monsterImage = new ImageView(new Image("file:src/main/resources/cliche_monster.jpeg"));
        monsterImage.setFitHeight(HEIGHT / 4);
        monsterImage.setFitWidth(WIDTH / 4);
        vboxRight.getChildren().add(monsterImage);
        ProgressBar monsHealthMeter = new ProgressBar(1.0);
        monsHealthMeter.setStyle("-fx-accent: red;");
        ProgressBar monsManaMeter = new ProgressBar(1.0);
        vboxRight.getChildren().add(monsHealthMeter);
        vboxRight.getChildren().add(monsManaMeter);
        bp.setRight(vboxRight);
        //center
        Button bAttack = new Button("attack");
        Button bDefend = new Button("defend");
        Button bItem = new Button("use item");
        Button bFlee = new Button("flee");
        bAttack.setPrefWidth(WIDTH / 5);
        bDefend.setPrefWidth(WIDTH / 5);
        bItem.setPrefWidth(WIDTH / 5);
        bFlee.setPrefWidth(WIDTH / 5);
        bAttack.setDisable(true);
        bDefend.setDisable(true);
        bItem.setDisable(true);
        bFlee.setDisable(true);
        VBox vboxCenter = new VBox(bAttack, bDefend, bItem, bFlee);
        vboxCenter.setPrefHeight(HEIGHT / 2);
        vboxCenter.setAlignment(Pos.CENTER);
        bp.setCenter(vboxCenter);
        BorderPane.setAlignment(vboxCenter, Pos.BOTTOM_CENTER);
        return battleScene;
    }

}

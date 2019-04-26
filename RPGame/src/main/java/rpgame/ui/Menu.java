package rpgame.ui;

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
import jdk.nashorn.tools.Shell;
import rpgame.battle.Battle;
import rpgame.creatures.MonsterIdentities;
import rpgame.creatures.PlayerCharacter;
import rpgame.creatures.ThiefCharacter;
import rpgame.creatures.WarriorCharacter;
import rpgame.creatures.WizardCharacter;
import rpgame.io.Io;
import rpgame.items.ItemRandomGetter;
import rpgame.progression.Game;

public class Menu extends Application {

    private static final int WIDTH = 600, HEIGHT = 400;
    private static final Font TITLE_FONTS = Font.font("Tahoma", 30);

    private static Game game;
    private static int battleCounter = 0;
    private static MonsterIdentities monsIdent;

    static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Roleplay NOW");
        stage = primaryStage;
        primaryStage.setScene(getMainMenuScene());
        primaryStage.show();
    }

    @Override
    public void init() {
        monsIdent = new MonsterIdentities();
        monsIdent.initMonsterImages();
        ItemRandomGetter.initItemRandomGetter();
    }

    private Scene getMainMenuScene() {
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
            Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Start a new game? ", ButtonType.YES, ButtonType.CANCEL);
            a.showAndWait();
            if (a.getResult() != ButtonType.YES) {
                return;
            }
            Menu.stage.setScene(getStartSceneLoading());
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(x -> {
                Menu.stage.setScene(getStartScreenSelections());
            });
            pause.play();
        });

        Button buttonLoad = new Button("Load Game");
        buttonLoad.setPadding(insets);
        buttonLoad.setOnAction(e -> {
            if (Io.saveFileExists()) {
                
            }
        });

        Button buttonQuit = new Button("Quit Game");
        buttonQuit.setOnAction(e -> {
            stage.close();
        });
        buttonQuit.setPadding(insets);

        leftpane.getChildren().addAll(buttonBegin, buttonLoad, buttonQuit);
        leftpane.setAlignment(Pos.CENTER);
        pane.setLeft(leftpane);

        // right
        ImageView image = new ImageView(new Image(getClass().getResourceAsStream("/scenery/bavaria.jpeg")));
        image.setFitHeight(HEIGHT / 2);
        image.setFitWidth(WIDTH / 2);
        pane.setRight(image);
        BorderPane.setAlignment(image, Pos.CENTER);

        return mainMenuScene;
    }

    private Scene getStartSceneLoading() {
        BorderPane bp = new BorderPane();
        bp.setPrefSize(WIDTH, HEIGHT);
        Scene startingScene = new Scene(bp);
        Label header = new Label("Loading...");
        header.setFont(TITLE_FONTS);
        header.setPadding(new Insets(30, 30, 0, 30));
        bp.setCenter(header);
        BorderPane.setAlignment(header, Pos.CENTER);
        return startingScene;
    }

    private Scene getStartScreenSelections() {
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
            PlayerCharacter character;
            switch (((RadioButton) toggleCharType.getSelectedToggle()).getText()) {
                default:
                    Alert a = new Alert(Alert.AlertType.ERROR, "Error in character creation (no selection) ");
                    a.showAndWait();
                    return;
                case "Warrior":
                    character = new WarriorCharacter(textfieldName.getText());
                    game = new Game(character);
                    break;
                case "Wizard":
                    character = new WizardCharacter(textfieldName.getText());
                    game = new Game(character);
                    break;
                case "Thief":
                    character = new ThiefCharacter(textfieldName.getText());
                    game = new Game(character);
                    break;
            }
            stage.setScene(getBattleScene());
        });
        return makeSelectionsScene;
    }

    private Scene getBattleScene() {
        if (!game.currentLevelIsStoryInstance() && game.getCurrentLevelBattleMaximum() <= battleCounter) {
            battleCounter = 0;
            game.advanceLevel();
        }
        Battle b = game.getNextBattle();

        BorderPane bp = new BorderPane();
        bp.setPrefSize(WIDTH, HEIGHT);
        Scene battleScene = new Scene(bp);
        // top
        TextArea textAreaEvents = new TextArea();
        textAreaEvents.setWrapText(true);
        textAreaEvents.setEditable(false);
        if (game.currentLevelIsStoryInstance()) {
            textAreaEvents.setText(game.getNextStoryText());
        } else {
            textAreaEvents.setText(b.getTurnout());
        }
        textAreaEvents.setPrefWidth(WIDTH - 10);
        textAreaEvents.setMaxHeight(HEIGHT / 2);
        bp.setTop(textAreaEvents);
        // left
        VBox vboxLeft = new VBox();
        vboxLeft.setPrefHeight(HEIGHT / 2);
        ImageView playerImage;
        switch (game.getCharacterType()) {
            case "warrior":
                playerImage = new ImageView(new Image(getClass().getResourceAsStream("/playerCharacters/warrior_stock.jpeg")));
                break;
            case "thief":
                playerImage = new ImageView(new Image(getClass().getResourceAsStream("/playerCharacters/thief_stock.jpeg")));
                break;
            case "wizard":
                playerImage = new ImageView(new Image(getClass().getResourceAsStream("/playerCharacters/wizard_stock.jpeg")));
                break;
            default:
                throw new IllegalStateException();
        }
        playerImage.setFitHeight(HEIGHT / 4);
        playerImage.setFitWidth(WIDTH / 4);
        vboxLeft.getChildren().add(playerImage);
        ProgressBar healthMeter = new ProgressBar(1.0);
        healthMeter.setPrefWidth(WIDTH / 4);
        healthMeter.setStyle("-fx-accent: red;");
        ProgressBar manaMeter = new ProgressBar(1.0);
        manaMeter.setPrefWidth(WIDTH / 4);
        vboxLeft.getChildren().add(healthMeter);
        vboxLeft.getChildren().add(manaMeter);
        bp.setLeft(vboxLeft);
        // right
        VBox vboxRight = new VBox();
        vboxRight.setPrefHeight(HEIGHT / 2);
        ImageView rightImage;
        if (game.currentLevelIsStoryInstance()) {
            rightImage = new ImageView(game.getLevelImage(game.getCurrentLevelName()));
        } else {
            rightImage = new ImageView(MonsterIdentities.getMonsterImage(b.getMonsterName()));
        }
        rightImage.setFitHeight(HEIGHT / 4);
        rightImage.setFitWidth(WIDTH / 4);
        vboxRight.getChildren().add(rightImage);
        ProgressBar monsHealthMeter = new ProgressBar(1.0);
        monsHealthMeter.setPrefWidth(WIDTH / 4);
        ProgressBar monsManaMeter = new ProgressBar(1.0);
        monsHealthMeter.setStyle("-fx-accent: red;");
        monsManaMeter.setPrefWidth(WIDTH / 4);
        if (!game.currentLevelIsStoryInstance()) {
            vboxRight.getChildren().add(monsHealthMeter);
            vboxRight.getChildren().add(monsManaMeter);
        } else {
            Label labLevelName = new Label(game.getCurrentLevelName());
            vboxRight.getChildren().add(labLevelName);
        }
        bp.setRight(vboxRight);
        //center
        Button bNext = new Button("next");
        Button bAttack = new Button("attack");
        Button bDefend = new Button("defend");
        Button bItem = new Button("use item");
        Button bFlee = new Button("flee");
        bNext.setPrefWidth(WIDTH / 5);
        bNext.setOnAction(action -> {
            if (game.currentLevelIsStoryInstance()) {
                String text = game.getNextStoryText();
                textAreaEvents.setText(text);
                if (text == null) {
                    boolean success = game.advanceLevel();
                    if (!success) {
                        stage.setScene(getMainMenuScene());
                        return;
                    }
                    stage.setScene(getStartSceneLoading());
                    PauseTransition pause = new PauseTransition(Duration.seconds(1));
                    pause.setOnFinished(x -> {
                        stage.setScene(getBattleScene());
                    });
                    pause.play();
                }
            } else {
                b.opponentTurn();
                b.changeTurn();
                textAreaEvents.setText(b.getTurnout());
                healthMeter.setProgress(b.getPlayerHealthRatio());
                manaMeter.setProgress(b.getPlayerManaRatio());
                bNext.setDisable(true);
                bAttack.setDisable(false);
                bDefend.setDisable(false);
                bItem.setDisable(false);
                bFlee.setDisable(false);
                if (!b.endBattle()) {
                    return;
                }
                textAreaEvents.setText(b.getTurnout());
                Alert a;
                if (b.getPlayerHealthRatio() > 0) {
                    a = new Alert(Alert.AlertType.NONE, "Opponent flees! Success. ", ButtonType.OK);
                    battleCounter++;
                    a.showAndWait();
                    stage.setScene(getBattleScene());
                } else {
                    a = new Alert(Alert.AlertType.NONE, "You died! Failure. ", ButtonType.OK);
                    a.showAndWait();
                    stage.setScene(getMainMenuScene());
                }
            }
        });
        bAttack.setPrefWidth(WIDTH / 5);
        bAttack.setOnAction(action -> {
            b.attacks(true);
            textAreaEvents.setText(b.getTurnout());
            monsHealthMeter.setProgress(b.getMonsterHealthRatio());
            bNext.setDisable(false);
            bAttack.setDisable(true);
            bDefend.setDisable(true);
            bItem.setDisable(true);
            bFlee.setDisable(true);
            if (!b.endBattle()) {
                b.changeTurn();
                return;
            }
            textAreaEvents.setText(b.getTurnout());
            Alert a = new Alert(Alert.AlertType.NONE, "Opponent is conquered! Success", ButtonType.OK);
            battleCounter++;
            a.showAndWait();
            stage.setScene(getBattleScene());
        });
        bDefend.setPrefWidth(WIDTH / 5);
        bDefend.setOnAction(action -> {
            b.defends(true);
            textAreaEvents.setText(b.getTurnout());
            bNext.setDisable(false);
            bAttack.setDisable(true);
            bDefend.setDisable(true);
            bItem.setDisable(true);
            bFlee.setDisable(true);
            b.changeTurn();
        });
        bItem.setPrefWidth(WIDTH / 5);
        bItem.setOnAction(action -> {
            // TODO: set item usage based on selection (and add selection component to UI)
        });
        bFlee.setPrefWidth(WIDTH / 5);
        bFlee.setOnAction(action -> {
            b.flees(true);
            textAreaEvents.setText(b.getTurnout());
            bNext.setDisable(false);
            bAttack.setDisable(true);
            bDefend.setDisable(true);
            bItem.setDisable(true);
            bFlee.setDisable(true);
            if (!b.endBattle()) {
                b.changeTurn();
                return;
            }
            textAreaEvents.setText(b.getTurnout());
            Alert a = new Alert(Alert.AlertType.NONE, "You flee! Success", ButtonType.OK);
            battleCounter++;
            a.showAndWait();
            stage.setScene(getBattleScene());
        });
        if (game.currentLevelIsStoryInstance()
                || (!game.currentLevelIsStoryInstance() && !b.getPlayerTurn())) {
            bNext.setDisable(false);
            bAttack.setDisable(true);
            bDefend.setDisable(true);
            bItem.setDisable(true);
            bFlee.setDisable(true);
        } else if (b.getPlayerTurn()) {
            bNext.setDisable(true);
            bAttack.setDisable(false);
            bDefend.setDisable(false);
            bItem.setDisable(false);
            bFlee.setDisable(false);
        }
        VBox vboxCenter = new VBox(bNext, bAttack, bDefend, bItem, bFlee);
        vboxCenter.setPrefHeight(HEIGHT / 2);
        vboxCenter.setAlignment(Pos.CENTER);
        bp.setCenter(vboxCenter);
        BorderPane.setAlignment(vboxCenter, Pos.BOTTOM_CENTER);
        return battleScene;
    }

}

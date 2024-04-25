package tv2.metamorphose;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main extends Application {
    public Path path = Paths.get("src", "main", "resources", "backgroundMusic.mp3");
    public Media media = new Media(path.toUri().toString());
    public MediaPlayer mediaPlayer = new MediaPlayer(media);

    @Override
    public void start(Stage stage) {
        backgroundMusic();

        StackPane root = new StackPane();
        root.setId("mainMenuBackground");

        Scene scene = new Scene(root, 1250, 1000);
        scene.getStylesheets().add("/StyleSheet.css");

        setupUI(root, stage);

        stage.setScene(scene);
        stage.setWidth(1250);
        stage.setHeight(650);
        stage.show();
    }

    public void backgroundMusic() {
       mediaPlayer.setOnEndOfMedia(new Runnable() {
           @Override
           public void run() {
               mediaPlayer.seek(Duration.ZERO);
           }
       });

        mediaPlayer.play();
    }


    private void setupUI(StackPane root, Stage stage) {
        AnchorPane anchorPane = new AnchorPane();
        root.getChildren().add(anchorPane);
        Rotate rotate = new Rotate(-15,0,0);

        Button playButton = new Button("Start");
        playButton.setId("playButton");
        playButton.setLayoutX(765);
        playButton.setLayoutY(390);
        playButton.getTransforms().add(rotate);
        playButton.setOnAction(event -> {
            try {
                showTutorial(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Button optionButton = new Button("Options");
        optionButton.setId("optionsButton");
        optionButton.setStyle("-fx-pref-width: 285");
        optionButton.setLayoutX(780);
        optionButton.setLayoutY(450);
        optionButton.getTransforms().add(rotate);
        optionButton.setOnAction(event -> {
            try {
                SettingsScene settingsScene = new SettingsScene(stage);
                stage.setScene(settingsScene.getSettingsScene());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Button exitButton = new Button("Exit");
        exitButton.setId("exitButton");
        exitButton.setLayoutX(820);
        exitButton.setLayoutY(520);
        exitButton.getTransforms().add(rotate);
        exitButton.setOnAction(event -> {
            try {
                System.exit(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        anchorPane.getChildren().addAll(playButton,optionButton,exitButton);
    }

    private void showTutorial(Stage stage) {
        VBox tutorialLayout = new VBox(20);
        tutorialLayout.setAlignment(Pos.CENTER);
        tutorialLayout.setPadding(new Insets(50));

        tutorialLayout.setId("dialogueLabel");

        Label instructionLabel = new Label("Tutorial Instructions:");
        instructionLabel.setStyle("-fx-font-weight: bold;");
        instructionLabel.setStyle("-fx-text-fill: white;");

        Label instructionContent = new Label("1. Use the body buttons to select different body parts.\n" +
                "2. Click on each body part to view symptoms.\n" +
                "3. Check the symptom checklist on the right side of the screen.\n" +
                "4. Continue exploring until you're ready to start the game.");

        instructionContent.setStyle("-fx-text-fill: white;");

        Label dialogueLabel = new Label("Dialogue Box: ");
        dialogueLabel.setStyle("-fx-font-weight: bold;");
        dialogueLabel.setStyle("-fx-text-fill: white;");


        Label dialogueContent = new Label("The dialogue box provides information about collected symptoms " +
                "and instructions on how to proceed with the game.");

        dialogueContent.setStyle("-fx-text-fill: white;");

        Button startGameButton = new Button("Start Day");
        startGameButton.setOnAction(event -> {
            new Game(stage, mediaPlayer).startGame();
        });

        tutorialLayout.getChildren().addAll(
                instructionLabel, instructionContent,
                dialogueLabel, dialogueContent,
                startGameButton
        );

        tutorialLayout.setStyle("-fx-background-color: black");

        Scene tutorialScene = new Scene(tutorialLayout, 800, 600);

        stage.setScene(tutorialScene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

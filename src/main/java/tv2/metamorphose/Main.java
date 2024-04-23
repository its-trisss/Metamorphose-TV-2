package tv2.metamorphose;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
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
        VBox vbox = new VBox(25);
        vbox.prefWidthProperty().bind(stage.widthProperty().multiply(0.3));
        vbox.prefHeightProperty().bind(stage.heightProperty().multiply(0.8));
        vbox.setAlignment(Pos.CENTER);
        root.getChildren().add(vbox);

        Button playButton = new Button("Play");
        playButton.setId("playButton");
        playButton.setOnAction(event -> {
            try {
                System.out.println("Play button clicked");
                showTutorial(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Button optionButton = new Button("Options");
        optionButton.setId("optionsButton");
        optionButton.setOnAction(event -> {
            try {
                System.out.println("Options label clicked");
                SettingsScene settingsScene = new SettingsScene(stage);
                stage.setScene(settingsScene.getSettingsScene());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Button exitButton = new Button("Exit");
        exitButton.setId("exitButton");
        exitButton.setOnAction(event -> {
            try {
                System.out.println("Exit label clicked");
                System.exit(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        vbox.getChildren().addAll(playButton, optionButton, exitButton);
        vbox.setSpacing(10);
    }

    private void showTutorial(Stage stage) {
        VBox tutorialLayout = new VBox(20);
        tutorialLayout.setAlignment(Pos.CENTER);
        tutorialLayout.setPadding(new Insets(50));

        tutorialLayout.getStyleClass().add("dialogueLabel");

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

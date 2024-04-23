package tv2.metamorphose;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

public class Game {
    private  Stage stage;
    private  Scene mainGameScene;
    private VBox rightSideScreen;
    private VBox rightSideVBox;
    private VBox centerVBox;
    private  Set<String> discoveredSymptoms;
    private Label dialogueLabel;
    private VBox characterSelection;
    private int currentDay = 1;

    private int currentPatient = 1;

    private String patient;
    private String[] symptoms;
    Days gameplay = new Days(currentDay, currentPatient);
    public Game(Stage primaryStage, MediaPlayer mediaPlayer) {
        showBeginningOfDayScreen(primaryStage);
    }

    private void SetLayout(Stage primaryStage) {
        symptoms = gameplay.symptoms;

        stage = primaryStage;
        this.rightSideVBox = new VBox(10);

        this.rightSideScreen = new VBox(10);
        rightSideScreen = RightSideScreen();
        HBox mainGameLayoutHBox = new HBox(10);
        mainGameLayoutHBox.setAlignment(Pos.CENTER);
        mainGameLayoutHBox.getChildren().addAll(LeftSideScreen(), CenterScreen(), rightSideScreen);
        VBox.setVgrow(rightSideScreen, Priority.ALWAYS);
        VBox.setVgrow(centerVBox, Priority.ALWAYS);

        characterSelection = new VBox(10);
        characterSelection.setAlignment(Pos.CENTER);
        characterSelection.setPadding(new Insets(20));

        mainGameScene = new Scene(mainGameLayoutHBox, 1250, 1000);
        mainGameScene.getStylesheets().add("StyleSheet.css");
        stage.setScene(mainGameScene);
        stage.show();
    }

    public void startGame() {}

    private void showBeginningOfDayScreen(Stage primaryStage) {
        stage = primaryStage;

        VBox beginOfDayLayout = new VBox(10);
        beginOfDayLayout.setAlignment(Pos.CENTER);
        beginOfDayLayout.getStyleClass().add("end-of-day-layout");

        Image doctorImage = new Image("/boar.png");
        ImageView doctorImageView = new ImageView(doctorImage);
        doctorImageView.setFitWidth(400);
        doctorImageView.setFitHeight(600);
        doctorImageView.setPreserveRatio(true);
        doctorImageView.getStyleClass().add("head-image");

        dialogueLabel = new Label(gameplay.beginDayDialogue);
        dialogueLabel.getStyleClass().add("dialogueLabel");
        dialogueLabel.setStyle("-fx-font-size: 13.5");

        Button continueButton = new Button("Start Game");
        continueButton.getStyleClass().add("continueButton");
        continueButton.setOnAction(event -> {
            SetLayout(primaryStage);
        });

        beginOfDayLayout.getChildren().addAll(doctorImageView, dialogueLabel, continueButton);

        Scene beginOfDayScene = new Scene(beginOfDayLayout, 400, 200);
        beginOfDayScene.getStylesheets().add("StyleSheet.css");
        stage.setScene(beginOfDayScene);
        stage.show();
    }

    private void showEndOfDayScreen() {
        VBox endOfDayLayout = new VBox(10);
        endOfDayLayout.setAlignment(Pos.CENTER);
        endOfDayLayout.getStyleClass().add("end-of-day-layout");

        Label endOfDayLabel = new Label("End of Day " + currentDay);
        endOfDayLabel.getStyleClass().add("end-of-day-label");

        Button continueButton = new Button("Continue");
        continueButton.getStyleClass().add("continue-button");
        continueButton.setStyle("-fx-text-fill: white");

        endOfDayLayout.getChildren().addAll(endOfDayLabel, continueButton);

        Scene endOfDayScene = new Scene(endOfDayLayout, 400, 200);
        endOfDayScene.getStylesheets().add("StyleSheet.css");
        stage.setScene(endOfDayScene);
        stage.show();

        continueButton.setOnAction(event -> {
            currentDay++;
            if (currentDay <= 2) {
                stage.setScene(mainGameScene);
                stage.show();
            } else {
                showGameOverScreen();
            }
        });
    }

    private void showGameOverScreen() {
        VBox gameOverLayout = new VBox(10);
        gameOverLayout.setAlignment(Pos.CENTER);

        Path path = Paths.get("src", "main", "resources", "WildBoar.m4a");
        Media media = new Media(path.toUri().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);

        mediaPlayer.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                mediaPlayer.seek(Duration.ZERO);
            }
        });
        mediaPlayer.play();

        Label gameOverLabel = new Label("You've got boar herpes");
        gameOverLabel.getStyleClass().add("boar-herpes");
        Button returnToMainMenuButton = new Button("Return to Main Menu");
        returnToMainMenuButton.getStyleClass().add("return-main-menu");
        gameOverLayout.getStyleClass().add("game-over");
        gameOverLayout.getChildren().addAll(gameOverLabel, returnToMainMenuButton);

        Scene gameOverScene = new Scene(gameOverLayout, 400, 200);
        gameOverScene.getStylesheets().add("StyleSheet.css");
        stage.setScene(gameOverScene);
        stage.show();

        returnToMainMenuButton.setOnAction(event -> {

            currentDay = 1;

            new Main().start(stage);
        });
    }

    private VBox LeftSideScreen() {
        VBox leftSideHBox = new VBox(20);
        leftSideHBox.setPadding(new Insets(10));

        Image characterImg = new Image(gameplay.characterImage);
        ImageView characterImage = new ImageView(characterImg);
        characterImage.setId("characterImage");
        characterImage.setFitWidth(300);
        characterImage.setFitHeight(500);
        characterImage.setPreserveRatio(true);
        leftSideHBox.getStyleClass().add("left-screen");
        HBox bodyButtonsVBox = BodyButtons();
        bodyButtonsVBox.setPrefWidth(150);

        Button backButton = new Button("Back to Main Menu");
        backButton.setOnAction(event -> {

            new Main().start(stage);
        });

        leftSideHBox.getChildren().addAll(characterImage, bodyButtonsVBox, backButton);
        leftSideHBox.getStyleClass().add("black-border");
        return leftSideHBox;
    }

    private HBox BodyButtons() {
        Button armsButton = new Button("Arms");
        Button torsoButton = new Button("Torso");
        Button legsButton = new Button("Legs");

        armsButton.setId("bodyButtons");
        torsoButton.setId("bodyButtons");
        legsButton.setId("bodyButtons");

        armsButton.setOnAction(actionEvent -> {
            BodyButtonAction(gameplay.armImage, "arms");
        });

        torsoButton.setOnAction(actionEvent -> {
            BodyButtonAction(gameplay.torsoImage, "torso");
        });

        legsButton.setOnAction(actionEvent -> {
            BodyButtonAction(gameplay.legImage, "legs");
        });

        VBox armsButtonVBox = new VBox(armsButton);
        VBox torsoButtonVBox = new VBox(torsoButton);
        VBox legsButtonVBox = new VBox(legsButton);

        HBox hBox1 = new HBox(armsButtonVBox, torsoButtonVBox, legsButtonVBox);
        hBox1.setId("blackBox");
        hBox1.setAlignment(Pos.BOTTOM_CENTER);
        hBox1.setSpacing(10);

        HBox hBox = new HBox(hBox1);
        return hBox;
    }

    private void BodyButtonAction(String imageUrl, String bodyPart) {
        ImageView imageView = new ImageView(new Image(imageUrl));
        imageView.setFitWidth(300);
        imageView.setFitHeight(550);

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(imageView, createReturnButton());
        vBox.setId("blackBox");

        Scene closeupOfBodyPartScene = new Scene(vBox);

        ChangeScene(closeupOfBodyPartScene);
    }

    private Button createReturnButton() {
        Button returnButton = new Button("Return");
        returnButton.setId("bodyButtons");
        returnButton.setOnAction(actionEvent -> ChangeScene(mainGameScene));
        return returnButton;
    }

    private VBox CenterScreen() {
        if (centerVBox == null) centerVBox = new VBox(20);
        centerVBox.setAlignment(Pos.CENTER);
        centerVBox.setPadding(new Insets(10));
        centerVBox.getStyleClass().add("center-screen");

        double centerScreenWidth = 400;
        centerVBox.setPrefWidth(centerScreenWidth);

        Label patientName = new Label("Patient: " + gameplay.name);
        patientName.getStyleClass().add("description-label");
        patientName.setAlignment(Pos.TOP_CENTER);

        Image headImage = new Image(gameplay.headImage);
        ImageView headImageView = new ImageView(headImage);
        headImageView.setFitWidth(400);
        headImageView.setFitHeight(600);
        headImageView.setPreserveRatio(true);
        headImageView.getStyleClass().add("head-image");

        Label descriptionLabel = new Label("Character Dialogue");
        descriptionLabel.getStyleClass().add("description-label");

        dialogueLabel = new Label(gameplay.dialogue);
        dialogueLabel.getStyleClass().add("dialogue-label");

        VBox descriptionDialogueBox = new VBox(10);
        descriptionDialogueBox.setAlignment(Pos.CENTER);
        descriptionDialogueBox.getChildren().addAll(patientName, headImageView, descriptionLabel, dialogueLabel);

        centerVBox.getChildren().addAll(descriptionDialogueBox);
        centerVBox.getStyleClass().add("black-border");
        return centerVBox;
    }

    private VBox RightSideScreen() {
        VBox rightSideVBox = new VBox(10);

        Label checklistLabel = new Label("Symptom Checklist");
        checklistLabel.setStyle("-fx-font-size: 18px; -fx-text-fill: black;");
        checklistLabel.setMaxWidth(Double.MAX_VALUE);
        checklistLabel.setWrapText(true);
        rightSideVBox.getChildren().add(checklistLabel);

        for (String symptom : symptoms) {
            CheckBox cb = new CheckBox(symptom);
            cb.setMaxWidth(stage.getWidth() * 0.2);
            cb.setStyle("-fx-text-fill: black;");
            cb.setPadding(new Insets(10));
            rightSideVBox.getChildren().add(cb);
        }

        rightSideVBox.getStyleClass().add("right-screen");
        Button continueButton = new Button(gameplay.buttonName);
        continueButton.setId("continue-button");
        continueButton.setStyle("-fx-padding: 15;");
        continueButton.setAlignment(Pos.BOTTOM_CENTER);

        continueButton.setOnAction(event -> {
            ++currentPatient;

            if (gameplay.buttonName == "Clock Out") {
                if (currentDay == 2) {
                    VBox tbcLayout = new VBox(10);
                    tbcLayout.setAlignment(Pos.CENTER);
                    tbcLayout.getStyleClass().add("end-of-day-layout");

                    Label tbcLabel = new Label("To Be Continued ");
                    tbcLabel.getStyleClass().add("end-of-day-label");

                    Button exitButton = new Button("Continue");
                    exitButton.getStyleClass().add("continue-button");

                    exitButton.setStyle("-fx-text-fill: white");


                    tbcLayout.getChildren().addAll(tbcLabel, exitButton);

                    Scene endOfDayScene = new Scene(tbcLayout, 400, 200);
                    endOfDayScene.getStylesheets().add("StyleSheet.css");
                    stage.setScene(endOfDayScene);
                    stage.show();
                    showGameOverScreen();
                }
                else {
                    showEndOfDayScreen();
                }
            }

            centerVBox = null;
            gameplay = new Days(currentDay, currentPatient);
            SetLayout(stage);

        });

        rightSideVBox.getChildren().add(continueButton);
        rightSideVBox.getStyleClass().add("black-border");
        return rightSideVBox;
    }

    private void ChangeScene(Scene scene) {
        scene.getStylesheets().add("StyleSheet.css");
        stage.setScene(scene);
    }
}

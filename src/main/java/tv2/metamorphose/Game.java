package tv2.metamorphose;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.HashSet;
import java.util.Set;

public class Game {
    private final Stage stage;
    private final Scene mainGameScene;
    private VBox rightSideScreen;
    private VBox rightSideVBox;
    private VBox centerVBox;
    private final Set<String> discoveredSymptoms;
    private Label dialogueLabel;
    private VBox characterSelection;
    private int currentDay = 1;
    private Timeline dayEndTimer = null;
    public Game(Stage primaryStage) {
        this.stage = primaryStage;
        this.discoveredSymptoms = new HashSet<>();
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

        mainGameScene = new Scene(mainGameLayoutHBox, 1250, 650);
        mainGameScene.getStylesheets().add("StyleSheet.css");
        stage.setScene(mainGameScene);
        stage.show();

        //timer for each day
        dayEndTimer = new Timeline(new KeyFrame(Duration.minutes(5), event -> {
            if (currentDay <= 3) {
                showEndOfDayScreen();
            } else {

                dayEndTimer.stop();
            }
        }));
        dayEndTimer.setCycleCount(Timeline.INDEFINITE);
        dayEndTimer.play();
    }

    public void startGame() {
    }

    private void showEndOfDayScreen() {
        VBox endOfDayLayout = new VBox(10);
        endOfDayLayout.setAlignment(Pos.CENTER);
        endOfDayLayout.getStyleClass().add("end-of-day-layout");

        Label endOfDayLabel = new Label("End of Day " + currentDay);
        endOfDayLabel.getStyleClass().add("end-of-day-label");

        Button continueButton = new Button("Continue");
        continueButton.getStyleClass().add("continue-button");

        endOfDayLayout.getChildren().addAll(endOfDayLabel, continueButton);

        Scene endOfDayScene = new Scene(endOfDayLayout, 400, 200);
        endOfDayScene.getStylesheets().add("StyleSheet.css");
        stage.setScene(endOfDayScene);
        stage.show();

        continueButton.setOnAction(event -> {
            currentDay++;
            if (currentDay <= 3) {
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
            dayEndTimer.stop();

            currentDay = 1;

            new Main().start(stage);
        });
    }

    private VBox LeftSideScreen() {
        VBox leftSideHBox = new VBox(20);
        leftSideHBox.setPadding(new Insets(10));

        Image characterImg = new Image("/character.png");
        ImageView characterImage = new ImageView(characterImg);
        characterImage.setId("characterImage");
        characterImage.setFitWidth(300);
        characterImage.setFitHeight(600);
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
        String headImageUrl = "/face.png";
        String armsImageUrl = "/arms.png";
        String torsoImageUrl = "/torso.png";
        String legsImageUrl = "/legs.png";

        Button headButton = new Button("Head");
        Button armsButton = new Button("Arms");
        Button torsoButton = new Button("Torso");
        Button legsButton = new Button("Legs");

        headButton.setId("bodyButtons");
        armsButton.setId("bodyButtons");
        torsoButton.setId("bodyButtons");
        legsButton.setId("bodyButtons");

        headButton.setOnAction(actionEvent -> {
            BodyButtonAction(headImageUrl, "head");
        });

        armsButton.setOnAction(actionEvent -> {
            BodyButtonAction(armsImageUrl, "arms");
        });

        torsoButton.setOnAction(actionEvent -> {
            BodyButtonAction(torsoImageUrl, "torso");
        });

        legsButton.setOnAction(actionEvent -> {
            BodyButtonAction(legsImageUrl, "legs");
        });

        VBox headButtonVBox = new VBox(headButton);
        VBox armsButtonVBox = new VBox(armsButton);
        VBox torsoButtonVBox = new VBox(torsoButton);
        VBox legsButtonVBox = new VBox(legsButton);

        VBox vBox = new VBox(headButtonVBox, armsButtonVBox, torsoButtonVBox, legsButtonVBox);
        vBox.setId("blackBox");
        vBox.setAlignment(Pos.BOTTOM_CENTER);
        vBox.setSpacing(10);

        HBox hBox = new HBox(vBox);
        return hBox;
    }

    private void BodyButtonAction(String imageUrl, String bodyPart) {
        discoveredSymptoms.add(bodyPart);
        ImageView imageView = new ImageView(new Image(imageUrl));
        imageView.setFitWidth(300);
        imageView.setFitHeight(550);

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(imageView, createReturnButton());
        vBox.setId("blackBox");

        Scene closeupOfBodyPartScene = new Scene(vBox);

        ChangeScene(closeupOfBodyPartScene);

        updateSymptomsChecklist();
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

        Image headImage = new Image("/head.png");
        ImageView headImageView = new ImageView(headImage);
        headImageView.setFitWidth(400);
        headImageView.setFitHeight(600);
        headImageView.setPreserveRatio(true);
        headImageView.getStyleClass().add("head-image");

        Label descriptionLabel = new Label("Description of character");
        descriptionLabel.getStyleClass().add("description-label");

        dialogueLabel = new Label("Dialogue goes here");
        dialogueLabel.getStyleClass().add("dialogue-label");

        VBox descriptionDialogueBox = new VBox(10);
        descriptionDialogueBox.setAlignment(Pos.CENTER);
        descriptionDialogueBox.getChildren().addAll(headImageView, descriptionLabel, dialogueLabel);

        centerVBox.getChildren().addAll(descriptionDialogueBox);
        centerVBox.getStyleClass().add("black-border");
        return centerVBox;
    }

    private VBox RightSideScreen() {
        VBox rightSideVBox = new VBox(10);

        Label checklistLabel = new Label("Symptom Checklist");
        checklistLabel.setStyle("-fx-font-size: 18px; -fx-text-fill: #ecf0f1;");
        checklistLabel.setMaxWidth(Double.MAX_VALUE);
        checklistLabel.setWrapText(true);
        rightSideVBox.getChildren().add(checklistLabel);

        String[] symptoms = new String[]{"Swelling", "Rash", "Bruising", "Sweating", "Wounds", "Pallor", "Bloodshot eyes", "Skin Lesions", "Gangrene", "Facial Drooping"};
        for (String symptom : symptoms) {
            CheckBox cb = new CheckBox(symptom);
            cb.setMaxWidth(stage.getWidth() * 0.2);
            cb.setStyle("-fx-text-fill: white;");
            rightSideVBox.getChildren().add(cb);
        }
        rightSideVBox.getStyleClass().add("right-screen");
        Button continueButton = new Button("Continue");
        continueButton.setId("continueButton");
        continueButton.setStyle("-fx-padding: 15;");
        rightSideVBox.getChildren().add(continueButton);
        rightSideVBox.getStyleClass().add("black-border");
        return rightSideVBox;
    }

    private void updateSymptomsChecklist() {
        for (Node child : rightSideVBox.getChildren()) {
            if (child instanceof CheckBox checkBox) {
                if (discoveredSymptoms.contains(checkBox.getText())) {
                    checkBox.setVisible(true);
                }
            }
        }
        rightSideVBox.setVisible(!discoveredSymptoms.isEmpty());
    }

    private void ChangeScene(Scene scene) {
        scene.getStylesheets().add("StyleSheet.css");
        rightSideVBox.setVisible(!discoveredSymptoms.isEmpty());
        stage.setScene(scene);
    }
}

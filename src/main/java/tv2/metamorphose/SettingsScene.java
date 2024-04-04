package tv2.metamorphose;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SettingsScene {
    private final Scene settingsScene;

    public SettingsScene(Stage stage) {
        VBox settingsLayout = new VBox(20);
        settingsLayout.setAlignment(Pos.CENTER);
        settingsLayout.setPadding(new Insets(10));
        settingsLayout.setStyle("-fx-background-color: black;");

        // Volume Sliders VBoxes
        VBox sfxVolumeBox = new VBox(10);
        VBox musicVolumeBox = new VBox(10);
        sfxVolumeBox.setAlignment(Pos.CENTER);
        musicVolumeBox.setAlignment(Pos.CENTER);

        // Sound Effects Volume Label and Slider
        Label sfxVolumeLabel = new Label("Sound Effects Volume");
        sfxVolumeLabel.setStyle("-fx-text-fill: white;");
        Slider sfxVolumeSlider = new Slider(0, 100, 50);
        VBox sfxVolumeSliderContainer = new VBox(sfxVolumeSlider);
        sfxVolumeSliderContainer.setAlignment(Pos.CENTER);
        sfxVolumeSliderContainer.setPrefWidth(100);
        sfxVolumeSliderContainer.setPrefHeight(50);
        sfxVolumeSlider.setId("sfxVolumeSlider");
        sfxVolumeSlider.setShowTickLabels(true);
        sfxVolumeSlider.setShowTickMarks(true);

        // Music Volume Label and Slider
        Label musicVolumeLabel = new Label("Music Volume");
        musicVolumeLabel.setStyle("-fx-text-fill: white;");
        Slider musicVolumeSlider = new Slider(0, 100, 50);
        VBox musicVolumeSliderContainer = new VBox(musicVolumeSlider);
        musicVolumeSliderContainer.setAlignment(Pos.CENTER);
        musicVolumeSliderContainer.setPrefWidth(100); // Adjust width as needed
        musicVolumeSliderContainer.setPrefHeight(50);
        musicVolumeSlider.setId("musicVolumeSlider");
        musicVolumeSlider.setShowTickLabels(true);
        musicVolumeSlider.setShowTickMarks(true);

        sfxVolumeBox.getChildren().addAll(sfxVolumeLabel, sfxVolumeSlider);
        musicVolumeBox.getChildren().addAll(musicVolumeLabel, musicVolumeSlider);

        settingsLayout.getChildren().addAll(sfxVolumeBox, musicVolumeBox);
        settingsScene = new Scene(settingsLayout, stage.getWidth(), stage.getHeight());
        settingsScene.getStylesheets().add(getClass().getResource("/StyleSheet.css").toExternalForm());

        Button backButton = new Button("Back to Main Menu");
        backButton.setOnAction(event -> {
            new Main().start(stage);
        });

        settingsLayout.getChildren().add(backButton);
    }

    public void show(Stage stage) {
        stage.setScene(settingsScene);
        stage.setFullScreen(true);
    }

    public Scene getSettingsScene() {
        return settingsScene;
    }
}

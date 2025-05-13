package chibichan;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;

public class ChibichanApp extends Application {

    // The pet object we play with
    private Chibichan pet;

    // This label shows the pet's status
    private Label statusLabel;

    public static void main(String[] args) {
        launch(args); // start JavaFX app
    }

    @Override
    public void start(Stage stage) {
        // Try to load saved game
        pet = ChibichanGame.loadGame();

        // If nothing is loaded, create a new pet
        if (pet == null) {
            pet = new Chibichan("Chibi"); // we just name it Chibi for now
        }

        // Create a label to show pet stats
        statusLabel = new Label();
        updateStatus(); // first time display

        // Create buttons for each action
        Button feedButton = new Button("Feed");
        Button playButton = new Button("Play");
        Button sleepButton = new Button("Sleep");
        Button medicineButton = new Button("Take Medicine");
        Button bathButton = new Button("Bathe");
        Button walkButton = new Button("Walk");
        Button randomEventButton = new Button("Random Event");
        Button quitButton = new Button("Save and Exit");

        // Set what happens when buttons are clicked
        feedButton.setOnAction(e -> {
            pet.feed();
            pet.tick();
            updateStatus();
        });

        playButton.setOnAction(e -> {
            pet.play();
            pet.tick();
            updateStatus();
        });

        sleepButton.setOnAction(e -> {
            pet.sleep();
            pet.tick();
            updateStatus();
        });

        medicineButton.setOnAction(e -> {
            pet.takeMedicine();
            pet.tick();
            updateStatus();
        });

        bathButton.setOnAction(e -> {
            pet.bathe();
            pet.tick();
            updateStatus();
        });

        walkButton.setOnAction(e -> {
            pet.walk();
            pet.tick();
            updateStatus();
        });

        randomEventButton.setOnAction(e -> {
            pet.randomEvent();
            pet.tick();
            updateStatus();
        });

        quitButton.setOnAction(e -> {
            ChibichanGame.saveGame(pet);
            stage.close(); // exit the app
        });

        // Layout the buttons and label
        VBox root = new VBox();
        root.setSpacing(10); // space between buttons
        root.setPadding(new Insets(15)); // space around the window

        // Add everything to the layout
        root.getChildren().addAll(
                statusLabel,
                feedButton,
                playButton,
                sleepButton,
                medicineButton,
                bathButton,
                walkButton,
                randomEventButton,
                quitButton
        );

        // Create and show the window
        Scene scene = new Scene(root, 300, 420);
        stage.setTitle("My Chibichan Pet");
        stage.setScene(scene);
        stage.show();
    }

    // This method shows the pet's status on the screen
    private void updateStatus() {
        if (!pet.isAlive()) {
            statusLabel.setText(pet.getName() + " has passed away... 😢");
        } else {
            String info = "Name: " + pet.getName() + "\n";
            info += "Hunger: " + pet.getHunger() + "\n";
            info += "Happiness: " + pet.getHappiness() + "\n";
            info += "Energy: " + pet.getEnergy() + "\n";
            info += "Health: " + pet.getHealth();
            statusLabel.setText(info);
        }
    }
}


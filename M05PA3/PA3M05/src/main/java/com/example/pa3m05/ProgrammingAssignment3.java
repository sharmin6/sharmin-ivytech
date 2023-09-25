package com.example.pa3m05;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ProgrammingAssignment3 extends Application {

    public static void main(String[] args) {
        launch(args); // Launch the JavaFX application
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("M05ProgrammingAssignment3 - Use Scrollbar And Slider"); // Set the title of the application window

        Label textLabel = new Label("Show Color"); // Create a label with the text "Show Color"
        textLabel.setFont(new Font(24)); // Set the font size of the label

        Slider[] sliders = {
                createSlider("Red", 0, 255, 0, 85), // Create a red slider
                createSlider("Green", 0, 255, 0, 85), // Create a green slider
                createSlider("Blue", 0, 255, 0, 85), // Create a blue slider
                createSlider("Opacity", 0, 1, 1, 0.25) // Create an opacity slider
        };

        textLabel.setTextFill(Color.BLACK); // Set the initial text color to black

        for (Slider slider : sliders) {
            slider.valueProperty().addListener((obs, oldValue, newValue) -> updateTextColor(textLabel, sliders)); // Add a listener to each slider to update the text color
        }

        GridPane grid = new GridPane(); // Create a grid layout
        grid.setHgap(10); // Set horizontal gap between elements in the grid
        grid.setVgap(10); // Set vertical gap between elements in the grid

        for (int i = 0; i < sliders.length; i++) {
            grid.addRow(i, new Label(sliders[i].getUserData().toString() + ":"), sliders[i]); // Add labels and sliders to the grid
        }

        VBox root = new VBox(20); // Create a vertical layout
        root.getChildren().addAll(textLabel, grid); // Add the label and grid to the layout

        Scene scene = new Scene(root, 600, 400); // Create a scene with a specified width and height
        stage.setScene(scene); // Set the scene for the stage
        stage.show(); // Show the application window
    }

    private Slider createSlider(String label, double min, double max, double initialValue, double majorTickUnit) {
        Slider slider = new Slider(min, max, initialValue); // Create a slider with specified min, max, and initial value
        slider.setShowTickMarks(true); // Show tick marks on the slider
        slider.setShowTickLabels(true); // Show tick labels on the slider
        slider.setMajorTickUnit(majorTickUnit); // Set the major tick unit for the slider
        slider.setBlockIncrement(1); // Set the block increment for the slider
        slider.setPrefWidth(300); // Set the preferred width of the slider
        slider.setMinWidth(100); // Set the minimum width of the slider
        slider.setMaxWidth(400); // Set the maximum width of the slider
        slider.setUserData(label); // Set user data for the slider to store the label
        return slider; // Return the created slider
    }

    private void updateTextColor(Label textLabel, Slider[] sliders) {
        double red = sliders[0].getValue() / 255.0; // Get the value of the red slider
        double green = sliders[1].getValue() / 255.0; // Get the value of the green slider
        double blue = sliders[2].getValue() / 255.0; // Get the value of the blue slider
        double opacity = sliders[3].getValue(); // Get the value of the opacity slider

        Color textColor = new Color(red, green, blue, opacity); // Create a Color object with the selected values
        textLabel.setTextFill(textColor); // Set the text color of the label to the selected color
    }
}

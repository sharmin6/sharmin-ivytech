package com.example.pa2m05;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class ProgrammingAssignment2 extends Application {

    public static void main(String[] args) {
        //The launch method is to start the JavaFX application inside the main
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        //Set the title of the stage/window
        stage.setTitle("M05 Programming Assignment 2 - Change Color Using Mouse");

        //Created a white circle with a positions of 200, 200, radius of 100.
        Circle circle = new Circle(200, 200, 100, Color.WHITE);

        //Set the outer border of the circle to black
        circle.setStroke(Color.BLACK);

        //Set an event handler for when the mouse button, which will change the circle to black when the mouse is pressed
        circle.setOnMousePressed(event -> circle.setFill(Color.BLACK));

        //Set an event handler for when the mouse button to changing the circle's color to white the mouse is released
        circle.setOnMouseReleased(event -> circle.setFill(Color.WHITE));

        //Created a StackPane layout to put in the circle
        StackPane root = new StackPane();
        root.getChildren().add(circle);

        //Created a scene with the size of 500x500 and set it as the scene for the stage
        Scene scene = new Scene(root, 500, 500);
        stage.setScene(scene);

        //Showing the stage
        stage.show();
    }
}

package com.example.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ViewImages extends Application {
    public static void main(String[] args) {
        //launch method is being used to start/showcase the window/stage
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // Set the title of the window.
        stage.setTitle("M05 Programming Assignment - Display 4 images");

        // Created a new GridPane layout to organize the images and using the gridPane to make changes
        // to the position of the images .
        GridPane gridPane = new GridPane();

        // Load four images: ca.gif, china.gif, uk.gif, and us.gif.
        Image ca = new Image("ca.gif");
        Image china = new Image("china.gif");
        Image uk = new Image("uk.gif");
        Image us = new Image("us.gif");

        // Create ImageView objects for each image so that it could be viewed.
        ImageView viewCanada = new ImageView(ca);
        ImageView viewChina = new ImageView(china);
        ImageView viewUk = new ImageView(uk);
        ImageView viewUs = new ImageView(us);

        // Added ImageView objects to the GridPane with specific row and column indices to arrange
        // their position by in a 2x2 grid.
        gridPane.add(viewCanada, 0, 0);
        gridPane.add(viewChina, 1, 0);
        gridPane.add(viewUk, 0, 1);
        gridPane.add(viewUs, 1, 1);

        // Created a Scene object and passing in the GridPane as the root layout.
        Scene scene = new Scene(gridPane);

        // Set the Scene on the Stage and display the application window.
        stage.setScene(scene);
        stage.show();
    }
}
// NOTE: You can click on the tasks after you have added them to read the descriptions you have written
// You can also delete the tasks after you have already added

package com.example.finalproject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

// The main class representing the Task Manager, extending the JavaFX Application class
public class TaskManager extends Application {
    // Fields for managing tasks and displaying them in lists
    private Manager taskManager = new Manager();
    private ListView<Task> taskListView = new ListView<>();
    private ListView<String> descriptionListView = new ListView<>();

    // The main entry point of the application to be launch or run the code
    public static void main(String[] args) {
        // Launches the JavaFX application
        launch(args);
    }

    // Override method for configuring the primary stage and building the UI
    @Override
    public void start(Stage primaryStage) {
        // Set the title of the application window
        primaryStage.setTitle("Task Management System");

        // Create UI components for adding and managing tasks
        Label titleLabel = new Label("Add Task");  // Label for the task addition section
        titleLabel.setStyle("-fx-font-size: 20; -fx-font-weight: bold;");  // Styling for the label
        TextField titleInput = new TextField();  // Text field for entering task names
        titleInput.setPromptText("Task Name");  // Placeholder text in the text field
        titleInput.setMaxWidth(300);  // Maximum width of the text field
        titleInput.setStyle("-fx-font-size: 14;");  // Styling for the text field
        TextArea descriptionInput = new TextArea();  // Text area for entering task descriptions
        descriptionInput.setPromptText("Task Description");  // Placeholder text in the text area
        descriptionInput.setMaxWidth(300);  // Maximum width of the text area
        descriptionInput.setMaxHeight(100);  // Maximum height of the text area
        descriptionInput.setStyle("-fx-font-size: 14;");  // Styling for the text area
        Button addButton = new Button("Add Task");  // Button for adding tasks
        addButton.setStyle("-fx-font-size: 16; -fx-background-color: #4CAF50; -fx-text-fill: white;");  // Styling for the button
        Button deleteButton = new Button("Delete Task");  // Button for deleting tasks
        deleteButton.setStyle("-fx-font-size: 16; -fx-background-color: #F44336; -fx-text-fill: white;");  // Styling for the button

        // Event handler for adding a task when the "Add Task" button is clicked
        addButton.setOnAction(e -> {
            String title = titleInput.getText();
            String description = descriptionInput.getText();
            if (!title.isEmpty()) {
                Task task = new TodoTask(title, description);
                taskManager.addTask(task);
                taskListView.getItems().add(task);
                titleInput.clear();
                descriptionInput.clear();
                updateTaskList();  // Updates the task list in the UI
            }
        });

        // Event handler for deleting a task when the "Delete Task" button is clicked
        deleteButton.setOnAction(e -> {
            Task selectedTask = taskListView.getSelectionModel().getSelectedItem();
            if (selectedTask != null) {
                taskManager.deleteTask(selectedTask);
                taskListView.getItems().remove(selectedTask);
                descriptionListView.getItems().clear();
            }
        });

        // Event handler for selecting a task in the taskListView
        taskListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                descriptionListView.getItems().clear();
                descriptionListView.getItems().addAll("Task Description:", newValue.description);
            } else {
                descriptionListView.getItems().clear();
            }
        });

        // Set up the main layout using VBox and HBox for organizing UI components
        VBox mainLayout = new VBox(10);  // Vertical box for organizing components with 10 pixels spacing
        mainLayout.setPadding(new Insets(20));  // Padding around the main layout
        mainLayout.setStyle("-fx-background-color: #f0f0f0;");  // Background color for the main layout
        mainLayout.getChildren().addAll(
                titleLabel,
                new HBox(10, new Label("Title:"), titleInput),  // Horizontal box for organizing title-related components
                new HBox(10, new Label("Description:"), descriptionInput),  // Horizontal box for organizing description-related components
                new HBox(10, addButton, deleteButton),  // Horizontal box for organizing buttons
                new HBox(10, taskListView, descriptionListView)  // Horizontal box for organizing task and description lists
        );

        // Equalize the preferred height of the taskListView and descriptionListView
        taskListView.setPrefHeight(200);
        descriptionListView.setPrefHeight(200);

        // Create the scene with a larger stage size
        Scene scene = new Scene(new BorderPane(mainLayout, null, null, null, null), 800, 600);
        primaryStage.setScene(scene);  // Set the scene to the stage
        primaryStage.show();  // Display the stage
    }

    // Method for updating the task list in the UI
    private void updateTaskList() {
        taskListView.getItems().clear();
        descriptionListView.getItems().clear();
        int taskNumber = 1;
        for (Task task : taskManager.getTasks()) {
            taskListView.getItems().add(task);
            descriptionListView.getItems().addAll(taskNumber + ". " + task.title);
            taskNumber++;
        }
    }
}

// Class representing a generic task with title and description
class Task {
    protected String title;  // Title of the task
    protected String description;  // Description of the task

    // Constructor for initializing a task with title and description
    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    // Override method to return the title of the task as its string representation
    @Override
    public String toString() {
        return title;
    }
}

// Subclass of Task representing a todo task
class TodoTask extends Task {
    // Constructor for initializing a todo task with title and description
    public TodoTask(String title, String description) {
        super(title, description);
    }
}

// Class representing a manager for tasks with methods to add, delete, and retrieve tasks
class Manager {
    private List<Task> tasks = new ArrayList<>();  // List to store tasks

    // Method for adding a task to the task list
    public void addTask(Task task) {
        tasks.add(task);
    }

    // Method for deleting a task from the task list
    public void deleteTask(Task task) {
        tasks.remove(task);
    }

    // Method for retrieving the list of tasks
    public List<Task> getTasks() {
        return tasks;
    }
}
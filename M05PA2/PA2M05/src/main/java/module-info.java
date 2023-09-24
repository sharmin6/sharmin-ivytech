module com.example.pa2m05 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pa2m05 to javafx.fxml;
    exports com.example.pa2m05;
}
module com.example.pa3m05 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pa3m05 to javafx.fxml;
    exports com.example.pa3m05;
}
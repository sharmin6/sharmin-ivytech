module com.example.testforpr {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.finalproject to javafx.fxml;
    exports com.example.finalproject;
}
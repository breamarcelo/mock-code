module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;

    opens com.example to javafx.fxml;
    exports com.example;
}

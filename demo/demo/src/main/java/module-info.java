module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires jakarta.xml.bind;

    opens com.example to javafx.fxml, jakarta.xml.bind;
    exports com.example;
}

module com.budgetsgenerator {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.budgetsgenerator to javafx.fxml;
    exports com.budgetsgenerator;
}

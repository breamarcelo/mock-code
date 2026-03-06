module com.budgetsgenerator {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;

    opens com.budgetsgenerator to javafx.fxml;
    exports com.budgetsgenerator;
}

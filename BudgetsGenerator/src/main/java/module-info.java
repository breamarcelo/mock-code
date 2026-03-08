module com.budgetsgenerator {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;

    opens com.budgetsgenerator to javafx.fxml;
    opens com.budgetsgenerator.models to org.hibernate.orm.core;
    exports com.budgetsgenerator;
}

package com.example;

import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        Stage window = stage;
        window.setTitle("demo");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label empHeader = new Label("Employees");
        GridPane.setColumnSpan(empHeader, 2);
        GridPane.setConstraints(empHeader, 0, 0);

        ListView<String> ls = new ListView<String>();
        ls.setMaxHeight(285);
        ls.setMaxWidth(200);
        GridPane.setColumnSpan(ls, 2);
        GridPane.setRowSpan(ls, 10);
        GridPane.setConstraints(ls, 0, 1);
        
        Button addEmpBtn = new Button("Add");
        addEmpBtn.setMinWidth(95);
        GridPane.setConstraints(addEmpBtn, 0, 11);
        
        Button delEmpBtn = new Button("Delete");
        delEmpBtn.setMaxWidth(95);
        GridPane.setConstraints(delEmpBtn, 1, 11);
        
        Label idLabel = new Label("ID:");
        GridPane.setColumnSpan(idLabel, 2);
        GridPane.setConstraints(idLabel, 2, 1);
        
        TextField idInput = new TextField();
        GridPane.setColumnSpan(idInput, 2);
        GridPane.setConstraints(idInput, 2, 2);

        Label nameLabel = new Label("Name:");
        GridPane.setColumnSpan(nameLabel, 2);
        GridPane.setConstraints(nameLabel, 2, 3);
        
        TextField nameInput = new TextField();
        GridPane.setColumnSpan(nameInput, 2);
        GridPane.setConstraints(nameInput, 2, 4);

        Label lNameLabel = new Label("Last name:");
        GridPane.setColumnSpan(lNameLabel, 2);
        GridPane.setConstraints(lNameLabel, 2, 5);
        
        TextField lNameInput = new TextField();
        GridPane.setColumnSpan(lNameInput, 2);
        GridPane.setConstraints(lNameInput, 2, 6);

        Label departmentLabel = new Label("Department:");
        GridPane.setColumnSpan(departmentLabel, 2);
        GridPane.setConstraints(departmentLabel, 2, 7);
        
        TextField departmentInput = new TextField();
        departmentInput.setDisable(true);
        GridPane.setColumnSpan(departmentInput, 2);
        GridPane.setConstraints(departmentInput, 2, 8);

        Label salaryLabel = new Label("Salary:");
        GridPane.setColumnSpan(salaryLabel, 2);
        GridPane.setConstraints(salaryLabel, 2, 9);
        
        TextField salaryInput = new TextField();
        GridPane.setColumnSpan(salaryInput, 2);
        GridPane.setConstraints(salaryInput, 2, 10);
        
        Button editEmpBtn = new Button("Edit");
        editEmpBtn.setMinWidth(95);
        GridPane.setConstraints(editEmpBtn, 2, 11);
        
        Button saveEditEmpBtn = new Button("Save");
        saveEditEmpBtn.setMinWidth(95);
        GridPane.setConstraints(saveEditEmpBtn, 3, 11);
        
        Label deptHeader = new Label("Departments");
        GridPane.setColumnSpan(deptHeader, 2);
        GridPane.setConstraints(deptHeader, 4, 0);
        
        ListView<String> deptList = new ListView<String>();
        deptList.setMaxHeight(142.5);
        deptList.setMaxWidth(200);
        GridPane.setColumnSpan(deptList, 2);
        GridPane.setRowSpan(deptList, 5);
        GridPane.setConstraints(deptList, 4, 1);

        Button addDeptBtn = new Button("Add");
        addDeptBtn.setMinWidth(95);
        GridPane.setConstraints(addDeptBtn, 4, 6);

        Button delDeptBtn = new Button("Delete");
        delDeptBtn.setMinWidth(95);
        GridPane.setConstraints(delDeptBtn, 5, 6);
        
        Label deptIdLabel = new Label("ID:");
        GridPane.setColumnSpan(deptIdLabel, 2);
        GridPane.setConstraints(deptIdLabel, 4, 7);
        
        TextField deptIdInput = new TextField();
        GridPane.setColumnSpan(deptIdInput, 2);
        GridPane.setConstraints(deptIdInput, 4, 8);
        
        Label deptNameLabel = new Label("Name:");
        GridPane.setColumnSpan(deptNameLabel, 2);
        GridPane.setConstraints(deptNameLabel, 4, 9);
        
        TextField deptNameInput = new TextField();
        GridPane.setColumnSpan(deptNameInput, 2);
        GridPane.setConstraints(deptNameInput, 4, 10);
        
        Button editDeptBtn = new Button("Edit");
        editDeptBtn.setMinWidth(95);
        GridPane.setConstraints(editDeptBtn, 4, 11);
        
        Button saveEditDeptBtn = new Button("Save");
        saveEditDeptBtn.setMinWidth(95);
        GridPane.setConstraints(saveEditDeptBtn, 5, 11);
        
        grid.getChildren().addAll(empHeader, ls, addEmpBtn, delEmpBtn, idLabel, idInput, nameLabel, nameInput, lNameLabel, 
        lNameInput, departmentLabel, departmentInput, salaryLabel, salaryInput, editEmpBtn, saveEditEmpBtn, deptHeader, 
        deptList, addDeptBtn, delDeptBtn, deptIdLabel, deptIdInput, deptNameLabel, deptNameInput, editDeptBtn, saveEditDeptBtn);
        Scene scene = new Scene(grid);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
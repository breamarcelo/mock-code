package com.example;

import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
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
        BorderPane root = new BorderPane();

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);
        grid.setPrefSize(800, 500);

        for(int i=0; i<6; i++){
            ColumnConstraints col = new ColumnConstraints();
            grid.getColumnConstraints().add(col);
            col.setPercentWidth(33);
        }

        for(int i=0; i<12; i++){
            RowConstraints row = new RowConstraints();
            grid.getRowConstraints().add(row);
            row.setPercentHeight(10);
        }

        Label empHeader = new Label("Employees");
        grid.add(empHeader, 0, 0, 2, 1);

        ListView<String> ls = new ListView<String>();
        grid.add(ls, 0, 1, 2, 10);
        
        Button addEmpBtn = new Button("Add");
        grid.add(addEmpBtn, 0, 11);
        
        Button delEmpBtn = new Button("Delete");
        grid.add(delEmpBtn, 1, 11);
        
        Label idLabel = new Label("ID:");
        grid.add(idLabel, 2, 1, 2, 1);
        
        TextField idInput = new TextField();
        grid.add(idInput, 2, 2, 2, 1);

        Label nameLabel = new Label("Name:");
        grid.add(nameLabel, 2, 3, 2, 1);
        
        TextField nameInput = new TextField();
        grid.add(nameInput, 2, 4, 2, 1);
        
        Label lNameLabel = new Label("Last name:");
        grid.add(lNameLabel, 2, 5, 2, 1);
        
        TextField lNameInput = new TextField();
        grid.add(lNameInput, 2, 6, 2, 1);
        
        Label departmentLabel = new Label("Department:");
        grid.add(departmentLabel, 2, 7, 2, 1);
        
        TextField departmentInput = new TextField();
        grid.add(departmentInput, 2, 8, 2, 1);
        
        Label salaryLabel = new Label("Salary:");
        grid.add(salaryLabel, 2, 9, 2, 1);
        
        TextField salaryInput = new TextField();
        grid.add(salaryInput, 2, 10, 2, 1);
        
        Button editEmpBtn = new Button("Edit");
        grid.add(editEmpBtn, 2, 11);
        
        Button saveEditEmpBtn = new Button("Save");
        grid.add(saveEditEmpBtn, 3, 11);
        
        Label deptHeader = new Label("Departments");
        grid.add(deptHeader, 4, 0, 2, 1);
        
        ListView<String> deptList = new ListView<String>();
        grid.add(deptList, 4, 1, 2, 5);
        
        Button addDeptBtn = new Button("Add");
        grid.add(addDeptBtn, 4, 6);
        
        Button delDeptBtn = new Button("Delete");
        grid.add(delDeptBtn, 5, 6);
        
        Label deptIdLabel = new Label("ID:");
        grid.add(deptIdLabel, 4, 7, 2, 1);
        
        TextField deptIdInput = new TextField();
        grid.add(deptIdInput, 4, 8, 2, 1);
        
        Label deptNameLabel = new Label("Name:");
        grid.add(deptNameLabel, 4, 9, 2, 1);
        
        TextField deptNameInput = new TextField();
        grid.add(deptNameInput, 4, 10, 2, 1);
        
        Button editDeptBtn = new Button("Edit");
        grid.add(editDeptBtn, 4, 11);
        
        Button saveEditDeptBtn = new Button("Save");
        grid.add(saveEditDeptBtn, 5, 11);
        
        root.setCenter(grid);
        Scene scene = new Scene(root);
        scene.getStylesheets().add("styles.css");
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
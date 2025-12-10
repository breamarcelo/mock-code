package com.example;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.xml.sax.SAXException;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

// needs implementation

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException, SAXException, TransformerConfigurationException, ParserConfigurationException, TransformerException {
        Stage window = stage;
        window.resizableProperty().set(false);
        window.setTitle("demo");
        BorderPane root = new BorderPane();

        GridPane grid = new GridPane();
        grid.setId("gridpane");
        grid.setPadding(new Insets(20,20,20,20));
        grid.setVgap(10);
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
        empHeader.getStyleClass().add("header");
        grid.add(empHeader, 0, 0, 2, 1);
        
        
        Button delEmpBtn = new Button("Delete");
        grid.add(delEmpBtn, 1, 11);
        delEmpBtn.setBorder(null);;
        
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
        deptHeader.getStyleClass().add("header");
        grid.add(deptHeader, 4, 0, 2, 1);
        
        
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

        idInput.setDisable(true);
        nameInput.setDisable(true);
        lNameInput.setDisable(true);
        departmentInput.setDisable(true);
        salaryInput.setDisable(true);

        EmployeeParser empParser = new EmployeeParser();
        loadEmployeeList(empParser, grid,idInput, nameInput, lNameInput, departmentInput, salaryInput);
        // Buttons

        Button addEmpBtn = new Button("Add");
        grid.add(addEmpBtn, 0, 11);
        addEmpBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Button pressed");
                if(addEmpBtn.getText().equals("Add")){
                    idInput.setDisable(false);
                    idInput.setText("");
                    nameInput.setDisable(false);
                    nameInput.setText("");
                    lNameInput.setDisable(false);
                    lNameInput.setText("");
                    departmentInput.setDisable(false);
                    departmentInput.setText("");
                    salaryInput.setDisable(false);
                    salaryInput.setText("");
                    addEmpBtn.setText("Submit");
                } else {
                    int id = Integer.parseInt(idInput.getText());
                    String name = nameInput.getText();
                    String lName = lNameInput.getText();
                    String dept = departmentInput.getText();
                    double salary = Double.parseDouble(salaryInput.getText());
                    try {
                        empParser.addNewEmp(id, name, lName, dept, salary);
                    } catch (TransformerConfigurationException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (SAXException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (TransformerException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (TransformerFactoryConfigurationError e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    idInput.setDisable(true);
                    idInput.setText("");
                    nameInput.setDisable(true);
                    nameInput.setText("");
                    lNameInput.setDisable(true);
                    lNameInput.setText("");
                    departmentInput.setDisable(true);
                    departmentInput.setText("");
                    salaryInput.setDisable(true);
                    salaryInput.setText("");
                    addEmpBtn.setText("add");
                    try {
                        loadEmployeeList(empParser, grid,idInput, nameInput, lNameInput, departmentInput, salaryInput);
                    } catch (SAXException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
            
        });
        
        ListView<String> deptList = new ListView<String>();
        grid.add(deptList, 4, 1, 2, 5);
        for (int i = 0; i < 10; i++) {
            deptList.getItems().add("Department " + i);
        }
        
        root.setCenter(grid);
        Scene scene = new Scene(root);
        scene.getStylesheets().add("styles.css");
        window.setScene(scene);
        window.show();
    }
    
    public static void loadEmployeeList(EmployeeParser empParser, GridPane grid, TextField idInput, TextField nameInput, TextField lNameInput, TextField departmentInput, TextField salaryInput) throws SAXException, IOException{
        ObservableList<Employee> obsList = empParser.readXmlFile();
        ListView<Employee> ls = new ListView<Employee>(obsList);
        grid.add(ls, 0, 1, 2, 10);
       
        ls.getSelectionModel().selectedIndexProperty().addListener((obs, oldItem, newItem) -> {
            Employee selectedEmployee = obsList.get(newItem.intValue());
            idInput.setText(Integer.toString(selectedEmployee.getId()));
            nameInput.setText((String) selectedEmployee.getName());
            lNameInput.setText(selectedEmployee.getlName());
            departmentInput.setText(selectedEmployee.getDeptName());
            salaryInput.setText(Double.toString(selectedEmployee.getSalary()));
        });
    };
    public static void main(String[] args) {
        launch();
    }

}
package com.budgetsgenerator;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene1, scene2;

    @Override
    public void start(Stage stage) throws IOException {
        BorderPane root = new BorderPane();
        AnchorPane sideBar = new AnchorPane();
        sideBar.setMinSize(100, 400);
        sideBar.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        Button btn1 = new Button("Panel 1");
        btn1.setLayoutY(0);
        Button btn2 = new Button("Panel 2");
        btn2.setLayoutY(25);
        sideBar.getChildren().addAll(btn1, btn2);

        AnchorPane p1 = new AnchorPane();
        p1.setMinSize(500, 400);
        p1.setBackground(new Background(new BackgroundFill(Color.ANTIQUEWHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        GridPane p2 = new GridPane();

        for(int i=0; i<4; i++){
            ColumnConstraints col = new ColumnConstraints();
            p2.getColumnConstraints().add(col);
            col.setPercentWidth(25);
        }

        for(int i=0; i<15; i++){
            RowConstraints row = new RowConstraints();
            p2.getRowConstraints().add(row);
            row.setPercentHeight(6.66);
        }
        Label presupuestoLabel = new Label("Presupuestos");
        presupuestoLabel.setId("presupuestos_title");
        p2.add(presupuestoLabel, 0, 0, 1, 1);

        Label tarifaLabel = new Label("Tarifa:");
        p2.add(tarifaLabel, 0, 1, 2, 1);

        ComboBox tarifaCombo = new ComboBox<>();
        p2.add(tarifaCombo, 0, 2, 2, 1);

        Label fibraLabel = new Label("Fibra:");
        p2.add(fibraLabel, 0, 3, 1, 1);

        ComboBox fibraCombo = new ComboBox<>();
        p2.add(fibraCombo, 0, 4, 1, 1);

        Label streamingLabel = new Label("Streaming:");
        p2.add(streamingLabel, 1, 3, 1, 1);

        ComboBox streamingCombo = new ComboBox<>();
        p2.add(streamingCombo, 1, 4, 1, 1);

        Label lineasAdicionalesLabel = new Label("Líneas Adicionales:");
        p2.add(lineasAdicionalesLabel, 0, 5, 2, 1);

        ComboBox lineasAdicionalesCombo = new ComboBox<>();
        p2.add(lineasAdicionalesCombo, 0, 6, 2, 1);
        
        Button add = new Button("Añadir línea");
        p2.add(add, 0, 7, 1, 1);
        
        Button delete = new Button("Eliminar línea");
        p2.add(delete, 1, 7, 1, 1);
        
        ListView<String> lineasAdicionalesView = new ListView<String>();
        p2.add(lineasAdicionalesView, 0, 8, 2, 6);
        
        Button saveButton = new Button("Guardar Presupuesto");
        p2.add(saveButton, 0, 14, 1, 1);
        
        Button loadButton = new Button("Cargar Presupuesto");
        p2.add(loadButton, 1, 14, 1, 1);

        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                root.setCenter(p1);
            }
        });
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                root.setCenter(p2);
            }
        });
        
        Label descuentoLabel = new Label("Descuento:");
        p2.add(descuentoLabel, 2, 1, 2, 1);

        ComboBox descuentoCombo = new ComboBox<>();
        p2.add(descuentoCombo, 2, 2, 2, 1);
                
        Label centralitaLabel = new Label("Centralita:");
        p2.add(centralitaLabel, 2, 3, 2, 1);

        ComboBox centralitaCombo = new ComboBox<>();
        p2.add(centralitaCombo, 2, 4, 2, 1);
                
        Label packFutbolLabel = new Label("Pack Fútbol:");
        p2.add(packFutbolLabel, 2, 5, 2, 1);

        ComboBox packFutbolCombo = new ComboBox<>();
        p2.add(packFutbolCombo, 2, 6, 2, 1);

        ListView<String> resumenView = new ListView<String>();
        p2.add(resumenView, 2, 7, 2, 6);

        Label totalLabel = new Label("TOTAL:");
        totalLabel.setId("total_label");
        p2.add(totalLabel, 2, 13, 1, 1);

        TextField totaField = new TextField();
        p2.add(totaField, 3, 13, 1, 1);

        Button limpiarButton = new Button("Limpiar");
        p2.add(limpiarButton, 2, 14, 1, 1);
        
        Button generarPdfButton = new Button("Generar PDF");
        p2.add(generarPdfButton, 3, 14, 1, 1);

        root.setLeft(sideBar);
        root.setCenter(p2);

        Scene scene = new Scene(root);
        scene.getStylesheets().add("styles.css");
        stage.setTitle("Multiple panes demo");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
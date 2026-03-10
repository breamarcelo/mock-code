package com.budgetsgenerator.views;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class PresupuestosView extends GridPane{

    public PresupuestosView() {
        this.getStylesheets().add(getClass().getResource("/css/presupuestos.css").toExternalForm());
        this.getStyleClass().add("grid_pane");

        for(int i=0; i<4; i++){
            ColumnConstraints col = new ColumnConstraints();
            this.getColumnConstraints().add(col);
            col.setPercentWidth(25);
        }

        for(int i=0; i<15; i++){
            RowConstraints row = new RowConstraints();
            this.getRowConstraints().add(row);
            row.setPercentHeight(6.66);
        }
        Label presupuestoLabel = new Label("Presupuestos");
        presupuestoLabel.setId("presupuestos_title");
        this.add(presupuestoLabel, 0, 0, 1, 1);

        Label tarifaLabel = new Label("Tarifa:");
        this.add(tarifaLabel, 0, 1, 2, 1);

        Label fibraLabel = new Label("Fibra:");
        this.add(fibraLabel, 0, 3, 1, 1);

        Label streamingLabel = new Label("Streaming:");
        this.add(streamingLabel, 1, 3, 1, 1);

        Label lineasAdicionalesLabel = new Label("Líneas Adicionales:");
        this.add(lineasAdicionalesLabel, 0, 5, 2, 1);
        
        Button add = new Button("Añadir línea");
        this.add(add, 0, 7, 1, 1);
        
        Button delete = new Button("Eliminar línea");
        this.add(delete, 1, 7, 1, 1);
        
        ListView<String> lineasAdicionalesView = new ListView<String>();
        this.add(lineasAdicionalesView, 0, 8, 2, 6);
        
        Button saveButton = new Button("Guardar Presupuesto");
        this.add(saveButton, 0, 14, 1, 1);
        
        Button loadButton = new Button("Cargar Presupuesto");
        this.add(loadButton, 1, 14, 1, 1);
        
        Label descuentoLabel = new Label("Descuento:");
        this.add(descuentoLabel, 3, 1, 2, 1);
                
        Label centralitaLabel = new Label("Centralita:");
        this.add(centralitaLabel, 2, 3, 2, 1);

        ComboBox centralitaCombo = new ComboBox<>();
        this.add(centralitaCombo, 2, 4, 2, 1);
                
        Label packFutbolLabel = new Label("Pack Fútbol:");
        this.add(packFutbolLabel, 2, 5, 2, 1);

        ComboBox packFutbolCombo = new ComboBox<>();
        this.add(packFutbolCombo, 2, 6, 2, 1);

        ListView<String> resumenView = new ListView<String>();
        this.add(resumenView, 2, 7, 2, 6);

        Label totalLabel = new Label("TOTAL:");
        totalLabel.setId("total_label");
        this.add(totalLabel, 2, 13, 1, 1);

        TextField totaField = new TextField();
        this.add(totaField, 3, 13, 1, 1);

        Button limpiarButton = new Button("Limpiar");
        this.add(limpiarButton, 2, 14, 1, 1);
        
        Button generarPdfButton = new Button("Generar PDF");
        this.add(generarPdfButton, 3, 14, 1, 1);
    }
     
}

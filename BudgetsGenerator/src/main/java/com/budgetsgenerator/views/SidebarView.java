package com.budgetsgenerator.views;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class SidebarView extends VBox{
    private Button presupuestosButton = new Button("PRESUPUESTOS");
    private Button tarifasButton = new Button("TARIFAS");
    private Button productosButton = new Button("PRODUCTOS");
    private Button ajustesButton = new Button("AJUSTES");

    public SidebarView() {
        this.getStylesheets().add(getClass().getResource("/css/palette.css").toExternalForm());
        this.getStylesheets().add(getClass().getResource("/css/sidebar.css").toExternalForm());
        this.getStyleClass().add("sidebar");
        load();
    }

    public void load() {
        Region start = new Region();
        Region end = new Region();

        this.getChildren().addAll(start, this.getPresupuestosButton(), this.getTarifasButton(), this.getProductosButton(), this.getAjustesButton(), end);
        for(Node node : this.getChildren()){
            this.setMargin(node, new Insets(0, 0, 10, 0));
        }
        this.setVgrow(start, Priority.ALWAYS);
        this.setVgrow(end, Priority.ALWAYS);
    }

    public Button getPresupuestosButton() {
        return presupuestosButton;
    }

    public void setPresupuestosButton(Button presupuestosButton) {
        this.presupuestosButton = presupuestosButton;
    }

    public Button getTarifasButton() {
        return tarifasButton;
    }

    public void setTarifasButton(Button tarifasButton) {
        this.tarifasButton = tarifasButton;
    }

    public Button getProductosButton() {
        return productosButton;
    }

    public void setProductosButton(Button productosButton) {
        this.productosButton = productosButton;
    }

    public Button getAjustesButton() {
        return ajustesButton;
    }

    public void setAjustesButton(Button ajustesButton) {
        this.ajustesButton = ajustesButton;
    }

    

}

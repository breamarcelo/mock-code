package com.budgetsgenerator.views;

import com.budgetsgenerator.config.UIUtil;

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
        this.getStylesheets().add(getClass().getResource(UIUtil.getPalette()).toExternalForm());
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

        Region invoiceIcon = new Region();
        invoiceIcon.getStyleClass().addAll("icon", "invoice-icon");
        this.getPresupuestosButton().setGraphic(invoiceIcon);

        Region homeIcon = new Region();
        homeIcon.getStyleClass().addAll("icon", "home-icon");
        this.getTarifasButton().setGraphic(homeIcon);

        Region phoneIcon = new Region();
        phoneIcon.getStyleClass().addAll("icon", "phone-icon");
        this.getProductosButton().setGraphic(phoneIcon);
        
        Region gearIcon = new Region();
        gearIcon.getStyleClass().addAll("icon", "gear-icon");
        this.getAjustesButton().setGraphic(gearIcon);
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

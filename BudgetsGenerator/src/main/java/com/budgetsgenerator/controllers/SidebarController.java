package com.budgetsgenerator.controllers;

import com.budgetsgenerator.views.SidebarView;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

public class SidebarController {
    private SidebarView view;
    
    public SidebarController(SidebarView view){
        this.view = view;
        load();
    }

public void load() {
        Region start = new Region();
        Region end = new Region();
        
        view.getChildren().addAll(start, view.getPresupuestosButton(), view.getTarifasButton(), view.getLineasAdicionalesButton(),view.getProductosButton(), end, view.getAjustesButton());
        for(Node node : view.getChildren()){
            if(node instanceof Button) {
                view.setMargin(node, new Insets(0, 0, 10, 0));
            }
        }
        view.setVgrow(start, Priority.ALWAYS);
        view.setVgrow(end, Priority.ALWAYS);

        Region invoiceIcon = new Region();
        invoiceIcon.getStyleClass().addAll("icon", "invoice-icon");
        view.getPresupuestosButton().setGraphic(invoiceIcon);

        Region homeIcon = new Region();
        homeIcon.getStyleClass().addAll("icon", "home-icon");
        view.getTarifasButton().setGraphic(homeIcon);

        Region phoneIcon = new Region();
        phoneIcon.getStyleClass().addAll("icon", "phone-icon");
        view.getLineasAdicionalesButton().setGraphic(phoneIcon);

        Region shoppingIcon = new Region();
        shoppingIcon.getStyleClass().addAll("icon", "shopping-icon");
        view.getProductosButton().setGraphic(shoppingIcon);
        
        Region gearIcon = new Region();
        gearIcon.getStyleClass().addAll("icon", "gear-icon");
        view.getAjustesButton().setGraphic(gearIcon);
    }
}

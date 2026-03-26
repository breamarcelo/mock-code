package com.budgetsgenerator.controllers;

import com.budgetsgenerator.views.SidebarView;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

public class SidebarController {
    private SidebarView view;
    
    public SidebarController(SidebarView view){
        this.view = view;
    }

    public void load() {
        Region start = new Region();
        Region end = new Region();

        view.getChildren().addAll(start, view.getPresupuestosButton(), view.getTarifasButton(), view.getProductosButton(), view.getAjustesButton(), end);
        for(Node node : view.getChildren()){
            view.setMargin(node, new Insets(0, 0, 10, 0));
        }
        view.setVgrow(start, Priority.ALWAYS);
        view.setVgrow(end, Priority.ALWAYS);
    }
}

package com.budgetsgenerator.controllers;

import com.budgetsgenerator.views.MainView;
import com.budgetsgenerator.views.PresupuestosView;

import javafx.scene.Node;
import javafx.scene.control.Button;

public class MainController {
    private MainView view;

    public MainController(MainView view) {
        this.view = view;
        load();
    }

    public void load() {

        view.getSidebar().getPresupuestosButton().setOnAction(e -> {
            PresupuestosView presupuestosView = new PresupuestosView();
            PresupuestosController presupuestosController = new PresupuestosController(presupuestosView);
            unselectButtons();
            view.getSidebar().getPresupuestosButton().getStyleClass().add("selected");
            view.setCenterContent(presupuestosView);
        });
    }

    public void unselectButtons() {
        for(Node node : view.getSidebar().getChildren()) {
            if(node instanceof Button) {
                node.getStyleClass().add("unselected");
            }
        }
    }
}

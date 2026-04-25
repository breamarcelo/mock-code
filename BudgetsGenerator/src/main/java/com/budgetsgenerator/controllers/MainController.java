package com.budgetsgenerator.controllers;

import com.budgetsgenerator.views.LineasAdicionalesView;
import com.budgetsgenerator.views.MainView;
import com.budgetsgenerator.views.PresupuestosView;
import com.budgetsgenerator.views.TarifasView;

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
        
        view.getSidebar().getTarifasButton().setOnAction(e -> {
            TarifasView tarifasView = new TarifasView();
            TarifasController tarifasController = new TarifasController(tarifasView);
            unselectButtons();
            view.getSidebar().getTarifasButton().getStyleClass().add("selected");
            view.setCenterContent(tarifasView);
        });

        view.getSidebar().getLineasAdicionalesButton().setOnAction(e -> {
            LineasAdicionalesView lineasAdicionalesView = new LineasAdicionalesView();
            LineasAdicionalesController lineasAdicionalesController = new LineasAdicionalesController(lineasAdicionalesView);
            unselectButtons();
            view.getSidebar().getLineasAdicionalesButton().getStyleClass().add("selected");
            view.setCenterContent(lineasAdicionalesView);
        });
    }

    public void unselectButtons() {
        for(Node node : view.getSidebar().getChildren()) {
            if(node instanceof Button) {
                node.getStyleClass().remove("selected");
            }
        }
    }
}

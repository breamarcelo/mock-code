package com.example.controllers;

import com.example.views.LibrosView;
import com.example.views.MainView;
import com.example.views.VideojuegosView;

import javafx.scene.Node;
import javafx.scene.control.Button;

public class MainController {
    private MainView view;

    public MainController(MainView view) {
        this.view = view;
        load();
    }

    public void load() {
        view.getSidebar().getLibrosButton().setOnAction(e -> {
            LibrosView librosView = new LibrosView();
            LibrosController controller = new LibrosController(librosView);
            unselectButtons();
            view.getSidebar().getLibrosButton().getStyleClass().add("selected");
            view.setCenterContent(librosView);
        });
        
        view.getSidebar().getVideojuegosButton().setOnAction(e -> {
            VideojuegosView videojuegosView = new VideojuegosView();
            VideojuegosController videojuegosController = new VideojuegosController(videojuegosView);
            unselectButtons();
            view.getSidebar().getVideojuegosButton().getStyleClass().add("selected");
            view.setCenterContent(videojuegosView);
        });

    //     view.getSidebar().getLineasAdicionalesButton().setOnAction(e -> {
    //         LineasAdicionalesView lineasAdicionalesView = new LineasAdicionalesView();
    //         LineasAdicionalesController lineasAdicionalesController = new LineasAdicionalesController(lineasAdicionalesView);
    //         unselectButtons();
    //         view.getSidebar().getLineasAdicionalesButton().getStyleClass().add("selected");
    //         view.setCenterContent(lineasAdicionalesView);
    //     });

    //     view.getSidebar().getProductosButton().setOnAction(e -> {
    //         ProductosView productosView = new ProductosView();
    //         ProductosController productosController = new ProductosController(productosView);
    //         unselectButtons();
    //         view.getSidebar().getProductosButton().getStyleClass().add("selected");
    //         view.setCenterContent(productosView);
    //     });
    }

    public void unselectButtons() {
        for(Node node : view.getSidebar().getChildren()) {
            if(node instanceof Button) {
                node.getStyleClass().remove("selected");
            }
        }
    }
}

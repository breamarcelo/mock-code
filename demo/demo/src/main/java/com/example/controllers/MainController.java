package com.example.controllers;

import com.example.views.ComicsView;
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

        view.getSidebar().getRevistasButton().setOnAction(e -> {
            ComicsView comicsView = new ComicsView();
            ComicsController comicsController = new ComicsController(comicsView);
            unselectButtons();
            view.getSidebar().getRevistasButton().getStyleClass().add("selected");
            view.setCenterContent(comicsView);
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

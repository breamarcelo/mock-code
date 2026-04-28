package com.example.controllers;

import com.example.views.SidebarView;

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

        view.getChildren().addAll(start, view.getVideojuegosButton(), view.getLibrosButton(), view.getRevistasButton(), view.getPeliculasButton(),view.getSeriesButton(), end, view.getAjustesButton());
        for(Node node : view.getChildren()){
            if(node instanceof Button) {
                view.setMargin(node, new Insets(0, 0, 10, 0));
            }
        }
        view.setVgrow(start, Priority.ALWAYS);
        view.setVgrow(end, Priority.ALWAYS);


        Region videojuegoIcon = new Region();
        videojuegoIcon.getStyleClass().addAll("icon", "juego-icon");
        view.getVideojuegosButton().setGraphic(videojuegoIcon);
        view.getVideojuegosButton().getStyleClass().add("juego-button");

        Region libroIcon = new Region();
        libroIcon.getStyleClass().addAll("icon", "libro-icon");
        view.getLibrosButton().setGraphic(libroIcon);

        Region revistaIcon = new Region();
        revistaIcon.getStyleClass().addAll("icon", "revista-icon");
        view.getRevistasButton().setGraphic(revistaIcon);

        Region peliculaIcon = new Region();
        peliculaIcon.getStyleClass().addAll("icon", "pelicula-icon");
        view.getPeliculasButton().setGraphic(peliculaIcon);

        Region tvIcon = new Region();
        tvIcon.getStyleClass().addAll("icon", "tv-icon");
        view.getSeriesButton().setGraphic(tvIcon);

        Region gearIcon = new Region();
        gearIcon.getStyleClass().addAll("icon", "gear-icon");
        view.getAjustesButton().setGraphic(gearIcon);
    }
}

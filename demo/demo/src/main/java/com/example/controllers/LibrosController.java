package com.example.controllers;

import com.example.views.LibrosView;

import javafx.geometry.Insets;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

public class LibrosController {
    LibrosView view;

    public LibrosController(LibrosView view){
        this.view = view;
        load();
    }

    public void load() {
        Region space = new Region();
        view.getMenuHBox().getChildren().addAll(view.getSearchBarTextField(), view.getFilterComboBox(), space, view.getNuevButton());
        view.getMenuHBox().setHgrow(space, Priority.ALWAYS);
        view.getMenuHBox().getStyleClass().add("menu-bar");
        view.getMenuHBox().setPrefWidth(Double.MAX_VALUE);
        view.getMenuHBox().setMargin(view.getSearchBarTextField(), new Insets(0, 20, 0, 0));
    }
}

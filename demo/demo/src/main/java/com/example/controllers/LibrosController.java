package com.example.controllers;

import com.example.views.LibrosView;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

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
        
        for(int i = 1; i<=6; i++) {
            HBox containerBox = new HBox();
            containerBox.getStyleClass().add("card-container");
            VBox card = new VBox();
            card.getStyleClass().add("card");
            card.getChildren().addAll(new Label("Hola " + i));
            containerBox.getChildren().add(card);
            containerBox.setHgrow(card, Priority.ALWAYS);
            view.getTilePane().getChildren().add(containerBox);
        }
        
        view.getTilePane().setTileAlignment(Pos.CENTER);
        view.getFooter().getChildren().add(view.getFooterButton());

    }
}

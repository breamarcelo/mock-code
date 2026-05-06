package com.example.views;

import com.example.config.UIUtil;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class SidebarView extends VBox{
    private Button librosButton = new Button("LIBROS");
    private Button revistasButton = new Button("COMICS");
    private Button videojuegosButton = new Button("VIDEOJUEGOS");

    public SidebarView() {
        this.getStylesheets().add(getClass().getResource(UIUtil.getPalette()).toExternalForm());
        this.getStylesheets().add(getClass().getResource("/css/sidebar.css").toExternalForm());
        this.getStyleClass().add("sidebar");
    }

    public Button getLibrosButton() {
        return librosButton;
    }

    public void setLibrosButton(Button presupuestosButton) {
        this.librosButton = presupuestosButton;
    }

    public Button getRevistasButton() {
        return revistasButton;
    }

    public void setRevistasButton(Button tarifasButton) {
        this.revistasButton = tarifasButton;
    }

    public Button getVideojuegosButton() {
        return videojuegosButton;
    }

}

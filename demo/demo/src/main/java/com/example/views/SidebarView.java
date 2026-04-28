package com.example.views;

import com.example.config.UIUtil;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class SidebarView extends VBox{
    private Button librosButton = new Button("LIBROS");
    private Button revistasButton = new Button("REVISTAS");
    private Button peliculasButton = new Button("PELÍCULAS");
    private Button seriesButton = new Button("SERIES");
    private Button videojuegosButton = new Button("VIDEOJUEGOS");
    private Button ajustesButton = new Button("AJUSTES");

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

    public Button getSeriesButton() {
        return seriesButton;
    }

    public void setSeriesButton(Button productosButton) {
        this.seriesButton = productosButton;
    }

    public Button getAjustesButton() {
        return ajustesButton;
    }

    public void setAjustesButton(Button ajustesButton) {
        this.ajustesButton = ajustesButton;
    }

    public Button getPeliculasButton() {
        return peliculasButton;
    }

    public Button getVideojuegosButton() {
        return videojuegosButton;
    }

}

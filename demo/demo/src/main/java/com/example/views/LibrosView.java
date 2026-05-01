package com.example.views;

import com.example.config.UIUtil;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;

public class LibrosView extends BorderPane{
    private final TilePane tilePane = new TilePane();
    private final HBox menuHBox = new HBox();
    private final TextField searchBarTextField = new TextField();
    private final ComboBox filterComboBox = new ComboBox<>();
    private final Button nuevButton = new Button("Nuevo");
    private final HBox footer = new HBox();
    private final Button footerButton = new Button("<");

    public LibrosView() {
        this.getStylesheets().add(getClass().getResource(UIUtil.getPalette()).toExternalForm());
        this.getStylesheets().add(getClass().getResource("/css/libros.css").toExternalForm());
        this.getStyleClass().add("border-pane");

        this.setTop(menuHBox);
        this.setCenter(tilePane);
        this.setBottom(footer);
    }

    public TilePane getTilePane() {
        return tilePane;
    }

    public HBox getMenuHBox() {
        return menuHBox;
    }

    public TextField getSearchBarTextField() {
        return searchBarTextField;
    }

    public ComboBox getFilterComboBox() {
        return filterComboBox;
    }

    public Button getNuevButton() {
        return nuevButton;
    }

    public HBox getFooter() {
        return footer;
    }

    public Button getFooterButton() {
        return footerButton;
    }

    
}

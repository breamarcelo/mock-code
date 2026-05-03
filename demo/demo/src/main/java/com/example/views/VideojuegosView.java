package com.example.views;

import com.example.config.UIUtil;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;

public class VideojuegosView extends BorderPane{
private final TilePane tilePane = new TilePane();
    private final HBox menuHBox = new HBox();
    private final TextField searchBarTextField = new TextField();
    private final ComboBox<String> filterComboBox = new ComboBox<>();
    private final ComboBox<String> orderComboBox = new ComboBox<>();
    private final Button clearFiltersButton = new Button("Limpiar");
    private final Button nuevButton = new Button("Nuevo");
    private final HBox footer = new HBox();
    private final Button previousButton = new Button();
    private final Label pageNumLabel = new Label("1");
    private final Label totalPagesLabel = new Label("1");
    private final Button nextButton = new Button();

    public VideojuegosView() {
        this.getStylesheets().add(getClass().getResource(UIUtil.getPalette()).toExternalForm());
        this.getStylesheets().add(getClass().getResource("/css/main.css").toExternalForm());
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

    public ComboBox<String> getFilterComboBox() {
        return filterComboBox;
    }

    public Button getNuevButton() {
        return nuevButton;
    }

    public HBox getFooter() {
        return footer;
    }

    public ComboBox<String> getOrderComboBox() {
        return orderComboBox;
    }

    public Button getClearFiltersButton() {
        return clearFiltersButton;
    }

    public Button getPreviousButton() {
        return previousButton;
    }

    public Button getNextButton() {
        return nextButton;
    }

    public Label getPageNumLabel() {
        return pageNumLabel;
    }

    public Label getTotalPagesLabel() {
        return totalPagesLabel;
    }

    
}

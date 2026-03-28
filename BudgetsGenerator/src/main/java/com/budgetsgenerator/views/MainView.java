package com.budgetsgenerator.views;

import com.budgetsgenerator.config.UIUtil;
import com.budgetsgenerator.controllers.SidebarController;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class MainView {
    private BorderPane root;
    private SidebarView sidebar;

    public MainView() {
        this.root = new BorderPane();
        load();
    }

    public void load() {
        this.setSidebar(new SidebarView());
        SidebarController sidebarController = new SidebarController(this.getSidebar());
        Pane emptyPane = new Pane();
        emptyPane.getStylesheets().add(getClass().getResource(UIUtil.getPalette()).toExternalForm());
        emptyPane.getStylesheets().add(getClass().getResource("/css/emptypane.css").toExternalForm());
        emptyPane.getStyleClass().add("empty-pane");
        root.setLeft(sidebar);
        root.setCenter(emptyPane);
    }

    public void setCenterContent(Node node) {
        root.setCenter(node);
    }

    public BorderPane getRoot() {
        return root;
    }

    public void setRoot(BorderPane root) {
        this.root = root;
    }

    public SidebarView getSidebar() {
        return sidebar;
    }

    public void setSidebar(SidebarView sidebar) {
        this.sidebar = sidebar;
    }

    
}

package com.budgetsgenerator;

import java.io.IOException;

import com.budgetsgenerator.controllers.PresupuestosController;
import com.budgetsgenerator.controllers.SidebarController;
import com.budgetsgenerator.views.PresupuestosView;
import com.budgetsgenerator.views.SidebarView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        BorderPane root = new BorderPane();

        PresupuestosView presupuestosView = new PresupuestosView();
        PresupuestosController presupuestosController = new PresupuestosController(presupuestosView);
        presupuestosController.loadData();
        
        SidebarView sidebarView = new SidebarView();
        SidebarController sidebarController = new SidebarController(sidebarView);
        sidebarController.load();

        root.setLeft(sidebarView);
        root.setCenter(presupuestosView);
        
        Scene scene = new Scene(root);
        stage.setTitle("Generador de presupuestos - Orange Empresas");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

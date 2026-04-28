package com.example;

import java.io.IOException;

import com.example.controllers.MainController;
import com.example.views.MainView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        MainView mainView = new MainView();
        MainController mainController = new MainController(mainView);
        
        Scene scene = new Scene(mainView.getRoot());
        stage.setTitle("Catálogo");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
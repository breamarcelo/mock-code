package com.budgetsgenerator;

import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        Stage window = stage;
        window.resizableProperty().set(false);
        BorderPane pane = new BorderPane();
        pane.setBackground(new Background(new BackgroundFill(Color.valueOf("#146732"), new CornerRadii(0), new Insets(0))));
        pane.setMaxWidth(50);
        Scene scene = new Scene(pane);
        window.setScene(scene);
        window.show();
        window.centerOnScreen();
    }

    public static void main(String[] args) {
        launch();
    }

}
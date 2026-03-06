package com.budgetsgenerator;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
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

    private static Scene scene1, scene2;

    @Override
    public void start(Stage stage) throws IOException {
        BorderPane root = new BorderPane();
        AnchorPane sideBar = new AnchorPane();
        sideBar.setMinSize(100, 400);
        sideBar.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        Button btn1 = new Button("Panel 1");
        btn1.setLayoutY(0);
        Button btn2 = new Button("Panel 2");
        btn2.setLayoutY(25);
        sideBar.getChildren().addAll(btn1, btn2);

        AnchorPane p1 = new AnchorPane();
        p1.setMinSize(500, 400);
        p1.setBackground(new Background(new BackgroundFill(Color.ANTIQUEWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        AnchorPane p2 = new AnchorPane();
        p2.setMinSize(500, 400);
        p2.setBackground(new Background(new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                root.setCenter(p1);
            }
        });
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                root.setCenter(p2);
            }
        });
        root.setLeft(sideBar);
        root.setCenter(p1);

        Scene scene = new Scene(root);
        stage.setTitle("Multiple panes demo");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
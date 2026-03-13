package com.budgetsgenerator;

import java.io.IOException;

import com.budgetsgenerator.controllers.PresupuestosController;
import com.budgetsgenerator.dto.LineasAdicionalesDTO;
import com.budgetsgenerator.mappers.LineasAdicionalesMapper;
import com.budgetsgenerator.views.PresupuestosView;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
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
        p1.setMinSize(800, 400);
        p1.setBackground(new Background(new BackgroundFill(Color.ANTIQUEWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        TableView<LineasAdicionalesDTO> t1 = new TableView<>();
        
        // for(LineasAdicionalesDTO l : LineasAdicionalesMapper.getInstance().toDTOList()) {
        //     t1.getItems().add(l);
        // }

        t1.setItems(FXCollections.observableArrayList(LineasAdicionalesMapper.getInstance().toDTOList()));

        TableColumn<LineasAdicionalesDTO, String> idTableColumn = new TableColumn<>("Id");
        idTableColumn.minWidthProperty().set(20);
        idTableColumn.setCellValueFactory(new PropertyValueFactory<LineasAdicionalesDTO, String>("id"));
        TableColumn<LineasAdicionalesDTO, String> nombreTableColumn = new TableColumn<>("Nombre");
        nombreTableColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        TableColumn<LineasAdicionalesDTO, String> tipoTableColumn = new TableColumn<>("Tipo");
        tipoTableColumn.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        t1.getColumns().add(idTableColumn);
        t1.getColumns().add(nombreTableColumn);
        t1.getColumns().add(tipoTableColumn);
        t1.prefWidth(300);
        t1.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN);

        Label l1 = new Label("");
        Label l2 = new Label("");
        HBox hb1 = new HBox();
        hb1.getChildren().addAll(l1, l2);
        Button b1 = new Button("Btn1");
        Button b2 = new Button("Btn2");
        HBox hb2 = new HBox();
        hb2.getChildren().addAll(b1, b2);
        
        ListView<HBox> lv = new ListView<>();
        HBox line1 = new HBox();
        line1.setPrefWidth(400);
        line1.paddingProperty().set(new Insets(-5));
        Label line1s1 = new Label("Line 1");
        line1s1.setPrefWidth(340);
        Button line1b1 = new Button("+");
        line1b1.setPrefWidth(20);
        Label line1s2 = new Label("0");
        line1s2.setPrefWidth(20);
        Button line1b2 = new Button("-");
        line1b2.setPrefWidth(20);
        line1.getChildren().addAll(line1s1, line1b1, line1s2, line1b2);
        
        lv.getItems().add(line1);
        p1.getChildren().add(lv);
        
        
        PresupuestosView p2 = new PresupuestosView();
        PresupuestosController p2v = new PresupuestosController(p2);
        p2v.loadData();
        
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
        root.setPrefSize(1920, 1080);
        Scene scene = new Scene(root);
        //scene.getStylesheets().add("styles.css");
        stage.setTitle("Multiple panes demo");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
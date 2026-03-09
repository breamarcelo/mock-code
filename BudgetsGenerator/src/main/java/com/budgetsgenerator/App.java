package com.budgetsgenerator;

import java.io.IOException;
import java.util.List;

import com.budgetsgenerator.models.ServiciosAdicionalesEntity;
import com.budgetsgenerator.models.TarifasEntity;
import com.budgetsgenerator.views.PresupuestosV;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
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
import javafx.scene.layout.GridPane;
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

        GridPane p2 = new PresupuestosV();

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
        root.setPrefSize(900, 600);
        Scene scene = new Scene(root);
        //scene.getStylesheets().add("styles.css");
        stage.setTitle("Multiple panes demo");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("budgets_generator").createEntityManager();

        
        // ServiciosAdicionalesEntity ent = em.find(ServiciosAdicionalesEntity.class, 1);

        // if (ent != null) {
        //     System.out.println("ID: " + ent.getId() + "\n" + 
        //     "Roaming: " + ent.getRoaming() + "\n" + 
        //     "Internacional: " + ent.getInternacional() + "\n" + 
        //     "Legalitas: " + ent.isLegalitas() + "\n" + 
        //     "Cloud: " + ent.isCloud() + "\n" + 
        //     "CiberProteccion: " + ent.isCiberProteccion() + "\n" + 
        //     "AtencionPersonalizada: " + ent.isAtencionPersonalizada() + "\n" + 
        //     "Centralita: " + ent.getCentralita() + "\n" + 
        //     "NumBeneficios: " + ent.getNumBeneficios() + "\n" + 
        //     "DescuentoBeneficios: " + ent.getDescuentoBeneficios() + "\n");
        // } else {
        //     System.out.println("No record found with that ID.");
        // }

        // List<DescuentosEntity> descuentos = em.createQuery("SELECT d FROM Descuentos d", DescuentosEntity.class).getResultList();
        // for (DescuentosEntity d : descuentos) {
        //     System.out.println("ID: " + d.getId() + " Porciento: " + d.getPorciento() + "%");
        // }

        List<TarifasEntity> testList = em.createQuery("SELECT c FROM TarifasEntity c", TarifasEntity.class).getResultList();
        for(TarifasEntity c : testList){
            ServiciosAdicionalesEntity servicios = c.getServiciosAdicionales();
            System.out.println("ID: " + c.getId() + "\n" + 
            "Nombre: " + c.getNombre() + "\n" + 
            "Tipo: " + c.getTipo() + "\n" + 
            "LineasMoviles: " + c.getLineasMoviles() + "\n" + 
            "LlamadasMovil: " + c.getLlamadasMovil() + "\n" + 
            "GbMovil: " + c.getGbMovil() + "\n" + 
            "OpcionFibra1: " + c.getOpcionFibra1() + "\n" + 
            "OpcionFibra2: " + c.getOpcionFibra2() + "\n" + 
            "SobrecargoFibra: " + c.getSobrecargoFibra() + "\n" + 
            "Precio: " + c.getPrecio() + "\n" + 
            "Tv: " + c.isTv() + "\n" + 
            "Streaming: " + c.isStreaming() + "\n" + 
            "Servicios Adicionales: " + "\n" + 
            "--------------------------" + "\n" +
            "| Roaming: " + servicios.getRoaming() + "\n" +
            "| Internacional: " + servicios.getInternacional() + "\n" +
            "| Legalitas: " + servicios.isLegalitas() + "\n" +
            "| Cloud: " + servicios.isCloud() + "\n" +
            "| CiberProteccion: " + servicios.isCiberProteccion() + "\n" +
            "| AtencionPersonalizada: " + servicios.isAtencionPersonalizada() + "\n" +
            "| Centralita: " + servicios.getCentralita() + "\n" +
            "| NumBeneficios: " + servicios.getNumBeneficios() + "\n" +
            "| DescuentoBeneficios: " + servicios.getDescuentoBeneficios() + "\n" +
            "--------------------------");
        }
        em.close();
        launch();
    }

}
package com.budgetsgenerator.controllers;

import java.util.List;

import com.budgetsgenerator.config.UIUtils;
import com.budgetsgenerator.dto.CentralitasDTO;
import com.budgetsgenerator.dto.DescuentosDTO;
import com.budgetsgenerator.dto.LineasAdicionalesDTO;
import com.budgetsgenerator.dto.PacksFutbolDTO;
import com.budgetsgenerator.dto.TarifasDTO;
import com.budgetsgenerator.mappers.CentralitasMapper;
import com.budgetsgenerator.mappers.DescuentosMapper;
import com.budgetsgenerator.mappers.LineasAdicionalesMapper;
import com.budgetsgenerator.mappers.PacksFutbolMapper;
import com.budgetsgenerator.mappers.TarifasMapper;
import com.budgetsgenerator.views.PresupuestosView;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class PresupuestosController {
    private PresupuestosView view = new PresupuestosView();

    public PresupuestosController(PresupuestosView view) {
        this.view = view;
    }
    
    public void loadData(){
        List<TarifasDTO> tarifasList = TarifasMapper.getInstance().toDTOList();
        List<LineasAdicionalesDTO> lineasAdicionalesList = LineasAdicionalesMapper.getInstance().toDTOList();
        List<DescuentosDTO> descuentosList = DescuentosMapper.getInstance().toDTOList();
        List<CentralitasDTO> centralitasList = CentralitasMapper.getInstance().toDTOList();
        List<PacksFutbolDTO> packsFutbolList = PacksFutbolMapper.getInstance().toDTOList();
        
        view.getTarifasCombo().getItems().setAll(tarifasList);
        view.getLineasAdicionalesCombo().getItems().setAll(lineasAdicionalesList);
        view.getDescuentoCombo().getItems().setAll(descuentosList);
        view.getCentralitaCombo().getItems().setAll(centralitasList);
        view.getPacksFutbolCombo().getItems().setAll(packsFutbolList);
        view.getStreamingCombo().setDisable(true);
        view.getStreamingCombo().getItems().setAll("Amazon Prime", "Disney+", "Netflix");
        view.getTarifasCombo().getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            view.getFibraCombo().getItems().clear();
            view.getFibraCombo().getItems().addAll(newValue.getOpcionFibra1(), newValue.getOpcionFibra2() + " (+" + newValue.getSobrecargoFibra() + "€)");
            view.getStreamingCombo().setDisable(!newValue.isStreaming());
        });
        
        view.getTarifasCombo().setConverter(UIUtils.createConverter(dto -> dto.getNombre()));
        view.getLineasAdicionalesCombo().setConverter(UIUtils.createConverter(dto -> dto.getNombre()));
        view.getDescuentoCombo().setConverter(UIUtils.createConverter(dto -> dto.getPorciento() + "%"));
        view.getCentralitaCombo().setConverter(UIUtils.createConverter(dto -> dto.getNombre()));
        view.getPacksFutbolCombo().setConverter(UIUtils.createConverter(dto -> dto.getNombre()));
        view.getPacksFutbolCombo().setConverter(UIUtils.createConverter(dto -> dto.getNombre()));
       
        view.getAddLineaAdicionalButton().setOnAction(addLineaAdicionalToListView());
        view.getDeleteLineaAdicionalButton().setOnAction(deleteLineaAdicionalToListView());

        view.getTarifasCombo().setOnAction(e -> {
            System.out.println(e.getSource().toString());
        });

        for(LineasAdicionalesDTO dto : lineasAdicionalesList) {
            HBox listViewItem = new HBox();
            Label itemId = new Label(Integer.toString(dto.getId()));
            itemId.setVisible(false);
            itemId.getStyleClass().add("view_id");
            Label itemName = new Label(dto.getNombre());
            itemName.setMaxWidth(Double.MAX_VALUE);
            itemName.getStyleClass().add("view_label");
            Button addItemButton = new Button("+");
            addItemButton.getStyleClass().add("view_btn");
            Label itemQuantityLabel = new Label("0");
            itemQuantityLabel.getStyleClass().add("view_qt");
            Button deleteItemButton = new Button("-");
            deleteItemButton.getStyleClass().add("view_btn");


            addItemButton.setOnAction(e -> {
                System.out.println(itemId.getText());
            });

            listViewItem.setHgrow(itemName, Priority.ALWAYS);
            listViewItem.setAlignment(Pos.CENTER_RIGHT);
            listViewItem.getChildren().addAll(itemId, itemName, addItemButton, itemQuantityLabel, deleteItemButton);

            view.getLineasAdicionalesView().getItems().add(listViewItem);
        }
        view.getLineasAdicionalesView().setPadding(Insets.EMPTY);
    }

    public EventHandler<ActionEvent> addLineaAdicionalToListView(){
        EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LineasAdicionalesDTO selectedLineaAdicional = view.getLineasAdicionalesCombo().getSelectionModel().getSelectedItem();
                //view.getLineasAdicionalesView().getItems().add(view.getLineasAdicionalesView().getItems().size(), selectedLineaAdicional.getNombre());
                
            }
        };
        return eventHandler;
    }

    public EventHandler<ActionEvent> deleteLineaAdicionalToListView(){
        EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int selectedIndex = view.getLineasAdicionalesCombo().getSelectionModel().getSelectedIndex();
                System.out.println("delete: " + selectedIndex);
                //view.getLineasAdicionalesView().getItems().remove(selectedIndex);
            }
        };
        return eventHandler;
    }

}

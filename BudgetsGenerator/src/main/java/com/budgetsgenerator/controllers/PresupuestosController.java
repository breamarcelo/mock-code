package com.budgetsgenerator.controllers;

import java.util.ArrayList;
import java.util.Arrays;
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

        UIUtils.populateVBox(view.getTarifasVBox(), new ArrayList<>(Arrays.asList(view.getTarifasVBoxLabel(), view.getTarifaLabel(), view.getTarifasCombo(), view.getFibraLabel(), view.getFibraCombo(), view.getStreamingLabel(), view.getStreamingCombo())));
        UIUtils.populateVBox(view.getProductosAdicionalesVBox(), new ArrayList<>(Arrays.asList(view.getProductosAdicioanelesVBoxLabel(), view.getCentralitaLabel(), view.getCentralitaCombo(), view.getPackFutbolLabel(), view.getPacksFutbolCombo())));
        UIUtils.populateVBox(view.getLineasAdicionalesVBox(), new ArrayList<>(Arrays.asList(view.getLineasAdicionalesVBoxLabel(), view.getLineasAdicionalesView())));
        
        view.getTarifasCombo().setConverter(UIUtils.createConverter(dto -> dto.getNombre()));
        view.getDescuentoCombo().setConverter(UIUtils.createConverter(dto -> dto.getPorciento() + "%"));
        view.getCentralitaCombo().setConverter(UIUtils.createConverter(dto -> dto.getNombre()));
        view.getPacksFutbolCombo().setConverter(UIUtils.createConverter(dto -> dto.getNombre()));
        view.getPacksFutbolCombo().setConverter(UIUtils.createConverter(dto -> dto.getNombre()));

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
                int quantity = Integer.decode(itemQuantityLabel.getText());
                itemQuantityLabel.setText(Integer.toString(quantity+1));
                System.out.println("ID: " + itemId.getText() + " QT: " + itemQuantityLabel.getText());
            });
            
            deleteItemButton.setOnAction(e -> {
                int quantity = Integer.decode(itemQuantityLabel.getText());
                itemQuantityLabel.setText(Integer.toString(quantity >= 1 ? quantity - 1 : 0));
            });
            listViewItem.setHgrow(itemName, Priority.ALWAYS);
            listViewItem.setAlignment(Pos.CENTER_RIGHT);
            listViewItem.getChildren().addAll(itemId, itemName, addItemButton, itemQuantityLabel, deleteItemButton);

            view.getLineasAdicionalesView().getItems().add(listViewItem);
        }
        view.getLineasAdicionalesView().setPadding(Insets.EMPTY);
    }
}

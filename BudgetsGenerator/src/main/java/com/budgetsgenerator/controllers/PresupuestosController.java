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
import javafx.event.EventHandler;

public class PresupuestosController {
    private PresupuestosView view = new PresupuestosView();

    public PresupuestosController(PresupuestosView view) {
        this.view = view;
    }
    
    public void loadData(){
        view.getTarifasCombo().getItems().setAll(tarifasList);
        view.getLineasAdicionalesCombo().getItems().setAll(lineasAdicionalesList);
        view.getDescuentoCombo().getItems().setAll(descuentosList);
        view.getCentralitaCombo().getItems().setAll(centralitasList);
        view.getPacksFutbolCombo().getItems().setAll(packsFutbolList);
        view.getStreamingCombo().setDisable(true);
        view.getStreamingCombo().getItems().addAll("Amazon Prime", "Disney+", "Netflix");
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
       
        view.getAddLineaAdicionalButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LineasAdicionalesDTO selectedLineaAdicional = view.getLineasAdicionalesCombo().getSelectionModel().getSelectedItem();
                view.getLineasAdicionalesView().getItems().add(selectedLineaAdicional.getNombre());
            }
        });
        view.getDeleteLineaAdicionalButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int selectedIndex = view.getLineasAdicionalesCombo().getSelectionModel().getSelectedIndex();
                view.getLineasAdicionalesView().getItems().remove(selectedIndex - 1);
            }
        });
    }

    List<TarifasDTO> tarifasList = TarifasMapper.getInstance().toDTOList();
    List<LineasAdicionalesDTO> lineasAdicionalesList = LineasAdicionalesMapper.getInstance().toDTOList();
    List<DescuentosDTO> descuentosList = DescuentosMapper.getInstance().toDTOList();
    List<CentralitasDTO> centralitasList = CentralitasMapper.getInstance().toDTOList();
    List<PacksFutbolDTO> packsFutbolList = PacksFutbolMapper.getInstance().toDTOList();
}

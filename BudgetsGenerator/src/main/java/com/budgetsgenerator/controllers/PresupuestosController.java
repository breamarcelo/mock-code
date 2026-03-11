package com.budgetsgenerator.controllers;

import java.util.List;

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
import javafx.util.StringConverter;

public class PresupuestosController {
    private PresupuestosView view;

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

        view.getTarifasCombo().setConverter(new StringConverter<TarifasDTO>() {
            @Override
            public String toString(TarifasDTO object) {
                return object == null ? "" : object.getNombre();
            }
            @Override
            public TarifasDTO fromString(String string) {
                return null;
            }
        });
        
        view.getLineasAdicionalesCombo().setConverter(new StringConverter<LineasAdicionalesDTO>() {
            @Override
            public String toString(LineasAdicionalesDTO object) {
                return object == null ? "" : object.getNombre();
            }
            @Override
            public LineasAdicionalesDTO fromString(String string) {
                return null;
            }
        });
        
        view.getDescuentoCombo().setConverter(new StringConverter<DescuentosDTO>() {
            @Override
            public String toString(DescuentosDTO object) {
                return object == null ? "" : object.getPorciento() + "%";
            }
            @Override
            public DescuentosDTO fromString(String string) {
                return null;
            }
        });
        
        view.getCentralitaCombo().setConverter(new StringConverter<CentralitasDTO>() {
            @Override
            public String toString(CentralitasDTO object) {
                return object == null ? "" : object.getNombre();
            }
            @Override
            public CentralitasDTO fromString(String string) {
                return null;
            }
        });
        
        view.getPacksFutbolCombo().setConverter(new StringConverter<PacksFutbolDTO>() {
            @Override
            public String toString(PacksFutbolDTO object) {
                return object == null ? "" : object.getNombre();
            }
            @Override
            public PacksFutbolDTO fromString(String string) {
                return null;
            }
        });

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

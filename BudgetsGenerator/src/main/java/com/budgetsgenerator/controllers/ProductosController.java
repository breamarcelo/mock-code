package com.budgetsgenerator.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.budgetsgenerator.config.UIUtil;
import com.budgetsgenerator.dto.CentralitasDTO;
import com.budgetsgenerator.dto.DescuentosDTO;
import com.budgetsgenerator.dto.PacksFutbolDTO;
import com.budgetsgenerator.dto.StreamingDTO;
import com.budgetsgenerator.services.impl.CentralitasService;
import com.budgetsgenerator.services.impl.DescuentosService;
import com.budgetsgenerator.services.impl.PacksFutbolService;
import com.budgetsgenerator.services.impl.StreamingService;
import com.budgetsgenerator.views.ProductosView;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ListCell;

public class ProductosController {
    private ProductosView view;
    private List<DescuentosDTO> descuentoDTOs;
    private List<StreamingDTO> streamingDTOs;
    private List<CentralitasDTO> centralitasDTOs;
    private List<PacksFutbolDTO> packsFutbolDTOs;

    public ProductosController(ProductosView view) {
        this.view = view;
        load();
    }

    public void load() {
        descuentoDTOs = DescuentosService.getInstance().getAll();
        streamingDTOs = StreamingService.getInstance().getAll();
        centralitasDTOs = CentralitasService.getInstance().getAll();
        packsFutbolDTOs = PacksFutbolService.getInstance().getAll();
        view.getDescuentosListView().getItems().addAll(descuentoDTOs);
        view.getStreamingListView().getItems().addAll(streamingDTOs);
        view.getCentralitasListView().getItems().addAll(centralitasDTOs);
        view.getPacksFutbolListView().getItems().addAll(packsFutbolDTOs);

        view.getDescuentosListView().setCellFactory(param -> new ListCell<DescuentosDTO>() {
            @Override
            public void updateItem(DescuentosDTO item, boolean empty) {
                super.updateItem(item, empty);
                if(empty || item == null) {
                    setText(null);
                } else {
                    setText(Integer.toString(item.getPorciento()) + "%");
                }
            }
        });

        view.getDescuentosListView().setOnMouseClicked(eh -> {
            DescuentosDTO selected = view.getDescuentosListView().getSelectionModel().getSelectedItem();
            view.getDescuentosPorcientoTextField().setText(Integer.toString(selected.getPorciento()));
        });

        view.getStreamingListView().setCellFactory(param -> new ListCell<StreamingDTO>() {
            @Override
            public void updateItem(StreamingDTO item, boolean empty) {
                super.updateItem(item, empty);
                if(empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getNombre());
                }
            }
        });

        view.getStreamingListView().setOnMouseClicked(eh -> {
            StreamingDTO selected = view.getStreamingListView().getSelectionModel().getSelectedItem();
            view.getStreamingNombreTextField().setText(selected.getNombre());
        });
        
        view.getPacksFutbolListView().setCellFactory(param -> new ListCell<PacksFutbolDTO>() {
            @Override
            public void updateItem(PacksFutbolDTO item, boolean empty) {
                super.updateItem(item, empty);
                if(empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getNombre());
                }
            }
        });

        view.getPacksFutbolListView().setOnMouseClicked(eh -> {
            PacksFutbolDTO selected = view.getPacksFutbolListView().getSelectionModel().getSelectedItem();
            view.getPacksFutbolNombreTextField().setText(selected.getNombre());
            view.getPacksFutbolPrecioTextField().setText(Double.toString(selected.getPrecio()));
        });
        
        view.getCentralitasListView().setCellFactory(param -> new ListCell<CentralitasDTO>() {
            @Override
            public void updateItem(CentralitasDTO item, boolean empty) {
                super.updateItem(item, empty);
                if(empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getNombre());
                }
            }
        });

        view.getCentralitasListView().setOnMouseClicked(eh -> {
            CentralitasDTO selected = view.getCentralitasListView().getSelectionModel().getSelectedItem();
            view.getCentralitasNombreTextField().setText(selected.getNombre());
            view.getCentralitasPrecioTextField().setText(Double.toString(selected.getPrecio()));
        });

        view.getButtonsHBox().getChildren().addAll(view.getLimpiarButton(), view.getGuardarButton());
        view.getButtonsHBox().getStyleClass().add("menu-bar");
        view.getButtonsHBox().setPrefWidth(Double.MAX_VALUE);
        for(Node node : view.getButtonsHBox().getChildren()){
            if(view.getButtonsHBox().getChildren().indexOf(node) < view.getButtonsHBox().getChildren().size()-1) {
                view.getButtonsHBox().setMargin(node, new Insets(0, 20, 0, 0));
            }
        }

        view.getDescuentosButtonsBox().getChildren().addAll(view.getDescuentosAgregarButton(), view.getDescuentosModificarButton(), view.getDescuentosEliminarButton());
        view.getDescuentosEliminarButton().getStyleClass().add("cancel-btn");
        for(Node node : view.getDescuentosButtonsBox().getChildren()) {
            view.getDescuentosButtonsBox().setMargin(node, new Insets(0, 20, 0, 0));
        }

        view.getCentralitasButtonsBox().getChildren().addAll(view.getCentralitasAgregarButton(), view.getCentralitasModificarButton(), view.getCentralitasEliminarButton());
        view.getCentralitasEliminarButton().getStyleClass().add("cancel-btn");
        for(Node node : view.getCentralitasButtonsBox().getChildren()) {
            view.getCentralitasButtonsBox().setMargin(node, new Insets(0, 20, 0, 0));
        }

        view.getStreamingButtonsBox().getChildren().addAll(view.getStreamingAgregarButton(), view.getStreamingModificarButton(), view.getStreamingEliminarButton());
        view.getStreamingEliminarButton().getStyleClass().add("cancel-btn");
        for(Node node : view.getStreamingButtonsBox().getChildren()) {
            view.getStreamingButtonsBox().setMargin(node, new Insets(0, 20, 0, 0));
        }

        view.getPacksFutbolButtonsBox().getChildren().addAll(view.getPacksFutbolAgregarButton(), view.getPacksFutbolModificarButton(), view.getPacksFutbolEliminarButton());
        view.getPacksFutbolEliminarButton().getStyleClass().add("cancel-btn");
        for(Node node : view.getPacksFutbolButtonsBox().getChildren()) {
            view.getPacksFutbolButtonsBox().setMargin(node, new Insets(0, 20, 0, 0));
        }

        UIUtil.populateVBox(view.getDescuentosVBox(), new ArrayList<>(Arrays.asList(view.getDescuentosVBoxLabel(), view.getDescuentosPorcientoLabel(), view.getDescuentosPorcientoTextField(), view.getDescuentosButtonsBox(), view.getDescuentosListView())));   
        UIUtil.populateVBox(view.getStreamingVBox(), new ArrayList<>(Arrays.asList(view.getStreamingVBoxLabel(), view.getStreamingNombreLabel(), view.getStreamingNombreTextField(), view.getStreamingButtonsBox(), view.getStreamingListView())));
        UIUtil.populateVBox(view.getCentralitasVBox(), new ArrayList<>(Arrays.asList(view.getCentralitasVBoxLabel(), view.getCentralitasNombreLabel(), view.getCentralitasNombreTextField(), view.getCentralitasPrecioLabel(), view.getCentralitasPrecioTextField(), view.getCentralitasButtonsBox(), view.getCentralitasListView())));
        UIUtil.populateVBox(view.getPacksFutbolVBox(), new ArrayList<>(Arrays.asList(view.getPacksFutbolVBoxLabel(), view.getPacksFutbolNombreLabel(), view.getPacksFutbolNombreTextField(), view.getPacksFutbolPrecioLabel(), view.getPacksFutbolPrecioTextField(), view.getPacksFutbolButtonsBox(), view.getPacksFutbolListView())));

    }
}

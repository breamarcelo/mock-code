package com.budgetsgenerator.controllers;

import java.util.ArrayList;
import java.util.Arrays;

import com.budgetsgenerator.config.UIUtil;
import com.budgetsgenerator.dto.FibrasDTO;
import com.budgetsgenerator.dto.TarifasDTO;
import com.budgetsgenerator.services.impl.TarifasService;
import com.budgetsgenerator.views.TarifasView;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

public class TarifasController {
    public TarifasView view;
    public int counter = 0;
    public TarifasDTO tarifas;

    public TarifasController(TarifasView view) {
        this.view = view;
        this.tarifas = new TarifasDTO();
        load();
    }

    public void load() {
        view.getButtonsBox().getChildren().addAll(view.getNuevoButton(), view.getAbrirButton(), view.getActualizarutton(), view.getGuardarButton());
        view.getButtonsBox().getStyleClass().add("menu-bar");
        view.getButtonsBox().setPrefWidth(Double.MAX_VALUE);
        for(Node node : view.getButtonsBox().getChildren()){
            if(view.getButtonsBox().getChildren().indexOf(node) < view.getButtonsBox().getChildren().size()-1) {
                view.getButtonsBox().setMargin(node, new Insets(0, 20, 0, 0));
            }
        }

        view.getNuevoButton().setOnAction(eh -> {
            tarifas = new TarifasDTO();
            limpiarFormulario();
        });

        view.getAbrirButton().setOnAction(eh -> {
            TextInputDialog dialog = new TextInputDialog();
            
            dialog.getDialogPane().getStylesheets().add(getClass().getResource(UIUtil.getPalette()).toExternalForm());
            dialog.getDialogPane().getStylesheets().add(getClass().getResource("/css/dialog.css").toExternalForm());
            dialog.getDialogPane().getStyleClass().add("dialog");
            dialog.setTitle("Abrir presupuesto");
            dialog.setGraphic(null);
            dialog.setHeaderText("Seleccione un presupuesto:");

            Button cancelButton = (Button) dialog.getDialogPane().lookupButton(ButtonType.CANCEL);
            cancelButton.setText("Cancelar");
            cancelButton.getStyleClass().add("cancel-btn");

            Button okButton = (Button) dialog.getDialogPane().lookupButton(ButtonType.OK);
            okButton.setText("Abrir");
            
            TextField node = (TextField) dialog.getDialogPane().lookup("TextField");
            node.setVisible(false);

            ListView<TarifasDTO> tarifasListView = new ListView<>();
            tarifasListView.getItems().setAll(TarifasService.getInstance().getAll());
            
            tarifasListView.setCellFactory(param -> new ListCell<TarifasDTO>() {
                @Override
                protected void updateItem(TarifasDTO item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setText(null);
                    } else {
                        setText(item.getNombre());
                    }
                }
            });

            dialog.getDialogPane().setContent(tarifasListView);

            okButton.addEventFilter(ActionEvent.ACTION, e -> {
                TarifasDTO selected = tarifasListView.getSelectionModel().getSelectedItem();
                if(selected != null) {  
                    loadTarifaDTO(selected);
                    dialog.close();
                }
                eh.consume();
            });

            dialog.showAndWait();
        });

        view.getCheckboxesBox().getChildren().addAll(view.getTarifaTvLabel(), view.getTarifaTvCheckBox(), view.getTarifaStreamingLabel(), view.getTarifaStreamingCheckBox());
        for(Node node : view.getCheckboxesBox().getChildren()) {
            if(node instanceof Label) {
                view.getCheckboxesBox().setMargin(node, new Insets(0, 10, 0, 0));
            }
            if(node instanceof CheckBox) {
                view.getCheckboxesBox().setMargin(node, new Insets(0, 20, 0, 0));
            }
        }
        
        view.getServiciosCheckboxes1Box().getChildren().addAll(view.getServiciosLegalitasLabel(), view.getServiciosLegalitasBox(), view.getServiciosCloudLabel(), view.getServiciosCloudBox());
        view.getServiciosCheckboxes2Box().getChildren().addAll(view.getServiciosCiberProteccionLabel(), view.getServiciosCiberProteccionBox(), view.getServiciosAtencionPersonalizadaLabel(), view.getServiciosAtencionPersonalizadaBox());
        
        for(Node node : view.getServiciosCheckboxes1Box().getChildren()) {
            if(node instanceof Label) {
                view.getCheckboxesBox().setMargin(node, new Insets(0, 10, 0, 0));
            }
            if(node instanceof CheckBox) {
                view.getCheckboxesBox().setMargin(node, new Insets(0, 20, 0, 0));
            }
        }
        
        for(Node node : view.getServiciosCheckboxes2Box().getChildren()) {
            if(node instanceof Label) {
                view.getCheckboxesBox().setMargin(node, new Insets(0, 10, 0, 0));
            }
            if(node instanceof CheckBox) {
                view.getCheckboxesBox().setMargin(node, new Insets(0, 20, 0, 0));
            }
        }

        view.getFibrasListView().setCellFactory(param -> new ListCell<FibrasDTO>() {
            @Override
            public void updateItem(FibrasDTO item, boolean empty) {
                super.updateItem(item, empty);
                if(empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getNombre());
                }
            }
        });


        view.getFibrasListView().setOnMouseClicked(eh-> {
            FibrasDTO selected = view.getFibrasListView().getSelectionModel().getSelectedItem();
            view.getFibraNombreTextField().setText(selected.getNombre()); 
            view.getFibraSobrecargoTextField().setText(Double.toString(selected.getSobrecargo()));
        });
        
        UIUtil.populateVBox(view.getTarifasBox(), new ArrayList<>(Arrays.asList(view.getTarifasBoxLabel(), view.getTarifaNombreLabel(), view.getTarifaNombreTextField(), view.getTarifaTipoLabel(), view.getTarifaTipoTextField(), view.getTarifaPrecioLabel(), view.getTarifaPrecioTextField(), view.getCheckboxesBox())));
        UIUtil.populateVBox(view.getFibrasBox(), new ArrayList<>(Arrays.asList(view.getFibrasBoxLabel(), view.getFibraNombreLabel(), view.getFibraNombreTextField(), view.getFibraSobrecargoLabel(), view.getFibraSobrecargoTextField(), view.getFibrasListView())));
        UIUtil.populateVBox(view.getLineasBox(), new ArrayList<>(Arrays.asList(view.getLineasBoxLabel(), view.getLineasNumLabel(), view.getLineasNumField(), view.getLineasLlamadasabel(), view.getLineasLlamadasField(), view.getLineasGbLabel(), view.getLineasGbField())));
        UIUtil.populateVBox(view.getServiciosBox(), new ArrayList<>(Arrays.asList(view.getServiciosBoxLabel(), view.getServiciosRoamingLabel(), view.getServiciosRoamingTextField(), view.getServiciosInternacionalLabel(), view.getServiciosInternacionalTextField(), view.getServiciosCheckboxes1Box(), view.getServiciosCheckboxes2Box(), view.getServiciosCentralitaLabel(), view.getServiciosCentralitaTextField(), view.getServiciosNumBeneficiosLabel(), view.getServiciosNumBeneficiosTextField(), view.getServiciosDescuentoBeneficiosLabel(), view.getServiciosDescuentoBeneficiosTextField())));
    }

    public void limpiarFormulario() {
        view.getTarifaNombreTextField().setText("");
        view.getTarifaTipoTextField().setText("");
        view.getTarifaPrecioTextField().setText("");
        view.getTarifaTvCheckBox().setSelected(false);
        view.getTarifaStreamingCheckBox().setSelected(false);
        view.getFibraNombreTextField().setText("");
        view.getFibraSobrecargoTextField().setText("");
        view.getFibrasListView().getItems().clear();
        view.getLineasNumField().setText("");
        view.getLineasLlamadasField().setText("");
        view.getLineasGbField().setText("");
        view.getServiciosRoamingTextField().setText(""); 
        view.getServiciosInternacionalTextField().setText("");
        view.getServiciosCentralitaTextField().setText(""); 
        view.getServiciosNumBeneficiosTextField().setText(""); 
        view.getServiciosDescuentoBeneficiosTextField().setText("");
        view.getServiciosLegalitasBox().setSelected(false); 
        view.getServiciosCloudBox().setSelected(false);
        view.getServiciosCiberProteccionBox().setSelected(false); 
        view.getServiciosAtencionPersonalizadaBox().setSelected(false);
    }

    public void loadTarifaDTO(TarifasDTO selected) {
        tarifas = selected;
        view.getTarifaNombreTextField().setText(selected.getNombre());
        view.getTarifaTipoTextField().setText(selected.getTipo());
        view.getTarifaPrecioTextField().setText(Double.toString(selected.getPrecio()));
        view.getTarifaTvCheckBox().setSelected(selected.isTv());
        view.getTarifaStreamingCheckBox().setSelected(selected.isStreaming());
        view.getFibraNombreTextField().setText("");
        view.getFibraSobrecargoTextField().setText("");
        view.getFibrasListView().getItems().clear();
        view.getFibrasListView().getItems().addAll(selected.getFibras());
        view.getLineasNumField().setText(Integer.toString(selected.getLineasMoviles()));
        view.getLineasLlamadasField().setText(selected.getLlamadasMovil());
        view.getLineasGbField().setText(selected.getGbMovil());
        view.getServiciosRoamingTextField().setText(selected.getServiciosAdicionales().getRoaming()); 
        view.getServiciosInternacionalTextField().setText(selected.getServiciosAdicionales().getInternacional());
        view.getServiciosCentralitaTextField().setText(selected.getServiciosAdicionales().getCentralita()); 
        view.getServiciosNumBeneficiosTextField().setText(Integer.toString(selected.getServiciosAdicionales().getNumBeneficios())); 
        view.getServiciosDescuentoBeneficiosTextField().setText(selected.getServiciosAdicionales().getDescuentoBeneficios());
        view.getServiciosLegalitasBox().setSelected(selected.getServiciosAdicionales().isLegalitas()); 
        view.getServiciosCloudBox().setSelected(selected.getServiciosAdicionales().isCloud());
        view.getServiciosCiberProteccionBox().setSelected(selected.getServiciosAdicionales().isCiberProteccion()); 
        view.getServiciosAtencionPersonalizadaBox().setSelected(selected.getServiciosAdicionales().isAtencionPersonalizada());
    }
}

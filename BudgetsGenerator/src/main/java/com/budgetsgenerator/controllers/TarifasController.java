package com.budgetsgenerator.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.budgetsgenerator.config.UIUtil;
import com.budgetsgenerator.views.TarifasView;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;

public class TarifasController {
    public TarifasView view;
    public int counter = 0;

    public TarifasController(TarifasView view) {
        this.view = view;
        load();
    }

    public void load() {
        view.getButtonsBox().getChildren().addAll(view.getNuevoButton(), view.getAbrirButton(), view.getActualizarutton(), view.getGuardarButton());
        view.getButtonsBox().getStyleClass().add("menu-bar");
        view.getButtonsBox().setPrefWidth(Double.MAX_VALUE);
        
        // for(Node node : view.getButtonsBox().getChildren()){
        //     if(view.getButtonsBox().getChildren().indexOf(node) <= 5) {
        //         view.getButtonsBox().setMargin(node, new Insets(0, 20, 0, 0));
        //     }
        // }

        view.getCheckboxesBox().getChildren().addAll(view.getTarifaTvLabel(), view.getTarifaTvCheckBox(), view.getTarifaStreamingLabel(), view.getTarifaStreamingCheckBox());
        for(Node node : view.getCheckboxesBox().getChildren()) {
            if(node instanceof Label) {
                view.getCheckboxesBox().setMargin(node, new Insets(0, 10, 0, 0));
            }
            if(node instanceof CheckBox) {
                view.getCheckboxesBox().setMargin(node, new Insets(0, 20, 0, 0));
            }
        }
        
        view.getFibraSobrecargoTextField().setOnKeyReleased(eh -> {
            if(eh.getCode() == KeyCode.BACK_SPACE) {
                counter--;
            }
            String text = view.getFibraSobrecargoTextField().getText();
            Pattern pattern = Pattern.compile("^\\d{1,3}\\b");
            Matcher matcher = pattern.matcher(text);
            if(matcher.find()){
                counter++;
                view.getFibraSobrecargoTextField().setText(matcher.group() + ".00€");
                view.getFibraSobrecargoTextField().positionCaret(counter);
            } else {
                view.getFibraSobrecargoTextField().setText("");
                view.getFibraSobrecargoTextField().setText(matcher.group() + ".00€");
            }
        });

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

        UIUtil.populateVBox(view.getTarifasBox(), new ArrayList<>(Arrays.asList(view.getTarifasBoxLabel(), view.getTarifaNombreLabel(), view.getTarifaNombreTextField(), view.getTarifaTipoLabel(), view.getTarifaTipoTextField(), view.getTarifaPrecioLabel(), view.getTarifaPrecioTextField(), view.getCheckboxesBox())));
        UIUtil.populateVBox(view.getFibrasBox(), new ArrayList<>(Arrays.asList(view.getFibrasBoxLabel(), view.getFibraNombreLabel(), view.getFibraNombreTextField(), view.getFibraSobrecargoLabel(), view.getFibraSobrecargoTextField())));
        UIUtil.populateVBox(view.getServiciosBox(), new ArrayList<>(Arrays.asList(view.getServiciosBoxLabel(), view.getServiciosRoamingLabel(), view.getServiciosRoamingTextField(), view.getServiciosInternacionalLabel(), view.getServiciosInternacionalTextField(), view.getServiciosCheckboxes1Box(), view.getServiciosCheckboxes2Box(), view.getServiciosCentralitaLabel(), view.getServiciosCentralitaTextField(), view.getServiciosNumBeneficiosLabel(), view.getServiciosNumBeneficiosTextField(), view.getServiciosDescuentoBeneficiosLabel(), view.getServiciosDescuentoBeneficiosTextField())));
    }
}

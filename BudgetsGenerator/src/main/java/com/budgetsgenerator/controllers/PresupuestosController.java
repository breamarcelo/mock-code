package com.budgetsgenerator.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.budgetsgenerator.config.UIUtil;
import com.budgetsgenerator.dto.CentralitasDTO;
import com.budgetsgenerator.dto.DescuentosDTO;
import com.budgetsgenerator.dto.FibrasDTO;
import com.budgetsgenerator.dto.LineasAdicionalesDTO;
import com.budgetsgenerator.dto.PacksFutbolDTO;
import com.budgetsgenerator.dto.StreamingDTO;
import com.budgetsgenerator.dto.TarifasDTO;
import com.budgetsgenerator.services.impl.CentralitasService;
import com.budgetsgenerator.services.impl.DescuentosService;
import com.budgetsgenerator.services.impl.LineasAdicionalesService;
import com.budgetsgenerator.services.impl.PacksFutbolService;
import com.budgetsgenerator.services.impl.StreamingService;
import com.budgetsgenerator.services.impl.TarifasService;
import com.budgetsgenerator.viewmodels.ResumentTableItem;
import com.budgetsgenerator.views.PresupuestosView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class PresupuestosController {
    private PresupuestosView view = new PresupuestosView();
    private ResumentTableItem tarifaRow;

    public PresupuestosController(PresupuestosView view) {
        this.view = view;
    }
    
    public void loadData(){
        tarifaRow = new ResumentTableItem();

        List<TarifasDTO> tarifasList = TarifasService.getInstance().getAll();
        List<LineasAdicionalesDTO> lineasAdicionalesList = LineasAdicionalesService.getInstance().getAll();
        List<DescuentosDTO> descuentosList = DescuentosService.getInstance().getAll();
        List<CentralitasDTO> centralitasList = CentralitasService.getInstance().getAll();
        List<PacksFutbolDTO> packsFutbolList = PacksFutbolService.getInstance().getAll();
        List<StreamingDTO> streamingList = StreamingService.getInstance().getAll();
        
        view.getTarifasCombo().getItems().setAll(tarifasList);
        view.getDescuentoCombo().getItems().setAll(descuentosList);
        view.getCentralitaCombo().getItems().setAll(centralitasList);
        view.getPacksFutbolCombo().getItems().setAll(packsFutbolList);
        view.getStreamingCombo().setDisable(true);
        view.getStreamingCombo().getItems().setAll(streamingList);
        
        view.getTarifasCombo().setConverter(UIUtil.createConverter(dto -> dto.getNombre()));
        view.getDescuentoCombo().setConverter(UIUtil.createConverter(dto -> dto.getPorciento() + "%"));
        view.getCentralitaCombo().setConverter(UIUtil.createConverter(dto -> dto.getNombre()));
        view.getFibraCombo().setConverter(UIUtil.createConverter(dto -> dto.getNombre()));
        view.getPacksFutbolCombo().setConverter(UIUtil.createConverter(dto -> dto.getNombre()));
        view.getStreamingCombo().setConverter(UIUtil.createConverter(dto -> dto.getNombre()));
        
        ObservableList<ResumentTableItem> resumenPresupuesto = FXCollections.observableArrayList(
            new ResumentTableItem(),
            new ResumentTableItem()
        );
        view.getTarifasCombo().getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            view.getFibraCombo().getItems().clear();
            view.getFibraCombo().getItems().setAll(newValue.getFibras());
            view.getStreamingCombo().setDisable(!newValue.isStreaming());
            updateTarifaRow(newValue);
            // presupuesto.setTarifa(newValue);
            // System.out.println("Presupuesto tarifa: " + presupuesto.getTarifa().getNombre() + "\n" + 
            // presupuesto.getTarifa().getLineasMoviles() + " linea(s) móvil(es) " + presupuesto.getTarifa().getLlamadasMovil() + " " + presupuesto.getTarifa().getGbMovil());
            // ResumentTableItem updated = new ResumentTableItem("1", presupuesto.getTarifa().getNombre(), Double.toString(presupuesto.getTarifa().getPrecio()));
            // resumenPresupuesto.set(0, updated);
            // view.getResumenView().refresh();
        });
        
        view.getFibraCombo().getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            updateTarifaRow(newValue);
        });
        
        view.getStreamingCombo().getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            updateTarifaRow(newValue);
        });

        view.getCentralitaCombo().getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            
        });

        view.getPacksFutbolCombo().getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            
        });

        view.getDescuentoCombo().getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            
        });
        
        UIUtil.populateVBox(view.getTarifasVBox(), new ArrayList<>(Arrays.asList(view.getTarifasVBoxLabel(), view.getTarifaLabel(), view.getTarifasCombo(), view.getFibraLabel(), view.getFibraCombo(), view.getStreamingLabel(), view.getStreamingCombo())));
        UIUtil.populateVBox(view.getProductosAdicionalesVBox(), new ArrayList<>(Arrays.asList(view.getProductosAdicioanelesVBoxLabel(), view.getCentralitaLabel(), view.getCentralitaCombo(), view.getPackFutbolLabel(), view.getPacksFutbolCombo())));
        UIUtil.populateVBox(view.getLineasAdicionalesVBox(), new ArrayList<>(Arrays.asList(view.getLineasAdicionalesVBoxLabel(), view.getLineasAdicionalesView())));
        UIUtil.populateVBox(view.getResumenVBox(), new ArrayList<>(Arrays.asList(view.getResumenVBoxLabel(), view.getDescuentoLabel(), view.getDescuentoCombo(), view.getResumenView())));
    
        TableColumn<ResumentTableItem, String> cantidadTableColumn = new TableColumn<>("Cantidad");
        TableColumn<ResumentTableItem, String> descripcionTableColumn = new TableColumn<>("Descripción");
        TableColumn<ResumentTableItem, Double> precioTableColumn = new TableColumn<>("Importe");

        cantidadTableColumn.setCellValueFactory(cellData -> cellData.getValue().cantidadProperty().asString());
        descripcionTableColumn.setCellValueFactory(cellData -> cellData.getValue().descripcionProperty());
        precioTableColumn.setCellValueFactory(cellData -> cellData.getValue().importeProperty().asObject());

        cantidadTableColumn.setMinWidth(60);
        cantidadTableColumn.setMaxWidth(60);
        
        precioTableColumn.setMinWidth(100);
        precioTableColumn.setMaxWidth(100);

        descripcionTableColumn.setMaxWidth(Double.MAX_VALUE);
        descripcionTableColumn.resizableProperty().set(true);
        
        view.getResumenView().getColumns().clear();
        view.getResumenView().getColumns().addAll(cantidadTableColumn, descripcionTableColumn, precioTableColumn); 
        view.getResumenView().getItems().add(tarifaRow);
        view.getResumenVBox().setVgrow(view.getResumenView(), Priority.ALWAYS);
        view.getResumenView().setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN);
        
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
                quantity += 1;
                itemQuantityLabel.setText(Integer.toString(quantity));

                // int index = 0;
                // boolean exist = false;
                // for(LineasPresupuestoDTO linea : lineasPresupuestoList) {
                //     if(linea.getLineasAdicional().getId() == dto.getId()){
                //         index = lineasPresupuestoList.indexOf(linea);
                //         exist = true;
                //     }
                // }
                // if(exist){
                //     lineasPresupuestoList.set(index, new LineasPresupuestoDTO(index, quantity, dto));
                // } else {
                //     lineasPresupuestoList.add(new LineasPresupuestoDTO(index, quantity, dto));
                // }

                // presupuesto.setLineasAdicionales(lineasPresupuestoList);
                
                // for(LineasPresupuestoDTO linea : lineasPresupuestoList) {
                //     System.out.println(linea.getCantidad() + " | " + linea.getLineasAdicional().getNombre() + " | " + linea.getLineasAdicional().getPrecio()*linea.getCantidad());
                // }
                // System.out.println("list size: " + lineasPresupuestoList.size());
                // System.out.println("-----------------------------");
            });
            
            deleteItemButton.setOnAction(e -> {
                int quantity = Integer.decode(itemQuantityLabel.getText());
                quantity -= 1;
                itemQuantityLabel.setText(Integer.toString(quantity >= 1 ? quantity : 0));

                // if(lineasPresupuestoList.size() > 0){

                //     int index = 0;
                //     for(LineasPresupuestoDTO linea : lineasPresupuestoList) {
                //         if(linea.getLineasAdicional().getId() == dto.getId()){
                //             index = lineasPresupuestoList.indexOf(linea);
                //         }
                //     }
                    
                //     if(quantity > 0) {
                //         lineasPresupuestoList.set(index, new LineasPresupuestoDTO(index, quantity, dto));
                //     } else {
                //         lineasPresupuestoList.remove(index);
                //     }

                //     presupuesto.setLineasAdicionales(lineasPresupuestoList);
                // }

                // for(LineasPresupuestoDTO linea : lineasPresupuestoList) {
                //     System.out.println(linea.getCantidad() + " | " + linea.getLineasAdicional().getNombre() + " | " + linea.getLineasAdicional().getPrecio()*linea.getCantidad());
                // }
                // System.out.println("list size: " + lineasPresupuestoList.size());
                // System.out.println("-----------------------------");
            });
            listViewItem.setHgrow(itemName, Priority.ALWAYS);
            listViewItem.setAlignment(Pos.CENTER_RIGHT);
            listViewItem.getChildren().addAll(itemId, itemName, addItemButton, itemQuantityLabel, deleteItemButton);

            view.getLineasAdicionalesView().getItems().add(listViewItem);
        }
        view.getLineasAdicionalesView().setPadding(Insets.EMPTY);
    }

    private void refreshTarifaRow(int cantidad, String descripcion, double importe) {
        tarifaRow.setCantidadProperty(cantidad);
        tarifaRow.setDescripcion(descripcion);
        tarifaRow.setImporteProperty(importe);
    }

    private <T> void updateTarifaRow(T dto){
        String descripcion = tarifaRow.getDescripcion().isEmpty() ? "" : tarifaRow.getDescripcion();
        double precio = 0.0;
        
        if(dto instanceof TarifasDTO) {
            descripcion = 
                "Pack " + ((TarifasDTO) dto).getNombre() + 
                "\n" + ((TarifasDTO) dto).getLineasMoviles() + (((TarifasDTO) dto).getLineasMoviles() > 1 ? " líneas móviles " : " línea móvil ") + 
                " con " + (((TarifasDTO) dto).getLlamadasMovil() == "ilimitadas" ? "llamadas ilimitadas " : ((TarifasDTO) dto).getLlamadasMovil()) + 
                "y " + (((TarifasDTO) dto).getGbMovil() == "ilimitados" ? "Gb ilimitados" : ((TarifasDTO) dto).getGbMovil());
                if(((TarifasDTO) dto).isTv()) {
                    descripcion += "\nTV con más de 90 canales" + "\n ";
                } 
                precio += ((TarifasDTO) dto).getPrecio();
        }
        
        if(dto instanceof FibrasDTO) {
            ArrayList<String> list = new ArrayList<>(Arrays.asList(descripcion.split("\n")));
            
            list.set(list.size()-1, "Fibra de " + ((FibrasDTO) dto).getNombre());
            descripcion = String.join("\n", list);
            precio += ((FibrasDTO) dto).getSobrecargo();
        }
        
        if(dto instanceof StreamingDTO) {
            descripcion += "\n" + ((StreamingDTO) dto).getNombre() + " inlcuído";
        }

        refreshTarifaRow(1, descripcion, precio);
    }
}

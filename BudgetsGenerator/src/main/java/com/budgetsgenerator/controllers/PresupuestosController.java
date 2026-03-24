package com.budgetsgenerator.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.budgetsgenerator.config.UIUtil;
import com.budgetsgenerator.dto.CentralitasDTO;
import com.budgetsgenerator.dto.DescuentosDTO;
import com.budgetsgenerator.dto.FibrasDTO;
import com.budgetsgenerator.dto.LineasAdicionalesDTO;
import com.budgetsgenerator.dto.LineasPresupuestoDTO;
import com.budgetsgenerator.dto.PacksFutbolDTO;
import com.budgetsgenerator.dto.PresupuestosDTO;
import com.budgetsgenerator.dto.ServiciosAdicionalesDTO;
import com.budgetsgenerator.dto.StreamingDTO;
import com.budgetsgenerator.dto.TarifasDTO;
import com.budgetsgenerator.services.impl.CentralitasService;
import com.budgetsgenerator.services.impl.DescuentosService;
import com.budgetsgenerator.services.impl.LineasAdicionalesService;
import com.budgetsgenerator.services.impl.LineasPresupuestoService;
import com.budgetsgenerator.services.impl.PacksFutbolService;
import com.budgetsgenerator.services.impl.PresupuestosService;
import com.budgetsgenerator.services.impl.StreamingService;
import com.budgetsgenerator.services.impl.TarifasService;
import com.budgetsgenerator.viewmodels.ResumentTableItem;
import com.budgetsgenerator.views.PresupuestosView;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class PresupuestosController {
    private PresupuestosView view = new PresupuestosView();
    private List<LineasPresupuestoDTO> lineasPresupuestoList;
    private double total;
    private PresupuestosDTO presupuesto;

    public PresupuestosController(PresupuestosView view) {
        this.view = view;
    }
    
    public void loadData(){
        lineasPresupuestoList  = new ArrayList<>();
        presupuesto = new PresupuestosDTO();
        
        List<TarifasDTO> tarifasList = TarifasService.getInstance().getAll();
        List<LineasAdicionalesDTO> lineasAdicionalesList = LineasAdicionalesService.getInstance().getAll();
        List<DescuentosDTO> descuentosList = DescuentosService.getInstance().getAll();
        List<CentralitasDTO> centralitasList = CentralitasService.getInstance().getAll();
        List<PacksFutbolDTO> packsFutbolList = PacksFutbolService.getInstance().getAll();
        List<StreamingDTO> streamingList = StreamingService.getInstance().getAll();
        
        view.getTarifasCombo().getItems().setAll(tarifasList);
        view.getDescuentoCombo().getItems().setAll(descuentosList);
        view.getDescuentoCombo().setDisable(true);
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
        
        view.getTarifasCombo().setOnAction(e -> {
            view.getFibraCombo().getItems().clear();
            view.getFibraCombo().getItems().setAll(view.getTarifasCombo().getValue().getFibras());
            view.getStreamingCombo().setDisable(!view.getTarifasCombo().getValue().isStreaming());
            view.getStreamingCombo().valueProperty().set(null);
            view.getDescuentoCombo().setDisable(view.getTarifasCombo().getValue() == null);
            view.getDescuentoCombo().valueProperty().set(null);
            updateResumenTable();
        });

        view.getFibraCombo().setOnAction(e -> updateResumenTable());
        view.getStreamingCombo().setOnAction(e -> updateResumenTable());
        view.getCentralitaCombo().setOnAction(e -> updateResumenTable());
        view.getPacksFutbolCombo().setOnAction(e -> updateResumenTable());
        view.getDescuentoCombo().setOnAction(e -> updateResumenTable());
        
        view.getTotalHBox().getChildren().addAll(view.getTotalLabel(), view.getTotalField());
        view.getTotalHBox().setAlignment(Pos.CENTER_RIGHT);
        view.getTotalHBox().setMargin(view.getTotalLabel(), new Insets(0, 10, 0, 0));
        view.getTotalField().setEditable(false);
        
        view.getAccionesHBox1().getChildren().addAll(view.getNuevoButton(), view.getAccionesComboBox());
        view.getAccionesHBox2().getChildren().addAll(view.getLoadButton(), view.getSaveButton());
        view.getAccionesHBox3().getChildren().addAll(view.getEliminarButton(), view.getGenerarPdfButton());

        UIUtil.populateVBox(view.getTarifasVBox(), new ArrayList<>(Arrays.asList(view.getTarifasVBoxLabel(), view.getTarifaLabel(), view.getTarifasCombo(), view.getFibraLabel(), view.getFibraCombo(), view.getStreamingLabel(), view.getStreamingCombo())));
        UIUtil.populateVBox(view.getProductosAdicionalesVBox(), new ArrayList<>(Arrays.asList(view.getProductosAdicioanelesVBoxLabel(), view.getCentralitaLabel(), view.getCentralitaCombo(), view.getPackFutbolLabel(), view.getPacksFutbolCombo())));
        UIUtil.populateVBox(view.getLineasAdicionalesVBox(), new ArrayList<>(Arrays.asList(view.getLineasAdicionalesVBoxLabel(), view.getLineasAdicionalesView())));
        UIUtil.populateVBox(view.getAccionesVBox(), new ArrayList<>(Arrays.asList(view.getAcccionesVBoxLabel(), view.getAccionesHBox1(), view.getAccionesHBox2(), view.getAccionesHBox3())));
        UIUtil.populateVBox(view.getResumenVBox(), new ArrayList<>(Arrays.asList(view.getResumenVBoxLabel(), view.getDescuentoLabel(), view.getDescuentoCombo(), view.getResumenView(), view.getTotalHBox())));

        TableColumn<ResumentTableItem, Integer> cantidadTableColumn = new TableColumn<>("Cantidad");
        TableColumn<ResumentTableItem, ListView<String>> descripcionTableColumn = new TableColumn<>("Descripción");
        TableColumn<ResumentTableItem, Double> precioTableColumn = new TableColumn<>("Importe");

        cantidadTableColumn.setCellValueFactory(new PropertyValueFactory<ResumentTableItem, Integer>("cantidad"));
        descripcionTableColumn.setCellValueFactory(new PropertyValueFactory<ResumentTableItem, ListView<String>>("descripcion"));
        precioTableColumn.setCellValueFactory(new PropertyValueFactory<ResumentTableItem, Double>("importe"));

        cantidadTableColumn.setMinWidth(60);
        cantidadTableColumn.setMaxWidth(60);
        
        precioTableColumn.setMinWidth(100);
        precioTableColumn.setMaxWidth(100);

        descripcionTableColumn.setMaxWidth(Double.MAX_VALUE);
        descripcionTableColumn.resizableProperty().set(true);
        
        view.getResumenView().getColumns().clear();
        view.getResumenView().getColumns().addAll(cantidadTableColumn, descripcionTableColumn, precioTableColumn); 
        view.getResumenVBox().setVgrow(view.getResumenView(), Priority.ALWAYS);
        view.getResumenView().setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN);
        
        view.getGenerarPdfButton().setOnAction(e -> {
            int cantidad = 0;
            ListView<String> descripcion = new ListView<>();
            double importe = 0.0;
            double total = 0.0;
            for(ResumentTableItem item : view.getResumenView().getItems()) {
                cantidad = item.getCantidad();
                descripcion = item.getDescripcion();
                importe = item.getImporte();
            }
            total = Double.valueOf(view.getTotalField().getText());
        });

        view.getSaveButton().setOnAction(e -> {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Guardar presupuesto");
            dialog.setHeaderText("Escribe un nombre para el presupuesto:");
            Optional<String> nombre = dialog.showAndWait();
            presupuesto.setNombre(dialog.getResult());
            presupuesto.setLineasAdicionales(lineasPresupuestoList);
            
            PresupuestosDTO guardado = PresupuestosService.getInstance().save(presupuesto);
            
            for(LineasPresupuestoDTO dto : lineasPresupuestoList) {
                dto.setPresupuesto(guardado);
                dto.setId(null);
                LineasPresupuestoService.getInstance().save(dto);
            }
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
                addLineasAdicionales(dto, quantity);
                updateResumenTable();
            });
            
            deleteItemButton.setOnAction(e -> {
                int quantity = Integer.decode(itemQuantityLabel.getText());
                quantity -= 1;
                itemQuantityLabel.setText(Integer.toString(quantity >= 1 ? quantity : 0));
                removeLineasAdicionales(dto, quantity);
                updateResumenTable();
            });

            listViewItem.setHgrow(itemName, Priority.ALWAYS);
            listViewItem.setAlignment(Pos.CENTER_RIGHT);
            listViewItem.getChildren().addAll(itemId, itemName, addItemButton, itemQuantityLabel, deleteItemButton);

            view.getLineasAdicionalesView().getItems().add(listViewItem);
        }
        view.getLineasAdicionalesView().setPadding(Insets.EMPTY);
    }

    private void updateResumenTable() {
        total = 0.0;
        view.getResumenView().getItems().clear();
        if(view.getTarifasCombo().getValue() != null) {
            updateTarifaRow();
        }
        if(view.getDescuentoCombo().getValue() != null) {
            updateDescuentoRow();
        }
        if(view.getCentralitaCombo().getValue() != null){
            updateCentralitaRow();
        }
        if(view.getPacksFutbolCombo().getValue() != null) {
            updatePackFutbolRow();
        }

        if(lineasPresupuestoList != null) {
            for(LineasPresupuestoDTO linea : lineasPresupuestoList) {    
                ResumentTableItem row = new ResumentTableItem();
                ListView<String> descripcion = new ListView<>();
                descripcion.setPrefHeight(30);
                descripcion.getItems().add(linea.getLineasAdicional().getNombre());
                
                double importe = (double) linea.getLineasAdicional().getPrecio() * linea.getCantidad();
                row.setCantidad(linea.getCantidad());
                row.setDescripcion(descripcion);
                row.setImporte(importe);
                total += importe;
                view.getResumenView().getItems().add(row);
            }
        }

        if(view.getTarifasCombo().getValue().getServiciosAdicionales() != null) {
            updateServiciosAdicionalesRow();
        }

        view.getResumenView().refresh();

        view.getTotalField().setText(String.valueOf(total));
    }

    private void updateTarifaRow(){
        ResumentTableItem row = new ResumentTableItem();
        TarifasDTO tarifasDTO = view.getTarifasCombo().getValue();
        FibrasDTO fibrasDTO = view.getFibraCombo().getValue();
        StreamingDTO streamingDTO = view.getStreamingCombo().getValue();
        presupuesto.setTarifa(tarifasDTO);
        presupuesto.setFibra(fibrasDTO);
        presupuesto.setStreaming(streamingDTO);

        double importe = tarifasDTO.getPrecio();
        ListView<String> descripcionList = new ListView<>();
        descripcionList.setPrefHeight(125);
        
        descripcionList.getItems().add("Tarifa " + tarifasDTO.getNombre());
        descripcionList.getItems().add(tarifasDTO.getLineasMoviles() + (tarifasDTO.getLineasMoviles() > 1 ? " líneas móviles " : " línea móvil ") + 
        " con " + (tarifasDTO.getLlamadasMovil().toLowerCase().contains("ilimitadas") ? "llamadas ilimitadas " : tarifasDTO.getLlamadasMovil()) + 
        "y " + (tarifasDTO.getGbMovil().toLowerCase().contains("ilimitados") ? "Gb ilimitados" : tarifasDTO.getGbMovil()));
        
        if(tarifasDTO.isTv()) {
                descripcionList.getItems().add("Pack " + tarifasDTO.getNombre());
        } 
        
        if(fibrasDTO != null) {
            descripcionList.getItems().add("Fibra " + fibrasDTO.getNombre());
            importe += fibrasDTO.getSobrecargo();
        }
        
        if(streamingDTO != null) {
            descripcionList.getItems().add(tarifasDTO.isStreaming() ? "Con " + streamingDTO.getNombre() : "");
        }

        row.setCantidad(1);
        row.setDescripcion(descripcionList);
        row.setImporte(importe);
        total += importe;
        view.getResumenView().getItems().add(row);
    }

    private void updateCentralitaRow() {
        ResumentTableItem row = new ResumentTableItem();
        CentralitasDTO centralitasDTO = view.getCentralitaCombo().getValue();
        presupuesto.setCentralita(centralitasDTO);
        ListView<String> descripcion = new ListView<>();
        descripcion.setPrefHeight(30);
        descripcion.getItems().add("Centralita " + centralitasDTO.getNombre());
        
        double importe = centralitasDTO.getPrecio();
        row.setCantidad(1);
        row.setDescripcion(descripcion);
        row.setImporte(importe);
        total += importe;
        view.getResumenView().getItems().add(row);
    }
    
    public void updatePackFutbolRow() {
        ResumentTableItem row = new ResumentTableItem();
        PacksFutbolDTO dto = view.getPacksFutbolCombo().getValue();
        presupuesto.setPackFutbol(dto);
        ListView<String> descripcion = new ListView<>();
        descripcion.setPrefHeight(30);
        
        if(dto != null) {
            descripcion.getItems().add("Pack " + dto.getNombre());
        }
        
        double importe = dto.getPrecio();
        row.setCantidad(1);
        row.setDescripcion(descripcion);
        row.setImporte(importe);
        total += importe;
        view.getResumenView().getItems().add(row);
    }

    private void updateDescuentoRow() {
        ResumentTableItem row = new ResumentTableItem();
        DescuentosDTO dto = view.getDescuentoCombo().getValue();
        presupuesto.setDescuento(dto);
        ListView<String> descripcion = new ListView<>();
        descripcion.setPrefHeight(30);
        
        if(dto != null) {
            descripcion.getItems().add("Descuento " + dto.getPorciento() + "%");
        }
        
        double importe = (double) (view.getResumenView().getItems().get(0).getImporte() * dto.getPorciento())/-100;
        row.setCantidad(1);
        row.setDescripcion(descripcion);
        row.setImporte(importe);
        total += importe;
        view.getResumenView().getItems().add(row);
    }
    
    private void addLineasAdicionales(LineasAdicionalesDTO dto, int quantity) {
        Integer index = 0;
        boolean exist = false;
        for(LineasPresupuestoDTO linea : lineasPresupuestoList) {
            if(linea.getLineasAdicional().getId() == dto.getId()){
                index = lineasPresupuestoList.indexOf(linea);
                exist = true;
            }
        }
        if(exist){
            lineasPresupuestoList.set(index, new LineasPresupuestoDTO(index, quantity, dto));
        } else {
            lineasPresupuestoList.add(new LineasPresupuestoDTO(index, quantity, dto));
        }
    }

    public void removeLineasAdicionales(LineasAdicionalesDTO dto, int quantity) {
        if(lineasPresupuestoList.size() > 0){
            int index = 0;
            for(LineasPresupuestoDTO linea : lineasPresupuestoList) {
                if(linea.getLineasAdicional().getId() == dto.getId()){
                    index = lineasPresupuestoList.indexOf(linea);
                }
            }
            
            if(quantity > 0) {
                lineasPresupuestoList.set(index, new LineasPresupuestoDTO(index, quantity, dto));
            } else {
                lineasPresupuestoList.remove(index);
            }
        }
    }

    private void updateServiciosAdicionalesRow() {
        ServiciosAdicionalesDTO dto = view.getTarifasCombo().getValue().getServiciosAdicionales();
        ResumentTableItem row = new ResumentTableItem();
        ListView<String> descripcion = new ListView<>();
        descripcion.setPrefHeight(197);
        descripcion.getItems().add("Roaming: llamadas y " + dto.getRoaming() + " en Zona Roaming UE");
        if(dto.getInternacional() != null){
            descripcion.getItems().add("Llamadas internacionales: " + dto.getInternacional());
        }
        if(dto.isLegalitas()) {descripcion.getItems().add("Legálitas Protección Jurídica Negocios Orange");}
        if(dto.isCloud()) {descripcion.getItems().add("Cloud y Protección Dispositivos");}
        if(dto.isCiberProteccion()) {descripcion.getItems().add("Ciber Protección Red Móvil");}
        if(dto.isAtencionPersonalizada()) {descripcion.getItems().add("Atención personalizada");}
        if(dto.getCentralita() != null){
            descripcion.getItems().add("Centralita Negocio: " + dto.getInternacional());
        }
        if(dto.getNumBeneficios() > 0) {
            descripcion.getItems().add(dto.getNumBeneficios() + " beneficios a elegir para tu negocio" + 
            (dto.getDescuentoBeneficios() != null ? "con " + dto.getDescuentoBeneficios() : ""));
        }

        row.setCantidad(1);
        row.setDescripcion(descripcion);
        row.setImporte(0.0);
        view.getResumenView().getItems().add(row);
    }
}

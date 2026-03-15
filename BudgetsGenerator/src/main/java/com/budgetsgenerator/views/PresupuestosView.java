package com.budgetsgenerator.views;

import com.budgetsgenerator.controllers.PresupuestosController;
import com.budgetsgenerator.dto.CentralitasDTO;
import com.budgetsgenerator.dto.DescuentosDTO;
import com.budgetsgenerator.dto.FibrasDTO;
import com.budgetsgenerator.dto.PacksFutbolDTO;
import com.budgetsgenerator.dto.StreamingDTO;
import com.budgetsgenerator.dto.TarifasDTO;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PresupuestosView extends GridPane{
    private VBox tarifasVBox = new VBox();
    private Label tarifasVBoxLabel = new Label("TARIFAS");
    private VBox lineasAdicionalesVBox = new VBox();
    private Label lineasAdicionalesVBoxLabel = new Label("LÍNEAS ADICIONALES");
    private VBox productosAdicionalesVBox = new VBox();
    private Label productosAdicioanelesVBoxLabel = new Label("SERVICIOS ADICIONALES");
    private VBox resumenVBox = new VBox();
    private Label resumenVBoxLabel = new Label("RESUMEN");

    private ComboBox<TarifasDTO> tarifasCombo = new ComboBox<>();
    private ComboBox<FibrasDTO> fibraCombo = new ComboBox<>();
    private ComboBox<StreamingDTO> streamingCombo = new ComboBox<>();
    private ComboBox<DescuentosDTO> descuentoCombo = new ComboBox<>();
    private ComboBox<CentralitasDTO> centralitaCombo = new ComboBox<>();
    private ComboBox<PacksFutbolDTO> packsFutbolCombo = new ComboBox<>();
    private ListView<HBox> lineasAdicionalesView = new ListView<>();
    private TableView<PresupuestosController.ResumenItem> resumenView = new TableView<>();
    private Button saveButton = new Button("Guardar Presupuesto");
    private Button loadButton = new Button("Cargar Presupuesto");
    private Button limpiarButton = new Button("Limpiar");
    private Button generarPdfButton = new Button("Generar PDF");
    private final Label presupuestoLabel = new Label("Presupuestos");
    private final Label tarifaLabel = new Label("Tarifa:");
    private final Label fibraLabel = new Label("Fibra:");
    private final Label streamingLabel = new Label("Streaming:");
    private final Label lineasAdicionalesLabel = new Label("Líneas Adicionales:");
    private final Label descuentoLabel = new Label("Descuento:");
    private final Label centralitaLabel = new Label("Centralita:");
    private final Label packFutbolLabel = new Label("Pack Fútbol:");
    private final Label totalLabel = new Label("TOTAL:");
    private TextField totaField = new TextField();

    public PresupuestosView() {
        this.getStylesheets().add(getClass().getResource("/css/presupuestos.css").toExternalForm());
        this.getStyleClass().add("grid_pane");

        // for(int i=0; i<4; i++){
        //     ColumnConstraints col = new ColumnConstraints();
        //     this.getColumnConstraints().add(col);
        //     //col.setPercentWidth(25);
        // }

        // for(int i=0; i<15; i++){
        //     RowConstraints row = new RowConstraints();
        //     this.getRowConstraints().add(row);
        //     //row.setPercentHeight(6.66);
        // }
        presupuestoLabel.setId("presupuestos_title");
        totalLabel.setId("total_label");
        
        this.add(presupuestoLabel, 0, 0, 1, 1);
        this.add(tarifasVBox, 0, 1, 1, 1);
        this.add(productosAdicionalesVBox, 0, 2, 1, 1);
        this.add(lineasAdicionalesVBox, 0, 3, 1, 1);
        this.add(resumenVBox, 1, 1, 1, 3);
        // this.add(tarifaLabel, 0, 1, 2, 1);
        // this.add(tarifasCombo, 0, 2, 2, 1);
        // this.add(fibraLabel, 0, 3, 1, 1);
        // this.add(fibraCombo, 0, 4, 1, 1);
        // this.add(lineasAdicionalesLabel, 0, 5, 2, 1);
        // this.add(lineasAdicionalesView, 0, 8, 2, 6);
        // this.add(saveButton, 0, 14, 1, 1);
        // this.add(streamingLabel, 1, 3, 1, 1);
        // this.add(streamingCombo, 1, 4, 1, 1);
        // this.add(loadButton, 1, 14, 1, 1);
        // this.add(loadButton, 1, 14, 1, 1);
        // this.add(loadButton, 1, 14, 1, 1);
        // this.add(loadButton, 1, 14, 1, 1);
        // this.add(loadButton, 1, 14, 1, 1);
        // this.add(centralitaLabel, 2, 3, 2, 1);
        // this.add(centralitaCombo, 2, 4, 2, 1);
        // this.add(packFutbolLabel, 2, 5, 2, 1);
        // this.add(packsFutbolCombo, 2, 6, 2, 1);
        // this.add(resumenView, 2, 7, 2, 6);
        // this.add(totalLabel, 2, 13, 1, 1);
        // this.add(limpiarButton, 2, 14, 1, 1);
        // this.add(descuentoLabel, 3, 1, 2, 1);
        // this.add(descuentoCombo, 3, 2, 1, 1);
        // this.add(totaField, 3, 13, 1, 1);
        // this.add(generarPdfButton, 3, 14, 1, 1);
    }

    public ComboBox<TarifasDTO> getTarifasCombo() {
        return tarifasCombo;
    }

    public void setTarifasCombo(ComboBox<TarifasDTO> tarifasCombo) {
        this.tarifasCombo = tarifasCombo;
    }

    public ComboBox<FibrasDTO> getFibraCombo() {
        return fibraCombo;
    }

    public void setFibraCombo(ComboBox<FibrasDTO> fibraCombo) {
        this.fibraCombo = fibraCombo;
    }

    public ComboBox<StreamingDTO> getStreamingCombo() {
        return streamingCombo;
    }

    public void setStreamingCombo(ComboBox<StreamingDTO> streamingCombo) {
        this.streamingCombo = streamingCombo;
    }
    
    public ComboBox<DescuentosDTO> getDescuentoCombo() {
        return descuentoCombo;
    }

    public void setDescuentoCombo(ComboBox<DescuentosDTO> descuentoCombo) {
        this.descuentoCombo = descuentoCombo;
    }

    public ComboBox<CentralitasDTO> getCentralitaCombo() {
        return centralitaCombo;
    }

    public void setCentralitaCombo(ComboBox<CentralitasDTO> centralitaCombo) {
        this.centralitaCombo = centralitaCombo;
    }

    public ComboBox<PacksFutbolDTO> getPacksFutbolCombo() {
        return packsFutbolCombo;
    }

    public void setPacksFutbolCombo(ComboBox<PacksFutbolDTO> packsFutbolCombo) {
        this.packsFutbolCombo = packsFutbolCombo;
    }

    public ListView<HBox> getLineasAdicionalesView() {
        return lineasAdicionalesView;
    }

    public void setLineasAdicionalesView(ListView<HBox> lineasAdicionalesView) {
        this.lineasAdicionalesView = lineasAdicionalesView;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public void setSaveButton(Button saveButton) {
        this.saveButton = saveButton;
    }

    public Button getLoadButton() {
        return loadButton;
    }

    public void setLoadButton(Button loadButton) {
        this.loadButton = loadButton;
    }

    public TableView<PresupuestosController.ResumenItem> getResumenView() {
        return resumenView;
    }

    public void setResumenView(TableView<PresupuestosController.ResumenItem> resumenView) {
        this.resumenView = resumenView;
    }

    public String getTotaFieldText() {
        return totaField.getText();
    }

    public void setTotaField(TextField totaField) {
        this.totaField = totaField;
    }

    public Button getLimpiarButton() {
        return limpiarButton;
    }

    public void setLimpiarButton(Button limpiarButton) {
        this.limpiarButton = limpiarButton;
    }

    public Button getGenerarPdfButton() {
        return generarPdfButton;
    }

    public void setGenerarPdfButton(Button generarPdfButton) {
        this.generarPdfButton = generarPdfButton;
    }

    public VBox getTarifasVBox() {
        return tarifasVBox;
    }

    public void setTarifasVBox(VBox tarifasVBox) {
        this.tarifasVBox = tarifasVBox;
    }

    public VBox getLineasAdicionalesVBox() {
        return lineasAdicionalesVBox;
    }

    public void setLineasAdicionalesVBox(VBox lineasAdicionalesVBox) {
        this.lineasAdicionalesVBox = lineasAdicionalesVBox;
    }

    public VBox getProductosAdicionalesVBox() {
        return productosAdicionalesVBox;
    }

    public void setProductosAdicionalesVBox(VBox productosAdicionalesVBox) {
        this.productosAdicionalesVBox = productosAdicionalesVBox;
    }

    public Label getPresupuestoLabel() {
        return presupuestoLabel;
    }

    public Label getTarifaLabel() {
        return tarifaLabel;
    }

    public Label getFibraLabel() {
        return fibraLabel;
    }

    public Label getStreamingLabel() {
        return streamingLabel;
    }

    public Label getLineasAdicionalesLabel() {
        return lineasAdicionalesLabel;
    }

    public Label getDescuentoLabel() {
        return descuentoLabel;
    }

    public Label getCentralitaLabel() {
        return centralitaLabel;
    }

    public Label getPackFutbolLabel() {
        return packFutbolLabel;
    }

    public Label getTotalLabel() {
        return totalLabel;
    }

    public TextField getTotaField() {
        return totaField;
    }

    public Label getTarifasVBoxLabel() {
        return tarifasVBoxLabel;
    }

    public void setTarifasVBoxLabel(Label tarifasVBoxLabel) {
        this.tarifasVBoxLabel = tarifasVBoxLabel;
    }
    public Label getLineasAdicionalesVBoxLabel() {
        return lineasAdicionalesVBoxLabel;
    }
    public void setLineasAdicionalesVBoxLabel(Label lineasAdicionalesVBoxLabel) {
        this.lineasAdicionalesVBoxLabel = lineasAdicionalesVBoxLabel;
    }
    public Label getProductosAdicioanelesVBoxLabel() {
        return productosAdicioanelesVBoxLabel;
    }
    public void setProductosAdicioanelesVBoxLabel(Label productosAdicioanelesVBoxLabel) {
        this.productosAdicioanelesVBoxLabel = productosAdicioanelesVBoxLabel;
    }   

    public VBox getResumenVBox() {
        return resumenVBox;
    }

    public void setResumenVBox(VBox resumenVBox) {
        this.resumenVBox = resumenVBox;
    }

    public Label getResumenVBoxLabel() {
        return resumenVBoxLabel;
    }

    public void setResumenVBoxLabel(Label resumenVBoxLabel) {
        this.resumenVBoxLabel = resumenVBoxLabel;
    }
}

package com.budgetsgenerator.views;

import com.budgetsgenerator.dto.CentralitasDTO;
import com.budgetsgenerator.dto.DescuentosDTO;
import com.budgetsgenerator.dto.FibrasDTO;
import com.budgetsgenerator.dto.PacksFutbolDTO;
import com.budgetsgenerator.dto.StreamingDTO;
import com.budgetsgenerator.dto.TarifasDTO;
import com.budgetsgenerator.viewmodels.ResumentTableItem;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
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
    private VBox descuentosVBox = new VBox();

    private final Label descuentoLabel = new Label("Descuento:");
    private VBox resumenVBox = new VBox();
    private Label resumenVBoxLabel = new Label("RESUMEN");
    private HBox totalHBox = new HBox();
    private final Label totalLabel = new Label("TOTAL:");
    private TextField totalField = new TextField();
    private TextField presupuestoField = new TextField();
    private HBox buttonsHBox = new HBox();

    private ComboBox<TarifasDTO> tarifasCombo = new ComboBox<>();
    private ComboBox<FibrasDTO> fibraCombo = new ComboBox<>();
    private ComboBox<StreamingDTO> streamingCombo = new ComboBox<>();
    private ComboBox<DescuentosDTO> descuentoCombo = new ComboBox<>();
    private ComboBox<CentralitasDTO> centralitaCombo = new ComboBox<>();
    private ComboBox<PacksFutbolDTO> packsFutbolCombo = new ComboBox<>();
    private ListView<HBox> lineasAdicionalesView = new ListView<>();
    private TableView<ResumentTableItem> resumenView = new TableView<>();
    private Button saveButton = new Button("Guardar");
    private Button loadButton = new Button("Abrir");
    private Button actualizarButton = new Button("Actualizar");
    private Button eliminarButton = new Button("Eliminar");
    private Button nuevoButton = new Button("Nuevo");
    private Button generarPdfButton = new Button("Generar PDF");
    private final Label presupuestoLabel = new Label("Presupuestos");
    private final Label tarifaLabel = new Label("Tarifa:");
    private final Label fibraLabel = new Label("Fibra:");
    private final Label streamingLabel = new Label("Streaming:");
    private final Label lineasAdicionalesLabel = new Label("Líneas Adicionales:");
    private final Label centralitaLabel = new Label("Centralita:");
    private final Label packFutbolLabel = new Label("Pack Fútbol:");

    public PresupuestosView() {
        this.getStylesheets().add(getClass().getResource("/css/light-palette.css").toExternalForm());
        this.getStylesheets().add(getClass().getResource("/css/presupuestos.css").toExternalForm());
        this.getStyleClass().add("grid_pane");

        presupuestoLabel.setId("presupuestos_title");
        totalLabel.setId("total_label");
        
        this.getColumnConstraints().addAll(new ColumnConstraints(), new ColumnConstraints());
        this.getColumnConstraints().get(0).setPercentWidth(50);
        this.getColumnConstraints().get(1).setPercentWidth(50);
        
        this.add(buttonsHBox, 0, 0, 2, 1);
        this.add(tarifasVBox, 0, 1, 1, 2);
        this.add(productosAdicionalesVBox, 0, 3, 1, 1);
        this.add(lineasAdicionalesVBox, 0, 4, 1, 2);
        this.add(descuentosVBox, 1, 1, 1, 1);
        this.add(resumenVBox, 1, 2, 1, 3);
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

    public TableView<ResumentTableItem> getResumenView() {
        return resumenView;
    }

    public void setResumenView(TableView<ResumentTableItem> resumenView) {
        this.resumenView = resumenView;
    }

    public String getTotalFieldText() {
        return totalField.getText();
    }

    public void setTotalField(TextField totaField) {
        this.totalField = totaField;
    }

    public Button getNuevoButton() {
        return nuevoButton;
    }

    public void setNuevoButton(Button nuevoButton) {
        this.nuevoButton = nuevoButton;
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

    public TextField getTotalField() {
        return totalField;
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

    public HBox getTotalHBox() {
        return totalHBox;
    }

    public void setTotalHBox(HBox totalHBox) {
        this.totalHBox = totalHBox;
    }

    public Button getActualizarButton() {
        return actualizarButton;
    }

    public void setActualizarButton(Button actualizarButton) {
        this.actualizarButton = actualizarButton;
    }

    public Button getEliminarButton() {
        return eliminarButton;
    }

    public void setEliminarButton(Button eliminarButton) {
        this.eliminarButton = eliminarButton;
    }
    public TextField getPresupuestoField() {
        return presupuestoField;
    }

    public void setPresupuestoField(TextField presupuestoField) {
        this.presupuestoField = presupuestoField;
    }

    public HBox getButtonsHBox() {
        return buttonsHBox;
    }

    public void setButtonsHBox(HBox buttonsHBox) {
        this.buttonsHBox = buttonsHBox;
    }

    public VBox getDescuentosVBox() {
        return descuentosVBox;
    }

    public void setDescuentosVBox(VBox descuentosVBox) {
        this.descuentosVBox = descuentosVBox;
    }
}

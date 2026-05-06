package com.example.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.config.UIUtil;
import com.example.models.CatalogoComics;
import com.example.models.Comic;
import com.example.services.XmlService;
import com.example.views.ComicsView;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class ComicsController {
    private ComicsView view;
    private List<Comic> listaComics;
    private List<Comic> vistaComics;
    private int pageNum;
    private int totalPages;
    private CatalogoComics catalogo;

    public ComicsController(ComicsView view){
        this.view = view;
        load();
    }

    public void load() {
        catalogo = new CatalogoComics();
        cargarVista();
        pageNum = 1;
        totalPages = 1;
        view.getPageNumLabel().setText(Integer.toString(pageNum));
        view.getTotalPagesLabel().setText(Integer.toString(totalPages));

        Region space = new Region();
        view.getMenuHBox().getChildren().addAll(view.getSearchBarTextField(), view.getFilterComboBox(), view.getOrderComboBox(), view.getClearFiltersButton(), space, view.getNuevButton());
        view.getMenuHBox().setHgrow(space, Priority.ALWAYS);
        view.getMenuHBox().getStyleClass().add("menu-bar");
        view.getMenuHBox().setPrefWidth(Double.MAX_VALUE);
        view.getMenuHBox().setMargin(view.getSearchBarTextField(), new Insets(0, 10, 0, 0));
        view.getMenuHBox().setMargin(view.getFilterComboBox(), new Insets(0, 10, 0, 0));
        view.getMenuHBox().setMargin(view.getOrderComboBox(), new Insets(0, 10, 0, 0));

        List<String> campos = new ArrayList<>(Arrays.asList("Título", "Autor", "ISBN/UPC", "Editorial", "Año"));
        view.getFilterComboBox().getItems().addAll(campos);
        view.getFilterComboBox().getStyleClass().add("filter-combo");
        view.getOrderComboBox().getItems().addAll(campos);
        view.getOrderComboBox().getStyleClass().add("order-combo");
       
        view.getPreviousButton().getStyleClass().addAll("footer-button", "previous-button");
        view.getPreviousButton().setDisable(true);
        view.getNextButton().getStyleClass().addAll("footer-button", "next-button");
        view.getNextButton().setDisable(true);
        view.getFooter().getChildren().addAll(view.getPreviousButton(), view.getPageNumLabel(), new Label("/"), view.getTotalPagesLabel(), view.getNextButton());
        view.getFooter().getStyleClass().add("footer");
        view.getFooter().setMargin(view.getPreviousButton(), new Insets(0, 20, 0, 0));
        view.getFooter().setMargin(view.getNextButton(), new Insets(0, 0, 0, 20));
        generarTiles(vistaComics);
        
        view.getPreviousButton().setOnAction(eh -> {
            pageNum--;
            view.getPageNumLabel().setText(Integer.toString(pageNum));
            
            generarTiles(vistaComics);
        });
        
        view.getNextButton().setOnAction(eh -> {
            pageNum++;
            view.getPageNumLabel().setText(Integer.toString(pageNum));
            
            generarTiles(vistaComics);
        });

        view.getSearchBarTextField().setOnKeyReleased(eh -> {
            buscar();
        });

        view.getFilterComboBox().setOnAction(eh -> {
            buscar();
        });

        view.getClearFiltersButton().setOnAction(eh -> {
            view.getSearchBarTextField().setText("");
            view.getFilterComboBox().setValue("");
            view.getOrderComboBox().setValue("");
            
            cargarVista();
            generarTiles(vistaComics);
        });

        view.getOrderComboBox().setOnAction(eh -> {
            ordenar(vistaComics);
        });
        
        view.getNuevButton().setOnAction(eh -> {
            TextInputDialog dialog = new TextInputDialog();
            
            dialog.getDialogPane().getStylesheets().add(getClass().getResource(UIUtil.getPalette()).toExternalForm());
            dialog.getDialogPane().getStylesheets().add(getClass().getResource("/css/dialog.css").toExternalForm());
            dialog.getDialogPane().getStyleClass().add("dialog");
            dialog.setTitle("Agregar nuevo");
            dialog.setGraphic(null);
            dialog.setHeaderText("Detalles del Comic:");

            Button cancelButton = (Button) dialog.getDialogPane().lookupButton(ButtonType.CANCEL);
            cancelButton.setText("Cancelar");
            cancelButton.getStyleClass().add("cancel-btn");

            Button okButton = (Button) dialog.getDialogPane().lookupButton(ButtonType.OK);
            okButton.setText("Guardar");
            
            TextField node = (TextField) dialog.getDialogPane().lookup("TextField");
            node.setVisible(false);

            Label nuevoTituloLabel = new Label("Título:");
            TextField nuevoTituloTextField = new TextField();
            Label nuevoautorLabel = new Label("Autor:");
            TextField nuevoautorTextField = new TextField();
            Label nuevoIsbnLabel = new Label("ISBN/UPC:");
            TextField nuevoIsbnTextField = new TextField();
            Label nuevoEditorialLabel = new Label("Editorial:");
            TextField nuevoEditorialTextField = new TextField();
            Label nuevoAnioPublicacionLabel = new Label("Año de publicación:");
            TextField nuevoAnioPublicacionTextField = new TextField();
            Label nuevoImgLabel = new Label("URL de imágen:");
            TextField nuevoImgTextField = new TextField();
            VBox nueVBox = new VBox(nuevoTituloLabel, nuevoTituloTextField, nuevoautorLabel, nuevoautorTextField, nuevoIsbnLabel, nuevoIsbnTextField, nuevoEditorialLabel, nuevoEditorialTextField, nuevoAnioPublicacionLabel, nuevoAnioPublicacionTextField, nuevoImgLabel, nuevoImgTextField);
            nueVBox.getChildren().addAll();
            nueVBox.getChildren().forEach(e -> {
                nueVBox.setMargin(e, new Insets(0, 0, 10, 0));
            });
            
            dialog.getDialogPane().setContent(nueVBox);

            okButton.addEventFilter(ActionEvent.ACTION, e -> {
                boolean validado = true;
                validar(nuevoTituloTextField, validado);
                validar(nuevoautorTextField, validado);
                validar(nuevoIsbnTextField, validado);
                validar(nuevoEditorialTextField, validado);
                validar(nuevoAnioPublicacionTextField, validado);
                validar(nuevoImgTextField, validado);
                if(validado){
                    Comic nuevoComic = new Comic(nuevoTituloTextField.getText(), nuevoautorTextField.getText(), nuevoIsbnTextField.getText(), nuevoEditorialTextField.getText(), Integer.parseInt(nuevoAnioPublicacionTextField.getText()), nuevoImgTextField.getText());
                    listaComics.add(nuevoComic);
                    catalogo.saveList(listaComics);
                    XmlService.getInstance().guardarCatalogo(catalogo);
                    listaComics = XmlService.getInstance().leerCatalogo(catalogo).getList();
                    cargarVista();
                    generarTiles(vistaComics);
                    eh.consume();
                }
            });

            dialog.showAndWait();
        });
    }

    public void cargarVista() {
        listaComics = XmlService.getInstance().leerCatalogo(catalogo).getList() != null ? XmlService.getInstance().leerCatalogo(catalogo).getList() : new ArrayList<>();
        vistaComics = new ArrayList<>();
        if(listaComics.size() > 0) {
            for(Comic Comic : listaComics) {
                vistaComics.add(Comic);
            }
        }
    }

    public void generarTiles(List<Comic> Comics){
        view.getTilePane().getChildren().clear();
        if(Comics.size() > 0) {
            totalPages = (int) Math.ceil((double) vistaComics.size()/8);
            view.getTotalPagesLabel().setText(Integer.toString(totalPages));
            view.getPreviousButton().setDisable(pageNum == 1);
            view.getNextButton().setDisable(pageNum == totalPages);
            List<Comic> pagina = new ArrayList<>();
            int first = (pageNum -1)*8;
            int last = (pageNum*8)-1 < (vistaComics.size() - 1) ? (pageNum*8)-1  : vistaComics.size() - 1;
            for(int i = first; i <= last; i++) {
                pagina.add(vistaComics.get(i));
            }
            
            for(Comic comic : pagina) {
                HBox containerBox = new HBox();
                containerBox.getStyleClass().add("card-container");
                
                VBox card = new VBox();
                card.getStyleClass().add("card");
                
                ImageView img = new ImageView(new Image(comic.getImgURL()));
                img.setFitHeight(120);
                img.setFitWidth(90);
                img.setPreserveRatio(true);
                Label titulo = new Label(comic.getTitulo());
                titulo.getStyleClass().add("titulo");
                Label autor = new Label(comic.getAutor());
                Label detalles = new Label(comic.getIsbn() + "\nEditorial: " + comic.getEditorial() + "\nAño de publicación: " + comic.getAnioPublicacion());
                detalles.getStyleClass().add("detalles");
                Button modificarButton = new Button("Modificar");
                Button eliminarButton = new Button("Eliminar");
                eliminarButton.getStyleClass().add("eliminar-button");
                HBox buttonsBox = new HBox();
                Region space = new Region();
                HBox.setHgrow(space, Priority.ALWAYS);
                buttonsBox.getChildren().addAll(modificarButton, space, eliminarButton);
                buttonsBox.setAlignment(Pos.BOTTOM_CENTER);
                
                
                modificarButton.setOnAction(eh -> {
                    TextInputDialog dialog = new TextInputDialog();
                    
                    dialog.getDialogPane().getStylesheets().add(getClass().getResource(UIUtil.getPalette()).toExternalForm());
                    dialog.getDialogPane().getStylesheets().add(getClass().getResource("/css/dialog.css").toExternalForm());
                    dialog.getDialogPane().getStyleClass().add("dialog");
                    dialog.setTitle("Modificar");
                    dialog.setGraphic(null);
                    dialog.setHeaderText("Detalles del Comic:");
                    
                    Button cancelButton = (Button) dialog.getDialogPane().lookupButton(ButtonType.CANCEL);
                    cancelButton.setText("Cancelar");
                    cancelButton.getStyleClass().add("cancel-btn");
                    
                    Button okButton = (Button) dialog.getDialogPane().lookupButton(ButtonType.OK);
                    okButton.setText("Guardar");
                    
                    TextField node = (TextField) dialog.getDialogPane().lookup("TextField");
                    node.setVisible(false);
                    
                    Label nuevoTituloLabel = new Label("Título:");
                    TextField nuevoTituloTextField = new TextField(comic.getTitulo());
                    Label nuevoAutorLabel = new Label("Autor:");
                    TextField nuevoAutorTextField = new TextField(comic.getAutor());
                    Label nuevoIsbnLabel = new Label("ISBN:");
                    TextField nuevoIsbnTextField = new TextField(comic.getIsbn());
                    Label nuevoEditorialLabel = new Label("Editorial:");
                    TextField nuevoEditorialTextField = new TextField(comic.getEditorial());
                    Label nuevoAnioPublicacionLabel = new Label("Año de publicación:");
                    TextField nuevoAnioPublicacionTextField = new TextField(Integer.toString(comic.getAnioPublicacion()));
                    Label nuevoImgLabel = new Label("URL de imágen:");
                    TextField nuevoImgTextField = new TextField(comic.getImgURL());
                    VBox nueVBox = new VBox();
                    nueVBox.getChildren().addAll(nuevoTituloLabel, nuevoTituloTextField, nuevoAutorLabel, nuevoAutorTextField, nuevoIsbnLabel, nuevoIsbnTextField, nuevoEditorialLabel, nuevoEditorialTextField, nuevoAnioPublicacionLabel, nuevoAnioPublicacionTextField, nuevoImgLabel, nuevoImgTextField);
                    nueVBox.getChildren().forEach(e -> {
                        nueVBox.setMargin(e, new Insets(0, 0, 10, 0));
                    });

                    nuevoAnioPublicacionTextField.setOnKeyReleased(event -> {
                        String f = nuevoAnioPublicacionTextField.getText();
                        if(f.matches("\\d")){
                            nuevoAnioPublicacionTextField.setText(f);
                        }
                    });
                    
                    dialog.getDialogPane().setContent(nueVBox);
                    
                    okButton.addEventFilter(ActionEvent.ACTION, e -> {
                        boolean validado = true;
                        validar(nuevoTituloTextField, validado);
                        validar(nuevoAutorTextField, validado);
                        validar(nuevoIsbnTextField, validado);
                        validar(nuevoEditorialTextField, validado);
                        validar(nuevoAnioPublicacionTextField, validado);
                        validar(nuevoImgTextField, validado);
                        if(validado){
                            catalogo = new CatalogoComics();
                            Comic actualizado = new Comic(nuevoTituloTextField.getText(), nuevoAutorTextField.getText(), nuevoIsbnTextField.getText(), nuevoEditorialTextField.getText(), Integer.parseInt(nuevoAnioPublicacionTextField.getText()), nuevoImgTextField.getText());
                            listaComics.set(listaComics.indexOf(comic), actualizado);
                            catalogo.saveList(listaComics);
                            XmlService.getInstance().guardarCatalogo(catalogo);
                            listaComics = XmlService.getInstance().leerCatalogo(catalogo).getList();
                            cargarVista();
                            generarTiles(vistaComics);
                            eh.consume();
                        }
                    });
                    
                    dialog.showAndWait();
                });
                
                eliminarButton.setOnAction(eh -> {
                    listaComics.remove(listaComics.indexOf(comic));
                    catalogo.saveList(listaComics);
                    XmlService.getInstance().guardarCatalogo(catalogo);
                    listaComics = XmlService.getInstance().leerCatalogo(catalogo).getList();
                    cargarVista();
                    generarTiles(vistaComics);
                });
                
                card.getChildren().addAll(img, titulo, autor, detalles, buttonsBox);
                card.setAlignment(Pos.TOP_CENTER);
                containerBox.getChildren().add(card);
                containerBox.setHgrow(card, Priority.ALWAYS);
                view.getTilePane().getChildren().add(containerBox);
            }
            
            view.getTilePane().setTileAlignment(Pos.CENTER);
        }
    }

    public void validar(TextField field, boolean validado) {
        field.setPromptText("Debe rellenar el campo");
        field.getStyleClass().add("error");
        validado = false;
    }

    public void ordenar(List<Comic> comic) {
        String orden = view.getOrderComboBox().getValue();
        if(orden.equals("Título")) {
            comic.sort( (l1, l2) -> {
                return l1.getTitulo().compareTo(l2.getTitulo());
            });
        } else if(orden.equals("Autor")) {
            comic.sort((l1, l2) -> {
                return l1.getAutor().compareTo(l2.getAutor());
            });
        } else if(orden.equals("ISBN")) {
            comic.sort((l1, l2) -> {
                return l1.getIsbn().compareTo(l2.getIsbn());
            });
        } else if(orden.equals("Editorial")) {
            comic.sort((l1, l2) -> {
                return l1.getEditorial().compareTo(l2.getEditorial());
            });
        } else {
            comic.sort((l1, l2) -> {
                return l1.getAnioPublicacion() - l2.getAnioPublicacion();
            });
        }
        generarTiles(comic);
    }

    public void buscar() {
        List<Comic> filtrada = new ArrayList<>();
        String filtro = view.getFilterComboBox().getValue() != null ? view.getFilterComboBox().getValue() : "";
        String input = view.getSearchBarTextField().getText().toLowerCase();
        for(Comic comic : listaComics) {
            if(filtro.isEmpty() && (comic.getTitulo().toLowerCase().contains(input) || comic.getAutor().toLowerCase().contains(input) || comic.getIsbn().toLowerCase().contains(input) || comic.getEditorial().toLowerCase().contains(input) || Integer.toString(comic.getAnioPublicacion()).contains(input))) {
                filtrada.add(comic);
            } else if(filtro.equals("Título") && comic.getTitulo().toLowerCase().contains(input)) {
                filtrada.add(comic);
            } else if(filtro.equals("Autor") && comic.getAutor().toLowerCase().contains(input)) {
                filtrada.add(comic);
            } else if(filtro.equals("ISBN") && comic.getIsbn().toLowerCase().contains(input)) {
                filtrada.add(comic);
            } else if(filtro.equals("Editorial") && comic.getEditorial().toLowerCase().contains(input)) {
                filtrada.add(comic);
            }else if(filtro.equals("Año") && Integer.toString(comic.getAnioPublicacion()).contains(input)) {
                filtrada.add(comic);
            }
        }
        vistaComics = filtrada;
        generarTiles(filtrada);
    }
}

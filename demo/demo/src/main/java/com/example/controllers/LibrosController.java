package com.example.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.config.UIUtil;
import com.example.models.CatalogoLibros;
import com.example.models.Libro;
import com.example.services.XmlService;
import com.example.views.LibrosView;

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

public class LibrosController {
    private LibrosView view;
    private List<Libro> listaLibros;
    private List<Libro> vistaLibros;
    private int pageNum;
    private int totalPages;
    private CatalogoLibros catalogo;

    public LibrosController(LibrosView view){
        this.view = view;
        load();
    }
    
    public void load() {
        catalogo = new CatalogoLibros();
        listaLibros = XmlService.getInstance().leerCatalogo(catalogo).getList();
        cargarVista();
        if(vistaLibros != null) {
            pageNum = vistaLibros.size() > 0 ? 1 : 0;
            totalPages = vistaLibros.size() > 0 ? (int) Math.ceil((double) vistaLibros.size()/8) : 1; 
        }
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

        List<String> campos = new ArrayList<>(Arrays.asList("Título", "Autor", "ISBN", "Año"));
        view.getFilterComboBox().getItems().addAll(campos);
        view.getFilterComboBox().getStyleClass().add("filter-combo");
        view.getOrderComboBox().getItems().addAll(campos);
        view.getOrderComboBox().getStyleClass().add("order-combo");
       
        view.getPreviousButton().getStyleClass().addAll("footer-button", "previous-button");
        view.getNextButton().getStyleClass().addAll("footer-button", "next-button");
        view.getFooter().getChildren().addAll(view.getPreviousButton(), view.getPageNumLabel(), new Label("/"), view.getTotalPagesLabel(), view.getNextButton());
        view.getFooter().getStyleClass().add("footer");
        view.getFooter().setMargin(view.getPreviousButton(), new Insets(0, 20, 0, 0));
        view.getFooter().setMargin(view.getNextButton(), new Insets(0, 0, 0, 20));
        generarTiles(vistaLibros);
        
        view.getPreviousButton().setOnAction(eh -> {
            pageNum--;
            view.getPageNumLabel().setText(Integer.toString(pageNum));
            
            generarTiles(vistaLibros);
        });
        
        view.getNextButton().setOnAction(eh -> {
            pageNum++;
            view.getPageNumLabel().setText(Integer.toString(pageNum));
            
            generarTiles(vistaLibros);
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
            generarTiles(vistaLibros);
        });

        view.getOrderComboBox().setOnAction(eh -> {
            ordenar(vistaLibros);
        });
        
        view.getNuevButton().setOnAction(eh -> {
            TextInputDialog dialog = new TextInputDialog();
            
            dialog.getDialogPane().getStylesheets().add(getClass().getResource(UIUtil.getPalette()).toExternalForm());
            dialog.getDialogPane().getStylesheets().add(getClass().getResource("/css/dialog.css").toExternalForm());
            dialog.getDialogPane().getStyleClass().add("dialog");
            dialog.setTitle("Agregar nuevo");
            dialog.setGraphic(null);
            dialog.setHeaderText("Detalles del libro:");

            Button cancelButton = (Button) dialog.getDialogPane().lookupButton(ButtonType.CANCEL);
            cancelButton.setText("Cancelar");
            cancelButton.getStyleClass().add("cancel-btn");

            Button okButton = (Button) dialog.getDialogPane().lookupButton(ButtonType.OK);
            okButton.setText("Guardar");
            
            TextField node = (TextField) dialog.getDialogPane().lookup("TextField");
            node.setVisible(false);

            Label nuevoTituloLabel = new Label("Título:");
            TextField nuevoTituloTextField = new TextField();
            Label nuevoAutorLabel = new Label("Autor:");
            TextField nuevoAutorTextField = new TextField();
            Label nuevoIsbnLabel = new Label("ISBN:");
            TextField nuevoIsbnTextField = new TextField();
            Label nuevoAnioLabel = new Label("Año de publicación:");
            TextField nuevoAnioTextField = new TextField();
            Label nuevoImgLabel = new Label("URL de imágen:");
            TextField nuevoImgTextField = new TextField();
            VBox nueVBox = new VBox();
            nueVBox.getChildren().addAll(nuevoTituloLabel, nuevoTituloTextField, nuevoAutorLabel, nuevoAutorTextField, nuevoIsbnLabel, nuevoIsbnTextField, nuevoAnioLabel, nuevoAnioTextField, nuevoImgLabel, nuevoImgTextField);
            nueVBox.getChildren().forEach(e -> {
                nueVBox.setMargin(e, new Insets(0, 0, 10, 0));
            });
            
            dialog.getDialogPane().setContent(nueVBox);


            okButton.addEventFilter(ActionEvent.ACTION, e -> {
                Libro nuevoLibro = new Libro(nuevoTituloTextField.getText(), nuevoAutorTextField.getText(), nuevoIsbnTextField.getText(), Integer.parseInt(nuevoAnioTextField.getText()), nuevoImgTextField.getText());
                listaLibros.add(nuevoLibro);
                catalogo.saveList(listaLibros);
                // XmlService.getInstance().guardarCatalogo(catalogo);
                listaLibros = XmlService.getInstance().leerCatalogo(catalogo).getList();
                cargarVista();
                generarTiles(vistaLibros);
                eh.consume();
            });

            dialog.showAndWait();
        });
    }

    public void cargarVista() {
        if(listaLibros != null) {
            vistaLibros = new ArrayList<>();
            for(Libro libro : listaLibros) {
                vistaLibros.add(libro);
            }
        }
    }

    public void generarTiles(List<Libro> libros){
        if(libros != null) {

            view.getTilePane().getChildren().clear();
            
            List<Libro> pagina = new ArrayList<>();
            int first = (pageNum -1)*8;
            int last = (pageNum*8)-1 < (vistaLibros.size() - 1) ? (pageNum*8)-1  : vistaLibros.size() - 1;
            for(int i = first; i <= last; i++) {
                pagina.add(vistaLibros.get(i));
            }
            
            for(Libro libro : pagina) {
                HBox containerBox = new HBox();
                containerBox.getStyleClass().add("card-container");
                
                VBox card = new VBox();
                card.getStyleClass().add("card");
                
                ImageView img = new ImageView(new Image(libro.getImgURL()));
                Label titulo = new Label(libro.getTitulo());
                titulo.getStyleClass().add("titulo");
                Label autor = new Label(libro.getAutor());
                autor.getStyleClass().add("autor");
                Label detalles = new Label(libro.getIsbn() + "\nAño de publicación: " + libro.getAnioPublicacion());
                detalles.getStyleClass().add("detalles");
                Button modificarButton = new Button("Modificar");
                modificarButton.getStyleClass().add("modificar-button");
                Button eliminarButton = new Button("Eliminar");
                eliminarButton.getStyleClass().add("eliminar-button");
                Region empty = new Region();
                VBox buttonsBox = new VBox();
                buttonsBox.getStyleClass().add("buttons-box");
                buttonsBox.getChildren().addAll(modificarButton, eliminarButton);
                buttonsBox.setMargin(eliminarButton, new Insets(10, 0, 0, 0));
                
                modificarButton.setOnAction(eh -> {
                    TextInputDialog dialog = new TextInputDialog();
                    
                    dialog.getDialogPane().getStylesheets().add(getClass().getResource(UIUtil.getPalette()).toExternalForm());
                    dialog.getDialogPane().getStylesheets().add(getClass().getResource("/css/dialog.css").toExternalForm());
                    dialog.getDialogPane().getStyleClass().add("dialog");
                    dialog.setTitle("Modificar");
                    dialog.setGraphic(null);
                    dialog.setHeaderText("Detalles del libro:");
                    
                    Button cancelButton = (Button) dialog.getDialogPane().lookupButton(ButtonType.CANCEL);
                    cancelButton.setText("Cancelar");
                    cancelButton.getStyleClass().add("cancel-btn");
                    
                    Button okButton = (Button) dialog.getDialogPane().lookupButton(ButtonType.OK);
                    okButton.setText("Guardar");
                    
                    TextField node = (TextField) dialog.getDialogPane().lookup("TextField");
                    node.setVisible(false);
                    
                    Label nuevoTituloLabel = new Label("Título:");
                    TextField nuevoTituloTextField = new TextField(libro.getTitulo());
                    Label nuevoAutorLabel = new Label("Autor:");
                    TextField nuevoAutorTextField = new TextField(libro.getAutor());
                    Label nuevoIsbnLabel = new Label("ISBN:");
                    TextField nuevoIsbnTextField = new TextField(libro.getIsbn());
                    Label nuevoAnioLabel = new Label("Año de publicación:");
                    TextField nuevoAnioTextField = new TextField(Integer.toString(libro.getAnioPublicacion()));
                    Label nuevoImgLabel = new Label("URL de imágen:");
                    TextField nuevoImgTextField = new TextField(libro.getImgURL());
                    VBox nueVBox = new VBox();
                    nueVBox.getChildren().addAll(nuevoTituloLabel, nuevoTituloTextField, nuevoAutorLabel, nuevoAutorTextField, nuevoIsbnLabel, nuevoIsbnTextField, nuevoAnioLabel, nuevoAnioTextField, nuevoImgLabel, nuevoImgTextField);
                    nueVBox.getChildren().forEach(e -> {
                        nueVBox.setMargin(e, new Insets(0, 0, 10, 0));
                    });
                    
                    dialog.getDialogPane().setContent(nueVBox);
                    
                    
                    okButton.addEventFilter(ActionEvent.ACTION, e -> {
                        Libro actualizado = new Libro(nuevoTituloTextField.getText(), nuevoAutorTextField.getText(), nuevoIsbnTextField.getText(), Integer.parseInt(nuevoAnioTextField.getText()), nuevoImgTextField.getText());
                        listaLibros.set(listaLibros.indexOf(libro), actualizado);
                        catalogo.saveList(listaLibros);
                        // XmlService.getInstance().guardarCatalogo(catalogo);
                        listaLibros = XmlService.getInstance().leerCatalogo(catalogo).getList();
                        cargarVista();
                        generarTiles(vistaLibros);
                        eh.consume();
                    });
                    
                    dialog.showAndWait();
                });
                
                eliminarButton.setOnAction(eh -> {
                    listaLibros.remove(listaLibros.indexOf(libro));
                    catalogo.saveList(listaLibros);
                    // XmlService.getInstance().guardarCatalogo(catalogo);
                    listaLibros = XmlService.getInstance().leerCatalogo(catalogo).getList();
                    cargarVista();
                    generarTiles(vistaLibros);
                });
                
                card.getChildren().addAll(img, titulo, autor, detalles, buttonsBox);
                card.setAlignment(Pos.TOP_CENTER);
                containerBox.getChildren().add(card);
                containerBox.setHgrow(card, Priority.ALWAYS);
                view.getTilePane().getChildren().add(containerBox);
            }
        }
        
        view.getTilePane().setTileAlignment(Pos.CENTER);
    }


    public void ordenar(List<Libro> libros) {
        String orden = view.getOrderComboBox().getValue();
        if(orden.equals("Título")) {
            libros.sort( (l1, l2) -> {
                return l1.getTitulo().compareTo(l2.getTitulo());
            });
        } else if(orden.equals("Autor")) {
            libros.sort((l1, l2) -> {
                return l1.getAutor().compareTo(l2.getAutor());
            });
        } else if(orden.equals("ISBN")) {
            libros.sort((l1, l2) -> {
                return l1.getIsbn().compareTo(l2.getIsbn());
            });
        } else {
            libros.sort((l1, l2) -> {
                return l1.getAnioPublicacion() - l2.getAnioPublicacion();
            });
        }
        generarTiles(libros);
    }

    public void buscar() {
        List<Libro> filtrada = new ArrayList<>();
        String filtro = view.getFilterComboBox().getValue() != null ? view.getFilterComboBox().getValue() : "";
        String input = view.getSearchBarTextField().getText().toLowerCase();
        for(Libro libro : listaLibros) {
            if(filtro.isEmpty() && (libro.getTitulo().toLowerCase().contains(input) || libro.getAutor().toLowerCase().contains(input) || libro.getIsbn().toLowerCase().contains(input) || Integer.toString(libro.getAnioPublicacion()).contains(input))) {
                filtrada.add(libro);
            } else if(filtro.equals("Título") && libro.getTitulo().toLowerCase().contains(input)) {
                filtrada.add(libro);
            } else if(filtro.equals("Autor") && libro.getAutor().toLowerCase().contains(input)) {
                filtrada.add(libro);
            } else if(filtro.equals("ISBN") && libro.getIsbn().toLowerCase().contains(input)) {
                filtrada.add(libro);
            } else if(filtro.equals("Año") && Integer.toString(libro.getAnioPublicacion()).contains(input)) {
                filtrada.add(libro);
            }
        }
        vistaLibros = filtrada;
        generarTiles(filtrada);
    }
}

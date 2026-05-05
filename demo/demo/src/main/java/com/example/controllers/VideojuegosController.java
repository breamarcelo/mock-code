package com.example.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.config.UIUtil;
import com.example.models.CatalogoVideojuegos;
import com.example.models.Videojuego;
import com.example.services.XmlService;
import com.example.views.VideojuegosView;

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

public class VideojuegosController {
    private VideojuegosView view;
    private List<Videojuego> listaVideojuegos;
    private List<Videojuego> vistaVideojuegos;
    private int pageNum;
    private int totalPages;
    private CatalogoVideojuegos catalogo;

    public VideojuegosController(VideojuegosView view){
        this.view = view;
        load();
    }

    public void load() {
        catalogo = new CatalogoVideojuegos();
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

        List<String> campos = new ArrayList<>(Arrays.asList("Título", "Consola", "Editorial", "Género", "Año"));
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
        generarTiles(vistaVideojuegos);
        
        view.getPreviousButton().setOnAction(eh -> {
            pageNum--;
            view.getPageNumLabel().setText(Integer.toString(pageNum));
            
            generarTiles(vistaVideojuegos);
        });
        
        view.getNextButton().setOnAction(eh -> {
            pageNum++;
            view.getPageNumLabel().setText(Integer.toString(pageNum));
            
            generarTiles(vistaVideojuegos);
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
            generarTiles(vistaVideojuegos);
        });

        view.getOrderComboBox().setOnAction(eh -> {
            ordenar(vistaVideojuegos);
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
            Label nuevoConsolaLabel = new Label("Consola:");
            TextField nuevoConsolaTextField = new TextField();
            Label nuevoEditorialLabel = new Label("Editorial:");
            TextField nuevoEditorialTextField = new TextField();
            Label nuevoGeneroLabel = new Label("Género:");
            TextField nuevoGeneroTextField = new TextField();
            Label nuevoAnioPublicacionLabel = new Label("Año de publicación:");
            TextField nuevoAnioPublicacionTextField = new TextField();
            Label nuevoImgLabel = new Label("URL de imágen:");
            TextField nuevoImgTextField = new TextField();
            VBox nueVBox = new VBox(nuevoTituloLabel, nuevoTituloTextField, nuevoConsolaLabel, nuevoConsolaTextField, nuevoEditorialLabel, nuevoEditorialTextField, nuevoGeneroLabel, nuevoGeneroTextField, nuevoAnioPublicacionLabel, nuevoAnioPublicacionTextField, nuevoImgLabel, nuevoImgTextField);
            nueVBox.getChildren().addAll();
            nueVBox.getChildren().forEach(e -> {
                nueVBox.setMargin(e, new Insets(0, 0, 10, 0));
            });
            
            dialog.getDialogPane().setContent(nueVBox);

            okButton.addEventFilter(ActionEvent.ACTION, e -> {
                boolean validado = true;
                validar(nuevoTituloTextField, validado);
                validar(nuevoConsolaTextField, validado);
                validar(nuevoEditorialTextField, validado);
                validar(nuevoGeneroTextField, validado);
                validar(nuevoAnioPublicacionTextField, validado);
                validar(nuevoImgTextField, validado);
                if(validado){
                    Videojuego nuevoVideojuego = new Videojuego(nuevoTituloTextField.getText(), nuevoConsolaTextField.getText(), nuevoEditorialTextField.getText(), nuevoGeneroTextField.getText(), Integer.parseInt(nuevoAnioPublicacionTextField.getText()), nuevoImgTextField.getText());
                    listaVideojuegos.add(nuevoVideojuego);
                    catalogo.saveList(listaVideojuegos);
                    XmlService.getInstance().guardarCatalogo(catalogo);
                    listaVideojuegos = XmlService.getInstance().leerCatalogo(catalogo).getList();
                    cargarVista();
                    generarTiles(vistaVideojuegos);
                    eh.consume();
                }
            });

            dialog.showAndWait();
        });
    }

    public void cargarVista() {
        listaVideojuegos = XmlService.getInstance().leerCatalogo(catalogo).getList() != null ? XmlService.getInstance().leerCatalogo(catalogo).getList() : new ArrayList<>();
        vistaVideojuegos = new ArrayList<>();
        if(listaVideojuegos.size() > 0) {
            for(Videojuego Videojuego : listaVideojuegos) {
                vistaVideojuegos.add(Videojuego);
            }
        }
    }

    public void generarTiles(List<Videojuego> videojuegos){
        view.getTilePane().getChildren().clear();
        if(videojuegos.size() > 0) {
            totalPages = (int) Math.ceil((double) vistaVideojuegos.size()/8);
            view.getTotalPagesLabel().setText(Integer.toString(totalPages));
            view.getPreviousButton().setDisable(pageNum == 1);
            view.getNextButton().setDisable(pageNum == totalPages);
            List<Videojuego> pagina = new ArrayList<>();
            int first = (pageNum -1)*8;
            int last = (pageNum*8)-1 < (vistaVideojuegos.size() - 1) ? (pageNum*8)-1  : vistaVideojuegos.size() - 1;
            for(int i = first; i <= last; i++) {
                pagina.add(vistaVideojuegos.get(i));
            }
            
            for(Videojuego videojuego : pagina) {
                HBox containerBox = new HBox();
                containerBox.getStyleClass().add("card-container");
                
                VBox card = new VBox();
                card.getStyleClass().add("card");
                
                ImageView img = new ImageView(new Image(videojuego.getImgURL()));
                Label titulo = new Label(videojuego.getTitulo());
                titulo.getStyleClass().add("titulo");
                Label consola = new Label(videojuego.getConsola());
                Label detalles = new Label("Editorial: " + videojuego.getEditorial() + "\nGénero: " + videojuego.getGenero() + "\nAño de publicación: " + videojuego.getAnioPublicacion());
                detalles.getStyleClass().add("detalles");
                Button modificarButton = new Button("Modificar");
                Button eliminarButton = new Button("Eliminar");
                eliminarButton.getStyleClass().add("eliminar-button");
                HBox buttonsBox = new HBox();
                Region space = new Region();
                HBox.setHgrow(space, Priority.ALWAYS);
                buttonsBox.getChildren().addAll(modificarButton, space, eliminarButton);
                
                
                modificarButton.setOnAction(eh -> {
                    TextInputDialog dialog = new TextInputDialog();
                    
                    dialog.getDialogPane().getStylesheets().add(getClass().getResource(UIUtil.getPalette()).toExternalForm());
                    dialog.getDialogPane().getStylesheets().add(getClass().getResource("/css/dialog.css").toExternalForm());
                    dialog.getDialogPane().getStyleClass().add("dialog");
                    dialog.setTitle("Modificar");
                    dialog.setGraphic(null);
                    dialog.setHeaderText("Detalles del videojuego:");
                    
                    Button cancelButton = (Button) dialog.getDialogPane().lookupButton(ButtonType.CANCEL);
                    cancelButton.setText("Cancelar");
                    cancelButton.getStyleClass().add("cancel-btn");
                    
                    Button okButton = (Button) dialog.getDialogPane().lookupButton(ButtonType.OK);
                    okButton.setText("Guardar");
                    
                    TextField node = (TextField) dialog.getDialogPane().lookup("TextField");
                    node.setVisible(false);
                    
                    Label nuevoTituloLabel = new Label("Título:");
                    TextField nuevoTituloTextField = new TextField(videojuego.getTitulo());
                    Label nuevoConsolaLabel = new Label("Consola:");
                    TextField nuevoConsolaTextField = new TextField(videojuego.getConsola());
                    Label nuevoEditorialLabel = new Label("Editorial:");
                    TextField nuevoEditorialTextField = new TextField(videojuego.getEditorial());
                    Label nuevoGeneroLabel = new Label("Género:");
                    TextField nuevoGeneroTextField = new TextField(videojuego.getGenero());
                    Label nuevoAnioPublicacionLabel = new Label("Año de publicación:");
                    TextField nuevoAnioPublicacionTextField = new TextField(Integer.toString(videojuego.getAnioPublicacion()));
                    Label nuevoImgLabel = new Label("URL de imágen:");
                    TextField nuevoImgTextField = new TextField(videojuego.getImgURL());
                    VBox nueVBox = new VBox();
                    nueVBox.getChildren().addAll(nuevoTituloLabel, nuevoTituloTextField, nuevoConsolaLabel, nuevoConsolaTextField, nuevoEditorialLabel, nuevoEditorialTextField, nuevoGeneroLabel, nuevoGeneroTextField, nuevoAnioPublicacionLabel, nuevoAnioPublicacionTextField, nuevoImgLabel, nuevoImgTextField);
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
                        validar(nuevoConsolaTextField, validado);
                        validar(nuevoEditorialTextField, validado);
                        validar(nuevoGeneroTextField, validado);
                        validar(nuevoAnioPublicacionTextField, validado);
                        validar(nuevoImgTextField, validado);
                        if(validado){
                            catalogo = new CatalogoVideojuegos();
                            Videojuego actualizado = new Videojuego(nuevoTituloTextField.getText(), nuevoConsolaTextField.getText(), nuevoEditorialTextField.getText(), nuevoGeneroTextField.getText(), Integer.parseInt(nuevoAnioPublicacionTextField.getText()), nuevoImgTextField.getText());
                            listaVideojuegos.set(listaVideojuegos.indexOf(videojuego), actualizado);
                            catalogo.saveList(listaVideojuegos);
                            XmlService.getInstance().guardarCatalogo(catalogo);
                            listaVideojuegos = XmlService.getInstance().leerCatalogo(catalogo).getList();
                            cargarVista();
                            generarTiles(vistaVideojuegos);
                            eh.consume();
                        }
                    });
                    
                    dialog.showAndWait();
                });
                
                eliminarButton.setOnAction(eh -> {
                    listaVideojuegos.remove(listaVideojuegos.indexOf(videojuego));
                    catalogo.saveList(listaVideojuegos);
                    XmlService.getInstance().guardarCatalogo(catalogo);
                    listaVideojuegos = XmlService.getInstance().leerCatalogo(catalogo).getList();
                    cargarVista();
                    generarTiles(vistaVideojuegos);
                });
                
                card.getChildren().addAll(img, titulo, consola, detalles, buttonsBox);
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

    public void ordenar(List<Videojuego> videojuegos) {
        String orden = view.getOrderComboBox().getValue();
        if(orden.equals("Título")) {
            videojuegos.sort( (l1, l2) -> {
                return l1.getTitulo().compareTo(l2.getTitulo());
            });
        } else if(orden.equals("Consola")) {
            videojuegos.sort((l1, l2) -> {
                return l1.getConsola().compareTo(l2.getConsola());
            });
        } else if(orden.equals("Editorial")) {
            videojuegos.sort((l1, l2) -> {
                return l1.getEditorial().compareTo(l2.getEditorial());
            });
        } else if(orden.equals("Género")) {
            videojuegos.sort((l1, l2) -> {
                return l1.getGenero().compareTo(l2.getGenero());
            });
        } else {
            videojuegos.sort((l1, l2) -> {
                return l1.getAnioPublicacion() - l2.getAnioPublicacion();
            });
        }
        generarTiles(videojuegos);
    }

    public void buscar() {
        List<Videojuego> filtrada = new ArrayList<>();
        String filtro = view.getFilterComboBox().getValue() != null ? view.getFilterComboBox().getValue() : "";
        String input = view.getSearchBarTextField().getText().toLowerCase();
        for(Videojuego videojuego : listaVideojuegos) {
            if(filtro.isEmpty() && (videojuego.getTitulo().toLowerCase().contains(input) || videojuego.getConsola().toLowerCase().contains(input) || videojuego.getGenero().toLowerCase().contains(input) || videojuego.getEditorial().toLowerCase().contains(input) || Integer.toString(videojuego.getAnioPublicacion()).contains(input))) {
                filtrada.add(videojuego);
            } else if(filtro.equals("Título") && videojuego.getTitulo().toLowerCase().contains(input)) {
                filtrada.add(videojuego);
            } else if(filtro.equals("Consola") && videojuego.getConsola().toLowerCase().contains(input)) {
                filtrada.add(videojuego);
            }  else if(filtro.equals("Genero") && videojuego.getGenero().toLowerCase().contains(input)) {
                filtrada.add(videojuego);
            } else if(filtro.equals("Editorial") && videojuego.getEditorial().toLowerCase().contains(input)) {
                filtrada.add(videojuego);
            } else if(filtro.equals("Año") && Integer.toString(videojuego.getAnioPublicacion()).contains(input)) {
                filtrada.add(videojuego);
            }
        }
        vistaVideojuegos = filtrada;
        generarTiles(filtrada);
    }
}

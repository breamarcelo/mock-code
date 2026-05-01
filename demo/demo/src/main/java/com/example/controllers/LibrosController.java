package com.example.controllers;

import java.util.Collections;
import java.util.List;

import com.example.models.Catalogo;
import com.example.models.Libro;
import com.example.services.XmlService;
import com.example.views.LibrosView;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class LibrosController {
    private LibrosView view;
    private Catalogo catalogo;
    private List<Libro> libros;

    public LibrosController(LibrosView view){
        this.view = view;
        load();
    }

    public void load() {
        Region space = new Region();
        view.getMenuHBox().getChildren().addAll(view.getSearchBarTextField(), view.getFilterComboBox(), space, view.getNuevButton());
        view.getMenuHBox().setHgrow(space, Priority.ALWAYS);
        view.getMenuHBox().getStyleClass().add("menu-bar");
        view.getMenuHBox().setPrefWidth(Double.MAX_VALUE);
        view.getMenuHBox().setMargin(view.getSearchBarTextField(), new Insets(0, 20, 0, 0));
        
        // Catalogo catalogo = new Catalogo();
        // List<Libro> libros = new ArrayList<>(Arrays.asList(
        //     new Libro("La Divina Comedia", "Dante Alighieri", "ISBN-13: 9781518711374", 2015, "https://m.media-amazon.com/images/I/512ts006FKL._SL160_.jpg"),
        //     new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", "ISBN-13: 9788420412146", 2016, "https://m.media-amazon.com/images/I/41VgBuQ-omL._SL160_.jpg"),
        //     new Libro("Bodas de Sangre", "Federico Garcia Lorca", "ISBN-13: 9781545305881", 2017, "https://m.media-amazon.com/images/I/41YY5EMX-2L._SL160_.jpg")
        // ));
        // catalogo.setLibros(libros);
        // XmlService.getInstance().guardarCatalogo(catalogo);
        libros = XmlService.getInstance().leerCatalogo().getLibros();
        Collections.sort(libros, (l1, l2) -> {
            return l1.getTitulo().compareTo(l2.getTitulo());
        });
        for(Libro libro : libros) {
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
            
            
            card.getChildren().addAll(img, titulo, autor, detalles, buttonsBox);
            card.setAlignment(Pos.TOP_CENTER);
            containerBox.getChildren().add(card);
            containerBox.setHgrow(card, Priority.ALWAYS);
            view.getTilePane().getChildren().add(containerBox);
        }
        
        view.getTilePane().setTileAlignment(Pos.CENTER);
        view.getFooter().getChildren().add(view.getFooterButton());

    }
}

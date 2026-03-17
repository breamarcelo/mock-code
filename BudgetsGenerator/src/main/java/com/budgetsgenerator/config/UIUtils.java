package com.budgetsgenerator.config;

import java.util.List;
import java.util.function.Function;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;


public class UIUtils {
    public static <T> StringConverter<T> createConverter(Function<T, String> nameExtractor) {
        return new StringConverter<T>() {
            @Override
            public String toString(T object) {
                return (object == null) ? "" : nameExtractor.apply(object);
            }
            @Override
            public T fromString(String string) {
                return null; 
            }
        };
    }

    public static void populateVBox(VBox box, List<Control> controls) {
        box.getChildren().addAll(controls);
        controls.get(0).getStyleClass().add("VBox-Label");
        for(Control c : controls) {
            if(c instanceof ComboBox) {
                box.setMargin(c, new Insets(5,0,10,0));
                c.setPrefWidth(Double.MAX_VALUE);
            }
        }
        box.setPrefWidth(800);
    }
}

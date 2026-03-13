package com.budgetsgenerator.config;

import java.util.function.Function;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
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

    public static <T> Callback<ListView<T>, ListCell<T>> simpleCellFactory(Function<T, String> extractor) {
        return lv -> new ListCell<>() {
            @Override
            protected void updateItem(T item, boolean empty) {
                super.updateItem(item, empty);
                setText((empty || item == null) ? null : extractor.apply(item));
            }
        };
    }
}

package com.budgetsgenerator.config;

import java.util.function.Function;

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
}

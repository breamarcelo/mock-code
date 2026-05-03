package com.example.models;

import java.util.List;

public interface Catalogo<T> {
   String getCatalogoXml();
   List<T> getList();
   void saveList(List<T> lista);
}

package com.budgetsgenerator.repository;

import java.util.List;

public interface GenericDAO<T, ID> {
    void save(T entity);
    T findBy(ID id);
    List<T> findall();
    void update(T entity);
    void delete(T entity);
}

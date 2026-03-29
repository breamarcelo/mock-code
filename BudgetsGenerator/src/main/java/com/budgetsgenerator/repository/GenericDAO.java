package com.budgetsgenerator.repository;

import java.util.List;

public interface GenericDAO<T, ID, EM> {
    T save(T entity, EM em);
    T findBy(ID id, EM em);
    List<T> findall(EM em);
    void update(T entity, EM em);
    void delete(T entity, EM em);
}

package com.budgetsgenerator.mappers;

import java.util.List;

import com.budgetsgenerator.repository.GenericDAO;

public interface EntityMapper<E, D> {
    D toDTO(E entity);
    E toEntity(D dto);
    List<E> toEntityList(GenericDAO dao);
    List<D> toDTOList();
}

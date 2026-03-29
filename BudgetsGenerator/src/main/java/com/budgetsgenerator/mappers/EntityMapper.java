package com.budgetsgenerator.mappers;

import java.util.List;

import com.budgetsgenerator.repository.GenericDAO;

public interface EntityMapper<E, D, EM> {
    D toDTO(E entity, EM em);
    E toEntity(D dto);
    List<E> toEntityList(GenericDAO dao, EM em);
    List<D> toDTOList(List<E> entities, EM em);
}

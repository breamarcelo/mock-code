package com.budgetsgenerator.mappers;

import java.util.List;

public interface EntityMapper<E, D, EM> {
    D toDTO(E entity, EM em);
    E toEntity(D dto);
    List<E> toEntityList(List<D> dtoList, EM em);
    List<D> toDTOList(List<E> entities, EM em);
}

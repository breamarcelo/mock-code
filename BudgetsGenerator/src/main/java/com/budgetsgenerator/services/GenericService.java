package com.budgetsgenerator.services;

import java.util.List;

public interface GenericService<DTO, M, E, DAO, ID> {
    List<DTO> getAll();
    DTO findById(ID id);
    void save(DTO dto);
    void update(DTO dto);
    void delete(DTO dto);
}

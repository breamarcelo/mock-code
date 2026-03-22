package com.budgetsgenerator.services;

import java.util.List;

import com.budgetsgenerator.mappers.EntityMapper;
import com.budgetsgenerator.repository.GenericDAO;

public abstract class GenericServiceImpl<DTO, M, E, DAO, ID> implements GenericService<DTO, M, E, DAO, ID>{
    private GenericDAO<E, ID> dao;
    private EntityMapper<E, DTO> mapper;
    
    public GenericServiceImpl() {
    }

    public GenericServiceImpl(GenericDAO<E, ID> dao, EntityMapper<E, DTO> mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    public List<DTO> getAll() {
        return mapper.toDTOList(dao.findall());
    }

    @Override
    public DTO findById(ID id) {
        return mapper.toDTO(dao.findBy(id));
    }

    @Override
    public DTO save(DTO dto) {
        E entity = mapper.toEntity(dto);
        entity = dao.save(entity);
        return mapper.toDTO(entity);
    }

    @Override
    public void delete(DTO dto) {
        dao.delete(mapper.toEntity(dto));
        
    }

    @Override
    public void update(DTO dto) {
        dao.update(mapper.toEntity(dto));
    }
}

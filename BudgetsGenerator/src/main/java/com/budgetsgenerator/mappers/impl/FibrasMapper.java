package com.budgetsgenerator.mappers.impl;

import java.util.ArrayList;
import java.util.List;

import com.budgetsgenerator.dto.FibrasDTO;
import com.budgetsgenerator.mappers.EntityMapper;
import com.budgetsgenerator.models.FibrasEntity;
import com.budgetsgenerator.repository.GenericDAO;
import com.budgetsgenerator.repository.impl.FibrasDAO;

public class FibrasMapper implements EntityMapper<FibrasEntity, FibrasDTO>{
    private static final FibrasMapper instance = new FibrasMapper();
    private static final FibrasDAO fibrasDAO = new FibrasDAO(FibrasEntity.class);

    private FibrasMapper() {
    }

    public static FibrasMapper getInstance(){
        return instance;
    }

    @Override
    public FibrasDTO toDTO(FibrasEntity entity) {
        FibrasDTO dto = new FibrasDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setSobrecargo(entity.getSobrecargo());
        return dto;
    }
    
    @Override
    public FibrasEntity toEntity(FibrasDTO dto) {
        FibrasEntity entity = new FibrasEntity();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setSobrecargo(dto.getSobrecargo());
        return entity;
    }

    @Override
    public List<FibrasEntity> toEntityList(GenericDAO dao) {
        return dao.findall();
    }

    @Override
    public List<FibrasDTO> toDTOList(List<FibrasEntity> entities) {
        if(entities == null) {
            entities = fibrasDAO.findall();
        }
        List<FibrasDTO> dtos = new ArrayList<>();
        for(FibrasEntity entity : entities){
            dtos.add(toDTO(entity));
        }
        return dtos;
    }
    
}

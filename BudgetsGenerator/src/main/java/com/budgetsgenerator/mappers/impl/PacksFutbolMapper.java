package com.budgetsgenerator.mappers.impl;

import java.util.ArrayList;
import java.util.List;

import com.budgetsgenerator.dto.PacksFutbolDTO;
import com.budgetsgenerator.mappers.EntityMapper;
import com.budgetsgenerator.models.PacksFutbolEntity;
import com.budgetsgenerator.repository.GenericDAO;
import com.budgetsgenerator.repository.impl.PacksFutbolDAO;

public class PacksFutbolMapper implements EntityMapper<PacksFutbolEntity, PacksFutbolDTO>{
    private static final PacksFutbolMapper instance = new PacksFutbolMapper();
    private static final PacksFutbolDAO packsFutbolDAO = new PacksFutbolDAO(PacksFutbolEntity.class);
    
    private PacksFutbolMapper() {
    }

    public static PacksFutbolMapper getInstance() {
        return instance;
    }

    @Override
    public PacksFutbolDTO toDTO(PacksFutbolEntity entity) {
        PacksFutbolDTO dto = new PacksFutbolDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setPrecio(entity.getPrecio());
        return dto;
    }

    @Override
    public PacksFutbolEntity toEntity(PacksFutbolDTO dto) {
        PacksFutbolEntity entity = new PacksFutbolEntity();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setPrecio(dto.getPrecio());
        return entity;
    }
    
    @Override
    public List<PacksFutbolEntity> toEntityList(GenericDAO dao) {
        return dao.findall();
    }

    @Override
    public List<PacksFutbolDTO> toDTOList(List<PacksFutbolEntity> entities) {
        if(entities == null) {
            entities = packsFutbolDAO.findall();
        }
        List<PacksFutbolDTO> dtos = new ArrayList<>();
        for(PacksFutbolEntity entity : entities) {
            dtos.add(toDTO(entity));
        }
        return dtos;
    }
}

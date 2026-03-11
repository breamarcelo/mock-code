package com.budgetsgenerator.mappers;

import java.util.ArrayList;
import java.util.List;

import com.budgetsgenerator.dto.PacksFutbolDTO;
import com.budgetsgenerator.models.PacksFutbolEntity;
import com.budgetsgenerator.repository.GenericDAO;
import com.budgetsgenerator.repository.impl.PackFutbolDAO;

public class PacksFutbolMapper implements EntityMapper<PacksFutbolEntity, PacksFutbolDTO>{
    private static final PacksFutbolMapper instance = new PacksFutbolMapper();
    private static final PackFutbolDAO packsFutbolDAO = new PackFutbolDAO(PacksFutbolEntity.class);
    
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
    public List<PacksFutbolDTO> toDTOList() {
        List<PacksFutbolDTO> dtos = new ArrayList<>();
        for(PacksFutbolEntity entity : toEntityList(packsFutbolDAO)) {
            dtos.add(toDTO(entity));
        }
        return dtos;
    }
}

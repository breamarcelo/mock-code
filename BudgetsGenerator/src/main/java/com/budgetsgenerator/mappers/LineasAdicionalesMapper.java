package com.budgetsgenerator.mappers;

import java.util.ArrayList;
import java.util.List;

import com.budgetsgenerator.dto.LineasAdicionalesDTO;
import com.budgetsgenerator.models.LineasAdicionalesEntity;
import com.budgetsgenerator.repository.GenericDAO;
import com.budgetsgenerator.repository.impl.LineasAdicionalesDAO;

public class LineasAdicionalesMapper implements EntityMapper<LineasAdicionalesEntity, LineasAdicionalesDTO>{
    public static final LineasAdicionalesMapper instance = new LineasAdicionalesMapper();
    public static final LineasAdicionalesDAO lineasAdicionalesDAO = new LineasAdicionalesDAO(LineasAdicionalesEntity.class);
    
    private LineasAdicionalesMapper() {
    }

    public static LineasAdicionalesMapper getInstance() {
        return instance;
    }

    @Override
    public LineasAdicionalesDTO toDTO(LineasAdicionalesEntity entity) {
        LineasAdicionalesDTO dto = new LineasAdicionalesDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setTipo(entity.getTipo());
        dto.setNumLineas(entity.getNumLineas());
        dto.setLlamadas(entity.getLlamadas());
        dto.setGb(entity.getGb());
        dto.setFibra(entity.getFibra());
        dto.setPrecio(entity.getPrecio());
        return dto;
    }

    @Override
    public LineasAdicionalesEntity toEntity(LineasAdicionalesDTO dto) {
        LineasAdicionalesEntity entity = new LineasAdicionalesEntity();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setTipo(dto.getTipo());
        entity.setNumLineas(dto.getNumLineas());
        entity.setLlamadas(dto.getLlamadas());
        entity.setGb(dto.getGb());
        entity.setFibra(dto.getFibra());
        entity.setPrecio(dto.getPrecio());
        return entity;
    }

    @Override
    public List<LineasAdicionalesEntity> toEntityList(GenericDAO dao) {
        return dao.findall();
    }

    @Override
    public List<LineasAdicionalesDTO> toDTOList() {
        List<LineasAdicionalesDTO> dtos = new ArrayList<>();
        for(LineasAdicionalesEntity entity : toEntityList(lineasAdicionalesDAO)) {
            dtos.add(toDTO(entity));
        }
        return dtos;
    }
}

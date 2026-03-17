package com.budgetsgenerator.mappers.impl;

import java.util.ArrayList;
import java.util.List;

import com.budgetsgenerator.dto.CentralitasDTO;
import com.budgetsgenerator.mappers.EntityMapper;
import com.budgetsgenerator.models.CentralitasEntity;
import com.budgetsgenerator.repository.GenericDAO;
import com.budgetsgenerator.repository.impl.CentralitasDAO;

public class CentralitasMapper implements EntityMapper<CentralitasEntity, CentralitasDTO>{
    private static final CentralitasMapper instance = new CentralitasMapper();
    private static final CentralitasDAO centralitasDAO = new CentralitasDAO(CentralitasEntity.class);

    private CentralitasMapper(){
    }

    public static CentralitasMapper getInstance(){
        return instance;
    }
    
    @Override
    public CentralitasDTO toDTO(CentralitasEntity entity) {
        CentralitasDTO dto = new CentralitasDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setPrecio(entity.getPrecio());
        return dto;
    }

    @Override
    public CentralitasEntity toEntity(CentralitasDTO dto) {
        CentralitasEntity entity = new CentralitasEntity();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setPrecio(dto.getPrecio());
        return entity;
    }

    @Override
    public List<CentralitasEntity> toEntityList(GenericDAO dao) {
        return dao.findall();
    }

    @Override
    public List<CentralitasDTO> toDTOList(List<CentralitasEntity> entities) {
        if(entities == null) {
            entities = centralitasDAO.findall();
        }
        List<CentralitasDTO> dtos = new ArrayList<>();
        for(CentralitasEntity entity : entities) {
            dtos.add(toDTO(entity));
        }
        return dtos;
    }
}

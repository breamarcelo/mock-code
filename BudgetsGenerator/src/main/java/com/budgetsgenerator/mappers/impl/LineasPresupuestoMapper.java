package com.budgetsgenerator.mappers.impl;

import java.util.ArrayList;
import java.util.List;

import com.budgetsgenerator.dto.LineasPresupuestoDTO;
import com.budgetsgenerator.mappers.EntityMapper;
import com.budgetsgenerator.models.LineasPresupuestoEntity;
import com.budgetsgenerator.models.PresupuestosEntity;
import com.budgetsgenerator.repository.GenericDAO;
import com.budgetsgenerator.repository.impl.PresupuestosDAO;

public class LineasPresupuestoMapper implements EntityMapper<LineasPresupuestoEntity, LineasPresupuestoDTO> {
    private static final LineasPresupuestoMapper instance = new LineasPresupuestoMapper();
    private static final PresupuestosDAO presupuestosDAO = new PresupuestosDAO(PresupuestosEntity.class);

    private LineasPresupuestoMapper() {
    }

    public static LineasPresupuestoMapper getInstance(){
        return instance;
    }

    @Override
    public LineasPresupuestoDTO toDTO(LineasPresupuestoEntity entity) {
        if(entity == null) {
            return null;
        }
        LineasPresupuestoDTO dto = new LineasPresupuestoDTO();
        dto.setId(entity.getId());
        dto.setCantidad(entity.getCantidad());
        dto.setLineasAdicional(LineasAdicionalesMapper.getInstance().toDTO(entity.getLineaAdicional()));
        return dto;
    }

    @Override
    public LineasPresupuestoEntity toEntity(LineasPresupuestoDTO dto) {
        if(dto == null) {
            return null;
        } 
        LineasPresupuestoEntity entity = new LineasPresupuestoEntity();
        entity.setId(dto.getId());
        entity.setCantidad(dto.getCantidad());
        entity.setPresupuesto(presupuestosDAO.findBy(dto.getPresupuesto().getId()));
        entity.setLineaAdicional(LineasAdicionalesMapper.getInstance().toEntity(dto.getLineasAdicional()));
        return entity;
    }
    
    @Override
    public List<LineasPresupuestoEntity> toEntityList(GenericDAO dao) {
        return dao.findall();
    }

    public List<LineasPresupuestoEntity> toEntityListFromDTOs(List<LineasPresupuestoDTO> dtos) {
        List<LineasPresupuestoEntity> entities = new ArrayList<>();
        for(LineasPresupuestoDTO dto : dtos) {
            entities.add(toEntity(dto));
        }
        return entities;
    }
    
    @Override
    public List<LineasPresupuestoDTO> toDTOList(List<LineasPresupuestoEntity> entities) {
        if(entities == null) {
            entities = new ArrayList<>();
        }
        List<LineasPresupuestoDTO> dtos = new ArrayList<>();
        for(LineasPresupuestoEntity entity : entities) {
            dtos.add(toDTO(entity));
        }
        return dtos;
    }
}

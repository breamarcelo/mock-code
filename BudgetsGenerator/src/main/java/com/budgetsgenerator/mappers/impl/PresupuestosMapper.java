package com.budgetsgenerator.mappers.impl;

import java.util.ArrayList;
import java.util.List;

import com.budgetsgenerator.dto.PresupuestosDTO;
import com.budgetsgenerator.mappers.EntityMapper;
import com.budgetsgenerator.models.PresupuestosEntity;
import com.budgetsgenerator.repository.GenericDAO;
import com.budgetsgenerator.repository.impl.PresupuestosDAO;

public class PresupuestosMapper implements EntityMapper<PresupuestosEntity, PresupuestosDTO>{
    private static final PresupuestosMapper instance = new PresupuestosMapper();
    private static final PresupuestosDAO presupuestosDAO = new PresupuestosDAO(PresupuestosEntity.class);
    
    private PresupuestosMapper() {
    }

    public static PresupuestosMapper getInstance(){
        return instance;
    }

    @Override
    public PresupuestosDTO toDTO(PresupuestosEntity entity) {
        if(entity == null) {
            return null;
        }
        PresupuestosDTO dto = new PresupuestosDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setTarifa(TarifasMapper.getInstance().toDTO(entity.getTarifa()));
        dto.setFibra(FibrasMapper.getInstance().toDTO(entity.getFibra()));
        dto.setStreaming(StreamingMapper.getInstance().toDTO(entity.getStreaming()));
        dto.setCentralita(CentralitasMapper.getInstance().toDTO(entity.getCentralita()));
        dto.setPackFutbol(PacksFutbolMapper.getInstance().toDTO(entity.getPackFutbol()));
        dto.setDescuento(DescuentosMapper.getInstance().toDTO(entity.getDescuento()));
        dto.setLineasAdicionales(LineasPresupuestoMapper.getInstance().toDTOList(presupuestosDAO.findByIdWithLineasPresupuesto(entity.getId()).getLineasPresupuesto()));
        return dto;
    }

    @Override
    public PresupuestosEntity toEntity(PresupuestosDTO dto) {
        if(dto == null) {
            return null;
        } 
        PresupuestosEntity entity = new PresupuestosEntity();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setTarifa(TarifasMapper.getInstance().toEntity(dto.getTarifa()));
        entity.setFibra(FibrasMapper.getInstance().toEntity(dto.getFibra()));
        entity.setStreaming(StreamingMapper.getInstance().toEntity(dto.getStreaming()));
        entity.setCentralita(CentralitasMapper.getInstance().toEntity(dto.getCentralita()));
        entity.setPackFutbol(PacksFutbolMapper.getInstance().toEntity(dto.getPackFutbol()));
        entity.setDescuento(DescuentosMapper.getInstance().toEntity(dto.getDescuento()));
        if(dto.getLineasAdicionales() != null) {
            entity.setLineasPresupuesto(LineasPresupuestoMapper.getInstance().toEntityListFromDTOs(dto.getLineasAdicionales()));
        }
        return entity;
    }
    
    @Override
    public List<PresupuestosEntity> toEntityList(GenericDAO dao) {
        return dao.findall();
    }
    
    @Override
    public List<PresupuestosDTO> toDTOList(List<PresupuestosEntity> entities) {
        if(entities == null){
            entities = new ArrayList<>();
        }
        List<PresupuestosDTO> dtos = new ArrayList<>();
        for(PresupuestosEntity entity : entities) {
            dtos.add(toDTO(entity));
        }
        return dtos;
    }

    public PresupuestosDTO toDTOById(int id) {
        return toDTO(presupuestosDAO.findBy(id));
    }
}

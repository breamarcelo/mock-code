package com.budgetsgenerator.mappers;

import java.util.ArrayList;
import java.util.List;

import com.budgetsgenerator.dto.LineasPresupuestoDTO;
import com.budgetsgenerator.models.LineasPresupuestoEntity;
import com.budgetsgenerator.repository.GenericDAO;
import com.budgetsgenerator.repository.impl.LineasPresupuestoDAO;

public class LineasPresupuestoMapper implements EntityMapper<LineasPresupuestoEntity, LineasPresupuestoDTO> {
    private static final LineasPresupuestoMapper instance = new LineasPresupuestoMapper();
    private static final LineasPresupuestoDAO lineasPresupuestoDAO = new LineasPresupuestoDAO(LineasPresupuestoEntity.class);
    
    private LineasPresupuestoMapper() {
    }

    public static LineasPresupuestoMapper getInstance(){
        return instance;
    }

    @Override
    public LineasPresupuestoDTO toDTO(LineasPresupuestoEntity entity) {
        LineasPresupuestoDTO dto = new LineasPresupuestoDTO();
        dto.setId(entity.getId());
        dto.setCantidad(entity.getCantidad());
        dto.setLineasAdicional(LineasAdicionalesMapper.getInstance().toDTO(entity.getLineaAdicional()));
        return dto;
    }

    @Override
    public LineasPresupuestoEntity toEntity(LineasPresupuestoDTO dto) {
        LineasPresupuestoEntity entity = new LineasPresupuestoEntity();
        entity.setId(dto.getId());
        entity.setCantidad(dto.getCantidad());
        entity.setLineaAdicional(LineasAdicionalesMapper.getInstance().toEntity(dto.getLineasAdicional()));
        return entity;
    }
    
    @Override
    public List<LineasPresupuestoEntity> toEntityList(GenericDAO dao) {
        return dao.findall();
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

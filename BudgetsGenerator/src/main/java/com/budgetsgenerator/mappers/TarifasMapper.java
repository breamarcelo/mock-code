package com.budgetsgenerator.mappers;

import java.util.ArrayList;
import java.util.List;

import com.budgetsgenerator.dto.TarifasDTO;
import com.budgetsgenerator.models.TarifasEntity;
import com.budgetsgenerator.repository.GenericDAO;
import com.budgetsgenerator.repository.impl.TarifasDAO;

public class TarifasMapper implements EntityMapper<TarifasEntity, TarifasDTO>{
    private static final TarifasMapper instance = new TarifasMapper();
    private static final TarifasDAO tarifasDAO = new TarifasDAO(TarifasEntity.class);
    
    private TarifasMapper() {
    }

    public static TarifasMapper getInstance() {
        return instance;
    }

    @Override
    public TarifasDTO toDTO(TarifasEntity entity) {
        TarifasDTO dto = new TarifasDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setTipo(entity.getTipo());
        dto.setLineasMoviles(entity.getLineasMoviles());
        dto.setLlamadasMovil(entity.getLlamadasMovil());
        dto.setGbMovil(entity.getGbMovil());
        dto.setOpcionFibra1(entity.getOpcionFibra1());
        dto.setOpcionFibra2(entity.getOpcionFibra2());
        dto.setSobrecargoFibra(entity.getSobrecargoFibra());
        dto.setPrecio(entity.getPrecio());
        dto.setServiciosAdicionales(ServiciosAdicionalesMapper.getInstance().toDTO(entity.getServiciosAdicionales()));
        dto.setTv(entity.isTv());
        dto.setStreaming(entity.isStreaming());
        return dto;
    }
    @Override
    public TarifasEntity toEntity(TarifasDTO dto) {
        TarifasEntity entity = new TarifasEntity();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setTipo(dto.getTipo());
        entity.setLineasMoviles(dto.getLineasMoviles());
        entity.setLlamadasMovil(dto.getLlamadasMovil());
        entity.setGbMovil(dto.getGbMovil());
        entity.setOpcionFibra1(dto.getOpcionFibra1());
        entity.setOpcionFibra2(dto.getOpcionFibra2());
        entity.setSobrecargoFibra(dto.getSobrecargoFibra());
        entity.setPrecio(dto.getPrecio());
        entity.setServiciosAdicionales(ServiciosAdicionalesMapper.getInstance().toEntity(dto.getServiciosAdicionales()));
        entity.setTv(dto.isTv());
        entity.setStreaming(dto.isStreaming());
        return entity;
    }

    
    @Override
    public List<TarifasEntity> toEntityList(GenericDAO dao) {
        return dao.findall();
    }
    
    @Override
    public List<TarifasDTO> toDTOList() {
        List<TarifasDTO> dtos = new ArrayList<>();
        for(TarifasEntity entity : toEntityList(tarifasDAO)) {
            dtos.add(toDTO(entity));
        }
        return dtos;
    }
}

package com.budgetsgenerator.mappers;

import java.util.ArrayList;
import java.util.List;

import com.budgetsgenerator.dto.StreamingDTO;
import com.budgetsgenerator.models.StreamingEntity;
import com.budgetsgenerator.repository.GenericDAO;
import com.budgetsgenerator.repository.impl.StreamingDAO;

public class StreamingMapper implements EntityMapper<StreamingEntity, StreamingDTO>{
    private static final StreamingMapper instance = new StreamingMapper();
    private static final StreamingDAO streamingDAO = new StreamingDAO(StreamingEntity.class);
    
    private StreamingMapper() {
    }

    public static StreamingMapper getInstance() {
        return instance;
    }
    
    @Override
    public StreamingDTO toDTO(StreamingEntity entity) {
        StreamingDTO dto = new StreamingDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        return dto;
    }

    @Override
    public StreamingEntity toEntity(StreamingDTO dto) {
        StreamingEntity entity = new StreamingEntity();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        return entity;
    }

    @Override
    public List<StreamingEntity> toEntityList(GenericDAO dao) {
        return dao.findall();
    }
  
    @Override
    public List<StreamingDTO> toDTOList(List<StreamingEntity> entities) {
        if(entities == null) {
            entities = streamingDAO.findall();
        }
        List<StreamingDTO> dtos = new ArrayList<>();
        for(StreamingEntity entity : entities){
            dtos.add(toDTO(entity));
        }
        return dtos;
    }
    
}

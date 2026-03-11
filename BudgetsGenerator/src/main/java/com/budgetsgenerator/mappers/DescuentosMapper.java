package com.budgetsgenerator.mappers;

import java.util.ArrayList;
import java.util.List;

import com.budgetsgenerator.dto.DescuentosDTO;
import com.budgetsgenerator.models.DescuentosEntity;
import com.budgetsgenerator.repository.GenericDAO;
import com.budgetsgenerator.repository.impl.DescuentosDAO;

public class DescuentosMapper implements EntityMapper<DescuentosEntity, DescuentosDTO> {
    private static final DescuentosMapper instance = new DescuentosMapper();
    private static final DescuentosDAO descuentosDAO = new DescuentosDAO(DescuentosEntity.class);

    private DescuentosMapper(){
    }

    public static DescuentosMapper getInstance(){
        return instance;
    }
    
    @Override
    public DescuentosDTO toDTO(DescuentosEntity entity) {
        DescuentosDTO dto = new DescuentosDTO();
        dto.setId(entity.getId());
        dto.setPorciento(entity.getPorciento());
        return dto;
    }

    @Override
    public DescuentosEntity toEntity(DescuentosDTO dto) {
        DescuentosEntity entity = new DescuentosEntity();
        entity.setId(dto.getId());
        entity.setPorciento(dto.getPorciento());
        return entity;
    }

    @Override
    public List<DescuentosEntity> toEntityList(GenericDAO dao) {
        return dao.findall();
    }

    @Override
    public List<DescuentosDTO> toDTOList() {
        List<DescuentosEntity> entities = descuentosDAO.findall();
        List<DescuentosDTO> dtos = new ArrayList<>();
        for(DescuentosEntity entity : toEntityList(descuentosDAO)) {
            dtos.add(toDTO(entity));
        }
        return dtos;
    }

}

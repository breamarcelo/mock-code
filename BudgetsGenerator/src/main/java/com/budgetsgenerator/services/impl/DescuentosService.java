package com.budgetsgenerator.services.impl;

import com.budgetsgenerator.dto.DescuentosDTO;
import com.budgetsgenerator.mappers.impl.DescuentosMapper;
import com.budgetsgenerator.models.DescuentosEntity;
import com.budgetsgenerator.repository.impl.DescuentosDAO;
import com.budgetsgenerator.services.GenericServiceImpl;

public class DescuentosService extends GenericServiceImpl<DescuentosDTO, DescuentosMapper, DescuentosEntity, DescuentosDAO, Integer>{
    private static DescuentosService instance;

    private DescuentosService() {
        super(new DescuentosDAO(DescuentosEntity.class), DescuentosMapper.getInstance());
    }
    
    public static DescuentosService getInstance() {
        if(instance == null) {
            instance = new DescuentosService();
        }
        return instance;
    }
}

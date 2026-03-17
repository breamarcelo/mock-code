package com.budgetsgenerator.services.impl;

import com.budgetsgenerator.dto.PresupuestosDTO;
import com.budgetsgenerator.mappers.impl.PresupuestosMapper;
import com.budgetsgenerator.models.PresupuestosEntity;
import com.budgetsgenerator.repository.impl.PresupuestosDAO;
import com.budgetsgenerator.services.GenericServiceImpl;

public class PresupuestosService extends GenericServiceImpl<PresupuestosDTO, PresupuestosMapper, PresupuestosEntity, PresupuestosDTO, Integer>{
    private static PresupuestosService instance;

    private PresupuestosService() {
        super(new PresupuestosDAO(PresupuestosEntity.class), PresupuestosMapper.getInstance());
    }

    public static PresupuestosService getInstance() {
        if(instance == null) {
            instance = new PresupuestosService();
        }
        return instance;
    }
}

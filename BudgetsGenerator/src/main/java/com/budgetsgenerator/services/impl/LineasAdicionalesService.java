package com.budgetsgenerator.services.impl;

import com.budgetsgenerator.dto.LineasAdicionalesDTO;
import com.budgetsgenerator.mappers.impl.LineasAdicionalesMapper;
import com.budgetsgenerator.models.LineasAdicionalesEntity;
import com.budgetsgenerator.repository.impl.LineasAdicionalesDAO;
import com.budgetsgenerator.services.GenericServiceImpl;

public class LineasAdicionalesService extends GenericServiceImpl<LineasAdicionalesDTO, LineasAdicionalesMapper, LineasAdicionalesEntity, LineasAdicionalesDAO, Integer>{
    private static LineasAdicionalesService instance;
    
    private LineasAdicionalesService() {
        super(new LineasAdicionalesDAO(LineasAdicionalesEntity.class), LineasAdicionalesMapper.getInstance());
    }

    public static LineasAdicionalesService getInstance() {
        if(instance == null) {
            instance = new LineasAdicionalesService();
        }
        return instance;
    }
}

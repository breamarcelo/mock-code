package com.budgetsgenerator.services.impl;

import com.budgetsgenerator.dto.TarifasDTO;
import com.budgetsgenerator.mappers.impl.TarifasMapper;
import com.budgetsgenerator.models.TarifasEntity;
import com.budgetsgenerator.repository.impl.TarifasDAO;
import com.budgetsgenerator.services.GenericServiceImpl;

public class TarifasService extends GenericServiceImpl<TarifasDTO, TarifasMapper, TarifasEntity, TarifasDAO, Integer>{
    private static TarifasService instance;

    private TarifasService() {
        super(new TarifasDAO(TarifasEntity.class), TarifasMapper.getInstance());
    }

    public static TarifasService getInstance() {
        if(instance == null) {
            instance = new TarifasService();
        }
        return instance;
    }
}

package com.budgetsgenerator.services.impl;

import com.budgetsgenerator.dto.CentralitasDTO;
import com.budgetsgenerator.mappers.impl.CentralitasMapper;
import com.budgetsgenerator.models.CentralitasEntity;
import com.budgetsgenerator.repository.impl.CentralitasDAO;
import com.budgetsgenerator.services.GenericServiceImpl;

public class CentralitasService extends GenericServiceImpl<CentralitasDTO, CentralitasMapper, CentralitasEntity, CentralitasDAO, Integer>{
    private static CentralitasService instance;

    private CentralitasService() {
        super(new CentralitasDAO(CentralitasEntity.class), CentralitasMapper.getInstance());
    }
   
    public static CentralitasService getInstance(){
        if(instance == null) {
            instance = new CentralitasService();
        }
        return instance;
    }
}

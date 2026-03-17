package com.budgetsgenerator.repository.impl;

import com.budgetsgenerator.models.CentralitasEntity;
import com.budgetsgenerator.repository.GenericDAOImpl;

public class CentralitasDAO extends GenericDAOImpl<CentralitasEntity, Integer>{

    public CentralitasDAO(Class<CentralitasEntity> entityClass) {
        super(entityClass);
    }

}

package com.budgetsgenerator.repository.impl;

import com.budgetsgenerator.models.TarifasEntity;

public class TarifasDAO extends GenericDAOImpl<TarifasEntity, Integer>{

    public TarifasDAO(Class<TarifasEntity> entityClass) {
        super(entityClass);
    }

}

package com.budgetsgenerator.repository.impl;

import com.budgetsgenerator.models.FibrasEntity;
import com.budgetsgenerator.repository.GenericDAOImpl;

public class FibrasDAO extends GenericDAOImpl<FibrasEntity, Integer>{

    public FibrasDAO(Class<FibrasEntity> entityClass) {
        super(entityClass);
    
    }

}

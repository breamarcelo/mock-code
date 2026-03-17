package com.budgetsgenerator.repository.impl;

import com.budgetsgenerator.models.LineasAdicionalesEntity;
import com.budgetsgenerator.repository.GenericDAOImpl;

public class LineasAdicionalesDAO extends GenericDAOImpl<LineasAdicionalesEntity, Integer>{

    public LineasAdicionalesDAO(Class<LineasAdicionalesEntity> entityClass) {
        super(entityClass);
    }

}

package com.budgetsgenerator.repository.impl;

import com.budgetsgenerator.models.DescuentosEntity;
import com.budgetsgenerator.repository.GenericDAOImpl;

public class DescuentosDAO extends GenericDAOImpl<DescuentosEntity, Integer>{

    public DescuentosDAO(Class<DescuentosEntity> entityClass) {
        super(entityClass);
    }

}

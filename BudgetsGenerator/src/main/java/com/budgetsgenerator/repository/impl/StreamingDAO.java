package com.budgetsgenerator.repository.impl;

import com.budgetsgenerator.models.StreamingEntity;

public class StreamingDAO extends GenericDAOImpl<StreamingEntity, Integer>{

    public StreamingDAO(Class<StreamingEntity> entityClass) {
        super(entityClass);
    }
}

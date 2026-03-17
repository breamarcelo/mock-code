package com.budgetsgenerator.repository.impl;

import com.budgetsgenerator.models.ServiciosAdicionalesEntity;
import com.budgetsgenerator.repository.GenericDAOImpl;

public class ServiciosAdicionalesDAO extends GenericDAOImpl<ServiciosAdicionalesEntity, Integer>{

    public ServiciosAdicionalesDAO(Class<ServiciosAdicionalesEntity> entityClass) {
        super(entityClass);
    }

}

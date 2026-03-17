package com.budgetsgenerator.repository.impl;

import com.budgetsgenerator.models.LineasPresupuestoEntity;
import com.budgetsgenerator.repository.GenericDAOImpl;

public class LineasPresupuestoDAO extends GenericDAOImpl<LineasPresupuestoEntity, Integer>{

    public LineasPresupuestoDAO(Class<LineasPresupuestoEntity> entityClass) {
        super(entityClass);
    }
}

package com.budgetsgenerator.repository.impl;

import com.budgetsgenerator.config.JPAUtil;
import com.budgetsgenerator.models.TarifasEntity;
import com.budgetsgenerator.repository.GenericDAOImpl;

import jakarta.persistence.EntityManager;

public class TarifasDAO extends GenericDAOImpl<TarifasEntity, Integer>{

    public TarifasDAO(Class<TarifasEntity> entityClass) {
        super(entityClass);
    }
    
    public TarifasEntity findByIdWithFibras(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery(
                "SELECT t FROM TarifasEntity t LEFT JOIN FETCH t.fibras WHERE t.id = :id", 
                TarifasEntity.class)
                .setParameter("id", id)
                .getSingleResult();
        } finally {
            em.close();
        }
    }
}

package com.budgetsgenerator.repository.impl;

import com.budgetsgenerator.config.JPAUtil;
import com.budgetsgenerator.models.PresupuestosEntity;

import jakarta.persistence.EntityManager;

public class PresupuestosDAO extends GenericDAOImpl<PresupuestosEntity, Integer>{

    public PresupuestosDAO(Class<PresupuestosEntity> entityClass) {
        super(entityClass);
    }

    public PresupuestosEntity findByIdWithLineasPresupuesto(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery(
                "SELECT t FROM PresupuestosEntity t LEFT JOIN FETCH t.lineasPresupuesto WHERE t.id = :id", 
                PresupuestosEntity.class)
                .setParameter("id", id)
                .getSingleResult();
        } finally {
            em.close();
        }
    }
}

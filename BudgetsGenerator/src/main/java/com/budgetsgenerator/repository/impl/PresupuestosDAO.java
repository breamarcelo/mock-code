package com.budgetsgenerator.repository.impl;

import java.util.List;

import com.budgetsgenerator.config.JPAUtil;
import com.budgetsgenerator.models.LineasPresupuestoEntity;
import com.budgetsgenerator.models.PresupuestosEntity;
import com.budgetsgenerator.repository.GenericDAOImpl;

import jakarta.persistence.EntityManager;

public class PresupuestosDAO extends GenericDAOImpl<PresupuestosEntity, Integer, EntityManager>{

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

    public PresupuestosEntity savePresupuesto(PresupuestosEntity presuspuestoEntity, List<LineasPresupuestoEntity> lineasPresupuestoEntitys, EntityManager em) {
        presuspuestoEntity.setId(null);
        PresupuestosEntity savedPresupuesto = em.merge(presuspuestoEntity);
        em.flush();
        if(lineasPresupuestoEntitys != null) {
            for(LineasPresupuestoEntity lineaEntity : lineasPresupuestoEntitys){
                lineaEntity.setId(null);
                lineaEntity.setPresupuesto(savedPresupuesto);
                em.persist(lineaEntity);
            }
        }
        return savedPresupuesto;
    }
}

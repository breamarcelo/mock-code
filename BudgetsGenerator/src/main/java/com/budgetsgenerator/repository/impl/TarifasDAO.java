package com.budgetsgenerator.repository.impl;

import java.util.List;

import com.budgetsgenerator.config.JPAUtil;
import com.budgetsgenerator.dto.TarifasDTO;
import com.budgetsgenerator.models.FibrasEntity;
import com.budgetsgenerator.models.TarifasEntity;
import com.budgetsgenerator.repository.GenericDAOImpl;

import jakarta.persistence.EntityManager;

public class TarifasDAO extends GenericDAOImpl<TarifasEntity, Integer, EntityManager>{

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

    public TarifasEntity saveTarifa(TarifasDTO dto, TarifasEntity tarifaEntity, List<FibrasEntity> fibrasEntitys, EntityManager em) {
        TarifasEntity savedTarifa = em.merge(tarifaEntity);
        em.flush();
        if(fibrasEntitys != null) {
            for(FibrasEntity fibraEntity : fibrasEntitys){
                fibraEntity.setTarifa(savedTarifa);
                savedTarifa.getFibras().add(fibraEntity);
            }
            savedTarifa = em.merge(savedTarifa);
        }
        return savedTarifa;
    }
}

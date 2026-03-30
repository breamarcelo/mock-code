package com.budgetsgenerator.repository.impl;

import java.util.List;

import com.budgetsgenerator.config.JPAUtil;
import com.budgetsgenerator.dto.PresupuestosDTO;
import com.budgetsgenerator.mappers.impl.CentralitasMapper;
import com.budgetsgenerator.mappers.impl.DescuentosMapper;
import com.budgetsgenerator.mappers.impl.FibrasMapper;
import com.budgetsgenerator.mappers.impl.PacksFutbolMapper;
import com.budgetsgenerator.mappers.impl.StreamingMapper;
import com.budgetsgenerator.mappers.impl.TarifasMapper;
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
        PresupuestosEntity savedPresupuesto = em.merge(presuspuestoEntity);
        em.flush();
        if(lineasPresupuestoEntitys != null) {
            for(LineasPresupuestoEntity lineaEntity : lineasPresupuestoEntitys){
                lineaEntity.setPresupuesto(savedPresupuesto);
                savedPresupuesto.getLineasPresupuesto().add(lineaEntity);
            }
            savedPresupuesto = em.merge(savedPresupuesto);
        }
        return savedPresupuesto;
    }

    public PresupuestosEntity updatePresupuesto(PresupuestosDTO dto, PresupuestosEntity presuspuestoEntity, List<LineasPresupuestoEntity> lineasPresupuestoEntitys, EntityManager em) {
        PresupuestosEntity savedPresupuesto = em.find(PresupuestosEntity.class, dto.getId());
        savedPresupuesto.setTarifa(TarifasMapper.getInstance().toEntity(dto.getTarifa()));
        savedPresupuesto.setFibra(FibrasMapper.getInstance().toEntity(dto.getFibra()));
        savedPresupuesto.setStreaming(StreamingMapper.getInstance().toEntity(dto.getStreaming()));
        savedPresupuesto.setCentralita(CentralitasMapper.getInstance().toEntity(dto.getCentralita()));
        savedPresupuesto.setPackFutbol(PacksFutbolMapper.getInstance().toEntity(dto.getPackFutbol()));
        savedPresupuesto.setDescuento(DescuentosMapper.getInstance().toEntity(dto.getDescuento()));
        savedPresupuesto.getLineasPresupuesto().clear();
        em.flush();
        if(lineasPresupuestoEntitys != null) {
            for(LineasPresupuestoEntity lineaEntity : lineasPresupuestoEntitys){
                lineaEntity.setPresupuesto(savedPresupuesto);
                savedPresupuesto.getLineasPresupuesto().add(lineaEntity);
            }
        }
        em.merge(savedPresupuesto);
        return savedPresupuesto;
    }
}

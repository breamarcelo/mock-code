package com.budgetsgenerator.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.budgetsgenerator.config.JPAUtil;
import com.budgetsgenerator.dto.LineasPresupuestoDTO;
import com.budgetsgenerator.dto.PresupuestosDTO;
import com.budgetsgenerator.mappers.impl.CentralitasMapper;
import com.budgetsgenerator.mappers.impl.DescuentosMapper;
import com.budgetsgenerator.mappers.impl.FibrasMapper;
import com.budgetsgenerator.mappers.impl.LineasPresupuestoMapper;
import com.budgetsgenerator.mappers.impl.PacksFutbolMapper;
import com.budgetsgenerator.mappers.impl.PresupuestosMapper;
import com.budgetsgenerator.mappers.impl.StreamingMapper;
import com.budgetsgenerator.mappers.impl.TarifasMapper;
import com.budgetsgenerator.models.LineasPresupuestoEntity;
import com.budgetsgenerator.models.PresupuestosEntity;
import com.budgetsgenerator.repository.impl.PresupuestosDAO;
import com.budgetsgenerator.services.GenericServiceImpl;

import jakarta.persistence.EntityManager;

public class PresupuestosService extends GenericServiceImpl<PresupuestosDTO, PresupuestosMapper, PresupuestosEntity, PresupuestosDTO, Integer>{
    private static PresupuestosService instance;

    private PresupuestosService() {
        super(new PresupuestosDAO(PresupuestosEntity.class), PresupuestosMapper.getInstance());
    }

    public static PresupuestosService getInstance() {
        if(instance == null) {
            instance = new PresupuestosService();
        }
        return instance;
    }
    
    public static PresupuestosDTO savePresupuesto(PresupuestosDTO presupuestosDTO, List<LineasPresupuestoDTO> lineasPresupuesto){
        EntityManager em = JPAUtil.getEntityManager();
        PresupuestosDAO presupuestosDAO = new PresupuestosDAO(PresupuestosEntity.class);
        
        try {
            em.getTransaction().begin();
            PresupuestosEntity presupuestosEntity = PresupuestosMapper.getInstance().toEntity(presupuestosDTO, em);
            presupuestosEntity.setLineasPresupuesto(new ArrayList<>());
    
            List<LineasPresupuestoEntity> lineasPresupuestoEntitys = LineasPresupuestoMapper.getInstance().toEntityList(lineasPresupuesto, em);
            PresupuestosEntity savedEntity = presupuestosDAO.savePresupuesto(presupuestosEntity, lineasPresupuestoEntitys, em);
            em.getTransaction().commit();
            return PresupuestosMapper.getInstance().toDTO(savedEntity, em);
        } catch (Exception e) {
            if(em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            } 
            throw e;  
        } finally {
            em.close();
        }
    }

    public static PresupuestosDTO updatePresupuesto(PresupuestosDTO presupuestosDTO, List<LineasPresupuestoDTO> lineasPresupuesto){
        EntityManager em = JPAUtil.getEntityManager();
        PresupuestosDAO presupuestosDAO = new PresupuestosDAO(PresupuestosEntity.class);
        
        try {
            em.getTransaction().begin();
            PresupuestosEntity presupuestosEntity = em.find(PresupuestosEntity.class, presupuestosDTO.getId());
            if(presupuestosDTO.getTarifa() != null) {
                presupuestosEntity.setTarifa(TarifasMapper.getInstance().toEntity(presupuestosDTO.getTarifa(), em));
            }
            if(presupuestosDTO.getFibra() != null){
                presupuestosEntity.setFibra(FibrasMapper.getInstance().toEntity(presupuestosDTO.getFibra(), em));
            }
            if(presupuestosDTO.getStreaming() != null) {
                presupuestosEntity.setStreaming(StreamingMapper.getInstance().toEntity(presupuestosDTO.getStreaming(), em));
            }
            if(presupuestosDTO.getCentralita() != null) {
                presupuestosEntity.setCentralita(CentralitasMapper.getInstance().toEntity(presupuestosDTO.getCentralita(), em));
            }
            if(presupuestosDTO.getPackFutbol() != null) {
                presupuestosEntity.setPackFutbol(PacksFutbolMapper.getInstance().toEntity(presupuestosDTO.getPackFutbol(), em));
            }
            if(presupuestosDTO.getDescuento() != null) {
                presupuestosEntity.setDescuento(DescuentosMapper.getInstance().toEntity(presupuestosDTO.getDescuento(), em));
            }
            presupuestosEntity.getLineasPresupuesto().clear();
            em.flush();
            if(lineasPresupuesto != null) {
                List<LineasPresupuestoEntity> lineasPresupuestoEntitys = LineasPresupuestoMapper.getInstance().toEntityList(lineasPresupuesto, em);
                for(LineasPresupuestoEntity lineaEntity : lineasPresupuestoEntitys) {
                    lineaEntity.setPresupuesto(presupuestosEntity);
                    presupuestosEntity.getLineasPresupuesto().add(lineaEntity);
                }
                // em.merge(presupuestosEntity);
            }
            // presupuestosEntity.setLineasPresupuesto(lineasPresupuestoEntitys);
            // PresupuestosEntity savedEntity = presupuestosDAO.updatePresupuesto(presupuestosDTO, presupuestosEntity, lineasPresupuestoEntitys, em);
            em.getTransaction().commit();
            return PresupuestosMapper.getInstance().toDTO(presupuestosEntity, em);
        } catch (Exception e) {
            if(em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            } 
            throw e;  
        } finally {
            em.close();
        }
    }
    
}

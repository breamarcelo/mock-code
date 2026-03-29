package com.budgetsgenerator.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.budgetsgenerator.config.JPAUtil;
import com.budgetsgenerator.dto.LineasPresupuestoDTO;
import com.budgetsgenerator.dto.PresupuestosDTO;
import com.budgetsgenerator.mappers.impl.LineasPresupuestoMapper;
import com.budgetsgenerator.mappers.impl.PresupuestosMapper;
import com.budgetsgenerator.models.LineasPresupuestoEntity;
import com.budgetsgenerator.models.PresupuestosEntity;
import com.budgetsgenerator.repository.impl.LineasPresupuestoDAO;
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
        LineasPresupuestoDAO lineasPresupuestoDAO = new LineasPresupuestoDAO(LineasPresupuestoEntity.class);
        try {
            em.getTransaction().begin();
            PresupuestosEntity presupuestosEntity = PresupuestosMapper.getInstance().toEntity(presupuestosDTO);
            presupuestosEntity.setLineasPresupuesto(new ArrayList<>());
            // presupuestosDAO.save(presupuestosEntity, em);
            presupuestosEntity = em.merge(presupuestosEntity);
            em.flush();
            if(lineasPresupuesto != null) {
                for(LineasPresupuestoDTO lineaDTO : lineasPresupuesto){
                    LineasPresupuestoEntity lineaEntity = LineasPresupuestoMapper.getInstance().toEntity(lineaDTO);
                    lineaEntity.setPresupuesto(presupuestosEntity);

                    // lineasPresupuestoDAO.save(lineaEntity, em);
                    em.merge(lineaEntity);
                }
            }
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
    // public static PresupuestosDTO findByIdWithLineas(int id){
    //     return PresupuestosMapper.getInstance().toDTO(new PresupuestosDAO(PresupuestosEntity.class).findByIdWithLineasPresupuesto(id));
    // }
}

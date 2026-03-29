package com.budgetsgenerator.services;

import java.util.List;

import com.budgetsgenerator.config.JPAUtil;
import com.budgetsgenerator.mappers.EntityMapper;
import com.budgetsgenerator.repository.GenericDAO;

import jakarta.persistence.EntityManager;

public abstract class GenericServiceImpl<DTO, M, E, DAO, ID> implements GenericService<DTO, M, E, DAO, ID>{
    private GenericDAO<E, ID, EntityManager> dao;
    private EntityMapper<E, DTO, EntityManager> mapper;
    
    public GenericServiceImpl() {
    }

    public GenericServiceImpl(GenericDAO<E, ID, EntityManager> dao, EntityMapper<E, DTO, EntityManager> mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    public List<DTO> getAll() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return mapper.toDTOList(dao.findall(em), em);
        } catch (Exception e) {
            if(em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            } 
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public DTO findById(ID id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return mapper.toDTO(dao.findBy(id, em), em);
        } catch (Exception e) {
            if(em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            } 
            throw e;
        }finally {
            em.close();
        }
    }

    @Override
    public DTO save(DTO dto) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            E entity = mapper.toEntity(dto);
            E savedEntity = dao.save(entity, em);
            em.getTransaction().commit();
            return mapper.toDTO(savedEntity, em);
        } catch (Exception e) {
            if(em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            } 
            throw e;  
        } finally {
            em.close();
        }
    }

    @Override
    public void delete(DTO dto) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            dao.delete(mapper.toEntity(dto), em);
            em.getTransaction().commit();
        } catch (Exception e) {
            if(em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            } 
            throw e;  
        } finally {
            em.close();
        }
    }

    @Override
    public void update(DTO dto) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            dao.update(mapper.toEntity(dto), em);
            em.getTransaction().commit();
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

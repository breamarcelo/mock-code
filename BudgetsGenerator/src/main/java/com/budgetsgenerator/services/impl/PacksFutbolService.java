package com.budgetsgenerator.services.impl;

import com.budgetsgenerator.dto.PacksFutbolDTO;
import com.budgetsgenerator.mappers.impl.PacksFutbolMapper;
import com.budgetsgenerator.models.PacksFutbolEntity;
import com.budgetsgenerator.repository.impl.PacksFutbolDAO;
import com.budgetsgenerator.services.GenericServiceImpl;

public class PacksFutbolService extends GenericServiceImpl<PacksFutbolDTO, PacksFutbolMapper, PacksFutbolEntity, PacksFutbolDAO, Integer>{
    private static PacksFutbolService instance;

    private PacksFutbolService() {
        super(new PacksFutbolDAO(PacksFutbolEntity.class), PacksFutbolMapper.getInstance());
    }

    public static PacksFutbolService getInstance() {
        if(instance == null) {
            instance = new PacksFutbolService();
        }
        return instance;
    }
}

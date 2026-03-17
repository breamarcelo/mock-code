package com.budgetsgenerator.services.impl;

import com.budgetsgenerator.dto.StreamingDTO;
import com.budgetsgenerator.mappers.impl.StreamingMapper;
import com.budgetsgenerator.models.StreamingEntity;
import com.budgetsgenerator.repository.impl.StreamingDAO;
import com.budgetsgenerator.services.GenericServiceImpl;

public class StreamingService extends GenericServiceImpl<StreamingDTO, StreamingMapper, StreamingEntity, StreamingDAO, Integer>{
    private static StreamingService instance;

    private StreamingService() {
        super(new StreamingDAO(StreamingEntity.class), StreamingMapper.getInstance());
    }

    public static StreamingService getInstance() {
        if(instance == null) {
            instance = new StreamingService();
        }
        return instance;
    }

}

package com.licky.tour.service;

import com.licky.tour.domain.Preparation;
import com.licky.tour.mapper.PreparationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PreparationService {
    @Autowired
    private PreparationMapper preparationMapper;

    public Boolean createPreparation(Preparation preparation){
        return preparationMapper.insert(preparation)==1?true:false;
    }
}

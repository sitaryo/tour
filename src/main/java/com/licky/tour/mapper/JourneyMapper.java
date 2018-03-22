package com.licky.tour.mapper;

import com.licky.tour.domain.Journey;
import org.springframework.stereotype.Repository;

@Repository
public interface JourneyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Journey record);

    int insertSelective(Journey record);

    Journey selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Journey record);

    int updateByPrimaryKey(Journey record);
}
package com.licky.tour.mapper;

import com.licky.tour.domain.Preparation;
import org.springframework.stereotype.Repository;

@Repository
public interface PreparationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Preparation record);

    int insertSelective(Preparation record);

    Preparation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Preparation record);

    int updateByPrimaryKey(Preparation record);
}
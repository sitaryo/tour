package com.licky.tour.mapper;

import com.licky.tour.domain.Pic;
import org.springframework.stereotype.Repository;

@Repository
public interface PicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Pic record);

    int insertSelective(Pic record);

    Pic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Pic record);

    int updateByPrimaryKey(Pic record);
}
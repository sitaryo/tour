package com.licky.tour.mapper;

import com.licky.tour.domain.History;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(History record);

    int insertSelective(History record);

    History selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(History record);

    int updateByPrimaryKey(History record);
}
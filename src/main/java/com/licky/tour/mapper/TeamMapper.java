package com.licky.tour.mapper;

import com.licky.tour.domain.Team;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Team record);

    int insertSelective(Team record);

    Team selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Team record);

    int updateByPrimaryKey(Team record);
}
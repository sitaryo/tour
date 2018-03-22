package com.licky.tour.mapper;

import com.licky.tour.domain.Authority;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Authority record);

    int insertSelective(Authority record);

    Authority selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Authority record);

    int updateByPrimaryKey(Authority record);
}
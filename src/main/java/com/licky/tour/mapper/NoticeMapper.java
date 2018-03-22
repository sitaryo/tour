package com.licky.tour.mapper;

import com.licky.tour.domain.Notice;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);
}
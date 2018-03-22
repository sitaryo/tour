package com.licky.tour.mapper;

import com.licky.tour.domain.HeadPic;
import org.springframework.stereotype.Repository;

@Repository
public interface HeadPicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HeadPic record);

    int insertSelective(HeadPic record);

    HeadPic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HeadPic record);

    int updateByPrimaryKey(HeadPic record);
}
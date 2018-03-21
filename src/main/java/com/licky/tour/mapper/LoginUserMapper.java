package com.licky.tour.mapper;

import com.licky.tour.domain.LoginUser;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LoginUserMapper {

    @Select("Select * form user")
    List<LoginUser> getAllUser();
}

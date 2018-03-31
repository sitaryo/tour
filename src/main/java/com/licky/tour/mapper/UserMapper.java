package com.licky.tour.mapper;

import com.licky.tour.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    User updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByUsernameAndPassword(User user);

    User selectByUsername(String user);

    List<User> selectUsersInSameTeam(User user);

    int removeUserFormTeamByUsername(User user);

    int updateBaseInfoByUsername(User user);

    int resetPasswordByUsername(User user);
}
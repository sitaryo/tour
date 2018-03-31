package com.licky.tour.service;

import com.licky.tour.domain.User;
import com.licky.tour.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService  {
    @Autowired
    private UserMapper userMapper;

    public Boolean insertUser(User user){
        int number = userMapper.insert(user);
        return number == 1?true:false;
    }

    public Optional<User> selectUserByUsernameAndPassword(User user){
        return Optional.ofNullable(userMapper.selectByUsernameAndPassword(user));
    }

    public Optional<List<User>> selectUsersInSameTeam(User user){
        return Optional.ofNullable(userMapper.selectUsersInSameTeam(user));
    }

    public Boolean removeUserFromTeam(User user){
        return userMapper.removeUserFormTeamByUsername(user)==1?true:false;
    }

    public Optional<User> selectUserByUsername(String username){
        return Optional.ofNullable(userMapper.selectByUsername(username));
    }

    /**
     * 根据用户名，修改基本信息（性别，昵称）
     *
     * @param user
     * @return
     */
    public Boolean updateBaseInfoByUserName(User user){
        return userMapper.updateBaseInfoByUsername(user)==1?true:false;
    }

    public Boolean resetPasswordByUsername(User user){
        return userMapper.resetPasswordByUsername(user)==1?true:false;
    }

}

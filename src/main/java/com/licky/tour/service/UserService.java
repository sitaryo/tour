package com.licky.tour.service;

import com.licky.tour.domain.User;
import com.licky.tour.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService  {
    @Autowired
    private UserMapper userMapper;

    public void insertUser(){
        User user = new User();
        user.setUsername("licky");
        user.setPassword("666666");
        userMapper.insert(user);
    }

}

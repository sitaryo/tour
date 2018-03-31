package com.licky.tour.controller;

import com.licky.tour.domain.User;
import com.licky.tour.service.AuthorityService;
import com.licky.tour.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthorityService authorityService;

    /**
     * 根据用户名密码 获取用户权限
     *
     * @param user user
     * @return 用户权限
     */
    @PostMapping("/login")
    @ResponseBody
    public Map<String, String> login(@RequestBody User user) {
        //todo 登录时间？
        Map<String, String> data = new HashMap(1);
        userService.selectUserByUsernameAndPassword(user).ifPresent(dbUser ->
                authorityService.selectAuthorityById(dbUser.getAuthorityId()).ifPresent(authority ->
                        data.put("authority", authority.getName())
                )
        );
        return data;
    }

    /**
     * 插入user
     *
     * @param user 要插入的user
     * @return insertFlag true/false
     */
    @PostMapping("/register")
    @ResponseBody
    public Map<String, Boolean> register(@RequestBody User user) {
        Map<String, Boolean> data = new HashMap<>(1);
        user.setActive(true);
        data.put("insertFlag", userService.insertUser(user));
        return data;
    }
}

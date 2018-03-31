package com.licky.tour.service;


import com.licky.tour.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void InsertUserTest02(){
        User user = new User();
        user.setUsername("user");
        userService.selectUsersInSameTeam(user).ifPresent(users -> {
            System.out.println(users);
        });
    }
}

package com.shier.mongo;

import com.shier.mongo.entity.User;
import com.shier.mongo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    private Logger logger = LoggerFactory.getLogger(UserTest.class);
    @Resource
    private UserService userService;

    @Test
    public void addUser() {
        User user = new User(16, "" + 16, 16);
        userService.insert(user);
    }

    @Test
    public void addMannyUser() {
        List<User> userList = new ArrayList<>();
        for (int i = 20; i < 28; i++) {
            User user = new User(i, "" + i, i);
            userList.add(user);
        }
        userService.insertAll(userList);
    }

    @Test
    public void queryAll() {
        List<User> userList = userService.findAll();
        userList.forEach(user -> {
            logger.info("******user:{}", user.toString());
        });
    }

    @Test
    public void queryById() {
        User user = userService.getUser(16);
        logger.info("******user:{}", user.toString());
    }

    @Test
    public void update() {
        User user = new User();
        user.setId(16);
        user.setAge(18);
        user.setName("云标李");
        userService.update(user);
    }
}

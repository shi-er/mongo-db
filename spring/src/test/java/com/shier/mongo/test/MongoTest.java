package com.shier.mongo.test;

import com.shier.mongo.dao.MongoBaseDao;
import com.shier.mongo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@ContextConfiguration({"classpath:/xml/spring-contex.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class MongoTest {
    private Logger logger = LoggerFactory.getLogger(MongoTest.class);
    @Resource
    private MongoBaseDao mongoBaseDao;

    @Test
    public void queryById() {
        //User user = mongoBaseDao.findById("1", User.class);
        User user = mongoBaseDao.findById("1", User.class, "user");
        logger.info("******user:{}", user.toString());
    }

    @Test
    public void add() {
        User user = new User();
        user.setId("1");
        user.setName("云标李");
        user.setAddress("安徽省利辛县");
        user.setAge(18);
        //logger.info("******id:{}", mongoBaseDao.save(user));
        logger.info("******id:{}", mongoBaseDao.save(user, "user"));
    }

    @Test
    public void queryAll() {
        //List<User> userList = mongoBaseDao.findAll(User.class);
        List<User> userList = mongoBaseDao.findAll(User.class, "user");
        userList.forEach(user -> {
            logger.info("******user:{}", user.toString());
        });
    }

    @Test
    public void delete() {
        //logger.info("******result:{}", mongoBaseDao.deleteById("1", User.class));
        logger.info("******result:{}", mongoBaseDao.deleteById("1", User.class, "user").toString());
    }

    @Test
    public void update() {
        User user = new User();
        user.setId("1");
        user.setName("shier Hello汝集镇");
        user.setAddress("安徽省利辛县");
        user.setAge(20);
        try {
            //logger.info("******result:{}", mongoBaseDao.updateOne(user));
            logger.info("******result:{}", mongoBaseDao.updateOne(user), "user");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
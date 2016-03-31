package com.tiger.learn.mybatis.sample.test.dao;

import com.tiger.learn.mybatis.sample.Application;
import com.tiger.learn.mybatis.sample.dao.UserDao;
import com.tiger.learn.mybatis.sample.model.User;
import com.tiger.learn.mybatis.sample.test.util.CommonBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * @author xuerhu (mailto:xueh@primeton.com)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@Rollback
@Transactional
public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    private String userId_1 = UUID.randomUUID().toString();
    private String username_1 = "username1";
    private String password_1 = "password1";

    private String userId_2 = UUID.randomUUID().toString();
    private String username_2 = "username2";
    private String password_2 = "password2";

    @Before
    public void prepare() {
        User user1 = CommonBuilder.buildUser(userId_1, username_1, password_1);
        User user2 = CommonBuilder.buildUser(userId_2, username_2, password_2);
        userDao.insertUser(user1);
        userDao.insertUser(user2);
    }

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setUsername("erhu");
        user.setPassword("123456");

        List<User> before = userDao.getAll();

        userDao.insertUser(user);

        List<User> after = userDao.getAll();
        Assert.assertEquals(before.size(), after.size() - 1);
    }
}

package com.tiger.learn.mybaits.sample.test.dao;

import com.tiger.learn.mybatis.sample.Application;
import com.tiger.learn.mybatis.sample.dao.UserDao;
import com.tiger.learn.mybatis.sample.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.UUID;

/**
 * @author xuerhu (mailto:xueh@primeton.com)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@Rollback
public class UserDaoTest {
    @Autowired
    private UserDao userDao;

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

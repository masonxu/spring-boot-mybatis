package com.tiger.learn.mybatis.sample.service;

import com.tiger.learn.mybatis.sample.dao.UserDao;
import com.tiger.learn.mybatis.sample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xuerhu (mailto:xueh@primeton.com)
 */
@Service("userService")
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<User> getAll() {
        return userDao.getAll();
    }
}

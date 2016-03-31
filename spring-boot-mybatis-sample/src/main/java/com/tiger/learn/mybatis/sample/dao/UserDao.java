package com.tiger.learn.mybatis.sample.dao;

import com.tiger.learn.mybatis.sample.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xuerhu (mailto:xueh@primeton.com)
 */
public interface UserDao {

    User getById(String id);

    List<User> getAll();

    int insertUser(User user);
}

package com.tiger.learn.mybatis.sample.test.util;

import com.tiger.learn.mybatis.sample.model.User;

/**
 * @author xuerhu (mailto:xueh@primeton.com)
 */
public class CommonBuilder {
    public static User buildUser(String id, String username, String password) {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);

        return user;
    }
}

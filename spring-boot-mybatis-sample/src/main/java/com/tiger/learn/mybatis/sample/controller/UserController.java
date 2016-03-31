package com.tiger.learn.mybatis.sample.controller;

import com.tiger.learn.mybatis.sample.model.User;
import com.tiger.learn.mybatis.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xuerhu on 3/29/16.
 */

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAllProducts() {
        return userService.getAll();
    }
}

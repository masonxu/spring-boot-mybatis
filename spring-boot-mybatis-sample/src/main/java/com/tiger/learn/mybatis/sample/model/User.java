package com.tiger.learn.mybatis.sample.model;

import java.io.Serializable;

/**
 * @author xuerhu (mailto:xueh@primeton.com)
 */
public class User implements Serializable{

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String id;

    private String username;

    private String password;


}

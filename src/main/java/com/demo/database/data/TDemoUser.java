package com.demo.database.data;

import java.sql.Date;

/**
 * 用户表的持久化类
 * @Author weixianbo
 * @CreateTime 2021/7/22 15:19
 * @Version 1.0.0
 */
public class TDemoUser {

    private Integer userId;
    private String userName;
    private String userPassword;
    private String userGender;
    private Date userBirthday;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }
}

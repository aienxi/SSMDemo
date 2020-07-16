package com.xinyu.model;

import java.util.Date;

public class UserInfo {
    private Integer userId;

    private String userName;

    private String userHeadImg;

    private Integer userAge;

    private Integer userSex;

    private Date registerTime;

    public UserInfo(Integer userId, String userName, String userHeadImg, Integer userAge, Integer userSex, Date registerTime) {
        this.userId = userId;
        this.userName = userName;
        this.userHeadImg = userHeadImg;
        this.userAge = userAge;
        this.userSex = userSex;
        this.registerTime = registerTime;
    }

    public UserInfo() {
        super();
    }

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
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserHeadImg() {
        return userHeadImg;
    }

    public void setUserHeadImg(String userHeadImg) {
        this.userHeadImg = userHeadImg == null ? null : userHeadImg.trim();
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }
}
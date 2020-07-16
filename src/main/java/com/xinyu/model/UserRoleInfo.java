package com.xinyu.model;

import java.util.Date;

public class UserRoleInfo {
    private Integer urId;

    private Integer userId;

    private Integer roleId;

    private Date createTime;

    private Date updateTime;

    public UserRoleInfo(Integer urId, Integer userId, Integer roleId, Date createTime, Date updateTime) {
        this.urId = urId;
        this.userId = userId;
        this.roleId = roleId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public UserRoleInfo() {
        super();
    }

    public Integer getUrId() {
        return urId;
    }

    public void setUrId(Integer urId) {
        this.urId = urId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
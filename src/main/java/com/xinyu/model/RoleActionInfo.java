package com.xinyu.model;

import java.util.Date;

public class RoleActionInfo {
    private Integer raId;

    private Integer roleId;

    private Integer actionId;

    private Date createTime;

    private Date updateTime;

    public RoleActionInfo(Integer raId, Integer roleId, Integer actionId, Date createTime, Date updateTime) {
        this.raId = raId;
        this.roleId = roleId;
        this.actionId = actionId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public RoleActionInfo() {
        super();
    }

    public Integer getRaId() {
        return raId;
    }

    public void setRaId(Integer raId) {
        this.raId = raId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getActionId() {
        return actionId;
    }

    public void setActionId(Integer actionId) {
        this.actionId = actionId;
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
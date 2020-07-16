package com.xinyu.model;

public class ActionInfo {
    private Integer actionId;

    private String actionName;

    private String actionDesc;

    public ActionInfo(Integer actionId, String actionName, String actionDesc) {
        this.actionId = actionId;
        this.actionName = actionName;
        this.actionDesc = actionDesc;
    }

    public ActionInfo() {
        super();
    }

    public Integer getActionId() {
        return actionId;
    }

    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName == null ? null : actionName.trim();
    }

    public String getActionDesc() {
        return actionDesc;
    }

    public void setActionDesc(String actionDesc) {
        this.actionDesc = actionDesc == null ? null : actionDesc.trim();
    }
}
package com.xinyu.dao;

import com.xinyu.model.ActionInfo;

public interface ActionInfoMapper {
    int deleteByPrimaryKey(Integer actionId);

    int insert(ActionInfo record);

    int insertSelective(ActionInfo record);

    ActionInfo selectByPrimaryKey(Integer actionId);

    int updateByPrimaryKeySelective(ActionInfo record);

    int updateByPrimaryKey(ActionInfo record);
}
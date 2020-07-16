package com.xinyu.dao;

import com.xinyu.model.UserRoleInfo;

public interface UserRoleInfoMapper {
    int deleteByPrimaryKey(Integer urId);

    int insert(UserRoleInfo record);

    int insertSelective(UserRoleInfo record);

    UserRoleInfo selectByPrimaryKey(Integer urId);

    int updateByPrimaryKeySelective(UserRoleInfo record);

    int updateByPrimaryKey(UserRoleInfo record);
}
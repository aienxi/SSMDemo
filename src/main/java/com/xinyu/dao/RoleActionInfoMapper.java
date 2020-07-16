package com.xinyu.dao;

import com.xinyu.model.RoleActionInfo;

public interface RoleActionInfoMapper {
    int deleteByPrimaryKey(Integer raId);

    int insert(RoleActionInfo record);

    int insertSelective(RoleActionInfo record);

    RoleActionInfo selectByPrimaryKey(Integer raId);

    int updateByPrimaryKeySelective(RoleActionInfo record);

    int updateByPrimaryKey(RoleActionInfo record);
}
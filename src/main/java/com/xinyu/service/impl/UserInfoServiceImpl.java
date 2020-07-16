package com.xinyu.service.impl;

import com.xinyu.dao.UserInfoMapper;
import com.xinyu.model.UserInfo;
import com.xinyu.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    UserInfoMapper mapper ;

    @Override
    public UserInfo selectUserInfoByUserID(int userId) {
        UserInfo userInfo =  mapper.selectByPrimaryKey(userId);

        return userInfo;
    }
}

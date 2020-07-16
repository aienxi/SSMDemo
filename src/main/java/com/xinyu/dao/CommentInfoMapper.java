package com.xinyu.dao;

import com.xinyu.model.CommentInfo;

public interface CommentInfoMapper {
    int deleteByPrimaryKey(Integer commentId);

    int insert(CommentInfo record);

    int insertSelective(CommentInfo record);

    CommentInfo selectByPrimaryKey(Integer commentId);

    int updateByPrimaryKeySelective(CommentInfo record);

    int updateByPrimaryKeyWithBLOBs(CommentInfo record);

    int updateByPrimaryKey(CommentInfo record);
}
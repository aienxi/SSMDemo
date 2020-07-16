package com.xinyu.dao;

import com.xinyu.model.ArticleInfo;

public interface ArticleInfoMapper {
    int deleteByPrimaryKey(Integer articleId);

    int insert(ArticleInfo record);

    int insertSelective(ArticleInfo record);

    ArticleInfo selectByPrimaryKey(Integer articleId);

    int updateByPrimaryKeySelective(ArticleInfo record);

    int updateByPrimaryKeyWithBLOBs(ArticleInfo record);

    int updateByPrimaryKey(ArticleInfo record);
}
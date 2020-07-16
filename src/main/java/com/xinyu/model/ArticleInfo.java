package com.xinyu.model;

import java.util.Date;

public class ArticleInfo {
    private Integer articleId;

    private String atricleTitle;

    private String articleSubhead;

    private Integer articleStar;

    private Integer articleTransmit;

    private Integer articeShare;

    private Integer articleState;

    private Integer publicUserId;

    private Date publicTime;

    private Date updateTime;

    private String atricleContent;

    public ArticleInfo(Integer articleId, String atricleTitle, String articleSubhead, Integer articleStar, Integer articleTransmit, Integer articeShare, Integer articleState, Integer publicUserId, Date publicTime, Date updateTime, String atricleContent) {
        this.articleId = articleId;
        this.atricleTitle = atricleTitle;
        this.articleSubhead = articleSubhead;
        this.articleStar = articleStar;
        this.articleTransmit = articleTransmit;
        this.articeShare = articeShare;
        this.articleState = articleState;
        this.publicUserId = publicUserId;
        this.publicTime = publicTime;
        this.updateTime = updateTime;
        this.atricleContent = atricleContent;
    }

    public ArticleInfo() {
        super();
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getAtricleTitle() {
        return atricleTitle;
    }

    public void setAtricleTitle(String atricleTitle) {
        this.atricleTitle = atricleTitle == null ? null : atricleTitle.trim();
    }

    public String getArticleSubhead() {
        return articleSubhead;
    }

    public void setArticleSubhead(String articleSubhead) {
        this.articleSubhead = articleSubhead == null ? null : articleSubhead.trim();
    }

    public Integer getArticleStar() {
        return articleStar;
    }

    public void setArticleStar(Integer articleStar) {
        this.articleStar = articleStar;
    }

    public Integer getArticleTransmit() {
        return articleTransmit;
    }

    public void setArticleTransmit(Integer articleTransmit) {
        this.articleTransmit = articleTransmit;
    }

    public Integer getArticeShare() {
        return articeShare;
    }

    public void setArticeShare(Integer articeShare) {
        this.articeShare = articeShare;
    }

    public Integer getArticleState() {
        return articleState;
    }

    public void setArticleState(Integer articleState) {
        this.articleState = articleState;
    }

    public Integer getPublicUserId() {
        return publicUserId;
    }

    public void setPublicUserId(Integer publicUserId) {
        this.publicUserId = publicUserId;
    }

    public Date getPublicTime() {
        return publicTime;
    }

    public void setPublicTime(Date publicTime) {
        this.publicTime = publicTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getAtricleContent() {
        return atricleContent;
    }

    public void setAtricleContent(String atricleContent) {
        this.atricleContent = atricleContent == null ? null : atricleContent.trim();
    }
}
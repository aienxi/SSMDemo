package com.xinyu.model;

public class CommentInfo {
    private Integer commentId;

    private Integer commentUserId;

    private Integer targetUserId;

    private Integer articleId;

    private String commentContent;

    public CommentInfo(Integer commentId, Integer commentUserId, Integer targetUserId, Integer articleId, String commentContent) {
        this.commentId = commentId;
        this.commentUserId = commentUserId;
        this.targetUserId = targetUserId;
        this.articleId = articleId;
        this.commentContent = commentContent;
    }

    public CommentInfo() {
        super();
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getCommentUserId() {
        return commentUserId;
    }

    public void setCommentUserId(Integer commentUserId) {
        this.commentUserId = commentUserId;
    }

    public Integer getTargetUserId() {
        return targetUserId;
    }

    public void setTargetUserId(Integer targetUserId) {
        this.targetUserId = targetUserId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }
}
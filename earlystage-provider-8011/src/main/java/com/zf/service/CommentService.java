package com.zf.service;

import com.zf.entity.Article;
import com.zf.entity.Comment;

import java.util.List;

/**
 * 2021-01-13 10:35
 */
public interface CommentService {
    public Comment findById(Integer id);

    public Comment save(Comment comment);

    public Integer delete(Integer id);

    public List<Comment> getArticleAllCommentById(Integer id);

    public Long getArticleCommentNumById(Integer id);
}

package com.zf.service.impl;

import com.zf.dao.ArticleDao;
import com.zf.dao.CommentDao;
import com.zf.entity.Article;
import com.zf.entity.Comment;
import com.zf.service.ArticleService;
import com.zf.service.CommentService;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 2021-01-12 20:26
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentDao commentDao;

    public Comment findById(Integer id){
        Comment result = commentDao.findById(id).get();
        return result;
    }

    @Transactional
    @Rollback(false)
    public Comment save(Comment comment){
        Comment result = commentDao.save(comment);
        return result;
    }

    public Integer delete(Integer id){
        Integer result = commentDao.deleteComment(id);
        return result;
    }


}

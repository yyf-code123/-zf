package com.zf.service.impl;

import com.zf.dao.ArticleDao;
import com.zf.dao.CommentDao;
import com.zf.dao.ReplyDao;
import com.zf.dao.UserDao;
import com.zf.entity.Article;
import com.zf.entity.Comment;
import com.zf.entity.CommonResult;
import com.zf.entity.Reply;
import com.zf.service.ArticleService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2021-01-12 20:26
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleDao articleDao;

    @Resource
    CommentDao commentDao;

    @Resource
    ReplyDao replyDao;

    @Resource
    UserDao userDao;

    public Article findById(Integer id){
        Article result = articleDao.findById(id).get();
        return result;
    }

    @Transactional
    @Rollback(false)
    public Article save(Article article){
        Article result = articleDao.save(article);
        return result;
    }


    public Integer delete(Integer id){
        Integer result = articleDao.deleteArtilce(id);
        return result;
    }

    @Override
    public List<Article> getAllArticle() {
        return articleDao.findAll();
    }

    @Override
    public List<Article> getUserArticle(Integer userId) {
        return articleDao.findAllByUserId(userId);
    }

    @Override
    public List<Article> getArticleByTitle(String title) {
        return articleDao.findAllByTitleLike(title);
    }


}

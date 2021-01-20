package com.zf.service.impl;

import com.zf.dao.ArticleDao;
import com.zf.entity.Article;
import com.zf.service.ArticleService;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 2021-01-12 20:26
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleDao articleDao;

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
        Integer result = articleDao.deleteArticle(id);
        return result;
    }

    @Override
    public ArrayList<Article> getAllArticle() {
        return articleDao.getAllArticle();
    }
}

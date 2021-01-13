package com.zf.service.impl;

import com.zf.dao.ArticleDao;
import com.zf.entity.Article;
import com.zf.service.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    ArticleDao articleDao;


    public Article save(Article article){
        Article save = articleDao.save(article);
        return save;
    }

    public Article find(Integer id){
        return articleDao.findById(id).get();

    }
}

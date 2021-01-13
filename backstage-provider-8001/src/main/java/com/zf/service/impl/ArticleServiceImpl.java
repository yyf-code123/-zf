package com.zf.service.impl;

import com.zf.dao.ArticleDao;
import com.zf.entity.Article;
import com.zf.service.ArticleService;
<<<<<<< HEAD
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;

=======
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 2021-01-12 20:26
 */
>>>>>>> b1e461bde3d4952186c45c14330f3c1c875e8812
@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
<<<<<<< HEAD
    ArticleDao articleDao;


    public Article save(Article article){
        Article save = articleDao.save(article);
        return save;
    }

    public Article find(Integer id){
        return articleDao.findById(id).get();

    }
=======
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
        Integer result = articleDao.deleteArtilce(id);
        return result;
    }


>>>>>>> b1e461bde3d4952186c45c14330f3c1c875e8812
}

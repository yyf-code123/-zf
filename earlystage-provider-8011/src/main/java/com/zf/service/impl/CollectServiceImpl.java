package com.zf.service.impl;

import com.zf.dao.ArticleDao;
import com.zf.dao.CollectDao;
import com.zf.entity.Article;
import com.zf.entity.Collect;
import com.zf.service.ArticleService;
import com.zf.service.CollectService;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 2021-01-12 20:26
 */
@Service
public class CollectServiceImpl implements CollectService {

    @Resource
    private CollectDao collectDao;

    public Collect findById(Integer id){
       Collect  result = collectDao.findById(id).get();
        return result;
    }

    @Transactional
    @Rollback(false)
    public Collect save(Collect collect){
        Collect result = collectDao.save(collect);
        return result;
    }

    public Integer delete(Integer id){
        Integer result = collectDao.deleteCollect(id);
        return result;
    }

    @Override
    public Collect findByUserIdAndArticleId(Integer userId, Integer articleId) {
        return collectDao.findByUserIdAndArticleId(userId,articleId);
    }
}

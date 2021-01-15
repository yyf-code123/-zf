package com.zf.service.impl;

import com.zf.dao.ArticleDao;
import com.zf.dao.CollectCatalogDao;
import com.zf.entity.Article;
import com.zf.entity.CollectCatalog;
import com.zf.service.ArticleService;
import com.zf.service.CollectCatalogService;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 2021-01-12 20:26
 */
@Service
public class CollectCatalogServiceImpl implements CollectCatalogService {

    @Resource
    private CollectCatalogDao collectCatalogDao;

    public CollectCatalog findById(Integer id){
        CollectCatalog result = collectCatalogDao.findById(id).get();
        return result;
    }

    @Transactional
    @Rollback(false)
    public CollectCatalog save(CollectCatalog collectCatalog){
        CollectCatalog reult = collectCatalogDao.save(collectCatalog);
        return reult;
    }

    public Integer delete(Integer id){
        Integer result = collectCatalogDao.deleteCollectCatalog(id);
        return result;
    }


}

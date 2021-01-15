package com.zf.service.impl;

import com.zf.dao.ClassificationDao;
import com.zf.entity.Article;
import com.zf.entity.Classification;
import com.zf.service.ClassificationService;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 2021-01-13 10:40
 */
@Service
public class ClassificationServiceImpl implements ClassificationService {

    @Resource
    private ClassificationDao classificationDao;

    @Override
    public Classification findById(Integer id) {
        Classification classification = classificationDao.findById(id).get();
        return classification;
    }

    @Transactional
    @Rollback(false)
    @Override
    public Classification save(Classification classification) {
        Classification save = classificationDao.save(classification);
        return save;
    }

    @Override
    public Integer delete(Integer id) {
        Integer result = classificationDao.deleteClassification(id);
        return result;
    }
}

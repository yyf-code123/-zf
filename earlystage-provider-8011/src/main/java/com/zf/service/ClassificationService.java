package com.zf.service;

import com.zf.entity.Article;
import com.zf.entity.Classification;

import java.util.ArrayList;
import java.util.List;

/**
 * 2021-01-13 10:37
 */
public interface ClassificationService {
    public Classification findById(Integer id);

    public Classification save(Classification classification);

    public Integer delete(Integer id);

    public List<Classification> getAllClassification();
}

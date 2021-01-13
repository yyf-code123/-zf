package com.zf.service;

import com.zf.entity.Article;
import com.zf.entity.Collect;

/**
 * 2021-01-13 10:35
 */
public interface CollectService {
    public Collect findById(Integer id);

    public Collect save(Collect collect);

    public Integer delete(Integer id);
}

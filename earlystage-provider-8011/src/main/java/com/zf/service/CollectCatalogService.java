package com.zf.service;

import com.zf.entity.Article;
import com.zf.entity.CollectCatalog;

/**
 * 2021-01-13 10:35
 */
public interface CollectCatalogService {
    public CollectCatalog findById(Integer id);

    public CollectCatalog save(CollectCatalog collectCatalog);

    public Integer delete(Integer id);
}

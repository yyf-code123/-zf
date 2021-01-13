package com.zf.service;

import com.zf.entity.Article;

/**
 * 2021-01-13 10:35
 */
public interface ArticleService {
    public Article findById(Integer id);

    public Article save(Article article);

    public Integer delete(Integer id);
}

package com.zf.service;

<<<<<<< HEAD
import com.zf.dao.ArticleDao;
import com.zf.entity.Article;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

public interface ArticleService {

    public Article find(Integer id);

    public Article save(Article article);

=======
import com.zf.entity.Article;

/**
 * 2021-01-13 10:35
 */
public interface ArticleService {
    public Article findById(Integer id);

    public Article save(Article article);

    public Integer delete(Integer id);
>>>>>>> b1e461bde3d4952186c45c14330f3c1c875e8812
}

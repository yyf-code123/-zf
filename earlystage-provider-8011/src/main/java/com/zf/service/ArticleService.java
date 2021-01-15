package com.zf.service;


import com.zf.dao.ArticleDao;
import com.zf.entity.Article;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

public interface ArticleService {

    public Article findById(Integer id);

    public Article save(Article article);

    public Integer delete(Integer id);

}

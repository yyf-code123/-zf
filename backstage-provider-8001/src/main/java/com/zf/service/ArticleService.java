package com.zf.service;


import com.zf.dao.ArticleDao;
import com.zf.entity.Article;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface ArticleService {

    public Article findById(Integer id);

    public Article save(Article article);

    public Integer delete(Integer id);

    public ArrayList<Article> getAllArticle();
}

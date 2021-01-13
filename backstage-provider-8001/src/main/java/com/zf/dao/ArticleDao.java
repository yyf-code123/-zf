package com.zf.dao;

import com.zf.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

public interface ArticleDao extends JpaRepository<Article,Integer>, JpaSpecificationExecutor<Article> {


}

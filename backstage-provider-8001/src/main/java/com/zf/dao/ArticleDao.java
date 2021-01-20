package com.zf.dao;

import com.zf.entity.Article;
import com.zf.entity.CommonResult;
import com.zf.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface ArticleDao extends JpaRepository<Article,Integer>, JpaSpecificationExecutor<Article> {

    @Transactional
    @Rollback(false)
    @Modifying
    @Query(value = "delete from article where id =?1",nativeQuery = true)
    public Integer deleteArticle(Integer id);

    @Query(value = "select * from article", nativeQuery = true)
    public ArrayList<Article> getAllArticle();


}

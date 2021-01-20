package com.zf.dao;

import com.zf.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ArticleDao extends JpaRepository<Article,Integer>, JpaSpecificationExecutor<Article> {

    @Transactional
    @Rollback(false)
    @Modifying
    @Query(value = "delete from article where id =?1",nativeQuery = true)
    public Integer deleteArtilce(Integer id);


    @Query(value = "select * from Article order by id desc ",nativeQuery = true)
    public List<Article> findAll();

    public List<Article> findAllByUserId(Integer userId);

    public List<Article> findAllByTitleLike(String title);
}

package com.zf.dao;

import com.zf.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

public interface ArticleDao extends JpaRepository<Article,Integer>, JpaSpecificationExecutor<Article> {
    @Transactional
    @Rollback(false)
    @Modifying
    @Query(value = "delete from article where id =?1",nativeQuery = true)
    public Integer deleteArtilce(Integer id);

}

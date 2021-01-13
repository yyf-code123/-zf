package com.zf.dao;

import com.zf.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
<<<<<<< HEAD
import org.springframework.stereotype.Repository;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

public interface ArticleDao extends JpaRepository<Article,Integer>, JpaSpecificationExecutor<Article> {
=======
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 * 2021-01-12 20:22
 */
public interface ArticleDao extends JpaRepository<Article,Integer>, JpaSpecificationExecutor<Article> {

>>>>>>> b1e461bde3d4952186c45c14330f3c1c875e8812
    @Transactional
    @Rollback(false)
    @Modifying
    @Query(value = "delete from article where id =?1",nativeQuery = true)
    public Integer deleteArtilce(Integer id);
<<<<<<< HEAD

=======
>>>>>>> b1e461bde3d4952186c45c14330f3c1c875e8812
}

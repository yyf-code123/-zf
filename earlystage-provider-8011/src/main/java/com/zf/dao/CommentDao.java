package com.zf.dao;

import com.zf.entity.Article;
import com.zf.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 2021-01-12 20:22
 */
public interface CommentDao extends JpaRepository<Comment,Integer>, JpaSpecificationExecutor<Comment> {

    @Transactional
    @Rollback(false)
    @Modifying
    @Query(value = "delete from comment where id =?1",nativeQuery = true)
    public Integer deleteComment(Integer id);

    @Query(value = "select * from comment where article_id= ? order by id desc ",nativeQuery = true)
    public List<Comment> findAllById(Integer id);

    @Query(value = "select count(*) from comment where article_id= ?",nativeQuery = true)
    public Long getArticleCommentNum(Integer id);
}

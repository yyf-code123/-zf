package com.zf.dao;

import com.zf.entity.Thumb;
import com.zf.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

public interface ThumbDao extends JpaRepository<Thumb,Integer>, JpaSpecificationExecutor {

    @Query(value = "delete from Thumb where id = ?1")
    @Modifying
    @Transactional
    @Rollback(value = false)
    public Integer delete(Integer id);

    public Thumb findByCommentIdAndUserId(Integer id, Integer userId);

    public Thumb findByReplyIdAndUserId(Integer id, Integer fromUserId);
}

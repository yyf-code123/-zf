package com.zf.dao;

import com.zf.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.ArrayList;

public interface UserDao extends JpaRepository<User,Integer>, JpaSpecificationExecutor {

    @Query(value = "delete from user where id = ?1",nativeQuery = true)
    @Modifying
    @Transactional
    @Rollback(value = false)
    public Integer delete(Integer id);

    @Query(value = "select * from user ",nativeQuery = true)
    public ArrayList<User> findAll();

    @Query(value = "select user_nickname from user where id=?",nativeQuery = true)
    public String getUserNickNameById(Integer userId);

    public User findByUserPhone(String phone);

    @Query(value = "update user set user_article_auth=?1 where id=?2",nativeQuery = true)
    @Modifying
    @Transactional
    @Rollback(value = false)
    public void setUserPublishPermission(Integer userArticleAuth,Integer userId);

    @Query(value = "update user set user_comment_auth=?1 where id=?2",nativeQuery = true)
    @Modifying
    @Transactional
    @Rollback(value = false)
    void setUserModifyPermission(int i, Integer userId);
}

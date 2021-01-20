package com.zf.dao;

import com.zf.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.Optional;

public interface UserDao extends JpaRepository<User,Integer>, JpaSpecificationExecutor {

    @Query(value = "delete from user where id = ?1",nativeQuery = true)
    @Modifying
    @Transactional
    @Rollback(value = false)
    public Integer delete(Integer id);

    public User findByUserPhone(String userPhone);

    @Query(value = "select  * from user where user_phone = ?1",nativeQuery = true)
    public User findOne(Integer id);

    @Query(value = "select user_nickname from user where id=?",nativeQuery = true)
    public String getUserNameById(Integer UserId);

    @Query(value = "select user_image from user where id=?",nativeQuery = true)
    public String getUserImageById(Integer userId);
}

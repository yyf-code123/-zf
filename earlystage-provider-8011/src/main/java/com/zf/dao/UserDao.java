package com.zf.dao;

import com.zf.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

public interface UserDao extends JpaRepository<User,Integer>, JpaSpecificationExecutor {

    @Query(value = "delete from user where id = ?1",nativeQuery = true)
    @Modifying
    @Transactional
    @Rollback(value = false)
    public Integer delete(Integer id);


}

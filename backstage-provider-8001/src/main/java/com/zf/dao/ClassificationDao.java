package com.zf.dao;

import com.zf.entity.Article;
import com.zf.entity.Classification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 * 2021-01-12 20:22
 */
public interface ClassificationDao extends JpaRepository<Classification,Integer>, JpaSpecificationExecutor<Classification> {

    @Transactional
    @Rollback(false)
    @Modifying
    @Query(value = "delete from classification  where id =?1",nativeQuery = true)
    public Integer deleteClassification(Integer id);

    @Query(value = "select classification_name from classification where id=?",nativeQuery = true)
    public String getClassificationNameById(Integer id);
}

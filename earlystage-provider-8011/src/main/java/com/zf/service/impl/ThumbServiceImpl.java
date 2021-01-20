package com.zf.service.impl;

import com.zf.dao.ThumbDao;
import com.zf.dao.ThumbDao;
import com.zf.entity.Thumb;
import com.zf.service.ThumbService;
import jdk.nashorn.internal.runtime.Specialization;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.*;

@Service
public class ThumbServiceImpl implements ThumbService {

    @Resource
    ThumbDao thumbDao;

    @Override
    public Thumb findById(Integer id) {
        return thumbDao.findById(id).get();
    }

    @Override
    public Thumb save(Thumb thumb) {
        return thumbDao.save(thumb);
    }

    @Override
    public Thumb update(Thumb thumb) {
        return thumbDao.save(thumb);
    }

    @Override
    public Integer delete(Integer id) {
        return thumbDao.delete(id);
    }

   /* @Override
    public Long getThumbNumById(Integer id) {

        Specification<Thumb> thumbSpecification = new Specification<Thumb>(){
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {
                Path commentId = root.get("commentId");

                Predicate equal = criteriaBuilder.equal(commentId, id);
                return equal;
            }
        };
        return thumbDao.count(thumbSpecification);
    }*/

    public Long getThumbNumById(String condition,Integer id) {
        Specification<Thumb> thumbSpecification = new Specification<Thumb>(){
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {
                Path myCondition = root.get(condition);

                Predicate equal = criteriaBuilder.equal(myCondition, id);
                return equal;
            }
        };
        return thumbDao.count(thumbSpecification);
    }

    @Override
    public Thumb findByCommentIdAndUserId(Integer id, Integer userId) {
        return thumbDao.findByCommentIdAndUserId(id,userId);
    }

    @Override
    public Thumb findByReplyIdAndUserId(Integer id, Integer fromUserId) {
        return thumbDao.findByReplyIdAndUserId(id,fromUserId);
    }
}

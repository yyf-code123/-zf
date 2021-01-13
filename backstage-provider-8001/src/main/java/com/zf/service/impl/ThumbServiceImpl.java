package com.zf.service.impl;

import com.zf.dao.ThumbDao;
import com.zf.dao.ThumbDao;
import com.zf.entity.Thumb;
import com.zf.service.ThumbService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}

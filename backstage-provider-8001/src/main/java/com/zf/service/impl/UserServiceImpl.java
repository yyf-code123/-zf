package com.zf.service.impl;

import com.zf.entity.User;
import com.zf.dao.UserDao;
import com.zf.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserDao userDao;

    @Override
    public User findById(Integer id) {
        return userDao.findById(id).get();
    }

    @Override
    public User save(User user) {
        return userDao.save(user);
    }


    @Override
    public Integer delete(Integer id) {
        return userDao.delete(id);
    }
}

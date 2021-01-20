package com.zf.service.impl;

import com.zf.entity.User;
import com.zf.dao.UserDao;
import com.zf.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<User> getAllUser() {
        return userDao.findAll();
    }

    @Override
    public String getUserNickNameById(Integer userId) {
        return userDao.getUserNickNameById(userId);
    }

    @Override
    public User getUserByPhone(String phone) {
        return userDao.findByUserPhone(phone);
    }

    @Override
    public void setUserPublishPermission(Boolean publishPermission, Integer userId) {
        if(publishPermission.equals(true)){
            userDao.setUserPublishPermission(1,userId);
        }else {
            userDao.setUserPublishPermission(0,userId);

        }
    }

    @Override
    public void setUserModifyPermission(Boolean modifyPermission, Integer userId) {
        if(modifyPermission.equals(true)){
            userDao.setUserModifyPermission(1,userId);
        }else {
            userDao.setUserModifyPermission(0,userId);

        }
    }
}

package com.zf.service;

import com.zf.entity.User;
import org.springframework.data.jpa.repository.Query;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public interface UserService {

    public User findById(Integer id);

    public User save(User user);

    public Integer delete(Integer id);

    public List<User> getAllUser();

    public String getUserNickNameById(Integer userId);

    public  User getUserByPhone(String phone);

    public void setUserPublishPermission(Boolean publishPermission, Integer userId);

    public void setUserModifyPermission(Boolean modifyPermission, Integer userId);
}

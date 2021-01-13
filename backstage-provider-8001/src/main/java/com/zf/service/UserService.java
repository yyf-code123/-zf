package com.zf.service;

import com.zf.entity.User;
import org.springframework.data.jpa.repository.Query;

public interface UserService {

    public User findById(Integer id);

    public User save(User user);

    public Integer delete(Integer id);
}

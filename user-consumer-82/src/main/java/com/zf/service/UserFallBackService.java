package com.zf.service;

import com.zf.entity.CommonResult;
import com.zf.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserFallBackService implements UserService{


    @Override
    public CommonResult<User> getOne(Integer id) {
        return new CommonResult<>(410,"请求user的getOne出现错误请重试");
    }

    @Override
    public CommonResult<User> save(User user) {
        return new CommonResult<>(410,"请求user的save超时请重试");
    }

    @Override
    public CommonResult<User> update(User user) {
        return new CommonResult<>(410,"请求user的update超时请重试");
    }

    @Override
    public CommonResult<User> delete(Integer id) {
        return new CommonResult<>(410,"请求user的delete超时请重试");
    }
}

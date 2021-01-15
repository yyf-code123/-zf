package com.zf.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.zf.entity.CommonResult;
import com.zf.entity.User;
import com.zf.service.UserService;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer/user")
public class UserController {

    @Resource
    UserService userService;

    @GetMapping(value = "/getOne/{id}")
    @Cacheable(value = "user",key = "#id",unless = "#result==null")
    public CommonResult<User> getOne(@PathVariable("id") Integer id){
      /*  try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return userService.getOne(id);
    }

    @PostMapping(value = "/save")
    @CachePut(value = "user",key = "#id")
    public CommonResult<User> save(User user){
        return userService.save(user);
    }

    @PostMapping(value = "/update")
    public CommonResult<User> update(User user){
        return userService.save(user);

    }

    @RequestMapping(value = "/delete/{id}")
    public CommonResult<User> delete(@PathVariable("id") Integer id){
        return userService.delete(id);
    }


}

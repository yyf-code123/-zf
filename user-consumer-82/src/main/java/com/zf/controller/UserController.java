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
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/consumer/user")
public class UserController {

    @Resource
    UserService userService;



    @GetMapping(value = "/getOne/{phoneNum}")
    @Cacheable(value = "user",key = "#phoneNum",unless = "#result==null")
    public CommonResult<User> getOne(@PathVariable("phoneNum") String phoneNum){
      /*  try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return userService.getOne(phoneNum);
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

//    发送短信验证码
    @PostMapping("/sendRegisterMessage")
    public CommonResult<String> sendRegisterMessage(String phoneNum){
        return userService.sendRegisterMessage(phoneNum);
    }


//用户注册
    @PostMapping(value = "/register")
    public CommonResult<String> register(User user,String phone,String password){
        return userService.register(user,phone,password);
    }


//  验证注册验证码是否正确
    @PostMapping(value = "/verifyCode")
    public CommonResult<String> verifyCode(@RequestParam("phone") String phone,
                                           @RequestParam("code") String code){

       return userService.verifyCode(phone,code);

    }

}

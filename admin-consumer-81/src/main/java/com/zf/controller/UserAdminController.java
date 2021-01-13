package com.zf.controller;

import com.zf.entity.CommonResult;
import com.zf.entity.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class UserAdminController {

    @Resource
    RestTemplate restTemplate;

    public static final String BACKSTAGE_URL = "http://BACKSTAGE-PROVIDER-SERVICE";


    @GetMapping(value = "/consumer/user/getOne/{id}")
    public CommonResult<User> getOne(@PathVariable("id") Integer id){
        return restTemplate.getForObject(BACKSTAGE_URL+"/user/getOne/"+id,CommonResult.class);
    }

    @PostMapping(value = "/consumer/user/save")
    public CommonResult<User> save(User user){
        return  restTemplate.postForObject(BACKSTAGE_URL+"/user/save",user,CommonResult.class);
    }

    @PostMapping(value = "/consumer/user/update")
    public CommonResult<User> update(User user){
        System.out.println(user);
        return  restTemplate.postForObject(BACKSTAGE_URL+"/user/update",user,CommonResult.class);

    }

    @RequestMapping(value = "/consumer/user/delete/{id}")
    public CommonResult<User> delete(@PathVariable("id") Integer id){
        return  restTemplate.getForObject(BACKSTAGE_URL+"/user/delete/"+id,CommonResult.class);
    }
}

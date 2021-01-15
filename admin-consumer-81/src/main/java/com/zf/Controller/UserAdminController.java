package com.zf.controller;

import com.zf.entity.CommonResult;
import com.zf.entity.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer/admin/user")
public class UserAdminController {

    @Resource
    RestTemplate restTemplate;

    public static final String BACKSTAGE_URL = "http://BACKSTAGE-PROVIDER-SERVICE";


    @GetMapping(value = "/getOne/{id}")
    public CommonResult<User> getOne(@PathVariable("id") Integer id){
        return restTemplate.getForObject(BACKSTAGE_URL+"/admin/user/getOne/"+id,CommonResult.class);
    }

    @PostMapping(value = "/save")
    public CommonResult<User> save(User user){
        return  restTemplate.postForObject(BACKSTAGE_URL+"/admin/user/save",user,CommonResult.class);
    }

    @PostMapping(value = "/update")
    public CommonResult<User> update(User user){
        System.out.println(user);
        return  restTemplate.postForObject(BACKSTAGE_URL+"/admin/user/update",user,CommonResult.class);

    }

    @RequestMapping(value = "/delete/{id}")
    public CommonResult<User> delete(@PathVariable("id") Integer id){
        return  restTemplate.getForObject(BACKSTAGE_URL+"/admin/user/delete/"+id,CommonResult.class);
    }
}

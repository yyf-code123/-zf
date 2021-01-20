package com.zf.controller;

import com.zf.entity.CommonResult;
import com.zf.entity.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;

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

    @GetMapping(value = "/getAllUser")
    public CommonResult<ArrayList> getAllUser(){
        return  restTemplate.getForObject(BACKSTAGE_URL+"/admin/user/getAllUser",CommonResult.class);

    }

    @GetMapping(value = "/getUserByPhone")
    public CommonResult<HashMap> getUserByPhone(String phone){
        return  restTemplate.getForObject(BACKSTAGE_URL+"/admin/user/getUserByPhone?phone="+phone,CommonResult.class);

    }

    @GetMapping(value = "/setUserPublishPermission")
    public CommonResult<HashMap> setUserPublishPermission(Boolean publishPermission,Integer userId){
        return  restTemplate.getForObject(BACKSTAGE_URL+
                "/admin/user/setUserPublishPermission?publishPermission="+publishPermission
                +"&userId="+userId,CommonResult.class);
    }

    @GetMapping(value = "/setUserCommentPermission")
    public CommonResult<HashMap> setUserCommentPermission(Boolean commentPermission,Integer userId){
        return  restTemplate.getForObject(BACKSTAGE_URL+
                "/admin/user/setUserCommentPermission?commentPermission="+commentPermission
                +"&userId="+userId,CommonResult.class);
    }
}

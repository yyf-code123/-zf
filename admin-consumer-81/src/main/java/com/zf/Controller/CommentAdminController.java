package com.zf.controller;


import com.zf.entity.Comment;
import com.zf.entity.CommonResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 2021-01-13 15:20
 */
@RestController
@RequestMapping("/consumer/admin/comment")
public class CommentAdminController {
    public final static String PAYMENT_URL="http://BACKSTAGE-PROVIDER-SERVICE";


    @Resource
    private RestTemplate restTemplate;


    @GetMapping("/get/{id}")
    public CommonResult<Comment> get(@PathVariable(value = "id")Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/admin/comment/get/"+id, CommonResult.class);
    }

    @PostMapping("/save")
    public CommonResult<Comment> save(Comment comment){
        return restTemplate.postForObject(PAYMENT_URL+"/admin/comment/save",comment,CommonResult.class);
    }

    @GetMapping("/delete/{id}")
    public CommonResult<Comment> delete(@PathVariable(value = "id")Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/admin/comment/delete/"+id, CommonResult.class);
    }

}

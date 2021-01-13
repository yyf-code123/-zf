package com.zf.controller;

import com.zf.entity.Article;
import com.zf.entity.Comment;
import com.zf.entity.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 2021-01-13 15:20
 */
@RestController
public class CommentAdminController {
    public final static String PAYMENT_URL="http://BACKSTARGE-PROVIDER-SERVICE";


    @Resource
    private RestTemplate restTemplate;


    @GetMapping("/consumer/comment/get/{id}")
    public CommonResult<Comment> get(@PathVariable(value = "id")Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/comment/get/"+id, CommonResult.class);
    }

    @PostMapping("/consumer/comment/save")
    public CommonResult<Comment> save(Comment comment){
        return restTemplate.postForObject(PAYMENT_URL+"/comment/save",comment,CommonResult.class);
    }

    @GetMapping("/consumer/comment/delete/{id}")
    public CommonResult<Comment> delete(@PathVariable(value = "id")Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/comment/delete/"+id, CommonResult.class);
    }

}

package com.zf.controller;

import com.netflix.discovery.DiscoveryClient;
import com.zf.entity.Article;
import com.zf.entity.CommonResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 2021-01-12 21:34
 */
@RestController
public class articleAdminController {

    public final static String PAYMENT_URL="http://BACKSTARGE-PROVIDER-SERVICE";


    @Resource
    private RestTemplate restTemplate;


    @GetMapping("/consumer/article/get/{id}")
    public CommonResult<Article> get(@PathVariable(value = "id")Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/article/get/"+id, CommonResult.class);
    }

    @PostMapping("/consumer/article/save")
    public CommonResult<Article> save(Article article){
        return restTemplate.postForObject(PAYMENT_URL+"/article/save",article,CommonResult.class);
    }

    @GetMapping("/consumer/article/delete/{id}")
    public CommonResult<Article> delete(@PathVariable(value = "id")Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/article/delete/"+id, CommonResult.class);
    }

}

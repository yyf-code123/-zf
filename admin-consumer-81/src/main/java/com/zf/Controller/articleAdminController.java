package com.zf.controller;

import com.netflix.discovery.DiscoveryClient;
import com.zf.entity.Article;
import com.zf.entity.CommonResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * 2021-01-12 21:34
 */
@RestController
@RequestMapping("/consumer/admin/article")
public class ArticleAdminController {

    public final static String PAYMENT_URL="http://BACKSTAGE-PROVIDER-SERVICE";

    @Resource
    private RestTemplate restTemplate;


    @GetMapping("/get/{id}")
    public CommonResult<Article> get(@PathVariable(value = "id")Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/admin/article/get/"+id, CommonResult.class);
    }

    @PostMapping("/save")
    public CommonResult<Article> save(Article article){
        return restTemplate.postForObject(PAYMENT_URL+"/admin/article/save",article,CommonResult.class);
    }

    @GetMapping("/delete/{id}")
    public CommonResult<Article> delete(@PathVariable(value = "id")Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/admin/article/delete/"+id, CommonResult.class);
    }

    @GetMapping("/getAllArticle")
    public CommonResult<HashMap> getAllArticle(){
        return restTemplate.getForObject(PAYMENT_URL+"/admin/article/getAllArticle", CommonResult.class);
    }
}

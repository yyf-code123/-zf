package com.zf.Controller;

import com.zf.entity.Article;
import com.zf.entity.CommonResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ArticleAdminController {

    @Resource
    RestTemplate restTemplate;

   // public static final String BACKSTAGE_URL = "http://localhost:8001";

    public static final String BACKSTAGE_URL = "http://BACKSTAGE-PROVIDER-SERVICE";

    @GetMapping(value = "/consumer/get/{id}")
    public CommonResult<Article> find(@PathVariable("id") Integer id){
        return restTemplate.getForObject(BACKSTAGE_URL+"/get/"+id,CommonResult.class);
    }

    @PostMapping(value = "/consumer/save")
    public CommonResult<Article> save(Article article){
        System.out.println(article);
        return  restTemplate.postForObject(BACKSTAGE_URL+"/save",article,CommonResult.class);
    }

}

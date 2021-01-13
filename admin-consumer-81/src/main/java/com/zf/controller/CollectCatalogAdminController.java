package com.zf.controller;

import com.zf.entity.Article;
import com.zf.entity.CollectCatalog;
import com.zf.entity.Comment;
import com.zf.entity.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 2021-01-13 15:17
 */
@RestController
public class CollectCatalogAdminController {
    public final static String PAYMENT_URL="http://BACKSTARGE-PROVIDER-SERVICE";


    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/collectCatalog/get/{id}")
    public CommonResult<CollectCatalog> get(@PathVariable(value = "id")Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/collectCatalog/get/"+id, CommonResult.class);
    }

    @PostMapping("/consumer/collectCatalog/save")
    public CommonResult<CollectCatalog> save(CollectCatalog collectCatalog){
        return restTemplate.postForObject(PAYMENT_URL+"/collectCatalog/save",collectCatalog,CommonResult.class);
    }

    @GetMapping("/consumer/collectCatalog/delete/{id}")
    public CommonResult<CollectCatalog> delete(@PathVariable(value = "id")Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/collectCatalog/delete/"+id, CommonResult.class);
    }
}

package com.zf.controller;

import com.zf.entity.Article;
import com.zf.entity.CollectCatalog;
import com.zf.entity.Comment;
import com.zf.entity.CommonResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 2021-01-13 15:17
 */
@RestController
@RequestMapping("/consumer/admin/collectCatalog")
public class CollectCatalogAdminController {
    public final static String PAYMENT_URL="http://BACKSTAGE-PROVIDER-SERVICE";


    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/get/{id}")
    public CommonResult<CollectCatalog> get(@PathVariable(value = "id")Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/admin/collectCatalog/get/"+id, CommonResult.class);
    }

    @PostMapping("/save")
    public CommonResult<CollectCatalog> save(CollectCatalog collectCatalog){
        return restTemplate.postForObject(PAYMENT_URL+"/admin/collectCatalog/save",collectCatalog,CommonResult.class);
    }

    @GetMapping("/delete/{id}")
    public CommonResult<CollectCatalog> delete(@PathVariable(value = "id")Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/admin/collectCatalog/delete/"+id, CommonResult.class);
    }
}

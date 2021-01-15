package com.zf.controller;

import com.zf.entity.Article;
import com.zf.entity.Collect;
import com.zf.entity.CommonResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 2021-01-13 15:35
 */
@RestController
@RequestMapping("/consumer/admin/collect")
public class CollectAdminController {

    public final static String PAYMENT_URL="http://BACKSTAGE-PROVIDER-SERVICE";


    @Resource
    private RestTemplate restTemplate;


    @GetMapping("/get/{id}")
    public CommonResult<Collect> get(@PathVariable(value = "id")Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/admin/collect/get/"+id, CommonResult.class);
    }

    @PostMapping("/save")
    public CommonResult<Collect> save(Collect collect){
        return restTemplate.postForObject(PAYMENT_URL+"/admin/collect/save",collect,CommonResult.class);
    }

    @GetMapping("/delete/{id}")
    public CommonResult<Collect> delete(@PathVariable(value = "id")Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/admin/collect/delete/"+id, CommonResult.class);
    }
}

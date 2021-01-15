package com.zf.controller;

import com.zf.entity.Article;
import com.zf.entity.Classification;
import com.zf.entity.CommonResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 2021-01-13 15:10
 */
@RestController
@RequestMapping("/consumer/admin/classification")
public class ClassificationAdminController {

    public final static String PAYMENT_URL="http://BACKSTAGE-PROVIDER-SERVICE";


    @Resource
    private RestTemplate restTemplate;


    @GetMapping("/get/{id}")
    public CommonResult<Classification> get(@PathVariable(value = "id")Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/admin/classification/get/"+id, CommonResult.class);
    }

    @PostMapping("/save")
    public CommonResult<Classification> save(Classification classification){
        return restTemplate.postForObject(PAYMENT_URL+"/admin/classification/save",classification,CommonResult.class);
    }

    @GetMapping("/delete/{id}")
    public CommonResult<Classification> delete(@PathVariable(value = "id")Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/admin/classification/delete/"+id, CommonResult.class);
    }
}

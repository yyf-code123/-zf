package com.zf.controller;

import com.zf.entity.Article;
import com.zf.entity.Classification;
import com.zf.entity.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 2021-01-13 15:10
 */
@RestController
public class ClassificationAdminController {

    public final static String PAYMENT_URL="http://BACKSTARGE-PROVIDER-SERVICE";


    @Resource
    private RestTemplate restTemplate;


    @GetMapping("/consumer/classification/get/{id}")
    public CommonResult<Classification> get(@PathVariable(value = "id")Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/classification/get/"+id, CommonResult.class);
    }

    @PostMapping("/consumer/classification/save")
    public CommonResult<Classification> save(Classification classification){
        return restTemplate.postForObject(PAYMENT_URL+"/classification/save",classification,CommonResult.class);
    }

    @GetMapping("/consumer/classification/delete/{id}")
    public CommonResult<Classification> delete(@PathVariable(value = "id")Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/classification/delete/"+id, CommonResult.class);
    }
}

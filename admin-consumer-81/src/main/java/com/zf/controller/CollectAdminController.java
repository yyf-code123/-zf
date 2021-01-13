package com.zf.controller;

import com.zf.entity.Article;
import com.zf.entity.Collect;
import com.zf.entity.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 2021-01-13 15:35
 */
@RestController
public class CollectAdminController {

    public final static String PAYMENT_URL="http://BACKSTARGE-PROVIDER-SERVICE";


    @Resource
    private RestTemplate restTemplate;


    @GetMapping("/consumer/collect/get/{id}")
    public CommonResult<Collect> get(@PathVariable(value = "id")Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/collect/get/"+id, CommonResult.class);
    }

    @PostMapping("/consumer/collect/save")
    public CommonResult<Collect> save(Collect collect){
        return restTemplate.postForObject(PAYMENT_URL+"/collect/save",collect,CommonResult.class);
    }

    @GetMapping("/consumer/collect/delete/{id}")
    public CommonResult<Collect> delete(@PathVariable(value = "id")Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/collect/delete/"+id, CommonResult.class);
    }
}

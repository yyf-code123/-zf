package com.zf.controller;

import com.zf.entity.CommonResult;
import com.zf.entity.Thumb;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer/admin/thumb")
public class ThumbAdminController {

    @Resource
    RestTemplate restTemplate;

    public static final String BACKSTAGE_URL = "http://BACKSTAGE-PROVIDER-SERVICE";


    @GetMapping(value = "/getOne/{id}")
    public CommonResult<Thumb> getOne(@PathVariable("id") Integer id){
        return restTemplate.getForObject(BACKSTAGE_URL+"/admin/thumb/getOne/"+id,CommonResult.class);
    }

    @PostMapping(value = "/save")
    public CommonResult<Thumb> save(Thumb thumb){
        return  restTemplate.postForObject(BACKSTAGE_URL+"/admin/thumb/save",thumb,CommonResult.class);
    }

    @PostMapping(value = "/update")
    public CommonResult<Thumb> update(Thumb thumb){
        System.out.println(thumb);
        return  restTemplate.postForObject(BACKSTAGE_URL+"/admin/thumb/update",thumb,CommonResult.class);

    }

    @RequestMapping(value = "/delete/{id}")
    public CommonResult<Thumb> delete(@PathVariable("id") Integer id){
        return  restTemplate.getForObject(BACKSTAGE_URL+"/admin/thumb/delete/"+id,CommonResult.class);
    }
}

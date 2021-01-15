package com.zf.controller;

import com.zf.entity.CommonResult;
import com.zf.entity.Reply;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer/admin/reply")
public class ReplyAdminController {

    @Resource
    RestTemplate restTemplate;

    public static final String BACKSTAGE_URL = "http://BACKSTAGE-PROVIDER-SERVICE";


    @GetMapping(value = "/getOne/{id}")
    public CommonResult<Reply> getOne(@PathVariable("id") Integer id){
        return restTemplate.getForObject(BACKSTAGE_URL+"/admin/reply/getOne/"+id,CommonResult.class);
    }

    @PostMapping(value = "/save")
    public CommonResult<Reply> save(Reply reply){
        return  restTemplate.postForObject(BACKSTAGE_URL+"/admin/reply/save",reply,CommonResult.class);
    }

    @PostMapping(value = "/update")
    public CommonResult<Reply> update(Reply reply){
        System.out.println(reply);
        return  restTemplate.postForObject(BACKSTAGE_URL+"/admin/reply/update",reply,CommonResult.class);

    }

    @RequestMapping(value = "/delete/{id}")
    public CommonResult<Reply> delete(@PathVariable("id") Integer id){
        return  restTemplate.getForObject(BACKSTAGE_URL+"/admin/reply/delete/"+id,CommonResult.class);
    }
}

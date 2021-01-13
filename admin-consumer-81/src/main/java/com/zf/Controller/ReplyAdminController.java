package com.zf.Controller;

import com.zf.entity.CommonResult;
import com.zf.entity.Reply;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ReplyAdminController {

    @Resource
    RestTemplate restTemplate;

    public static final String BACKSTAGE_URL = "http://BACKSTAGE-PROVIDER-SERVICE";


    @GetMapping(value = "/consumer/reply/getOne/{id}")
    public CommonResult<Reply> getOne(@PathVariable("id") Integer id){
        return restTemplate.getForObject(BACKSTAGE_URL+"/reply/getOne/"+id,CommonResult.class);
    }

    @PostMapping(value = "/consumer/reply/save")
    public CommonResult<Reply> save(Reply reply){
        return  restTemplate.postForObject(BACKSTAGE_URL+"/reply/save",reply,CommonResult.class);
    }

    @PostMapping(value = "/consumer/reply/update")
    public CommonResult<Reply> update(Reply reply){
        System.out.println(reply);
        return  restTemplate.postForObject(BACKSTAGE_URL+"/reply/update",reply,CommonResult.class);

    }

    @RequestMapping(value = "/consumer/reply/delete/{id}")
    public CommonResult<Reply> delete(@PathVariable("id") Integer id){
        return  restTemplate.getForObject(BACKSTAGE_URL+"/reply/delete/"+id,CommonResult.class);
    }
}

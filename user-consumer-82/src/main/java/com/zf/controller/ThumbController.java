package com.zf.controller;

import com.zf.entity.CommonResult;
import com.zf.entity.Thumb;
import com.zf.service.ThumbService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer/thumb")
public class ThumbController {

    @Resource
    ThumbService thumbService;

    @GetMapping(value = "/getOne/{id}")
    @Cacheable(value = "thumb",key = "#id",unless = "#result==null")
    public CommonResult<Thumb> getOne(@PathVariable("id") Integer id){
        return thumbService.getOne(id);
    }


    @PostMapping(value = "/save")
    public CommonResult<Thumb> save(Thumb thumb){
        return thumbService.save(thumb);
    }

    @PostMapping(value = "/update")
    public CommonResult<Thumb> update(Thumb thumb){
        return thumbService.save(thumb);

    }

    @RequestMapping(value = "/delete/{id}")
    public CommonResult<Thumb> delete(@PathVariable("id") Integer id){

        return thumbService.delete(id);
    }


}

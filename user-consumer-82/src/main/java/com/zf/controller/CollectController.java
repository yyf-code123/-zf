package com.zf.controller;

import com.zf.entity.CommonResult;
import com.zf.entity.Collect;
import com.zf.service.CollectService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer/collect")
public class CollectController {

    @Resource
    CollectService collectService;

    @GetMapping(value = "/getOne/{id}")
    public CommonResult<Collect> getOne(@PathVariable("id") Integer id){
        return collectService.getOne(id);
    }


    @PostMapping(value = "/save")
    public CommonResult<Collect> save(Collect collect){
        return collectService.save(collect);
    }

    @PostMapping(value = "/update")
    public CommonResult<Collect> update(Collect collect){
        return collectService.save(collect);

    }

    @RequestMapping(value = "/delete/{id}")
    public CommonResult<Collect> delete(@PathVariable("id") Integer id){

        return collectService.delete(id);
    }


}

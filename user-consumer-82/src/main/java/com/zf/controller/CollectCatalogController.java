package com.zf.controller;

import com.zf.entity.CommonResult;
import com.zf.entity.CollectCatalog;
import com.zf.service.CollectCatalogService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer/collectCatalog")
public class CollectCatalogController {

    @Resource
    CollectCatalogService collectCatalogService;

    @GetMapping(value = "/getOne/{id}")
    public CommonResult<CollectCatalog> getOne(@PathVariable("id") Integer id){
        return collectCatalogService.getOne(id);
    }


    @PostMapping(value = "/save")
    public CommonResult<CollectCatalog> save(CollectCatalog collectCatalog){
        return collectCatalogService.save(collectCatalog);
    }

    @PostMapping(value = "/update")
    public CommonResult<CollectCatalog> update(CollectCatalog collectCatalog){
        return collectCatalogService.save(collectCatalog);

    }

    @RequestMapping(value = "/delete/{id}")
    public CommonResult<CollectCatalog> delete(@PathVariable("id") Integer id){

        return collectCatalogService.delete(id);
    }


}

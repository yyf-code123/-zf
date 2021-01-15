package com.zf.service;

import com.zf.entity.CollectCatalog;
import com.zf.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "EARLYSTAGE-PROVIDER-SERVICE")
@Service
public interface CollectCatalogService {
    @GetMapping(value = "/collectCatalog/get/{id}")
    public CommonResult<CollectCatalog> getOne(@PathVariable("id") Integer id);


    @PostMapping(value = "/collectCatalog/save")
    public CommonResult<CollectCatalog> save(@RequestBody CollectCatalog collectCatalog);

    @PostMapping(value = "/collectCatalog/update")
    public CommonResult<CollectCatalog> update(@RequestBody CollectCatalog collectCatalog);

    @RequestMapping(value = "/collectCatalog/delete/{id}")
    public CommonResult<CollectCatalog> delete(@PathVariable("id") Integer id);

}

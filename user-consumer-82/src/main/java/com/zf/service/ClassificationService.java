package com.zf.service;

import com.zf.entity.Classification;
import com.zf.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "EARLYSTAGE-PROVIDER-SERVICE")
@Service
public interface ClassificationService {
    @GetMapping(value = "/classification/get/{id}")
    public CommonResult<Classification> getOne(@PathVariable("id") Integer id);


    @PostMapping(value = "/classification/save")
    public CommonResult<Classification> save(@RequestBody Classification classification);

    @PostMapping(value = "/classification/update")
    public CommonResult<Classification> update(@RequestBody Classification classification);

    @RequestMapping(value = "/classification/delete/{id}")
    public CommonResult<Classification> delete(@PathVariable("id") Integer id);

}

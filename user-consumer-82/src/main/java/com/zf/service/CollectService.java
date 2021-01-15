package com.zf.service;

import com.zf.entity.CommonResult;
import com.zf.entity.Collect;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "EARLYSTAGE-PROVIDER-SERVICE")
@Service
public interface CollectService {
    @GetMapping(value = "/collect/get/{id}")
    public CommonResult<Collect> getOne(@PathVariable("id") Integer id);


    @PostMapping(value = "/collect/save")
    public CommonResult<Collect> save(@RequestBody Collect collect);

    @PostMapping(value = "/collect/update")
    public CommonResult<Collect> update(@RequestBody Collect collect);

    @RequestMapping(value = "/collect/delete/{id}")
    public CommonResult<Collect> delete(@PathVariable("id") Integer id);

}

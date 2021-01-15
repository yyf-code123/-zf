package com.zf.service;

import com.zf.entity.CommonResult;
import com.zf.entity.Reply;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "EARLYSTAGE-PROVIDER-SERVICE")
@Service
public interface ReplyService {
    @GetMapping(value = "/reply/getOne/{id}")
    public CommonResult<Reply> getOne(@PathVariable("id") Integer id);


    @PostMapping(value = "/reply/save")
    public CommonResult<Reply> save(@RequestBody Reply reply);

    @PostMapping(value = "/reply/update")
    public CommonResult<Reply> update(@RequestBody Reply reply);

    @RequestMapping(value = "/reply/delete/{id}")
    public CommonResult<Reply> delete(@PathVariable("id") Integer id);

}

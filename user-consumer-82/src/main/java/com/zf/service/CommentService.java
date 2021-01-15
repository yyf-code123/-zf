package com.zf.service;

import com.zf.entity.CommonResult;
import com.zf.entity.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "EARLYSTAGE-PROVIDER-SERVICE")
@Service
public interface CommentService {
    @GetMapping(value = "/comment/get/{id}")
    public CommonResult<Comment> getOne(@PathVariable("id") Integer id);


    @PostMapping(value = "/comment/save")
    public CommonResult<Comment> save(@RequestBody Comment comment);

    @PostMapping(value = "/comment/update")
    public CommonResult<Comment> update(@RequestBody Comment comment);

    @RequestMapping(value = "/comment/delete/{id}")
    public CommonResult<Comment> delete(@PathVariable("id") Integer id);

}

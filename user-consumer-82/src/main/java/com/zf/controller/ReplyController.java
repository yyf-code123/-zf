package com.zf.controller;

import com.zf.entity.CommonResult;
import com.zf.entity.Reply;
import com.zf.service.ReplyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer/reply")
public class ReplyController {

    @Resource
    ReplyService replyService;

    @GetMapping(value = "/getOne/{id}")
    public CommonResult<Reply> getOne(@PathVariable("id") Integer id){
        return replyService.getOne(id);
    }


    @PostMapping(value = "/save")
    public CommonResult<Reply> save(Reply reply){
        return replyService.save(reply);
    }

    @PostMapping(value = "/update")
    public CommonResult<Reply> update(Reply reply){
        return replyService.save(reply);

    }

    @RequestMapping(value = "/delete/{id}")
    public CommonResult<Reply> delete(@PathVariable("id") Integer id){

        return replyService.delete(id);
    }


}

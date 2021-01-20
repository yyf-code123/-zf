package com.zf.controller;

import com.zf.dao.ReplyDao;
import com.zf.entity.CommonResult;
import com.zf.entity.Reply;
import com.zf.service.ReplyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/reply")
public class ReplyController {

    @Resource
    ReplyService replyService;

    @Resource
    ReplyDao replyDao;

    @GetMapping(value = "/getOne/{id}")
    public CommonResult<Reply> getOne(@PathVariable("id") Integer id){
        Reply reply = replyDao.findById(id).get();
        return new CommonResult<>(200,"查询成功",reply);
    }

    @PostMapping(value = "/save")
    public CommonResult<Reply> save(@RequestBody Reply reply){
        System.out.println(replyService.save(reply));
        return new CommonResult<>(200,"回复成功");
    }

    @PostMapping(value = "/update")
    public CommonResult<Reply> update(@RequestBody Reply reply){
        System.out.println(replyService.save(reply));
        return new CommonResult<>(200,"修改成功");
    }

    @RequestMapping(value = "/delete/{id}")
    public CommonResult<Reply> delete(@PathVariable("id") Integer id){
        replyService.delete(id);
        return new CommonResult<>(200,"删除成功");
    }

}

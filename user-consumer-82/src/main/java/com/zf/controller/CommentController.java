package com.zf.controller;

import com.zf.entity.CommonResult;
import com.zf.entity.Comment;
import com.zf.service.CommentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer/comment")
public class CommentController {

    @Resource
    CommentService commentService;

    @GetMapping(value = "/getOne/{id}")
    public CommonResult<Comment> getOne(@PathVariable("id") Integer id){
        return commentService.getOne(id);
    }


    @PostMapping(value = "/save")
    public CommonResult<Comment> save(Comment comment){
        return commentService.save(comment);
    }

    @PostMapping(value = "/update")
    public CommonResult<Comment> update(Comment comment){
        return commentService.save(comment);

    }

    @RequestMapping(value = "/delete/{id}")
    public CommonResult<Comment> delete(@PathVariable("id") Integer id){

        return commentService.delete(id);
    }


}

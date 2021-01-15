package com.zf.controller;

import com.zf.entity.Collect;
import com.zf.entity.Comment;
import com.zf.entity.CommonResult;
import com.zf.service.CollectService;
import com.zf.service.CommentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 2021-01-13 11:29
 */
@RestController
@RequestMapping("/admin/comment")
public class CommentController {
    @Resource
    private CommentService commentService;

    @GetMapping("/get/{id}")
    public CommonResult get(@PathVariable("id") Integer id){
        Comment result = commentService.findById(id);
        return new CommonResult(200,"查询成功",result);
    }

    @PostMapping("/save")
    public CommonResult save(@RequestBody Comment comment){
        Comment result = commentService.save(comment);
        if(null!=result) {
            return new CommonResult(200, "更新成功", result);
        }else{
            return new CommonResult(404,"更新失败");
        }
    }

    @GetMapping("/delete/{id}")
    public CommonResult delete(@PathVariable("id") Integer id){
        Integer result = commentService.delete(id);
        if (result>0) {
            return new CommonResult(200, "删除成功");
        }else{
            return new CommonResult(404, "删除失败");
        }
    }
}

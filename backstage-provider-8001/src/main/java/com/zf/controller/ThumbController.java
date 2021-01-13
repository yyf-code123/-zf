package com.zf.controller;

import com.zf.entity.CommonResult;
import com.zf.entity.Thumb;
import com.zf.service.ThumbService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class ThumbController {

    @Resource
    ThumbService thumbService;

    @GetMapping(value = "/thumb/getOne/{id}")
    public CommonResult<Thumb> getOne(@PathVariable("id") Integer id){
        Thumb thumb = thumbService.findById(id);
        return new CommonResult<>(200,"查询成功",thumb);
    }

    @PostMapping(value = "/thumb/save")
    public CommonResult<Thumb> save(@RequestBody Thumb thumb){
        System.out.println(thumbService.save(thumb));
        return new CommonResult<>(200,"点赞成功");
    }

    @PostMapping(value = "/thumb/update")
    public CommonResult<Thumb> update(@RequestBody Thumb thumb){
        System.out.println(thumbService.save(thumb));
        return new CommonResult<>(200,"修改成功");
    }

    @RequestMapping(value = "/thumb/delete/{id}")
    public CommonResult<Thumb> delete(@PathVariable("id") Integer id){
        thumbService.delete(id);
        return new CommonResult<>(200,"删除成功");
    }
}

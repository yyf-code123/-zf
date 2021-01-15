package com.zf.controller;


import com.zf.entity.Article;
import com.zf.entity.CommonResult;
import com.zf.service.ArticleService;
import com.zf.service.impl.ArticleServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 2021-01-12 20:20
 */
@RestController
@RequestMapping("/admin/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @GetMapping("/get/{id}")
    public CommonResult get(@PathVariable("id") Integer id){
        Article result = articleService.findById(id);
        return new CommonResult(200,"查询成功",result);
    }

    @PostMapping("/save")
    public CommonResult save(@RequestBody Article article){
        Article save = articleService.save(article);
        if(null!=save) {
            return new CommonResult(200, "更新成功", save);
        }else{
            return new CommonResult(404,"更新失败");
        }
    }

    @GetMapping("/delete/{id}")
    public CommonResult delete(@PathVariable("id") Integer id){
        Integer result = articleService.delete(id);
        if (result>0) {
            return new CommonResult(200, "删除成功");
        }else{
            return new CommonResult(404, "删除失败");
        }
    }

}

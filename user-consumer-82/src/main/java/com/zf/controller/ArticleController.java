package com.zf.controller;

import com.zf.entity.CommonResult;
import com.zf.entity.Article;
import com.zf.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer/article")
public class ArticleController {

    @Resource
    ArticleService articleService;

    @GetMapping(value = "/getOne/{id}")
    public CommonResult<Article> getOne(@PathVariable("id") Integer id){
        return articleService.getOne(id);
    }


    @PostMapping(value = "/save")
    public CommonResult<Article> save(Article article){
        return articleService.save(article);
    }

    @PostMapping(value = "/update")
    public CommonResult<Article> update(Article article){
        return articleService.save(article);

    }

    @RequestMapping(value = "/delete/{id}")
    public CommonResult<Article> delete(@PathVariable("id") Integer id){

        return articleService.delete(id);
    }


}

package com.zf.controller;

import com.zf.entity.CommonResult;
import com.zf.entity.Article;
import com.zf.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

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

    @GetMapping("/getAllArticle")
    public CommonResult<HashMap> getAllArticle(){
        return articleService.getAllArticle();
    }

    @GetMapping("/getUserArticle/{userId}")
    public CommonResult<HashMap> getUserArticle(@PathVariable("userId") Integer userId){
        return articleService.getUserArticle(userId);
    }

    @GetMapping("/getArticleByTitle")
    public CommonResult<HashMap> getArticleByTitle(@RequestParam("title") String title){
        return articleService.getArticleByTitle(title);
    }
}

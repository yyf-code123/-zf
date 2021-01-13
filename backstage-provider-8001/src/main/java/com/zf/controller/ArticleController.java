package com.zf.controller;

import com.zf.dao.ArticleDao;
import com.zf.entity.Article;
import com.zf.entity.CommonResult;
import com.zf.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ArticleController {

    @Resource
    ArticleService articleService;

    @GetMapping(value = "/get/{id}")
    public CommonResult<Article> find(@PathVariable("id") Integer id){
        Article article = articleService.find(id);
        return new CommonResult<>(200,"查询成功",article);
    }

    @PostMapping(value = "/save")
    public CommonResult<Article> save(Article article){
        System.out.println(articleService.save(article));
        return new CommonResult<>(200,"添加成功");
    }
}

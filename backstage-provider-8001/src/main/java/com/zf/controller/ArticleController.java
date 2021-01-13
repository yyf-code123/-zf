package com.zf.controller;

<<<<<<< HEAD
import com.zf.dao.ArticleDao;
import com.zf.entity.Article;
import com.zf.entity.CommonResult;
import com.zf.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

=======

import com.zf.entity.Article;
import com.zf.entity.CommonResult;
import com.zf.service.ArticleService;
import com.zf.service.impl.ArticleServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 2021-01-12 20:20
 */
>>>>>>> b1e461bde3d4952186c45c14330f3c1c875e8812
@RestController
public class ArticleController {

    @Resource
<<<<<<< HEAD
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
=======
    private ArticleService articleService;

    @GetMapping("/article/get/{id}")
    public CommonResult get(@PathVariable("id") Integer id){
        Article result = articleService.findById(id);
        return new CommonResult(200,"查询成功",result);
    }

    @PostMapping("/article/save")
    public CommonResult save(@RequestBody Article article){
        Article save = articleService.save(article);
        if(null!=save) {
            return new CommonResult(200, "更新成功", save);
        }else{
            return new CommonResult(404,"更新失败");
        }
    }

    @GetMapping("/article/delete/{id}")
    public CommonResult delete(@PathVariable("id") Integer id){
        Integer result = articleService.delete(id);
        if (result>0) {
            return new CommonResult(200, "删除成功");
        }else{
            return new CommonResult(404, "删除失败");
        }
    }

>>>>>>> b1e461bde3d4952186c45c14330f3c1c875e8812
}

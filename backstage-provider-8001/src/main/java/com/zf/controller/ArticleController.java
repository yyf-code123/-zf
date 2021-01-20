package com.zf.controller;


import com.zf.entity.Article;
import com.zf.entity.CommonResult;
import com.zf.entity.User;
import com.zf.service.ArticleService;
import com.zf.service.ClassificationService;
import com.zf.service.UserService;
import com.zf.service.impl.ArticleServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 2021-01-12 20:20
 */
@RestController
@RequestMapping("/admin/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @Resource
    private UserService userService;

    @Resource
    private ClassificationService classificationService;

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

    @GetMapping(value = "/getAllArticle")
    public CommonResult<ArrayList> getAllArticle(){
        ArrayList<Article> articleList = articleService.getAllArticle();
        ArrayList<HashMap> articleMapList = new ArrayList<>();

        for(Article article:articleList){
            String userNickName = userService.getUserNickNameById(article.getUserId());
            String classificationName = classificationService.getClassificationNameById(article.getClassificationId());
            System.out.println(article);
            HashMap<String, Object> articleMap = new HashMap<>();
            articleMap.put("title",article.getTitle());
            articleMap.put("delete_time",article.getDeleteTime());
            articleMap.put("pub_time",article.getPubTime());
            articleMap.put("userNickName",userNickName);
            articleMap.put("articleId",article.getId());
            articleMap.put("classificationName",classificationName);
            articleMap.put("articleContent",article.getContent());
            articleMapList.add(articleMap);
        }
        return new CommonResult<ArrayList>(200,"成功查询所有文章",articleMapList);
    }



}

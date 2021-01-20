package com.zf.controller;


import com.zf.entity.*;
import com.zf.service.*;
import com.zf.service.impl.ArticleServiceImpl;
import org.hibernate.annotations.Source;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2021-01-12 20:20
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @Resource
    CommentService commentService;

    @Resource
    ReplyService replyService;

    @Resource
    UserService userService;

    @Resource
    ThumbService thumbService;

    @Resource
    CollectService collectService;

    @GetMapping("/get/{id}")
    public CommonResult get(@PathVariable("id") Integer id){
        Article result = articleService.findById(id);
        return new CommonResult(200,"查询成功",result);
    }

    @PostMapping("/save")
  //  @CachePut(value = "article")
    public CommonResult save(@RequestBody Article article){
        Article save = articleService.save(article);
        if(null!=save) {
            return new CommonResult(200, "添加成功", save);
        }else{
            return new CommonResult(404,"添加失败");
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

//    查询文章及评论
    @GetMapping("/getAllArticle")
 //   @Cacheable(value = "article")
    public CommonResult<HashMap> getAllArticle(@RequestParam("userId") Integer userId){
        List<Article> articleList=articleService.getAllArticle();
        HashMap<String,Object> resultMap=new HashMap<>();
        List<Map> articleMapList=new ArrayList<>();

        for (Article article:articleList){

            List<Comment> commentList=commentService.getArticleAllCommentById(article.getId());
            ArrayList<HashMap> commentMapList = new ArrayList<>();

            for(Comment comment:commentList){
                HashMap<String, Object> commentMap = new HashMap<>();

                List<Reply> replyList = replyService.getCommentAllReply(comment.getId());
                String commentUserName = userService.getUserNameById(comment.getUserId());
                Long commentThumbNum = thumbService.getThumbNumById("commentId",comment.getId());

                Thumb commentThumb = thumbService.findByCommentIdAndUserId(comment.getId(),userId);
                Boolean commentThumbUp=false;
                if(commentThumb!=null){
                    commentThumbUp=true;
                }

                ArrayList<HashMap> replyMapList = new ArrayList<>();

                for(Reply reply:replyList){

                    String fromUserName = userService.getUserNameById(reply.getFromUserId());
                    String toUserName = userService.getUserNameById(reply.getToUserId());
                    Long replyThumbNum = thumbService.getThumbNumById("replyId",reply.getId());
                    Thumb replyThumb = thumbService.findByReplyIdAndUserId(reply.getId(),userId);
                    Boolean replyThumbUp=false;
                    if(replyThumb!=null){
                        replyThumbUp=true;
                    }

                    HashMap<String, Object> rePlyMap = new HashMap<>();
                    rePlyMap.put("reply",reply);
                    rePlyMap.put("fromUserName",fromUserName);
                    rePlyMap.put("toUserName",toUserName);
                    rePlyMap.put("replyThumbNum",replyThumbNum);
                    rePlyMap.put("replyThumbUp",replyThumbUp);

                    replyMapList.add(rePlyMap);
                }
                commentMap.put("comment",comment);
                commentMap.put("replyMapList",replyMapList);
                commentMap.put("commentUserName",commentUserName);
                commentMap.put("commentThumbNum",commentThumbNum);
                commentMap.put("commentThumbUp",commentThumbUp);

                commentMapList.add(commentMap);

            }

            Long commentNum=commentService.getArticleCommentNumById(article.getId());

            HashMap<String, Object> articleMap = new HashMap<>();
            articleMap.put("article",article);
            articleMap.put("commentMapList",commentMapList);
            articleMap.put("commentNum",commentNum);
            articleMapList.add(articleMap);
           /* System.out.println(articleMap);
            System.out.println(commentNum);
            System.out.println(articleMap);*/
        }
        System.out.println("66666");
        resultMap.put("articleMapList",articleMapList);

        return new CommonResult<HashMap>(200, "成功查询到所有文章",resultMap);

    }

    //    查询用户文章
    @GetMapping("/getUserArticle/{userId}")
    public CommonResult<HashMap> getUserArticle(@PathVariable("userId") Integer userId){
        List<Article> articleList=articleService.getUserArticle(userId);
        HashMap<String,Object> resultMap=new HashMap<>();
        String userName = userService.getUserNameById(userId);
        String userImage = userService.getUserImageById(userId);

        List<Map> articleMapList=new ArrayList<>();

        for (Article article:articleList){

            List<Comment> commentList=commentService.getArticleAllCommentById(article.getId());
            Collect collect = collectService.findByUserIdAndArticleId(userId,article.getId());
            Boolean collectArticle=false;
            if(collect!=null){
                collectArticle=true;
            }
            ArrayList<HashMap> commentMapList = new ArrayList<>();

            for(Comment comment:commentList){
                HashMap<String, Object> commentMap = new HashMap<>();

                List<Reply> replyList = replyService.getCommentAllReply(comment.getId());
                String commentUserName = userService.getUserNameById(comment.getUserId());
                Long commentThumbNum = thumbService.getThumbNumById("commentId",comment.getId());

                Thumb commentThumb = thumbService.findByCommentIdAndUserId(comment.getId(),userId);
                Boolean commentThumbUp=false;
                if(commentThumb!=null){
                    commentThumbUp=true;
                }

                ArrayList<HashMap> replyMapList = new ArrayList<>();

                for(Reply reply:replyList){

                    String fromUserName = userService.getUserNameById(reply.getFromUserId());
                    String toUserName = userService.getUserNameById(reply.getToUserId());
                    Long replyThumbNum = thumbService.getThumbNumById("replyId",reply.getId());
                    Thumb replyThumb = thumbService.findByReplyIdAndUserId(reply.getId(),userId);
                    Boolean replyThumbUp=false;
                    if(replyThumb!=null){
                        replyThumbUp=true;
                    }

                    HashMap<String, Object> rePlyMap = new HashMap<>();
                    rePlyMap.put("reply",reply);
                    rePlyMap.put("fromUserName",fromUserName);
                    rePlyMap.put("toUserName",toUserName);
                    rePlyMap.put("replyThumbNum",replyThumbNum);
                    rePlyMap.put("replyThumbUp",replyThumbUp);

                    replyMapList.add(rePlyMap);
                }
                commentMap.put("comment",comment);
                commentMap.put("replyMapList",replyMapList);
                commentMap.put("commentUserName",commentUserName);
                commentMap.put("commentThumbNum",commentThumbNum);
                commentMap.put("commentThumbUp",commentThumbUp);
                commentMap.put("collectArticle",collectArticle);

                commentMapList.add(commentMap);

            }

            Long commentNum=commentService.getArticleCommentNumById(article.getId());

            HashMap<String, Object> articleMap = new HashMap<>();
            articleMap.put("article",article);
            articleMap.put("commentMapList",commentMapList);
            articleMap.put("commentNum",commentNum);
            articleMap.put("userName",userName);
            articleMap.put("userImage",userImage);

            articleMapList.add(articleMap);
               /* System.out.println(articleMap);
                System.out.println(commentNum);
                System.out.println(articleMap);*/
        }

        resultMap.put("articleMapList",articleMapList);

        return new CommonResult<HashMap>(200, "成功查询此用户到所有文章",resultMap);

    }

//    按标题搜索文章
    @GetMapping("/getArticleByTitle")
    public CommonResult<HashMap> getArticleByTitle(@RequestParam("title") String title
                                                    ,@RequestParam("userId") Integer userId){
        List<Article> articleList=articleService.getArticleByTitle("%"+title+"%");

        HashMap<String,Object> resultMap=new HashMap<>();


        List<Map> articleMapList=new ArrayList<>();

        for (Article article:articleList){

            List<Comment> commentList=commentService.getArticleAllCommentById(article.getId());

            ArrayList<HashMap> commentMapList = new ArrayList<>();

            for(Comment comment:commentList){
                HashMap<String, Object> commentMap = new HashMap<>();

                List<Reply> replyList = replyService.getCommentAllReply(comment.getId());
                String commentUserName = userService.getUserNameById(comment.getUserId());
                Long commentThumbNum = thumbService.getThumbNumById("commentId",comment.getId());

                Thumb commentThumb = thumbService.findByCommentIdAndUserId(comment.getId(),userId);
                Boolean commentThumbUp=false;
                if(commentThumb!=null){
                    commentThumbUp=true;
                }

                ArrayList<HashMap> replyMapList = new ArrayList<>();

                for(Reply reply:replyList){

                    String fromUserName = userService.getUserNameById(reply.getFromUserId());
                    String toUserName = userService.getUserNameById(reply.getToUserId());
                    Long replyThumbNum = thumbService.getThumbNumById("replyId",reply.getId());
                    Thumb replyThumb = thumbService.findByReplyIdAndUserId(reply.getId(),userId);
                    Boolean replyThumbUp=false;
                    if(replyThumb!=null){
                        replyThumbUp=true;
                    }

                    HashMap<String, Object> rePlyMap = new HashMap<>();
                    rePlyMap.put("reply",reply);
                    rePlyMap.put("fromUserName",fromUserName);
                    rePlyMap.put("toUserName",toUserName);
                    rePlyMap.put("replyThumbNum",replyThumbNum);
                    rePlyMap.put("replyThumbUp",replyThumbUp);

                    replyMapList.add(rePlyMap);
                }
                commentMap.put("comment",comment);
                commentMap.put("replyMapList",replyMapList);
                commentMap.put("commentUserName",commentUserName);
                commentMap.put("commentThumbNum",commentThumbNum);
                commentMap.put("commentThumbUp",commentThumbUp);

                commentMapList.add(commentMap);

            }

            Long commentNum=commentService.getArticleCommentNumById(article.getId());

            HashMap<String, Object> articleMap = new HashMap<>();
            articleMap.put("article",article);
            articleMap.put("commentMapList",commentMapList);
            articleMap.put("commentNum",commentNum);

            articleMapList.add(articleMap);

        }

        resultMap.put("articleMapList",articleMapList);

        return new CommonResult<HashMap>(200, "成功查询与此标题相关的所有文章",resultMap);

    }

    @GetMapping("/getArticleByArticleId")
    public CommonResult<HashMap> getArticleByArticleId(@RequestParam("articleId") Integer articleId,
                                                       @RequestParam("userId") Integer userId){
        Article article=articleService.findById(articleId);

        HashMap<String,Object> resultMap=new HashMap<>();

        List<Map> articleMapList=new ArrayList<>();

        List<Comment> commentList=commentService.getArticleAllCommentById(article.getId());

        ArrayList<HashMap> commentMapList = new ArrayList<>();

        for(Comment comment:commentList){
            HashMap<String, Object> commentMap = new HashMap<>();

            List<Reply> replyList = replyService.getCommentAllReply(comment.getId());
            String commentUserName = userService.getUserNameById(comment.getUserId());
            Long commentThumbNum = thumbService.getThumbNumById("commentId",comment.getId());

            Thumb commentThumb = thumbService.findByCommentIdAndUserId(comment.getId(),userId);
            Boolean commentThumbUp=false;
            if(commentThumb!=null){
                commentThumbUp=true;
            }

            ArrayList<HashMap> replyMapList = new ArrayList<>();

            for(Reply reply:replyList){

                String fromUserName = userService.getUserNameById(reply.getFromUserId());
                String toUserName = userService.getUserNameById(reply.getToUserId());
                Long replyThumbNum = thumbService.getThumbNumById("replyId",reply.getId());
                Thumb replyThumb = thumbService.findByReplyIdAndUserId(reply.getId(),userId);
                Boolean replyThumbUp=false;
                if(replyThumb!=null){
                    replyThumbUp=true;
                }

                HashMap<String, Object> rePlyMap = new HashMap<>();
                rePlyMap.put("reply",reply);
                rePlyMap.put("fromUserName",fromUserName);
                rePlyMap.put("toUserName",toUserName);
                rePlyMap.put("replyThumbNum",replyThumbNum);
                rePlyMap.put("replyThumbUp",replyThumbUp);

                replyMapList.add(rePlyMap);
            }
            commentMap.put("comment",comment);
            commentMap.put("replyMapList",replyMapList);
            commentMap.put("commentUserName",commentUserName);
            commentMap.put("commentThumbNum",commentThumbNum);
            commentMap.put("commentThumbUp",commentThumbUp);

            commentMapList.add(commentMap);

        }

        Long commentNum=commentService.getArticleCommentNumById(article.getId());

        HashMap<String, Object> articleMap = new HashMap<>();
        articleMap.put("article",article);
        articleMap.put("commentMapList",commentMapList);
        articleMap.put("commentNum",commentNum);

        articleMapList.add(articleMap);



        resultMap.put("articleMapList",articleMapList);

        return new CommonResult<HashMap>(200, "成功查询与此标题相关的所有文章",resultMap);

    }

}

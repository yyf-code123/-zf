package com.zf.controller;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.zf.entity.Comment;
import com.zf.entity.User;
import com.zf.entity.CommonResult;
import com.zf.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/user")
public class UserController {

    @Resource
    UserService userService;

    @GetMapping(value = "/getOne/{id}")
    public CommonResult<User> getOne(@PathVariable("id") Integer id){
        User user = userService.findById(id);
        return new CommonResult<>(200,"查询成功",user);
    }

    /**
     * @RequestBody用在消费者调用生产者时将输入的数据传到生产者中，没有使用则不能将数据传到生产者的方法中
     */

    @PostMapping(value = "/save")
    public CommonResult<User> save(@RequestBody User user){
        System.out.println(userService.save(user));
        return new CommonResult<>(200,"添加用户成功");
    }

    @PostMapping(value = "/update")
    public CommonResult<User> update(@RequestBody User user){
        System.out.println(user);
        userService.save(user);
        return new CommonResult<>(200,"修改成功");
    }

    @RequestMapping(value = "/delete/{id}")
    public CommonResult<User> delete(@PathVariable("id") Integer id){
        userService.delete(id);
        return new CommonResult<>(200,"删除成功");
    }

    @GetMapping(value = "/getAllUser")
    public CommonResult<ArrayList> getAllUser(){
        ArrayList<User> userList = (ArrayList<User>) userService.getAllUser();
        ArrayList<Map> userMapList = new ArrayList<>();
        System.out.println(userList);

        for(User user:userList){
            HashMap<String, Object> userMap = new HashMap<>();
            if(user.getUserCommentAuth()==1){
                userMap.put("userCommentAuth",true);
            }else {
                userMap.put("userCommentAuth",false);
            }

            if(user.getUser_article_auth()==1){
                userMap.put("userArticleAuth",true);

            }else {
                userMap.put("userArticleAuth",false);
            }

            userMap.put("userNickname",user.getUserNickname());
            userMap.put("userPhone",user.getUserPhone());
            userMap.put("userId",user.getId());
            userMapList.add(userMap);
        }
        return new CommonResult<ArrayList>(200,"成功查询所有用户",userMapList);
    }

    @GetMapping(value = "/getUserByPhone")
    public CommonResult<HashMap> getUserByPhone(String phone){
        HashMap<String, Object> userMap = new HashMap<>();
        System.out.println(phone);

        User user = userService.getUserByPhone(phone);
        if(user==null){
            return new CommonResult<HashMap>(404,"不存在此用户！");
        }


        if(user.getUserCommentAuth()==1){
            userMap.put("userCommentAuth",true);
        }else {
            userMap.put("userCommentAuth",false);
        }

        if(user.getUser_article_auth()==1){
            userMap.put("userArticleAuth",true);

        }else {
            userMap.put("userArticleAuth",false);
        }

        userMap.put("userNickname",user.getUserNickname());
        userMap.put("userPhone",user.getUserPhone());
        userMap.put("userId",user.getId());

        return new CommonResult<HashMap>(200,"成功查询到此用户",userMap);

    }

    @GetMapping("/setUserPublishPermission")
    public CommonResult<HashMap> setUserPublishPermission(Boolean publishPermission,Integer userId){
        userService.setUserPublishPermission(publishPermission,userId);
        return new CommonResult<HashMap>(200,"修改权限成功");
    }

    @GetMapping("/setUserCommentPermission")
    public CommonResult<HashMap> setUserCommentPermission(Boolean commentPermission,Integer userId){
        userService.setUserModifyPermission(commentPermission,userId);
        return new CommonResult<HashMap>(200,"修改权限成功");
    }
}

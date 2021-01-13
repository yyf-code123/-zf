package com.zf.controller;

import com.zf.entity.User;
import com.zf.entity.CommonResult;
import com.zf.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    UserService userService;

    @GetMapping(value = "/user/getOne/{id}")
    public CommonResult<User> getOne(@PathVariable("id") Integer id){
        User user = userService.findById(id);
        return new CommonResult<>(200,"查询成功",user);
    }

    /**
     * @RequestBody用在消费者调用生产者时将输入的数据传到生产者中，没有使用则不能将数据传到生产者的方法中
     */

    @PostMapping(value = "/user/save")
    public CommonResult<User> save(@RequestBody User user){
        System.out.println(userService.save(user));
        return new CommonResult<>(200,"添加用户成功");
    }

    @PostMapping(value = "/user/update")
    public CommonResult<User> update(@RequestBody User user){
        System.out.println(user);
        userService.save(user);
        return new CommonResult<>(200,"修改成功");
    }

    @RequestMapping(value = "/user/delete/{id}")
    public CommonResult<User> delete(@PathVariable("id") Integer id){
        userService.delete(id);
        return new CommonResult<>(200,"删除成功");
    }
}

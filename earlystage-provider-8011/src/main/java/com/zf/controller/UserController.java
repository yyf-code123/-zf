package com.zf.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zf.entity.User;
import com.zf.entity.CommonResult;
import com.zf.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
@DefaultProperties(defaultFallback = "user_Global_FallbackMethod")
public class UserController {

    @Resource
    UserService userService;

    @GetMapping(value = "/getOne/{id}")
    @HystrixCommand(fallbackMethod = "userGetOne_TimeOutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public CommonResult<User> getOne(@PathVariable("id") Integer id){
      //  int i=1/0;
     /*   try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        User user = userService.findById(id);
        return new CommonResult<>(200,"查询成功",user);
    }
    public CommonResult<User> userGetOne_TimeOutHandler(@PathVariable("id") Integer id) {
        return new CommonResult<>(410,"请求超时请重试");
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

    @HystrixCommand
    @RequestMapping(value = "/delete/{id}")
    public CommonResult<User> delete(@PathVariable("id") Integer id){
          int i=1/0;
        userService.delete(id);
        return new CommonResult<>(200,"删除成功");
    }

    //下面是全局fallback方法
    public CommonResult<User> user_Global_FallbackMethod(){
        return new CommonResult<>(200,"请求失败请稍后再试");
    }
}

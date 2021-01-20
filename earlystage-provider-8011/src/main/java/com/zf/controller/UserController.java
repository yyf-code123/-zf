package com.zf.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zf.dao.UserDao;
import com.zf.entity.User;
import com.zf.entity.CommonResult;
import com.zf.service.UserService;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
@DefaultProperties(defaultFallback = "user_Global_FallbackMethod")
public class UserController {

    @Resource
    UserService userService;

    @GetMapping(value = "/getOne/{phoneNum}")
    @HystrixCommand(fallbackMethod = "userGetOne_TimeOutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public CommonResult<User> getOne(@PathVariable("phoneNum") String phoneNum){
      //  int i=1/0;
     /*   try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        User user = userService.findByUserPhone(phoneNum);
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
        //  int i=1/0;
        userService.delete(id);
        return new CommonResult<>(200,"删除成功");
    }

    //下面是全局fallback方法
    public CommonResult<User> user_Global_FallbackMethod(){
        return new CommonResult<>(200,"请求失败请稍后再试");
    }

    //用户发送验证码
    @PostMapping("/sendRegisterMessage")
    public CommonResult<String> sendRegisterMessage(@RequestBody String phoneNum){
        User user1 = userService.findByUserPhone(phoneNum);
        if(user1!=null){
            return new CommonResult(404,"此用户已注册，请更换手机号！");

        }
        return userService.sendExchange(phoneNum);
    }

//    用户注册
    @PostMapping(value = "/register")
    public CommonResult<String> register(@RequestBody User user,
                                         @RequestParam("phone") String phone,
                                         @RequestParam("password") String password){

        user.setUserPhone(phone);
        user.setUserPass(password);
        userService.save(user);
         return new CommonResult(200,"注册成功！");
    }


//    验证码的验证
    @PostMapping(value = "/verifyCode")
    public CommonResult<String> verifyCode(@RequestParam("phone") String phone,
                                           @RequestParam("code") String code){

        Object o = userService.verifyCode(phone, code);
        if(o==null){
            return new CommonResult(404,"请先获取此手机号的验证码！");

        }else{
            if(o.equals(code)){
                return new CommonResult(200,"验证码输入正确！");

            }
            else {
                return new CommonResult(200,"验证码输入错误！");

            }

        }

    }



}

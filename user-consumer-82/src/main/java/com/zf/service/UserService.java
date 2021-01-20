package com.zf.service;

import com.zf.entity.CommonResult;
import com.zf.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "EARLYSTAGE-PROVIDER-SERVICE",fallback = UserFallBackService.class)
@Service
public interface UserService {
    @GetMapping(value = "/user/getOne/{phoneNum}")
    public CommonResult<User> getOne(@PathVariable("phoneNum") String phoneNum);


    @PostMapping(value = "/user/save")
    public CommonResult<User> save(@RequestBody User user);

    @PostMapping(value = "/user/update")
    public CommonResult<User> update(@RequestBody User user);

    @RequestMapping(value = "/user/delete/{id}")
    public CommonResult<User> delete(@PathVariable("id") Integer id);

    //用户发送验证码
    @PostMapping(value = "/user/sendRegisterMessage")
    public CommonResult<String> sendRegisterMessage(String phoneNum);

    @PostMapping(value = "/user/register")
    public CommonResult<String> register(@RequestBody User user,@RequestParam("phone") String phone,@RequestParam("password") String password);


    @PostMapping(value = "/user/verifyCode")
    public CommonResult<String> verifyCode(@RequestParam("phone") String phone, @RequestParam("code") String code);
}

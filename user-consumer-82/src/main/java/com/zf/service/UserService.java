package com.zf.service;

import com.zf.entity.CommonResult;
import com.zf.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "EARLYSTAGE-PROVIDER-SERVICE",fallback = UserFallBackService.class)
@Service
public interface UserService {
    @GetMapping(value = "/user/getOne/{id}")
    public CommonResult<User> getOne(@PathVariable("id") Integer id);


    @PostMapping(value = "/user/save")
    public CommonResult<User> save(@RequestBody User user);

    @PostMapping(value = "/user/update")
    public CommonResult<User> update(@RequestBody User user);

    @RequestMapping(value = "/user/delete/{id}")
    public CommonResult<User> delete(@PathVariable("id") Integer id);

}

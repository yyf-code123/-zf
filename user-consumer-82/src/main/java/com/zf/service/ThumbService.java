package com.zf.service;

import com.zf.entity.CommonResult;
import com.zf.entity.Thumb;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "EARLYSTAGE-PROVIDER-SERVICE")
@Service
public interface ThumbService {
    @GetMapping(value = "/thumb/getOne/{id}")
    public CommonResult<Thumb> getOne(@PathVariable("id") Integer id);


    @PostMapping(value = "/thumb/save")
    public CommonResult<Thumb> save(@RequestBody Thumb thumb);

    @PostMapping(value = "/thumb/update")
    public CommonResult<Thumb> update(@RequestBody Thumb thumb);

    @RequestMapping(value = "/thumb/delete/{id}")
    public CommonResult<Thumb> delete(@PathVariable("id") Integer id);

    @GetMapping("/thumb/replyThumb")
    public CommonResult<Thumb> replyThumb(@RequestParam("replyId") Integer replyId,
                                          @RequestParam("status")Boolean status,
                                          @RequestParam("userId")Integer userId);
}

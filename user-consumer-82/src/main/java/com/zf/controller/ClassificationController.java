package com.zf.controller;

import com.zf.entity.CommonResult;
import com.zf.entity.Classification;
import com.zf.service.ClassificationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/consumer/classification")
public class ClassificationController {

    @Resource
    ClassificationService classificationService;

    @GetMapping(value = "/getOne/{id}")
    public CommonResult<Classification> getOne(@PathVariable("id") Integer id){
        return classificationService.getOne(id);
    }


    @PostMapping(value = "/save")
    public CommonResult<Classification> save(Classification classification){
        return classificationService.save(classification);
    }

    @PostMapping(value = "/update")
    public CommonResult<Classification> update(Classification classification){
        return classificationService.save(classification);

    }

    @RequestMapping(value = "/delete/{id}")
    public CommonResult<Classification> delete(@PathVariable("id") Integer id){

        return classificationService.delete(id);
    }

    @GetMapping("/getAllClassification")
    public CommonResult<List> getAllClassification(){
        return classificationService.getAllClassification();
    }

}

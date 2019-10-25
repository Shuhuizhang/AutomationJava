package com.haizol.automation.controller;

import com.haizol.automation.model.ApiDoc;
import com.haizol.automation.service.ApiDocService;
import entity.PageResult;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Classname ApiDocController
 * @Date 2019/9/21 20:14
 * @Created by StevenZsh
 * @Description Apidoc
 */
@RestController
@RequestMapping("/apiDoc")
public class ApiDocController {

    @Autowired
    private ApiDocService apiDocService;

    /**
     * 查找所有的api
     * @return
     */
    @RequestMapping("/findAll")
    public PageResult findAll(Integer page, Integer size){
        return apiDocService.findAll(page, size);
    }


    @RequestMapping("findOne")
    public ApiDoc findOne(Integer id){
        return apiDocService.findOne(id);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody ApiDoc apiDoc){
        return apiDocService.update(apiDoc);
    }

    @RequestMapping("/add")
    public Result add(@RequestBody ApiDoc apiDoc){
        return apiDocService.add(apiDoc);
    }

    @RequestMapping("/del")
    public Result del(Integer [] ids){
        return apiDocService.del(ids);
    }


    @RequestMapping("/optionList")
    public List<Map> selectOptionList(){
        return apiDocService.selectOptionList();
    }


}

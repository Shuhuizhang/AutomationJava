package com.haizol.automation.controller;

import com.haizol.automation.model.TbTestCase;
import com.haizol.automation.model.TestPlan;
import com.haizol.automation.service.TestCaseService;
import entity.PageResult;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname TestCaseController
 * @Date 2019/10/20 18:15
 * @Created by StevenZsh
 * @Description TODO
 */
@RestController
@RequestMapping("/cases")
public class TestCaseController {

    @Autowired
    private TestCaseService caseService;

    @RequestMapping("/create")
    public Result createcase(@RequestBody TbTestCase testCase){
        return caseService.createCase(testCase);
    }

    @RequestMapping("/search")
    public PageResult searchCaseByPlan(@RequestBody TestPlan plan, int page, int size){
        return caseService.findPage(plan,page,size);
    }

    @RequestMapping("findOne")
    public TbTestCase findOne(Integer id){
        return caseService.findOne(id);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody TbTestCase testCase){
        return caseService.update(testCase);
    }

    @RequestMapping("/del")
    public Result del(Integer[] ids){
        return caseService.del(ids);
    }


    @RequestMapping("/getModuleOption")
    public List<Map> selectModuleOption(){
        List<Map> option = new ArrayList<>();
        List<String> strings = caseService.selectModuleOption();
        for (int i = 1; i <= strings.size(); i++) {
            Map<String,Object> optionMap = new HashMap<>();
            optionMap.put("id",strings.get(i-1));
            optionMap.put("text",strings.get(i-1));
            option.add(optionMap);
        }
        return option;
    }

    @RequestMapping("/getMethodOption")
    public List<Map> selectMethodOption(String module){
        return caseService.selectMothedOption(module);
    }

}

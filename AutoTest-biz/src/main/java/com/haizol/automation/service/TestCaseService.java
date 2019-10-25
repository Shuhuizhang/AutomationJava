package com.haizol.automation.service;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.haizol.automation.mapper.TbCasePlanMapper;
import com.haizol.automation.mapper.TbTestCaseMapper;
import com.haizol.automation.model.*;
import entity.PageResult;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Classname TestCaseService
 * @Date 2019/10/20 17:59
 * @Created by StevenZsh
 * @Description TODO
 */
@Service
public class TestCaseService {

    @Autowired
    private TbTestCaseMapper testCaseMapper;

    @Autowired
    private TbCasePlanMapper casePlanMapper;


    public Result createCase(TbTestCase testCase){
        try {
            testCaseMapper.insert(testCase);
            return new Result(true,"添加用例成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true,"添加用例失败");
        }
    }


    public TbTestCase findOne(Integer id) {
        return testCaseMapper.selectByPrimaryKey(id);
    }



    public Result update(TbTestCase testCase) {
        try {
            testCaseMapper.updateByPrimaryKey(testCase);
            return new Result(true,"修改用例成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true,"修改用例失败");
        }
    }

    public Result del(Integer [] ids) {
        try {
            for (Integer id : ids) {
                testCaseMapper.deleteByPrimaryKey(id);}
            return new Result(true, "删除用例成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true, "删除用例失败");
        }
    }

    public PageResult findPage(TestPlan plan, int page, int size) {
        Page<TbTestCase> pages = null;
        if (plan.getId() != null){
            TbCasePlanExample casePlanExample = new TbCasePlanExample();
            TbCasePlanExample.Criteria criteria = casePlanExample.createCriteria();
            criteria.andPlanIdEqualTo(plan.getId());
            List<TbCasePlan> tbCasePlans = casePlanMapper.selectByExample(casePlanExample);
            List<Integer> caseIds = new ArrayList<>();
            if (tbCasePlans.size() != 0){
                for (TbCasePlan casePlan:tbCasePlans) {
                    int caseid = Integer.parseInt(String.valueOf(casePlan.getCaseId()));
                    caseIds.add(caseid); }
            }else{ caseIds.add(0); }
            TbTestCaseExample caseExample= new TbTestCaseExample();
            TbTestCaseExample.Criteria exampleCriteria = caseExample.createCriteria();
            exampleCriteria.andIdIn(caseIds);

            PageHelper.startPage(page, size);
            pages = (Page<TbTestCase>) testCaseMapper.selectByExample(caseExample);
        }else{
            PageHelper.startPage(page, size);
            PageHelper.orderBy("id desc");
            pages = (Page<TbTestCase>) testCaseMapper.selectByExample(null);
        }
        return new PageResult(pages.getTotal(), pages.getResult());


    }


    public List<String> selectModuleOption(){
        return testCaseMapper.selectModuleOption();
    }

    public List<Map> selectMothedOption(String module){
       return testCaseMapper.selectMothedOption(module);}

}

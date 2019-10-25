package com.haizol.automation.service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haizol.automation.mapper.TbCasePlanMapper;
import com.haizol.automation.mapper.TbTestCaseMapper;
import com.haizol.automation.mapper.TestPlanMapper;
import com.haizol.automation.model.*;
import com.haizol.automation.utils.HttpClientUtil;
import entity.PageResult;
import entity.Result;
import entity.RunPlan;
import entity.TestPlanDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * @Classname PlanService
 * @Date 2019/9/24 21:49
 * @Created by StevenZsh
 * @Description TODO
 */
@Service
public class PlanService {

    @Autowired
    private TestPlanMapper planMapper;

    @Autowired
    private TbCasePlanMapper casePlanMapper;

    @Autowired
    private TbTestCaseMapper caseMapper;

    @Autowired
    private TbTestCaseMapper testCaseMapper;

    @Autowired
    private HttpClientUtil httpClientUtil;

    public PageResult findPage(TestPlan plan, int page, int size) {
        Page pages= null;
        if(plan.getModule() !=null){
            TestPlanExample testPlanExample = new TestPlanExample();
            TestPlanExample.Criteria criteria = testPlanExample.createCriteria();
            criteria.andModuleEqualTo(plan.getModule());
            PageHelper.startPage(page, size);
            pages = (Page) planMapper.selectByExample(testPlanExample);
        }else {
            PageHelper.startPage(page, size);
            pages = (Page) planMapper.selectByExample(null);
        }
        return new PageResult(pages.getTotal(), pages.getResult());


//        List<TestPlanDetail> testPlanDetails = new ArrayList<>();
//        if (plan.getTestPlan() != null){
//            if(plan.getTestPlan().getName() != null &&  !plan.getTestPlan().getName().equals("")){
//                PageHelper.startPage(page, size);
//                Page pages = (Page) planMapper.selectByExample(null);
//                return new PageResult(pages.getTotal(), pages.getResult());
//            }else {
//                PageHelper.startPage(page, size);
//                Page pages = (Page) planMapper.selectByExample(null);
//                return new PageResult(pages.getTotal(), pages.getResult());
//            }
//        }else {
//            List<TestPlan> plans = planMapper.selectByExample(null);
//            for(TestPlan ignored : plans){
//
//                TbCasePlanExample casePlanExample = new TbCasePlanExample();
//                TbCasePlanExample.Criteria criteria = casePlanExample.createCriteria();
//                criteria.andPlanIdEqualTo(ignored.getId());
//                List<TbCasePlan> tbCasePlans = casePlanMapper.selectByExample(casePlanExample);
//                List<TbTestCase> caseList = new ArrayList<>();
//                for (TbCasePlan casePlan:tbCasePlans){
//                    String caseid = String.valueOf(casePlan.getCaseId());
//                    caseList.add(caseMapper.selectByPrimaryKey(Integer.parseInt(caseid)));
//                }
//                TestPlanDetail detail = new TestPlanDetail();
//                detail.setTestPlan(ignored);
//                detail.setCaseList(caseList);
//                testPlanDetails.add(detail);
//            }
//            PageHelper.startPage(page, size);
//            PageInfo<TestPlanDetail> pages = (PageInfo<TestPlanDetail>) testPlanDetails;
//            return new PageResult(pages.getTotal(), Collections.singletonList(pages.getPages()));
//        }

    }

    public Result createPlan(TestPlan testPlan) {
        try {
           TbCasePlanExample casePlanExample = new TbCasePlanExample();
            TbCasePlanExample.Criteria criteria = casePlanExample.createCriteria();
            criteria.andPlanIdEqualTo(testPlan.getId());
            casePlanMapper.deleteByExample(casePlanExample);
            if(testPlan.getTestList().equals("")){

            }
        }
            return new Result(true,"添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true,"添加失败");
        }
    }


    public List<TestPlan> findAll() {
        TestPlanExample caseExample = new TestPlanExample();
        TestPlanExample.Criteria criteria = caseExample.createCriteria();
        criteria.andStatusEqualTo("0");
        return planMapper.selectByExample(caseExample);
    }


//    public PageResult findAll(Integer pageNum, Integer pageSize ){
//
//        PageHelper.startPage(pageNum,pageSize);  // 分页
//
//        TbTestPlanExample caseExample = new TbTestPlanExample();
//        TbTestPlanExample.Criteria criteria = caseExample.createCriteria();
//        criteria.andStatusEqualTo("0");
//        Page<TbTestPlan> page = (Page<TbTestPlan>) planMapper.selectByExample(caseExample);
//
//        return new PageResult(page.getTotal(),page.getResult());
//    }

    public TestPlan findOne(int id) {
        return  planMapper.selectByPrimaryKey(id);
    }



//    public Result update(TestPlan testPlan) {
//        try {
//            planMapper.updateByPrimaryKey(testPlan);
//            return new Result(true,"修改成功");
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new Result(true,"修改失败");
//        }
//    }
//
    public Result del(int [] ids) {
        try {
            for (int id : ids) {
                planMapper.deleteByPrimaryKey(id);}
            return new Result(true, "删除用户成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true, "删除用户失败");
        }
    }
//
//    public List<Map> selectOptionList() {
//        return planMapper.selectOptionList();
//    }
//
////    public Result addToPlan(TestPlan plan) {
////        try {
////            for(Long caseid : plan.getCaseList()){
////                TbCasePlan casePlan = new TbCasePlan();
////                casePlan.setCaseId(caseid);
////                casePlan.setPlanId(plan.getPlanId());
////                casePlan.setStatus("0");
////                casePlanMapper.insert(casePlan);}
////            return new Result(true, "加入测试计划成功");
////            } catch (Exception e) {
////                e.printStackTrace();
////            return new Result(false, "加入测试计划失败");
////        }
////        }

//    public Result run(Long id) {
////        TestPlanDetail planDetail = findOne(id);
//        RunPlan runPlan = new RunPlan();
//        runPlan.setPlanName(planDetail.getTestPlan().getName());
//        runPlan.setTestList(planDetail.getCaseList());
//        String json=JSON.toJSONString(runPlan);
//        System.out.println(json);
//        String url = "http://localhost:5000/create_test_plan";
//        String s = httpClientUtil.doPost(url, json);
//        System.out.println(s);
//        if (s.equals("发送请求成功")){
//            return new Result(true, "请求执行测试计划成功");
//        }else{
//            return new Result(false, "请求执行测试计划失败");
//        }
//
//
//    }


}

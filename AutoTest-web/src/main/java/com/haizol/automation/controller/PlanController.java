package com.haizol.automation.controller;

import com.haizol.automation.model.TestPlan;
import com.haizol.automation.service.PlanService;
import entity.PageResult;
import entity.Result;
import entity.TestPlanDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * @Classname PlanController
 * @Date 2019/9/24 21:49
 * @Created by StevenZsh
 * @Description TODO
 */
@RestController
@RequestMapping("/plan")
public class PlanController {

    @Autowired
    private PlanService planService;

    @RequestMapping("/create")
    public Result createPlan(@RequestBody TestPlanDetail testPlan){
        return planService.createPlan(testPlan);
    }

//    @RequestMapping("/findAll")
//    public List<TestPlanDetail> findAll(){
//        return planService.findAll();
//    }

    @RequestMapping("findOne")
    public TestPlan findOne(int id){
        return planService.findOne(id);
    }

//    @RequestMapping("/update")
//    public Result update(@RequestBody TestPlanDetail testPlan){
//        return planService.update(testPlan);
//    }

    @RequestMapping("/del")
    public Result del(int[] ids){
        return planService.del(ids);
    }


//    @RequestMapping("/optionList")
//    public List<Map> selectOptionList(){
//        return planService.selectOptionList();
//    }


//    @RequestMapping("/addToPlan")
//    public Result addToPlan(@RequestBody TestPlan testPlan ){
//        return PlanService.addToPlan(testPlan);
//    }

    @RequestMapping("/search")
    public PageResult search(@RequestBody TestPlan plan, int page, int size){
        return  planService.findPage(plan,page,size);
    }

//    @RequestMapping("/run")
//    public Result runPlan(Long id){
//        System.out.println(id);
//        return planService.run(id);
//    }
    
}

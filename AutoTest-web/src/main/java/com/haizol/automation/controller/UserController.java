package com.haizol.automation.controller;

import com.haizol.automation.model.TbUser;
import com.haizol.automation.service.UserService;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Classname userController
 * @Date 2019/9/23 20:45
 * @Created by StevenZsh
 * @Description TODO
 */
@RestController
@RequestMapping("/manage")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/create")
    public Result createUser(@RequestBody TbUser user){
        return userService.createUser(user);
    }

    @RequestMapping("/searchAll")
    public List<TbUser> allUser(){
        return userService.allUser();
    }

    @RequestMapping("findOne")
    public TbUser findOne(Long id){
        return userService.findOne(id);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody TbUser user){
        return userService.update(user);
    }

    @RequestMapping("/del")
    public Result del(Long[] ids){
        return userService.del(ids);
    }

    @RequestMapping("/optionList")
    public List<Map> selectOptionList(){
        return userService.selectOptionList();
    }

}

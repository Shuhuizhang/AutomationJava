package com.haizol.automation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname TestController
 * @Date 2019/9/22 15:04
 * @Created by StevenZsh
 * @Description TODO
 */
@Controller
public class TestController {

     @RequestMapping("/user")
     public String user(){
         System.out.println("请求进来了");
         return "请求成功";
     }
}

package com.haizol.automation.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.haizol.automation.mapper.ApiDocMapper;
import com.haizol.automation.model.ApiDoc;
import entity.PageResult;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;


/**
 * @Classname ApiDocService
 * @Date 2019/9/21 20:10
 * @Created by StevenZsh
 * @Description TODO
 */

@Service
public class ApiDocService {

    @Autowired
    private ApiDocMapper apiDocMapper;


    public PageResult findAll(Integer pageNum, Integer pageSize ){

        PageHelper.startPage(pageNum,pageSize);  // 分页

        Page<ApiDoc> page = (Page<ApiDoc>) apiDocMapper.selectByExample(null);

        return new PageResult(page.getTotal(),page.getResult());
    }

    public ApiDoc findOne(Integer id) {
        return apiDocMapper.selectByPrimaryKey(id);
    }

    public Result update(ApiDoc apiDoc) {

        try {
            apiDocMapper.updateByPrimaryKey(apiDoc);
            return new Result(true, "更新成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "更新失败");
        }
    }

    public Result add(ApiDoc apiDoc) {

        try {
            apiDocMapper.insert(apiDoc);
            return  new Result(true, "新增Api成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "新增Api失败");
        }
    }

    public Result del(Integer[] ids) {

        try {
            for (Integer i : ids) {
                apiDocMapper.deleteByPrimaryKey(i);
            }
            return new Result(true, "删除API成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除API失败");
        }

    }

    public List<Map> selectOptionList() {
        return apiDocMapper.selectOptionList();
    }
}



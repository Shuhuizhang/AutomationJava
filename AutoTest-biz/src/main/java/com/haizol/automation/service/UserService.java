package com.haizol.automation.service;

import com.haizol.automation.mapper.TbUserMapper;
import com.haizol.automation.model.TbUser;
import com.haizol.automation.model.TbUserExample;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Classname UserService
 * @Date 2019/9/23 20:47
 * @Created by StevenZsh
 * @Description TODO
 */

@Service
public class UserService {

    @Autowired(required = false)
    private TbUserMapper userMapper;


    public Result createUser(TbUser user) {

        try {
            user.setStatus("0");
            userMapper.insert(user);
            return new Result(true,"添加用户成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true,"添加用户失败");
        }
    }


    public List<TbUser> allUser() {
        TbUserExample userExample = new TbUserExample();
        TbUserExample.Criteria criteria = userExample.createCriteria();
        criteria.andStatusEqualTo("0");
        return userMapper.selectByExample(userExample);
    }

    public TbUser findOne(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public Result update(TbUser user) {
        try {
            userMapper.updateByPrimaryKey(user);
            return new Result(true,"修改用户成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true,"修改用户失败");
        }
    }

    public Result del(Long [] ids) {
        try {
            for (Long id : ids) {
                TbUser user = userMapper.selectByPrimaryKey(id);
                user.setStatus("1");
                userMapper.updateByPrimaryKey(user);}
            return new Result(true, "删除用户成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true, "删除用户失败");
        }
    }

    public List<Map> selectOptionList() {
        return userMapper.selectOptionList();
    }
}

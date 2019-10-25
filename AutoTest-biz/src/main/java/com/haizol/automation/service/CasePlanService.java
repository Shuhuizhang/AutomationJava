package com.haizol.automation.service;

import com.haizol.automation.mapper.TbCasePlanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Classname CasePlanService
 * @Date 2019/10/9 21:08
 * @Created by StevenZsh
 * @Description TODO
 */
@Service
public class CasePlanService {

    @Autowired()
    private TbCasePlanMapper casePlanMapper;
}

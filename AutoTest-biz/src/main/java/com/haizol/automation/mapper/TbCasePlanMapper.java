package com.haizol.automation.mapper;

import com.haizol.automation.model.TbCasePlan;
import com.haizol.automation.model.TbCasePlanExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbCasePlanMapper {
    long countByExample(TbCasePlanExample example);

    int deleteByExample(TbCasePlanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbCasePlan record);

    int insertSelective(TbCasePlan record);

    List<TbCasePlan> selectByExample(TbCasePlanExample example);

    TbCasePlan selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbCasePlan record, @Param("example") TbCasePlanExample example);

    int updateByExample(@Param("record") TbCasePlan record, @Param("example") TbCasePlanExample example);

    int updateByPrimaryKeySelective(TbCasePlan record);

    int updateByPrimaryKey(TbCasePlan record);
}
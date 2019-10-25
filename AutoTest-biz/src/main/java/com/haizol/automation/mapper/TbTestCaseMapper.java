package com.haizol.automation.mapper;

import com.haizol.automation.model.TbTestCase;
import com.haizol.automation.model.TbTestCaseExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TbTestCaseMapper {
    long countByExample(TbTestCaseExample example);

    int deleteByExample(TbTestCaseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbTestCase record);

    int insertSelective(TbTestCase record);

    List<TbTestCase> selectByExample(TbTestCaseExample example);

    TbTestCase selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbTestCase record, @Param("example") TbTestCaseExample example);

    int updateByExample(@Param("record") TbTestCase record, @Param("example") TbTestCaseExample example);

    int updateByPrimaryKeySelective(TbTestCase record);

    int updateByPrimaryKey(TbTestCase record);

    List<String> selectModuleOption();

    List<Map> selectMothedOption(String module);
}
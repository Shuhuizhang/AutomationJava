package com.haizol.automation.mapper;


import com.haizol.automation.model.ApiDoc;
import com.haizol.automation.model.ApiDocExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ApiDocMapper {
    int countByExample(ApiDocExample example);

    int deleteByExample(ApiDocExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ApiDoc record);

    int insertSelective(ApiDoc record);

    List<ApiDoc> selectByExample(ApiDocExample example);

    ApiDoc selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ApiDoc record, @Param("example") ApiDocExample example);

    int updateByExample(@Param("record") ApiDoc record, @Param("example") ApiDocExample example);

    int updateByPrimaryKeySelective(ApiDoc record);

    int updateByPrimaryKey(ApiDoc record);

    List<Map> selectOptionList();

}
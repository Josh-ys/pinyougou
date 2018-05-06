package com.pinyougou.mapper;

import com.pinyougou.pojo.TbFreightTemplate;
import com.pinyougou.pojo.TbFreightTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbFreightTemplateMapper {
    int countByExample(TbFreightTemplateExample example);

    int deleteByExample(TbFreightTemplateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbFreightTemplate record);

    int insertSelective(TbFreightTemplate record);

    List<TbFreightTemplate> selectByExample(TbFreightTemplateExample example);

    TbFreightTemplate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbFreightTemplate record, @Param("example") TbFreightTemplateExample example);

    int updateByExample(@Param("record") TbFreightTemplate record, @Param("example") TbFreightTemplateExample example);

    int updateByPrimaryKeySelective(TbFreightTemplate record);

    int updateByPrimaryKey(TbFreightTemplate record);
}
package com.neu.shop.mapper;

import com.neu.shop.entity.Pest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jiang
 * @description 针对表【pest】的数据库操作Mapper
 * @createDate 2023-03-12 16:22:14
 * @Entity com.neu.shop.entity.Pest
 */
public interface PestMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Pest record);

    int insertSelective(Pest record);

    List<Pest> selectByPrimaryKey(@Param("id") Long id);

    int updateByPrimaryKeySelective(Pest record);

    int updateByPrimaryKey(Pest record);

}

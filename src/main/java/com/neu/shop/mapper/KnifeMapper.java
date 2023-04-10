package com.neu.shop.mapper;

import com.neu.shop.entity.Knife;

import java.util.List;

/**
* @author jiang
* @description 针对表【knife】的数据库操作Mapper
* @createDate 2023-03-10 15:52:30
* @Entity com.neu.shop.entity.Knife
*/
public interface KnifeMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Knife record);

    int insertSelective(Knife record);

    List<Knife> selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Knife record);

    int updateByPrimaryKey(Knife record);

    List<Knife> getAll();

}

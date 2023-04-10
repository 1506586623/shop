package com.neu.shop.mapper;

import com.neu.shop.entity.Equipment;

import java.util.List;

/**
* @author dell
* @description 针对表【equipment】的数据库操作Mapper
* @createDate 2023-03-07 12:20:30
* @Entity com.neu.shop.entity.Equipment
*/
public interface EquipmentMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Equipment record);

    int insertSelective(Equipment record);

    List<Equipment> selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Equipment record);

    int updateByPrimaryKey(Equipment record);

    List<Equipment> getAll();

}

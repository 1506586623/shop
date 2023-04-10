package com.neu.shop.mapper;

import com.neu.shop.entity.Cart;

import java.util.List;

/**
* @author dell
* @description 针对表【cart】的数据库操作Mapper
* @createDate 2022-06-14 17:31:36
* @Entity com.neu.shop.entity.Cart
*/
public interface CartMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);

    List<Cart> getAll();

    List<Cart> selectAllByUserid(Integer id);

}

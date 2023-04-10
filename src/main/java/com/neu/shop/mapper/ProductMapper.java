package com.neu.shop.mapper;

import com.neu.shop.entity.Product;

import java.util.List;

/**
* @author dell
* @description 针对表【product】的数据库操作Mapper
* @createDate 2022-06-13 15:23:43
* @Entity com.neu.shop.entity.Product
*/
public interface ProductMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    List<Product> getAll();
}

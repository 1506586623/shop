package com.neu.shop.mapper;

import com.neu.shop.entity.User;

/**
* @author jiang
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-04-07 14:52:18
* @Entity com.neu.shop.entity.User
*/
public interface UserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}

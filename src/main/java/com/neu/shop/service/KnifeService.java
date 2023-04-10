package com.neu.shop.service;


import com.neu.shop.entity.Knife;

import java.util.List;


/**
* @author jiang
* @description 针对表【knife】的数据库操作Service
* @createDate 2023-02-17 15:23:10
*/
public interface KnifeService {
List<Knife> select(String id);
List<Knife> getAll();
}

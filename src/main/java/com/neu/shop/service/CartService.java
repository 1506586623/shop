package com.neu.shop.service;

import com.github.pagehelper.PageInfo;
import com.neu.shop.entity.Cart;

public interface CartService {
    PageInfo<Cart> getPaged(int pageNum, int pageSize);
    int insert(Cart record);
    int deleteByPrimaryKey(Integer id);
    Cart selectByPrimaryKey(Integer id);
}

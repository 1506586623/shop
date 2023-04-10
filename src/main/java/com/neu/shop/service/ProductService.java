package com.neu.shop.service;

import com.github.pagehelper.PageInfo;
import com.neu.shop.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product selectByPrimaryKey(Integer id);
    PageInfo<Product> getPaged(int pageNum, int pageSize);
}

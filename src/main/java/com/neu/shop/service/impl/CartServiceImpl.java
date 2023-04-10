package com.neu.shop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neu.shop.entity.Cart;
import com.neu.shop.entity.Product;
import com.neu.shop.mapper.CartMapper;
import com.neu.shop.service.CartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class CartServiceImpl implements CartService {
    @Resource
    CartMapper cartMapper;
    @Override
    public PageInfo<Cart> getPaged(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Cart> list = cartMapper.getAll();
        PageInfo<Cart> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
    @Override
    public int insert(Cart record) {
        return cartMapper.insert(record);
    }
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return cartMapper.deleteByPrimaryKey(id);
    }
    @Override
    public Cart selectByPrimaryKey(Integer id) {
        return cartMapper.selectByPrimaryKey(id);
    }

}

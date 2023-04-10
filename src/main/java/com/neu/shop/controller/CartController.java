package com.neu.shop.controller;

import com.github.pagehelper.PageInfo;
import com.neu.shop.entity.Cart;
import com.neu.shop.entity.Product;
import com.neu.shop.service.CartService;
import com.neu.shop.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("cart")
public class CartController {
    @Resource
    CartService cartService;
    @GetMapping("getPaged")
    public PageInfo<Cart> getPaged(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "3") int pageSize
            ){return cartService.getPaged(pageNum, pageSize);}
    @GetMapping("{userId}")
    public Cart getById(@PathVariable("userId") Integer userId){return cartService.selectByPrimaryKey(userId); }
    @PostMapping
    public int insert(@RequestBody Cart cart){
        System.out.println(cart);
        System.out.println("-------");
        return cartService.insert(cart);}
    @DeleteMapping("{productId}")
    public int delete(@PathVariable("productId") Integer productId){return cartService.deleteByPrimaryKey(productId);}
}

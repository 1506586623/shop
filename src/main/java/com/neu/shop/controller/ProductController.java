package com.neu.shop.controller;

import com.github.pagehelper.PageInfo;
import com.neu.shop.entity.Product;
import com.neu.shop.service.ProductService;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Resource
    ProductService productService;
    @GetMapping("getAll")
    public List<Product> getAll(){
        return productService.getAll();
    }
    @GetMapping("getPaged")
    public PageInfo<Product> getPaged(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "3") int pageSize){
        return productService.getPaged(pageNum, pageSize);
    }
    @GetMapping("{productId}")
    public Product getById(@PathVariable("productId") Integer productId){
        return productService.selectByPrimaryKey(productId);
    }
}

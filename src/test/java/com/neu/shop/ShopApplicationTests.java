package com.neu.shop;

import com.neu.shop.entity.Cart;
import com.neu.shop.entity.Equipment;
import com.neu.shop.mapper.CartMapper;
import com.neu.shop.mapper.EquipmentMapper;
import com.neu.shop.mapper.KnifeMapper;
import com.neu.shop.mapper.ProductMapper;
import com.neu.shop.service.CartService;
import com.neu.shop.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ShopApplicationTests {

//    @Resource
//    private ProductService productService;
//    @Resource
//    private CartMapper cartMapper;
//    @Resource
//    private CartService cartService;
//    @Test
//    void contextLoads() {
//        System.out.println(cartMapper.selectAllByUserid(1));
//    }
//    @Test
//    void contextLoads1() {
//        System.out.println(productService.getAll());
//    }
//
    @Resource
    private EquipmentMapper equipmentMapper;
    @Resource
    private KnifeMapper knifeMapper;
//    @Test
//    void insertTest() {
//        System.out.println(equipmentMapper.insert(new Equipment("2905748rxes","智能车床","精密工业零件","崭新","产自德国")));
//    }

    @Test
    void Test1() {
        System.out.println(knifeMapper.selectByPrimaryKey("T3405"));
    }

}

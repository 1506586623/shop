package com.neu.shop.service.impl;


import com.neu.shop.entity.Knife;
import com.neu.shop.mapper.KnifeMapper;
import com.neu.shop.service.KnifeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jiang
 * @description 针对表【knife】的数据库操作Service实现
 * @createDate 2023-02-17 15:23:10
 */
@Service
public class KnifeServiceImpl implements KnifeService {
    @Resource
    private KnifeMapper knifeMapper;


    @Override
    public List<Knife> select(String id) {
        return knifeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Knife> getAll() {
        return knifeMapper.getAll();
    }


}

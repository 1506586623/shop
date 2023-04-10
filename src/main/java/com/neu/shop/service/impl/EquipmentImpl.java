package com.neu.shop.service.impl;

import com.neu.shop.entity.Equipment;
import com.neu.shop.mapper.EquipmentMapper;
import com.neu.shop.service.EquipmentService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

@Service
public class EquipmentImpl implements EquipmentService {
    @Resource
    EquipmentMapper equipmentMapper;
    @Override
    public List<Equipment> getAll() {
        return equipmentMapper.getAll();
    }

    @Override
    public int insert(Equipment equipment) {
        return equipmentMapper.insert(equipment);
    }

    @Override
    public List<Equipment> getById(String id) {
        return equipmentMapper.selectByPrimaryKey(id);
    }


}

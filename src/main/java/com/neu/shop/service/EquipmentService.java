package com.neu.shop.service;

import com.neu.shop.entity.Equipment;

import java.util.List;

public interface EquipmentService {
    List<Equipment> getAll();

    int insert(Equipment equipment);

    List<Equipment> getById(String id);
}

package com.neu.shop.controller;

import com.neu.shop.entity.Equipment;
import com.neu.shop.service.EquipmentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("equipment")
public class EquipmentController {

    @Resource
    EquipmentService equipmentService;

    @GetMapping("/getAll")
    public List<Equipment> getAll() {
        return equipmentService.getAll();
    }

    @PostMapping("/insert")
    public int insert(@RequestBody Equipment equipment) {
        return equipmentService.insert(equipment);
    }

    @GetMapping("/{equipmentNumber}")
    public List<Equipment> getById(@PathVariable String equipmentNumber) {
        return equipmentService.getById(equipmentNumber);
    }

}

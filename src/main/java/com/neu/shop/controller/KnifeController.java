package com.neu.shop.controller;


import com.neu.shop.entity.Knife;
import com.neu.shop.service.KnifeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("knife")
public class KnifeController {
    @Resource
    KnifeService knifeService;

    @GetMapping("/getAll")
    public List<Knife> getAll() {
        return knifeService.getAll();
    }

    @GetMapping("/{knifeNumber}")
    public List<Knife> getById(@PathVariable String knifeNumber) {
        return knifeService.select(knifeNumber);
    }
}

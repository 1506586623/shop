package com.neu.shop.controller;

import com.neu.shop.entity.Equipment;
import com.neu.shop.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("redis")
public class RedisController {

    /**
     * 需要注入redis模板
     * <p>
     * 对于RedisTemplate的泛型情况,
     * 可以使用<String, String>
     * <Object, Object>
     * 或者不写泛型
     * <p>
     * 注意,属性的名称必须为redisTemplate,因为按名称注入,框架创建的对象就是这个名字的
     */
    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private EquipmentService equipmentService;

    /**
     * 注解版本缓存数据
     *
     * @return
     */
    @Cacheable(cacheNames = "gatewayHandler", key = "'getGatewayHandler'")
    @GetMapping("/set/handler/")
    public Object getGatewayHandler() {

        //如果 redis中没有则执行该方法去数据库查询，如果redis中有则无需执行该操作
        return equipmentService.getAll();
    }


    // 添加数据到redis
    @PostMapping("/addstring")
    public String addToRedis(String name, String value) {

        // 操作Redis中的string类型的数据,先获取ValueOperation
        ValueOperations valueOperations = redisTemplate.opsForValue();

        // 添加数据到redis
        valueOperations.set(name, value);
        return "向redis添加string类型的数据";
    }

    // 从redis获取数据
    @GetMapping("/getk")
    public String getData(String key) {

        ValueOperations valueOperations = redisTemplate.opsForValue();
        Object v = valueOperations.get(key);
        return "key是" + key + ",它的值是:" + v;
    }

    @PostMapping("/{k}/{v}")
    public String addStringKV(@PathVariable String k,
                              @PathVariable String v) {

        // 使用StringRedisTemplate对象
        stringRedisTemplate.opsForValue().set(k, v);
        return "使用StringRedisTemplate对象添加";
    }

    @GetMapping("/{k}")
    public String getStringValue(@PathVariable String k) {

        // 获取String类型的value
        String v = stringRedisTemplate.opsForValue().get(k);
        return "从redis中通过" + k + "获取到string类型的v=" + v;
    }

    /**
     * 设置RedisTemplate序列化机制
     * 可以设置 key 的序列化,也可以设置 value 的序列化
     * 也可以同时设置
     */
    @PostMapping("/redis/addstr")
    public String addString(String k, String v) {

        // 设置RedisTemplate的序列化机制
        // 设置key为string类型的序列化
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // 设置value的序列化
        redisTemplate.setValueSerializer(new StringRedisSerializer());

        redisTemplate.opsForValue().set(k, v);
        return "添加了k和v";
    }

    /**
     * 使用json序列化
     */
    @PostMapping("/addjson")
    public String addJson() {

        Equipment equipment = new Equipment("1", "1", "1", "1", "1");

        // 设置key为string的序列化方式
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // 设置value为json的序列化方式,json为Student类型的方式组织,所以需要传入Student.class
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer(Equipment.class));
        redisTemplate.opsForValue().set("myStudent", equipment);
        return "存入json类型的数据student";
    }

    /**
     * 使用json序列化
     */
    @PostMapping("/getjson")
    public String getJson() {
        //设置key为string的序列化方式
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //设置value为json的序列化方式，json为Equipment类型的方式组织，索引需要传入Equipment.class
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer(Equipment.class));
        Object obj = redisTemplate.opsForValue().get("myStudent");
        return "取出" + obj.toString();
    }


}

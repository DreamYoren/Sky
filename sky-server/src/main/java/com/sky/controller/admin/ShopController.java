package com.sky.controller.admin;

import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController("adminShopController")
@RequestMapping
@Slf4j
@Api(tags = "店铺相关接口")
public class ShopController {

    @Autowired
    private RedisTemplate redisTemplate;
    @PutMapping("/{status}")
    public Result setStatus(@PathVariable Integer status){
        log.info("设置店铺的营业状态为:{}",status == 1? "营业中":"打样中");
        redisTemplate.opsForValue().set("shop_status", status);
        return Result.success();
    }

    @GetMapping("/status")
    @ApiOperation("获取店铺的营业状态")
    public Result<Integer> getStatus()
    {
        Integer shopStatus = (Integer) redisTemplate.opsForValue().get("shop_status");
        log.info("获取店铺的营业状态:{}",shopStatus== 1? "营业中":"打样中");
        return Result.success(shopStatus);
    }
}

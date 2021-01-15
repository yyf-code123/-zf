package com.zf.cache;

import com.zf.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisTest {

    @Resource
    UserService userService;

    @Resource
    RedisTemplate redisTemplate;

    @Resource
    StringRedisTemplate stringRedisTemplate;

    /**
     * Redis常见的五大数据类型
     * String(字符串)、List(列表)、Set(集合)、Hash(散列)、ZSet(有序集合)
     * stringRedisTemplate.opsForValue()[String(字符串)]
     * stringRedisTemplate.opsForlist()[List(列表)]
     * stringRedisTemplate.opsForSet()[Set(集合)]
     * stringRedisTemplate.opsForHash()[Hash(散列)]
     * stringRedisTemplate.opsForZSet()[ZSet(有序集合)]
     */
    
    @Test
    public void test(){
     /*   String k1 = stringRedisTemplate.opsForValue().get("k1");
        stringRedisTemplate.opsForValue().set("k10","666");
        System.out.println(k1);*/

        stringRedisTemplate.opsForList().leftPush("myList","棒棒棒");

    }
}

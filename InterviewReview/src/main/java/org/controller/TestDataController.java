package org.controller;

import org.bean.TestDataBean;
import org.dao.TestDataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestDataController {

    @Autowired
    TestDataDao testDataDao;

    @Autowired
    @Qualifier("myStringRedisTemplate")
    private RedisTemplate<Object, Object> redisTemplate;

    @GetMapping("/helloworld")
    public String getHelloworld() {
        return "hello world!";
    }

    @GetMapping("/addTestData")
    public int addTestData(){
        TestDataBean testDataBean = new TestDataBean(0,"test0",0, "sjdfkljalksdjf");
        int i = testDataDao.addTestData(testDataBean);
        System.out.println(i);
        return i;
    }

    @GetMapping("/redisTest")
    public String redisTest() {
        redisTemplate.opsForValue().set("school", "小学");
        Object school = redisTemplate.opsForValue().get("school");
        System.out.println(school);
        return (String) school;
    }

}

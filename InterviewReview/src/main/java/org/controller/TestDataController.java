package org.controller;

import org.bean.TestDataBean;
import org.dao.TestDataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Action;

@RestController
public class TestDataController {

    @Autowired
    TestDataDao testDataDao;

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

}

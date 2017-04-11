package code.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author knight
 * @createtime : 2017/04/11 23:07
 * @description : controller例子
 * @result :
 */
@Controller
public class StudentController {
    @RequestMapping("/StudentController/hello")
    public String hello(){
        System.out.println("hello world!");
        return "hello";
    }
}

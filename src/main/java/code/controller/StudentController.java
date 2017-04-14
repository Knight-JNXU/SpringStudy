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
    
    /**
     * 基本的controller测试
     * @return
     */
    @RequestMapping("/StudentController/hello")
    public String hello(){
        System.out.println("hello world!");
        return "hello";
    }
    
    /**
     * 跑出异常的controller测试
     * 这个会直接使用
     * @return
     * @throws Exception
     */
    @RequestMapping("/StudentController/throwException")
    public String throwException() throws Exception{
        throw new Exception("test throw exception!");
    }
}

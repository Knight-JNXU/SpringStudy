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
public class MenuController extends BaseController{
    
    /**
     * 基本的controller测试
     * @return
     */
    @RequestMapping("/menuController/go")
    public String goMenu(){
        return "menu";
    }
    
    /**
     * 跑出异常的controller测试
     * 这个会直接使用
     * @return
     * @throws Exception
     */
    @RequestMapping("/menuController/throwException")
    public String throwException() throws Exception{
        throw new Exception("test throw exception!");
    }
}

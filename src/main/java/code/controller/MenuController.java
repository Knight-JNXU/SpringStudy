package code.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        return "menu/menupage";
    }
    /**
     * 基本的controller测试
     * @return
     */
    @RequestMapping("/menuController/hello")
    public String hello(){
        return "hello";
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
    
    /**
     * 改变model
     * @param model
     * @return
     */
    @RequestMapping("/menuController/changeModel")
    public String changeModel(Model model){
        addModelValue(model);
        return "changeModel";
    }
    
    /**
     * 往model中添加值
     * @param model
     */
    private void addModelValue(Model model){
        model.addAttribute("isChangeFlag", true);
    }
    
}

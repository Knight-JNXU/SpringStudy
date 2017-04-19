package code.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

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

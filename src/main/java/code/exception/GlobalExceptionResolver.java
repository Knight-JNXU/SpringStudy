package code.exception;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import code.dto.BaseResult;

/**
 * 
 * @author knight
 * @description:全局异常处理
 */

@Component
public class GlobalExceptionResolver implements HandlerExceptionResolver{
    
    
    /** The Constant log. */
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionResolver.class);
    
    @ResponseBody
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        LOGGER.error("exception url:" + request.getRequestURI() + " , exception message:" + ex.getMessage());
        //这里有2种选择
        //跳转到定制化的错误页面
        /*ModelAndView error = new ModelAndView("error");
        error.addObject("exMsg", ex.getMessage());
        error.addObject("exType", ex.getClass().getSimpleName().replace("\"", "'"));*/
        //返回json格式的错误信息
        try {
            PrintWriter writer = response.getWriter();
            BaseResult<String> result=new BaseResult(false, ex.getMessage());
            writer.write(JSON.toJSONString(result));
            writer.flush();
        } catch (Exception e) {
            LOGGER.error("Exception:",e);
        }
        return null;
    }
    
}

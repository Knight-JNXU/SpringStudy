package code.ExceptionHander;

import code.model.BaseExcption;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Knight_JXNU on 2016/9/26.
 */
//注意要让这个 resolver 实例化
@Component
public class GlobalHandlerExceptionResolver implements HandlerExceptionResolver {
    public static final String DEFAULT_ERROR_VIEW = "error";

    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        System.out.println("GlobalHandlerExceptionResolver");
        if(e instanceof BaseExcption){
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("exception", e);
            modelAndView.setViewName(DEFAULT_ERROR_VIEW);
            return modelAndView;
        }
        return null;
    }
}

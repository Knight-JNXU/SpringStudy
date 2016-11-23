package code.Handler;

import code.model.BaseException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Knight_JXNU on 2016/9/26.
 */
@ControllerAdvice
public class GlobalExceptionHandler{
    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = BaseException.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request, BaseException baseException) throws Exception{
        ModelAndView mav  = new ModelAndView();
        mav.addObject("exception", baseException);
        mav.addObject("url", request.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);  //设置跳转的 views 页面
        System.out.println("GlobalExceptionHandler");
        return mav;
    }
}

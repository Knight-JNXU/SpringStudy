package code.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import code.service.MenuService;

/**
 * @author liuwen
 * @version 1.0
 * @date 2018年6月5日
 */
public class MenuClassImpl extends BaseServiceImpl implements MenuService{
    
    /**
     * 使用RequestContextHolder获取请求参数
     * @return
     */
    public String getUrlParam() {
        //两个方法在没有使用JSF的项目中是没有区别的
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
//      RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
        String param = request.getAttribute("param").toString();
        return param;
    }
    
}

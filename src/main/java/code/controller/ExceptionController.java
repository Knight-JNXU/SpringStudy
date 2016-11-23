package code.controller;

import code.model.BaseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Knight_JXNU on 2016/9/26.
 */
@Controller
@RequestMapping(value = "/exceptionController")
public class ExceptionController extends BaseController {

    @RequestMapping(value = "/throwException")
    public void throwException() throws BaseException{
        throw new BaseException("throw exception!");
    }

}

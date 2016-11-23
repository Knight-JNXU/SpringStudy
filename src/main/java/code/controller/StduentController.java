package code.controller;

import code.Exception.AdviceLog;
import code.Exception.BusinessException;
import code.Exception.ErrorCode;
import code.model.StudentModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Knight_JXNU on 2016/9/27.
 */
@Controller
@RequestMapping(value = "/student")
public class StduentController extends BaseController {

    @AdviceLog(description = "/student/add")
    @RequestMapping(value = "/add")
    public String add(StudentModel student) throws Exception{
        return "result";
    }

    @ResponseBody
    @RequestMapping(value = "/exception")
    public void exception() throws Exception{
        throw new BusinessException("student exception", ErrorCode.ConnectException.code);
    }

}

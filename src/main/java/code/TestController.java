package code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Knight_JXNU on 2017/1/5.
 */
@Controller
@RequestMapping(value = "/con")
public class TestController {
    @Autowired
    Test2 test2;
    @ResponseBody
    @RequestMapping(value = "/print")
    public void pri(){
        System.out.println("s4:"+test2.getS4());
    }
}

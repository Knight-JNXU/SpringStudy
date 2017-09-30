package controller;

import model.CouponModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by hasee on 2017/9/30.
 */
@Controller
public class CouponController extends BaseController {

    @ResponseBody
    @RequestMapping(value = "couponPost")
    public String couponPost(CouponModel couponModel){
        return couponModel.getCode();
    }

}

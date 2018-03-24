package code.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import code.dto.BaseResult;
import code.service.AccountService;

/**
 * @author knightjxnu
 * @version 1.0
 * @date 2018年2月19日
 * @function :
 */
@Controller
@RequestMapping(value = "/account")
public class AccountController extends BaseController{
    
    @Autowired
    private AccountService accountService;
    
    @RequestMapping(value = "/goRegister",method = RequestMethod.GET)
    public String goRegister(HttpServletRequest request,HttpServletResponse response,Model model) {
        return "account/register";
    }

    @ResponseBody
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public BaseResult<String> register(@RequestParam String userName,@RequestParam String userPwd,HttpServletRequest request,HttpServletResponse response,Model model){
        BaseResult<String> result = accountService.saveAccount(userName, userPwd);
        return result;
    }

}

package code.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import code.service.JokeService;

/**
 * @author knightjxnu
 * @version 1.0
 * @date 2018年1月11日
 * @function : 
 */
@Controller
public class JokeController extends BaseController{
    
    @Autowired
    private JokeService jokeService;
    
    @ResponseBody
    @RequestMapping("/joke/list.json")
    public String getJokeListJson(@RequestParam(value="page", required=false, defaultValue="1") String page, HttpServletRequest request, HttpServletResponse response, Model model){
        return jokeService.getJokesByPage(page);
    }
}

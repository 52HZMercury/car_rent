package com.carRent4_0.controller;

import com.carRent4_0.pojo.User;
import com.carRent4_0.service.UserService;
import com.carRent4_0.service.moneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @program: carRent4_0
 * @description:
 * @author: Mr.Like
 * @create: 2021-10-27 10:19
 **/

@Controller
public class loginController {

    @Autowired
    private UserService userService;

    @Autowired
    private moneyService moneyService;


    @RequestMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session){

        User loginuser = userService.doLogin(username,password);
        session.setAttribute("loginuser",loginuser);

        if(loginuser == null){
            model.addAttribute("msg","用户名或密码错误");
            return "login";
        } else if(loginuser.getType()==0){

            session.setAttribute("loginusername",username);
            session.setAttribute("loginuserId",loginuser.getId());
            return "redirect:/index.html";

        }else if(loginuser.getType()==1){//管理员

            session.setAttribute("totalsalemoney",moneyService.getmoney().getMoney());
            session.setAttribute("loginusername",username);
            session.setAttribute("loginuserId",loginuser.getId());

            return "redirect:/admin.html";
        }
          return "login";
    }


    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();//注销session
        return "redirect:index.html";
    }


}



package com.carRent4_0.controller;

import com.carRent4_0.pojo.User;
import com.carRent4_0.service.UserService;
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
 * @create: 2021-10-28 15:30
 **/
@Controller
public class registerController {

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String register(@RequestParam("id") String id,@RequestParam("username") String username, @RequestParam("password") String password, Model model){
        User reuser = new User();
        reuser.setId(id);
        reuser.setName(username);
        reuser.setPassword(password);
        reuser.setType(0);
        Boolean isdoreg = userService.isdoreg(username);
        if(isdoreg){
            Boolean doreg = userService.doreg(reuser);
            model.addAttribute("rmsg","注册成功");
            return "index";
        }else{
            model.addAttribute("rmsg","该用户已注册！");
            return "register";
        }
    }
}

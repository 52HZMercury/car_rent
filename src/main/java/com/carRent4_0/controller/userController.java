package com.carRent4_0.controller;


import com.carRent4_0.pojo.Bus;
import com.carRent4_0.pojo.User;
import com.carRent4_0.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;


/**
 * @program: carRent4_0
 * @description:
 * @author: Mr.Like
 * @create: 2021-10-28 16:42
 **/
@Controller
public class userController {


    @Autowired
    private UserService userService;

    @RequestMapping("/change")
    public String change(@RequestParam("username") String username, @RequestParam("password") String password, Model model,HttpSession session){


        User chuser = new User();
        chuser.setId((String)session.getAttribute("loginuserId"));
        chuser.setName(username);
        chuser.setPassword(password);

        Boolean dochange = userService.dochange(chuser);

        if(dochange) {
            session.setAttribute("loginusername",username);
            model.addAttribute("cmsg", "更改成功");
            System.out.println(chuser);
            return "index";
        }else{
            model.addAttribute("cmsg", "更改失败");
            return "index";
    }
   }

    @RequestMapping("/admin/userdashboard.html")
    public String  getAllrentVehicle(Model model){
        model.addAttribute("Allusers",userService.getAllUsers());
        return "userdashboard";
    }

    @RequestMapping("/admin/userdelete/{id}")
    public String deleteuser(@PathVariable("id") String id){
        userService.deleteUser(id);
        return "redirect:/admin/userdashboard.html";
    }

    /**
     * @Description: 用户的信息更新
     * @Param:
     * @return:
     */

    @RequestMapping("/admin/userUpdate/{id}")
    public String updateuser(@PathVariable("id") String id, Model model, HttpSession session){
        User updateuser =  userService.getUser(id);
        model.addAttribute("updateUser",updateuser);
        session.setAttribute("updateuserId",updateuser.getId());
        return "userUpdate";
    }

    @RequestMapping("/admin/userUpdate")
    public String updateuser(String name ,String password ,int type,HttpSession session){
        User updateuser = new User((String) session.getAttribute("updateuserId"),name,password,type);
        userService.updateUser(updateuser);
        return "redirect:/admin/userdashboard.html";
    }


}

package com.example.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.po.Bucket;
import com.example.service.IBucketService;
import com.example.service.IUserService;
import com.example.po.User;
//import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Controller
public class UserController {
    private static final Log logger = LogFactory.getLog(UserController.class);
    @Autowired
    @Qualifier("userServ")
    private IUserService userServ;




    @RequestMapping("/login")
    public String login(@RequestParam("username") String username ,@RequestParam("password")String password, Model model) {
        User user=userServ.login(username);
        if (user!=null && user.getUser_password().equals(password)) {

            model.addAttribute("user_id",user.getUser_id());
            model.addAttribute("user_name", user.getUser_name());
            model.addAttribute("user_password",user.getUser_password());
            model.addAttribute("user_permission",user.getUser_permission());

            return "xuanze";

        }
        else {
            model.addAttribute("error", "账号或密码错误！");

            return "login";
        }
    }

    @RequestMapping("/register")
    public String register(@RequestParam("username") String username ,@RequestParam("password")String password,@RequestParam("password2")String password2,Model model) {

        if(!password.equals(password2)){
            model.addAttribute("error", "两次输入的密码不一致！");
            return "register";
        }

        if (userServ.register(username, password)) {

            return "login";
        }
        else
        {
            model.addAttribute("error", "用户名已存在！");
            return "register";
        }
    }

}

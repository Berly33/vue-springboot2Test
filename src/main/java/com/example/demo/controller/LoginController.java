package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Controller
@RequestMapping()
public class LoginController {

    @Autowired
    private LoginService loginService;
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login() {
        return "user/login";
    }

    @RequestMapping(value="/checkLogin",method= RequestMethod.GET)
    @ResponseBody
    public String checkLogin(UserEntity u, HttpServletRequest request ) {
        UserEntity user = loginService.login(u);
        if (null != user) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            if (user.getType() == 1) {
                return "detail";
            } else if (user.getType()==0){
                return "teacher";
            }
            else {
                return  "login";
            }
        } else {
            return "login";
        }
    }








//@RequestMapping(value="/checkLogin",method= RequestMethod.GET)
////@ResponseBody
//public String checkLogin(UserEntity u, HttpServletRequest request) {
//    UserEntity user = loginService.login(u);
//    if(null != user) {
//        HttpSession session = request.getSession();
//        session.setAttribute("user", user);
//       if (user.getUsername()==""||user.getPassword()==""){
//            return ""
//       }
//    }else {
//        return false;
//    }
//}


}
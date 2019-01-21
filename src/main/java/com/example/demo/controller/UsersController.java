package com.example.demo.controller;


import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import javax.security.auth.Subject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping()
public class UsersController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    @ResponseBody
    public List<UserEntity> testQuery(int id) {
        return userService.selectUserByName(id);
    }

    @RequestMapping(value ="/insert",method = RequestMethod.GET)
    public String testInsert(int id,String username,String password,int age,String address,int type) {
        userService.insertService(id, username ,password, age,address,type);
        //return userService.selectAllUser();
        return "user/delete";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @ResponseBody
    public String update(int id,String username,String password,int age,String address,int type) {
       userService.Update(id, username , password,age,address,type);
//        if (result >= 1) {
//            return "修改成功";
//        } else {
//            return "修改失败";
//        }
        return "修改成功";
    }




//    @RequestMapping("/delete")
@RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String testDelete(int id) {
        userService.deleteService(id);
        return "user/delete";
    }



    @RequestMapping(value = "teacher",method = RequestMethod.GET)
    public String teacher() {
        return "user/teacher";
    }
    @RequestMapping(value = "getAll",method = RequestMethod.GET)
    public String getAll() {
        return "user/list";
    }
        @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public String detail() {
        return "user/detail";
    }

    @RequestMapping(value = "/getDetail",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getDetail() {
        Map<String,Object> result=new HashMap<>();
        List<UserEntity> list = userService.getAll();
        result.put("success",true);
        result.put("users",list);
        return result;

    }

//    @RequestMapping("/login")
//    public String login(){
////        @RequestParam(value="username",required = false)String username,
////        @RequestParam(value="password",required = false)String password,
////                Model model) {
////            System.out.println("username"+username+",password"+password);
////            //初始化
////            Subject subject= SecurityUtil.getSubject();
////            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
////            try{
////
////                subject.login(token);
////                System.out.println("用户是否登录"+subject.isAuthenticated());
////                return "user/detail";
////            }catch (AuthenticationException e){
////
////                e.printStackTrace();
////                model.addAttribute("error","用户登录失败，错误信息："+e.getMessage());
////                return "login";
////            }
//
//        return "user/login";
//        }


    @RequestMapping("/index")
    public String index() {
        return "123";
    }
}






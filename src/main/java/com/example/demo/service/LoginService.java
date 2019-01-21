package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import com.example.demo.mapper.LoginMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class LoginService {
    @Resource
    private LoginMapper loginMapper;


    public UserEntity login(UserEntity u) {
//        UserEntity user_entity = loginMapper.checkUserInfo(u);
//        return user_entity;
        return loginMapper.checkUserInfo(u);

    }




}

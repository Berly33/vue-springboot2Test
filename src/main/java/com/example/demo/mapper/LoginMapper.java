package com.example.demo.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LoginMapper extends BaseMapper<UserEntity> {

    @Select("select id,username,password,address,age,type from user_entity\n" +
            "    where username=#{username} and password=#{password}and type=#{type}")
//
//    List<UserEntity> checkUserInfo(@Param("username") String username,@Param("password") String password);

    UserEntity checkUserInfo(UserEntity u);
}

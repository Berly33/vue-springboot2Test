package com.example.demo.mapper;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.UserEntity;
import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

    /**
     * 通过名字查询用户信息
     */
    @Select("SELECT * FROM user_entity WHERE id = #{id}")
    List<UserEntity> findUserByName(@Param("id") int id);

//    /**
//     * 查询所有用户信息
//     */
//    @Select("SELECT * FROM user_entity")
//    List<UserEntity> findAllUser();

    /**
     * 插入用户信息
     */
    @Insert("INSERT INTO user_entity(id, username,password,age,address,type) VALUES(#{id}, #{username},#{password},#{age}, #{address}, #{type})")
    void insertUser(@Param("id") int id, @Param("username") String username,@Param("password") String password,@Param("age") int age, @Param("address") String address,@Param("type") int type);

    /**
     * 根据 id 更新用户信息
     */
    @Update("UPDATE  user_entity SET id = #{id},username = #{username},password = #{password},age=#{age},address= #{address},type=#{type} WHERE id = #{id}")
    void updateUser(@Param("id") int id, @Param("username") String username,@Param("password") String password,@Param("age") int age, @Param("address") String address,@Param("type") int type);

    /**
     * 根据 id 删除用户信息
     */
    @Delete("DELETE from user_entity WHERE id = #{id}")
    void deleteUser(@Param("id") int id);

   // List<UserEntity> selectList(QueryWrapper<Object> id);


    //List<UserEntity> getAll();

//    UserEntity getOne(Integer id);
//
//    int insert(UserEntity user);
//
//    int update(UserEntity user);
//
//    int delete(Integer id);
}


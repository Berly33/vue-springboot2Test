package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.UserEntity;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
;import java.util.List;


@Service
    public class UserService {
        @Resource
        private UserMapper userMapper;

        /**
         * 根据名字查找用户
         */
        public List<UserEntity> selectUserByName(int id) {
            return userMapper.findUserByName(id);
        }

//        /**
//         * 查找所有用户
//         */
//        public List<User> selectAllUser() {
//            return userMapper.findAllUser();
//        }

        /**
         * 插入两个用户
         */
        public void insertService(int id,String username,String password,int age,String address,int type) {
            userMapper.insertUser(id, username ,password, age,address,type);
        }

        /**
         * 根据id 修改用户
         */

        public void Update(int id,String username,String password,int age,String address,int type){
            userMapper.updateUser(id, username ,password, age,address,type);
        }

        /**
         * 根据id 删除用户
         */

        public void deleteService(int id) {

            userMapper.deleteUser(id);
        }


        public List<UserEntity> getAll() {

            return userMapper.selectList(new QueryWrapper<>());
        }


        public List<UserEntity> getDetail() {
            return userMapper.selectList(new QueryWrapper<>());

        }

        public List<UserEntity> selectAllUser() {

            return userMapper.selectList(new QueryWrapper<>());
        }
    }



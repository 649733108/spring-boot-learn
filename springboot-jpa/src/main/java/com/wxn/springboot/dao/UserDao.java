package com.wxn.springboot.dao;
/*
 * Created by wxn
 * 2018/12/15 18:56
 */


import com.wxn.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

//继承JpaRepository来完成对数据库的操作
public interface UserDao extends JpaRepository<User,Integer> {
}

package com.learn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.learn.domain.User;

@Mapper
public interface UserMapper {
    List<User> findAll();
    List<User> findById();
}

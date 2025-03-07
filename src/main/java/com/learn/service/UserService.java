package com.learn.service;

import com.learn.domain.User;
import com.learn.mapper.UserMapper;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class UserService {
	//Mapper Interface 선언 (new 대용)
	private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<User> getAllUsers() {
    	List<User> result = null;
    	log.info("getAllUsers(호출)");
        result = userMapper.findAll();
        log.debug("Fetched user:{}",result);
        log.info("서비스완료");
        return result;
    }
	
	
}

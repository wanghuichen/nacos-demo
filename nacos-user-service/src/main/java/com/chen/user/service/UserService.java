package com.chen.user.service;

import com.chen.user.entiy.User;
import com.chen.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author whc
 * @date 2022/7/12 22:24
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findById(Long id) {
        return userMapper.findById(id);
    }
}

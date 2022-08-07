package com.chen.user.controller;

import com.chen.user.entiy.User;
import com.chen.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author whc
 * @date 2022/7/12 22:25
 */
@Slf4j
@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    public User findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }
}

package com.chen.feign.clients;

import com.chen.feign.entiy.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author whc
 * @date 2022/7/12 22:34
 */
@FeignClient("userService")
public interface UserClient {

    @GetMapping("/user/{id}")
    User findById(@PathVariable("id") Long id);
}

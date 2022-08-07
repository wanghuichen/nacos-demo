package com.chen.order;

import com.chen.feign.clients.UserClient;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author whc
 * @date 2022/7/12 22:37
 */
@EnableFeignClients(clients = UserClient.class)
@SpringBootApplication
@MapperScan("com.chen.order.mapper")
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}

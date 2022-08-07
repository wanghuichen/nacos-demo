package com.chen.order.service;

import com.chen.feign.clients.UserClient;
import com.chen.feign.entiy.User;
import com.chen.order.entiy.Order;
import com.chen.order.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author whc
 * @date 2022/7/12 22:34
 */
@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserClient userClient;

    public Order queryOrderById(Long orderId) {
        //1. 查询订单
        Order order = orderMapper.findById(orderId);
        //2. 查询用户
        User user = userClient.findById(order.getUserId());
        order.setUser(user);
        return order;
    }
}

package com.chen.order.entiy;

import com.chen.feign.entiy.User;
import lombok.Data;

/**
 * @author whc
 * @date 2022/7/12 22:33
 */
@Data
public class Order {
    private Long id;
    private Long price;
    private String name;
    private Integer num;
    private Long userId;
    private User user;
}

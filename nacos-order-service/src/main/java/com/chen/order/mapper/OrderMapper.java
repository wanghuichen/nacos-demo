package com.chen.order.mapper;

import com.chen.order.entiy.Order;
import org.apache.ibatis.annotations.Select;

/**
 * @author whc
 * @date 2022/7/12 22:33
 */
public interface OrderMapper {

    @Select("select * from tb_order where id = #{id}")
    Order findById(Long id);
}

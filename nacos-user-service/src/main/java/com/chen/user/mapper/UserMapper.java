package com.chen.user.mapper;

import com.chen.user.entiy.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author whc
 * @date 2022/7/12 22:23
 */
public interface UserMapper {

    @Select("select * from tb_user where id = #{id}")
    User findById(@Param("id") Long id);
}

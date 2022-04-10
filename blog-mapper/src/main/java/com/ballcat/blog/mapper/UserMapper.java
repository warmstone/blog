package com.ballcat.blog.mapper;

import com.ballcat.blog.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author pengshun
 * @date 2022-04-10 22:06
 * @description
 */
@Mapper
public interface UserMapper {

    User getByUsername(String username);

}

package com.ballcat.blog.service;

import com.ballcat.blog.common.exception.BizException;
import com.ballcat.blog.dto.UserDTO;
import com.ballcat.blog.entity.User;

/**
 * @author pengshun
 * @date 2022-04-10 22:13
 * @description
 */
public interface UserService {

    String login(UserDTO userDTO) throws BizException;
}

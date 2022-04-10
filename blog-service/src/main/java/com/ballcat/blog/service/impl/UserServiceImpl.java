package com.ballcat.blog.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.SecureUtil;
import com.ballcat.blog.common.exception.BizException;
import com.ballcat.blog.common.response.RetCode;
import com.ballcat.blog.common.util.JWTUtil;
import com.ballcat.blog.dto.UserDTO;
import com.ballcat.blog.entity.User;
import com.ballcat.blog.mapper.UserMapper;
import com.ballcat.blog.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author pengshun
 * @date 2022-04-10 22:14
 * @description
 */
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Override
    public String login(UserDTO userDTO) throws BizException {
        // TODO 增加验证码校验
        User user = userMapper.getByUsername(userDTO.getUsername());
        if (ObjectUtil.isNotNull(user)) {
            String secret = user.getSecret();
            // MD5加密
            String encryptPassword = SecureUtil.md5(userDTO.getPassword() + secret);
            if (ObjectUtil.equal(encryptPassword, user.getPassword())) {
                return JWTUtil.generateToken(userDTO.getUsername());
            }
        }
        throw new BizException(RetCode.LOGIN_FAILED);
    }
}

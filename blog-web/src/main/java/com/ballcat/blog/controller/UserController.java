package com.ballcat.blog.controller;

import com.ballcat.blog.common.exception.BizException;
import com.ballcat.blog.common.response.CommonResult;
import com.ballcat.blog.dto.UserDTO;
import com.ballcat.blog.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pengshun
 * @date 2022-04-10 22:27
 * @description
 */
@RestController
@AllArgsConstructor
@RequestMapping(value = "/admin")
public class UserController {

    private final UserService userService;

    @PostMapping(value = "/login")
    public CommonResult<String> login(@RequestBody UserDTO userDTO) throws BizException {
        return CommonResult.ok(userService.login(userDTO));
    }
}

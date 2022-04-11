package com.ballcat.blog.controller.admin;

import com.ballcat.blog.common.exception.BizException;
import com.ballcat.blog.common.response.CommonResult;
import com.ballcat.blog.dto.UserDTO;
import com.ballcat.blog.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "后台管理>>登录控制器")
public class LoginController {

    private final UserService userService;

    @PostMapping(value = "/login")
    @ApiOperation(value = "登录", httpMethod = "POST")
    public CommonResult<String> login(@RequestBody UserDTO userDTO) throws BizException {
        return CommonResult.ok(userService.login(userDTO));
    }
}
